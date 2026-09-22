package com.bestbuds.controller;

import com.bestbuds.model.AccountDto;
import com.bestbuds.model.User;
import com.bestbuds.model.UpdateEmailDto;
import com.bestbuds.model.UpdateUsernameDto;
import com.bestbuds.model.UpdateUsernameResponseDto;
import com.bestbuds.model.UpdatePasswordDto;
import com.bestbuds.service.AuthenticationService;

import jakarta.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AuthenticationService authenticationService;

    public AccountController(
            AuthenticationService authenticationService
    ) {
        this.authenticationService = authenticationService;
    }

    // Get the authenticated user's account information
    @GetMapping
    public AccountDto getAccount(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        return new AccountDto(
                user.getUsername(),
                user.getEmail()
        );
    }

    // Update the authenticated user's email
    @PutMapping("/email")
    public AccountDto updateEmail(
            Authentication authentication,
            @Valid @RequestBody UpdateEmailDto updateEmail
    ) {

        User user =
                authenticationService.updateEmail(
                        authentication.getName(),
                        updateEmail
                );

        return new AccountDto(
                user.getUsername(),
                user.getEmail()
        );
    }

    // Update the authenticated user's username
    @PutMapping("/username")
    public UpdateUsernameResponseDto updateUsername(
            Authentication authentication,
            @Valid @RequestBody UpdateUsernameDto updateUsername
    ) {

        String currentUsername =
                authentication.getName();

        User user =
                authenticationService.updateUsername(
                        currentUsername,
                        updateUsername
                );

        boolean reauthenticationRequired =
                !currentUsername.equals(
                        user.getUsername()
                );

        return new UpdateUsernameResponseDto(
                user.getUsername(),
                user.getEmail(),
                reauthenticationRequired
        );
    }

    // Update the authenticated user's password
    @PutMapping("/password")
    public void updatePassword(
            Authentication authentication,
            @Valid @RequestBody UpdatePasswordDto updatePassword
    ) {

        authenticationService.updatePassword(
                authentication.getName(),
                updatePassword
        );
    }
}