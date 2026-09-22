package com.bestbuds.dao;

import com.bestbuds.model.Profile;

public interface ProfileDao {

    Profile getProfileByUserId(int userId);

    Profile createProfile(Profile profile);

    Profile updateProfile(Profile profile);
}