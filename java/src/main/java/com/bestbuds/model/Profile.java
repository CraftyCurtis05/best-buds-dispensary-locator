package com.bestbuds.model;

import java.time.LocalDate;
import java.util.Objects;

public class Profile {

    private int id;
    private int userId;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateAbbr;
    private String zipcode;

    public Profile() {
    }

    public Profile(
            int id,
            int userId,
            String firstName,
            String lastName,
            LocalDate birthday,
            String addressLine1,
            String addressLine2,
            String city,
            String stateAbbr,
            String zipcode
    ) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.stateAbbr = stateAbbr;
        this.zipcode = zipcode;
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

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof Profile profile)) {
            return false;
        }

        return id == profile.id
                && userId == profile.userId
                && Objects.equals(
                        firstName,
                        profile.firstName
                )
                && Objects.equals(
                        lastName,
                        profile.lastName
                )
                && Objects.equals(
                        birthday,
                        profile.birthday
                )
                && Objects.equals(
                        addressLine1,
                        profile.addressLine1
                )
                && Objects.equals(
                        addressLine2,
                        profile.addressLine2
                )
                && Objects.equals(
                        city,
                        profile.city
                )
                && Objects.equals(
                        stateAbbr,
                        profile.stateAbbr
                )
                && Objects.equals(
                        zipcode,
                        profile.zipcode
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                userId,
                firstName,
                lastName,
                birthday,
                addressLine1,
                addressLine2,
                city,
                stateAbbr,
                zipcode
        );
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}