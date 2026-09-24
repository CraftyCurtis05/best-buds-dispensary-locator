package com.bestbuds.controller;

import com.bestbuds.model.Coordinates;
import com.bestbuds.model.Profile;
import com.bestbuds.model.User;
import com.bestbuds.service.GeoapifyService;
import com.bestbuds.service.YelpService;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.ProfileService;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DispensaryControllerTests {

    private YelpService yelpService;
    private GeoapifyService geoapifyService;
    private ProfileService profileService;
    private AuthenticationService authenticationService;
    private Authentication authentication;
    private DispensaryController sut;

    @BeforeEach
    public void setUp() {

        yelpService =
                mock(YelpService.class);

        geoapifyService =
                mock(GeoapifyService.class);

        profileService =
                mock(ProfileService.class);

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new DispensaryController(
                        yelpService,
                        geoapifyService,
                        profileService,
                        authenticationService
                );
    }

    @Test
    public void searchDispensaries_returns_search_results() {

        JsonNode results =
                new ObjectMapper()
                        .createObjectNode();

        when(
                yelpService.searchDispensaries(
                        "Columbus, OH"
                )
        )
                .thenReturn(
                        results
                );

        ResponseEntity<JsonNode> response =
                sut.searchDispensaries(
                        "Columbus, OH"
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                results,
                response.getBody()
        );

        verify(yelpService)
                .searchDispensaries(
                        "Columbus, OH"
                );
    }

    @Test
    public void searchDispensariesNearHome_returns_search_results() {

        User user =
                new User();

        user.setId(1);

        Profile profile =
                new Profile();

        profile.setAddressLine1(
                "123 Main Street"
        );

        profile.setCity(
                "Columbus"
        );

        profile.setStateAbbr(
                "OH"
        );

        profile.setZipcode(
                "43215"
        );

        JsonNode results =
                new ObjectMapper()
                        .createObjectNode();

        when(
                authentication.getName()
        )
                .thenReturn(
                        "testuser"
                );

        when(
                authenticationService.getUser(
                        "testuser"
                )
        )
                .thenReturn(
                        user
                );

        when(
                profileService.getProfile(
                        1
                )
        )
                .thenReturn(
                        profile
                );

        when(
                yelpService.searchDispensaries(
                        "123 Main Street, Columbus, OH 43215"
                )
        )
                .thenReturn(
                        results
                );

        ResponseEntity<JsonNode> response =
                sut.searchDispensariesNearHome(
                        authentication
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                results,
                response.getBody()
        );

        verify(yelpService)
                .searchDispensaries(
                        "123 Main Street, Columbus, OH 43215"
                );
    }

    @Test
    public void searchDispensariesNearHome_returns_bad_request_when_address_is_missing() {

        User user =
                new User();

        user.setId(1);

        Profile profile =
                new Profile();

        when(
                authentication.getName()
        )
                .thenReturn(
                        "testuser"
                );

        when(
                authenticationService.getUser(
                        "testuser"
                )
        )
                .thenReturn(
                        user
                );

        when(
                profileService.getProfile(
                        1
                )
        )
                .thenReturn(
                        profile
                );

        ResponseEntity<JsonNode> response =
                sut.searchDispensariesNearHome(
                        authentication
                );

        assertEquals(
                400,
                response.getStatusCode().value()
        );

        verify(
                yelpService,
                never()
        )
                .searchDispensaries(
                        anyString()
                );
    }

    @Test
    public void searchDispensariesNearHome_returns_bad_request_when_profile_does_not_exist() {

        User user =
                new User();

        user.setId(1);

        when(
                authentication.getName()
        )
                .thenReturn(
                        "testuser"
                );

        when(
                authenticationService.getUser(
                        "testuser"
                )
        )
                .thenReturn(
                        user
                );

        when(
                profileService.getProfile(
                        1
                )
        )
                .thenReturn(
                        null
                );

        ResponseEntity<JsonNode> response =
                sut.searchDispensariesNearHome(
                        authentication
                );

        assertEquals(
                400,
                response.getStatusCode().value()
        );

        verify(
                yelpService,
                never()
        )
                .searchDispensaries(
                        anyString()
                );
    }

    @Test
    public void getFeaturedDispensary_returns_featured_dispensary_near_home() {

        User user =
                new User();

        user.setId(1);

        Profile profile =
                new Profile();

        profile.setAddressLine1(
                "123 Main Street"
        );

        profile.setCity(
                "Columbus"
        );

        profile.setStateAbbr(
                "OH"
        );

        profile.setZipcode(
                "43215"
        );

        Coordinates coordinates =
                new Coordinates(
                        39.961657,
                        -83.006021
                );

        JsonNode featured =
                new ObjectMapper()
                        .createObjectNode();

        when(
                authentication.getName()
        )
                .thenReturn(
                        "testuser"
                );

        when(
                authenticationService.getUser(
                        "testuser"
                )
        )
                .thenReturn(
                        user
                );

        when(
                profileService.getProfile(
                        1
                )
        )
                .thenReturn(
                        profile
                );

        when(
                geoapifyService.geocodeAddress(
                        "123 Main Street, Columbus, OH 43215"
                )
        )
                .thenReturn(
                        coordinates
                );

        when(
                yelpService.getFeaturedDispensary(
                        39.961657,
                        -83.006021
                )
        )
                .thenReturn(
                        featured
                );

        ResponseEntity<JsonNode> response =
                sut.getFeaturedDispensary(
                        authentication
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                featured,
                response.getBody()
        );

        verify(geoapifyService)
                .geocodeAddress(
                        "123 Main Street, Columbus, OH 43215"
                );

        verify(yelpService)
                .getFeaturedDispensary(
                        39.961657,
                        -83.006021
                );
    }

    @Test
    public void getFeaturedDispensary_returns_no_content_when_address_cannot_be_geocoded() {

        User user =
                new User();

        user.setId(1);

        Profile profile =
                new Profile();

        profile.setAddressLine1(
                "123 Main Street"
        );

        profile.setCity(
                "Columbus"
        );

        profile.setStateAbbr(
                "OH"
        );

        profile.setZipcode(
                "43215"
        );

        when(
                authentication.getName()
        )
                .thenReturn(
                        "testuser"
                );

        when(
                authenticationService.getUser(
                        "testuser"
                )
        )
                .thenReturn(
                        user
                );

        when(
                profileService.getProfile(
                        1
                )
        )
                .thenReturn(
                        profile
                );

        when(
                geoapifyService.geocodeAddress(
                        "123 Main Street, Columbus, OH 43215"
                )
        )
                .thenReturn(
                        null
                );

        ResponseEntity<JsonNode> response =
                sut.getFeaturedDispensary(
                        authentication
                );

        assertEquals(
                204,
                response.getStatusCode().value()
        );

        verify(geoapifyService)
                .geocodeAddress(
                        "123 Main Street, Columbus, OH 43215"
                );

        verify(
                yelpService,
                never()
        )
                .getFeaturedDispensary(
                        anyDouble(),
                        anyDouble()
                );
    }
}