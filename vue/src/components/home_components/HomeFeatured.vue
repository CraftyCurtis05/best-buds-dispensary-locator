                                    <!-- <<<<<<<<<<<< ACTIVELY WORKING ON >>>>>>>>>>>>>> -->

<template>

    <section id="result-object">

        <!-- Loop Through Results Array From getResults Function and Bind Each Result to the Result's ID -->
        <article id="result-object">

            <!-- Display Result Name and Link to Result's URL -->
            <h1 v-bind:href="getResult().url" target="_blank">{{ result.name }}</h1>

            <!-- Display Result Details -->
            <div id="result-details">

                <!-- Display Result Address -->
                <h2 id="result-address1">{{ result.location.address1 }} {{ result.location.address2 }}</h2>
                <h2 id="result-address2">{{ result.location.city }}, {{ result.location.state }} {{ result.location.zip_code }}</h2>
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

// Import JS Object Containing States To Randomize Location for Top Rated in State
import StatesList from '@/assets/featured_assets/featured.js';

export default {
    name: "HomeFeaturedComponent",
    
    data() {
        return {
            states: StatesList,
            results: [],
            state: ''
        }
    },

    methods: {

        getState() {
            const randomIndex = Math.floor(Math.random() * this.states.length);
            this.state = this.states[randomIndex].state;
            console.log(this.state);
        },

        // Gets Results Function That Takes in the Parameter, LocationID, That's Passed From The Store and Into the Yelp Service getGreen Function
        // Results Array Holds All Results, JSON Objects, That Are Returned From the getGreen Yelp Service Function
        getResult() {
            
            YelpService.getFeatured(this.state)
            .then(response => {
                this.results(response.data.businesses);
                console.log(this.results);
            })
            .catch(error => {
                console.log(error);
            })
        }
    },
    created() {
        this.getResult();
    }
};        
</script>

<style scoped>

</style>