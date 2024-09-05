<!-- Search Map Component Display--->
<template>
    
    <!-- Display Search Map Body -->
    <body id="map-body">

        <!-- Google Map Display -->
        <GoogleMap 
            api-key="AIzaSyC_eyTPqQJl9g4WT2vYrQOnaLdC1KbdbGQ" 
            style="width:60vw;height:45vw" 
            :zoom="10"
            :center="center">
            <Marker 
                :options="{ position: center }"/>
        </GoogleMap>

    </body>

</template>
  
<script>
import { defineComponent } from "vue";
import { GoogleMap, Marker } from "vue3-google-map";

export default defineComponent({
    name: "SearchMap",

    components: {
        GoogleMap,
        Marker
    },

    data() {
        return {
            locationID: '',
            // latitude: 0,
            // longitude: 0
        }
    },

    setup() {
        const center = { lat: 39.96357, lng: -82.98995};
        return {center};
    },

    methods: {

        // Method that gets user input to create a longitude and latitude
        // If no user input, use user geolocation
        // getLocation() {
        //     this.locationID = this.$store.state.locationID;
        //     console.log(this.locationID);

        //     if (this.locationID == '') {

        //         if (navigator.geolocation) {
        //             navigator.geolocation.getCurrentPosition(function(position) {
        //                 this.latitude = position.coords.latitude;
        //                 this.longitude = position.coords.longitude;
        //                 console.log(`Latitude: ${this.latitude}, Longitude: ${this.longitude}`);
        //             });
        //         } else {
        //             console.log("Geolocation is not supported by this browser.");
        //         }
        //     }
        // }
    },

    mounted() {
       // this.getLocation();
    }
});
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
</style>