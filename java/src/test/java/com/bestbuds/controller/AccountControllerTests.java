package com.bestbuds.controller;

import com.bestbuds.model.AccountDto;
import com.bestbuds.model.User;
import com.bestbuds.model.UpdateEmailDto;
import com.bestbuds.model.UpdateUsernameDto;
import com.bestbuds.model.UpdateUsernameResponseDto;
import com.bestbuds.model.UpdatePasswordDto;
import com.bestbuds.service.AuthenticationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountControllerTests {

    private AuthenticationService authenticationService;
    private Authentication authentication;
    private AccountController sut;

    @BeforeEach
    public void setup() {

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new AccountController(
                        authenticationService
                );
    }

    @Test
    public void getAccount_returns_account_for_authenticated_user() {

        User user =
                new User();

        user.setUsername(
                "user1"
        );

        user.setEmail(
                "user1@bestbuds.local"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        AccountDto account =
                sut.getAccount(
                        authentication
                );

        assertEquals(
                "user1",
                account.getUsername()
        );

        assertEquals(
                "user1@bestbuds.local",
                account.getEmail()
        );

        verify(authenticationService).getUser(
                "user1"
        );
    }

    @Test
    public void updateEmail_returns_updated_account() {

        UpdateEmailDto updateEmail =
                new UpdateEmailDto();

        updateEmail.setEmail(
                "updated@bestbuds.local"
        );

        updateEmail.setCurrentPassword(
                "password123"
        );

        User updatedUser =
                new User();

        updatedUser.setUsername(
                "user1"
        );

        updatedUser.setEmail(
                "updated@bestbuds.local"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(
                authenticationService.updateEmail(
                        "user1",
                        updateEmail
                )
        ).thenReturn(
                updatedUser
        );

        AccountDto account =
                sut.updateEmail(
                        authentication,
                        updateEmail
                );

        assertEquals(
                "user1",
                account.getUsername()
        );

        assertEquals(
                "updated@bestbuds.local",
                account.getEmail()
        );

        verify(authenticationService).updateEmail(
                "user1",
                updateEmail
        );
    }

    @Test
    public void updateUsername_with_changed_username_requires_reauthentication() {

        UpdateUsernameDto updateUsername =
                new UpdateUsernameDto();

        updateUsername.setUsername(
                "updateduser"
        );

        updateUsername.setCurrentPassword(
                "password123"
        );

        User updatedUser =
                new User();

        updatedUser.setUsername(
                "updateduser"
        );

        updatedUser.setEmail(
                "user1@bestbuds.local"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(
                authenticationService.updateUsername(
                        "user1",
                        updateUsername
                )
        ).thenReturn(
                updatedUser
        );

        UpdateUsernameResponseDto response =
                sut.updateUsername(
                        authentication,
                        updateUsername
                );

        assertEquals(
                "updateduser",
                response.getUsername()
        );

        assertEquals(
                "user1@bestbuds.local",
                response.getEmail()
        );

        assertTrue(
                response.isReauthenticationRequired()
        );

        verify(authenticationService).updateUsername(
                "user1",
                updateUsername
        );
    }

    @Test
    public void updateUsername_with_same_username_does_not_require_reauthentication() {

        UpdateUsernameDto updateUsername =
                new UpdateUsernameDto();

        updateUsername.setUsername(
                "  User1  "
        );

        updateUsername.setCurrentPassword(
                "password123"
        );

        User user =
                new User();

        user.setUsername(
                "user1"
        );

        user.setEmail(
                "user1@bestbuds.local"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(
                authenticationService.updateUsername(
                        "user1",
                        updateUsername
                )
        ).thenReturn(
                user
        );

        UpdateUsernameResponseDto response =
                sut.updateUsername(
                        authentication,
                        updateUsername
                );

        assertEquals(
                "user1",
                response.getUsername()
        );

        assertEquals(
                "user1@bestbuds.local",
                response.getEmail()
        );

        assertFalse(
                response.isReauthenticationRequired()
        );

        verify(authenticationService).updateUsername(
                "user1",
                updateUsername
        );
    }

    @Test
    public void updatePassword_updates_password_for_authenticated_user() {

        UpdatePasswordDto updatePassword =
                new UpdatePasswordDto();

        updatePassword.setCurrentPassword(
                "currentPassword123"
        );

        updatePassword.setNewPassword(
                "newPassword456"
        );

        updatePassword.setConfirmPassword(
                "newPassword456"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        sut.updatePassword(
                authentication,
                updatePassword
        );

        verify(authenticationService).updatePassword(
                "user1",
                updatePassword
        );
    }
}