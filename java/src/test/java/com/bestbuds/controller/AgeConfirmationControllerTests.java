package com.bestbuds.controller;

import com.bestbuds.model.User;
import com.bestbuds.service.AgeConfirmationService;
import com.bestbuds.service.AuthenticationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AgeConfirmationControllerTests {

    private AgeConfirmationService ageConfirmationService;
    private AuthenticationService authenticationService;
    private Authentication authentication;
    private AgeConfirmationController sut;

    @BeforeEach
    public void setup() {

        ageConfirmationService =
                mock(AgeConfirmationService.class);

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new AgeConfirmationController(
                        ageConfirmationService,
                        authenticationService
                );
    }

    @Test
    public void confirmAge_confirms_age_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        sut.confirmAge(
                authentication
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(ageConfirmationService).confirmAge(
                1
        );
    }
}