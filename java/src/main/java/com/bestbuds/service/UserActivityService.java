package com.bestbuds.service;

import com.bestbuds.dao.UserActivityDao;
import com.bestbuds.model.UserActivity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityService {

    private final UserActivityDao userActivityDao;

    public UserActivityService(
            UserActivityDao userActivityDao
    ) {
        this.userActivityDao = userActivityDao;
    }


    public UserActivity createUserActivity(
            int userId,
            String activityType,
            String activityValue
    ) {

        if (userId <= 0
                || activityType == null
                || activityType.isBlank()) {
            return null;
        }

        return userActivityDao.createUserActivity(
                userId,
                activityType,
                activityValue
        );
    }


    // Get all activities completed by a user
    public List<UserActivity> getUserActivities(
            int userId
    ) {
        return userActivityDao.getUserActivities(
                userId
        );
    }


    // Get activities of a specific type completed by a user
    public List<UserActivity> getUserActivitiesByType(
            int userId,
            String activityType
    ) {
        return userActivityDao.getUserActivitiesByType(
                userId,
                activityType
        );
    }
}