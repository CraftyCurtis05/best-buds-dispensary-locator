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
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "Test",
  components: { Header, SearchArticlesComponent, QuoteComponent, Footer }
};
</script>