package com.bestbuds.service;

import com.bestbuds.dao.CollectibleDao;
import com.bestbuds.model.Collectible;
import com.bestbuds.model.UserCollectible;
import com.bestbuds.model.Profile;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CollectibleService {

    private static final String BIRTHDAY_BUD =
            "BIRTHDAY_BUD";

    private final CollectibleDao collectibleDao;
    private final ProfileService profileService;

    public CollectibleService(
            CollectibleDao collectibleDao,
            ProfileService profileService
    ) {
        this.collectibleDao = collectibleDao;
        this.profileService = profileService;
    }

    // Get a collectible by its code
    public Collectible getCollectible(
            String code
    ) {
        return collectibleDao.getCollectibleByCode(
                code
        );
    }

    // Get all collectibles unlocked by a user
    public List<UserCollectible> getUserCollectibles(
            int userId
    ) {
        return collectibleDao.getUserCollectibles(
                userId
        );
    }

    // Get a specific collectible unlocked by a user
    public UserCollectible getUserCollectible(
            int userId,
            String code
    ) {
        return collectibleDao.getUserCollectible(
                userId,
                code
        );
    }

    // Unlock a collectible for a user
    public UserCollectible unlockCollectible(
            int userId,
            String code
    ) {
        return collectibleDao.unlockCollectible(
                userId,
                code
        );
    }

    // Get the profile used to evaluate automatic collectibles
    public Profile getProfileForCollectibles(
            int userId
    ) {
        return profileService.getProfile(
                userId
        );
    }

    // Check whether a user has any automatic collectibles to unlock
    public UserCollectible checkForDrops(
            int userId
    ) {

        Profile profile =
                getProfileForCollectibles(
                        userId
                );

        if (profile == null) {
            return null;
        }

        UserCollectible birthdayBud =
                getUserCollectible(
                        userId,
                        BIRTHDAY_BUD
                );

        if (birthdayBud != null) {
            return null;
        }

        return unlockBirthdayBud(
                userId,
                profile.getBirthday()
        );
    }

    // Unlock Birthday Bud using the current date
    public UserCollectible unlockBirthdayBud(
            int userId,
            LocalDate birthday
    ) {
        return unlockBirthdayBud(
                userId,
                birthday,
                LocalDate.now()
        );
    }

    // Unlock Birthday Bud when today matches the user's birthday
    public UserCollectible unlockBirthdayBud(
            int userId,
            LocalDate birthday,
            LocalDate today
    ) {

        if (birthday == null) {
            return null;
        }

        boolean isBirthday =
                birthday.getMonthValue()
                        == today.getMonthValue()
                        && birthday.getDayOfMonth()
                        == today.getDayOfMonth();

        if (!isBirthday) {
            return null;
        }

        return collectibleDao.unlockCollectible(
                userId,
                BIRTHDAY_BUD
        );
    }
}