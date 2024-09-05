<!-- Home Page Featured Component Display -->
<template>

    <body id="featured-body">

        <!-- Loop Through Results Array From getResults Function and Bind Each Result to the Result's ID -->
        <section id="featured" v-for="key in result" v-bind:key="key.id">

            <!-- Display Result Name and Link to Result's URL -->
            <h1 v-bind:href="key.url" target="_blank">{{ key.name }}</h1>

            <!-- Display Result Details -->
            <article id="details">

                <!-- Display Result Image and Link to Result's URL -->
                <a v-bind:href="key.url" target="_blank"><img v-bind:src="key.image_url"/></a> 

                <!-- Display Result Address -->
                <h2 id="address1">{{ key.location.address1 }} {{ key.location.address2 }}</h2>
                <h2 id="address2">{{ key.location.city }}, {{ key.location.state }} {{ key.location.zip_code }}</h2>
                <h3 id="phone">{{ key.display_phone }}</h3>

            </article>   

        </section>

    </body>

</template>

<script>
// Import JS Object Containing States To Randomize State Location for getGreen Function Argument
import StatesList from '@/assets/featured_assets/featured.js';

// Import Yelp Service to Run getGreen Function to Connect to API and Return Results
import YelpService from '@/services/YelpService';

export default {
    name: "HomeFeatured",
    
    data() {
        return {
            states: StatesList,
            result: [],
            state: '',
            defaultValue: false
        }
    },

    methods: {

        // Generates a Random Index Number
        // Retrieves That Index's State Property From The Imported StatesList Object Array
        // Sets State Variable To Generated State Property At Randomized Index
        getState() {
            const randomIndex = Math.floor(Math.random() * this.states.length);
            this.state = this.states[randomIndex].state;
            console.log(this.state);
        },

        // Function That Takes a State Argument That Is A Variable Set From Above Method
        // Calls YelpService.getFeatured Method That Uses The State Variable In The URL For The Yelp API Call
        // Sets Result Array To The API Data Response Array Or Sends Error To Console
        getResult(state) {

            YelpService.getFeatured(state)
            .then(response => {
                this.result = response.data.businesses;
                console.log(this.result);
            })
            .catch(error => {
                console.log(error);
            })  
        },

        // Check if Result Image URL is a, Actual Image             <<<<<<<<<<<<<<<<<WORKINNG ON RETURN RESULT VERIFICATION>>>>>>>>>>>>>>>>>
        isValid(urlTocheck="") {
            let image = new Image();
            this.result.img_url = urlTocheck;
            if (image.width !== 0) {
                this.defaultValue = true;
                console.log(this.defaultValue);
            }
        }    
    },

    created() {

        // Method Calls When The Page Is Rendered
        // Checks To Verify Result Has Image and Array Length Before Running Methods To Guarantee Result with Image
        if(this.defaultValue) {
            this.getState();
            this.getResult(this.state);                           //  <<<<<<<<<<<<<<<<<WORKINNG ON RETURN RESULT VERIFICATION>>>>>>>>>>>>>>>>>
            this.isValid();
        }
        else if(this.result.length === 0) {
            this.getState();
            this.getResult(this.state);
            this.isValid();
        } else {
            console.log("Please refresh page. We got issues.")
        }
    }
};        
</script>

<style scoped>
#featured-body {
    display: flex;
    justify-content: center;
    /* align-items: center; */
}

#featured {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 99%;
    height: 42rem;
    background-color: black;
}

h1 {
    font-size: 1.5rem;
    color: white;
}

img {
    height: 30rem;
    margin: -1vw;
    border: .5rem white solid;
}

h2 {
    font-size: 1.1rem;
    color: white;
}

h3 {
    font-size: 1rem;
    color: white;
}
</style>