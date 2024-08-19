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
#search-bar {
  display: flex;
  align-items: center;
  background-color: black;
  padding: .45%;
  max-width: 800px;
  margin: 0 auto;
}

#input-location {
  flex: 1;
  padding: 10px;
}

#search-button {
  border-radius: 5px;
  padding: 10px 20px;
  margin-left: 10px;
  cursor: pointer;
}

#search-button:hover {
  background-color: #122d1a;
  color: white;
}
</style>