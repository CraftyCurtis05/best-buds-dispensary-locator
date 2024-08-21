<template>

    <section id="result-object">

        <!-- Loop Through Results Array From getResults Function and Bind Each Result to the Result's ID -->
        <article id="result-object" v-for="result in results" v-bind:key="result.id">

            <!-- Display Result Name and Link to Result's URL -->
            <h2 v-bind:href="result.url" target="_blank">{{ result.name }}</h2>

            <!-- Display Result Details -->
            <div id="result-details">

                <!-- Display Result Address -->
                <h3 id="result-address1">{{ result.location.address1 }} {{ result.location.address2 }}</h3>
                <h3 id="result-address2">{{ result.location.city }}, {{ result.location.state }} {{ result.location.zip_code }}</h3>
                <h3 id="result-phone">{{ result.display_phone }}</h3>

                <!-- Display Result Image and Link to Result's URL -->
                <a v-bind:href="result.url" target="_blank"><img id="result-image" v-bind:src="result.image_url"/></a>

            </div>
        </article>    

    </section>

</template>

<script>
// Import Yelp Service to Run getGreen Function to Connect to API and Return Results
import YelpService from '@/services/YelpService';

// Import JS Object Containing States To Randomize Location for Top Rated in State in Featured
import StatesList from '@/assets/featured_assets/featured.js';

export default {
    name: "HomeFeaturedComponent",
    
    data() {
        return {
            states: StatesList,
            results: [],
            stateID: ''
        }
    },

    methods: {

        // Gets Results Function That Takes in the Parameter, LocationID, That's Passed From The Store and Into the Yelp Service getGreen Function
        // Results Array Holds All Results, JSON Objects, That Are Returned From the getGreen Yelp Service Function
        getResult() {
            const randomIndex = Math.floor(Math.random() * this.states.length);
            const stateID = this.states[randomIndex].state;
            
            YelpService.getFeatured(stateID)
            .then(response => {
                this.results = response.data.businesses;
                console.log(this.results);
                return this.results;
            })
            .catch(error => {
                console.log(error);
            })
        }
    },
    created() {
        this.getResults(this.stateID);
    }
};        
</script>

<style scoped>

</style>