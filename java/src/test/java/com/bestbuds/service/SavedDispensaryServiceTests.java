package com.bestbuds.service;

import com.bestbuds.dao.SavedDispensaryDao;
import com.bestbuds.model.SavedDispensary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SavedDispensaryServiceTests {

    @Mock
    private SavedDispensaryDao savedDispensaryDao;

    private SavedDispensaryService savedDispensaryService;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(
                this
        );

        savedDispensaryService =
                new SavedDispensaryService(
                        savedDispensaryDao
                );
    }

    @Test
    public void getSavedDispensaries_returns_saved_dispensaries_for_user() {

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

        List<SavedDispensary> savedDispensaries =
                List.of(
                        firstDispensary,
                        secondDispensary
                );

        when(
                savedDispensaryDao
                        .getSavedDispensariesByUserId(
                                1
                        )
        ).thenReturn(
                savedDispensaries
        );

        List<SavedDispensary> result =
                savedDispensaryService
                        .getSavedDispensaries(
                                1
                        );

        assertSame(
                savedDispensaries,
                result
        );

        assertEquals(
                2,
                result.size()
        );

        verify(
                savedDispensaryDao
        ).getSavedDispensariesByUserId(
                1
        );
    }

    @Test
    public void saveDispensary_creates_dispensary_when_not_already_saved() {

        SavedDispensary savedDispensary =
                createSavedDispensary(
                        99,
                        "new-yelp-business",
                        "New Dispensary"
                );

        when(
                savedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                1,
                                "new-yelp-business"
                        )
        ).thenReturn(
                null
        );

        when(
                savedDispensaryDao.createSavedDispensary(
                        savedDispensary
                )
        ).thenReturn(
                savedDispensary
        );

        SavedDispensary result =
                savedDispensaryService.saveDispensary(
                        1,
                        savedDispensary
                );

        assertSame(
                savedDispensary,
                result
        );

        assertEquals(
                1,
                savedDispensary.getUserId()
        );

        verify(
                savedDispensaryDao
        ).createSavedDispensary(
                savedDispensary
        );
    }

    @Test
    public void saveDispensary_returns_existing_dispensary_when_already_saved() {

        SavedDispensary savedDispensary =
                createSavedDispensary(
                        99,
                        "existing-yelp-business",
                        "Existing Dispensary"
                );

        SavedDispensary existingDispensary =
                createSavedDispensary(
                        1,
                        "existing-yelp-business",
                        "Existing Dispensary"
                );

        existingDispensary.setId(
                10
        );

        when(
                savedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                1,
                                "existing-yelp-business"
                        )
        ).thenReturn(
                existingDispensary
        );

        SavedDispensary result =
                savedDispensaryService.saveDispensary(
                        1,
                        savedDispensary
                );

        assertSame(
                existingDispensary,
                result
        );

        verify(
                savedDispensaryDao,
                never()
        ).createSavedDispensary(
                any(SavedDispensary.class)
        );
    }

    @Test
    public void deleteSavedDispensary_deletes_dispensary_for_user() {

        savedDispensaryService.deleteSavedDispensary(
                1,
                "delete-yelp-business"
        );

        verify(
                savedDispensaryDao
        ).deleteSavedDispensary(
                1,
                "delete-yelp-business"
        );
    }

    // Create saved dispensary data used by service tests
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

        return savedDispensary;
    }
}