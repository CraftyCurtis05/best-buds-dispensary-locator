<!-- Yelp Search List Component Display-->
<template>

    <!-- Display search results and favorite button -->
    <body class="locator-search-view">
        <h1 id="search-list-title">List of dispensaries near you:</h1>

        <!-- Display search results within a list -->
        <div class="search-list">
            <ul>

            <!-- Loop through results array and bind result by location(result) id -->
            <div v-for="result in results" v-bind:key="result.id">

                <!-- Display location name and bind it to Yelp business url -->
                <div class="location-item">
                    <h2 v-bind:href="result.url" target="_blank"> {{ result.name }} </h2>

                    <!-- Display location details -->
                    <div id="location-details">

                        <!-- Display location address; @click:address go to Google Directions-->
                        <h3 id="location-address"> {{ result.location.display_address }} </h3>
                        
                        <!-- Display location image and bind to location url -->
                        <!-- <a id="location-name" v-bind:href="result.url" target="_blank"><img id="location-image" v-bind:src="result.image_url" /></a> -->

                    </div>

                    <div class="favorite-button-display">
                        <!-- Display favorite button with each location result and use set favorite function to save location when clicked -->
                        <button id="favorite-button" v-on:click.prevent="setFavorite(result.id)">Favorite Dispensary</button>
                    </div>   

                </div>
            </div>
            </ul>
        </div>
    </body>        
</template>
  
<script>
//Import Yelp Service to connect search with location results
import YelpService from '@/services/YelpService';

//Import Java Service to connect favorites to store data within database
import JavaService from '@/services/JavaService';
  
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
        getResults(locationID) {
            YelpService.getGreen(locationID)
            .then(response => {
                this.results = response.data.businesses;
                console.log(this.results);
            })
            .catch(error => {
                console.log(error);
            })
        },

        //Set favorite function when button is clicked that stores location into database 
        setFavorite(value) {
            this.$store.commit('SET_FAVORITE_STATUS',  value);
            JavaService.makeFavorite({ 
                name: 'favorite', 
                props: { 
                    businessId: this.$store.state.id, 
                    businessName: this.$store.state.name, 
                    businessAddress: this.$store.state.location.address1 
                }
            });
        }
    },

    //Created function that retrieves results and stores results by location Id
    created() {
        this.getResults(this.$store.state.locationID);
    }
}
</script>
  
<style scoped>
.location-item {
    padding-bottom: 2vw;
}

h1 {
    font-size: 1.5em;
    font-weight: bolder;
    margin-top: 2vw;
}

h2 {
    font-size: 1.2em;
    font-weight: light;
    margin-bottom: -.5vw;
}

h3 {
    font-size: 1em;
    font-weight: bold;
    margin-bottom: 1vw;
}
</style>