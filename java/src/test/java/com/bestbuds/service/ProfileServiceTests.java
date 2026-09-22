package com.bestbuds.service;

import com.bestbuds.dao.ProfileDao;
import com.bestbuds.model.Profile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProfileServiceTests {

    @Mock
    private ProfileDao profileDao;

    private ProfileService profileService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(
                this
        );

        profileService =
                new ProfileService(
                        profileDao
                );
    }

    @Test
    public void getProfile_returns_profile_for_user() {

        Profile profile =
                new Profile();

        profile.setId(
                10
        );

        profile.setUserId(
                1
        );

        when(
                profileDao.getProfileByUserId(
                        1
                )
        ).thenReturn(
                profile
        );

        Profile result =
                profileService.getProfile(
                        1
                );

        assertSame(
                profile,
                result
        );

        verify(
                profileDao
        ).getProfileByUserId(
                1
        );
    }

    @Test
    public void saveProfile_creates_profile_when_profile_does_not_exist() {

        Profile profile =
                new Profile();

        profile.setUserId(
                99
        );

        profile.setFirstName(
                "Test"
        );

        when(
                profileDao.getProfileByUserId(
                        1
                )
        ).thenReturn(
                null
        );

        when(
                profileDao.createProfile(
                        profile
                )
        ).thenReturn(
                profile
        );

        Profile result =
                profileService.saveProfile(
                        1,
                        profile
                );

        assertSame(
                profile,
                result
        );

        assertEquals(
                1,
                profile.getUserId()
        );

        verify(
                profileDao
        ).createProfile(
                profile
        );
    }

    @Test
    public void saveProfile_updates_profile_when_profile_exists() {

        Profile existingProfile =
                new Profile();

        existingProfile.setId(
                10
        );

        existingProfile.setUserId(
                1
        );

        Profile profile =
                new Profile();

        profile.setUserId(
                99
        );

        profile.setFirstName(
                "Updated"
        );

        when(
                profileDao.getProfileByUserId(
                        1
                )
        ).thenReturn(
                existingProfile
        );

        when(
                profileDao.updateProfile(
                        profile
                )
        ).thenReturn(
                profile
        );

        Profile result =
                profileService.saveProfile(
                        1,
                        profile
                );

        assertSame(
                profile,
                result
        );

        assertEquals(
                1,
                profile.getUserId()
        );

        assertEquals(
                10,
                profile.getId()
        );

        verify(
                profileDao
        ).updateProfile(
                profile
        );
    }
}