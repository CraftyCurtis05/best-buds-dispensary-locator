package com.bestbuds.controller;

import com.bestbuds.model.User;
import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityRequest;
import com.bestbuds.model.UserActivityType;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.UserActivityService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserActivityControllerTests {

    private UserActivityService userActivityService;
    private AuthenticationService authenticationService;
    private Authentication authentication;
    private UserActivityController sut;

    @BeforeEach
    public void setup() {

        userActivityService =
                mock(UserActivityService.class);

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new UserActivityController(
                        userActivityService,
                        authenticationService
                );
    }


    @Test
    public void createUserActivity_creates_activity_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        UserActivityRequest request =
                new UserActivityRequest(
                        UserActivityType.DISPENSARY_VIEW,
                        "test-dispensary"
                );

        UserActivity userActivity =
                new UserActivity();

        userActivity.setActivityId(
                10
        );

        userActivity.setUserId(
                1
        );

        userActivity.setActivityType(
                UserActivityType.DISPENSARY_VIEW
        );

        userActivity.setActivityValue(
                "test-dispensary"
        );

        when(
                authentication.getName()
        ).thenReturn(
                "user1"
        );

        when(
                authenticationService.getUser(
                        "user1"
                )
        ).thenReturn(
                user
        );

        when(
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.DISPENSARY_VIEW,
                        "test-dispensary"
                )
        ).thenReturn(
                userActivity
        );

        ResponseEntity<UserActivity> response =
                sut.createUserActivity(
                        request,
                        authentication
                );

        assertEquals(
                201,
                response.getStatusCode().value()
        );

        assertSame(
                userActivity,
                response.getBody()
        );

        verify(
                authenticationService
        ).getUser(
                "user1"
        );

        verify(
                userActivityService
        ).createUserActivity(
                1,
                UserActivityType.DISPENSARY_VIEW,
                "test-dispensary"
        );
    }


    @Test
    public void createUserActivity_returns_bad_request_when_activity_is_invalid() {

        User user =
                new User();

        user.setId(
                1
        );

        UserActivityRequest request =
                new UserActivityRequest(
                        "INVALID_ACTIVITY",
                        "test-value"
                );

        when(
                authentication.getName()
        ).thenReturn(
                "user1"
        );

        when(
                authenticationService.getUser(
                        "user1"
                )
        ).thenReturn(
                user
        );

        when(
                userActivityService.createUserActivity(
                        1,
                        "INVALID_ACTIVITY",
                        "test-value"
                )
        ).thenReturn(
                null
        );

        ResponseEntity<UserActivity> response =
                sut.createUserActivity(
                        request,
                        authentication
                );

        assertEquals(
                400,
                response.getStatusCode().value()
        );

        assertNull(
                response.getBody()
        );

        verify(
                authenticationService
        ).getUser(
                "user1"
        );

        verify(
                userActivityService
        ).createUserActivity(
                1,
                "INVALID_ACTIVITY",
                "test-value"
        );
    }
}