<!-- Search View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Search | Best Buds</title>

  <!-- Display Header Component -->
  <header id="top">
    <Header/>
  </header>

  <!-- Display View Body -->
  <body id="search-body">
 
    <!-- Display Body's Main Content -->
    <main id="search-main">

      <!-- Display Body Title -->
      <h1>Dispensary Locator</h1>

      <!-- Display View Jump Links Component -->
      <aside id="view-links">
        <ViewJumpLinks/>
      </aside>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>🌿Need to find a dispensary?🌿</h2>
        <p>Lost in the sea of “where can I get my hands on some top-shelf green”? Fear not! Our dispensary locator is here to rescue you from your herbless woes. Just input your location and watch as it guides you straight to the nearest stash spot—because life’s too short to wander around without a good bud!</p>
        <h3>Use the search below to find dispensaries near you!</h3>
      </section>

      <!-- Display Search Information -->
      <section id="search">

        <!-- Display Search Bar Component -->
        <article id="search-bar">
          <SearchBar/>
        </article>

        <!-- Display Search Results List Component -->
        <article id="search-list">
          <SearchList v-if="this.$store.state.locationID"/>
        </article>

        <!-- Display Search Map Component -->
        <article id="search-map">
          <SearchMap/>
        </article>

      </section>

    </main> 

    <!-- Display Strain Guide Visit Component -->
    <section id="strain-guide-visit">
      <StrainGuideVisit/>
    </section>

    <!-- Display Articles Visit Component -->
    <section id="articles-visit">
      <ArticlesVisit/>
    </section>

    <!-- Display Quote Component -->
    <div id="quote">
      <Quote/>
    </div>  

  </body>

  <!-- Display Footer Component -->
  <footer id="bottom">
      <Footer/>
  </footer> 

</template>
  
<script>
import Header from '@/components/Header.vue';
import ViewJumpLinks from '@/components/ViewJumpLinks.vue';
import SearchBar from '@/components/search_components/SearchBar.vue';
import SearchList from '@/components/search_components/SearchList.vue';
import SearchMap from '@/components/search_components/SearchMap.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';
   
export default {
  name: "SearchView",
  components: { 
    Header,
    ViewJumpLinks, 
    SearchBar, 
    SearchList, 
    SearchMap, 
    StrainGuideVisit, 
    ArticlesVisit, 
    Quote, 
    Footer 
  }
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
#summary {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
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
</style>