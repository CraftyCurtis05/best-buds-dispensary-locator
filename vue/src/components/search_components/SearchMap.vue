<!-- Search Map Component Display--->
<template>
    
    <!-- Display Search Map Body -->
    <body id="search-map">

        <!-- Google Map Display -->
        <GoogleMap 
            api-key="AIzaSyC_eyTPqQJl9g4WT2vYrQOnaLdC1KbdbGQ" 
            style="width:50vw;height:50vw" 
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
    name: "SearchMapComponent",

    components: {GoogleMap, Marker},

    setup() {
        const center = { lat: 45.42152967, lng: -75.6971931};
        return {center}
    }  
});
</script>

<style scoped>

</style>