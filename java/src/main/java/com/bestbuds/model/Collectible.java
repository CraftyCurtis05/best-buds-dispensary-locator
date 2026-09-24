package com.bestbuds.model;

import java.util.Objects;

public class Collectible {

    private int id;
    private String code;
    private String name;
    private String description;
    private String rarity;
    private String category;
    private boolean secret;

    public Collectible() {
    }

    public Collectible(
            int id,
            String code,
            String name,
            String description,
            String rarity,
            String category,
            boolean secret
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.category = category;
        this.secret = secret;
    }

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(
            String code
    ) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description
    ) {
        this.description = description;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(
            String rarity
    ) {
        this.rarity = rarity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(
            String category
    ) {
        this.category = category;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(
            boolean secret
    ) {
        this.secret = secret;
    }

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof Collectible collectible)) {
            return false;
        }

        return id == collectible.id
                && secret == collectible.secret
                && Objects.equals(
                        code,
                        collectible.code
                )
                && Objects.equals(
                        name,
                        collectible.name
                )
                && Objects.equals(
                        description,
                        collectible.description
                )
                && Objects.equals(
                        rarity,
                        collectible.rarity
                )
                && Objects.equals(
                        category,
                        collectible.category
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                code,
                name,
                description,
                rarity,
                category,
                secret
        );
    }

    @Override
    public String toString() {
        return "Collectible{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rarity='" + rarity + '\'' +
                ", category='" + category + '\'' +
                ", secret=" + secret +
                '}';
    }
}