package com.bestbuds.service;

import com.bestbuds.dao.UserActivityDao;
import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityType;

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


    // Record an activity completed by a user
    public UserActivity createUserActivity(
            int userId,
            String activityType,
            String activityValue
    ) {

        if (
                userId <= 0
                || !UserActivityType.isValidValue(
                        activityType,
                        activityValue
                )
        ) {
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


    // Count activities of a specific type completed by a user
    public int countUserActivitiesByType(
            int userId,
            String activityType
    ) {

        return userActivityDao.countUserActivitiesByType(
                userId,
                activityType
        );
    }


    // Count unique activity values of a specific type
    public int countDistinctActivityValuesByType(
            int userId,
            String activityType
    ) {

        return userActivityDao
                .countDistinctActivityValuesByType(
                        userId,
                        activityType
                );
    }


    // Count unique activity types completed by a user
    public int countDistinctActivityTypes(
            int userId
    ) {

        return userActivityDao.countDistinctActivityTypes(
                userId
        );
    }
}