package com.bestbuds.controller;

import com.bestbuds.model.SavedDispensary;
import com.bestbuds.model.SavedDispensaryDto;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.SavedDispensaryService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/saved-dispensaries")
public class SavedDispensaryController {

    private final SavedDispensaryService savedDispensaryService;
    private final AuthenticationService authenticationService;

    public SavedDispensaryController(
            SavedDispensaryService savedDispensaryService,
            AuthenticationService authenticationService
    ) {
        this.savedDispensaryService = savedDispensaryService;
        this.authenticationService = authenticationService;
    }

    // Get the authenticated user's saved dispensaries
    @GetMapping
    public ResponseEntity<List<SavedDispensary>> getSavedDispensaries(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        List<SavedDispensary> savedDispensaries =
                savedDispensaryService.getSavedDispensaries(
                        user.getId()
                );

        return ResponseEntity.ok(
                savedDispensaries
        );
    }

    // Save a dispensary for the authenticated user
    @PostMapping
    public ResponseEntity<SavedDispensary> saveDispensary(
            Authentication authentication,
            @Valid @RequestBody SavedDispensaryDto savedDispensaryDto
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        SavedDispensary savedDispensary =
                createSavedDispensaryFromDto(
                        savedDispensaryDto
                );

        SavedDispensary result =
                savedDispensaryService.saveDispensary(
                        user.getId(),
                        savedDispensary
                );

        return ResponseEntity.ok(
                result
        );
    }

    // Remove a dispensary from the authenticated user's saved dispensaries
    @DeleteMapping("/{yelpBusinessId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSavedDispensary(
            Authentication authentication,
            @PathVariable String yelpBusinessId
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        savedDispensaryService.deleteSavedDispensary(
                user.getId(),
                yelpBusinessId
        );
    }

    // Convert saved dispensary fields into a SavedDispensary
    private SavedDispensary createSavedDispensaryFromDto(
            SavedDispensaryDto savedDispensaryDto
    ) {

        SavedDispensary savedDispensary =
                new SavedDispensary();

        savedDispensary.setYelpBusinessId(
                savedDispensaryDto.getYelpBusinessId()
        );

        savedDispensary.setName(
                savedDispensaryDto.getName()
        );

        savedDispensary.setImageUrl(
                savedDispensaryDto.getImageUrl()
        );

        savedDispensary.setAddress(
                savedDispensaryDto.getAddress()
        );

        savedDispensary.setCity(
                savedDispensaryDto.getCity()
        );

        savedDispensary.setStateAbbr(
                savedDispensaryDto.getStateAbbr()
        );

        savedDispensary.setZipcode(
                savedDispensaryDto.getZipcode()
        );

        savedDispensary.setLatitude(
                savedDispensaryDto.getLatitude()
        );

        savedDispensary.setLongitude(
                savedDispensaryDto.getLongitude()
        );

        savedDispensary.setRating(
                savedDispensaryDto.getRating()
        );

        return savedDispensary;
    }
}