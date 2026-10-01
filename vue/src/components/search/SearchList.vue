<!-- Search List Component Display -->
<template>

    <div
        id="search-list"
        class="search-list"
    >

        <!-- Display Search Results Title -->
        <h3>
            Dispensaries Near You
        </h3>

        <!-- Display Loading Message -->
        <p
            v-if="isLoading"
            role="status"
        >
            Finding dispensaries...
        </p>

        <!-- Display Search Error -->
        <p
            v-else-if="searchError"
            role="alert"
        >
            {{ searchError }}
        </p>

        <!-- Display Search Results -->
        <div
            v-else-if="results.length"
            id="results"
        >

            <DispensaryCard
                v-for="dispensary in results"
                :key="dispensary.id"
                :dispensary="dispensary"
                :is-saved="
                    isDispensarySaved(
                        dispensary.id
                    )
                "
                :is-saving="
                    isSaving(
                        dispensary.id
                    )
                "
                @toggle-saved="toggleSavedDispensary"
            />

        </div>

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

    </div>

</template>

<script>
import DispensaryCard from "./DispensaryCard.vue";

import YelpService from "../../services/YelpService.js";
import SavedDispensaryService from "../../services/SavedDispensaryService.js";

export default {
    name: "SearchList",

    components: {
        DispensaryCard
    },

    emits: [
        "drop-check-requested"
    ],

    data() {
        return {
            savedDispensaries: [],

            isLoading: false,
            hasSearched: false,
            savingDispensaryID: null,

            searchError: "",
            savedDispensaryError: ""
        };
    },

    computed: {

        // Get the current dispensary results from the store
        results() {

            return this.$store.state.dispensaries;

        }

    },

    created() {
        this.getSavedDispensaries();
    },

    methods: {

        // Search for dispensaries at the requested location
        search(
            searchLocation
        ) {

            if (!searchLocation) {
                return;
            }

            this.getResults(
                searchLocation
            );

        },

        // Search for dispensaries near the user's saved home address
        searchNearHome() {

            this.getNearHomeResults();

        },

        // Get dispensaries near the current location
        getResults(
            searchLocation
        ) {

            this.isLoading = true;
            this.hasSearched = true;
            this.searchError = "";

            this.$store.commit(
                "SET_DISPENSARIES",
                []
            );

            YelpService
                .getDispensaries(
                    searchLocation
                )
                .then((response) => {

                    const dispensaries =
                        response.data.businesses
                        || [];

                    this.$store.commit(
                        "SET_DISPENSARIES",
                        dispensaries
                    );

                })
                .catch((error) => {

                    console.error(
                        "Unable to load dispensaries:",
                        error
                    );

                    this.$store.commit(
                        "SET_DISPENSARIES",
                        []
                    );

                    this.searchError =
                        "Unable to load dispensaries. Please try again.";

                })
                .finally(() => {

                    this.isLoading = false;

                });

        },

        // Get dispensaries near the user's saved home address
        getNearHomeResults() {

            this.isLoading = true;
            this.hasSearched = true;
            this.searchError = "";

            this.$store.commit(
                "SET_DISPENSARIES",
                []
            );

            YelpService
                .getDispensariesNearHome()
                .then((response) => {

                    const dispensaries =
                        response.data.businesses
                        || [];

                    this.$store.commit(
                        "SET_DISPENSARIES",
                        dispensaries
                    );

                })
                .catch((error) => {

                    console.error(
                        "Unable to load dispensaries near home:",
                        error
                    );

                    this.$store.commit(
                        "SET_DISPENSARIES",
                        []
                    );

                    if (
                        error.response?.status
                            === 400
                    ) {

                        this.searchError =
                            "Add a complete home address to your profile to search near home.";

                        return;
                    }

                    this.searchError =
                        "Unable to load dispensaries near home. Please try again.";

                })
                .finally(() => {

                    this.isLoading = false;

                });

        },

        // Get the user's saved dispensaries
        getSavedDispensaries() {

            SavedDispensaryService
                .getSavedDispensaries()
                .then((response) => {

                    this.savedDispensaries =
                        response.data || [];

                })
                .catch((error) => {

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
                (dispensary) =>
                    dispensary.yelpBusinessId
                        === yelpBusinessId
            );

        },

        // Check if a dispensary is currently being saved or removed
        isSaving(yelpBusinessId) {

            return this.savingDispensaryID
                === yelpBusinessId;

        },

        // Save or remove the selected dispensary
        toggleSavedDispensary(dispensary) {

            this.savedDispensaryError = "";

            this.savingDispensaryID =
                dispensary.id;

            if (
                this.isDispensarySaved(
                    dispensary.id
                )
            ) {

                this.removeSavedDispensary(
                    dispensary.id
                );

                return;

            }

            this.saveDispensary(
                dispensary
            );

        },

        // Save a dispensary for the authenticated user
        saveDispensary(dispensary) {

            const savedDispensary = {
                yelpBusinessId:
                    dispensary.id,

                name:
                    dispensary.name,

                imageUrl:
                    dispensary.image_url || "",

                address:
                    dispensary.location?.address1 || "",

                city:
                    dispensary.location?.city || "",

                stateAbbr:
                    dispensary.location?.state || "",

                zipcode:
                    dispensary.location?.zip_code || "",

                latitude:
                    dispensary.coordinates?.latitude,

                longitude:
                    dispensary.coordinates?.longitude,

                rating:
                    dispensary.rating
            };

            SavedDispensaryService
                .saveDispensary(
                    savedDispensary
                )
                .then((response) => {

                    const alreadySaved =
                        this.isDispensarySaved(
                            response.data.yelpBusinessId
                        );

                    if (!alreadySaved) {

                        this.savedDispensaries.push(
                            response.data
                        );

                    }

                    this.$emit(
                        "drop-check-requested"
                    );

                })
                .catch((error) => {

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
        removeSavedDispensary(
            yelpBusinessId
        ) {

            SavedDispensaryService
                .deleteSavedDispensary(
                    yelpBusinessId
                )
                .then((response) => {

                    if (
                        response.status === 204
                    ) {

                        this.savedDispensaries =
                            this.savedDispensaries.filter(
                                (dispensary) =>
                                    dispensary.yelpBusinessId
                                        !== yelpBusinessId
                            );

                    }

                })
                .catch((error) => {

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

    }
};
</script>

<style scoped>

</style>