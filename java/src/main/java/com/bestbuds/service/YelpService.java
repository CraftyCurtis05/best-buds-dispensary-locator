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
                buildSearchUri(
                        location,
                        "distance",
                        20
                );

        return sendYelpRequest(uri);
    }

    // Get the closest qualifying dispensary for the home page
    public JsonNode getFeaturedDispensary(String location) {

        if (location == null || location.isBlank()) {
            return null;
        }

        URI uri =
                buildSearchUri(
                        location,
                        "distance",
                        50
                );

        JsonNode results =
                sendYelpRequest(uri);

        JsonNode businesses =
                results.path("businesses");

        for (JsonNode business : businesses) {

            if (isFeaturedBusiness(business)) {
                return business;
            }
        }

        return null;
    }

    // Check whether a dispensary meets the home page requirements
    private boolean isFeaturedBusiness(JsonNode business) {

        String imageUrl =
                business.path("image_url").stringValue();

        String country =
                business
                        .path("location")
                        .path("country")
                        .stringValue();

        double rating =
                business.path("rating").asDouble();

        boolean hasImage =
                imageUrl != null
                        && !imageUrl.isBlank();

        boolean isHighlyRated =
                rating >= MINIMUM_RATING;

        boolean isInUnitedStates =
                "US".equals(country);

        return hasImage
                && isHighlyRated
                && isInUnitedStates;
    }

    // Build a Yelp dispensary search URL
    private URI buildSearchUri(
            String location,
            String sortBy,
            int limit
    ) {

        return UriComponentsBuilder
                .fromUriString(apiUrl)
                .path("/businesses/search")
                .queryParam("location", location)
                .queryParam(
                        "categories",
                        "cannabis,cannabisdispensaries,dispensary"
                )
                .queryParam("radius", 40000)
                .queryParam("sort_by", sortBy)
                .queryParam("limit", limit)
                .build()
                .encode()
                .toUri();
    }

    // Send an authenticated request to Yelp
    private JsonNode sendYelpRequest(URI uri) {

        return restClient
                .get()
                .uri(uri)
                .headers(headers ->
                        headers.setBearerAuth(apiKey)
                )
                .retrieve()
                .body(JsonNode.class);
    }
}