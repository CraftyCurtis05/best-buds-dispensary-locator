                                    <!-- <<<<<<<<<<<< ACTIVELY WORKING ON >>>>>>>>>>>>>> -->

<template>

    <section id="result-object">

        <!-- Loop Through Results Array From getResults Function and Bind Each Result to the Result's ID -->
        <article id="result-object" v-for="key in result" v-bind:key="key.id">

            <!-- Display Result Name and Link to Result's URL -->
            <h2 v-bind:href="key.url" target="_blank">{{ key.name }}</h2>

            <!-- Display Result Details -->
            <div id="result-details">

                <!-- Display Result Address -->
                <h2 id="result-address1">{{ key.location.address1 }} {{ key.location.address2 }}</h2>
                <h2 id="result-address2">{{ key.location.city }}, {{ key.location.state }} {{ key.location.zip_code }}</h2>
                <h3 id="result-phone">{{ key.display_phone }}</h3>

                <!-- Display Result Image and Link to Result's URL -->
                <a v-bind:href="key.url" target="_blank"><img id="result-image" v-bind:src="key.image_url"/></a>

            </div>
        </article>    

    </section>

</template>

<script>
// Import JS Object Containing States To Randomize Location for Top Rated in State
import StatesList from '@/assets/featured_assets/featured.js';

// Import Yelp Service to Run getGreen Function to Connect to API and Return Results
import YelpService from '@/services/YelpService';

export default {
    name: "HomeFeaturedComponent",
    
    data() {
        return {
            states: StatesList,
            result: [],
            state: ''
        }
    },

    methods: {

        getState() {
            const randomIndex = Math.floor(Math.random() * this.states.length);
            this.state = this.states[randomIndex].state;
            console.log(this.state);
        },

        getResult(state) {

            //while (this.result.length === 0) {
                YelpService.getFeatured(state)

                .then(response => {
                    this.result = response.data.businesses;
                    console.log(this.result);
                })
                .catch(error => {
                    console.log(error);
                })
            //}    
        }    
    },
    created() {
        this.getState();
        this.getResult(this.state);
    }
};        
</script>

<style scoped>

</style>