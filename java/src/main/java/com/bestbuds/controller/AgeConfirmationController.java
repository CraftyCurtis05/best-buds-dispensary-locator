package com.bestbuds.controller;

import com.bestbuds.model.User;
import com.bestbuds.service.AgeConfirmationService;
import com.bestbuds.service.AuthenticationService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/age")
public class AgeConfirmationController {

    private final AgeConfirmationService ageConfirmationService;
    private final AuthenticationService authenticationService;

    public AgeConfirmationController(
            AgeConfirmationService ageConfirmationService,
            AuthenticationService authenticationService
    ) {
        this.ageConfirmationService = ageConfirmationService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/confirm")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmAge(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        ageConfirmationService.confirmAge(
                user.getId()
        );
    }
}