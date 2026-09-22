package com.bestbuds.dao;

import com.bestbuds.model.User;
import com.bestbuds.exception.DaoException;
import com.bestbuds.exception.UserAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JdbcUserDaoTests extends BaseDaoTests {

    protected static final User USER_1 =
            new User(
                    1,
                    "user1",
                    "password123",
                    "ROLE_USER"
            );

    protected static final User USER_2 =
            new User(
                    2,
                    "user2",
                    "password456",
                    "ROLE_USER"
            );

    private JdbcUserDao sut;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {

        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(dataSource);

        passwordEncoder =
                new BCryptPasswordEncoder();

        sut = new JdbcUserDao(
                jdbcTemplate,
                passwordEncoder
        );
    }

    @Test
    public void getUserByUsername_given_null_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.getUserByUsername(null)
        );
    }

    @Test
    public void getUserByUsername_given_blank_username_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.getUserByUsername("   ")
        );
    }

    @Test
    public void getUserByUsername_given_invalid_username_returns_null() {

        User actualUser =
                sut.getUserByUsername("invalid");

        assertNull(actualUser);
    }

    @Test
    public void getUserByUsername_given_valid_username_returns_user() {

        User actualUser =
                sut.getUserByUsername(
                        USER_1.getUsername()
                );

        assertEquals(
                USER_1,
                actualUser
        );
    }

    @Test
    public void getUserByUsername_is_case_insensitive() {

        User actualUser =
                sut.getUserByUsername("USER1");

        assertEquals(
                USER_1,
                actualUser
        );
    }

    @Test
    public void getUserById_given_invalid_user_id_returns_null() {

        User actualUser =
                sut.getUserById(-1);

        assertNull(actualUser);
    }

    @Test
    public void getUserById_given_valid_user_id_returns_user() {

        User actualUser =
                sut.getUserById(
                        USER_1.getId()
                );

        assertEquals(
                USER_1,
                actualUser
        );
    }

    @Test
    public void createUser_with_null_username_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.createUser(
                        null,
                        "password123"
                )
        );
    }

    @Test
    public void createUser_with_blank_username_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.createUser(
                        "   ",
                        "password123"
                )
        );
    }

    @Test
    public void createUser_with_null_password_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.createUser(
                        "newuser",
                        null
                )
        );
    }

    @Test
    public void createUser_with_blank_password_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.createUser(
                        "newuser",
                        "   "
                )
        );
    }

    @Test
    public void createUser_with_existing_username_throws_exception() {

        assertThrows(
                UserAlreadyExistsException.class,
                () -> sut.createUser(
                        USER_1.getUsername(),
                        "password123"
                )
        );
    }

    @Test
    public void createUser_creates_user_with_default_role() {

        User createdUser =
                sut.createUser(
                        "newuser",
                        "password123"
                );

        assertNotNull(createdUser);

        assertEquals(
                "newuser",
                createdUser.getUsername()
        );

        assertTrue(
                createdUser
                        .getAuthorities()
                        .stream()
                        .anyMatch(authority ->
                                authority
                                        .getName()
                                        .equals("ROLE_USER")
                        )
        );
    }

    @Test
    public void createUser_normalizes_username() {

        User createdUser =
                sut.createUser(
                        "  NewUser  ",
                        "password123"
                );

        assertEquals(
                "newuser",
                createdUser.getUsername()
        );
    }

    @Test
    public void createUser_hashes_password() {

        String password =
                "password123";

        User createdUser =
                sut.createUser(
                        "newuser",
                        password
                );

        assertNotNull(
                createdUser.getPassword()
        );

        assertFalse(
                password.equals(
                        createdUser.getPassword()
                )
        );

        assertTrue(
                passwordEncoder.matches(
                        password,
                        createdUser.getPassword()
                )
        );
    }

    @Test
    public void createUser_sets_age_confirmed_to_false() {

        User createdUser =
                sut.createUser(
                        "newuser",
                        "password123"
                );

        assertFalse(
                createdUser.isAgeConfirmed()
        );
    }

    @Test
    public void confirmAge_sets_age_confirmed_to_true() {

        User user =
                sut.getUserByUsername(
                        "user1"
                );

        assertFalse(
                user.isAgeConfirmed()
        );

        sut.confirmAge(
                user.getId()
        );

        User updatedUser =
                sut.getUserById(
                        user.getId()
                );

        assertTrue(
                updatedUser.isAgeConfirmed()
        );
    }

    @Test
    public void confirmAge_with_invalid_user_id_throws_dao_exception() {

        assertThrows(
                DaoException.class,
                () -> sut.confirmAge(
                        999999
                )
        );
    }
}