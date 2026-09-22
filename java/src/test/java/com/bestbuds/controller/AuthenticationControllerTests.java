package com.bestbuds.controller;

import com.bestbuds.model.User;
import com.bestbuds.model.LoginDto;
import com.bestbuds.model.LoginResponseDto;
import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.ForgotPasswordDto;
import com.bestbuds.model.ResetPasswordDto;
import com.bestbuds.security.TokenProvider;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.PasswordResetService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AuthenticationControllerTests {

    private AuthenticationService authenticationService;
    private TokenProvider tokenProvider;
    private PasswordResetService passwordResetService;
    private AuthenticationController sut;

    @BeforeEach
    public void setup() {

        authenticationService =
                mock(AuthenticationService.class);

        tokenProvider =
                mock(TokenProvider.class);

        passwordResetService =
                mock(PasswordResetService.class);

        sut =
                new AuthenticationController(
                        authenticationService,
                        tokenProvider,
                        passwordResetService
                );
    }

    @Test
    public void register_registers_new_user() {

        RegisterUserDto registration =
                new RegisterUserDto();

        registration.setUsername(
                "newuser"
        );

        registration.setEmail(
                "newuser@bestbuds.local"
        );

        registration.setPassword(
                "password123"
        );

        registration.setConfirmPassword(
                "password123"
        );

        sut.register(
                registration
        );

        verify(authenticationService).register(
                registration
        );
    }

    @Test
    public void login_returns_token_and_user() {

        LoginDto loginDto =
                new LoginDto();

        loginDto.setUsername(
                "user1"
        );

        loginDto.setPassword(
                "password123"
        );

        Authentication authentication =
                mock(Authentication.class);

        User user =
                new User();

        user.setUsername(
                "user1"
        );

        user.setEmail(
                "user1@bestbuds.local"
        );

        when(authenticationService.authenticate(loginDto))
                .thenReturn(
                        authentication
                );

        when(
                tokenProvider.createToken(
                        authentication,
                        false
                )
        )
                .thenReturn(
                        "test-jwt-token"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        ResponseEntity<LoginResponseDto> response =
                sut.login(
                        loginDto
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertEquals(
                "Bearer test-jwt-token",
                response.getHeaders().getFirst(
                        HttpHeaders.AUTHORIZATION
                )
        );

        assertEquals(
                "test-jwt-token",
                response.getBody().getToken()
        );

        assertSame(
                user,
                response.getBody().getUser()
        );

        verify(authenticationService).authenticate(
                loginDto
        );

        verify(tokenProvider).createToken(
                authentication,
                false
        );

        verify(authenticationService).getUser(
                "user1"
        );
    }

    @Test
    public void forgotPassword_requests_password_reset_for_email() {

        ForgotPasswordDto forgotPassword =
                new ForgotPasswordDto();

        forgotPassword.setEmail(
                "user1@bestbuds.local"
        );

        sut.forgotPassword(
                forgotPassword
        );

        verify(passwordResetService).createResetToken(
                "user1@bestbuds.local"
        );
    }

    @Test
    public void resetPassword_resets_password() {

        ResetPasswordDto resetPassword =
                new ResetPasswordDto();

        resetPassword.setToken(
                "reset-token"
        );

        resetPassword.setNewPassword(
                "newPassword123"
        );

        resetPassword.setConfirmPassword(
                "newPassword123"
        );

        sut.resetPassword(
                resetPassword
        );

        verify(passwordResetService).resetPassword(
                resetPassword
        );
    }
}