
<template>
  <title>Search | Best Buds</title>
  <div class="search-view">
    <div class="header-nav">
      <div id="header"><Header/></div>
      <div id="nav-bar"><NavBar/></div>
    </div>  
    <div class="search">
      <h1>Best Buds Dispensary Locator</h1>
      <h2>Search for dispensaries near you</h2>
      <div id="search-bar"><SearchBar/></div>
      <div class="map-list">
        <div id="search-map"><SearchMap/></div>
        <div id="search-list"><SearchList v-if="this.$store.state.locationID"/></div> 
      </div>   
      <div class="quote">
        <h3>"If everyone smoked weed the world would be a better place." -Kirsten Dunst</h3>
      </div>
    </div>
  </div>  
  <div class="footer"><Footer/></div>
</template>
  
<script>
import Header from '../components/Header.vue';
import NavBar from '../components/NavBar.vue';
import SearchBar from '../components/SearchBar.vue';
import SearchMap from '../components/SearchMap.vue';
import SearchList from '../components/SearchList.vue';
import Footer from '../components/Footer.vue';
   
export default {
  components: {
    Header, NavBar, SearchBar, SearchMap, SearchList, Footer},
  name: "SearchView"
};
</script>
  
<style scoped>
.search-view {
  width: 100vw;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
  margin-top: -1vw;
}

.header-nav {
  position: fixed;
}

h1 {
  text-align: center;
  font-size: 130%;
  font-weight: bolder;
  padding-top: 15%;
}
  
h2 {
  text-align: center;
  font-size: 105%;
  font-weight: lighter;
}

#search-bar {
  text-align: center;
}

.map-list {
  display: flex;
  justify-content: center;
  align-content: center;
}

h3 {
  text-align: center;
  font-style: italic;
  font-weight: lighter;
  font-size: 100%;
}
</style>