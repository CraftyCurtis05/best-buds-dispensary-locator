package com.bestbuds.controller;

import com.bestbuds.model.ProfileImage;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.ProfileImageService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profile/image")
public class ProfileImageController {

    private final ProfileImageService profileImageService;
    private final AuthenticationService authenticationService;

    public ProfileImageController(
            ProfileImageService profileImageService,
            AuthenticationService authenticationService
    ) {
        this.profileImageService = profileImageService;
        this.authenticationService = authenticationService;
    }

    // Get the authenticated user's profile image
    @GetMapping
    public ResponseEntity<byte[]> getProfileImage(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        ProfileImage profileImage =
                profileImageService.getProfileImage(
                        user.getId()
                );

        if (profileImage == null) {
            return ResponseEntity.noContent().build();
        }

        HttpHeaders headers =
                new HttpHeaders();

        headers.setContentType(
                MediaType.parseMediaType(
                        profileImage.getContentType()
                )
        );

        return new ResponseEntity<>(
                profileImage.getImageData(),
                headers,
                HttpStatus.OK
        );
    }

    // Create or replace the authenticated user's profile image
    @PutMapping
    public ResponseEntity<byte[]> saveProfileImage(
            Authentication authentication,
            @RequestParam("image") MultipartFile imageFile
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        ProfileImage savedProfileImage =
                profileImageService.saveProfileImage(
                        user.getId(),
                        imageFile
                );

        HttpHeaders headers =
                new HttpHeaders();

        headers.setContentType(
                MediaType.parseMediaType(
                        savedProfileImage.getContentType()
                )
        );

        return new ResponseEntity<>(
                savedProfileImage.getImageData(),
                headers,
                HttpStatus.OK
        );
    }

    // Delete the authenticated user's profile image
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfileImage(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        profileImageService.deleteProfileImage(
                user.getId()
        );
    }
}