package com.bestbuds.service;

import com.bestbuds.dao.CollectibleDao;
import com.bestbuds.model.Collectible;
import com.bestbuds.model.UserCollectible;
import com.bestbuds.model.Profile;
import com.bestbuds.model.UserActivity;
import com.bestbuds.model.UserActivityType;

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
                        userActivityService
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
}