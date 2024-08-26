<!-- Strain Guide Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Strain Guide | Best Buds</title>

  <!-- Display Header Component -->
  <header id="top">
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="strain-guide-body">

    <!-- Display Main Content -->
    <main id="strain-guide-main">

      <!-- Display Page Title -->
      <h1>Strain Type and Terpene Guide</h1>

      <!-- Display Page Summary -->
      <p>Every cannabis strain has a name, a type and terpenes. While most dispensaries categorize cannabis by the type--indica, sativa or hybrid; terpenes are another great way to find the best cannabis strain for you. Below is a basic guide to strains and the most common terpenes.</p>

      <!-- Display Page Jump Links -->
      <aside id="page-jump-links">
        <PageJumpLinks/>
      </aside>

      <!-- Display Strain Guide  -->
      <section id="strain-101">
        <Strain101Component/>
      </section>

      <!-- Display Terpene Guide  -->
      <section id="turpene-101">
        <Turpene101Component/>
      </section>

    </main>

    <!-- Display Want More Info with Articles Link -->
    <section id="articles-visit">
      <ArticlesVisit/>
    </section>

    <!-- Display Quote Component -->
    <section id="quote">
      <QuoteComponent/>
    </section>  

  </body>

  <!-- Display Footer Component -->
  <footer id="bottom">
    <Footer/>
  </footer>

</template>

<script>
import Header from '@/components/Header.vue';
import PageJumpLinks from '@/components/PageJumpLinks.vue';
import Strain101Component from '@/components/strain_guide_components/Strain101Component.vue';
import Turpene101Component from '@/components/strain_guide_components/Turpene101Component.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "StrainGuide",
  components: { 
    Header,
    PageJumpLinks,
    Strain101Component, 
    Turpene101Component, 
    ArticlesVisit, 
    QuoteComponent, 
    Footer 
  }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#strain-guide-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#strain-guide-main {
  margin: 4vw;
}

h1,
p,
#articles-visit {
  text-align: center;
}

h1 {
  font-size: 1.6rem;
}

p {
  margin: auto 8vw;
}
</style>