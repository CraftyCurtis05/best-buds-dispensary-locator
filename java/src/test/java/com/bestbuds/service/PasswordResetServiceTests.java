package com.bestbuds.service;

import com.bestbuds.dao.PasswordResetTokenDao;
import com.bestbuds.dao.UserDao;
import com.bestbuds.model.User;
import com.bestbuds.model.PasswordResetToken;
import com.bestbuds.model.ResetPasswordDto;
import com.bestbuds.exception.InvalidPasswordResetTokenException;
import com.bestbuds.exception.RegistrationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

public class PasswordResetServiceTests {

    private UserDao userDao;
    private PasswordResetTokenDao passwordResetTokenDao;
    private EmailService emailService;
    private PasswordResetService sut;

    @BeforeEach
    public void setup() {

        userDao =
                mock(
                        UserDao.class
                );

        passwordResetTokenDao =
                mock(
                        PasswordResetTokenDao.class
                );

        emailService =
                mock(
                        EmailService.class
                );                

        sut =
                new PasswordResetService(
                        userDao,
                        passwordResetTokenDao,
                        emailService
                );
    }

    @Test
    public void createResetToken_with_existing_email_creates_hashed_token() {

        User user =
                new User();

        user.setId(
                1
        );

        user.setEmail(
                "user1@bestbuds.local"
        );

        when(
                userDao.getUserByEmail(
                        "user1@bestbuds.local"
                )
        ).thenReturn(
                user
        );

        String token =
                sut.createResetToken(
                        "user1@bestbuds.local"
                );

        verify(emailService).sendPasswordResetEmail(
                "user1@bestbuds.local",
                token
        );        

        assertNotNull(
                token
        );

        ArgumentCaptor<String> tokenHashCaptor =
                ArgumentCaptor.forClass(
                        String.class
                );

        ArgumentCaptor<LocalDateTime> expiresAtCaptor =
                ArgumentCaptor.forClass(
                        LocalDateTime.class
                );

        verify(passwordResetTokenDao).createToken(
                eq(1),
                tokenHashCaptor.capture(),
                expiresAtCaptor.capture()
        );

        String storedTokenHash =
                tokenHashCaptor.getValue();

        assertNotNull(
                storedTokenHash
        );

        assertEquals(
                64,
                storedTokenHash.length()
        );

        assertNotEquals(
                token,
                storedTokenHash
        );

        assertNotNull(
                expiresAtCaptor.getValue()
        );
    }

    @Test
    public void createResetToken_with_unknown_email_does_not_create_token() {

        when(
                userDao.getUserByEmail(
                        "missing@bestbuds.local"
                )
        ).thenReturn(
                null
        );

        String token =
                sut.createResetToken(
                        "missing@bestbuds.local"
                );

        assertNull(
                token
        );

        verify(
                passwordResetTokenDao,
                never()
        ).createToken(
                anyInt(),
                anyString(),
                any(LocalDateTime.class)
        );

        verify(
                emailService,
                never()
        ).sendPasswordResetEmail(
                anyString(),
                anyString()
        );
    }

    @Test
    public void resetPassword_with_valid_token_updates_password_and_marks_token_used() {

        ResetPasswordDto resetPassword =
                createResetPasswordDto(
                        "valid-token",
                        "newPassword123",
                        "newPassword123"
                );

        PasswordResetToken storedToken =
                createPasswordResetToken(
                        10,
                        1,
                        false,
                        LocalDateTime.now()
                                .plusMinutes(
                                        30
                                )
                );

        when(
                passwordResetTokenDao.getTokenByHash(
                        anyString()
                )
        ).thenReturn(
                storedToken
        );

        sut.resetPassword(
                resetPassword
        );

        verify(userDao).updatePassword(
                1,
                "newPassword123"
        );

        verify(passwordResetTokenDao).markTokenAsUsed(
                10
        );
    }

    @Test
    public void resetPassword_with_mismatched_passwords_throws_exception() {

        ResetPasswordDto resetPassword =
                createResetPasswordDto(
                        "valid-token",
                        "newPassword123",
                        "differentPassword123"
                );

        assertThrows(
                RegistrationException.class,
                () -> sut.resetPassword(
                        resetPassword
                )
        );

        verify(
                passwordResetTokenDao,
                never()
        ).getTokenByHash(
                anyString()
        );

        verify(
                userDao,
                never()
        ).updatePassword(
                anyInt(),
                anyString()
        );
    }

    @Test
    public void resetPassword_with_missing_token_throws_exception() {

        ResetPasswordDto resetPassword =
                createResetPasswordDto(
                        "missing-token",
                        "newPassword123",
                        "newPassword123"
                );

        when(
                passwordResetTokenDao.getTokenByHash(
                        anyString()
                )
        ).thenReturn(
                null
        );

        assertThrows(
                InvalidPasswordResetTokenException.class,
                () -> sut.resetPassword(
                        resetPassword
                )
        );

        verify(
                userDao,
                never()
        ).updatePassword(
                anyInt(),
                anyString()
        );
    }

    @Test
    public void resetPassword_with_used_token_throws_exception() {

        ResetPasswordDto resetPassword =
                createResetPasswordDto(
                        "used-token",
                        "newPassword123",
                        "newPassword123"
                );

        PasswordResetToken storedToken =
                createPasswordResetToken(
                        10,
                        1,
                        true,
                        LocalDateTime.now()
                                .plusMinutes(
                                        30
                                )
                );

        when(
                passwordResetTokenDao.getTokenByHash(
                        anyString()
                )
        ).thenReturn(
                storedToken
        );

        assertThrows(
                InvalidPasswordResetTokenException.class,
                () -> sut.resetPassword(
                        resetPassword
                )
        );

        verify(
                userDao,
                never()
        ).updatePassword(
                anyInt(),
                anyString()
        );

        verify(
                passwordResetTokenDao,
                never()
        ).markTokenAsUsed(
                anyInt()
        );
    }

    @Test
    public void resetPassword_with_expired_token_throws_exception() {

        ResetPasswordDto resetPassword =
                createResetPasswordDto(
                        "expired-token",
                        "newPassword123",
                        "newPassword123"
                );

        PasswordResetToken storedToken =
                createPasswordResetToken(
                        10,
                        1,
                        false,
                        LocalDateTime.now()
                                .minusMinutes(
                                        1
                                )
                );

        when(
                passwordResetTokenDao.getTokenByHash(
                        anyString()
                )
        ).thenReturn(
                storedToken
        );

        assertThrows(
                InvalidPasswordResetTokenException.class,
                () -> sut.resetPassword(
                        resetPassword
                )
        );

        verify(
                userDao,
                never()
        ).updatePassword(
                anyInt(),
                anyString()
        );

        verify(
                passwordResetTokenDao,
                never()
        ).markTokenAsUsed(
                anyInt()
        );
    }

    private ResetPasswordDto createResetPasswordDto(
            String token,
            String newPassword,
            String confirmPassword
    ) {

        ResetPasswordDto resetPassword =
                new ResetPasswordDto();

        resetPassword.setToken(
                token
        );

        resetPassword.setNewPassword(
                newPassword
        );

        resetPassword.setConfirmPassword(
                confirmPassword
        );

        return resetPassword;
    }

    private PasswordResetToken createPasswordResetToken(
            int tokenId,
            int userId,
            boolean used,
            LocalDateTime expiresAt
    ) {

        PasswordResetToken token =
                new PasswordResetToken();

        token.setId(
                tokenId
        );

        token.setUserId(
                userId
        );

        token.setTokenHash(
                "stored-token-hash"
        );

        token.setExpiresAt(
                expiresAt
        );

        token.setUsed(
                used
        );

        return token;
    }
}