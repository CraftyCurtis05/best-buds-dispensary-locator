package com.bestbuds.controller;

import com.bestbuds.model.Profile;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.ProfileService;

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

public class ProfileControllerTests {

    private ProfileService profileService;
    private AuthenticationService authenticationService;
    private Authentication authentication;
    private ProfileController sut;

    @BeforeEach
    public void setup() {

        profileService =
                mock(ProfileService.class);

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new ProfileController(
                        profileService,
                        authenticationService
                );
    }

    @Test
    public void getProfile_returns_profile_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        Profile profile =
                new Profile();

        profile.setId(
                10
        );

        profile.setUserId(
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

        when(profileService.getProfile(1))
                .thenReturn(
                        profile
                );

        ResponseEntity<Profile> response =
                sut.getProfile(
                        authentication
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                profile,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(profileService).getProfile(
                1
        );
    }

    @Test
    public void getProfile_returns_no_content_when_profile_does_not_exist() {

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

        when(profileService.getProfile(1))
                .thenReturn(
                        null
                );

        ResponseEntity<Profile> response =
                sut.getProfile(
                        authentication
                );

        assertEquals(
                204,
                response.getStatusCode().value()
        );

        assertNull(
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(profileService).getProfile(
                1
        );
    }

    @Test
    public void saveProfile_saves_profile_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        Profile profile =
                new Profile();

        profile.setFirstName(
                "Test"
        );

        profile.setLastName(
                "User"
        );

        Profile savedProfile =
                new Profile();

        savedProfile.setId(
                10
        );

        savedProfile.setUserId(
                1
        );

        savedProfile.setFirstName(
                "Test"
        );

        savedProfile.setLastName(
                "User"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        when(
                profileService.saveProfile(
                        1,
                        profile
                )
        )
                .thenReturn(
                        savedProfile
                );

        ResponseEntity<Profile> response =
                sut.saveProfile(
                        authentication,
                        profile
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                savedProfile,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(profileService).saveProfile(
                1,
                profile
        );
    }
}