package com.bestbuds.dao;

import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JdbcUserActivityDaoTests
        extends BaseDaoTests {

    private JdbcUserActivityDao jdbcUserActivityDao;

    @BeforeEach
    public void setup() {

        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(
                        dataSource
                );

        jdbcUserActivityDao =
                new JdbcUserActivityDao(
                        jdbcTemplate
                );
    }

    @Test
    public void createUserActivity_creates_activity() {

        UserActivity activity =
                jdbcUserActivityDao.createUserActivity(
                        1,
                        UserActivityType.DISPENSARY_VIEW,
                        "test-dispensary"
                );

        assertNotNull(
                activity
        );

        assertEquals(
                1,
                activity.getUserId()
        );

        assertEquals(
                UserActivityType.DISPENSARY_VIEW,
                activity.getActivityType()
        );

        assertEquals(
                "test-dispensary",
                activity.getActivityValue()
        );

        assertNotNull(
                activity.getActivityDate()
        );

        assertNotNull(
                activity.getCreatedAt()
        );
    }

    @Test
    public void countUserActivitiesByType_counts_matching_activities() {

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.ARTICLES_VIEW,
                "article-one"
        );

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.ARTICLES_VIEW,
                "article-two"
        );

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.SAFETY_VIEW,
                "cbd"
        );

        int activityCount =
                jdbcUserActivityDao.countUserActivitiesByType(
                        1,
                        UserActivityType.ARTICLES_VIEW
                );

        assertEquals(
                2,
                activityCount
        );
    }

    @Test
    public void countDistinctActivityValuesByType_counts_unique_values() {

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.ARTICLES_VIEW,
                "article-one"
        );

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.ARTICLES_VIEW,
                "article-one"
        );

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.ARTICLES_VIEW,
                "article-two"
        );

        int activityCount =
                jdbcUserActivityDao
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.ARTICLES_VIEW
                        );

        assertEquals(
                2,
                activityCount
        );
    }

    @Test
    public void countDistinctActivityTypes_counts_unique_types() {

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.APP_VISIT,
                "best-buds"
        );

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.PRODUCTS_VIEW,
                "flower"
        );

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.SAFETY_VIEW,
                "cbd"
        );

        jdbcUserActivityDao.createUserActivity(
                1,
                UserActivityType.PRODUCTS_VIEW,
                "edible"
        );

        int activityCount =
                jdbcUserActivityDao.countDistinctActivityTypes(
                        1
                );

        assertEquals(
                3,
                activityCount
        );
    }
}