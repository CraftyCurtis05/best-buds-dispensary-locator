package com.bestbuds.dao;

import com.bestbuds.model.SavedDispensary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcSavedDispensaryDaoTests
        extends BaseDaoTests {

    private JdbcSavedDispensaryDao jdbcSavedDispensaryDao;

    @BeforeEach
    public void setup() {

        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(
                        dataSource
                );

        jdbcSavedDispensaryDao =
                new JdbcSavedDispensaryDao(
                        jdbcTemplate
                );
    }

    @Test
    public void getSavedDispensariesByUserId_returns_saved_dispensaries() {

        SavedDispensary firstDispensary =
                createSavedDispensary(
                        1,
                        "yelp-business-1",
                        "Green Leaf Dispensary"
                );

        SavedDispensary secondDispensary =
                createSavedDispensary(
                        1,
                        "yelp-business-2",
                        "High Street Dispensary"
                );

        jdbcSavedDispensaryDao.createSavedDispensary(
                firstDispensary
        );

        jdbcSavedDispensaryDao.createSavedDispensary(
                secondDispensary
        );

        List<SavedDispensary> savedDispensaries =
                jdbcSavedDispensaryDao
                        .getSavedDispensariesByUserId(
                                1
                        );

        assertEquals(
                2,
                savedDispensaries.size()
        );
    }

    @Test
    public void getSavedDispensariesByUserId_returns_empty_list_when_none_exist() {

        List<SavedDispensary> savedDispensaries =
                jdbcSavedDispensaryDao
                        .getSavedDispensariesByUserId(
                                3
                        );

        assertNotNull(
                savedDispensaries
        );

        assertTrue(
                savedDispensaries.isEmpty()
        );
    }

    @Test
    public void getSavedDispensaryByUserIdAndYelpBusinessId_returns_saved_dispensary() {

        SavedDispensary savedDispensary =
                createSavedDispensary(
                        1,
                        "yelp-business-1",
                        "Green Leaf Dispensary"
                );

        SavedDispensary createdDispensary =
                jdbcSavedDispensaryDao.createSavedDispensary(
                        savedDispensary
                );

        SavedDispensary foundDispensary =
                jdbcSavedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                1,
                                "yelp-business-1"
                        );

        assertNotNull(
                foundDispensary
        );

        assertEquals(
                createdDispensary,
                foundDispensary
        );
    }

    @Test
    public void getSavedDispensaryByUserIdAndYelpBusinessId_returns_null_when_not_found() {

        SavedDispensary savedDispensary =
                jdbcSavedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                1,
                                "missing-yelp-business"
                        );

        assertNull(
                savedDispensary
        );
    }

    @Test
    public void getSavedDispensaryByUserIdAndYelpBusinessId_does_not_return_another_users_dispensary() {

        SavedDispensary savedDispensary =
                createSavedDispensary(
                        1,
                        "private-yelp-business",
                        "Private Dispensary"
                );

        jdbcSavedDispensaryDao.createSavedDispensary(
                savedDispensary
        );

        SavedDispensary anotherUsersDispensary =
                jdbcSavedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                2,
                                "private-yelp-business"
                        );

        assertNull(
                anotherUsersDispensary
        );
    }

    @Test
    public void createSavedDispensary_creates_saved_dispensary() {

        SavedDispensary savedDispensary =
                createSavedDispensary(
                        1,
                        "create-yelp-business",
                        "Created Dispensary"
                );

        SavedDispensary createdDispensary =
                jdbcSavedDispensaryDao.createSavedDispensary(
                        savedDispensary
                );

        assertNotNull(
                createdDispensary
        );

        assertTrue(
                createdDispensary.getId() > 0
        );

        assertEquals(
                1,
                createdDispensary.getUserId()
        );

        assertEquals(
                "create-yelp-business",
                createdDispensary.getYelpBusinessId()
        );

        assertEquals(
                "Created Dispensary",
                createdDispensary.getName()
        );

        assertNotNull(
                createdDispensary.getSavedAt()
        );
    }

    @Test
    public void deleteSavedDispensary_deletes_saved_dispensary() {

        SavedDispensary savedDispensary =
                createSavedDispensary(
                        1,
                        "delete-yelp-business",
                        "Deleted Dispensary"
                );

        jdbcSavedDispensaryDao.createSavedDispensary(
                savedDispensary
        );

        jdbcSavedDispensaryDao.deleteSavedDispensary(
                1,
                "delete-yelp-business"
        );

        SavedDispensary deletedDispensary =
                jdbcSavedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                1,
                                "delete-yelp-business"
                        );

        assertNull(
                deletedDispensary
        );
    }

    @Test
    public void deleteSavedDispensary_does_not_delete_another_users_dispensary() {

        SavedDispensary savedDispensary =
                createSavedDispensary(
                        1,
                        "protected-yelp-business",
                        "Protected Dispensary"
                );

        jdbcSavedDispensaryDao.createSavedDispensary(
                savedDispensary
        );

        jdbcSavedDispensaryDao.deleteSavedDispensary(
                2,
                "protected-yelp-business"
        );

        SavedDispensary existingDispensary =
                jdbcSavedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                1,
                                "protected-yelp-business"
                        );

        assertNotNull(
                existingDispensary
        );
    }

    // Create saved dispensary data used by DAO tests
    private SavedDispensary createSavedDispensary(
            int userId,
            String yelpBusinessId,
            String name
    ) {

        SavedDispensary savedDispensary =
                new SavedDispensary();

        savedDispensary.setUserId(
                userId
        );

        savedDispensary.setYelpBusinessId(
                yelpBusinessId
        );

        savedDispensary.setName(
                name
        );

        savedDispensary.setImageUrl(
                "https://example.com/dispensary.jpg"
        );

        savedDispensary.setAddress(
                "123 High Street"
        );

        savedDispensary.setCity(
                "Columbus"
        );

        savedDispensary.setStateAbbr(
                "OH"
        );

        savedDispensary.setZipcode(
                "43215"
        );

        savedDispensary.setLatitude(
                new BigDecimal(
                        "39.961176"
                )
        );

        savedDispensary.setLongitude(
                new BigDecimal(
                        "-82.998794"
                )
        );

        savedDispensary.setRating(
                new BigDecimal(
                        "4.5"
                )
        );

        return savedDispensary;
    }
}