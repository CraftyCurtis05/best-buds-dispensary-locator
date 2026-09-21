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
            <Marker
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

                </div>

            </InfoWindow>

        </GoogleMap>

    </section>

</template>

<script>
import {
    GoogleMap,
    Marker,
    InfoWindow
} from 'vue3-google-map';

export default {
    name: "SearchMap",

    components: {
        GoogleMap,
        Marker,
        InfoWindow
    },

    data() {
        return {

            // Use Columbus before a dispensary search is made
            defaultCenter: {
                lat: 39.9612,
                lng: -82.9988
            },

            selectedDispensary: null
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
        },

        // Close the selected dispensary information
        clearSelectedDispensary() {
            this.selectedDispensary = null;
        }

    }
};
</script>

<style scoped>

</style>
