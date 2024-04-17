<template>
  <div class="header">
    <Header />
  </div>
  <div class="nav-bar">
    <NavBar />
  </div>
  <div class="home">
    <h1>Welcome to Best Buds!</h1>
    <h2>Find And Connect With Your Dispensary Here</h2>
    <div id="nav">
      <h3>"Sativa to change the things I can, indica to accept the things I can’t." -Unknown</h3>
    </div>
  </div>
  <div class="footer">
    <Footer />
  </div>
</template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
import NavBar from '../components/NavBar.vue';

export default {
  components: { Header, Footer, NavBar },

};
</script>

<style scoped>
h1 {
  text-align: center;
}

h2 {
  text-align: center;
}

h3 {
  text-align: center;
  font-style: italic;
}
</style>


