package com.bestbuds.controller;

import com.bestbuds.model.User;
import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityRequest;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.UserActivityService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activities")
public class UserActivityController {

    private final UserActivityService userActivityService;
    private final AuthenticationService authenticationService;

    public UserActivityController(
            UserActivityService userActivityService,
            AuthenticationService authenticationService
    ) {
        this.userActivityService =
                userActivityService;

        this.authenticationService =
                authenticationService;
    }


    // Record an activity for the authenticated user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserActivity createUserActivity(
            @RequestBody UserActivityRequest request,
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        return userActivityService.createUserActivity(
                user.getId(),
                request.getActivityType(),
                request.getActivityValue()
        );
    }
}