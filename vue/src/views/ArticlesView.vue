<!-- Articles View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Articles | Best Buds</title>

  <!-- Display Header Component -->
  <header id="top">
    <Header/>
  </header>

  <!-- Display View Body -->
  <body id="articles-body">

    <!-- Display Body's Main Content -->
    <main id="articles-main">

      <!-- Display Body Title -->
      <h1>***NEEDS PAGE TITLE***</h1>

      <!-- Display View Jump Links Component -->
      <aside id="view-links">
        <ViewJumpLinks/>
      </aside>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>🌿***NEED ATTENTION GRABBER***🌿</h2>
        <p>***NEED PAGE SUMMARY***</p>
        <h3>***WHATS TO BE EXPECTED OF PAGE***!</h3>
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
import SearchArticles from '@/components/articles_components/SearchArticles.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "ArticlesView",
  components: { 
    Header,
    ViewJumpLinks,
    SearchArticles, 
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
#articles-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#articles-main {
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
</style>