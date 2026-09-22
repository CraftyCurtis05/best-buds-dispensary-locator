package com.bestbuds.dao;

import com.bestbuds.model.User;

public interface UserDao {

    User getUserById(
            int userId
    );

    User getUserByUsername(
            String username
    );

    User getUserByEmail(
            String email
    );

    User createUser(
            String username,
            String email,
            String password
    );

    void updateEmail(
            int userId,
            String email
    );

    void updateUsername(
            int userId,
            String username
    );

    void updatePassword(
            int userId,
            String password
    );

    void confirmAge(
            int userId
    );
}