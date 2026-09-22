package com.bestbuds.service;

import com.bestbuds.dao.UserDao;
import com.bestbuds.model.LoginDto;
import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.User;
import com.bestbuds.exception.RegistrationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);

        sut = new AuthenticationService(
                authenticationManager,
                userDao
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

        registration.setUsername(username);
        registration.setPassword(password);
        registration.setConfirmPassword(
                confirmPassword
        );

        return registration;
    }
}