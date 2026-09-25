package com.bestbuds.service;

import com.bestbuds.dao.ProfileDao;
import com.bestbuds.model.Profile;

import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileDao profileDao;

    public ProfileService(
            ProfileDao profileDao
    ) {
        this.profileDao = profileDao;
    }

    // Get a user's profile
    public Profile getProfile(
            int userId
    ) {
        return profileDao.getProfileByUserId(
                userId
        );
    }

    // Create or update a user's profile
    public Profile saveProfile(
            int userId,
            Profile profile
    ) {

        profile.setUserId(
                userId
        );

        Profile existingProfile =
                profileDao.getProfileByUserId(
                        userId
                );

        if (existingProfile == null) {
            return profileDao.createProfile(
                    profile
            );
        }

        profile.setId(
                existingProfile.getId()
        );

        // Keep the original birthday once it has been set
        if (existingProfile.getBirthday() != null) {
            profile.setBirthday(
                    existingProfile.getBirthday()
            );
        }

        return profileDao.updateProfile(
                profile
        );
    }
}