package com.bestbuds.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class SavedDispensary {

    private int id;
    private int userId;
    private String yelpBusinessId;
    private String name;
    private String imageUrl;
    private String address;
    private String city;
    private String stateAbbr;
    private String zipcode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal rating;
    private LocalDateTime savedAt;

    public SavedDispensary() {
    }

    public SavedDispensary(
            int id,
            int userId,
            String yelpBusinessId,
            String name,
            String imageUrl,
            String address,
            String city,
            String stateAbbr,
            String zipcode,
            BigDecimal latitude,
            BigDecimal longitude,
            BigDecimal rating,
            LocalDateTime savedAt
    ) {
        this.id = id;
        this.userId = userId;
        this.yelpBusinessId = yelpBusinessId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.address = address;
        this.city = city;
        this.stateAbbr = stateAbbr;
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.savedAt = savedAt;
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

    public String getYelpBusinessId() {
        return yelpBusinessId;
    }

    public void setYelpBusinessId(
            String yelpBusinessId
    ) {
        this.yelpBusinessId = yelpBusinessId;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(
            String imageUrl
    ) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(
            String address
    ) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(
            String city
    ) {
        this.city = city;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(
            String stateAbbr
    ) {
        this.stateAbbr = stateAbbr;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(
            String zipcode
    ) {
        this.zipcode = zipcode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(
            BigDecimal latitude
    ) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(
            BigDecimal longitude
    ) {
        this.longitude = longitude;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(
            BigDecimal rating
    ) {
        this.rating = rating;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(
            LocalDateTime savedAt
    ) {
        this.savedAt = savedAt;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof SavedDispensary savedDispensary)) {
            return false;
        }

        return id == savedDispensary.id
                && userId == savedDispensary.userId
                && Objects.equals(
                        yelpBusinessId,
                        savedDispensary.yelpBusinessId
                )
                && Objects.equals(
                        name,
                        savedDispensary.name
                )
                && Objects.equals(
                        imageUrl,
                        savedDispensary.imageUrl
                )
                && Objects.equals(
                        address,
                        savedDispensary.address
                )
                && Objects.equals(
                        city,
                        savedDispensary.city
                )
                && Objects.equals(
                        stateAbbr,
                        savedDispensary.stateAbbr
                )
                && Objects.equals(
                        zipcode,
                        savedDispensary.zipcode
                )
                && Objects.equals(
                        latitude,
                        savedDispensary.latitude
                )
                && Objects.equals(
                        longitude,
                        savedDispensary.longitude
                )
                && Objects.equals(
                        rating,
                        savedDispensary.rating
                )
                && Objects.equals(
                        savedAt,
                        savedDispensary.savedAt
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                userId,
                yelpBusinessId,
                name,
                imageUrl,
                address,
                city,
                stateAbbr,
                zipcode,
                latitude,
                longitude,
                rating,
                savedAt
        );
    }

    @Override
    public String toString() {
        return "SavedDispensary{" +
                "id=" + id +
                ", userId=" + userId +
                ", yelpBusinessId='" + yelpBusinessId + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", rating=" + rating +
                ", savedAt=" + savedAt +
                '}';
    }
}