package com.bestbuds.service;

import tools.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class YelpService {

    private static final double MINIMUM_RATING = 4.0;
    private static final int MINIMUM_REVIEW_COUNT = 5;

    private final RestClient restClient;
    private final String apiUrl;
    private final String apiKey;

    public YelpService(
            RestClient.Builder restClientBuilder,
            @Value("${yelp.api.url}") String apiUrl,
            @Value("${yelp.api.key}") String apiKey
    ) {
        this.restClient = restClientBuilder.build();
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    // Search Yelp for dispensaries near a location
    public JsonNode searchDispensaries(String location) {

        URI uri =
                buildLocationSearchUri(
                        location,
                        "distance",
                        20
                );

        return sendYelpRequest(
                uri
        );
    }

    // Get the best dispensary near geographic coordinates
    public JsonNode getFeaturedDispensary(
            double latitude,
            double longitude
    ) {

        URI uri =
                buildCoordinateSearchUri(
                        latitude,
                        longitude,
                        "distance",
                        50
                );

        JsonNode results =
                sendYelpRequest(
                        uri
                );

        JsonNode businesses =
                results.path(
                        "businesses"
                );

        JsonNode featured =
                findBestFeaturedBusiness(
                        businesses,
                        true
                );

        // Fall back to the best available nearby result
        if (featured == null) {
            featured =
                    findBestFeaturedBusiness(
                            businesses,
                            false
                    );
        }

        return featured;
    }

    // Choose the strongest dispensary from the search results
    private JsonNode findBestFeaturedBusiness(
            JsonNode businesses,
            boolean requireMinimumQuality
    ) {

        JsonNode featured = null;

        double bestScore =
                Double.NEGATIVE_INFINITY;

        for (JsonNode business : businesses) {

            if (!isUsBusinessWithImage(business)) {
                continue;
            }

            double rating =
                    business
                            .path("rating")
                            .asDouble();

            int reviewCount =
                    business
                            .path("review_count")
                            .asInt();

            double distance =
                    business
                            .path("distance")
                            .asDouble();

            boolean isHighlyRated =
                    rating >= MINIMUM_RATING;

            boolean hasEnoughReviews =
                    reviewCount >= MINIMUM_REVIEW_COUNT;

            if (!isHighlyRated) {
                continue;
            }

            if (
                    requireMinimumQuality
                    && !hasEnoughReviews
            ) {
                continue;
}

            double score =
                    calculateFeaturedScore(
                            rating,
                            reviewCount,
                            distance
                    );

            if (score > bestScore) {
                bestScore = score;
                featured = business;
            }
        }

        return featured;
    }

    // Balance rating, review history, and distance
    private double calculateFeaturedScore(
            double rating,
            int reviewCount,
            double distance
    ) {

        double ratingScore =
                rating * 20.0;

        double reviewScore =
                Math.log10(
                        reviewCount + 1
                ) * 5.0;

        double distanceInKilometers =
                distance / 1000.0;

        double distancePenalty =
                distanceInKilometers * 0.5;

        return ratingScore
                + reviewScore
                - distancePenalty;
    }

    // Check whether a business can be used as the featured card
    private boolean isUsBusinessWithImage(
            JsonNode business
    ) {

        String imageUrl =
                business
                        .path("image_url")
                        .stringValue();

        String country =
                business
                        .path("location")
                        .path("country")
                        .stringValue();

        boolean hasImage =
                imageUrl != null
                        && !imageUrl.isBlank();

        boolean isInUnitedStates =
                "US".equals(country);

        return hasImage
                && isInUnitedStates;
    }

    // Build a Yelp search URL from a location
    private URI buildLocationSearchUri(
            String location,
            String sortBy,
            int limit
    ) {

        return UriComponentsBuilder
                .fromUriString(apiUrl)
                .path("/businesses/search")
                .queryParam(
                        "location",
                        location
                )
                .queryParam(
                        "categories",
                        "cannabis,cannabisdispensaries,dispensary"
                )
                .queryParam(
                        "radius",
                        40000
                )
                .queryParam(
                        "sort_by",
                        sortBy
                )
                .queryParam(
                        "limit",
                        limit
                )
                .build()
                .encode()
                .toUri();
    }

    // Build a Yelp search URL from geographic coordinates
    private URI buildCoordinateSearchUri(
            double latitude,
            double longitude,
            String sortBy,
            int limit
    ) {

        return UriComponentsBuilder
                .fromUriString(apiUrl)
                .path("/businesses/search")
                .queryParam(
                        "latitude",
                        latitude
                )
                .queryParam(
                        "longitude",
                        longitude
                )
                .queryParam(
                        "categories",
                        "cannabis,cannabisdispensaries,dispensary"
                )
                .queryParam(
                        "radius",
                        40000
                )
                .queryParam(
                        "sort_by",
                        sortBy
                )
                .queryParam(
                        "limit",
                        limit
                )
                .build()
                .encode()
                .toUri();
    }

    // Send an authenticated request to Yelp
    private JsonNode sendYelpRequest(
            URI uri
    ) {

        return restClient
                .get()
                .uri(uri)
                .headers(headers ->
                        headers.setBearerAuth(
                                apiKey
                        )
                )
                .retrieve()
                .body(
                        JsonNode.class
                );
    }
}