package com.bestbuds.service;

import com.bestbuds.model.User;
import com.bestbuds.dao.UserDao;
import com.bestbuds.exception.AgeConfirmationRequiredException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AgeConfirmationServiceTests {

    private UserDao userDao;
    private AgeConfirmationService sut;

    @BeforeEach
    public void setup() {

        userDao =
                mock(UserDao.class);

        sut =
                new AgeConfirmationService(
                        userDao
                );
    }

    @Test
    public void confirmAge_confirms_age_for_user() {

        sut.confirmAge(
                1
        );

        verify(userDao).confirmAge(
                1
        );
    }

    @Test
    public void hasConfirmedAge_returns_false_when_age_is_not_confirmed() {

        User user =
                new User();

        user.setAgeConfirmed(
                false
        );

        boolean result =
                sut.hasConfirmedAge(
                        user
                );

        assertFalse(
                result
        );
    }

    @Test
    public void hasConfirmedAge_returns_true_when_age_is_confirmed() {

        User user =
                new User();

        user.setAgeConfirmed(
                true
        );

        boolean result =
                sut.hasConfirmedAge(
                        user
                );

        assertTrue(
                result
        );
    }

    @Test
    public void requireAgeConfirmation_throws_exception_when_age_is_not_confirmed() {

        User user =
                new User();

        user.setAgeConfirmed(
                false
        );

        assertThrows(
                AgeConfirmationRequiredException.class,
                () -> sut.requireAgeConfirmation(
                        user
                )
        );
    }

    @Test
    public void requireAgeConfirmation_allows_user_when_age_is_confirmed() {

        User user =
                new User();

        user.setAgeConfirmed(
                true
        );

        assertDoesNotThrow(
                () -> sut.requireAgeConfirmation(
                        user
                )
        );
    }
}