<!-- Locator Search Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Dispensary Search | Best Buds</title>

  <header>
    <!-- Display Header Component -->
    <Header/>
  </header>

  <body class="search-view">
 
    <!-- Display Search Description -->
    <div class="search-information">
      <h1>Best Buds Dispensary Locator</h1>
      <h2>Search for dispensaries near you</h2>

      <!-- Display Search Bar -->
      <div id="search-bar">
        <SearchBar/>
      </div>

      <!-- Display Search Results List -->
      <div id="search-list">
        <SearchList v-if="this.$store.state.locationID"/>
      </div>
  
      <!-- Display Search Map -->
      <div id="search-map">
        <SearchMap />
      </div>
      
    </div>    

    <!-- Display Want More Info with Articles Link -->
    <div class="want-more">
      <h5> Want More Information? </h5>
      <div id="articles-link">
        <router-link v-bind:to="{ name:'articles'}"> Visit our articles page for more information! </router-link>
      </div>
    </div> 

    <!-- Display Page Quote -->
    <h6>***NEED QUOTE***</h6> 
  </body>

  <footer>
    <!-- Display Footer Component -->
    <Footer />
  </footer> 

</template>
  
<script>
import Header from '../components/Header.vue';
import SearchBar from '../components/SearchBar.vue';
import SearchList from '../components/SearchList.vue';
import SearchMap from '../components/SearchMap.vue';
import Footer from '../components/Footer.vue';
   
export default {
  name: "search",
  components: { Header, SearchBar, SearchList, SearchMap, Footer }
};
</script>
  
<style scoped>
.search-view {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

h1, 
h2, 
#search-bar, 
.want-more, 
h6 {
  text-align: center;
}

#search-list {
  display: flex;
  margin-left: 65vw;
}

#search-map {
  display: flex;
}

h1 {
  font-size: 1.8em;
  font-weight: bolder;
  margin-top: 4vw;
}

h2 {
  font-size: 1.5em;
  font-weight: light;
}

.want-more {
  margin-top: 3vw;
}

#articles-link {
  margin-top: -1vw;
}

h6 {
  font-size: .9em;
  font-style: italic;
  font-weight: lighter;
  margin-bottom: 1vw;
}
</style>