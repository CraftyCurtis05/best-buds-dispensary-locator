<!-- Articles Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Articles | Best Buds</title>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="articles-body">

    <main id="articles-main">

      <!-- Display Page Title -->
      <h1>***NEEDS PAGE TITLE***</h1>

        <!-- Display Page Summary -->
        <p>***PAGE SUMMARY***</p>

      <!-- Display About Us Information -->
      <section id="articles">
        <h2>***NEEDS ARTICLES PAGE HEAD LINER***</h2>
          <p>***NEEDS ARTICLES SEARCH SUMMARY***</p>

          <!-- Display Articles Search Component -->
          <article id="articles-search">
            <SearchArticlesComponent/>
          </article>  
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

  <footer>
    <Footer/>
  </footer>

</template>

<script>
import Header from '@/components/Header.vue';
import SearchArticlesComponent from '@/components/articles_components/SearchArticles.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "Test",
  components: { Header, SearchArticlesComponent, StrainGuideVisit, ArticlesVisit, QuoteComponent, Footer }
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
  padding-top: 2rem;
}

p {
    margin: auto 8vw;
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