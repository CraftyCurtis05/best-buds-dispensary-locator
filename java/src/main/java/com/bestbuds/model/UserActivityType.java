package com.bestbuds.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Set;

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
    public static final String ARTICLES_VIEW =
            "ARTICLES_VIEW";

    // User explored educational content
    public static final String EDUCATION_VIEW =
            "EDUCATION_VIEW";

    // User explored product information
    public static final String PRODUCTS_VIEW =
            "PRODUCTS_VIEW";

    // User explored safety information
    public static final String SAFETY_VIEW =
            "SAFETY_VIEW";

    // Education values used by collectible requirements
    public static final String EDUCATION_STRAIN_GUIDE =
            "strain-guide";

    public static final String EDUCATION_TERPENES =
            "terpenes";


    private static final Set<String> SUPPORTED_TYPES =
            Set.of(
                    APP_VISIT,
                    DISPENSARY_VIEW,
                    AREA_SEARCH,
                    ARTICLES_VIEW,
                    EDUCATION_VIEW,
                    PRODUCTS_VIEW,
                    SAFETY_VIEW
            );


    private static final Set<String> PRODUCTS_VALUES =
            Set.of(
                    "flower",
                    "edible",
                    "wax",
                    "oil",
                    "tincture",
                    "topical"
            );


    private static final Set<String> SAFETY_VALUES =
            Set.of(
                    "thc",
                    "cbd",
                    "smoking",
                    "topical"
            );


    private static final Set<String> EDUCATION_VALUES =
            Set.of(
                    "dispensary",
                    "cannabis",
                    "cbd",
                    "delta-9",
                    "flower",
                    "wax",
                    "oil",
                    "tincture",
                    "smoking",
                    "vaporizing",
                    "edible",
                    "topical",
                    EDUCATION_STRAIN_GUIDE,
                    EDUCATION_TERPENES,
                    "tips-tricks",
                    "too-much",
                    "legality"
            );


    private UserActivityType() {
    }


    // Check whether an activity type is supported by Best Buds
    public static boolean isSupported(
            String activityType
    ) {

        return activityType != null
                && SUPPORTED_TYPES.contains(
                        activityType
                );
    }


    // Check whether the activity value matches the activity type
    public static boolean isValidValue(
            String activityType,
            String activityValue
    ) {

        if (!isSupported(activityType)) {
            return false;
        }

        if (
            activityValue == null
            || activityValue.isBlank()
        ) {
            return false;
        }

        return switch (activityType) {

            case APP_VISIT ->
                    isValidActivityDate(
                            activityValue
                    );

            case PRODUCTS_VIEW ->
                    PRODUCTS_VALUES.contains(
                            activityValue
                    );

            case SAFETY_VIEW ->
                    SAFETY_VALUES.contains(
                            activityValue
                    );

            case EDUCATION_VIEW ->
                    EDUCATION_VALUES.contains(
                            activityValue
                    );

            case DISPENSARY_VIEW,
                 AREA_SEARCH,
                 ARTICLES_VIEW ->
                    true;

            default ->
                    false;
        };
    }

    // Check whether an activity value contains a valid calendar date
    private static boolean isValidActivityDate(
            String activityValue
    ) {

        try {

            LocalDate.parse(
                    activityValue
            );

            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }
}