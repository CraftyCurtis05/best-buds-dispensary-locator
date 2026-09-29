package com.bestbuds.service;

import com.bestbuds.dao.CollectibleDao;
import com.bestbuds.model.Collectible;
import com.bestbuds.model.CollectibleCode;
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

    private static final int EXPLORER_ACTIVITY_TYPE_COUNT =
            5;

    private static final int CURATOR_SAVED_DISPENSARY_COUNT =
            10;

    private static final int STASHED_COLLECTIBLE_COUNT =
            1;

    private static final int THE_REGULAR_VISIT_DATE_COUNT =
            5;

    private static final int COMPLETIONIST_COLLECTIBLE_COUNT =
            12;

    private static final int THE_WHOLE_PICTURE_ACTIVITY_COUNT =
            1;

    private static final int DEEP_DIVE_ARTICLE_COUNT =
            3;

    private static final int WELL_INFORMED_TOPIC_COUNT =
            5;

    private static final int KNOW_YOUR_BUDS_PRODUCT_COUNT =
            3;

    private static final int READ_THE_LABEL_PRODUCT_COUNT =
            6;

    private static final int SAFETY_FIRST_TOPIC_COUNT =
            1;

    private static final int CLEAR_HEAD_TOPIC_COUNT =
            4;

    private static final LocalTime NIGHT_OWL_END =
            LocalTime.of(
                    5,
                    0
            );


    private final CollectibleDao collectibleDao;
    private final ProfileService profileService;
    private final UserActivityService userActivityService;
    private final SavedDispensaryService savedDispensaryService;

    public CollectibleService(
            CollectibleDao collectibleDao,
            ProfileService profileService,
            UserActivityService userActivityService,
            SavedDispensaryService savedDispensaryService
    ) {
        this.collectibleDao =
                collectibleDao;

        this.profileService =
                profileService;

        this.userActivityService =
                userActivityService;

        this.savedDispensaryService =
                savedDispensaryService;        
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


        // Check activity-based Drops first

        UserCollectible firstContact =
                checkFirstContact(
                        userId
                );

        if (firstContact != null) {
            newDrops.add(
                    firstContact
            );
        }


        UserCollectible explorer =
                checkExplorer(
                        userId
                );

        if (explorer != null) {
            newDrops.add(
                    explorer
            );
        }


        UserCollectible deepDive =
                checkDeepDive(
                        userId
                );

        if (deepDive != null) {
            newDrops.add(
                    deepDive
            );
        }


        UserCollectible wellInformed =
                checkWellInformed(
                        userId
                );

        if (wellInformed != null) {
            newDrops.add(
                    wellInformed
            );
        }


        UserCollectible knowYourBuds =
                checkKnowYourBuds(
                        userId
                );

        if (knowYourBuds != null) {
            newDrops.add(
                    knowYourBuds
            );
        }


        UserCollectible readTheLabel =
                checkReadTheLabel(
                        userId
                );

        if (readTheLabel != null) {
            newDrops.add(
                    readTheLabel
            );
        }


        UserCollectible safetyFirst =
                checkSafetyFirst(
                        userId
                );

        if (safetyFirst != null) {
            newDrops.add(
                    safetyFirst
            );
        }


        UserCollectible clearHead =
                checkClearHead(
                        userId
                );

        if (clearHead != null) {
            newDrops.add(
                    clearHead
            );
        }


        UserCollectible theRegular =
                checkTheRegular(
                        userId
                );

        if (theRegular != null) {
            newDrops.add(
                    theRegular
            );
        }


        UserCollectible theWholePicture =
                checkTheWholePicture(
                        userId
                );

        if (theWholePicture != null) {
            newDrops.add(
                    theWholePicture
            );
        }


        // Check saved-dispensary Drops

        UserCollectible curator =
                checkCurator(
                        userId
                );

        if (curator != null) {
            newDrops.add(
                    curator
            );
        }


        // Check time-based Drops

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


        // Check profile-based Drops

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


        // Check meta Drops last

        UserCollectible stashed =
                checkStashed(
                        userId
                );

        if (stashed != null) {
            newDrops.add(
                    stashed
            );
        }


        UserCollectible completionist =
                checkCompletionist(
                        userId
                );

        if (completionist != null) {
            newDrops.add(
                    completionist
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
                        CollectibleCode.FIRST_CONTACT
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
                CollectibleCode.FIRST_CONTACT
        );
    }

    // Unlock Explorer after completing five different activity types
    private UserCollectible checkExplorer(
            int userId
    ) {

        UserCollectible explorer =
                getUserCollectible(
                        userId,
                        CollectibleCode.EXPLORER
                );

        if (explorer != null) {
            return null;
        }

        int activityTypeCount =
                userActivityService
                        .countDistinctActivityTypes(
                                userId
                        );

        if (
            activityTypeCount
                    < EXPLORER_ACTIVITY_TYPE_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.EXPLORER
        );
    }


    // Unlock Deep Dive after opening three different articles
    private UserCollectible checkDeepDive(
            int userId
    ) {

        UserCollectible deepDive =
                getUserCollectible(
                        userId,
                        CollectibleCode.DEEP_DIVE
                );

        if (deepDive != null) {
            return null;
        }

        int articleCount =
                userActivityService
                        .countDistinctActivityValuesByType(
                                userId,
                                UserActivityType.ARTICLES_VIEW
                        );

        if (articleCount < DEEP_DIVE_ARTICLE_COUNT) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.DEEP_DIVE
        );
    }


    // Unlock Well Informed after exploring five education topics
    private UserCollectible checkWellInformed(
            int userId
    ) {

        UserCollectible wellInformed =
                getUserCollectible(
                        userId,
                        CollectibleCode.WELL_INFORMED
                );

        if (wellInformed != null) {
            return null;
        }

        int educationTopicCount =
                userActivityService
                        .countDistinctActivityValuesByType(
                                userId,
                                UserActivityType.EDUCATION_VIEW
                        );

        if (
            educationTopicCount
                    < WELL_INFORMED_TOPIC_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.WELL_INFORMED
        );
    }


    // Unlock Know Your Buds after exploring strains, terpenes,
    // and at least three different product categories
    private UserCollectible checkKnowYourBuds(
            int userId
    ) {

        UserCollectible knowYourBuds =
                getUserCollectible(
                        userId,
                        CollectibleCode.KNOW_YOUR_BUDS
                );

        if (knowYourBuds != null) {
            return null;
        }

        List<UserActivity> educationActivities =
                userActivityService
                        .getUserActivitiesByType(
                                userId,
                                UserActivityType.EDUCATION_VIEW
                        );

        boolean viewedStrainGuide =
                false;

        boolean viewedTerpenes =
                false;

        for (UserActivity activity : educationActivities) {

            if (
                UserActivityType.EDUCATION_STRAIN_GUIDE
                        .equals(
                                activity.getActivityValue()
                        )
            ) {
                viewedStrainGuide =
                        true;
            }

            if (
                UserActivityType.EDUCATION_TERPENES
                        .equals(
                                activity.getActivityValue()
                        )
            ) {
                viewedTerpenes =
                        true;
            }
        }

        if (
            !viewedStrainGuide
            || !viewedTerpenes
        ) {
            return null;
        }

        int productCount =
                userActivityService
                        .countDistinctActivityValuesByType(
                                userId,
                                UserActivityType.PRODUCTS_VIEW
                        );

        if (
            productCount
                    < KNOW_YOUR_BUDS_PRODUCT_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.KNOW_YOUR_BUDS
        );
    }


    // Unlock Read the Label after exploring every product category
    private UserCollectible checkReadTheLabel(
            int userId
    ) {

        UserCollectible readTheLabel =
                getUserCollectible(
                        userId,
                        CollectibleCode.READ_THE_LABEL
                );

        if (readTheLabel != null) {
            return null;
        }

        int productCount =
                userActivityService
                        .countDistinctActivityValuesByType(
                                userId,
                                UserActivityType.PRODUCTS_VIEW
                        );

        if (
            productCount
                    < READ_THE_LABEL_PRODUCT_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.READ_THE_LABEL
        );
    }


    // Unlock Safety First after exploring a safety topic
    private UserCollectible checkSafetyFirst(
            int userId
    ) {

        UserCollectible safetyFirst =
                getUserCollectible(
                        userId,
                        CollectibleCode.SAFETY_FIRST
                );

        if (safetyFirst != null) {
            return null;
        }

        int safetyTopicCount =
                userActivityService
                        .countDistinctActivityValuesByType(
                                userId,
                                UserActivityType.SAFETY_VIEW
                        );

        if (
            safetyTopicCount
                    < SAFETY_FIRST_TOPIC_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.SAFETY_FIRST
        );
    }


    // Unlock Clear Head after exploring every safety topic
    private UserCollectible checkClearHead(
            int userId
    ) {

        UserCollectible clearHead =
                getUserCollectible(
                        userId,
                        CollectibleCode.CLEAR_HEAD
                );

        if (clearHead != null) {
            return null;
        }

        int safetyTopicCount =
                userActivityService
                        .countDistinctActivityValuesByType(
                                userId,
                                UserActivityType.SAFETY_VIEW
                        );

        if (
            safetyTopicCount
                    < CLEAR_HEAD_TOPIC_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.CLEAR_HEAD
        );
    }

    // Unlock The Regular after visiting Best Buds on five different dates
    private UserCollectible checkTheRegular(
            int userId
    ) {

        UserCollectible theRegular =
                getUserCollectible(
                        userId,
                        CollectibleCode.THE_REGULAR
                );

        if (theRegular != null) {
            return null;
        }

        int visitDateCount =
                userActivityService
                        .countDistinctActivityValuesByType(
                                userId,
                                UserActivityType.APP_VISIT
                        );

        if (
            visitDateCount
                    < THE_REGULAR_VISIT_DATE_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.THE_REGULAR
        );
    }


    // Unlock The Whole Picture after exploring every major content area
    private UserCollectible checkTheWholePicture(
            int userId
    ) {

        UserCollectible theWholePicture =
                getUserCollectible(
                        userId,
                        CollectibleCode.THE_WHOLE_PICTURE
                );

        if (theWholePicture != null) {
            return null;
        }

        int dispensaryViewCount =
                userActivityService
                        .countUserActivitiesByType(
                                userId,
                                UserActivityType.DISPENSARY_VIEW
                        );

        int articlesViewCount =
                userActivityService
                        .countUserActivitiesByType(
                                userId,
                                UserActivityType.ARTICLES_VIEW
                        );

        int educationViewCount =
                userActivityService
                        .countUserActivitiesByType(
                                userId,
                                UserActivityType.EDUCATION_VIEW
                        );

        int productsViewCount =
                userActivityService
                        .countUserActivitiesByType(
                                userId,
                                UserActivityType.PRODUCTS_VIEW
                        );

        int safetyViewCount =
                userActivityService
                        .countUserActivitiesByType(
                                userId,
                                UserActivityType.SAFETY_VIEW
                        );

        if (
            dispensaryViewCount
                    < THE_WHOLE_PICTURE_ACTIVITY_COUNT
            || articlesViewCount
                    < THE_WHOLE_PICTURE_ACTIVITY_COUNT
            || educationViewCount
                    < THE_WHOLE_PICTURE_ACTIVITY_COUNT
            || productsViewCount
                    < THE_WHOLE_PICTURE_ACTIVITY_COUNT
            || safetyViewCount
                    < THE_WHOLE_PICTURE_ACTIVITY_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.THE_WHOLE_PICTURE
        );
    }


    // Unlock Curator after saving at least ten dispensaries
    private UserCollectible checkCurator(
            int userId
    ) {

        UserCollectible curator =
                getUserCollectible(
                        userId,
                        CollectibleCode.CURATOR
                );

        if (curator != null) {
            return null;
        }

        int savedDispensaryCount =
                savedDispensaryService
                        .countSavedDispensaries(
                                userId
                        );

        if (
            savedDispensaryCount
                    < CURATOR_SAVED_DISPENSARY_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.CURATOR
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
                        CollectibleCode.NIGHT_OWL
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

        if (!currentTime.isBefore(NIGHT_OWL_END)) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.NIGHT_OWL
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
                        CollectibleCode.BIRTHDAY_BUD
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

        if (
            birthday == null
            || today == null
        ) {
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
                CollectibleCode.BIRTHDAY_BUD
        );
    }


    // Unlock Stashed after earning at least one other Drop
    private UserCollectible checkStashed(
            int userId
    ) {

        UserCollectible stashed =
                getUserCollectible(
                        userId,
                        CollectibleCode.STASHED
                );

        if (stashed != null) {
            return null;
        }

        int collectibleCount =
                collectibleDao.countUserCollectibles(
                        userId
                );

        if (
            collectibleCount
                    < STASHED_COLLECTIBLE_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.STASHED
        );
    }

    // Unlock Completionist after earning at least twelve other Drops
    private UserCollectible checkCompletionist(
            int userId
    ) {

        UserCollectible completionist =
                getUserCollectible(
                        userId,
                        CollectibleCode.COMPLETIONIST
                );

        if (completionist != null) {
            return null;
        }

        int collectibleCount =
                collectibleDao.countUserCollectibles(
                        userId
                );

        if (
            collectibleCount
                    < COMPLETIONIST_COLLECTIBLE_COUNT
        ) {
            return null;
        }

        return unlockCollectible(
                userId,
                CollectibleCode.COMPLETIONIST
        );
    }
}