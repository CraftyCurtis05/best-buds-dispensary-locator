<!-- Search Page Display -->
<template>

  <!-- Browser Tab Title -->
   <head>
    <title>Search | Best Buds</title>
   </head>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="search-body">
 
    <!-- Display Search Main Content -->
    <main id="search-main">

      <!-- Display Page Title -->
      <h1>Best Buds Dispensary Locator</h1>

      <!-- Display Search Information -->
      <section id="search">
        <h2>Search for dispensaries near you</h2>
          <p>***NEED SEARCH LOCATOR SUMMARY***</p>

        <!-- Display Search Bar -->
        <div id="search-bar">
          <SearchBarComponent/>
        </div>

        <!-- Display Search Results List -->
        <div id="search-list">
          <SearchListComponent v-if="this.$store.state.locationID"/>
        </div>

        <!-- Display Search Map -->
        <div id="search-map">
          <SearchMapComponent/>
        </div>
      </section>

    </main> 

    <!-- Display Strain Guide Link -->
    <section id="strain-guide">
      <h4>Looking for more information on types and strains?</h4>
      <summary id="strain-guide-link">
        Please check out our <router-link v-bind:to="{ name:'strainguide' }">Strain Guide</router-link> for information.
      </summary>
    </section>

    <!-- Display Want More Info with Articles Link -->
    <section id="articles-visit">
      <h5>Looking for more information?</h5>
      <summary id="articles-link">
        <router-link v-bind:to="{ name:'articles' }">Visit our articles page</router-link>
      </summary>
    </section>

    <!-- Display Quote Component -->
    <div id="quote">
      <QuoteComponent/>
    </div>  

  </body>

  <!-- Display Footer Component -->
  <footer>
    <Footer/>
  </footer> 

</template>
  
<script>
import Header from '@/components/Header.vue';
import SearchBarComponent from '@/components/search_components/SearchBar.vue';
import SearchListComponent from '@/components/search_components/SearchList.vue';
import SearchMapComponent from '@/components/search_components/SearchMap.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';
   
export default {
  name: "Search",
  components: { Header, SearchBarComponent, SearchListComponent, SearchMapComponent, QuoteComponent, Footer },
};
</script>
  
<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#search-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#search-main {
  margin: 4vw;
}

h1,
h2,
p,
#strain-guide,
#articles-visit {
  text-align: center;
}

h1 {
  font-size: 1.6rem;
}

h2 {
  font-size: 1.3rem;
  padding-top: 1rem;
}

p {
    margin: auto 8vw;
}

#search-bar {
  margin: 1.5vw auto;
}

#search-list {
  position: absolute;
  max-width: 35%;
  margin-top: -2vw;
  margin-left: 60vw;
  padding-top: .5vw;
  padding-bottom: 40vw;
}

#search-map {
  display: flex;
  margin-left: 4vw;
}

h4,
h5 {
    font-size: 1rem;
    margin: .1vw;
}

#strain-guide,
#articles-visit {
    padding: 1vw;
}
</style>