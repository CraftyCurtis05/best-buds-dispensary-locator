<!-- Dispensary Search Bar Component -->
<template>

    <form
        id="search-bar"
        role="search"
        @submit.prevent="search"
    >

        <!-- Location Search -->
        <div class="search-input-group">

            <label for="input-location">
                Search by location
            </label>

            <p id="search-location-help">
                Enter a city, state, or ZIP code.
            </p>


            <div class="search-input-row">

                <div class="search-input-container">

                    <!-- Location Icon -->
                    <span
                        class="search-location-icon"
                        aria-hidden="true"
                    >
                        ●
                    </span>

                    <input
                        id="input-location"
                        v-model="searchLocation"
                        type="search"
                        name="user-location"
                        placeholder="Columbus, OH or 43215"
                        aria-describedby="
                            search-location-help
                        "
                        autocomplete="off"
                        enterkeyhint="search"
                        spellcheck="false"
                    />

                </div>


                <!-- Search Button -->
                <button
                    id="search-button"
                    type="submit"
                    :disabled="!canSearch"
                >
                    Search

                    <span aria-hidden="true">
                        →
                    </span>
                </button>

            </div>

        </div>


        <!-- Search Near Home -->
        <div class="home-search">

            <span class="home-search-divider">
                or
            </span>

            <button
                id="search-near-home-button"
                type="button"
                @click="searchNearHome"
            >
                Search Near Home
            </button>

        </div>

    </form>

</template>


<script>

export default {

    name: "SearchBar",

    emits: [
        "search",
        "search-near-home"
    ],

    data() {

        return {
            searchLocation: ""
        };

    },

    computed: {

        // Check if a location is ready to search
        canSearch() {

            return (
                this.searchLocation
                    .trim()
                    .length > 0
            );

        }

    },

    methods: {

        // Start a search for the entered location
        search() {

            const searchLocation =
                this.searchLocation.trim();

            if (!searchLocation) {
                return;
            }

            this.$emit(
                "search",
                searchLocation
            );

        },


        // Start a search near the user's saved home
        searchNearHome() {

            this.$emit(
                "search-near-home"
            );

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Search Form
   ========================================================= */

#search-bar {
    width: 100%;
}


/* Search Input Group */
.search-input-group {
    width: 100%;
}


/* Search Label */
.search-input-group label {
    display: block;

    margin-bottom: 0.25rem;

    color:
        var(--color-text);

    font-size: 0.82rem;
    font-weight: 600;
}


/* Search Help Text */
#search-location-help {
    margin:
        0
        0
        0.7rem;

    color:
        var(--color-text-soft);

    font-size: 0.74rem;
}


/* Search Row */
.search-input-row {
    display: flex;

    gap: 0.75rem;
}


/* =========================================================
   Search Input
   ========================================================= */

.search-input-container {
    position: relative;

    flex: 1;
}


/* Location Icon */
.search-location-icon {
    position: absolute;

    top: 50%;
    left: 1rem;

    color:
        var(--color-gold);

    font-size: 0.5rem;

    transform:
        translateY(-50%);

    pointer-events: none;
}


/* Location Input */
#input-location {
    width: 100%;

    min-height: 3.25rem;

    padding:
        0.75rem
        1rem
        0.75rem
        2rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text);

    font-size: 0.9rem;
}


/* Input Placeholder */
#input-location::placeholder {
    color:
        var(--color-text-soft);

    opacity: 0.72;
}


/* Search Input Focus */
#input-location:focus {
    border-color:
        var(--color-border-strong);

    box-shadow:
        0 0 0 3px
        var(--color-primary-soft);
}


/* =========================================================
   Search Button
   ========================================================= */

#search-button {
    display: inline-flex;
    align-items: center;
    justify-content: center;

    gap: 0.5rem;

    min-width: 8rem;

    min-height: 3.25rem;

    padding:
        0.75rem
        1.2rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-background);

    font-size: 0.84rem;
    font-weight: 600;

    cursor: pointer;

    transition:
        transform 160ms ease,
        background 160ms ease;
}


/* Search Button Hover */
#search-button:hover:not(:disabled) {
    background:
        var(--color-primary-hover);

    transform:
        translateY(-1px);
}


/* Disabled Search */
#search-button:disabled {
    cursor: not-allowed;

    opacity: 0.48;
}


/* =========================================================
   Search Near Home
   ========================================================= */

.home-search {
    display: flex;
    align-items: center;

    gap: 0.75rem;

    margin-top: 1rem;
}


/* Or Divider */
.home-search-divider {
    color:
        var(--color-text-soft);

    font-size: 0.72rem;

    text-transform: uppercase;
}


/* Search Near Home */
#search-near-home-button {
    padding:
        0.5rem
        0.8rem;

    background:
        transparent;

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.78rem;
    font-weight: 600;

    cursor: pointer;

    transition:
        background 160ms ease,
        border-color 160ms ease;
}


/* Search Near Home Hover */
#search-near-home-button:hover {
    background:
        var(--color-primary-soft);

    border-color:
        var(--color-border-strong);
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    .search-input-row {
        flex-direction: column;
    }


    #search-button {
        width: 100%;
    }


    .home-search {
        justify-content: center;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    #search-button,
    #search-near-home-button {
        transition: none;
    }


    #search-button:hover:not(:disabled) {
        transform: none;
    }

}

</style>