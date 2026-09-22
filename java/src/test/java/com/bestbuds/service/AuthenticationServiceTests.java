package com.bestbuds.service;

import com.bestbuds.dao.UserDao;
import com.bestbuds.model.LoginDto;
import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.User;
import com.bestbuds.model.UpdateEmailDto;
import com.bestbuds.model.UpdateUsernameDto;
import com.bestbuds.model.UpdatePasswordDto;
import com.bestbuds.exception.RegistrationException;
import com.bestbuds.exception.InvalidPasswordException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTests {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserDao userDao;

    @Mock
    private Authentication authentication;

    private AuthenticationService sut;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);

        sut = new AuthenticationService(
                authenticationManager,
                userDao,
                passwordEncoder
        );
    }

    @Test
    public void authenticate_with_valid_login_returns_authentication() {

        LoginDto loginDto =
                createLoginDto(
                        "user1",
                        "password123"
                );

        when(
                authenticationManager.authenticate(
                        any(UsernamePasswordAuthenticationToken.class)
                )
        ).thenReturn(authentication);

        Authentication result =
                sut.authenticate(loginDto);

        assertSame(
                authentication,
                result
        );
    }

    @Test
    public void authenticate_passes_username_and_password_to_authentication_manager() {

        LoginDto loginDto =
                createLoginDto(
                        "user1",
                        "password123"
                );

        when(
                authenticationManager.authenticate(
                        any(UsernamePasswordAuthenticationToken.class)
                )
        ).thenReturn(authentication);

        sut.authenticate(loginDto);

        verify(authenticationManager).authenticate(
                new UsernamePasswordAuthenticationToken(
                        "user1",
                        "password123"
                )
        );
    }

    @Test
    public void getUser_with_username_returns_user() {

        User expectedUser =
                new User(
                        1,
                        "user1",
                        "password123",
                        "ROLE_USER"
                );

        when(
                userDao.getUserByUsername("user1")
        ).thenReturn(expectedUser);

        User actualUser =
                sut.getUser("user1");

        assertEquals(
                expectedUser,
                actualUser
        );

        verify(userDao).getUserByUsername(
                "user1"
        );
    }

    @Test
    public void register_with_matching_passwords_creates_user() {

        RegisterUserDto registration =
                createRegistrationDto(
                        "newuser",
                        "password123",
                        "password123"
                );

        User expectedUser =
                new User(
                        4,
                        "newuser",
                        "hashed-password",
                        "ROLE_USER"
                );

        when(
                userDao.createUser(
                        "newuser",
                        "newuser@bestbuds.local",
                        "password123"
                )
        ).thenReturn(expectedUser);

        User actualUser =
                sut.register(registration);

        assertEquals(
                expectedUser,
                actualUser
        );

        verify(userDao).createUser(
                "newuser",
                "newuser@bestbuds.local",
                "password123"
        );
    }

    @Test
    public void register_with_different_passwords_throws_exception() {

        RegisterUserDto registration =
                createRegistrationDto(
                        "newuser",
                        "password123",
                        "different123"
                );

        assertThrows(
                RegistrationException.class,
                () -> sut.register(registration)
        );

        verify(
                userDao,
                never()
        ).createUser(
                any(String.class),
                any(String.class),
                any(String.class)
        );
    }

    private LoginDto createLoginDto(
            String username,
            String password
    ) {

        LoginDto loginDto =
                new LoginDto();

        loginDto.setUsername(username);
        loginDto.setPassword(password);

        return loginDto;
    }

    private RegisterUserDto createRegistrationDto(
            String username,
            String password,
            String confirmPassword
    ) {

        RegisterUserDto registration =
                new RegisterUserDto();

        registration.setUsername(
                username
        );

        registration.setEmail(
                "newuser@bestbuds.local"
        );

        registration.setPassword(
                password
        );

        registration.setConfirmPassword(
                confirmPassword
        );

        return registration;
    }

    @Test
    public void updateEmail_with_correct_password_updates_email() {

        User user =
                new User(
                        1,
                        "user1",
                        "hashed-password",
                        "ROLE_USER"
                );

        user.setEmail(
                "user1@bestbuds.local"
        );

        User updatedUser =
                new User(
                        1,
                        "user1",
                        "hashed-password",
                        "ROLE_USER"
                );

        updatedUser.setEmail(
                "updated@bestbuds.local"
        );

        UpdateEmailDto updateEmail =
                createUpdateEmailDto(
                        "updated@bestbuds.local",
                        "password123"
                );

        when(userDao.getUserByUsername("user1"))
                .thenReturn(
                        user
                );

        when(
                passwordEncoder.matches(
                        "password123",
                        "hashed-password"
                )
        ).thenReturn(
                true
        );

        when(userDao.getUserById(1))
                .thenReturn(
                        updatedUser
                );

        User result =
                sut.updateEmail(
                        "user1",
                        updateEmail
                );

        assertSame(
                updatedUser,
                result
        );

        verify(userDao).updateEmail(
                1,
                "updated@bestbuds.local"
        );
    }

    @Test
    public void updateEmail_with_incorrect_password_throws_exception() {

        User user =
                new User(
                        1,
                        "user1",
                        "hashed-password",
                        "ROLE_USER"
                );

        user.setEmail(
                "user1@bestbuds.local"
        );

        UpdateEmailDto updateEmail =
                createUpdateEmailDto(
                        "updated@bestbuds.local",
                        "wrongpassword"
                );

        when(userDao.getUserByUsername("user1"))
                .thenReturn(
                        user
                );

        when(
                passwordEncoder.matches(
                        "wrongpassword",
                        "hashed-password"
                )
        ).thenReturn(
                false
        );

        assertThrows(
                InvalidPasswordException.class,
                () -> sut.updateEmail(
                        "user1",
                        updateEmail
                )
        );

        verify(
                userDao,
                never()
        ).updateEmail(
                1,
                "updated@bestbuds.local"
        );
    }

    @Test
    public void updateEmail_with_same_email_does_not_update_email() {

        User user =
                new User(
                        1,
                        "user1",
                        "hashed-password",
                        "ROLE_USER"
                );

        user.setEmail(
                "user1@bestbuds.local"
        );

        UpdateEmailDto updateEmail =
                createUpdateEmailDto(
                        "  User1@BestBuds.Local  ",
                        "password123"
                );

        when(userDao.getUserByUsername("user1"))
                .thenReturn(
                        user
                );

        when(
                passwordEncoder.matches(
                        "password123",
                        "hashed-password"
                )
        ).thenReturn(
                true
        );

        User result =
                sut.updateEmail(
                        "user1",
                        updateEmail
                );

        assertSame(
                user,
                result
        );

        verify(
                userDao,
                never()
        ).updateEmail(
                1,
                "user1@bestbuds.local"
        );
    }

    private UpdateEmailDto createUpdateEmailDto(
            String email,
            String currentPassword
    ) {

        UpdateEmailDto updateEmail =
                new UpdateEmailDto();

        updateEmail.setEmail(
                email
        );

        updateEmail.setCurrentPassword(
                currentPassword
        );

        return updateEmail;
    }

    @Test
    public void updateUsername_with_correct_password_updates_username() {

        User user =
                new User(
                        1,
                        "user1",
                        "hashed-password",
                        "ROLE_USER"
                );

        User updatedUser =
                new User(
                        1,
                        "updateduser",
                        "hashed-password",
                        "ROLE_USER"
                );

        UpdateUsernameDto updateUsername =
                createUpdateUsernameDto(
                        "updateduser",
                        "password123"
                );

        when(userDao.getUserByUsername("user1"))
                .thenReturn(
                        user
                );

        when(
                passwordEncoder.matches(
                        "password123",
                        "hashed-password"
                )
        ).thenReturn(
                true
        );

        when(userDao.getUserById(1))
                .thenReturn(
                        updatedUser
                );

        User result =
                sut.updateUsername(
                        "user1",
                        updateUsername
                );

        assertSame(
                updatedUser,
                result
        );

        verify(userDao).updateUsername(
                1,
                "updateduser"
        );
    }

    @Test
    public void updateUsername_with_incorrect_password_throws_exception() {

        User user =
                new User(
                        1,
                        "user1",
                        "hashed-password",
                        "ROLE_USER"
                );

        UpdateUsernameDto updateUsername =
                createUpdateUsernameDto(
                        "updateduser",
                        "wrongpassword"
                );

        when(userDao.getUserByUsername("user1"))
                .thenReturn(
                        user
                );

        when(
                passwordEncoder.matches(
                        "wrongpassword",
                        "hashed-password"
                )
        ).thenReturn(
                false
        );

        assertThrows(
                InvalidPasswordException.class,
                () -> sut.updateUsername(
                        "user1",
                        updateUsername
                )
        );

        verify(
                userDao,
                never()
        ).updateUsername(
                1,
                "updateduser"
        );
    }

    @Test
    public void updateUsername_with_same_username_does_not_update_username() {

        User user =
                new User(
                        1,
                        "user1",
                        "hashed-password",
                        "ROLE_USER"
                );

        UpdateUsernameDto updateUsername =
                createUpdateUsernameDto(
                        "  User1  ",
                        "password123"
                );

        when(userDao.getUserByUsername("user1"))
                .thenReturn(
                        user
                );

        when(
                passwordEncoder.matches(
                        "password123",
                        "hashed-password"
                )
        ).thenReturn(
                true
        );

        User result =
                sut.updateUsername(
                        "user1",
                        updateUsername
                );

        assertSame(
                user,
                result
        );

        verify(
                userDao,
                never()
        ).updateUsername(
                1,
                "user1"
        );
    }

    private UpdateUsernameDto createUpdateUsernameDto(
            String username,
            String currentPassword
    ) {

        UpdateUsernameDto updateUsername =
                new UpdateUsernameDto();

        updateUsername.setUsername(
                username
        );

        updateUsername.setCurrentPassword(
                currentPassword
        );

        return updateUsername;
    }

    @Test
    public void updatePassword_with_correct_password_updates_password() {

        User user =
                new User();

        user.setId(
                1
        );

        user.setUsername(
                "user1"
        );

        user.setPassword(
                "encodedCurrentPassword"
        );

        UpdatePasswordDto updatePassword =
                createUpdatePasswordDto(
                        "currentPassword123",
                        "newPassword456",
                        "newPassword456"
                );

        when(
                userDao.getUserByUsername(
                        "user1"
                )
        ).thenReturn(
                user
        );

        when(
                passwordEncoder.matches(
                        "currentPassword123",
                        "encodedCurrentPassword"
                )
        ).thenReturn(
                true
        );

        sut.updatePassword(
                "user1",
                updatePassword
        );

        verify(userDao).updatePassword(
                1,
                "newPassword456"
        );
    }

    @Test
    public void updatePassword_with_incorrect_password_throws_exception() {

        User user =
                new User();

        user.setId(
                1
        );

        user.setUsername(
                "user1"
        );

        user.setPassword(
                "encodedCurrentPassword"
        );

        UpdatePasswordDto updatePassword =
                createUpdatePasswordDto(
                        "wrongPassword123",
                        "newPassword456",
                        "newPassword456"
                );

        when(
                userDao.getUserByUsername(
                        "user1"
                )
        ).thenReturn(
                user
        );

        when(
                passwordEncoder.matches(
                        "wrongPassword123",
                        "encodedCurrentPassword"
                )
        ).thenReturn(
                false
        );

        assertThrows(
                InvalidPasswordException.class,
                () -> sut.updatePassword(
                        "user1",
                        updatePassword
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
    public void updatePassword_with_mismatched_new_passwords_throws_exception() {

        User user =
                new User();

        user.setId(
                1
        );

        user.setUsername(
                "user1"
        );

        user.setPassword(
                "encodedCurrentPassword"
        );

        UpdatePasswordDto updatePassword =
                createUpdatePasswordDto(
                        "currentPassword123",
                        "newPassword456",
                        "differentPassword456"
                );

        when(
                userDao.getUserByUsername(
                        "user1"
                )
        ).thenReturn(
                user
        );

        when(
                passwordEncoder.matches(
                        "currentPassword123",
                        "encodedCurrentPassword"
                )
        ).thenReturn(
                true
        );

        assertThrows(
                RegistrationException.class,
                () -> sut.updatePassword(
                        "user1",
                        updatePassword
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

    private UpdatePasswordDto createUpdatePasswordDto(
            String currentPassword,
            String newPassword,
            String confirmPassword
    ) {

        UpdatePasswordDto updatePassword =
                new UpdatePasswordDto();

        updatePassword.setCurrentPassword(
                currentPassword
        );

        updatePassword.setNewPassword(
                newPassword
        );

        updatePassword.setConfirmPassword(
                confirmPassword
        );

        return updatePassword;
    }
}