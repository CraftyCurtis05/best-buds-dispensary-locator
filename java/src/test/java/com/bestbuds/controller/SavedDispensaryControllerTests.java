package com.bestbuds.controller;

import com.bestbuds.model.SavedDispensary;
import com.bestbuds.model.SavedDispensaryDto;
import com.bestbuds.model.User;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.SavedDispensaryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SavedDispensaryControllerTests {

    private SavedDispensaryService savedDispensaryService;
    private AuthenticationService authenticationService;
    private Authentication authentication;
    private SavedDispensaryController sut;

    @BeforeEach
    public void setup() {

        savedDispensaryService =
                mock(SavedDispensaryService.class);

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new SavedDispensaryController(
                        savedDispensaryService,
                        authenticationService
                );
    }

    @Test
    public void getSavedDispensaries_returns_saved_dispensaries_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        SavedDispensary savedDispensary =
                new SavedDispensary();

        savedDispensary.setId(
                10
        );

        savedDispensary.setUserId(
                1
        );

        savedDispensary.setYelpBusinessId(
                "test-yelp-business"
        );

        savedDispensary.setName(
                "Test Dispensary"
        );

        List<SavedDispensary> savedDispensaries =
                List.of(
                        savedDispensary
                );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        when(savedDispensaryService.getSavedDispensaries(1))
                .thenReturn(
                        savedDispensaries
                );

        ResponseEntity<List<SavedDispensary>> response =
                sut.getSavedDispensaries(
                        authentication
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                savedDispensaries,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(savedDispensaryService).getSavedDispensaries(
                1
        );
    }

    @Test
    public void saveDispensary_saves_dispensary_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        SavedDispensaryDto savedDispensaryDto =
                new SavedDispensaryDto();

        savedDispensaryDto.setYelpBusinessId(
                "test-yelp-business"
        );

        savedDispensaryDto.setName(
                "Test Dispensary"
        );

        savedDispensaryDto.setImageUrl(
                "https://example.com/dispensary.jpg"
        );

        savedDispensaryDto.setAddress(
                "123 High Street"
        );

        savedDispensaryDto.setCity(
                "Columbus"
        );

        savedDispensaryDto.setStateAbbr(
                "OH"
        );

        savedDispensaryDto.setZipcode(
                "43215"
        );

        savedDispensaryDto.setLatitude(
                new BigDecimal(
                        "39.961176"
                )
        );

        savedDispensaryDto.setLongitude(
                new BigDecimal(
                        "-82.998794"
                )
        );

        savedDispensaryDto.setRating(
                new BigDecimal(
                        "4.5"
                )
        );

        SavedDispensary savedDispensary =
                new SavedDispensary();

        savedDispensary.setId(
                10
        );

        savedDispensary.setUserId(
                1
        );

        savedDispensary.setYelpBusinessId(
                "test-yelp-business"
        );

        savedDispensary.setName(
                "Test Dispensary"
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
                savedDispensaryService.saveDispensary(
                        eq(1),
                        any(SavedDispensary.class)
                )
        )
                .thenReturn(
                        savedDispensary
                );

        ResponseEntity<SavedDispensary> response =
                sut.saveDispensary(
                        authentication,
                        savedDispensaryDto
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                savedDispensary,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        ArgumentCaptor<SavedDispensary> savedDispensaryCaptor =
                ArgumentCaptor.forClass(
                        SavedDispensary.class
                );

        verify(savedDispensaryService).saveDispensary(
                eq(1),
                savedDispensaryCaptor.capture()
        );

        SavedDispensary capturedDispensary =
                savedDispensaryCaptor.getValue();

        assertEquals(
                "test-yelp-business",
                capturedDispensary.getYelpBusinessId()
        );

        assertEquals(
                "Test Dispensary",
                capturedDispensary.getName()
        );

        assertEquals(
                "https://example.com/dispensary.jpg",
                capturedDispensary.getImageUrl()
        );

        assertEquals(
                "123 High Street",
                capturedDispensary.getAddress()
        );

        assertEquals(
                "Columbus",
                capturedDispensary.getCity()
        );

        assertEquals(
                "OH",
                capturedDispensary.getStateAbbr()
        );

        assertEquals(
                "43215",
                capturedDispensary.getZipcode()
        );

        assertEquals(
                new BigDecimal(
                        "39.961176"
                ),
                capturedDispensary.getLatitude()
        );

        assertEquals(
                new BigDecimal(
                        "-82.998794"
                ),
                capturedDispensary.getLongitude()
        );

        assertEquals(
                new BigDecimal(
                        "4.5"
                ),
                capturedDispensary.getRating()
        );
    }

    @Test
    public void deleteSavedDispensary_deletes_dispensary_for_authenticated_user() {

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

        sut.deleteSavedDispensary(
                authentication,
                "test-yelp-business"
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(savedDispensaryService).deleteSavedDispensary(
                1,
                "test-yelp-business"
        );
    }
}