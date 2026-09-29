package com.bestbuds.service;

import com.bestbuds.dao.CollectibleDao;
import com.bestbuds.model.Collectible;
import com.bestbuds.model.CollectibleCode;
import com.bestbuds.model.Profile;
import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityType;
import com.bestbuds.model.UserCollectible;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

public class CollectibleServiceTests {

    @Mock
    private CollectibleDao collectibleDao;

    @Mock
    private ProfileService profileService;

    @Mock
    private UserActivityService userActivityService;

    @Mock
    private SavedDispensaryService savedDispensaryService;

    private CollectibleService collectibleService;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(
                this
        );

        collectibleService =
                new CollectibleService(
                        collectibleDao,
                        profileService,
                        userActivityService,
                        savedDispensaryService
                );

        when(
                userActivityService.getUserActivitiesByType(
                        1,
                        UserActivityType.DISPENSARY_VIEW
                )
        ).thenReturn(
                List.of()
        );
    }

    @Test
    public void getCollectible_returns_collectible_by_code() {

        Collectible collectible =
                createCollectible(
                        1,
                        "BIRTHDAY_BUD",
                        "Birthday Bud"
                );

        when(
                collectibleDao.getCollectibleByCode(
                        "BIRTHDAY_BUD"
                )
        ).thenReturn(
                collectible
        );

        Collectible result =
                collectibleService.getCollectible(
                        "BIRTHDAY_BUD"
                );

        assertSame(
                collectible,
                result
        );

        verify(
                collectibleDao
        ).getCollectibleByCode(
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void checkForDrops_unlocks_first_contact_after_first_dispensary_view() {

        UserActivity dispensaryView =
                new UserActivity();

        dispensaryView.setUserId(
                1
        );

        dispensaryView.setActivityType(
                UserActivityType.DISPENSARY_VIEW
        );

        dispensaryView.setActivityValue(
                "test-dispensary"
        );

        UserCollectible firstContact =
                createUserCollectible(
                        1,
                        1,
                        createCollectible(
                                1,
                                "FIRST_CONTACT",
                                "First Contact"
                        )
                );

        when(
                userActivityService.getUserActivitiesByType(
                        1,
                        UserActivityType.DISPENSARY_VIEW
                )
        ).thenReturn(
                List.of(
                        dispensaryView
                )
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "FIRST_CONTACT"
                )
        ).thenReturn(
                firstContact
        );

        when(
                profileService.getProfile(
                        1
                )
        ).thenReturn(
                null
        );

        List<UserCollectible> result =
                collectibleService.checkForDrops(
                        1,
                        LocalDate.of(
                                2026,
                                9,
                                24
                        ),
                        LocalTime.of(
                                12,
                                0
                        )
                );

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                firstContact,
                result.get(0)
        );

        verify(
                userActivityService
        ).getUserActivitiesByType(
                1,
                UserActivityType.DISPENSARY_VIEW
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "FIRST_CONTACT"
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_first_contact_without_dispensary_view() {

        when(
                userActivityService.getUserActivitiesByType(
                        1,
                        UserActivityType.DISPENSARY_VIEW
                )
        ).thenReturn(
                List.of()
        );

        when(
                profileService.getProfile(
                        1
                )
        ).thenReturn(
                null
        );

        List<UserCollectible> result =
                collectibleService.checkForDrops(
                        1,
                        LocalDate.of(
                                2026,
                                9,
                                24
                        ),
                        LocalTime.of(
                                12,
                                0
                        )
                );

        assertTrue(
                result.isEmpty()
        );

        verify(
                userActivityService
        ).getUserActivitiesByType(
                1,
                UserActivityType.DISPENSARY_VIEW
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "FIRST_CONTACT"
        );
    }

    @Test
    public void checkForDrops_unlocks_night_owl_during_early_morning() {

        UserCollectible nightOwl =
                createUserCollectible(
                        2,
                        1,
                        createCollectible(
                                2,
                                "NIGHT_OWL",
                                "Night Owl"
                        )
                );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "NIGHT_OWL"
                )
        ).thenReturn(
                nightOwl
        );

        when(
                profileService.getProfile(
                        1
                )
        ).thenReturn(
                null
        );

        List<UserCollectible> result =
                collectibleService.checkForDrops(
                        1,
                        LocalDate.of(
                                2026,
                                9,
                                24
                        ),
                        LocalTime.of(
                                2,
                                30
                        )
                );

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                nightOwl,
                result.get(0)
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "NIGHT_OWL"
        );
    }

    @Test
    public void unlockNightOwl_unlocks_collectible_at_midnight() {

        LocalTime currentTime =
                LocalTime.of(
                        0,
                        0
                );

        UserCollectible nightOwl =
                createUserCollectible(
                        2,
                        1,
                        createCollectible(
                                2,
                                "NIGHT_OWL",
                                "Night Owl"
                        )
                );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "NIGHT_OWL"
                )
        ).thenReturn(
                nightOwl
        );

        UserCollectible result =
                collectibleService.unlockNightOwl(
                        1,
                        currentTime
                );

        assertSame(
                nightOwl,
                result
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "NIGHT_OWL"
        );
    }


    @Test
    public void unlockNightOwl_unlocks_collectible_at_459_am() {

        LocalTime currentTime =
                LocalTime.of(
                        4,
                        59
                );

        UserCollectible nightOwl =
                createUserCollectible(
                        2,
                        1,
                        createCollectible(
                                2,
                                "NIGHT_OWL",
                                "Night Owl"
                        )
                );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "NIGHT_OWL"
                )
        ).thenReturn(
                nightOwl
        );

        UserCollectible result =
                collectibleService.unlockNightOwl(
                        1,
                        currentTime
                );

        assertSame(
                nightOwl,
                result
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "NIGHT_OWL"
        );
    }


    @Test
    public void unlockNightOwl_returns_null_at_5_am() {

        LocalTime currentTime =
                LocalTime.of(
                        5,
                        0
                );

        UserCollectible result =
                collectibleService.unlockNightOwl(
                        1,
                        currentTime
                );

        assertNull(
                result
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "NIGHT_OWL"
        );
    }


    @Test
    public void unlockNightOwl_returns_null_during_day() {

        LocalTime currentTime =
                LocalTime.of(
                        14,
                        30
                );

        UserCollectible result =
                collectibleService.unlockNightOwl(
                        1,
                        currentTime
                );

        assertNull(
                result
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "NIGHT_OWL"
        );
    }


    @Test
    public void unlockNightOwl_returns_null_when_time_is_missing() {

        UserCollectible result =
                collectibleService.unlockNightOwl(
                        1,
                        null
                );

        assertNull(
                result
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "NIGHT_OWL"
        );
    }

    @Test
    public void getUserCollectibles_returns_collectibles_for_user() {

        Collectible birthdayBud =
                createCollectible(
                        1,
                        "BIRTHDAY_BUD",
                        "Birthday Bud"
                );

        Collectible trailBlazer =
                createCollectible(
                        2,
                        "TRAIL_BLAZER",
                        "Trail Blazer"
                );

        UserCollectible firstUserCollectible =
                createUserCollectible(
                        10,
                        1,
                        birthdayBud
                );

        UserCollectible secondUserCollectible =
                createUserCollectible(
                        11,
                        1,
                        trailBlazer
                );

        List<UserCollectible> userCollectibles =
                List.of(
                        firstUserCollectible,
                        secondUserCollectible
                );

        when(
                collectibleDao.getUserCollectibles(
                        1
                )
        ).thenReturn(
                userCollectibles
        );

        List<UserCollectible> result =
                collectibleService.getUserCollectibles(
                        1
                );

        assertSame(
                userCollectibles,
                result
        );

        verify(
                collectibleDao
        ).getUserCollectibles(
                1
        );
    }

    @Test
    public void getUserCollectible_returns_collectible_for_user_and_code() {

        Collectible collectible =
                createCollectible(
                        1,
                        "BUD_KEEPER",
                        "Bud Keeper"
                );

        UserCollectible userCollectible =
                createUserCollectible(
                        10,
                        1,
                        collectible
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        "BUD_KEEPER"
                )
        ).thenReturn(
                userCollectible
        );

        UserCollectible result =
                collectibleService.getUserCollectible(
                        1,
                        "BUD_KEEPER"
                );

        assertSame(
                userCollectible,
                result
        );

        verify(
                collectibleDao
        ).getUserCollectible(
                1,
                "BUD_KEEPER"
        );
    }

    @Test
    public void unlockCollectible_unlocks_collectible_for_user() {

        Collectible collectible =
                createCollectible(
                        1,
                        "TRAIL_BLAZER",
                        "Trail Blazer"
                );

        UserCollectible userCollectible =
                createUserCollectible(
                        10,
                        1,
                        collectible
                );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "TRAIL_BLAZER"
                )
        ).thenReturn(
                userCollectible
        );

        UserCollectible result =
                collectibleService.unlockCollectible(
                        1,
                        "TRAIL_BLAZER"
                );

        assertSame(
                userCollectible,
                result
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "TRAIL_BLAZER"
        );
    }

    @Test
    public void checkForDrops_unlocks_birthday_bud_when_today_is_birthday() {

        Profile profile =
                new Profile();

        profile.setUserId(
                1
        );

        profile.setBirthday(
                LocalDate.of(
                        1996,
                        9,
                        24
                )
        );

        UserCollectible birthdayBud =
                createUserCollectible(
                        1,
                        1,
                        createCollectible(
                                1,
                                "BIRTHDAY_BUD",
                                "Birthday Bud"
                        )
                );

        when(
                profileService.getProfile(
                        1
                )
        ).thenReturn(
                profile
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "BIRTHDAY_BUD"
                )
        ).thenReturn(
                birthdayBud
        );

        List<UserCollectible> result =
                collectibleService.checkForDrops(
                        1,
                        LocalDate.of(
                                2026,
                                9,
                                24
                        ),
                        LocalTime.of(
                                12,
                                0
                        )
                );

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                birthdayBud,
                result.get(0)
        );

        verify(
                profileService
        ).getProfile(
                1
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void checkForDrops_returns_empty_list_when_profile_does_not_exist() {

        when(
                profileService.getProfile(
                        1
                )
        ).thenReturn(
                null
        );

        List<UserCollectible> result =
                collectibleService.checkForDrops(
                        1,
                        LocalDate.of(
                                2026,
                                9,
                                24
                        ),
                        LocalTime.of(
                                12,
                                0
                        )
                );

        assertTrue(
                result.isEmpty()
        );

        verify(
                profileService
        ).getProfile(
                1
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void checkForDrops_returns_empty_list_when_birthday_bud_is_already_unlocked() {

        UserCollectible birthdayBud =
                createUserCollectible(
                        1,
                        1,
                        createCollectible(
                                1,
                                "BIRTHDAY_BUD",
                                "Birthday Bud"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        "BIRTHDAY_BUD"
                )
        ).thenReturn(
                birthdayBud
        );

        List<UserCollectible> result =
                collectibleService.checkForDrops(
                        1,
                        LocalDate.of(
                                2026,
                                9,
                                24
                        ),
                        LocalTime.of(
                                12,
                                0
                        )
                );

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao
        ).getUserCollectible(
                1,
                "BIRTHDAY_BUD"
        );

        verify(
                profileService,
                never()
        ).getProfile(
                1
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void checkForDrops_unlocks_first_contact_and_birthday_bud_together() {

        UserActivity dispensaryView =
                new UserActivity();

        dispensaryView.setUserId(
                1
        );

        dispensaryView.setActivityType(
                UserActivityType.DISPENSARY_VIEW
        );

        dispensaryView.setActivityValue(
                "test-dispensary"
        );

        Profile profile =
                new Profile();

        profile.setUserId(
                1
        );

        profile.setBirthday(
                LocalDate.of(
                        1996,
                        9,
                        24
                )
        );

        UserCollectible firstContact =
                createUserCollectible(
                        1,
                        1,
                        createCollectible(
                                1,
                                "FIRST_CONTACT",
                                "First Contact"
                        )
                );

        UserCollectible birthdayBud =
                createUserCollectible(
                        2,
                        1,
                        createCollectible(
                                18,
                                "BIRTHDAY_BUD",
                                "Birthday Bud"
                        )
                );

        when(
                userActivityService.getUserActivitiesByType(
                        1,
                        UserActivityType.DISPENSARY_VIEW
                )
        ).thenReturn(
                List.of(
                        dispensaryView
                )
        );

        when(
                profileService.getProfile(
                        1
                )
        ).thenReturn(
                profile
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "FIRST_CONTACT"
                )
        ).thenReturn(
                firstContact
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "BIRTHDAY_BUD"
                )
        ).thenReturn(
                birthdayBud
        );

        List<UserCollectible> result =
                collectibleService.checkForDrops(
                        1,
                        LocalDate.of(
                                2026,
                                9,
                                24
                        ),
                        LocalTime.of(
                                12,
                                0
                        )
                );

        assertEquals(
                2,
                result.size()
        );

        assertSame(
                firstContact,
                result.get(0)
        );

        assertSame(
                birthdayBud,
                result.get(1)
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "FIRST_CONTACT"
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void unlockBirthdayBud_unlocks_collectible_using_current_date() {

        LocalDate birthday =
                LocalDate.now()
                        .minusYears(
                                30
                        );

        UserCollectible userCollectible =
                createUserCollectible(
                        1,
                        1,
                        createCollectible(
                                1,
                                "BIRTHDAY_BUD",
                                "Birthday Bud"
                        )
                );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "BIRTHDAY_BUD"
                )
        ).thenReturn(
                userCollectible
        );

        UserCollectible result =
                collectibleService.unlockBirthdayBud(
                        1,
                        birthday
                );

        assertSame(
                userCollectible,
                result
        );

        verify(collectibleDao).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void getProfileForCollectibles_returns_profile_for_user() {

        Profile profile =
                new Profile();

        profile.setUserId(
                1
        );

        when(
                profileService.getProfile(
                        1
                )
        ).thenReturn(
                profile
        );

        Profile result =
                collectibleService.getProfileForCollectibles(
                        1
                );

        assertSame(
                profile,
                result
        );

        verify(profileService).getProfile(
                1
        );
    }

    @Test
    public void unlockBirthdayBud_unlocks_collectible_when_today_is_birthday() {

        LocalDate birthday =
                LocalDate.of(
                        1990,
                        9,
                        24
                );

        LocalDate today =
                LocalDate.of(
                        2026,
                        9,
                        24
                );

        UserCollectible userCollectible =
                createUserCollectible(
                        1,
                        1,
                        createCollectible(
                                1,
                                "BIRTHDAY_BUD",
                                "Birthday Bud"
                        )
                );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        "BIRTHDAY_BUD"
                )
        ).thenReturn(
                userCollectible
        );

        UserCollectible result =
                collectibleService.unlockBirthdayBud(
                        1,
                        birthday,
                        today
                );

        assertSame(
                userCollectible,
                result
        );

        verify(collectibleDao).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void unlockBirthdayBud_returns_null_when_today_is_not_birthday() {

        LocalDate birthday =
                LocalDate.of(
                        1990,
                        9,
                        24
                );

        LocalDate today =
                LocalDate.of(
                        2026,
                        9,
                        25
                );

        UserCollectible result =
                collectibleService.unlockBirthdayBud(
                        1,
                        birthday,
                        today
                );

        assertNull(
                result
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void unlockBirthdayBud_returns_null_when_birthday_is_missing() {

        LocalDate today =
                LocalDate.of(
                        2026,
                        9,
                        24
                );

        UserCollectible result =
                collectibleService.unlockBirthdayBud(
                        1,
                        null,
                        today
                );

        assertNull(
                result
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                "BIRTHDAY_BUD"
        );
    }

    @Test
    public void checkForDrops_unlocks_deep_dive_at_three_distinct_articles() {

        UserCollectible deepDive =
                createUserCollectible(
                        7,
                        1,
                        createCollectible(
                                7,
                                CollectibleCode.DEEP_DIVE,
                                "Deep Dive"
                        )
                );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.ARTICLES_VIEW
                        )
        ).thenReturn(
                3
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.DEEP_DIVE
                )
        ).thenReturn(
                deepDive
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                deepDive,
                result.get(0)
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.DEEP_DIVE
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_deep_dive_before_three_articles() {

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.ARTICLES_VIEW
                        )
        ).thenReturn(
                2
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.DEEP_DIVE
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_deep_dive_when_already_owned() {

        UserCollectible deepDive =
                createUserCollectible(
                        7,
                        1,
                        createCollectible(
                                7,
                                CollectibleCode.DEEP_DIVE,
                                "Deep Dive"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.DEEP_DIVE
                )
        ).thenReturn(
                deepDive
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.DEEP_DIVE
        );
    }

    // Check Drops at a daytime hour without triggering Night Owl
    private List<UserCollectible> checkForDropsAtNoon() {

        return collectibleService.checkForDrops(
                1,
                LocalDate.of(
                        2026,
                        9,
                        24
                ),
                LocalTime.of(
                        12,
                        0
                )
        );
    }

    // Create collectible data used by service tests
    private Collectible createCollectible(
            int collectibleId,
            String code,
            String name
    ) {

        Collectible collectible =
                new Collectible();

        collectible.setId(
                collectibleId
        );

        collectible.setCode(
                code
        );

        collectible.setName(
                name
        );

        return collectible;
    }

    // Create user collectible data used by service tests
    private UserCollectible createUserCollectible(
            int userCollectibleId,
            int userId,
            Collectible collectible
    ) {

        UserCollectible userCollectible =
                new UserCollectible();

        userCollectible.setId(
                userCollectibleId
        );

        userCollectible.setUserId(
                userId
        );

        userCollectible.setCollectible(
                collectible
        );

        userCollectible.setUnlockedAt(
                LocalDateTime.of(
                        2026,
                        9,
                        24,
                        1,
                        30
                )
        );

        return userCollectible;
    }

    // Create user activity data used by service tests
    private UserActivity createUserActivity(
            int userId,
            String activityType,
            String activityValue
    ) {

        UserActivity userActivity =
                new UserActivity();

        userActivity.setUserId(
                userId
        );

        userActivity.setActivityType(
                activityType
        );

        userActivity.setActivityValue(
                activityValue
        );

        return userActivity;
    }

    @Test
    public void checkForDrops_unlocks_well_informed_at_five_education_topics() {

        UserCollectible wellInformed =
                createUserCollectible(
                        8,
                        1,
                        createCollectible(
                                8,
                                CollectibleCode.WELL_INFORMED,
                                "Well Informed"
                        )
                );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.EDUCATION_VIEW
                        )
        ).thenReturn(
                5
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.WELL_INFORMED
                )
        ).thenReturn(
                wellInformed
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                wellInformed,
                result.get(0)
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_well_informed_before_five_topics() {

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.EDUCATION_VIEW
                        )
        ).thenReturn(
                4
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.WELL_INFORMED
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_well_informed_when_already_owned() {

        UserCollectible wellInformed =
                createUserCollectible(
                        8,
                        1,
                        createCollectible(
                                8,
                                CollectibleCode.WELL_INFORMED,
                                "Well Informed"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.WELL_INFORMED
                )
        ).thenReturn(
                wellInformed
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.WELL_INFORMED
        );
    }

    @Test
    public void checkForDrops_unlocks_read_the_label_at_six_product_categories() {

        UserCollectible readTheLabel =
                createUserCollectible(
                        10,
                        1,
                        createCollectible(
                                10,
                                CollectibleCode.READ_THE_LABEL,
                                "Read the Label"
                        )
                );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.PRODUCTS_VIEW
                        )
        ).thenReturn(
                6
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.READ_THE_LABEL
                )
        ).thenReturn(
                readTheLabel
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                readTheLabel,
                result.get(0)
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_read_the_label_before_six_products() {

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.PRODUCTS_VIEW
                        )
        ).thenReturn(
                5
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.READ_THE_LABEL
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_read_the_label_when_already_owned() {

        UserCollectible readTheLabel =
                createUserCollectible(
                        10,
                        1,
                        createCollectible(
                                10,
                                CollectibleCode.READ_THE_LABEL,
                                "Read the Label"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.READ_THE_LABEL
                )
        ).thenReturn(
                readTheLabel
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.READ_THE_LABEL
        );
    }

    @Test
    public void checkForDrops_unlocks_safety_first_after_one_safety_topic() {

        UserCollectible safetyFirst =
                createUserCollectible(
                        11,
                        1,
                        createCollectible(
                                11,
                                CollectibleCode.SAFETY_FIRST,
                                "Safety First"
                        )
                );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.SAFETY_VIEW
                        )
        ).thenReturn(
                1
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.SAFETY_FIRST
                )
        ).thenReturn(
                safetyFirst
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                safetyFirst,
                result.get(0)
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_safety_first_without_safety_topic() {

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.SAFETY_VIEW
                        )
        ).thenReturn(
                0
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.SAFETY_FIRST
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_safety_first_when_already_owned() {

        UserCollectible safetyFirst =
                createUserCollectible(
                        11,
                        1,
                        createCollectible(
                                11,
                                CollectibleCode.SAFETY_FIRST,
                                "Safety First"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.SAFETY_FIRST
                )
        ).thenReturn(
                safetyFirst
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.SAFETY_FIRST
        );
    }

    @Test
    public void checkForDrops_unlocks_clear_head_at_four_safety_topics() {

        UserCollectible safetyFirst =
                createUserCollectible(
                        11,
                        1,
                        createCollectible(
                                11,
                                CollectibleCode.SAFETY_FIRST,
                                "Safety First"
                        )
                );

        UserCollectible clearHead =
                createUserCollectible(
                        12,
                        1,
                        createCollectible(
                                12,
                                CollectibleCode.CLEAR_HEAD,
                                "Clear Head"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.SAFETY_FIRST
                )
        ).thenReturn(
                safetyFirst
        );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.SAFETY_VIEW
                        )
        ).thenReturn(
                4
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.CLEAR_HEAD
                )
        ).thenReturn(
                clearHead
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                clearHead,
                result.get(0)
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_clear_head_before_four_topics() {

        UserCollectible safetyFirst =
                createUserCollectible(
                        11,
                        1,
                        createCollectible(
                                11,
                                CollectibleCode.SAFETY_FIRST,
                                "Safety First"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.SAFETY_FIRST
                )
        ).thenReturn(
                safetyFirst
        );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.SAFETY_VIEW
                        )
        ).thenReturn(
                3
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.CLEAR_HEAD
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_clear_head_when_already_owned() {

        UserCollectible safetyFirst =
                createUserCollectible(
                        11,
                        1,
                        createCollectible(
                                11,
                                CollectibleCode.SAFETY_FIRST,
                                "Safety First"
                        )
                );

        UserCollectible clearHead =
                createUserCollectible(
                        12,
                        1,
                        createCollectible(
                                12,
                                CollectibleCode.CLEAR_HEAD,
                                "Clear Head"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.SAFETY_FIRST
                )
        ).thenReturn(
                safetyFirst
        );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.CLEAR_HEAD
                )
        ).thenReturn(
                clearHead
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.CLEAR_HEAD
        );
    }

    @Test
    public void checkForDrops_unlocks_explorer_at_five_distinct_activity_types() {

        UserCollectible explorer =
                createUserCollectible(
                        4,
                        1,
                        createCollectible(
                                4,
                                CollectibleCode.EXPLORER,
                                "Explorer"
                        )
                );

        when(
                userActivityService
                        .countDistinctActivityTypes(
                                1
                        )
        ).thenReturn(
                5
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.EXPLORER
                )
        ).thenReturn(
                explorer
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                explorer,
                result.get(0)
        );

        verify(
                userActivityService
        ).countDistinctActivityTypes(
                1
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.EXPLORER
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_explorer_before_five_activity_types() {

        when(
                userActivityService
                        .countDistinctActivityTypes(
                                1
                        )
        ).thenReturn(
                4
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                userActivityService
        ).countDistinctActivityTypes(
                1
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.EXPLORER
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_explorer_when_already_owned() {

        UserCollectible explorer =
                createUserCollectible(
                        4,
                        1,
                        createCollectible(
                                4,
                                CollectibleCode.EXPLORER,
                                "Explorer"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.EXPLORER
                )
        ).thenReturn(
                explorer
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                userActivityService,
                never()
        ).countDistinctActivityTypes(
                1
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.EXPLORER
        );
    }

    @Test
    public void checkForDrops_unlocks_the_regular_at_five_visit_dates() {

        UserCollectible theRegular =
                createUserCollectible(
                        14,
                        1,
                        createCollectible(
                                14,
                                CollectibleCode.THE_REGULAR,
                                "The Regular"
                        )
                );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.APP_VISIT
                        )
        ).thenReturn(
                5
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.THE_REGULAR
                )
        ).thenReturn(
                theRegular
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                theRegular,
                result.get(0)
        );

        verify(
                userActivityService
        ).countDistinctActivityValuesByType(
                1,
                UserActivityType.APP_VISIT
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.THE_REGULAR
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_the_regular_before_five_visit_dates() {

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.APP_VISIT
                        )
        ).thenReturn(
                4
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                userActivityService
        ).countDistinctActivityValuesByType(
                1,
                UserActivityType.APP_VISIT
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.THE_REGULAR
        );
    }


    @Test
    public void checkForDrops_does_not_unlock_the_regular_when_already_owned() {

        UserCollectible theRegular =
                createUserCollectible(
                        14,
                        1,
                        createCollectible(
                                14,
                                CollectibleCode.THE_REGULAR,
                                "The Regular"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.THE_REGULAR
                )
        ).thenReturn(
                theRegular
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                userActivityService,
                never()
        ).countDistinctActivityValuesByType(
                1,
                UserActivityType.APP_VISIT
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.THE_REGULAR
        );
    }

    @Test
    public void checkForDrops_unlocks_the_whole_picture_after_all_major_areas() {

        UserCollectible theWholePicture =
                createUserCollectible(
                        16,
                        1,
                        createCollectible(
                                16,
                                CollectibleCode.THE_WHOLE_PICTURE,
                                "The Whole Picture"
                        )
                );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.DISPENSARY_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.ARTICLES_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.EDUCATION_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.PRODUCTS_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.SAFETY_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.THE_WHOLE_PICTURE
                )
        ).thenReturn(
                theWholePicture
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                theWholePicture,
                result.get(0)
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.THE_WHOLE_PICTURE
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_the_whole_picture_when_area_is_missing() {

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.DISPENSARY_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.ARTICLES_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.EDUCATION_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.PRODUCTS_VIEW
                )
        ).thenReturn(
                1
        );

        when(
                userActivityService.countUserActivitiesByType(
                        1,
                        UserActivityType.SAFETY_VIEW
                )
        ).thenReturn(
                0
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.THE_WHOLE_PICTURE
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_the_whole_picture_when_already_owned() {

        UserCollectible theWholePicture =
                createUserCollectible(
                        16,
                        1,
                        createCollectible(
                                16,
                                CollectibleCode.THE_WHOLE_PICTURE,
                                "The Whole Picture"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.THE_WHOLE_PICTURE
                )
        ).thenReturn(
                theWholePicture
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                userActivityService,
                never()
        ).countUserActivitiesByType(
                1,
                UserActivityType.DISPENSARY_VIEW
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.THE_WHOLE_PICTURE
        );
    }

    @Test
    public void checkForDrops_unlocks_know_your_buds_after_required_learning() {

        UserActivity strainGuide =
                createUserActivity(
                        1,
                        UserActivityType.EDUCATION_VIEW,
                        UserActivityType.EDUCATION_STRAIN_GUIDE
                );

        UserActivity terpenes =
                createUserActivity(
                        1,
                        UserActivityType.EDUCATION_VIEW,
                        UserActivityType.EDUCATION_TERPENES
                );

        UserCollectible knowYourBuds =
                createUserCollectible(
                        9,
                        1,
                        createCollectible(
                                9,
                                CollectibleCode.KNOW_YOUR_BUDS,
                                "Know Your Buds"
                        )
                );

        when(
                userActivityService
                        .getUserActivitiesByType(
                                1,
                                UserActivityType.EDUCATION_VIEW
                        )
        ).thenReturn(
                List.of(
                        strainGuide,
                        terpenes
                )
        );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.PRODUCTS_VIEW
                        )
        ).thenReturn(
                3
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.KNOW_YOUR_BUDS
                )
        ).thenReturn(
                knowYourBuds
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                knowYourBuds,
                result.get(0)
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.KNOW_YOUR_BUDS
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_know_your_buds_before_three_products() {

        UserActivity strainGuide =
                createUserActivity(
                        1,
                        UserActivityType.EDUCATION_VIEW,
                        UserActivityType.EDUCATION_STRAIN_GUIDE
                );

        UserActivity terpenes =
                createUserActivity(
                        1,
                        UserActivityType.EDUCATION_VIEW,
                        UserActivityType.EDUCATION_TERPENES
                );

        when(
                userActivityService
                        .getUserActivitiesByType(
                                1,
                                UserActivityType.EDUCATION_VIEW
                        )
        ).thenReturn(
                List.of(
                        strainGuide,
                        terpenes
                )
        );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.PRODUCTS_VIEW
                        )
        ).thenReturn(
                2
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.KNOW_YOUR_BUDS
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_know_your_buds_without_both_guides() {

        UserActivity strainGuide =
                createUserActivity(
                        1,
                        UserActivityType.EDUCATION_VIEW,
                        UserActivityType.EDUCATION_STRAIN_GUIDE
                );

        when(
                userActivityService
                        .getUserActivitiesByType(
                                1,
                                UserActivityType.EDUCATION_VIEW
                        )
        ).thenReturn(
                List.of(
                        strainGuide
                )
        );

        when(
                userActivityService
                        .countDistinctActivityValuesByType(
                                1,
                                UserActivityType.PRODUCTS_VIEW
                        )
        ).thenReturn(
                3
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.KNOW_YOUR_BUDS
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_know_your_buds_when_already_owned() {

        UserCollectible knowYourBuds =
                createUserCollectible(
                        9,
                        1,
                        createCollectible(
                                9,
                                CollectibleCode.KNOW_YOUR_BUDS,
                                "Know Your Buds"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.KNOW_YOUR_BUDS
                )
        ).thenReturn(
                knowYourBuds
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                userActivityService,
                never()
        ).getUserActivitiesByType(
                1,
                UserActivityType.EDUCATION_VIEW
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.KNOW_YOUR_BUDS
        );
    }

    @Test
    public void checkForDrops_unlocks_curator_at_ten_saved_dispensaries() {

        UserCollectible curator =
                createUserCollectible(
                        5,
                        1,
                        createCollectible(
                                5,
                                CollectibleCode.CURATOR,
                                "Curator"
                        )
                );

        when(
                savedDispensaryService
                        .countSavedDispensaries(
                                1
                        )
        ).thenReturn(
                10
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.CURATOR
                )
        ).thenReturn(
                curator
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                curator,
                result.get(0)
        );

        verify(
                savedDispensaryService
        ).countSavedDispensaries(
                1
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.CURATOR
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_curator_before_ten_saved_dispensaries() {

        when(
                savedDispensaryService
                        .countSavedDispensaries(
                                1
                        )
        ).thenReturn(
                9
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                savedDispensaryService
        ).countSavedDispensaries(
                1
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.CURATOR
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_curator_when_already_owned() {

        UserCollectible curator =
                createUserCollectible(
                        5,
                        1,
                        createCollectible(
                                5,
                                CollectibleCode.CURATOR,
                                "Curator"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.CURATOR
                )
        ).thenReturn(
                curator
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                savedDispensaryService,
                never()
        ).countSavedDispensaries(
                1
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.CURATOR
        );
    }

    @Test
    public void checkForDrops_unlocks_stashed_after_first_other_drop() {

        UserCollectible stashed =
                createUserCollectible(
                        6,
                        1,
                        createCollectible(
                                6,
                                CollectibleCode.STASHED,
                                "Stashed"
                        )
                );

        when(
                collectibleDao.countUserCollectibles(
                        1
                )
        ).thenReturn(
                1
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.STASHED
                )
        ).thenReturn(
                stashed
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                stashed,
                result.get(0)
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.STASHED
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_stashed_without_other_drop() {

        when(
                collectibleDao.countUserCollectibles(
                        1
                )
        ).thenReturn(
                0
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.STASHED
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_stashed_when_already_owned() {

        UserCollectible stashed =
                createUserCollectible(
                        6,
                        1,
                        createCollectible(
                                6,
                                CollectibleCode.STASHED,
                                "Stashed"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.STASHED
                )
        ).thenReturn(
                stashed
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.STASHED
        );
    }

    @Test
    public void checkForDrops_unlocks_completionist_at_twelve_other_drops() {

        UserCollectible stashed =
                createUserCollectible(
                        6,
                        1,
                        createCollectible(
                                6,
                                CollectibleCode.STASHED,
                                "Stashed"
                        )
                );

        UserCollectible completionist =
                createUserCollectible(
                        15,
                        1,
                        createCollectible(
                                15,
                                CollectibleCode.COMPLETIONIST,
                                "Completionist"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.STASHED
                )
        ).thenReturn(
                stashed
        );

        when(
                collectibleDao.countUserCollectibles(
                        1
                )
        ).thenReturn(
                12
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.COMPLETIONIST
                )
        ).thenReturn(
                completionist
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                1,
                result.size()
        );

        assertSame(
                completionist,
                result.get(0)
        );

        verify(
                collectibleDao
        ).unlockCollectible(
                1,
                CollectibleCode.COMPLETIONIST
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_completionist_before_twelve_other_drops() {

        UserCollectible stashed =
                createUserCollectible(
                        6,
                        1,
                        createCollectible(
                                6,
                                CollectibleCode.STASHED,
                                "Stashed"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.STASHED
                )
        ).thenReturn(
                stashed
        );

        when(
                collectibleDao.countUserCollectibles(
                        1
                )
        ).thenReturn(
                11
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.COMPLETIONIST
        );
    }

    @Test
    public void checkForDrops_does_not_unlock_completionist_when_already_owned() {

        UserCollectible stashed =
                createUserCollectible(
                        6,
                        1,
                        createCollectible(
                                6,
                                CollectibleCode.STASHED,
                                "Stashed"
                        )
                );

        UserCollectible completionist =
                createUserCollectible(
                        15,
                        1,
                        createCollectible(
                                15,
                                CollectibleCode.COMPLETIONIST,
                                "Completionist"
                        )
                );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.STASHED
                )
        ).thenReturn(
                stashed
        );

        when(
                collectibleDao.getUserCollectible(
                        1,
                        CollectibleCode.COMPLETIONIST
                )
        ).thenReturn(
                completionist
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertTrue(
                result.isEmpty()
        );

        verify(
                collectibleDao,
                never()
        ).unlockCollectible(
                1,
                CollectibleCode.COMPLETIONIST
        );
    }

    @Test
    public void checkForDrops_can_unlock_stashed_and_completionist_in_same_check() {

        UserCollectible stashed =
                createUserCollectible(
                        6,
                        1,
                        createCollectible(
                                6,
                                CollectibleCode.STASHED,
                                "Stashed"
                        )
                );

        UserCollectible completionist =
                createUserCollectible(
                        15,
                        1,
                        createCollectible(
                                15,
                                CollectibleCode.COMPLETIONIST,
                                "Completionist"
                        )
                );

        when(
                collectibleDao.countUserCollectibles(
                        1
                )
        ).thenReturn(
                11,
                12
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.STASHED
                )
        ).thenReturn(
                stashed
        );

        when(
                collectibleDao.unlockCollectible(
                        1,
                        CollectibleCode.COMPLETIONIST
                )
        ).thenReturn(
                completionist
        );

        List<UserCollectible> result =
                checkForDropsAtNoon();

        assertEquals(
                2,
                result.size()
        );

        assertSame(
                stashed,
                result.get(0)
        );

        assertSame(
                completionist,
                result.get(1)
        );
    }
}