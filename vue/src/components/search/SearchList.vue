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

                <!-- Display Saved Dispensary Control -->
                <div class="result-save">

                    <button
                        type="button"
                        v-bind:disabled="isSaving(result.id)"
                        v-on:click="toggleSavedDispensary(result)"
                    >
                        {{
                            getSaveButtonText(result)
                        }}
                    </button>

                </div>

            </article>

        </section>

        <!-- Display No Results Message -->
        <p v-else-if="hasSearched">
            No dispensaries were found near this location.
        </p>

        <!-- Display Saved Dispensary Error -->
        <p
            v-if="savedDispensaryError"
            role="alert"
        >
            {{ savedDispensaryError }}
        </p>

    </section>

</template>

<script>
import YelpService from '../../services/YelpService.js';
import SavedDispensaryService
    from '../../services/SavedDispensaryService.js';

export default {
    name: "SearchList",

    data() {
        return {
            isLoading: false,
            hasSearched: false,
            savedDispensaries: [],
            savingDispensaryID: null,
            savedDispensaryError: ''
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
                imageUrl: dispensary.image_url,
                address: dispensary.location.address1,
                city: dispensary.location.city,
                stateAbbr: dispensary.location.state,
                zipcode: dispensary.location.zip_code,
                latitude: dispensary.coordinates.latitude,
                longitude: dispensary.coordinates.longitude,
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

        // Load results when a search already exists
        if (this.locationID) {
            this.getResults(this.locationID);
        }
    }
};
</script>

<style scoped>

</style>