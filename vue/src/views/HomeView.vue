<!-- Home View Display --->
<template>

  <!-- Browser Tab Title -->
  <head>
    <title>Home | Best Buds</title>
  </head>

  <!-- Display Header Component -->
  <header id="top">
    <Header/>
  </header>

  <!-- Display View Body -->
  <body id="home-body">

    <!-- Display Body's Main Content -->
    <main id="home-main">

      <!-- Display Body Title -->
      <h1>Welcome to Best Buds!</h1>

      <!-- Display View Jump Links Component -->
      <aside id="view-links">
        <ViewJumpLinks/>
      </aside>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>🌿Need to find the nearest spot to grab some legal goodies?🌿</h2>
        <p>Our dispensary locator is like a GPS for your chill – just plug in your location and let it guide you to the best green in town. Whether you’re a seasoned pro or just curious, it’ll make sure you’re never more than a few taps away from your next favorite herb!</p>
        <h3>Check out the featured dispensary below or head over to our search page to find your next green spot!</h3>
      </section>

      <!-- Display Home Information -->
      <section id="home"> 

        <!-- Display Home Featured Component -->
        <article id="featured">
          <Featured/>
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
import Featured from '@/components/home_components/HomeFeatured.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "HomeView",
  components: { 
    Header,
    ViewJumpLinks,
    Featured,
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
#home-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#home-main {
  margin: 4vw;
}

h1,
#summary {
    text-align: center;
}

#summary {
    margin-bottom: 2vw;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}
</style>


