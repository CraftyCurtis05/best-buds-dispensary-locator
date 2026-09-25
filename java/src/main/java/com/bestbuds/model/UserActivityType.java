package com.bestbuds.model;

public class UserActivityType {

    // User opened or returned to Best Buds
    public static final String APP_VISIT =
            "APP_VISIT";

    // User viewed a dispensary
    public static final String DISPENSARY_VIEW =
            "DISPENSARY_VIEW";

    // User searched a location for dispensaries
    public static final String AREA_SEARCH =
            "AREA_SEARCH";

    // User viewed an educational article
    public static final String ARTICLE_VIEW =
            "ARTICLE_VIEW";

    // User explored educational content
    public static final String EDUCATION_VIEW =
            "EDUCATION_VIEW";

    // User explored product information
    public static final String PRODUCT_VIEW =
            "PRODUCT_VIEW";

    // User explored safety information
    public static final String SAFETY_VIEW =
            "SAFETY_VIEW";


    private UserActivityType() {
    }
}