package com.bestbuds.model;

public class UserActivityRequest {

    private String activityType;
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