package com.bestbuds.service;

import com.bestbuds.dao.UserDao;
import com.bestbuds.model.LoginDto;
import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.UpdateEmailDto;
import com.bestbuds.model.User;
import com.bestbuds.model.UpdateUsernameDto;
import com.bestbuds.model.UpdatePasswordDto;
import com.bestbuds.exception.RegistrationException;
import com.bestbuds.exception.InvalidPasswordException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(
            AuthenticationManager authenticationManager,
            UserDao userDao,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
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
                registration.getEmail(),
                registration.getPassword()
        );
    }

    public User updateEmail(
            String username,
            UpdateEmailDto updateEmail
    ) {

        User user =
                userDao.getUserByUsername(
                        username
                );

        if (!passwordEncoder.matches(
                updateEmail.getCurrentPassword(),
                user.getPassword()
        )) {
        throw new InvalidPasswordException(
                "Current password is incorrect."
        );
        }

        String normalizedEmail =
                updateEmail
                        .getEmail()
                        .trim()
                        .toLowerCase();

        if (normalizedEmail.equals(
                user.getEmail()
        )) {
            return user;
        }

        userDao.updateEmail(
                user.getId(),
                normalizedEmail
        );

        return userDao.getUserById(
                user.getId()
        );
    }

    public User updateUsername(
            String currentUsername,
            UpdateUsernameDto updateUsername
    ) {

        User user =
                userDao.getUserByUsername(
                        currentUsername
                );

        if (!passwordEncoder.matches(
                updateUsername.getCurrentPassword(),
                user.getPassword()
        )) {
            throw new InvalidPasswordException(
                    "Current password is incorrect."
            );
        }

        String normalizedUsername =
                updateUsername
                        .getUsername()
                        .trim()
                        .toLowerCase();

        if (normalizedUsername.equals(
                user.getUsername()
        )) {
            return user;
        }

        userDao.updateUsername(
                user.getId(),
                normalizedUsername
        );

        return userDao.getUserById(
                user.getId()
        );
    }

    // Change the authenticated user's password
    public void updatePassword(
            String username,
            UpdatePasswordDto updatePassword
    ) {

        User user =
                userDao.getUserByUsername(
                        username
                );

        if (!passwordEncoder.matches(
                updatePassword.getCurrentPassword(),
                user.getPassword()
        )) {
            throw new InvalidPasswordException(
                    "Current password is incorrect."
            );
        }

        if (!updatePassword
                .getNewPassword()
                .equals(
                        updatePassword.getConfirmPassword()
                )) {
            throw new RegistrationException(
                    "Passwords do not match."
            );
        }

        userDao.updatePassword(
                user.getId(),
                updatePassword.getNewPassword()
        );
    }
}