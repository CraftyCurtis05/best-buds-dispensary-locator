<!-- Articles View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Articles | Best Buds</title>

  <!-- Display View Body -->
  <body id="articles-body">

    <!-- Display Body's Main Content -->
    <main id="articles-main">

      <!-- Display Body Title -->
      <h1>The Cannabis Resource Center</h1>

      <section id="summary">
        <h2>Explore the World of Cannabis: Search Articles and Expand Your Mind!</h2>
        <p>Our articles cover everything from strain breakdowns to the latest trends, so you can navigate the world of cannabis with confidence. Whether you're a beginner or a seasoned enthusiast, we've got something for everyone!</p>
        <h3>Looking for more info? Dive into our library of cannabis articles below!</h3>
      </section>  
      

      <!-- Display About Us Information -->
      <section id="articles">

          <!-- Display Articles Search Component -->
          <article id="search">
            <SearchArticles/>
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

  </body>

</template>

<script>
import SearchArticles from '../components/articles/Search.vue';
import StrainGuideVisit from '../components/strain-guide/Visit.vue';
import ArticlesVisit from '../components/articles/Visit.vue';

export default {
  name: "ArticlesView",

  components: { 
    SearchArticles,
    StrainGuideVisit,
    ArticlesVisit
  }
};
</script>

<style scoped>

</style>