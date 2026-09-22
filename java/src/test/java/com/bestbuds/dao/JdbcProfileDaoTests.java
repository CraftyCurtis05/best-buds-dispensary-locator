package com.bestbuds.dao;

import com.bestbuds.model.Profile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcProfileDaoTests
        extends BaseDaoTests {

    private JdbcProfileDao jdbcProfileDao;

    @BeforeEach
    public void setup() {
        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(
                        dataSource
                );

        jdbcProfileDao =
                new JdbcProfileDao(
                        jdbcTemplate
                );
    }

    @Test
    public void getProfileByUserId_returns_profile() {

        Profile profile =
                jdbcProfileDao.getProfileByUserId(
                        1
                );

        assertNotNull(
                profile
        );

        assertEquals(
                1,
                profile.getUserId()
        );

        assertEquals(
                "Test",
                profile.getFirstName()
        );

        assertEquals(
                "User",
                profile.getLastName()
        );

        assertEquals(
                LocalDate.of(
                        1990,
                        5,
                        15
                ),
                profile.getBirthday()
        );

        assertEquals(
                "123 Main Street",
                profile.getAddressLine1()
        );

        assertNull(
                profile.getAddressLine2()
        );

        assertEquals(
                "Columbus",
                profile.getCity()
        );

        assertEquals(
                "OH",
                profile.getStateAbbr()
        );

        assertEquals(
                "43215",
                profile.getZipcode()
        );
    }

    @Test
    public void getProfileByUserId_returns_profile_with_null_fields() {

        Profile profile =
                jdbcProfileDao.getProfileByUserId(
                        2
                );

        assertNotNull(
                profile
        );

        assertEquals(
                2,
                profile.getUserId()
        );

        assertEquals(
                "Second",
                profile.getFirstName()
        );

        assertEquals(
                "User",
                profile.getLastName()
        );

        assertNull(
                profile.getBirthday()
        );

        assertNull(
                profile.getAddressLine1()
        );

        assertNull(
                profile.getAddressLine2()
        );

        assertNull(
                profile.getCity()
        );

        assertNull(
                profile.getStateAbbr()
        );

        assertNull(
                profile.getZipcode()
        );
    }

    @Test
    public void getProfileByUserId_returns_null_when_profile_does_not_exist() {

        Profile profile =
                jdbcProfileDao.getProfileByUserId(
                        3
                );

        assertNull(
                profile
        );
    }

    @Test
    public void createProfile_creates_profile() {

        Profile profile =
                new Profile();

        profile.setUserId(
                3
        );

        profile.setFirstName(
                "Third"
        );

        profile.setLastName(
                "User"
        );

        profile.setBirthday(
                LocalDate.of(
                        1995,
                        8,
                        20
                )
        );

        profile.setAddressLine1(
                "456 Broad Street"
        );

        profile.setCity(
                "Columbus"
        );

        profile.setStateAbbr(
                "OH"
        );

        profile.setZipcode(
                "43215"
        );

        Profile createdProfile =
                jdbcProfileDao.createProfile(
                        profile
                );

        assertNotNull(
                createdProfile
        );

        assertTrue(
                createdProfile.getId() > 0
        );

        Profile savedProfile =
                jdbcProfileDao.getProfileByUserId(
                        3
                );

        assertNotNull(
                savedProfile
        );

        assertEquals(
                createdProfile,
                savedProfile
        );
    }

    @Test
    public void updateProfile_updates_profile() {

        Profile profile =
                jdbcProfileDao.getProfileByUserId(
                        1
                );

        profile.setFirstName(
                "Updated"
        );

        profile.setAddressLine1(
                "789 High Street"
        );

        profile.setAddressLine2(
                "Apartment 2"
        );

        profile.setZipcode(
                "43201"
        );

        Profile updatedProfile =
                jdbcProfileDao.updateProfile(
                        profile
                );

        assertNotNull(
                updatedProfile
        );

        assertEquals(
                "Updated",
                updatedProfile.getFirstName()
        );

        assertEquals(
                "789 High Street",
                updatedProfile.getAddressLine1()
        );

        assertEquals(
                "Apartment 2",
                updatedProfile.getAddressLine2()
        );

        assertEquals(
                "43201",
                updatedProfile.getZipcode()
        );
    }

    @Test
    public void updateProfile_returns_null_when_profile_does_not_exist() {

        Profile profile =
                new Profile();

        profile.setUserId(
                3
        );

        profile.setFirstName(
                "Missing"
        );

        Profile updatedProfile =
                jdbcProfileDao.updateProfile(
                        profile
                );

        assertNull(
                updatedProfile
        );
    }
}