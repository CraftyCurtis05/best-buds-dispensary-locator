<!-- Dispensary Search Map Component -->
<template>

    <section
        id="search-map"
        aria-labelledby="search-map-heading"
    >

        <!-- Map Header -->
        <header class="map-header">

            <div>

                <p class="map-eyebrow">
                    Map View
                </p>

                <h3 id="search-map-heading">
                    Dispensary Map
                </h3>

            </div>

            <p class="map-result-count">
                {{ mappedDispensaries.length }}

                {{
                    mappedDispensaries.length === 1
                        ? "location"
                        : "locations"
                }}
            </p>

        </header>


        <!-- Map Container -->
        <div class="map-container">

            <GoogleMap
                :api-key="googleMapsApiKey"
                map-id="DEMO_MAP_ID"
                class="dispensary-map"
                :center="mapCenter"
                :zoom="mapZoom"
            >

                <!-- Dispensary Markers -->
                <AdvancedMarker
                    v-for="
                        dispensary
                        in mappedDispensaries
                    "
                    :key="dispensary.id"
                    :options="{
                        position:
                            dispensary.position,

                        title:
                            dispensary.name
                    }"
                    @click="
                        selectDispensary(
                            dispensary
                        )
                    "
                />


                <!-- Selected Dispensary -->
                <InfoWindow
                    v-if="selectedDispensary"
                    :options="{
                        position:
                            selectedDispensary.position
                    }"
                    @closeclick="
                        clearSelectedDispensary
                    "
                >

                    <article class="dispensary-map-info">

                        <!-- Dispensary Name -->
                        <h4>
                            {{
                                selectedDispensary.name
                            }}
                        </h4>


                        <!-- Rating -->
                        <p
                            v-if="
                                hasSelectedRating
                            "
                            class="map-info-rating"
                        >
                            <span aria-hidden="true">
                                ★
                            </span>

                            {{
                                selectedDispensary.rating
                            }}

                            <template
                                v-if="
                                    selectedDispensary
                                        .reviewCount
                                "
                            >
                                ·
                                {{
                                    getReviewCountText(
                                        selectedDispensary
                                            .reviewCount
                                    )
                                }}
                            </template>

                        </p>


                        <!-- Address -->
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


                        <!-- Phone -->
                        <a
                            v-if="
                                selectedDispensary.phone
                            "
                            :href="
                                selectedDispensary
                                    .phoneLink
                            "
                            class="map-info-phone"
                        >
                            {{
                                selectedDispensary.phone
                            }}
                        </a>


                        <!-- Map Actions -->
                        <div class="map-info-actions">

                            <a
                                v-if="
                                    selectedDispensary.url
                                "
                                :href="
                                    selectedDispensary.url
                                "
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                View Details ↗
                            </a>

                            <a
                                v-if="
                                    selectedDispensary
                                        .directionsUrl
                                "
                                :href="
                                    selectedDispensary
                                        .directionsUrl
                                "
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                Directions ↗
                            </a>

                        </div>

                    </article>

                </InfoWindow>

            </GoogleMap>

        </div>

    </section>

</template>


<script>

import {
    GoogleMap,
    AdvancedMarker,
    InfoWindow
} from "vue3-google-map";

import UserActivityService
    from "../../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../../constants/userActivityTypes.js";


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

            // Show the United States before results
            defaultCenter: {
                lat: 39.50,
                lng: -98.35
            },

            selectedDispensary: null

        };

    },

    computed: {

        // Get the Google Maps API key
        googleMapsApiKey() {

            return (
                import.meta.env
                    .VITE_GOOGLE_MAPS_API_KEY
            );

        },


        // Get current dispensary results
        dispensaries() {

            return (
                this.$store.state.dispensaries
            );

        },


        // Check if selected location has a rating
        hasSelectedRating() {

            return (
                this.selectedDispensary
                    ?.rating !== null
                &&
                this.selectedDispensary
                    ?.rating !== undefined
            );

        },


        // Prepare dispensaries for Google Maps
        mappedDispensaries() {

            return this.dispensaries
                .filter((dispensary) => {

                    return (
                        dispensary.coordinates
                        &&
                        dispensary.coordinates
                            .latitude
                            !== undefined
                        &&
                        dispensary.coordinates
                            .longitude
                            !== undefined
                    );

                })
                .map((dispensary) => {

                    const location =
                        dispensary.location
                        || {};

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

                    const fullAddress = [
                        streetAddress,
                        cityStateZip
                    ]
                        .filter(Boolean)
                        .join(", ");

                    let directionsUrl = "";

                    if (fullAddress) {

                        directionsUrl =
                            "https://www.google.com/maps/search/"
                            + "?api=1&query="
                            + encodeURIComponent(
                                fullAddress
                            );

                    }

                    return {

                        id:
                            dispensary.id,

                        name:
                            dispensary.name,

                        rating:
                            dispensary.rating,

                        reviewCount:
                            dispensary
                                .review_count,

                        phone:
                            dispensary
                                .display_phone,

                        phoneLink:
                            dispensary.phone
                                ? `tel:${dispensary.phone}`
                                : "",

                        url:
                            dispensary.url,

                        streetAddress,
                        cityStateZip,
                        directionsUrl,

                        position: {

                            lat:
                                dispensary
                                    .coordinates
                                    .latitude,

                            lng:
                                dispensary
                                    .coordinates
                                    .longitude

                        }

                    };

                });

        },


        // Center the map on the first result
        mapCenter() {

            if (
                this.mappedDispensaries
                    .length
            ) {

                return (
                    this.mappedDispensaries[0]
                        .position
                );

            }

            return this.defaultCenter;

        },


        // Adjust map zoom after a search
        mapZoom() {

            if (
                this.mappedDispensaries
                    .length
            ) {
                return 11;
            }

            return 4;

        }

    },

    watch: {

        // Close the marker when results change
        dispensaries() {

            this.clearSelectedDispensary();

        }

    },

    methods: {

        // Display the selected dispensary
        selectDispensary(
            dispensary
        ) {

            this.selectedDispensary =
                dispensary;

            this.recordDispensaryView(
                dispensary.id
            );

        },


        // Record a dispensary view
        recordDispensaryView(
            dispensaryID
        ) {

            if (!dispensaryID) {
                return;
            }

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES
                        .DISPENSARY_VIEW,

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


        // Close selected dispensary information
        clearSelectedDispensary() {

            this.selectedDispensary = null;

        },


        // Format the review count
        getReviewCountText(
            reviewCount
        ) {

            if (reviewCount === 1) {
                return "1 review";
            }

            return (
                `${reviewCount} reviews`
            );

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Search Map
   ========================================================= */

#search-map {
    width: 100%;
}


/* Map Header */
.map-header {
    display: flex;
    align-items: flex-end;
    justify-content: space-between;

    gap: 1rem;

    margin-bottom: 1rem;
}


/* Map Eyebrow */
.map-eyebrow {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-gold-dark);

    font-size: 0.66rem;
    font-weight: 600;

    letter-spacing: 0.16em;

    text-transform: uppercase;
}


/* Map Heading */
.map-header h3 {
    margin: 0;

    color:
        var(--color-text);

    font-size: 1.25rem;
    font-weight: 600;
}


/* Result Count */
.map-result-count {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.75rem;
}


/* =========================================================
   Map Container
   ========================================================= */

.map-container {
    overflow: hidden;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 16px 38px
        var(--color-shadow);
}


/* Google Map */
.dispensary-map {
    width: 100%;
    height:
        clamp(
            28rem,
            62vh,
            42rem
        );
}


/* =========================================================
   Map Information Window
   ========================================================= */

.dispensary-map-info {
    min-width: 13rem;
    max-width: 18rem;

    padding:
        0.35rem;

    color:
        var(--color-text);

    font-family:
        var(--font-family-main);
}


/* Map Dispensary Name */
.dispensary-map-info h4 {
    margin:
        0
        0
        0.5rem;

    font-size: 1rem;
    font-weight: 600;

    line-height: 1.25;
}


/* Map Rating */
.map-info-rating {
    margin:
        0
        0
        0.5rem;

    color:
        var(--color-text-soft);

    font-size: 0.75rem;
}


/* Rating Star */
.map-info-rating span {
    color:
        var(--color-gold);
}


/* Map Address */
.dispensary-map-info address {
    display: flex;
    flex-direction: column;

    margin:
        0
        0
        0.5rem;

    color:
        var(--color-text-soft);

    font-size: 0.75rem;

    font-style: normal;

    line-height: 1.45;
}


/* Map Phone */
.map-info-phone {
    display: inline-block;

    margin-bottom: 0.6rem;

    color:
        var(--color-primary);

    font-size: 0.75rem;
}


/* Map Actions */
.map-info-actions {
    display: flex;
    flex-wrap: wrap;

    gap: 0.7rem;

    padding-top: 0.55rem;

    border-top:
        1px solid
        var(--color-border);
}


/* Map Action Links */
.map-info-actions a {
    color:
        var(--color-primary);

    font-size: 0.72rem;
    font-weight: 600;

    text-decoration: none;
}


/* Map Action Hover */
.map-info-actions a:hover {
    color:
        var(--color-gold-dark);
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    .dispensary-map {
        height:
            min(
                70vh,
                34rem
            );
    }

}

</style>