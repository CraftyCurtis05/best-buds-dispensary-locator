package com.bestbuds.controller;

import com.bestbuds.model.ProfileImage;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.ProfileImageService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProfileImageControllerTests {

    private ProfileImageService profileImageService;
    private AuthenticationService authenticationService;
    private Authentication authentication;
    private ProfileImageController sut;

    @BeforeEach
    public void setup() {

        profileImageService =
                mock(ProfileImageService.class);

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new ProfileImageController(
                        profileImageService,
                        authenticationService
                );
    }

    @Test
    public void getProfileImage_returns_image_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        byte[] imageData =
                new byte[]{
                        1,
                        2,
                        3
                };

        ProfileImage profileImage =
                new ProfileImage();

        profileImage.setUserId(
                1
        );

        profileImage.setImageData(
                imageData
        );

        profileImage.setContentType(
                "image/jpeg"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        when(profileImageService.getProfileImage(1))
                .thenReturn(
                        profileImage
                );

        ResponseEntity<byte[]> response =
                sut.getProfileImage(
                        authentication
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertEquals(
                MediaType.IMAGE_JPEG,
                response.getHeaders().getContentType()
        );

        assertArrayEquals(
                imageData,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(profileImageService).getProfileImage(
                1
        );
    }

    @Test
    public void getProfileImage_returns_no_content_when_image_does_not_exist() {

        User user =
                new User();

        user.setId(
                1
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        when(profileImageService.getProfileImage(1))
                .thenReturn(
                        null
                );

        ResponseEntity<byte[]> response =
                sut.getProfileImage(
                        authentication
                );

        assertEquals(
                204,
                response.getStatusCode().value()
        );

        assertNull(
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(profileImageService).getProfileImage(
                1
        );
    }

    @Test
    public void saveProfileImage_saves_image_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        MockMultipartFile imageFile =
                new MockMultipartFile(
                        "image",
                        "profile.jpg",
                        "image/jpeg",
                        new byte[]{
                                1,
                                2,
                                3
                        }
                );

        byte[] savedImageData =
                new byte[]{
                        4,
                        5,
                        6
                };

        ProfileImage savedProfileImage =
                new ProfileImage();

        savedProfileImage.setUserId(
                1
        );

        savedProfileImage.setImageData(
                savedImageData
        );

        savedProfileImage.setContentType(
                "image/jpeg"
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        when(
                profileImageService.saveProfileImage(
                        1,
                        imageFile
                )
        )
                .thenReturn(
                        savedProfileImage
                );

        ResponseEntity<byte[]> response =
                sut.saveProfileImage(
                        authentication,
                        imageFile
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertEquals(
                MediaType.IMAGE_JPEG,
                response.getHeaders().getContentType()
        );

        assertArrayEquals(
                savedImageData,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(profileImageService).saveProfileImage(
                1,
                imageFile
        );
    }

    @Test
    public void deleteProfileImage_deletes_image_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        sut.deleteProfileImage(
                authentication
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(profileImageService).deleteProfileImage(
                1
        );
    }
}