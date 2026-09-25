<!-- Search Map Component Display -->
<template>

    <section id="search-map">

        <!-- Display Google Map -->
        <GoogleMap
            v-bind:api-key="googleMapsApiKey"
            style="width: 60vw; height: 45vw"
            v-bind:center="mapCenter"
            v-bind:zoom="mapZoom"
        >

            <!-- Display Dispensary Markers -->
            <GoogleMapMarker
                v-for="dispensary in mappedDispensaries"
                v-bind:key="dispensary.id"
                v-bind:options="{
                    position: dispensary.position
                }"
                v-on:click="selectDispensary(dispensary)"
            />

            <!-- Display Selected Dispensary -->
            <InfoWindow
                v-if="selectedDispensary"
                v-bind:options="{
                    position: selectedDispensary.position
                }"
                v-on:closeclick="clearSelectedDispensary"
            >

                <div class="dispensary-info">

                    <!-- Display Dispensary Name -->
                    <h2>
                        {{ selectedDispensary.name }}
                    </h2>

                    <!-- Display Dispensary Rating -->
                    <p v-if="selectedDispensary.rating">
                        {{ selectedDispensary.rating }} ★
                        ({{ selectedDispensary.reviewCount }} reviews)
                    </p>

                    <!-- Display Dispensary Address -->
                    <p>
                        {{ selectedDispensary.address1 }}
                    </p>

                    <p>
                        {{ selectedDispensary.city }},
                        {{ selectedDispensary.state }}
                        {{ selectedDispensary.zipCode }}
                    </p>

                    <!-- Display Dispensary Phone Number -->
                    <p v-if="selectedDispensary.phone">
                        {{ selectedDispensary.phone }}
                    </p>

                    <!-- Display Yelp Link -->
                    <a
                        v-if="selectedDispensary.url"
                        v-bind:href="selectedDispensary.url"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        View on Yelp
                    </a>

                    <!-- Display Saved Dispensary Control -->
                    <div class="dispensary-save">

                        <button
                            type="button"
                            v-bind:disabled="
                                isSaving(selectedDispensary.id)
                            "
                            v-on:click="
                                toggleSavedDispensary(
                                    selectedDispensary
                                )
                            "
                        >
                            {{
                                getSaveButtonText(
                                    selectedDispensary
                                )
                            }}
                        </button>

                    </div>

                    <!-- Display Saved Dispensary Error -->
                    <p
                        v-if="savedDispensaryError"
                        role="alert"
                    >
                        {{ savedDispensaryError }}
                    </p>

                </div>

            </InfoWindow>

        </GoogleMap>

    </section>

</template>

<script>
import {
    GoogleMap,
    Marker as GoogleMapMarker,
    InfoWindow
} from "vue3-google-map";

import SavedDispensaryService
    from "../../services/SavedDispensaryService.js";

export default {
    name: "SearchMap",

    components: {
        GoogleMap,
        GoogleMapMarker,
        InfoWindow
    },

    data() {
        return {

            // Use Columbus before a dispensary search is made
            defaultCenter: {
                lat: 39.9612,
                lng: -82.9988
            },

            selectedDispensary: null,
            savedDispensaries: [],
            savingDispensaryID: null,
            savedDispensaryError: ''
        }
    },

    computed: {

        // Get the Google Maps API key
        googleMapsApiKey() {
            return import.meta.env.VITE_GOOGLE_MAPS_API_KEY;
        },

        // Get the current dispensary results from the store
        dispensaries() {
            return this.$store.state.dispensaries;
        },

        // Get dispensaries that have valid map coordinates
        mappedDispensaries() {

            return this.dispensaries
                .filter(dispensary => {

                    return dispensary.coordinates
                        && dispensary.coordinates.latitude
                        && dispensary.coordinates.longitude;
                })
                .map(dispensary => {

                    return {
                        id: dispensary.id,
                        name: dispensary.name,
                        imageUrl: dispensary.image_url,
                        rating: dispensary.rating,
                        reviewCount: dispensary.review_count,
                        phone: dispensary.display_phone,
                        url: dispensary.url,

                        address1: dispensary.location.address1,
                        city: dispensary.location.city,
                        state: dispensary.location.state,
                        zipCode: dispensary.location.zip_code,

                        position: {
                            lat: dispensary.coordinates.latitude,
                            lng: dispensary.coordinates.longitude
                        }
                    };
                });
        },

        // Center the map on the first search result
        mapCenter() {

            if (this.mappedDispensaries.length) {
                return this.mappedDispensaries[0].position;
            }

            return this.defaultCenter;
        },

        // Adjust the zoom when search results are displayed
        mapZoom() {

            if (this.mappedDispensaries.length) {
                return 11;
            }

            return 10;
        }

    },

    methods: {

        // Display information for the selected dispensary
        selectDispensary(dispensary) {
            this.selectedDispensary = dispensary;
            this.savedDispensaryError = '';
        },

        // Close the selected dispensary information
        clearSelectedDispensary() {
            this.selectedDispensary = null;
            this.savedDispensaryError = '';
        },

        // Get the user's saved dispensaries
        getSavedDispensaries() {

            SavedDispensaryService.getSavedDispensaries()
            .then(response => {

                this.savedDispensaries =
                    response.data || [];
            })
            .catch(error => {

                console.error(
                    "Unable to load saved dispensaries:",
                    error
                );

                this.savedDispensaries = [];
            });
        },

        // Check if a dispensary is already saved
        isDispensarySaved(yelpBusinessId) {

            return this.savedDispensaries.some(
                dispensary =>
                    dispensary.yelpBusinessId
                        === yelpBusinessId
            );
        },

        // Check if a dispensary is currently being saved or removed
        isSaving(yelpBusinessId) {
            return this.savingDispensaryID
                === yelpBusinessId;
        },

        // Display the correct saved dispensary button text
        getSaveButtonText(dispensary) {

            if (this.isSaving(dispensary.id)) {

                if (this.isDispensarySaved(dispensary.id)) {
                    return "Removing...";
                }

                return "Saving...";
            }

            if (this.isDispensarySaved(dispensary.id)) {
                return "Saved";
            }

            return "Save";
        },

        // Save or remove the selected dispensary
        toggleSavedDispensary(dispensary) {

            this.savedDispensaryError = '';
            this.savingDispensaryID = dispensary.id;

            if (this.isDispensarySaved(dispensary.id)) {
                this.removeSavedDispensary(dispensary.id);
                return;
            }

            this.saveDispensary(dispensary);
        },

        // Save a dispensary for the authenticated user
        saveDispensary(dispensary) {

            const savedDispensary = {
                yelpBusinessId: dispensary.id,
                name: dispensary.name,
                imageUrl: dispensary.imageUrl,
                address: dispensary.address1,
                city: dispensary.city,
                stateAbbr: dispensary.state,
                zipcode: dispensary.zipCode,
                latitude: dispensary.position.lat,
                longitude: dispensary.position.lng,
                rating: dispensary.rating
            };

            SavedDispensaryService.saveDispensary(
                savedDispensary
            )
            .then(response => {

                const alreadySaved =
                    this.isDispensarySaved(
                        response.data.yelpBusinessId
                    );

                if (!alreadySaved) {
                    this.savedDispensaries.push(
                        response.data
                    );
                }
            })
            .catch(error => {

                console.error(
                    "Unable to save dispensary:",
                    error
                );

                this.savedDispensaryError =
                    "Unable to save this dispensary.";
            })
            .finally(() => {
                this.savingDispensaryID = null;
            });
        },

        // Remove a dispensary from the user's saved dispensaries
        removeSavedDispensary(yelpBusinessId) {

            SavedDispensaryService.deleteSavedDispensary(
                yelpBusinessId
            )
            .then(response => {

                if (response.status === 204) {

                    this.savedDispensaries =
                        this.savedDispensaries.filter(
                            dispensary =>
                                dispensary.yelpBusinessId
                                    !== yelpBusinessId
                        );
                }
            })
            .catch(error => {

                console.error(
                    "Unable to remove saved dispensary:",
                    error
                );

                this.savedDispensaryError =
                    "Unable to remove this dispensary.";
            })
            .finally(() => {
                this.savingDispensaryID = null;
            });
        }

    },

    created() {

        // Load the user's saved dispensaries
        this.getSavedDispensaries();
    }
};
</script>

<style scoped>

</style>