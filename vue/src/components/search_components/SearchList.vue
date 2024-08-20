<!-- Search List Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="search-body">

        <!-- Display Component Title -->
        <h1>List of dispensaries near you:</h1>

        <!-- Display Search Results List -->
        <section id="results">

            <!-- Loop Through Results Array From getResults Function and Bind Each Result to the Result's ID -->
            <ul id="result-object" v-for="result in results" v-bind:key="result.id">

                <!-- Display Result Name and Link to Result's URL -->
                <h2 v-bind:href="result.url" target="_blank">{{ result.name }}</h2>

                <!-- Display Result Details -->
                <div id="result-details">

                    <!-- Display Result Address -->
                    <h3 id="result-address">{{ result.location.display_address }}</h3>

                    <!-- Display Result Image and Link to Result's URL -->
                    <!-- <a v-bind:href="result.url" target="_blank"><img id="result-image" v-bind:src="result.image_url"/></a> -->

                </div>

                <!-- Display Favorite Button and When Clicked Run setFavorite Method to Store In User's Profile -->
                <button id="favorite-button" v-on:click.prevent="setFavorite(result.id)">Favorite Dispensary</button>
            </ul>       

        </section>

    </body> 
       
</template>
  
<script>
// Import Yelp Service to Run getGreen Function to Connect to API and Return Results
import YelpService from '@/services/YelpService';

// Import Java Service to Store Favorites to Database
import JavaService from '@/services/JavaService';
  
export default {
    name: "SearchListComponent",
    
    data() {
        // Results Array Initialized to Hold Results From getResults Function Bc Used In Template and Script
        // LocationID Initialized to Be Used in getResults Function bc its Used in Script and Yelp Service
        return {
            results: [],
            locationID: ''
        }
    },

    methods: {
        // Gets Results Function That Takes in the Parameter, LocationID, That's Passed From The Store and Into the Yelp Service getGreen Function
        // Results Array Holds All Results, JSON Objects, That Are Returned From the getGreen Yelp Service Function
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
        // Set Favorite Function That Stores the Result Object By Passing It Through Java Service and Stored in Database <<<< NOT WORKING >>>>>
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
    // Created Function That Retrieves Stored LocationID to Use in getResults Function
    created() {
        this.getResults(this.$store.state.locationID);
    }
};
</script>
  
<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#search-body {

}

#result-object {
    text-align: left;
    width: 22rem;
    padding-bottom: 1.2vw;
    background: pink;
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