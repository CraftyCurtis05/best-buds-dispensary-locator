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
                    <h3 id="result-address1">{{ result.location.address1 }} {{ result.location.address2 }}</h3>
                    <h3 id="result-address2">{{ result.location.city }}, {{ result.location.state }} {{ result.location.zip_code }}</h3>
                    <h3 id="result-phone">{{ result.display_phone }}</h3>

                    <!-- Display Result Image and Link to Result's URL -->
                    <!-- <a v-bind:href="result.url" target="_blank"><img id="result-image" v-bind:src="result.image_url"/></a> -->

                </div>

                <!-- Display Favorite Button and When Clicked Run setFavorite Method to Store In User's Profile -->
                <button id="favorite-button" v-on:click.prevent="setFavorite()">Favorite Dispensary</button>
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
    name: "SearchList",
    
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
        setFavorite(dispensary) {
            this.$store.commit('SET_FAVORITE_STATUS',  dispensary);
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
#results {
    max-height: 42vw;
    overflow-y: auto;
}

#result-object {
    text-align: left;
    width: 18rem;
    padding-bottom: 1.2vw;
    cursor: url('best_buds_logo_icon.ico'), pointer;
}

#result-object:hover {
    transform: scale(1.1);
}

h1 {
    font-size: 1.5rem;
    font-weight: bolder;
    margin-top: 2vw;
}

h2 {
    font-size: 1.2rem;
    margin-bottom: .5vw;
}

h3 {
    font-size: 1rem;
    font-weight: 400;
    margin: .5vw auto;
}

/* <<<<< MESSING AROUND WITH SCROLL BAR >>>>> */

/* Scrollbar Width */
::-webkit-scrollbar {
  width: 20px;
}

/* Buttons on Srollbar (Arrows Pointing Upwards/Downwards) */
::-webkit-scrollbar-button {
    width: 30vw;
}

/* Draggable Scrolling Handle */
::-webkit-scrollbar-thumb {
  background: rgb(53, 116, 7);
  opacity: 30;
  border-radius: 10px;
}

/* Track (Progress Bar)*/
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey;
  border-radius: 10px;
}

/* Track NOT Covered by Handle */
::-webkit-scrollbar-track-piece {

}

/* Bottom Corner of Scrollbar (Where Both Horizontal/Vertical Scrollbars Meet */
::-webkit-scrollbar-corner {

}

/* Draggable Resizing Handle That Appears at Bottom */
::-webkit-resizer {

}
</style>