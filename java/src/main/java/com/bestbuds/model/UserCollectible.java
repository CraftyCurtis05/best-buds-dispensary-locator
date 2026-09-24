package com.bestbuds.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserCollectible {

    private int id;
    private int userId;
    private Collectible collectible;
    private LocalDateTime unlockedAt;

    public UserCollectible() {
    }

    public UserCollectible(
            int id,
            int userId,
            Collectible collectible,
            LocalDateTime unlockedAt
    ) {
        this.id = id;
        this.userId = userId;
        this.collectible = collectible;
        this.unlockedAt = unlockedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(
            int userId
    ) {
        this.userId = userId;
    }

    public Collectible getCollectible() {
        return collectible;
    }

    public void setCollectible(
            Collectible collectible
    ) {
        this.collectible = collectible;
    }

    public LocalDateTime getUnlockedAt() {
        return unlockedAt;
    }

    public void setUnlockedAt(
            LocalDateTime unlockedAt
    ) {
        this.unlockedAt = unlockedAt;
    }

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof UserCollectible userCollectible)) {
            return false;
        }

        return id == userCollectible.id
                && userId == userCollectible.userId
                && Objects.equals(
                        collectible,
                        userCollectible.collectible
                )
                && Objects.equals(
                        unlockedAt,
                        userCollectible.unlockedAt
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                userId,
                collectible,
                unlockedAt
        );
    }

    @Override
    public String toString() {
        return "UserCollectible{" +
                "id=" + id +
                ", userId=" + userId +
                ", collectible=" + collectible +
                ", unlockedAt=" + unlockedAt +
                '}';
    }
}