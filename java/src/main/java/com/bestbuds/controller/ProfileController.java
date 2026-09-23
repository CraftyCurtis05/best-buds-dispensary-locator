package com.bestbuds.controller;

import com.bestbuds.model.Profile;
import com.bestbuds.model.ProfileDto;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.ProfileService;

import jakarta.validation.Valid;

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
            @Valid @RequestBody ProfileDto profileDto
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        Profile profile =
                createProfileFromDto(
                        profileDto
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

    // Convert editable profile fields into a Profile
    private Profile createProfileFromDto(
            ProfileDto profileDto
    ) {

        Profile profile =
                new Profile();

        profile.setFirstName(
                profileDto.getFirstName()
        );

        profile.setLastName(
                profileDto.getLastName()
        );

        profile.setBirthday(
                profileDto.getBirthday()
        );

        profile.setAddressLine1(
                profileDto.getAddressLine1()
        );

        profile.setAddressLine2(
                profileDto.getAddressLine2()
        );

        profile.setCity(
                profileDto.getCity()
        );

        profile.setStateAbbr(
                profileDto.getStateAbbr()
        );

        profile.setZipcode(
                profileDto.getZipcode()
        );

        return profile;
    }
}