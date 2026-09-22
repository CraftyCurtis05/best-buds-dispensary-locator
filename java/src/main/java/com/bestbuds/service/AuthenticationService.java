package com.bestbuds.service;

import com.bestbuds.dao.UserDao;
import com.bestbuds.model.LoginDto;
import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.User;
import com.bestbuds.exception.RegistrationException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;

    public AuthenticationService(
            AuthenticationManager authenticationManager,
            UserDao userDao
    ) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
    }

    // Authenticate a user's login credentials
    public Authentication authenticate(
            LoginDto loginDto
    ) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                );

        return authenticationManager.authenticate(
                authenticationToken
        );
    }

    // Find the authenticated user's account
    public User getUser(
            String username
    ) {
        return userDao.getUserByUsername(
                username
        );
    }

    // Register a new user account
    public User register(
            RegisterUserDto registration
    ) {

        if (!registration
                .getPassword()
                .equals(registration.getConfirmPassword())) {

                throw new RegistrationException(
                        "Passwords do not match."
                );
        }

        return userDao.createUser(
                registration.getUsername(),
                registration.getPassword()
        );
    }
}