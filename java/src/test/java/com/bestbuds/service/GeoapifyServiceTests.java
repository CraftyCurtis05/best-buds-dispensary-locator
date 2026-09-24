package com.bestbuds.service;

import com.bestbuds.model.Coordinates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class GeoapifyServiceTests {

    private GeoapifyService geoapifyService;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setup() {

        RestClient.Builder restClientBuilder =
                RestClient.builder();

        mockServer =
                MockRestServiceServer.bindTo(
                        restClientBuilder
                ).build();

        geoapifyService =
                new GeoapifyService(
                        restClientBuilder,
                        "https://api.geoapify.com/v1",
                        "test-api-key"
                );
    }

    @Test
    public void geocodeAddress_returns_coordinates() {

        String responseBody = """
                {
                    "results": [
                        {
                            "lat": 39.9612,
                            "lon": -82.9988
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
                                "text",
                                "123%20Main%20Street,%20Columbus,%20OH%2043215"
                        )
                )
                .andExpect(
                        queryParam(
                                "filter",
                                "countrycode:us"
                        )
                )
                .andExpect(
                        queryParam(
                                "format",
                                "json"
                        )
                )
                .andExpect(
                        queryParam(
                                "limit",
                                "1"
                        )
                )
                .andExpect(
                        queryParam(
                                "apiKey",
                                "test-api-key"
                        )
                )
                .andRespond(
                        withSuccess(
                                responseBody,
                                APPLICATION_JSON
                        )
                );

        Coordinates coordinates =
                geoapifyService.geocodeAddress(
                        "123 Main Street, Columbus, OH 43215"
                );

        assertEquals(
                39.9612,
                coordinates.getLatitude()
        );

        assertEquals(
                -82.9988,
                coordinates.getLongitude()
        );

        mockServer.verify();
    }

    @Test
    public void geocodeAddress_returns_null_when_no_results_are_found() {

        String responseBody = """
                {
                    "results": []
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

        Coordinates coordinates =
                geoapifyService.geocodeAddress(
                        "Unknown Address"
                );

        assertNull(
                coordinates
        );

        mockServer.verify();
    }

    @Test
    public void geocodeAddress_returns_null_for_blank_address() {

        Coordinates coordinates =
                geoapifyService.geocodeAddress(
                        "   "
                );

        assertNull(
                coordinates
        );

        mockServer.verify();
    }

    @Test
    public void geocodeAddress_returns_null_for_null_address() {

        Coordinates coordinates =
                geoapifyService.geocodeAddress(
                        null
                );

        assertNull(
                coordinates
        );

        mockServer.verify();
    }
}