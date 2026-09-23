package com.bestbuds.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class SavedDispensaryDto {

    @NotBlank(message = "Yelp business ID is required.")
    @Size(
            max = 100,
            message = "Yelp business ID must be 100 characters or fewer."
    )
    private String yelpBusinessId;

    @NotBlank(message = "Dispensary name is required.")
    @Size(
            max = 150,
            message = "Dispensary name must be 150 characters or fewer."
    )
    private String name;

    private String imageUrl;

    @Size(
            max = 200,
            message = "Address must be 200 characters or fewer."
    )
    private String address;

    @Size(
            max = 100,
            message = "City must be 100 characters or fewer."
    )
    private String city;

    @Size(
            max = 2,
            message = "State must be a two-letter abbreviation."
    )
    private String stateAbbr;

    @Size(
            max = 10,
            message = "ZIP code must be 10 characters or fewer."
    )
    private String zipcode;

    @DecimalMin(
            value = "-90.0",
            message = "Latitude must be at least -90."
    )
    @DecimalMax(
            value = "90.0",
            message = "Latitude must be no greater than 90."
    )
    private BigDecimal latitude;

    @DecimalMin(
            value = "-180.0",
            message = "Longitude must be at least -180."
    )
    @DecimalMax(
            value = "180.0",
            message = "Longitude must be no greater than 180."
    )
    private BigDecimal longitude;

    @DecimalMin(
            value = "0.0",
            message = "Rating must be at least 0."
    )
    @DecimalMax(
            value = "5.0",
            message = "Rating must be no greater than 5."
    )
    private BigDecimal rating;

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
}