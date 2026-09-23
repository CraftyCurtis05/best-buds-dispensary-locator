package com.bestbuds.dao;

import com.bestbuds.model.SavedDispensary;

import java.util.List;

public interface SavedDispensaryDao {

    List<SavedDispensary> getSavedDispensariesByUserId(
            int userId
    );

    SavedDispensary getSavedDispensaryByUserIdAndYelpBusinessId(
            int userId,
            String yelpBusinessId
    );

    SavedDispensary createSavedDispensary(
            SavedDispensary savedDispensary
    );

    void deleteSavedDispensary(
            int userId,
            String yelpBusinessId
    );
}