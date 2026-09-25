package com.bestbuds.dao;

import com.bestbuds.exception.DaoException;
import com.bestbuds.model.UserActivity;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserActivityDao implements UserActivityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserActivityDao(
            JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Record an activity completed by a user
    @Override
    public UserActivity createUserActivity(
            int userId,
            String activityType,
            String activityValue
    ) {

        String sql =
                "INSERT INTO user_activities "
                        + "(user_id, activity_type, activity_value) "
                        + "VALUES (?, ?, ?) "
                        + "RETURNING activity_id";

        try {
            Integer activityId =
                    jdbcTemplate.queryForObject(
                            sql,
                            Integer.class,
                            userId,
                            activityType,
                            activityValue
                    );

            if (activityId == null) {
                return null;
            }

            return getUserActivityById(
                    activityId
            );

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to create user activity",
                    e
            );
        }
    }


    // Find all activities completed by a user
    @Override
    public List<UserActivity> getUserActivities(
            int userId
    ) {

        List<UserActivity> userActivities =
                new ArrayList<>();

        String sql =
                "SELECT activity_id, user_id, activity_type, "
                        + "activity_value, activity_date, created_at "
                        + "FROM user_activities "
                        + "WHERE user_id = ? "
                        + "ORDER BY created_at DESC";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId
                    );

            while (results.next()) {
                userActivities.add(
                        mapRowToUserActivity(
                                results
                        )
                );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve user activities",
                    e
            );
        }

        return userActivities;
    }


    // Find activities of a specific type completed by a user
    @Override
    public List<UserActivity> getUserActivitiesByType(
            int userId,
            String activityType
    ) {

        List<UserActivity> userActivities =
                new ArrayList<>();

        String sql =
                "SELECT activity_id, user_id, activity_type, "
                        + "activity_value, activity_date, created_at "
                        + "FROM user_activities "
                        + "WHERE user_id = ? "
                        + "AND activity_type = ? "
                        + "ORDER BY created_at DESC";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId,
                            activityType
                    );

            while (results.next()) {
                userActivities.add(
                        mapRowToUserActivity(
                                results
                        )
                );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve user activities by type",
                    e
            );
        }

        return userActivities;
    }


    // Find a user activity by its ID
    private UserActivity getUserActivityById(
            int activityId
    ) {

        UserActivity userActivity = null;

        String sql =
                "SELECT activity_id, user_id, activity_type, "
                        + "activity_value, activity_date, created_at "
                        + "FROM user_activities "
                        + "WHERE activity_id = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            activityId
                    );

            if (results.next()) {
                userActivity =
                        mapRowToUserActivity(
                                results
                        );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve user activity",
                    e
            );
        }

        return userActivity;
    }


    // Convert a database row into a UserActivity
    private UserActivity mapRowToUserActivity(
            SqlRowSet rowSet
    ) {

        UserActivity userActivity =
                new UserActivity();

        userActivity.setActivityId(
                rowSet.getInt(
                        "activity_id"
                )
        );

        userActivity.setUserId(
                rowSet.getInt(
                        "user_id"
                )
        );

        userActivity.setActivityType(
                rowSet.getString(
                        "activity_type"
                )
        );

        userActivity.setActivityValue(
                rowSet.getString(
                        "activity_value"
                )
        );

        if (rowSet.getDate("activity_date") != null) {
            userActivity.setActivityDate(
                    rowSet.getDate(
                            "activity_date"
                    ).toLocalDate()
            );
        }

        if (rowSet.getTimestamp("created_at") != null) {
            userActivity.setCreatedAt(
                    rowSet.getTimestamp(
                            "created_at"
                    ).toLocalDateTime()
            );
        }

        return userActivity;
    }
}