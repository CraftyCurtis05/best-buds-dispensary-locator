package com.bestbuds.dao;

import java.util.List;

import com.bestbuds.model.RegisterUserDto;
import com.bestbuds.model.User;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
