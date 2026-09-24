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
    public void checkForDrops_returns_collectible_when_drop_is_available() {

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
                        userCollectible
                );

        ResponseEntity<UserCollectible> response =
                sut.checkForDrops(
                        authentication
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

        verify(collectibleService).checkForDrops(
                1
        );
    }

    @Test
    public void checkForDrops_returns_no_content_when_no_drop_is_available() {

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
                        null
                );

        ResponseEntity<UserCollectible> response =
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