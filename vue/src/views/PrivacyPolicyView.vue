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
    <main id="privacy-poilcy-main">

      <!-- Display Page Title -->
      <h1>Privacy Policy</h1>

      <!-- Display Privacy Policy Information -->
      <section id="privacy-policy">
        <h2>***ADD PRIVACY POLICY HEADERS***</h2>

        <h3>***ADD PRIVACY POLICY SUMMARY***</h3>
      </section>

    </main>

    <!-- Display Page Quote -->
    <h6>***NEED QUOTE***</h6>

  </body>

  <!-- Display Footer Component -->
  <footer>
    <Footer/>
  </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "PrivacyPolicy",
  components: { Header, Footer }
};
</script>

<style scoped>
#privacy-policy-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

h1, 
h2,
h3, 
h6 {
  text-align: center;
}

h1 {
  font-size: 1.8em;
  font-weight: bolder;
  margin-top: 4vw;
}

h2 {
  font-size: 1.5em;
  font-weight: light;
}

h6 {
  font-size: .9em;
  font-style: italic;
  font-weight: lighter;
  margin-bottom: 1vw;
}
</style>