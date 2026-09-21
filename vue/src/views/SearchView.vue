<!-- Search View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Search | Best Buds</title>

  <!-- Display View Body -->
  <body id="search-body">
 
    <!-- Display Body's Main Content -->
    <main id="search-main">

      <!-- Display Body Title -->
      <h1>Dispensary Locator</h1>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>Need to find a dispensary?</h2>
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
      <StrainGuideVisit />
    </section>

    <!-- Display Articles Visit Component -->
    <section id="articles-visit">
      <ArticlesVisit />
    </section>

  </body> 

</template>
  
<script>
import SearchBar from '../components/search/SearchBar.vue';
import SearchList from '../components/search/SearchList.vue';
import SearchMap from '../components/search/SearchMap.vue';
import StrainGuideVisit from '../components/strain-guide/StrainGuideVisit.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';
   
export default {
  name: "SearchView",

  components: { 
    SearchBar,
    SearchList,
    SearchMap,
    StrainGuideVisit,
    ArticlesVisit
  }
};
</script>
  
<style scoped>

</style>