package com.bestbuds.controller;

import com.bestbuds.service.YelpService;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DispensaryControllerTests {

    private YelpService yelpService;
    private DispensaryController sut;

    @BeforeEach
    public void setUp() {

        yelpService =
                mock(YelpService.class);

        sut =
                new DispensaryController(
                        yelpService
                );
    }

    @Test
    public void searchDispensaries_returns_search_results() {

        JsonNode results =
                new ObjectMapper()
                        .createObjectNode();

        when(
                yelpService.searchDispensaries(
                        "Columbus, OH"
                )
        )
                .thenReturn(
                        results
                );

        ResponseEntity<JsonNode> response =
                sut.searchDispensaries(
                        "Columbus, OH"
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                results,
                response.getBody()
        );

        verify(yelpService)
                .searchDispensaries(
                        "Columbus, OH"
                );
    }

    @Test
    public void getFeaturedDispensary_returns_featured_dispensary() {

        JsonNode featured =
                new ObjectMapper()
                        .createObjectNode();

        when(
                yelpService.getFeaturedDispensary(
                        "Columbus, OH"
                )
        )
                .thenReturn(
                        featured
                );

        ResponseEntity<JsonNode> response =
                sut.getFeaturedDispensary(
                        "Columbus, OH"
                );

        assertEquals(
                200,
                response.getStatusCode().value()
        );

        assertSame(
                featured,
                response.getBody()
        );

        verify(yelpService)
                .getFeaturedDispensary(
                        "Columbus, OH"
                );
    }
}