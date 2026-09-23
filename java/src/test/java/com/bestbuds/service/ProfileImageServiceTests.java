package com.bestbuds.service;

import com.bestbuds.dao.ProfileImageDao;
import com.bestbuds.model.ProfileImage;
import com.bestbuds.exception.InvalidProfileImageException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProfileImageServiceTests {

    @Mock
    private ProfileImageDao profileImageDao;

    private ProfileImageService profileImageService;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(
                this
        );

        profileImageService =
                new ProfileImageService(
                        profileImageDao
                );
    }

    @Test
    public void getProfileImage_returns_profile_image_for_user() {

        ProfileImage profileImage =
                new ProfileImage();

        profileImage.setId(
                10
        );

        profileImage.setUserId(
                1
        );

        when(
                profileImageDao.getProfileImageByUserId(
                        1
                )
        ).thenReturn(
                profileImage
        );

        ProfileImage result =
                profileImageService.getProfileImage(
                        1
                );

        assertSame(
                profileImage,
                result
        );

        verify(
                profileImageDao
        ).getProfileImageByUserId(
                1
        );
    }

    @Test
    public void deleteProfileImage_deletes_profile_image_for_user() {

        profileImageService.deleteProfileImage(
                1
        );

        verify(
                profileImageDao
        ).deleteProfileImageByUserId(
                1
        );
    }

    @Test
    public void saveProfileImage_creates_image_when_image_does_not_exist()
            throws IOException {

        MockMultipartFile imageFile =
                createImageFile(
                        400,
                        300,
                        "png"
                );

        when(
                profileImageDao.getProfileImageByUserId(
                        1
                )
        ).thenReturn(
                null
        );

        when(
                profileImageDao.createProfileImage(
                        any(ProfileImage.class)
                )
        ).thenAnswer(
                invocation -> invocation.getArgument(
                        0
                )
        );

        ProfileImage result =
                profileImageService.saveProfileImage(
                        1,
                        imageFile
                );

        assertEquals(
                1,
                result.getUserId()
        );

        assertEquals(
                "image/jpeg",
                result.getContentType()
        );

        assertNotNull(
                result.getImageData()
        );

        verify(
                profileImageDao
        ).createProfileImage(
                result
        );

        verify(
                profileImageDao,
                never()
        ).updateProfileImage(
                any(ProfileImage.class)
        );
    }

    @Test
    public void saveProfileImage_updates_image_when_image_exists()
            throws IOException {

        ProfileImage existingProfileImage =
                new ProfileImage();

        existingProfileImage.setId(
                10
        );

        existingProfileImage.setUserId(
                1
        );

        MockMultipartFile imageFile =
                createImageFile(
                        400,
                        300,
                        "png"
                );

        when(
                profileImageDao.getProfileImageByUserId(
                        1
                )
        ).thenReturn(
                existingProfileImage
        );

        when(
                profileImageDao.updateProfileImage(
                        any(ProfileImage.class)
                )
        ).thenAnswer(
                invocation -> invocation.getArgument(
                        0
                )
        );

        ProfileImage result =
                profileImageService.saveProfileImage(
                        1,
                        imageFile
                );

        assertEquals(
                10,
                result.getId()
        );

        assertEquals(
                1,
                result.getUserId()
        );

        assertEquals(
                "image/jpeg",
                result.getContentType()
        );

        verify(
                profileImageDao
        ).updateProfileImage(
                result
        );

        verify(
                profileImageDao,
                never()
        ).createProfileImage(
                any(ProfileImage.class)
        );
    }

    @Test
    public void saveProfileImage_rejects_empty_file() {

        MockMultipartFile imageFile =
                new MockMultipartFile(
                        "image",
                        new byte[0]
                );

        assertThrows(
                InvalidProfileImageException.class,
                () -> profileImageService.saveProfileImage(
                        1,
                        imageFile
                )
        );

        verify(
                profileImageDao,
                never()
        ).createProfileImage(
                any(ProfileImage.class)
        );

        verify(
                profileImageDao,
                never()
        ).updateProfileImage(
                any(ProfileImage.class)
        );
    }

    @Test
    public void saveProfileImage_rejects_file_larger_than_five_megabytes() {

        byte[] imageData =
                new byte[
                        (5 * 1024 * 1024) + 1
                ];

        MockMultipartFile imageFile =
                new MockMultipartFile(
                        "image",
                        "large-image.jpg",
                        "image/jpeg",
                        imageData
                );

        assertThrows(
                InvalidProfileImageException.class,
                () -> profileImageService.saveProfileImage(
                        1,
                        imageFile
                )
        );

        verify(
                profileImageDao,
                never()
        ).createProfileImage(
                any(ProfileImage.class)
        );

        verify(
                profileImageDao,
                never()
        ).updateProfileImage(
                any(ProfileImage.class)
        );
    }

    @Test
    public void saveProfileImage_rejects_file_that_is_not_an_image() {

        MockMultipartFile imageFile =
                new MockMultipartFile(
                        "image",
                        "not-an-image.jpg",
                        "image/jpeg",
                        "This is not an image".getBytes()
                );

        assertThrows(
                InvalidProfileImageException.class,
                () -> profileImageService.saveProfileImage(
                        1,
                        imageFile
                )
        );

        verify(
                profileImageDao,
                never()
        ).createProfileImage(
                any(ProfileImage.class)
        );

        verify(
                profileImageDao,
                never()
        ).updateProfileImage(
                any(ProfileImage.class)
        );
    }

    @Test
    public void saveProfileImage_resizes_large_landscape_image()
            throws IOException {

        MockMultipartFile imageFile =
                createImageFile(
                        1200,
                        800,
                        "png"
                );

        ProfileImage savedProfileImage =
                saveAndCaptureProfileImage(
                        imageFile
                );

        BufferedImage storedImage =
                readStoredImage(
                        savedProfileImage
                );

        assertEquals(
                500,
                storedImage.getWidth()
        );

        assertEquals(
                333,
                storedImage.getHeight()
        );
    }

    @Test
    public void saveProfileImage_resizes_large_portrait_image()
            throws IOException {

        MockMultipartFile imageFile =
                createImageFile(
                        800,
                        1200,
                        "png"
                );

        ProfileImage savedProfileImage =
                saveAndCaptureProfileImage(
                        imageFile
                );

        BufferedImage storedImage =
                readStoredImage(
                        savedProfileImage
                );

        assertEquals(
                333,
                storedImage.getWidth()
        );

        assertEquals(
                500,
                storedImage.getHeight()
        );
    }

    @Test
    public void saveProfileImage_keeps_small_image_dimensions()
            throws IOException {

        MockMultipartFile imageFile =
                createImageFile(
                        300,
                        200,
                        "png"
                );

        ProfileImage savedProfileImage =
                saveAndCaptureProfileImage(
                        imageFile
                );

        BufferedImage storedImage =
                readStoredImage(
                        savedProfileImage
                );

        assertEquals(
                300,
                storedImage.getWidth()
        );

        assertEquals(
                200,
                storedImage.getHeight()
        );
    }

    @Test
    public void saveProfileImage_converts_transparent_png_to_jpeg()
            throws IOException {

        MockMultipartFile imageFile =
                createTransparentImageFile();

        ProfileImage savedProfileImage =
                saveAndCaptureProfileImage(
                        imageFile
                );

        BufferedImage storedImage =
                readStoredImage(
                        savedProfileImage
                );

        assertNotNull(
                storedImage
        );

        assertEquals(
                "image/jpeg",
                savedProfileImage.getContentType()
        );

        assertEquals(
                BufferedImage.TYPE_3BYTE_BGR,
                storedImage.getType()
        );
    }

    // Create a real image upload used by service tests
    private MockMultipartFile createImageFile(
            int width,
            int height,
            String format
    ) throws IOException {

        BufferedImage image =
                new BufferedImage(
                        width,
                        height,
                        BufferedImage.TYPE_INT_RGB
                );

        Graphics2D graphics =
                image.createGraphics();

        try {
            graphics.setColor(
                    Color.GREEN
            );

            graphics.fillRect(
                    0,
                    0,
                    width,
                    height
            );

        } finally {
            graphics.dispose();
        }

        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream();

        ImageIO.write(
                image,
                format,
                outputStream
        );

        return new MockMultipartFile(
                "image",
                "profile." + format,
                "image/" + format,
                outputStream.toByteArray()
        );
    }

    // Create a transparent PNG to test JPEG conversion
    private MockMultipartFile createTransparentImageFile()
            throws IOException {

        BufferedImage image =
                new BufferedImage(
                        200,
                        200,
                        BufferedImage.TYPE_INT_ARGB
                );

        Graphics2D graphics =
                image.createGraphics();

        try {
            graphics.setColor(
                    new Color(
                            0,
                            255,
                            0,
                            100
                    )
            );

            graphics.fillRect(
                    0,
                    0,
                    200,
                    200
            );

        } finally {
            graphics.dispose();
        }

        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream();

        ImageIO.write(
                image,
                "png",
                outputStream
        );

        return new MockMultipartFile(
                "image",
                "transparent-profile.png",
                "image/png",
                outputStream.toByteArray()
        );
    }

    // Save an image and capture the processed data sent to the DAO
    private ProfileImage saveAndCaptureProfileImage(
            MockMultipartFile imageFile
    ) {

        when(
                profileImageDao.getProfileImageByUserId(
                        1
                )
        ).thenReturn(
                null
        );

        when(
                profileImageDao.createProfileImage(
                        any(ProfileImage.class)
                )
        ).thenAnswer(
                invocation -> invocation.getArgument(
                        0
                )
        );

        profileImageService.saveProfileImage(
                1,
                imageFile
        );

        ArgumentCaptor<ProfileImage> imageCaptor =
                ArgumentCaptor.forClass(
                        ProfileImage.class
                );

        verify(
                profileImageDao
        ).createProfileImage(
                imageCaptor.capture()
        );

        return imageCaptor.getValue();
    }

    // Read the processed image bytes created by the service
    private BufferedImage readStoredImage(
            ProfileImage profileImage
    ) throws IOException {

        return ImageIO.read(
                new ByteArrayInputStream(
                        profileImage.getImageData()
                )
        );
    }
}