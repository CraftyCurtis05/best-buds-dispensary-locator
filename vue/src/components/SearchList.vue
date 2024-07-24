<!-- Yelp Search List Component Display-->
<template>

    <!-- Display search results and favorite button -->
    <div class="locator-search">
        <h1 id="search-list-title">List of dispensaries near you:</h1>

        <!-- Display search results within a list -->
        <div class="search-list">
            <ul>

                <!-- Loop through results array and bind result by location(result) id -->
                <div v-for="result in results" v-bind:key="result.id">

                    <!-- Display location name and bind it to location url -->
                    <div id="location-item">
                        <a id="location-name" v-bind:href="result.url" target="_blank"> {{ result.name }} </a>

                        <!-- Display location details -->
                        <div id="location-details">

                            <!-- Display location address -->
                            <p id="location-address"><a href="https:www.google.com/maps/dir/?api=1" target="_blank"></a> {{ result.location.address1 }} </p>

                            <!-- Display location image and bind to location url -->
                            <a id="location-image" v-bind:href="result.url" target="_blank"><img v-bind:src="result.image_url"/></a>

                        </div>

                        <!-- Display favorite button with each location result and use set favorite function to save location when clicked -->
                        <button id="favorite-button" @click.prevent="setFavorite(result.id)">Favorite Dispensary</button>

                    </div>
                </div>
            </ul>
        </div>
    </div>        
</template>

<script>
//Import Yelp Service to connect search with location results
import YelpService from '../services/YelpService';

//Import Java Service to connect favorites to store data within database
import JavaService from '../services/JavaService';

export default {
    data() {

        //Return location results array and location Id
        return {
            results: [],
            locationID: ''
        }
    },
    methods: {

        //Get results function that is used to get results from yelp service and add business to results array
        getResults: function(locationID) {
            YelpService.getGreen(locationID).then(response => {
                this.results = response.data.businesses;
                console.log(this.results);
            })
            .catch(error => {
                console.log(error);
            })
        },

        //Set favorite function when button is clicked that stores location into database
        setFavorite: function(value) {
            this.$store.commit('SET_FAVORITE_STATUS',  value);
            JavaService.makeFavorite({ name: 'favorite', params: { businessId: this.$store.state.id, businessName: this.$store.state.name, businessAddress: this.$store.state.location.address1 }});
        },

        //Created function that retrieves results and stores results by location Id
        created: function() {
            this.getResults(this.$store.state.locationID);
        }
    }
};   
</script>

<style scoped>
.locator-search {
    background-color: grey;
    width: 23vw;
}

#search-list-title {
    font-size: 110%;
    text-decoration: underline;
}

.search-list {
    font-size: 100%;
    font-weight: bold;
}
</style>