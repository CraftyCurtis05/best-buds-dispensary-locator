<!-- Search Bar Component Display-->
<template>

    <!-- Display Search Bar and Search Button; Run Search and Get Location Method When Search Button is Clicked -->
    <body id="search-bar">
        <input id="input-location" v-model="locationID" type="text" name="user-location" placeholder="Enter Location"/>
        <button id="search-button" v-on:click="search(),getUserLocation()">Search</button>
    </body>

</template>

<script>
export default {
  name: "SearchBarComponent",

  data() {
    return {
      locationID: ''
    }
  },

  methods: {
    // Clear Results Function That Resets Stored LocationID
    clearResults() {
      this.$store.state.locationID = null;
    },
    // Search Function That Stores LocationID From User Input
    // Clear Results of Previous Search When New Search is Performed
    // Set Timeout to Perform Multiple Searches WithoutRrefreshing Page
    search() {
      this.clearResults();
      setTimeout(() => {
        this.$store.state.locationID = this.locationID}, 500);
    }
  }
};    
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#search-bar {
  display: flex;
  align-items: center;
  background-color: #01331b;
  max-width: 50vw;
  border-radius: .3vw;
  padding: .15vw;
}

#input-location {
  flex: 1;
  padding: .7vw;
}

#search-button {
  border-radius: .3vw;
  padding: .7vw 1.5vw;
  margin-left: .2vw;
  background-color: #377306;
}

#search-button:hover {
  cursor: url('best_buds_logo_icon.ico'), pointer;
  color: black;
  background: linear-gradient(270deg, #377306, transparent) #01331b;
}
</style>