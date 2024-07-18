<!-- Yelp Search Bar Component Display-->
<template>

    <!-- Display search bar and search button; Run search method when search button is clicked -->
    <div class="search-bar">
        <input id="input-location" type="text" name="user-location" placeholder="Enter your location"/>
        <button id="search-button" @click="search">Search</button>
    </div>

    <!-- Store search results from an array by location(result) id -->
    <div id="search-result" v-for="result in results" v-bind:key="result.id">

        <!-- Store each result in results array and bind name and link name to its google result when clicked  -->
        <a id="business-name" :href="'https://www.google.com/maps/dir/?api=1&destination=' + encodeURIComponent(result.location.address1)" target="_blank">
            {{ result.name }}
        </a>

        <!-- Store each result in results array by location result address1 -->
        <p id="business-address">
            {{ result.location.address1 }}
        </p>

    </div>    
</template>

<script>
export default {
    data() {

        //Return location id from search results
        return {
            locationID: '',
            results: Array
        }
    },
    methods: {

        //Clear results function that is used during search function
        clearResults: function() {
            this.$store.state.locationID = null;
        },

        //Search function that gets provided locationID that is stored from search results 
        //Clear results of previous search
        //Set timeout to be able to do multiple searches without refreshing page
        search: function() {
            this.clearResults;
            setTimeout(() => {this.$store.state.locationID = this.locationID}, 500);
        }
    }
};    
</script>

<style scoped>
.search-bar {
    padding: 1%;
}
</style>