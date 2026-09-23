package com.bestbuds.dao;

import com.bestbuds.model.ProfileImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcProfileImageDaoTests
        extends BaseDaoTests {

    private JdbcProfileImageDao jdbcProfileImageDao;

    @BeforeEach
    public void setup() {

        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(
                        dataSource
                );

        jdbcProfileImageDao =
                new JdbcProfileImageDao(
                        jdbcTemplate
                );
    }

    @Test
    public void getProfileImageByUserId_returns_profile_image() {

        ProfileImage profileImage =
                createProfileImage(
                        1
                );

        ProfileImage createdProfileImage =
                jdbcProfileImageDao.createProfileImage(
                        profileImage
                );

        ProfileImage savedProfileImage =
                jdbcProfileImageDao.getProfileImageByUserId(
                        1
                );

        assertNotNull(
                savedProfileImage
        );

        assertEquals(
                createdProfileImage,
                savedProfileImage
        );
    }

    @Test
    public void getProfileImageByUserId_returns_null_when_image_does_not_exist() {

        ProfileImage profileImage =
                jdbcProfileImageDao.getProfileImageByUserId(
                        3
                );

        assertNull(
                profileImage
        );
    }

    @Test
    public void createProfileImage_creates_profile_image() {

        ProfileImage profileImage =
                createProfileImage(
                        3
                );

        ProfileImage createdProfileImage =
                jdbcProfileImageDao.createProfileImage(
                        profileImage
                );

        assertNotNull(
                createdProfileImage
        );

        assertTrue(
                createdProfileImage.getId() > 0
        );

        assertEquals(
                3,
                createdProfileImage.getUserId()
        );

        assertArrayEquals(
                new byte[]{1, 2, 3, 4, 5},
                createdProfileImage.getImageData()
        );

        assertEquals(
                "image/jpeg",
                createdProfileImage.getContentType()
        );

        ProfileImage savedProfileImage =
                jdbcProfileImageDao.getProfileImageByUserId(
                        3
                );

        assertEquals(
                createdProfileImage,
                savedProfileImage
        );
    }

    @Test
    public void updateProfileImage_updates_profile_image() {

        ProfileImage profileImage =
                createProfileImage(
                        2
                );

        jdbcProfileImageDao.createProfileImage(
                profileImage
        );

        profileImage.setImageData(
                new byte[]{9, 8, 7, 6}
        );

        profileImage.setContentType(
                "image/png"
        );

        ProfileImage updatedProfileImage =
                jdbcProfileImageDao.updateProfileImage(
                        profileImage
                );

        assertNotNull(
                updatedProfileImage
        );

        assertArrayEquals(
                new byte[]{9, 8, 7, 6},
                updatedProfileImage.getImageData()
        );

        assertEquals(
                "image/png",
                updatedProfileImage.getContentType()
        );
    }

    @Test
    public void deleteProfileImageByUserId_deletes_profile_image() {

        ProfileImage profileImage =
                createProfileImage(
                        1
                );

        jdbcProfileImageDao.createProfileImage(
                profileImage
        );

        jdbcProfileImageDao.deleteProfileImageByUserId(
                1
        );

        ProfileImage deletedProfileImage =
                jdbcProfileImageDao.getProfileImageByUserId(
                        1
                );

        assertNull(
                deletedProfileImage
        );
    }

    // Create profile image data used by DAO tests
    private ProfileImage createProfileImage(
            int userId
    ) {

        ProfileImage profileImage =
                new ProfileImage();

        profileImage.setUserId(
                userId
        );

        profileImage.setImageData(
                new byte[]{1, 2, 3, 4, 5}
        );

        profileImage.setContentType(
                "image/jpeg"
        );

        return profileImage;
    }
}