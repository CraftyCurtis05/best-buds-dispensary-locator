<!-- Search Bar Component Display -->
<template>

    <!-- Display Location Search -->
    <form
        id="search-bar"
        @submit.prevent="search"
    >

        <label
            for="input-location"
            class="visually-hidden"
        >
            Search location
        </label>

        <input
            id="input-location"
            v-model="searchLocation"
            type="text"
            name="user-location"
            placeholder="Enter city, state, or ZIP code"
        />

        <button
            id="search-button"
            type="submit"
        >
            Search
        </button>

        <button
            id="search-near-home-button"
            type="button"
            @click="searchNearHome"
        >
            Search Near Home
        </button>

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

    methods: {

        // Start a dispensary search for the entered location
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

        // Start a search near the user's saved home address
        searchNearHome() {

            this.$emit(
                "search-near-home"
            );

        }

    }
};
</script>

<style scoped>

</style>