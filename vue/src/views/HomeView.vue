<!-- HomeView.vue -->
<template>
  <div id="home-view">
    
    <!-- Page Introduction -->
    <section id="hero" aria-labelledby="hero-heading">
      <h1 id="hero-heading">Welcome to Best Buds!</h1>
      <h2>Need to find the nearest spot to grab some legal goodies?</h2>
      <p>Our dispensary locator is like a GPS for your chill...</p>
    </section>

    <!-- Main Feature -->
    <section id="featured-dispensary" aria-labelledby="featured-heading">
      <h2 id="featured-heading">Featured Dispensary</h2>
      <article><Featured /></article>
    </section>

    <!-- Visit Links -->
    <section id="strain-guide" aria-labelledby="strain-heading">
      <h2 id="strain-heading">Explore Our Strain Guide</h2>
      <StrainGuideVisit />

      <h2 id="articles-heading">Latest Cannabis Articles</h2>
      <ArticlesVisit />
    </section>

  </div>
</template>

<script>
import Featured from '../components/home/HomeFeatured.vue';
import StrainGuideVisit from '../components/strain_guide/StrainGuideVisit.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
  name: "HomeView",
  components: { 
    Featured,
    StrainGuideVisit,
    ArticlesVisit
  }
};
</script>

<style scoped>

</style>
