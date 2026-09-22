package com.bestbuds.controller;

import com.bestbuds.model.Profile;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.ProfileService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final AuthenticationService authenticationService;

    public ProfileController(
            ProfileService profileService,
            AuthenticationService authenticationService
    ) {
        this.profileService = profileService;
        this.authenticationService = authenticationService;
    }

    // Get the authenticated user's profile
    @GetMapping
    public ResponseEntity<Profile> getProfile(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        Profile profile =
                profileService.getProfile(
                        user.getId()
                );

        if (profile == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(
                profile
        );
    }

    // Create or update the authenticated user's profile
    @PutMapping
    public ResponseEntity<Profile> saveProfile(
            Authentication authentication,
            @RequestBody Profile profile
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        Profile savedProfile =
                profileService.saveProfile(
                        user.getId(),
                        profile
                );

        return ResponseEntity.ok(
                savedProfile
        );
    }
}