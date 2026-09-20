package com.dao;

import java.util.List;

import com.model.RegisterUserDto;
import com.model.User;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
