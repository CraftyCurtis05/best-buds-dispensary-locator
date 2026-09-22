package com.bestbuds.service;

import com.bestbuds.model.User;
import com.bestbuds.dao.UserDao;
import com.bestbuds.exception.AgeConfirmationRequiredException;

import org.springframework.stereotype.Service;

@Service
public class AgeConfirmationService {

    private final UserDao userDao;

    public AgeConfirmationService(
            UserDao userDao
    ) {
        this.userDao = userDao;
    }

    // Confirm that the user meets the app's age requirement
    public void confirmAge(int userId) {
        userDao.confirmAge(
                userId
        );
    }

    // Check whether the user has confirmed the app's age requirement
    public boolean hasConfirmedAge(
            User user
    ) {
        return user.isAgeConfirmed();
    }

    // Require the user to confirm the app's age requirement
    public void requireAgeConfirmation(
            User user
    ) {

        if (!hasConfirmedAge(user)) {
            throw new AgeConfirmationRequiredException(
                    "Age confirmation is required."
            );
        }
    }
}