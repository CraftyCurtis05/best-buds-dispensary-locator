package com.bestbuds.model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProfileDto {

    @Size(
            max = 50,
            message = "First name must be 50 characters or fewer."
    )
    private String firstName;

    @Size(
            max = 50,
            message = "Last name must be 50 characters or fewer."
    )
    private String lastName;

    @Past(
            message = "Birthday must be in the past."
    )
    private LocalDate birthday;

    @Size(
            max = 150,
            message = "Address must be 150 characters or fewer."
    )
    private String addressLine1;

    @Size(
            max = 100,
            message = "Address line 2 must be 100 characters or fewer."
    )
    private String addressLine2;

    @Size(
            max = 100,
            message = "City must be 100 characters or fewer."
    )
    private String city;

    @Pattern(
            regexp = "^[A-Za-z]{2}$",
            message = "State must be a two-letter abbreviation."
    )
    private String stateAbbr;

    @Pattern(
            regexp = "^\\d{5}(-\\d{4})?$",
            message = "ZIP code must use 12345 or 12345-6789 format."
    )
    private String zipcode;

    public ProfileDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(
            String firstName
    ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(
            String lastName
    ) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(
            LocalDate birthday
    ) {
        this.birthday = birthday;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(
            String addressLine1
    ) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(
            String addressLine2
    ) {
        this.addressLine2 = addressLine2;
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
}