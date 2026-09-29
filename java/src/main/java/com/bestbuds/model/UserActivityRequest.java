package com.bestbuds.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserActivityRequest {

    @NotBlank(
            message = "Activity type is required."
    )
    @Size(
            max = 50,
            message = "Activity type must be 50 characters or fewer."
    )
    private String activityType;

    @NotBlank(
            message = "Activity value is required."
    )
    @Size(
            max = 2048,
            message = "Activity value must be 2048 characters or fewer."
    )
    private String activityValue;


    public UserActivityRequest() {
    }

    public UserActivityRequest(
            String activityType,
            String activityValue
    ) {
        this.activityType = activityType;
        this.activityValue = activityValue;
    }


    public String getActivityType() {
        return activityType;
    }


    public void setActivityType(
            String activityType
    ) {
        this.activityType = activityType;
    }


    public String getActivityValue() {
        return activityValue;
    }


    public void setActivityValue(
            String activityValue
    ) {
        this.activityValue = activityValue;
    }
}