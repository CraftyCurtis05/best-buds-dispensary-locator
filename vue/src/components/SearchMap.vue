<!-- Google Map Component Display--->
<template>
    <GoogleMap 
        api-key="AIzaSyC_eyTPqQJl9g4WT2vYrQOnaLdC1KbdbGQ" 
        style="width:50%;height:500px" 
        :zoom="8">
    </GoogleMap>
</template>
  
<script>
import { GoogleMap } from "vue3-google-map";
import { defineComponent } from "vue";

export default defineComponent({
    components: {GoogleMap},
    name: 'SearchMap'
});
</script>