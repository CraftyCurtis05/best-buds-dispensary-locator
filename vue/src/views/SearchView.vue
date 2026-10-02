<!-- Dispensary Search View Display -->
<template>

    <div
        id="search-view"
        aria-labelledby="search-heading"
    >

        <!-- =================================================
             Page Introduction
             ================================================= -->

        <header id="search-header">

            <p class="search-eyebrow">
                Explore Nearby
            </p>

            <h1 id="search-heading">
                Dispensary Locator
            </h1>

            <p class="search-introduction">
                Search by city, state, or ZIP code to find
                dispensaries and explore location details,
                ratings, directions, and saved locations.
            </p>

        </header>


        <!-- =================================================
             Dispensary Search
             ================================================= -->

        <section
            id="dispensary-search"
            aria-labelledby="dispensary-search-heading"
        >

            <!-- Search Panel -->
            <div class="search-panel">

                <div class="search-panel-heading">

                    <p class="search-panel-label">
                        Find a Location
                    </p>

                    <h2 id="dispensary-search-heading">
                        Where would you like to search?
                    </h2>

                </div>


                <!-- Location Search -->
                <SearchBar
                    @search="searchDispensaries"
                    @search-near-home="
                        searchDispensariesNearHome
                    "
                />

            </div>


            <!-- =================================================
                 Travel and Legal Reminder
                 ================================================= -->

            <aside
                id="search-legal-reminder"
                aria-labelledby="
                    search-legal-reminder-heading
                "
            >

                <!-- Reminder Accent -->
                <span
                    class="legal-reminder-accent"
                    aria-hidden="true"
                >
                    !
                </span>


                <div class="legal-reminder-content">

                    <h2
                        id="
                            search-legal-reminder-heading
                        "
                    >
                        Before You Travel
                    </h2>

                    <p>
                        Cannabis laws can change when you
                        cross a state line. A product that is
                        legal in one state may not be legal
                        in another, and transporting cannabis
                        across state lines can violate
                        federal law.
                    </p>

                    <p>
                        State legalization also doesn't mean
                        cannabis is permitted on federal
                        property or everywhere within that
                        state.
                    </p>

                    <router-link
                        :to="{ name: 'legality' }"
                        class="legal-reminder-link"
                    >
                        Review Cannabis Legality

                        <span aria-hidden="true">
                            →
                        </span>
                    </router-link>

                </div>

            </aside>


            <!-- =================================================
                 Search Results
                 ================================================= -->

            <section
                v-if="hasSearchLocation"
                id="search-results-section"
                aria-labelledby="search-results-heading"
            >

                <!-- Results Header -->
                <header class="search-results-header">

                    <div>

                        <p class="results-eyebrow">
                            Search Results
                        </p>

                        <h2 id="search-results-heading">
                            Explore Dispensaries
                        </h2>

                    </div>


                    <!-- Results View Controls -->
                    <div
                        v-if="hasResults"
                        class="results-view-controls"
                        aria-label="Choose results view"
                    >

                        <button
                            type="button"
                            class="view-button"
                            :class="{
                                'view-button--active':
                                    viewMode === 'list'
                            }"
                            :aria-pressed="
                                viewMode === 'list'
                            "
                            @click="
                                setViewMode('list')
                            "
                        >
                            List
                        </button>

                        <button
                            type="button"
                            class="view-button"
                            :class="{
                                'view-button--active':
                                    viewMode === 'map'
                            }"
                            :aria-pressed="
                                viewMode === 'map'
                            "
                            @click="
                                setViewMode('map')
                            "
                        >
                            Map
                        </button>

                    </div>

                </header>


                <!-- List View -->
                <SearchList
                    v-show="viewMode === 'list'"
                    ref="searchList"
                    @drop-check-requested="
                        dropCheckRequested
                    "
                />


                <!-- Map View -->
                <SearchMap
                    v-if="showMap"
                    @activity-recorded="
                        activityRecorded
                    "
                />

            </section>

        </section>

    </div>

</template>


<script>

import {
    defineAsyncComponent
} from "vue";

import SearchBar
    from "../components/search/SearchBar.vue";

import SearchList
    from "../components/search/SearchList.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";

import {
    SEARCH_SOURCES
} from "../constants/searchSources.js";


/*
 * Load Google Maps only when the user
 * chooses the Map view.
 *
 * This keeps the initial locator page
 * lighter and faster.
 */
const SearchMap =
    defineAsyncComponent(
        () =>
            import(
                "../components/search/SearchMap.vue"
            )
    );


export default {

    name: "SearchView",

    components: {
        SearchBar,
        SearchList,
        SearchMap
    },

    emits: [
        "activity-recorded",
        "drop-check-requested"
    ],

    data() {

        return {

            // Display list results by default
            viewMode: "list"

        };

    },

    computed: {

        // Check if the user has entered a search location
        hasSearchLocation() {

            return Boolean(
                this.$store.state.searchLocation
            );

        },


        // Check if dispensary results are available
        hasResults() {

            return (
                this.$store.state.dispensaries
                    .length > 0
            );

        },


        // Display the map only when requested
        showMap() {

            return (
                this.viewMode === "map"
                && this.hasResults
            );

        }

    },

    methods: {

        // Start a dispensary search
        searchDispensaries(
            searchLocation
        ) {

            // Return to the faster list view
            this.viewMode = "list";

            this.$store.commit(
                "SET_SEARCH_LOCATION",
                searchLocation
            );

            this.$store.commit(
                "SET_SEARCH_SOURCE",
                SEARCH_SOURCES.MANUAL
            );

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.AREA_SEARCH,
                    searchLocation
                )
                .then(() => {

                    this.activityRecorded();

                })
                .catch(() => {

                    /*
                     * Activity tracking should not
                     * block the search.
                     */

                });

            this.$nextTick(() => {

                this.$refs.searchList?.search(
                    searchLocation
                );

            });

        },


        // Search near the user's saved home address
        searchDispensariesNearHome() {

            // Return to the faster list view
            this.viewMode = "list";

            this.$store.commit(
                "SET_SEARCH_LOCATION",
                "Near Home"
            );

            this.$store.commit(
                "SET_SEARCH_SOURCE",
                SEARCH_SOURCES.NEAR_HOME
            );

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.AREA_SEARCH,
                    "near-home"
                )
                .then(() => {

                    this.activityRecorded();

                })
                .catch(() => {

                    /*
                     * Activity tracking should not
                     * block the search.
                     */

                });

            this.$nextTick(() => {

                this.$refs.searchList
                    ?.searchNearHome();

            });

        },


        // Change between list and map results
        setViewMode(
            viewMode
        ) {

            this.viewMode =
                viewMode;

        },


        // Pass recorded activity to the application
        activityRecorded() {

            this.$emit(
                "activity-recorded"
            );

        },


        // Request a new collectible Drop check
        dropCheckRequested() {

            this.$emit(
                "drop-check-requested"
            );

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Search View
   ========================================================= */

#search-view {
    width:
        min(
            calc(100% - 2rem),
            76rem
        );

    margin:
        0
        auto;

    padding:
        2.5rem
        0
        5rem;
}


/* =========================================================
   Page Introduction
   ========================================================= */

#search-header {
    max-width: 47rem;

    margin-bottom:
        2.5rem;
}


/* Page Eyebrow */
.search-eyebrow,
.search-panel-label,
.results-eyebrow {
    margin:
        0
        0
        0.65rem;

    color:
        var(--color-gold-dark);

    font-size: 0.7rem;
    font-weight: 600;

    letter-spacing: 0.17em;

    text-transform: uppercase;
}


/* Page Heading */
#search-heading {
    margin:
        0
        0
        1rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            2.4rem,
            6vw,
            4.6rem
        );

    font-weight: 500;

    line-height: 1;

    letter-spacing: -0.045em;
}


/* Page Introduction */
.search-introduction {
    max-width: 42rem;

    margin: 0;

    color:
        var(--color-text-soft);

    font-size:
        clamp(
            1rem,
            2vw,
            1.12rem
        );

    line-height: 1.75;
}


/* =========================================================
   Search Panel
   ========================================================= */

.search-panel {
    padding:
        clamp(
            1.4rem,
            4vw,
            2.25rem
        );

    background:
        linear-gradient(
            135deg,
            var(--color-surface),
            var(--color-surface-soft)
        );

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 16px 38px
        var(--color-shadow);
}


/* Search Panel Heading */
.search-panel-heading {
    margin-bottom: 1.4rem;
}


/* Search Panel Heading */
.search-panel-heading h2 {
    margin: 0;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.45rem,
            3vw,
            2rem
        );

    font-weight: 500;

    line-height: 1.2;
}


/* =========================================================
   Legal Reminder
   ========================================================= */

#search-legal-reminder {
    display: flex;
    align-items: flex-start;

    gap: 1rem;

    margin-top: 1rem;

    padding:
        1.15rem
        1.3rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);
}


/* Legal Reminder Accent */
.legal-reminder-accent {
    display: grid;
    place-items: center;

    width: 2rem;
    height: 2rem;

    flex-shrink: 0;

    background:
        var(--color-gold-soft);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-weight: 700;
}


/* Legal Reminder Heading */
.legal-reminder-content h2 {
    margin:
        0
        0
        0.45rem;

    color:
        var(--color-text);

    font-size: 0.9rem;
    font-weight: 600;

    letter-spacing: 0.04em;
}


/* Legal Reminder Text */
.legal-reminder-content p {
    margin:
        0
        0
        0.45rem;

    color:
        var(--color-text-soft);

    font-size: 0.8rem;

    line-height: 1.55;
}


/* Legal Reminder Link */
.legal-reminder-link {
    display: inline-flex;
    align-items: center;

    gap: 0.4rem;

    margin-top: 0.15rem;

    color:
        var(--color-primary);

    font-size: 0.78rem;
    font-weight: 600;

    text-decoration: none;
}


/* Legal Reminder Link Hover */
.legal-reminder-link:hover {
    color:
        var(--color-gold-dark);
}


/* =========================================================
   Search Results
   ========================================================= */

#search-results-section {
    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


/* Search Results Header */
.search-results-header {
    display: flex;
    align-items: flex-end;
    justify-content: space-between;

    gap: 1.5rem;

    margin-bottom: 1.5rem;
}


/* Results Heading */
.search-results-header h2 {
    margin: 0;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.7rem,
            4vw,
            2.5rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.03em;
}


/* =========================================================
   Results View Controls
   ========================================================= */

.results-view-controls {
    display: inline-flex;

    padding: 0.25rem;

    background:
        var(--color-surface-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);
}


/* View Button */
.view-button {
    min-width: 4.5rem;
    min-height: 2.4rem;

    padding:
        0.45rem
        0.8rem;

    background:
        transparent;

    border: 0;

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text-soft);

    font-size: 0.78rem;
    font-weight: 600;

    cursor: pointer;
}


/* Active View */
.view-button--active {
    background:
        var(--color-primary);

    color:
        var(--color-background);

    box-shadow:
        0 4px 12px
        var(--color-shadow);
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #search-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    .search-results-header {
        align-items: flex-start;
        flex-direction: column;
    }


    .results-view-controls {
        width: 100%;
    }


    .view-button {
        flex: 1;
    }


    #search-legal-reminder {
        padding: 1rem;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .legal-reminder-link,
    .view-button {
        transition: none;
    }

}

</style>