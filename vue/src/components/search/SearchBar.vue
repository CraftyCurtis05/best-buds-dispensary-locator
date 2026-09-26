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
            v-model="locationID"
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

    </form>

</template>

<script>
export default {
    name: "SearchBar",

    emits: [
        "search"
    ],

    data() {
        return {
            locationID: ""
        };
    },

    methods: {

        // Start a dispensary search for the entered location
        search() {

            const location =
                this.locationID.trim();

            if (!location) {
                return;
            }

            this.$store.commit(
                "SET_LOCATION",
                location
            );

            this.$emit(
                "search",
                location
            );

        }

    }
};
</script>

<style scoped>

</style>