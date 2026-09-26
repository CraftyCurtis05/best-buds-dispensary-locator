package com.bestbuds.service;

import com.bestbuds.dao.CollectibleDao;
import com.bestbuds.model.Collectible;
import com.bestbuds.model.Profile;
import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityType;
import com.bestbuds.model.UserCollectible;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectibleService {

    private static final String FIRST_CONTACT =
            "FIRST_CONTACT";

    private static final String NIGHT_OWL =
            "NIGHT_OWL";

    private static final String BIRTHDAY_BUD =
            "BIRTHDAY_BUD";

    private final CollectibleDao collectibleDao;
    private final ProfileService profileService;
    private final UserActivityService userActivityService;

    public CollectibleService(
            CollectibleDao collectibleDao,
            ProfileService profileService,
            UserActivityService userActivityService
    ) {
        this.collectibleDao =
                collectibleDao;

        this.profileService =
                profileService;

        this.userActivityService =
                userActivityService;
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


    // Check for automatic collectibles using the current date and time
    public List<UserCollectible> checkForDrops(
            int userId
    ) {
        return checkForDrops(
                userId,
                LocalDate.now(),
                LocalTime.now()
        );
    }


    // Check whether a user has any automatic collectibles to unlock
    public List<UserCollectible> checkForDrops(
            int userId,
            LocalDate today,
            LocalTime currentTime
    ) {

        List<UserCollectible> newDrops =
                new ArrayList<>();

        UserCollectible firstContact =
                checkFirstContact(
                        userId
                );

        if (firstContact != null) {
            newDrops.add(
                    firstContact
            );
        }

        UserCollectible nightOwl =
                checkNightOwl(
                        userId,
                        currentTime
                );

        if (nightOwl != null) {
            newDrops.add(
                    nightOwl
            );
        }

        UserCollectible birthdayBud =
                checkBirthdayBud(
                        userId,
                        today
                );

        if (birthdayBud != null) {
            newDrops.add(
                    birthdayBud
            );
        }

        return newDrops;
    }


    // Unlock First Contact after the user's first dispensary view
    private UserCollectible checkFirstContact(
            int userId
    ) {

        UserCollectible firstContact =
                getUserCollectible(
                        userId,
                        FIRST_CONTACT
                );

        if (firstContact != null) {
            return null;
        }

        List<UserActivity> dispensaryViews =
                userActivityService.getUserActivitiesByType(
                        userId,
                        UserActivityType.DISPENSARY_VIEW
                );

        if (dispensaryViews.isEmpty()) {
            return null;
        }

        return unlockCollectible(
                userId,
                FIRST_CONTACT
        );
    }


    // Check whether Night Owl is available to unlock
    private UserCollectible checkNightOwl(
            int userId,
            LocalTime currentTime
    ) {

        UserCollectible nightOwl =
                getUserCollectible(
                        userId,
                        NIGHT_OWL
                );

        if (nightOwl != null) {
            return null;
        }

        return unlockNightOwl(
                userId,
                currentTime
        );
    }

    // Unlock Night Owl using the current time
    public UserCollectible unlockNightOwl(
            int userId
    ) {
        return unlockNightOwl(
                userId,
                LocalTime.now()
        );
    }


    // Unlock Night Owl during the early morning hours
    public UserCollectible unlockNightOwl(
            int userId,
            LocalTime currentTime
    ) {

        if (currentTime == null) {
            return null;
        }

        LocalTime nightOwlEnd =
                LocalTime.of(
                        5,
                        0
                );

        if (!currentTime.isBefore(nightOwlEnd)) {
            return null;
        }

        return unlockCollectible(
                userId,
                NIGHT_OWL
        );
    }


    // Check whether Birthday Bud is available to unlock
    private UserCollectible checkBirthdayBud(
            int userId,
            LocalDate today
    ) {

        UserCollectible birthdayBud =
                getUserCollectible(
                        userId,
                        BIRTHDAY_BUD
                );

        if (birthdayBud != null) {
            return null;
        }

        Profile profile =
                getProfileForCollectibles(
                        userId
                );

        if (profile == null) {
            return null;
        }

        return unlockBirthdayBud(
                userId,
                profile.getBirthday(),
                today
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

        return unlockCollectible(
                userId,
                BIRTHDAY_BUD
        );
    }
}