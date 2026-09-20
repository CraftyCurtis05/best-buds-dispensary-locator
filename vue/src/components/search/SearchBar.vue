<!-- Search Bar Component Display -->
<template>

    <!-- Display Location Search -->
    <form id="search-bar" v-on:submit.prevent="search">

        <input
            id="input-location"
            v-model="locationID"
            type="text"
            name="user-location"
            placeholder="Enter Location"
        />

        <button id="search-button" type="submit">
            Search
        </button>

    </form>

</template>

<script>
export default {
    name: "SearchBar",

    data() {
        return {
            locationID: ''
        }
    },

    methods: {

        // Store the user's dispensary search location
        search() {

            const location = this.locationID.trim();

            if (!location) {
                return;
            }

            this.$store.commit('SET_LOCATION', location);
        }

    }
};
</script>

<style scoped>

</style>
