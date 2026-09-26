package com.bestbuds.controller;

import com.bestbuds.model.Collectible;
import com.bestbuds.model.User;
import com.bestbuds.model.UserCollectible;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.CollectibleService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CollectibleControllerTests {

    private CollectibleService collectibleService;
    private AuthenticationService authenticationService;
    private Authentication authentication;
    private CollectibleController sut;

    @BeforeEach
    public void setup() {

        collectibleService =
                mock(CollectibleService.class);

        authenticationService =
                mock(AuthenticationService.class);

        authentication =
                mock(Authentication.class);

        sut =
                new CollectibleController(
                        collectibleService,
                        authenticationService
                );
    }

    @Test
    public void getUserCollectibles_returns_collectibles_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        Collectible collectible =
                new Collectible();

        collectible.setId(
                10
        );

        collectible.setCode(
                "BIRTHDAY_BUD"
        );

        collectible.setName(
                "Birthday Bud"
        );

        UserCollectible userCollectible =
                new UserCollectible();

        userCollectible.setId(
                20
        );

        userCollectible.setUserId(
                1
        );

        userCollectible.setCollectible(
                collectible
        );

        List<UserCollectible> userCollectibles =
                List.of(
                        userCollectible
                );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        when(collectibleService.getUserCollectibles(1))
                .thenReturn(
                        userCollectibles
                );

        ResponseEntity<List<UserCollectible>> response =
                sut.getUserCollectibles(
                        authentication
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                userCollectibles,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(collectibleService).getUserCollectibles(
                1
        );
    }

    @Test
    public void checkForDrops_returns_collectibles_when_drops_are_available() {

        User user =
                new User();

        user.setId(
                1
        );

        Collectible firstContactCollectible =
                new Collectible();

        firstContactCollectible.setId(
                1
        );

        firstContactCollectible.setCode(
                "FIRST_CONTACT"
        );

        firstContactCollectible.setName(
                "First Contact"
        );

        UserCollectible firstContact =
                new UserCollectible();

        firstContact.setId(
                20
        );

        firstContact.setUserId(
                1
        );

        firstContact.setCollectible(
                firstContactCollectible
        );

        Collectible birthdayCollectible =
                new Collectible();

        birthdayCollectible.setId(
                18
        );

        birthdayCollectible.setCode(
                "BIRTHDAY_BUD"
        );

        birthdayCollectible.setName(
                "Birthday Bud"
        );

        UserCollectible birthdayBud =
                new UserCollectible();

        birthdayBud.setId(
                21
        );

        birthdayBud.setUserId(
                1
        );

        birthdayBud.setCollectible(
                birthdayCollectible
        );

        List<UserCollectible> newDrops =
                List.of(
                        firstContact,
                        birthdayBud
                );

        when(authentication.getName())
                .thenReturn(
                        "user1"
                );

        when(authenticationService.getUser("user1"))
                .thenReturn(
                        user
                );

        when(collectibleService.checkForDrops(1))
                .thenReturn(
                        newDrops
                );

        ResponseEntity<List<UserCollectible>> response =
                sut.checkForDrops(
                        authentication
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                newDrops,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(collectibleService).checkForDrops(
                1
        );
    }

    @Test
    public void checkForDrops_returns_no_content_when_no_drops_are_available() {

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

        when(collectibleService.checkForDrops(1))
                .thenReturn(
                        List.of()
                );

        ResponseEntity<List<UserCollectible>> response =
                sut.checkForDrops(
                        authentication
                );

        assertEquals(
                204,
                response.getStatusCode().value()
        );

        assertNull(
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(collectibleService).checkForDrops(
                1
        );
    }

    @Test
    public void getUserCollectible_returns_collectible_for_authenticated_user() {

        User user =
                new User();

        user.setId(
                1
        );

        Collectible collectible =
                new Collectible();

        collectible.setId(
                10
        );

        collectible.setCode(
                "TRAIL_BLAZER"
        );

        collectible.setName(
                "Trail Blazer"
        );

        UserCollectible userCollectible =
                new UserCollectible();

        userCollectible.setId(
                20
        );

        userCollectible.setUserId(
                1
        );

        userCollectible.setCollectible(
                collectible
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
                collectibleService.getUserCollectible(
                        1,
                        "TRAIL_BLAZER"
                )
        ).thenReturn(
                userCollectible
        );

        ResponseEntity<UserCollectible> response =
                sut.getUserCollectible(
                        authentication,
                        "TRAIL_BLAZER"
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                userCollectible,
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(collectibleService).getUserCollectible(
                1,
                "TRAIL_BLAZER"
        );
    }

    @Test
    public void getUserCollectible_returns_not_found_when_collectible_is_not_unlocked() {

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

        when(
                collectibleService.getUserCollectible(
                        1,
                        "GOLDEN_BUD"
                )
        ).thenReturn(
                null
        );

        ResponseEntity<UserCollectible> response =
                sut.getUserCollectible(
                        authentication,
                        "GOLDEN_BUD"
                );

        assertEquals(
                404,
                response.getStatusCode().value()
        );

        assertNull(
                response.getBody()
        );

        verify(authenticationService).getUser(
                "user1"
        );

        verify(collectibleService).getUserCollectible(
                1,
                "GOLDEN_BUD"
        );
    }
}