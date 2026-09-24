package com.bestbuds.service;

import com.bestbuds.model.Coordinates;

import tools.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class GeoapifyService {

    private final RestClient restClient;
    private final String apiUrl;
    private final String apiKey;

    public GeoapifyService(
            RestClient.Builder restClientBuilder,
            @Value("${geoapify.api.url}") String apiUrl,
            @Value("${geoapify.api.key}") String apiKey
    ) {
        this.restClient =
                restClientBuilder.build();

        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    // Convert a street address into geographic coordinates
    public Coordinates geocodeAddress(
            String address
    ) {

        if (address == null || address.isBlank()) {
            return null;
        }

        URI uri =
                buildGeocodingUri(
                        address
                );

        JsonNode response =
                sendGeoapifyRequest(
                        uri
                );

        JsonNode results =
                response.path(
                        "results"
                );

        if (!results.isArray() || results.isEmpty()) {
            return null;
        }

        JsonNode location =
                results.get(0);

        double latitude =
                location
                        .path("lat")
                        .asDouble();

        double longitude =
                location
                        .path("lon")
                        .asDouble();

        return new Coordinates(
                latitude,
                longitude
        );
    }

    // Build a Geoapify address search URL
    private URI buildGeocodingUri(
            String address
    ) {

        return UriComponentsBuilder
                .fromUriString(apiUrl)
                .path("/geocode/search")
                .queryParam(
                        "text",
                        address
                )
                .queryParam(
                        "filter",
                        "countrycode:us"
                )
                .queryParam(
                        "format",
                        "json"
                )
                .queryParam(
                        "limit",
                        1
                )
                .queryParam(
                        "apiKey",
                        apiKey
                )
                .build()
                .encode()
                .toUri();
    }

    // Send a request to Geoapify
    private JsonNode sendGeoapifyRequest(
            URI uri
    ) {

        return restClient
                .get()
                .uri(uri)
                .retrieve()
                .body(JsonNode.class);
    }
}