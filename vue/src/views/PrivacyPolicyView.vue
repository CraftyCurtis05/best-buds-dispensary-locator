<!-- Privacy Policy View Display --->
<template>

  <!-- Browser Tab Title -->
  <title>Privacy Policy | Best Buds</title>

  <!-- Display Header Component -->
  <header id="top">
    <Header/>
  </header>

  <!-- Display View Body -->
  <body id="privacy-body">

    <!-- Display Body's Main Content -->
    <main id="privacy-main">

      <!-- Display Body Title -->
      <h1>Privacy Policy</h1>

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

      <!-- Display Privacy Policy Information -->
      <section id="privacy">

        <!-- Display Policy Component -->
        <article id="policy">***CREATE PRIVACY POLICY COMPONENT***</article>

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
      <QuoteComponent/>
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
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "PrivacyPolicy",
  components: { 
    Header,
    ViewJumpLinks,
    StrainGuideVisit, 
    ArticlesVisit, 
    QuoteComponent, 
    Footer 
  }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#privacy-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#privacy-main {
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