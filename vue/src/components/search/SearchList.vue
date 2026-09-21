<!-- Search List Component Display -->
<template>

    <section id="search-list">

        <!-- Display Component Title -->
        <h1>List of dispensaries near you:</h1>

        <!-- Display Loading Message -->
        <p v-if="isLoading">
            Finding dispensaries...
        </p>

        <!-- Display Search Results -->
        <section id="results" v-else-if="results.length">

            <article
                class="result-object"
                v-for="result in results"
                v-bind:key="result.id"
            >

                <!-- Display Dispensary Name -->
                <a
                    v-bind:href="result.url"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <h2>{{ result.name }}</h2>
                </a>

                <!-- Display Dispensary Details -->
                <div class="result-details">

                    <h3 class="result-address">
                        {{ result.location.address1 }}
                        {{ result.location.address2 }}
                    </h3>

                    <h3 class="result-address">
                        {{ result.location.city }},
                        {{ result.location.state }}
                        {{ result.location.zip_code }}
                    </h3>

                    <h3 class="result-phone">
                        {{ result.display_phone }}
                    </h3>

                </div>

            </article>

        </section>

        <!-- Display No Results Message -->
        <p v-else-if="hasSearched">
            No dispensaries were found near this location.
        </p>

    </section>

</template>

<script>
import YelpService from '../../services/YelpService.js';

export default {
    name: "SearchList",

    data() {
        return {
            isLoading: false,
            hasSearched: false
        }
    },

    computed: {

        // Get the current search location from the store
        locationID() {
            return this.$store.state.locationID;
        },

        // Get the current dispensary results from the store
        results() {
            return this.$store.state.dispensaries;
        }

    },

    watch: {

        // Search again when the location changes
        locationID(newLocation) {

            if (newLocation) {
                this.getResults(newLocation);
            }
        }

    },

    methods: {

        // Get dispensaries near the current location
        getResults(locationID) {

            this.isLoading = true;
            this.hasSearched = true;

            this.$store.commit('SET_DISPENSARIES', []);

            YelpService.getDispensaries(locationID)
            .then(response => {

                const dispensaries = response.data.businesses || [];

                this.$store.commit(
                    'SET_DISPENSARIES',
                    dispensaries
                );
            })
            .catch(error => {

                console.error(
                    "Unable to load dispensaries:",
                    error
                );

                this.$store.commit('SET_DISPENSARIES', []);
            })
            .finally(() => {
                this.isLoading = false;
            });
        }

    },

    created() {

        // Load results when a search already exists
        if (this.locationID) {
            this.getResults(this.locationID);
        }
    }
};
</script>

<style scoped>

</style>
