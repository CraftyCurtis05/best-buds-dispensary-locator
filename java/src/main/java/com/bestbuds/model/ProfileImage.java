package com.bestbuds.model;

import java.util.Arrays;
import java.util.Objects;

public class ProfileImage {

    private int id;
    private int userId;
    private byte[] imageData;
    private String contentType;

    public ProfileImage() {
    }

    public ProfileImage(
            int id,
            int userId,
            byte[] imageData,
            String contentType
    ) {
        this.id = id;
        this.userId = userId;
        this.imageData = imageData;
        this.contentType = contentType;
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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(
            byte[] imageData
    ) {
        this.imageData = imageData;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(
            String contentType
    ) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof ProfileImage profileImage)) {
            return false;
        }

        return id == profileImage.id
                && userId == profileImage.userId
                && Arrays.equals(
                        imageData,
                        profileImage.imageData
                )
                && Objects.equals(
                        contentType,
                        profileImage.contentType
                );
    }

    @Override
    public int hashCode() {

        int result =
                Objects.hash(
                        id,
                        userId,
                        contentType
                );

        result =
                31 * result
                        + Arrays.hashCode(
                                imageData
                        );

        return result;
    }

    @Override
    public String toString() {
        return "ProfileImage{" +
                "id=" + id +
                ", userId=" + userId +
                ", imageDataLength=" +
                (imageData == null ? 0 : imageData.length) +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}