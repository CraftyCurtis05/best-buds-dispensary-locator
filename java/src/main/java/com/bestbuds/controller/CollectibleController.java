package com.bestbuds.controller;

import com.bestbuds.model.User;
import com.bestbuds.model.UserCollectible;
import com.bestbuds.service.AuthenticationService;
import com.bestbuds.service.CollectibleService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/collectibles")
public class CollectibleController {

    private final CollectibleService collectibleService;
    private final AuthenticationService authenticationService;

    public CollectibleController(
            CollectibleService collectibleService,
            AuthenticationService authenticationService
    ) {
        this.collectibleService = collectibleService;
        this.authenticationService = authenticationService;
    }

    // Get all collectibles unlocked by the authenticated user
    @GetMapping
    public ResponseEntity<List<UserCollectible>> getUserCollectibles(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        List<UserCollectible> userCollectibles =
                collectibleService.getUserCollectibles(
                        user.getId()
                );

        return ResponseEntity.ok(
                userCollectibles
        );
    }

    // Check for automatic collectibles available to the authenticated user
    @PostMapping("/check")
    public ResponseEntity<UserCollectible> checkForDrops(
            Authentication authentication
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        UserCollectible userCollectible =
                collectibleService.checkForDrops(
                        user.getId()
                );

        if (userCollectible == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(
                userCollectible
        );
    }

    // Get a specific collectible unlocked by the authenticated user
    @GetMapping("/{code}")
    public ResponseEntity<UserCollectible> getUserCollectible(
            Authentication authentication,
            @PathVariable String code
    ) {

        User user =
                authenticationService.getUser(
                        authentication.getName()
                );

        UserCollectible userCollectible =
                collectibleService.getUserCollectible(
                        user.getId(),
                        code
                );

        if (userCollectible == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                userCollectible
        );
    }
}