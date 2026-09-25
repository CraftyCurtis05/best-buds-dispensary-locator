package com.bestbuds.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserActivity {

    private int activityId;
    private int userId;
    private String activityType;
    private String activityValue;
    private LocalDate activityDate;
    private LocalDateTime createdAt;

    public UserActivity() {
    }

    public UserActivity(
            int activityId,
            int userId,
            String activityType,
            String activityValue,
            LocalDate activityDate,
            LocalDateTime createdAt
    ) {
        this.activityId = activityId;
        this.userId = userId;
        this.activityType = activityType;
        this.activityValue = activityValue;
        this.activityDate = activityDate;
        this.createdAt = createdAt;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityValue() {
        return activityValue;
    }

    public void setActivityValue(String activityValue) {
        this.activityValue = activityValue;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}