<!-- Privacy Policy Page Display --->
<template>

  <!-- Browser Tab Title -->
  <title>Privacy Policy | Best Buds</title>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="privacy-policy-body">

    <!-- Display Privacy Policy Main Content -->
    <main id="privacy-policy-main">

      <!-- Display Page Title -->
      <h1>Privacy Policy</h1>

      <!-- Display Privacy Policy Information -->
      <section id="privacy-policy">
        <h2>***ADD PRIVACY POLICY HEADERS***</h2>

        <h3>***ADD PRIVACY POLICY SUMMARY***</h3>
      </section>

    </main>

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
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "PrivacyPolicy",
  components: { Header, QuoteComponent, Footer }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#privacy-policy-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#privacy-policy-main {
  margin: 4vw;
}

h1,
h2,
h3 {
  text-align: center;
}

h1 {
  font-size: 1.6rem;
}

h2 {
  font-size: 1.3rem;
  padding-top: 2rem;
}

h3 {
    font-size: 1.1rem;
}
</style>