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

        <!-- Display Page Summary -->
        <p>Need to find a dispensary? Use our cannabis locator to easily spot nearby shops. Just enter your location, and voilà! You’ll see the best places to get your favorite strains and products. It’s a quick and fun way to get your green fix!</p>

      <!-- Display Search Information -->
      <section id="search">
        <h2>Search for dispensaries near you</h2>

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
    <section id="strain-guide-visit">
      <StrainGuideVisit/>
    </section>

    <!-- Display Want More Info with Articles Link -->
    <section id="articles-visit">
      <ArticlesVisit/>
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
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';
   
export default {
  name: "Search",
  components: { Header, SearchBarComponent, SearchListComponent, SearchMapComponent, StrainGuideVisit, ArticlesVisit, QuoteComponent, Footer },
};
</script>
  
<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#search-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
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
  max-width: 29%;
  margin-top: -2vw;
  margin-left: 66vw;
  padding-top: .5vw;
}

#search-map {
  display: flex;
  margin-left: 2vw;
  margin-top: .9vw;
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