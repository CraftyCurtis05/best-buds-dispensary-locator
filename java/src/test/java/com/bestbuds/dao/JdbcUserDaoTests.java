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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
                        "newuser@bestbuds.local",
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
                        "newuser@bestbuds.local",
                        "password123"
                )
        );
    }

    @Test
    public void createUser_with_null_email_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.createUser(
                        "newuser",
                        null,
                        "password123"
                )
        );
    }

    @Test
    public void createUser_with_blank_email_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.createUser(
                        "newuser",
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
                        "newuser@bestbuds.local",
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
                        "newuser@bestbuds.local",
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
                        "newuser@bestbuds.local",
                        "password123"
                )
        );
    }

    @Test
    public void createUser_creates_user_with_default_role() {

        User createdUser =
                sut.createUser(
                        "newuser",
                        "newuser@bestbuds.local",
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
                        "newuser@bestbuds.local",
                        "password123"
                );

        assertEquals(
                "newuser",
                createdUser.getUsername()
        );
    }

    @Test
    public void createUser_normalizes_email() {

        User createdUser =
                sut.createUser(
                        "newuser",
                        "  NewUser@BestBuds.Local  ",
                        "password123"
                );

        assertEquals(
                "newuser@bestbuds.local",
                createdUser.getEmail()
        );
    }

    @Test
    public void createUser_with_existing_email_throws_exception() {

        assertThrows(
                UserAlreadyExistsException.class,
                () -> sut.createUser(
                        "newuser",
                        "user1@bestbuds.local",
                        "password123"
                )
        );
    }

    @Test
    public void updateEmail_updates_email() {

        sut.updateEmail(
                1,
                "updated@bestbuds.local"
        );

        User updatedUser =
                sut.getUserById(
                        1
                );

        assertEquals(
                "updated@bestbuds.local",
                updatedUser.getEmail()
        );
    }

    @Test
    public void updateEmail_normalizes_email() {

        sut.updateEmail(
                1,
                "  Updated@BestBuds.Local  "
        );

        User updatedUser =
                sut.getUserById(
                        1
                );

        assertEquals(
                "updated@bestbuds.local",
                updatedUser.getEmail()
        );
    }

    @Test
    public void updateEmail_with_existing_email_throws_exception() {

        assertThrows(
                UserAlreadyExistsException.class,
                () -> sut.updateEmail(
                        1,
                        "user2@bestbuds.local"
                )
        );
    }

    @Test
    public void updateEmail_with_null_email_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.updateEmail(
                        1,
                        null
                )
        );
    }

    @Test
    public void updateEmail_with_blank_email_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.updateEmail(
                        1,
                        "   "
                )
        );
    }

    @Test
    public void updateUsername_updates_username() {

        sut.updateUsername(
                1,
                "updateduser"
        );

        User updatedUser =
                sut.getUserById(
                        1
                );

        assertEquals(
                "updateduser",
                updatedUser.getUsername()
        );
    }

    @Test
    public void updateUsername_normalizes_username() {

        sut.updateUsername(
                1,
                "  UpdatedUser  "
        );

        User updatedUser =
                sut.getUserById(
                        1
                );

        assertEquals(
                "updateduser",
                updatedUser.getUsername()
        );
    }

    @Test
    public void updateUsername_with_existing_username_throws_exception() {

        assertThrows(
                UserAlreadyExistsException.class,
                () -> sut.updateUsername(
                        1,
                        "user2"
                )
        );
    }

    @Test
    public void updateUsername_with_null_username_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.updateUsername(
                        1,
                        null
                )
        );
    }

    @Test
    public void updateUsername_with_blank_username_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.updateUsername(
                        1,
                        "   "
                )
        );
    }

    @Test
    public void updatePassword_updates_and_encodes_password() {

        sut.updatePassword(
                1,
                "newPassword456"
        );

        User updatedUser =
                sut.getUserById(
                        1
                );

        assertNotEquals(
                "newPassword456",
                updatedUser.getPassword()
        );

        assertTrue(
                passwordEncoder.matches(
                        "newPassword456",
                        updatedUser.getPassword()
                )
        );
    }

    @Test
    public void updatePassword_with_null_password_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.updatePassword(
                        1,
                        null
                )
        );
    }

    @Test
    public void updatePassword_with_blank_password_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.updatePassword(
                        1,
                        "   "
                )
        );
    }

    @Test
    public void createUser_hashes_password() {

        String password =
                "password123";

        User createdUser =
                sut.createUser(
                        "newuser",
                        "newuser@bestbuds.local",
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
                        "newuser@bestbuds.local",
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

    @Test
    public void getUserByEmail_returns_user() {

        User user =
                sut.getUserByEmail(
                        "user1@bestbuds.local"
                );

        assertNotNull(
                user
        );

        assertEquals(
                1,
                user.getId()
        );

        assertEquals(
                "user1",
                user.getUsername()
        );

        assertEquals(
                "user1@bestbuds.local",
                user.getEmail()
        );
    }

    @Test
    public void getUserByEmail_is_case_insensitive() {

        User user =
                sut.getUserByEmail(
                        "USER1@BESTBUDS.LOCAL"
                );

        assertNotNull(
                user
        );

        assertEquals(
                "user1@bestbuds.local",
                user.getEmail()
        );
    }

    @Test
    public void getUserByEmail_returns_null_when_user_does_not_exist() {

        User user =
                sut.getUserByEmail(
                        "missing@bestbuds.local"
                );

        assertNull(
                user
        );
    }

    @Test
    public void getUserByEmail_with_blank_email_throws_exception() {

        assertThrows(
                IllegalArgumentException.class,
                () -> sut.getUserByEmail(
                        "   "
                )
        );
    }
}