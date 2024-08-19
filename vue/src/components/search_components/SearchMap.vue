<!-- Google Map Component Display--->
<template>
    
    <GoogleMap 
        api-key="AIzaSyC_eyTPqQJl9g4WT2vYrQOnaLdC1KbdbGQ" 
        style="width:50vw;height:50vw" 
        :zoom="10"
        :center="center">
        <Marker 
            :options="{ position: center }"/>
    </GoogleMap>

</template>
  
<script>
import { defineComponent } from "vue";
import { GoogleMap, Marker } from "vue3-google-map";

export default defineComponent({
    components: {GoogleMap, Marker},
    setup() {
        const center = { lat: 45.42152967, lng: -75.6971931};
        // result in results = result.coordinates.latitude & result.coordinates.longitude
        return {center}
    }  
});
</script>

<style scoped>

</style>