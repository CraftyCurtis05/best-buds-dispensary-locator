<!-- Yelp Search Bar Component Display-->
<template>

    <!-- Display search bar and search button; Run search method when search button is clicked -->
    <div class="search-bar">
        <input id="input-location" v-model="locationID" type="text" name="user-location" placeholder="Enter Location"/>
        <button id="search-button" v-on:click="search()">Search</button>
    </div>

</template>

<script>
export default {
    methods: {

        //Search function that gets provided locationID that is stored from search results 
        //Clear results of previous search
        //Set timeout to be able to do multiple searches without refreshing page
        search() {
            this.clearResults();
            setTimeout(() => {
                this.$store.state.locationID = this.locationID}, 500);
        },
        //Clear results function that is used during search function
        clearResults() {
            this.$store.state.locationID = null;
        }
    },
};    
</script>

<style scoped>
.search-bar {
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