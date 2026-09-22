package com.bestbuds.dao;

import com.bestbuds.exception.DaoException;
import com.bestbuds.model.Profile;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileDao implements ProfileDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(
            JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Find a profile by its user ID
    @Override
    public Profile getProfileByUserId(
            int userId
    ) {

        Profile profile = null;

        String sql =
                "SELECT profile_id, user_id, first_name, last_name, "
                        + "birthday, address_line_1, address_line_2, "
                        + "city, state_abbr, zipcode "
                        + "FROM profiles "
                        + "WHERE user_id = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId
                    );

            if (results.next()) {
                profile =
                        mapRowToProfile(
                                results
                        );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve profile",
                    e
            );
        }

        return profile;
    }

    // Create a profile for a user
    @Override
    public Profile createProfile(
            Profile profile
    ) {

        String sql =
                "INSERT INTO profiles "
                        + "(user_id, first_name, last_name, birthday, "
                        + "address_line_1, address_line_2, city, "
                        + "state_abbr, zipcode) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) "
                        + "RETURNING profile_id";

        try {
            Integer profileId =
                    jdbcTemplate.queryForObject(
                            sql,
                            Integer.class,
                            profile.getUserId(),
                            profile.getFirstName(),
                            profile.getLastName(),
                            profile.getBirthday(),
                            profile.getAddressLine1(),
                            profile.getAddressLine2(),
                            profile.getCity(),
                            profile.getStateAbbr(),
                            profile.getZipcode()
                    );

            profile.setId(
                    profileId
            );

            return profile;

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to create profile",
                    e
            );
        }
    }

    // Update an existing profile
    @Override
    public Profile updateProfile(
            Profile profile
    ) {

        String sql =
                "UPDATE profiles "
                        + "SET first_name = ?, "
                        + "last_name = ?, "
                        + "birthday = ?, "
                        + "address_line_1 = ?, "
                        + "address_line_2 = ?, "
                        + "city = ?, "
                        + "state_abbr = ?, "
                        + "zipcode = ? "
                        + "WHERE user_id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    profile.getFirstName(),
                    profile.getLastName(),
                    profile.getBirthday(),
                    profile.getAddressLine1(),
                    profile.getAddressLine2(),
                    profile.getCity(),
                    profile.getStateAbbr(),
                    profile.getZipcode(),
                    profile.getUserId()
            );

            return getProfileByUserId(
                    profile.getUserId()
            );

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to update profile",
                    e
            );
        }
    }

    // Convert a database row into a Profile
    private Profile mapRowToProfile(
            SqlRowSet rowSet
    ) {

        Profile profile =
                new Profile();

        profile.setId(
                rowSet.getInt(
                        "profile_id"
                )
        );

        profile.setUserId(
                rowSet.getInt(
                        "user_id"
                )
        );

        profile.setFirstName(
                rowSet.getString(
                        "first_name"
                )
        );

        profile.setLastName(
                rowSet.getString(
                        "last_name"
                )
        );

        if (rowSet.getDate("birthday") != null) {
            profile.setBirthday(
                    rowSet.getDate(
                            "birthday"
                    ).toLocalDate()
            );
        }

        profile.setAddressLine1(
                rowSet.getString(
                        "address_line_1"
                )
        );

        profile.setAddressLine2(
                rowSet.getString(
                        "address_line_2"
                )
        );

        profile.setCity(
                rowSet.getString(
                        "city"
                )
        );

        profile.setStateAbbr(
                rowSet.getString(
                        "state_abbr"
                )
        );

        profile.setZipcode(
                rowSet.getString(
                        "zipcode"
                )
        );

        return profile;
    }
}