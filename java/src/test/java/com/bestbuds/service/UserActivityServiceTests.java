package com.bestbuds.service;

import com.bestbuds.dao.UserActivityDao;
import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserActivityServiceTests {

    @Mock
    private UserActivityDao userActivityDao;

    private UserActivityService userActivityService;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(
                this
        );

        userActivityService =
                new UserActivityService(
                        userActivityDao
                );
    }

    @Test
    public void createUserActivity_creates_supported_activity() {

        UserActivity activity =
                new UserActivity();

        when(
                userActivityDao.createUserActivity(
                        1,
                        UserActivityType.DISPENSARY_VIEW,
                        "test-dispensary"
                )
        ).thenReturn(
                activity
        );

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.DISPENSARY_VIEW,
                        "test-dispensary"
                );

        assertSame(
                activity,
                result
        );

        verify(
                userActivityDao
        ).createUserActivity(
                1,
                UserActivityType.DISPENSARY_VIEW,
                "test-dispensary"
        );
    }

    @Test
    public void createUserActivity_returns_null_for_unsupported_activity_type() {

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        "UNSUPPORTED_ACTIVITY",
                        "test-value"
                );

        assertNull(
                result
        );

        verify(
                userActivityDao,
                never()
        ).createUserActivity(
                1,
                "UNSUPPORTED_ACTIVITY",
                "test-value"
        );
    }

    @Test
    public void createUserActivity_returns_null_for_invalid_user() {

        UserActivity result =
                userActivityService.createUserActivity(
                        0,
                        UserActivityType.DISPENSARY_VIEW,
                        "test-dispensary"
                );

        assertNull(
                result
        );

        verify(
                userActivityDao,
                never()
        ).createUserActivity(
                0,
                UserActivityType.DISPENSARY_VIEW,
                "test-dispensary"
        );
    }

    @Test
    public void countUserActivitiesByType_returns_dao_count() {

        when(
                userActivityDao.countUserActivitiesByType(
                        1,
                        UserActivityType.ARTICLES_VIEW
                )
        ).thenReturn(
                4
        );

        int result =
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.ARTICLES_VIEW
                );

        assertEquals(
                4,
                result
        );
    }

    @Test
    public void countDistinctActivityValuesByType_returns_dao_count() {

        when(
                userActivityDao.countDistinctActivityValuesByType(
                        1,
                        UserActivityType.SAFETY_VIEW
                )
        ).thenReturn(
                3
        );

        int result =
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.SAFETY_VIEW
                        );

        assertEquals(
                3,
                result
        );
    }

    @Test
    public void createUserActivity_creates_valid_app_visit_date() {

        UserActivity activity =
                new UserActivity();

        when(
                userActivityDao.createUserActivity(
                        1,
                        UserActivityType.APP_VISIT,
                        "2026-09-29"
                )
        ).thenReturn(
                activity
        );

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.APP_VISIT,
                        "2026-09-29"
                );

        assertSame(
                activity,
                result
        );

        verify(
                userActivityDao
        ).createUserActivity(
                1,
                UserActivityType.APP_VISIT,
                "2026-09-29"
        );
    }


    @Test
    public void createUserActivity_returns_null_for_invalid_app_visit_date() {

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.APP_VISIT,
                        "2026-02-30"
                );

        assertNull(
                result
        );

        verify(
                userActivityDao,
                never()
        ).createUserActivity(
                1,
                UserActivityType.APP_VISIT,
                "2026-02-30"
        );
    }

    @Test
    public void createUserActivity_creates_valid_products_view() {

        UserActivity activity =
                new UserActivity();

        when(
                userActivityDao.createUserActivity(
                        1,
                        UserActivityType.PRODUCTS_VIEW,
                        "flower"
                )
        ).thenReturn(
                activity
        );

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.PRODUCTS_VIEW,
                        "flower"
                );

        assertSame(
                activity,
                result
        );

        verify(
                userActivityDao
        ).createUserActivity(
                1,
                UserActivityType.PRODUCTS_VIEW,
                "flower"
        );
    }

    @Test
    public void createUserActivity_returns_null_for_invalid_products_value() {

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.PRODUCTS_VIEW,
                        "banana"
                );

        assertNull(
                result
        );

        verify(
                userActivityDao,
                never()
        ).createUserActivity(
                1,
                UserActivityType.PRODUCTS_VIEW,
                "banana"
        );
    }

    @Test
    public void createUserActivity_returns_null_for_invalid_safety_value() {

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.SAFETY_VIEW,
                        "banana"
                );

        assertNull(
                result
        );

        verify(
                userActivityDao,
                never()
        ).createUserActivity(
                1,
                UserActivityType.SAFETY_VIEW,
                "banana"
        );
    }

    @Test
    public void createUserActivity_returns_null_for_invalid_education_value() {

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.EDUCATION_VIEW,
                        "made-up-topic"
                );

        assertNull(
                result
        );

        verify(
                userActivityDao,
                never()
        ).createUserActivity(
                1,
                UserActivityType.EDUCATION_VIEW,
                "made-up-topic"
        );
    }

    @Test
    public void createUserActivity_returns_null_for_blank_activity_value() {

        UserActivity result =
                userActivityService.createUserActivity(
                        1,
                        UserActivityType.AREA_SEARCH,
                        "   "
                );

        assertNull(
                result
        );

        verify(
                userActivityDao,
                never()
        ).createUserActivity(
                1,
                UserActivityType.AREA_SEARCH,
                "   "
        );
    }

    @Test
    public void countDistinctActivityTypes_returns_dao_count() {

        when(
                userActivityDao.countDistinctActivityTypes(
                        1
                )
        ).thenReturn(
                4
        );

        int result =
                userActivityService.countDistinctActivityTypes(
                        1
                );

        assertEquals(
                4,
                result
        );
    }
}