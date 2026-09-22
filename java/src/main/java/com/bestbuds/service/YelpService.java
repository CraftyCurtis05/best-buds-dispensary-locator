package com.bestbuds.service;

import tools.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class YelpService {

    private static final double MINIMUM_RATING = 4.0;
    private static final int MINIMUM_REVIEWS = 10;

    private static final List<String> FEATURED_LOCATIONS = List.of(
            "New York, NY",
            "Los Angeles, CA",
            "Chicago, IL",
            "Denver, CO",
            "Portland, OR",
            "Boston, MA",
            "Las Vegas, NV",
            "Phoenix, AZ"
    );

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

    // Get the featured dispensary for the home page
    public JsonNode getFeaturedDispensary(String location) {

        List<JsonNode> featuredBusinesses =
                new ArrayList<>();

        // Try the user's location when one is available
        if (location != null && !location.isBlank()) {
            featuredBusinesses =
                    getFeaturedBusinesses(location);
        }

        // Use a nationwide location when no local results are available
        if (featuredBusinesses.isEmpty()) {

            String fallbackLocation =
                    getDailyFallbackLocation();

            featuredBusinesses =
                    getFeaturedBusinesses(fallbackLocation);
        }

        if (featuredBusinesses.isEmpty()) {
            return null;
        }

        int dayOfYear =
                LocalDate.now().getDayOfYear();

        int featuredIndex =
                (dayOfYear - 1) % featuredBusinesses.size();

        return featuredBusinesses.get(featuredIndex);
    }

    // Get highly rated dispensaries that have an image
    private List<JsonNode> getFeaturedBusinesses(String location) {

        URI uri =
                buildSearchUri(
                        location,
                        "rating",
                        20
                );

        JsonNode results =
                sendYelpRequest(uri);

        JsonNode businesses =
                results.path("businesses");

        List<JsonNode> featuredBusinesses =
                new ArrayList<>();

        for (JsonNode business : businesses) {

            String imageUrl =
                    business.path("image_url").stringValue();

            String country =
                    business
                            .path("location")
                            .path("country")
                            .stringValue();

            double rating =
                    business.path("rating").asDouble();

            int reviewCount =
                    business.path("review_count").asInt();

            boolean hasImage =
                    imageUrl != null
                            && !imageUrl.isBlank();

            boolean isHighlyRated =
                    rating >= MINIMUM_RATING;

            boolean hasEnoughReviews =
                    reviewCount >= MINIMUM_REVIEWS;

            boolean isInUnitedStates =
                    "US".equals(country);

            if (hasImage
                    && isHighlyRated
                    && hasEnoughReviews
                    && isInUnitedStates) {

                featuredBusinesses.add(business);
            }
        }

        return featuredBusinesses;
    }

    // Choose a different fallback location throughout the year
    private String getDailyFallbackLocation() {

        int dayOfYear =
                LocalDate.now().getDayOfYear();

        int locationIndex =
                (dayOfYear - 1) % FEATURED_LOCATIONS.size();

        return FEATURED_LOCATIONS.get(locationIndex);
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