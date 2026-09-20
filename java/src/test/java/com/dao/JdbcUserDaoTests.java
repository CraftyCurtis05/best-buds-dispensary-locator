package com.dao;

import com.exception.DaoException;
import com.model.RegisterUserDto;
import com.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JdbcUserDaoTests extends BaseDaoTests {

    protected static final User USER_1 =
            new User(1, "user1", "user1", "ROLE_USER");

    protected static final User USER_2 =
            new User(2, "user2", "user2", "ROLE_USER");

    private static final User USER_3 =
            new User(3, "user3", "user3", "ROLE_USER");

    private JdbcUserDao sut;

    @BeforeEach
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

    @Test
    public void getUserByUsername_given_null_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.getUserByUsername(null)
        );
    }

    @Test
    public void getUserByUsername_given_invalid_username_returns_null() {

        User actualUser = sut.getUserByUsername("invalid");

        assertNull(actualUser);
    }

    @Test
    public void getUserByUsername_given_valid_user_returns_user() {

        User actualUser = sut.getUserByUsername(USER_1.getUsername());

        assertEquals(USER_1, actualUser);
    }

    @Test
    public void getUserById_given_invalid_user_id_returns_null() {

        User actualUser = sut.getUserById(-1);

        assertNull(actualUser);
    }

    @Test
    public void getUserById_given_valid_user_id_returns_user() {

        User actualUser = sut.getUserById(USER_1.getId());

        assertEquals(USER_1, actualUser);
    }

    @Test
    public void getUsers_returns_all_users() {

        List<User> users = sut.getUsers();

        assertNotNull(users);
        assertEquals(3, users.size());
        assertEquals(USER_1, users.get(0));
        assertEquals(USER_2, users.get(1));
        assertEquals(USER_3, users.get(2));
    }

    @Test
    public void createUser_with_null_username_throws_exception() {

        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername(null);
        registerUserDto.setPassword(USER_3.getPassword());
        registerUserDto.setRole("ROLE_USER");

        assertThrows(
                DaoException.class,
                () -> sut.createUser(registerUserDto)
        );
    }

    @Test
    public void createUser_with_existing_username_throws_exception() {

        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername(USER_1.getUsername());
        registerUserDto.setPassword(USER_3.getPassword());
        registerUserDto.setRole("ROLE_USER");

        assertThrows(
                DaoException.class,
                () -> sut.createUser(registerUserDto)
        );
    }

    @Test
    public void createUser_with_null_password_throws_exception() {

        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername(USER_3.getUsername());
        registerUserDto.setPassword(null);
        registerUserDto.setRole("ROLE_USER");

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.createUser(registerUserDto)
        );
    }

    @Test
    public void createUser_creates_a_user() {

        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername("new");
        registerUserDto.setPassword("user");
        registerUserDto.setRole("ROLE_USER");

        User createdUser = sut.createUser(registerUserDto);

        assertNotNull(createdUser);

        User retrievedUser =
                sut.getUserByUsername(createdUser.getUsername());

        assertEquals(createdUser, retrievedUser);
    }
}
