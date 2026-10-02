<!-- Dispensary Search List Component -->
<template>

    <div
        id="search-list"
        class="search-list"
    >

        <!-- =================================================
             Loading State
             ================================================= -->

        <div
            v-if="isLoading"
            class="results-status"
            role="status"
        >

            <span
                class="results-status-marker"
                aria-hidden="true"
            ></span>

            <div>

                <p class="results-status-title">
                    Finding dispensaries...
                </p>

                <p>
                    Searching near
                    {{ displaySearchLocation }}.
                </p>

            </div>

        </div>


        <!-- =================================================
             Search Error
             ================================================= -->

        <div
            v-else-if="searchError"
            class="results-status results-status-error"
            role="alert"
        >

            <span
                class="results-status-marker"
                aria-hidden="true"
            >
                !
            </span>

            <div>

                <p class="results-status-title">
                    Search unavailable
                </p>

                <p>
                    {{ searchError }}
                </p>

            </div>

        </div>


        <!-- =================================================
             Search Results
             ================================================= -->

        <template v-else-if="results.length">

            <!-- Results Summary -->
            <div class="results-summary">

                <p aria-live="polite">
                    <strong>
                        {{ results.length }}
                    </strong>

                    {{
                        results.length === 1
                            ? "dispensary"
                            : "dispensaries"
                    }}

                    found near

                    <strong>
                        {{ displaySearchLocation }}
                    </strong>
                </p>

            </div>


            <!-- Saved Dispensary Error -->
            <div
                v-if="savedDispensaryError"
                class="saved-error"
                role="alert"
            >
                {{ savedDispensaryError }}
            </div>


            <!-- Dispensary Cards -->
            <div id="results">

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
                    @toggle-saved="
                        toggleSavedDispensary
                    "
                />

            </div>

        </template>


        <!-- =================================================
             No Results
             ================================================= -->

        <div
            v-else-if="hasSearched"
            class="results-status"
            role="status"
        >

            <span
                class="results-status-marker"
                aria-hidden="true"
            >
                ?
            </span>

            <div>

                <p class="results-status-title">
                    No dispensaries found
                </p>

                <p>
                    Try a nearby city, state, or ZIP code.
                </p>

            </div>

        </div>

    </div>

</template>


<script>

import DispensaryCard
    from "./DispensaryCard.vue";

import YelpService
    from "../../services/YelpService.js";

import SavedDispensaryService
    from "../../services/SavedDispensaryService.js";


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

        // Get the current dispensary results
        results() {

            return this.$store.state.dispensaries;

        },


        // Get the location used for the current search
        displaySearchLocation() {

            const searchLocation =
                this.$store.state.searchLocation;

            if (
                searchLocation === "Near Home"
            ) {
                return "your saved home";
            }

            return (
                searchLocation
                || "this location"
            );

        }

    },

    created() {

        this.getSavedDispensaries();

    },

    methods: {

        // Search for dispensaries at a location
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


        // Search near the user's saved home address
        searchNearHome() {

            this.getNearHomeResults();

        },


        // Get dispensaries near a location
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


        // Get dispensaries near the user's home
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


        // Check if a dispensary is saved
        isDispensarySaved(
            yelpBusinessId
        ) {

            return this.savedDispensaries.some(
                (dispensary) =>
                    dispensary.yelpBusinessId
                        === yelpBusinessId
            );

        },


        // Check if a dispensary is being updated
        isSaving(
            yelpBusinessId
        ) {

            return (
                this.savingDispensaryID
                === yelpBusinessId
            );

        },


        // Save or remove the selected dispensary
        toggleSavedDispensary(
            dispensary
        ) {

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


        // Save a dispensary
        saveDispensary(
            dispensary
        ) {

            const savedDispensary = {

                yelpBusinessId:
                    dispensary.id,

                name:
                    dispensary.name,

                imageUrl:
                    dispensary.image_url
                    || "",

                address:
                    dispensary.location
                        ?.address1
                    || "",

                city:
                    dispensary.location
                        ?.city
                    || "",

                stateAbbr:
                    dispensary.location
                        ?.state
                    || "",

                zipcode:
                    dispensary.location
                        ?.zip_code
                    || "",

                latitude:
                    dispensary.coordinates
                        ?.latitude,

                longitude:
                    dispensary.coordinates
                        ?.longitude,

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
                            response.data
                                .yelpBusinessId
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


        // Remove a saved dispensary
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
                                    dispensary
                                        .yelpBusinessId
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

/* =========================================================
   Search List
   ========================================================= */

#search-list {
    width: 100%;
}


/* Results Summary */
.results-summary {
    margin-bottom: 1rem;

    color:
        var(--color-text-soft);

    font-size: 0.82rem;
}


/* Results Summary Text */
.results-summary p {
    margin: 0;
}


/* Results Summary Emphasis */
.results-summary strong {
    color:
        var(--color-text);

    font-weight: 600;
}


/* =========================================================
   Results Grid
   ========================================================= */

#results {
    display: grid;

    grid-template-columns:
        repeat(
            3,
            minmax(
                0,
                1fr
            )
        );

    gap: 1.25rem;
}


/* =========================================================
   Status Messages
   ========================================================= */

.results-status {
    display: flex;
    align-items: flex-start;

    gap: 1rem;

    min-height: 8rem;

    padding:
        1.4rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    color:
        var(--color-text-soft);
}


/* Status Marker */
.results-status-marker {
    display: grid;
    place-items: center;

    width: 2.5rem;
    height: 2.5rem;

    flex-shrink: 0;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius: 50%;

    color:
        var(--color-primary);

    font-size: 0.8rem;
    font-weight: 700;
}


/* Status Text */
.results-status p {
    margin:
        0.15rem
        0;
}


/* Status Title */
.results-status
.results-status-title {
    color:
        var(--color-text);

    font-weight: 600;
}


/* Error Status */
.results-status-error
.results-status-marker {
    color:
        var(--color-danger);
}


/* Saved Error */
.saved-error {
    margin-bottom: 1rem;

    padding:
        0.8rem
        1rem;

    background:
        var(--color-surface-soft);

    border:
        1px solid
        var(--color-border);

    border-left:
        3px solid
        var(--color-danger);

    border-radius:
        var(--border-radius-small);

    color:
        var(--color-danger);

    font-size: 0.82rem;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 999.98px) {

    #results {
        grid-template-columns:
            repeat(
                2,
                minmax(
                    0,
                    1fr
                )
            );
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 649.98px) {

    #results {
        grid-template-columns: 1fr;
    }

}

</style>