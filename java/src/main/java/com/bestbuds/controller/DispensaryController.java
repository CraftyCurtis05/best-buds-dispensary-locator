package com.bestbuds.controller;

import com.bestbuds.service.YelpService;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispensaries")
public class DispensaryController {

    private final YelpService yelpService;

    public DispensaryController(YelpService yelpService) {
        this.yelpService = yelpService;
    }

    // Get dispensaries near a location
    @GetMapping("/search")
    public ResponseEntity<JsonNode> searchDispensaries(
            @RequestParam String location) {

        JsonNode results = yelpService.searchDispensaries(location);

        return ResponseEntity.ok(results);
    }

    // Get the featured dispensary for the home page
    @GetMapping("/featured")
    public ResponseEntity<JsonNode> getFeaturedDispensary(
            @RequestParam(required = false) String location) {

        JsonNode featured = yelpService.getFeaturedDispensary(location);

        return ResponseEntity.ok(featured);
    }
}
