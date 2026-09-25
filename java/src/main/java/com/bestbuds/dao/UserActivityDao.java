package com.bestbuds.dao;

import com.bestbuds.model.UserActivity;

import java.util.List;

public interface UserActivityDao {

    // Record an activity completed by a user
    UserActivity createUserActivity(
            int userId,
            String activityType,
            String activityValue
    );

    // Get all activities completed by a user
    List<UserActivity> getUserActivities(
            int userId
    );

    // Get activities of a specific type completed by a user
    List<UserActivity> getUserActivitiesByType(
            int userId,
            String activityType
    );

}