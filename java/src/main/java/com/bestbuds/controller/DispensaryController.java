package com.bestbuds.controller;

import com.bestbuds.model.User;
import com.bestbuds.model.Profile;
import com.bestbuds.service.YelpService;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.ProfileService;

import tools.jackson.databind.JsonNode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/dispensaries")
public class DispensaryController {

    private final YelpService yelpService;
    private final ProfileService profileService;
    private final AuthenticationService authenticationService;

    public DispensaryController(
            YelpService yelpService,
            ProfileService profileService,
            AuthenticationService authenticationService
    ) {
        this.yelpService = yelpService;
        this.profileService = profileService;
        this.authenticationService = authenticationService;
    }

    // Get dispensaries near a location
    @GetMapping("/search")
    public ResponseEntity<JsonNode> searchDispensaries(
            @RequestParam String location
    ) {

        JsonNode results =
                yelpService.searchDispensaries(
                        location
                );

        return ResponseEntity.ok(
                results
        );
    }

    // Get dispensaries near the user's saved home address
    @GetMapping("/near-home")
    public ResponseEntity<JsonNode> searchDispensariesNearHome(
            Authentication authentication
    ) {

        Profile profile =
                getAuthenticatedProfile(
                        authentication
                );

        if (!hasHomeAddress(profile)) {
            return ResponseEntity.badRequest().build();
        }

        String location =
                buildHomeLocation(
                        profile
                );

        JsonNode results =
                yelpService.searchDispensaries(
                        location
                );

        return ResponseEntity.ok(
                results
        );
    }

    // Get the featured dispensary near the user's saved home address
    @GetMapping("/featured")
    public ResponseEntity<JsonNode> getFeaturedDispensary(
            Authentication authentication
    ) {

        Profile profile =
                getAuthenticatedProfile(
                        authentication
                );

        if (!hasHomeAddress(profile)) {
            return ResponseEntity.badRequest().build();
        }

        String location =
                buildHomeLocation(
                        profile
                );

        JsonNode featured =
                yelpService.getFeaturedDispensary(
                        location
                );

        if (featured == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(
                featured
        );
    }

    // Get the authenticated user's profile
    private Profile getAuthenticatedProfile(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        return profileService.getProfile(
                user.getId()
        );
    }

    // Check whether the profile has a usable home address
    private boolean hasHomeAddress(
            Profile profile
    ) {

        return profile != null
                && profile.getAddressLine1() != null
                && !profile.getAddressLine1().isBlank()
                && profile.getCity() != null
                && !profile.getCity().isBlank()
                && profile.getStateAbbr() != null
                && !profile.getStateAbbr().isBlank()
                && profile.getZipcode() != null
                && !profile.getZipcode().isBlank();
    }

    // Build a location from the user's saved home address
    private String buildHomeLocation(
            Profile profile
    ) {

        return profile.getAddressLine1()
                + ", "
                + profile.getCity()
                + ", "
                + profile.getStateAbbr()
                + " "
                + profile.getZipcode();
    }
}