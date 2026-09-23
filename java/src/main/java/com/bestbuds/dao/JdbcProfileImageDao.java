package com.bestbuds.dao;

import com.bestbuds.exception.DaoException;
import com.bestbuds.model.ProfileImage;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileImageDao implements ProfileImageDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProfileImageDao(
            JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Find a profile image by its user ID
    @Override
    public ProfileImage getProfileImageByUserId(
            int userId
    ) {

        ProfileImage profileImage = null;

        String sql =
                "SELECT image_id, user_id, image_data, content_type "
                        + "FROM profile_images "
                        + "WHERE user_id = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId
                    );

            if (results.next()) {
                profileImage =
                        mapRowToProfileImage(
                                results
                        );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve profile image",
                    e
            );
        }

        return profileImage;
    }

    // Create a profile image for a user
    @Override
    public ProfileImage createProfileImage(
            ProfileImage profileImage
    ) {

        String sql =
                "INSERT INTO profile_images "
                        + "(user_id, image_data, content_type) "
                        + "VALUES (?, ?, ?) "
                        + "RETURNING image_id";

        try {
            Integer imageId =
                    jdbcTemplate.queryForObject(
                            sql,
                            Integer.class,
                            profileImage.getUserId(),
                            profileImage.getImageData(),
                            profileImage.getContentType()
                    );

            profileImage.setId(
                    imageId
            );

            return profileImage;

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to create profile image",
                    e
            );
        }
    }

    // Update an existing profile image
    @Override
    public ProfileImage updateProfileImage(
            ProfileImage profileImage
    ) {

        String sql =
                "UPDATE profile_images "
                        + "SET image_data = ?, "
                        + "content_type = ? "
                        + "WHERE user_id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    profileImage.getImageData(),
                    profileImage.getContentType(),
                    profileImage.getUserId()
            );

            return getProfileImageByUserId(
                    profileImage.getUserId()
            );

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to update profile image",
                    e
            );
        }
    }

    // Delete a user's profile image
    @Override
    public void deleteProfileImageByUserId(
            int userId
    ) {

        String sql =
                "DELETE FROM profile_images "
                        + "WHERE user_id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    userId
            );

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to delete profile image",
                    e
            );
        }
    }

    // Convert a database row into a ProfileImage
    private ProfileImage mapRowToProfileImage(
            SqlRowSet rowSet
    ) {

        ProfileImage profileImage =
                new ProfileImage();

        profileImage.setId(
                rowSet.getInt(
                        "image_id"
                )
        );

        profileImage.setUserId(
                rowSet.getInt(
                        "user_id"
                )
        );

        profileImage.setImageData(
                (byte[]) rowSet.getObject(
                        "image_data"
                )
        );

        profileImage.setContentType(
                rowSet.getString(
                        "content_type"
                )
        );

        return profileImage;
    }
}