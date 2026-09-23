package com.bestbuds.dao;

import com.bestbuds.model.ProfileImage;

public interface ProfileImageDao {

    ProfileImage getProfileImageByUserId(int userId);

    ProfileImage createProfileImage(ProfileImage profileImage);

    ProfileImage updateProfileImage(ProfileImage profileImage);

    void deleteProfileImageByUserId(int userId);
}