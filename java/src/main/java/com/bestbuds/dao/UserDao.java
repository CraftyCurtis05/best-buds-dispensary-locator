package com.bestbuds.dao;

import com.bestbuds.model.User;

public interface UserDao {

    User getUserById(int userId);

    User getUserByUsername(String username);

    User createUser(
            String username,
            String password
    );

    void confirmAge(int userId);
}