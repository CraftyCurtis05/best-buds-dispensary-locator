<!-- Privacy Policy Page Display --->
<template>

  <!-- Browser Tab Title -->
  <title>Privacy Policy | Best Buds</title>

  <header>
    <!-- Display Header Component -->
    <Header/>
  </header>

  <body class="privacy-policy-view"> 

    <!-- Display Privacy Policy Description -->
    <div class="privacy-policy-description">
      <h1>Privacy Policy</h1>
      <h2>***ADD PRIVACY POLICY HEADERS***</h2>
      <h3>***ADD PRIVACY POLICY INFO***</h3>
    </div>

    <!-- Display Page Quote -->
    <h6>“A joint a day keeps the bad mood away.” -Unknown</h6> 
  </body>

  <footer>
    <!-- Display Footer Component -->
    <Footer />
  </footer> 
</template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';

export default {
  name: "privacypolicy",
  components: { Header, Footer }
};
</script>

<style scoped>
.privacy-policy-view {
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