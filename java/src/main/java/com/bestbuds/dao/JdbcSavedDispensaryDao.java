package com.bestbuds.dao;

import com.bestbuds.exception.DaoException;
import com.bestbuds.model.SavedDispensary;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSavedDispensaryDao implements SavedDispensaryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSavedDispensaryDao(
            JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Find all saved dispensaries for a user
    @Override
    public List<SavedDispensary> getSavedDispensariesByUserId(
            int userId
    ) {

        List<SavedDispensary> savedDispensaries =
                new ArrayList<>();

        String sql =
                "SELECT saved_dispensary_id, user_id, yelp_business_id, "
                        + "name, image_url, address, city, state_abbr, "
                        + "zipcode, latitude, longitude, rating, saved_at "
                        + "FROM saved_dispensaries "
                        + "WHERE user_id = ? "
                        + "ORDER BY saved_at DESC";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId
                    );

            while (results.next()) {
                savedDispensaries.add(
                        mapRowToSavedDispensary(
                                results
                        )
                );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve saved dispensaries",
                    e
            );
        }

        return savedDispensaries;
    }

    // Find a saved dispensary by its user and Yelp business ID
    @Override
    public SavedDispensary getSavedDispensaryByUserIdAndYelpBusinessId(
            int userId,
            String yelpBusinessId
    ) {

        SavedDispensary savedDispensary = null;

        String sql =
                "SELECT saved_dispensary_id, user_id, yelp_business_id, "
                        + "name, image_url, address, city, state_abbr, "
                        + "zipcode, latitude, longitude, rating, saved_at "
                        + "FROM saved_dispensaries "
                        + "WHERE user_id = ? "
                        + "AND yelp_business_id = ?";

        try {
            SqlRowSet results =
                    jdbcTemplate.queryForRowSet(
                            sql,
                            userId,
                            yelpBusinessId
                    );

            if (results.next()) {
                savedDispensary =
                        mapRowToSavedDispensary(
                                results
                        );
            }

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to retrieve saved dispensary",
                    e
            );
        }

        return savedDispensary;
    }

    // Save a dispensary for a user
    @Override
    public SavedDispensary createSavedDispensary(
            SavedDispensary savedDispensary
    ) {

        String sql =
                "INSERT INTO saved_dispensaries "
                        + "(user_id, yelp_business_id, name, image_url, "
                        + "address, city, state_abbr, zipcode, latitude, "
                        + "longitude, rating) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                        + "RETURNING saved_dispensary_id";

        try {
            Integer savedDispensaryId =
                    jdbcTemplate.queryForObject(
                            sql,
                            Integer.class,
                            savedDispensary.getUserId(),
                            savedDispensary.getYelpBusinessId(),
                            savedDispensary.getName(),
                            savedDispensary.getImageUrl(),
                            savedDispensary.getAddress(),
                            savedDispensary.getCity(),
                            savedDispensary.getStateAbbr(),
                            savedDispensary.getZipcode(),
                            savedDispensary.getLatitude(),
                            savedDispensary.getLongitude(),
                            savedDispensary.getRating()
                    );

            savedDispensary.setId(
                    savedDispensaryId
            );

            return getSavedDispensaryByUserIdAndYelpBusinessId(
                    savedDispensary.getUserId(),
                    savedDispensary.getYelpBusinessId()
            );

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to save dispensary",
                    e
            );
        }
    }

    // Delete a saved dispensary for a user
    @Override
    public void deleteSavedDispensary(
            int userId,
            String yelpBusinessId
    ) {

        String sql =
                "DELETE FROM saved_dispensaries "
                        + "WHERE user_id = ? "
                        + "AND yelp_business_id = ?";

        try {
            jdbcTemplate.update(
                    sql,
                    userId,
                    yelpBusinessId
            );

        } catch (DataAccessException e) {
            throw new DaoException(
                    "Unable to delete saved dispensary",
                    e
            );
        }
    }

    // Convert a database row into a SavedDispensary
    private SavedDispensary mapRowToSavedDispensary(
            SqlRowSet rowSet
    ) {

        SavedDispensary savedDispensary =
                new SavedDispensary();

        savedDispensary.setId(
                rowSet.getInt(
                        "saved_dispensary_id"
                )
        );

        savedDispensary.setUserId(
                rowSet.getInt(
                        "user_id"
                )
        );

        savedDispensary.setYelpBusinessId(
                rowSet.getString(
                        "yelp_business_id"
                )
        );

        savedDispensary.setName(
                rowSet.getString(
                        "name"
                )
        );

        savedDispensary.setImageUrl(
                rowSet.getString(
                        "image_url"
                )
        );

        savedDispensary.setAddress(
                rowSet.getString(
                        "address"
                )
        );

        savedDispensary.setCity(
                rowSet.getString(
                        "city"
                )
        );

        savedDispensary.setStateAbbr(
                rowSet.getString(
                        "state_abbr"
                )
        );

        savedDispensary.setZipcode(
                rowSet.getString(
                        "zipcode"
                )
        );

        savedDispensary.setLatitude(
                rowSet.getBigDecimal(
                        "latitude"
                )
        );

        savedDispensary.setLongitude(
                rowSet.getBigDecimal(
                        "longitude"
                )
        );

        savedDispensary.setRating(
                rowSet.getBigDecimal(
                        "rating"
                )
        );

        if (rowSet.getTimestamp("saved_at") != null) {
            savedDispensary.setSavedAt(
                    rowSet.getTimestamp(
                            "saved_at"
                    ).toLocalDateTime()
            );
        }

        return savedDispensary;
    }
}