package com.bestbuds.service;

import tools.jackson.databind.JsonNode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class YelpServiceTests {

    private YelpService yelpService;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setup() {

        RestClient.Builder restClientBuilder =
                RestClient.builder();

        mockServer =
                MockRestServiceServer.bindTo(
                        restClientBuilder
                ).build();

        yelpService =
                new YelpService(
                        restClientBuilder,
                        "https://api.yelp.com/v3",
                        "test-api-key"
                );
    }

    @Test
    public void getFeaturedDispensary_returns_high_quality_dispensary() {

        String responseBody = """
                {
                    "businesses": [
                        {
                            "id": "featured-dispensary",
                            "name": "Featured Dispensary",
                            "image_url": "https://example.com/featured.jpg",
                            "rating": 4.8,
                            "review_count": 25,
                            "distance": 5000.0,
                            "location": {
                                "country": "US"
                            }
                        }
                    ]
                }
                """;

        mockServer.expect(
                request -> {
                }
        )
                .andExpect(
                        method(GET)
                )
                .andExpect(
                        queryParam(
                                "latitude",
                                "39.9612"
                        )
                )
                .andExpect(
                        queryParam(
                                "longitude",
                                "-82.9988"
                        )
                )
                .andExpect(
                        queryParam(
                                "radius",
                                "40000"
                        )
                )
                .andExpect(
                        queryParam(
                                "sort_by",
                                "distance"
                        )
                )
                .andExpect(
                        queryParam(
                                "limit",
                                "50"
                        )
                )
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        JsonNode result =
                yelpService.getFeaturedDispensary(
                        39.9612,
                        -82.9988
                );

        assertNotNull(
                result
        );

        assertEquals(
                "featured-dispensary",
                result.path("id").stringValue()
        );

        mockServer.verify();
    }

    @Test
    public void getFeaturedDispensary_allows_high_rating_with_few_reviews_as_fallback() {

        String responseBody = """
                {
                    "businesses": [
                        {
                            "id": "small-review-count",
                            "name": "Small Review Count Dispensary",
                            "image_url": "https://example.com/small.jpg",
                            "rating": 5.0,
                            "review_count": 4,
                            "distance": 10000.0,
                            "location": {
                                "country": "US"
                            }
                        }
                    ]
                }
                """;

        mockServer.expect(
                request -> {
                }
        )
                .andExpect(
                        method(GET)
                )
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        JsonNode result =
                yelpService.getFeaturedDispensary(
                        39.9612,
                        -82.9988
                );

        assertNotNull(
                result
        );

        assertEquals(
                "small-review-count",
                result.path("id").stringValue()
        );

        mockServer.verify();
    }

    @Test
    public void getFeaturedDispensary_rejects_low_rating_even_with_many_reviews() {

        String responseBody = """
                {
                    "businesses": [
                        {
                            "id": "low-rating",
                            "name": "Low Rating Dispensary",
                            "image_url": "https://example.com/low.jpg",
                            "rating": 2.9,
                            "review_count": 42,
                            "distance": 5000.0,
                            "location": {
                                "country": "US"
                            }
                        }
                    ]
                }
                """;

        mockServer.expect(
                request -> {
                }
        )
                .andExpect(
                        method(GET)
                )
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        JsonNode result =
                yelpService.getFeaturedDispensary(
                        39.9612,
                        -82.9988
                );

        assertNull(
                result
        );

        mockServer.verify();
    }

    @Test
    public void getFeaturedDispensary_returns_null_when_no_businesses_are_found() {

        String responseBody = """
                {
                    "businesses": []
                }
                """;

        mockServer.expect(
                request -> {
                }
        )
                .andExpect(
                        method(GET)
                )
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        JsonNode result =
                yelpService.getFeaturedDispensary(
                        39.9612,
                        -82.9988
                );

        assertNull(
                result
        );

        mockServer.verify();
    }
}