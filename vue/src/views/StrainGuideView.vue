<!-- Strain Guide Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Strain Guide | Best Buds</title>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="strain-guide-body">

    <!-- Display Strain Guide Main Content -->
    <main id="strain-guide-main">

      <!-- Display Page Title -->
      <h1>Strain Type and Terpene Guide</h1>

      <!-- Display Page Summary -->
      <p>Every cannabis strain has a name, a type and terpenes. While most dispensaries categorize cannabis by the type--indica, sativa or hybrid; terpenes are another great way to find the best cannabis strain for you. Below is a basic guide to strains and the most common terpenes.</p>

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
        <h5>Looking for more information?</h5>
        <summary id="articles-link">
            <router-link v-bind:to="{ name:'articles' }">Visit our articles page</router-link>
        </summary>
    </section>

    <!-- Display Quote Component -->
    <div id="quote">
      <QuoteComponent/>
    </div>  

  </body>

  <!-- Display Footer Component -->
  <footer>
    <Footer/>
  </footer>

</template>

<script>
import Header from '@/components/Header.vue';
import Strain101Component from '@/components/strain_guide_components/Strain101Component.vue';
import Turpene101Component from '@/components/strain_guide_components/Turpene101Component.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "StrainGuide",
  components: { Header, Strain101Component, Turpene101Component, QuoteComponent, Footer }
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

h5 {
  font-size: 1rem;
  margin: .1vw;
}

#articles-visit {
  padding: 1vw;
}
</style>