package com.bestbuds.service;

import com.bestbuds.dao.SavedDispensaryDao;
import com.bestbuds.model.SavedDispensary;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedDispensaryService {

    private final SavedDispensaryDao savedDispensaryDao;

    public SavedDispensaryService(
            SavedDispensaryDao savedDispensaryDao
    ) {
        this.savedDispensaryDao = savedDispensaryDao;
    }

    // Get all saved dispensaries for a user
    public List<SavedDispensary> getSavedDispensaries(
            int userId
    ) {
        return savedDispensaryDao.getSavedDispensariesByUserId(
                userId
        );
    }

    // Save a dispensary for a user
    public SavedDispensary saveDispensary(
            int userId,
            SavedDispensary savedDispensary
    ) {

        SavedDispensary existingDispensary =
                savedDispensaryDao
                        .getSavedDispensaryByUserIdAndYelpBusinessId(
                                userId,
                                savedDispensary.getYelpBusinessId()
                        );

        if (existingDispensary != null) {
            return existingDispensary;
        }

        savedDispensary.setUserId(
                userId
        );

        return savedDispensaryDao.createSavedDispensary(
                savedDispensary
        );
    }

    // Remove a saved dispensary for a user
    public void deleteSavedDispensary(
            int userId,
            String yelpBusinessId
    ) {
        savedDispensaryDao.deleteSavedDispensary(
                userId,
                yelpBusinessId
        );
    }
}