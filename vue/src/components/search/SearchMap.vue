<!-- Search Map Component Display -->
<template>

    <section
        id="search-map"
        aria-labelledby="search-map-heading"
    >

        <!-- Display Component Title -->
        <h3 id="search-map-heading">
            Dispensary Map
        </h3>

        <!-- Display Google Map -->
        <GoogleMap
            :api-key="googleMapsApiKey"
            map-id="DEMO_MAP_ID"
            class="dispensary-map"
            :center="mapCenter"
            :zoom="mapZoom"
        >

            <!-- Display Dispensary Markers -->
            <AdvancedMarker
                v-for="dispensary in mappedDispensaries"
                :key="dispensary.id"
                :options="{
                    position: dispensary.position,
                    title: dispensary.name
                }"
                @click="selectDispensary(dispensary)"
            />

            <!-- Display Selected Dispensary -->
            <InfoWindow
                v-if="selectedDispensary"
                :options="{
                    position: selectedDispensary.position
                }"
                @closeclick="clearSelectedDispensary"
            >

                <div class="dispensary-map-info">

                    <!-- Display Dispensary Name -->
                    <h4>
                        {{ selectedDispensary.name }}
                    </h4>

                    <!-- Display Dispensary Rating -->
                    <p v-if="hasSelectedRating">
                        {{ selectedDispensary.rating }} / 5

                        <span
                            v-if="
                                selectedDispensary.reviewCount
                            "
                        >
                            ·
                            {{
                                getReviewCountText(
                                    selectedDispensary
                                        .reviewCount
                                )
                            }}
                        </span>
                    </p>

                    <!-- Display Dispensary Address -->
                    <address>

                        <span
                            v-if="
                                selectedDispensary
                                    .streetAddress
                            "
                        >
                            {{
                                selectedDispensary
                                    .streetAddress
                            }}
                        </span>

                        <span
                            v-if="
                                selectedDispensary
                                    .cityStateZip
                            "
                        >
                            {{
                                selectedDispensary
                                    .cityStateZip
                            }}
                        </span>

                    </address>

                    <!-- Display Dispensary Phone Number -->
                    <a
                        v-if="selectedDispensary.phone"
                        :href="selectedDispensary.phoneLink"
                    >
                        {{ selectedDispensary.phone }}
                    </a>

                    <!-- Display Yelp Link -->
                    <a
                        v-if="selectedDispensary.url"
                        :href="selectedDispensary.url"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        View on Yelp
                    </a>

                </div>

            </InfoWindow>

        </GoogleMap>

    </section>

</template>

<script>
import {
    GoogleMap,
    AdvancedMarker,
    InfoWindow
} from "vue3-google-map";

import UserActivityService from "../../services/UserActivityService.js";

export default {
    name: "SearchMap",

    components: {
        GoogleMap,
        AdvancedMarker,
        InfoWindow
    },

    emits: [
        "activity-recorded"
    ],

    data() {
        return {

            // Use Columbus before a dispensary search is made
            defaultCenter: {
                lat: 39.9612,
                lng: -82.9988
            },

            selectedDispensary: null
        };
    },

    computed: {

        // Get the Google Maps API key
        googleMapsApiKey() {

            return import.meta.env
                .VITE_GOOGLE_MAPS_API_KEY;

        },

        // Get the current dispensary results from the store
        dispensaries() {

            return this.$store.state.dispensaries;

        },

        // Check if the selected dispensary has a rating
        hasSelectedRating() {

            return (
                this.selectedDispensary?.rating
                    !== null
                && this.selectedDispensary?.rating
                    !== undefined
            );

        },

        // Get dispensaries that have valid map coordinates
        mappedDispensaries() {

            return this.dispensaries
                .filter((dispensary) => {

                    return (
                        dispensary.coordinates
                        && dispensary.coordinates
                            .latitude !== undefined
                        && dispensary.coordinates
                            .longitude !== undefined
                    );

                })
                .map((dispensary) => {

                    const location =
                        dispensary.location || {};

                    const streetAddress = [
                        location.address1,
                        location.address2
                    ]
                        .filter(Boolean)
                        .join(" ");

                    const cityState = [
                        location.city,
                        location.state
                    ]
                        .filter(Boolean)
                        .join(", ");

                    const cityStateZip = [
                        cityState,
                        location.zip_code
                    ]
                        .filter(Boolean)
                        .join(" ");

                    return {
                        id:
                            dispensary.id,

                        name:
                            dispensary.name,

                        rating:
                            dispensary.rating,

                        reviewCount:
                            dispensary.review_count,

                        phone:
                            dispensary.display_phone,

                        phoneLink:
                            dispensary.phone
                                ? `tel:${dispensary.phone}`
                                : "",

                        url:
                            dispensary.url,

                        streetAddress,
                        cityStateZip,

                        position: {
                            lat:
                                dispensary.coordinates
                                    .latitude,

                            lng:
                                dispensary.coordinates
                                    .longitude
                        }
                    };

                });

        },

        // Center the map on the first search result
        mapCenter() {

            if (
                this.mappedDispensaries.length
            ) {
                return this.mappedDispensaries[0]
                    .position;
            }

            return this.defaultCenter;

        },

        // Adjust the zoom when search results are displayed
        mapZoom() {

            if (
                this.mappedDispensaries.length
            ) {
                return 11;
            }

            return 10;

        }

    },

    watch: {

        // Close the selected marker when search results change
        dispensaries() {

            this.clearSelectedDispensary();

        }

    },

    methods: {

        // Display information for the selected dispensary
        selectDispensary(dispensary) {

            this.selectedDispensary =
                dispensary;

            this.recordDispensaryView(
                dispensary.id
            );

        },

        // Record that the user viewed a dispensary
        recordDispensaryView(
            dispensaryID
        ) {

            if (!dispensaryID) {
                return;
            }

            UserActivityService
                .createUserActivity(
                    "DISPENSARY_VIEW",
                    dispensaryID
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch((error) => {

                    console.error(
                        "Unable to record dispensary view:",
                        error
                    );

                });

        },

        // Close the selected dispensary information
        clearSelectedDispensary() {

            this.selectedDispensary = null;

        },

        // Format the dispensary review count
        getReviewCountText(
            reviewCount
        ) {

            if (reviewCount === 1) {
                return "1 review";
            }

            return `${reviewCount} reviews`;

        }

    }
};
</script>

<style scoped>

/* Display the dispensary map */
.dispensary-map {
    width: 100%;
    height: 32rem;
}

</style>