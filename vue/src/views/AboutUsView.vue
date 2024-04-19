<template>
    <div class="header">
    <Header />
  </div>
  <div class="nav-bar">
    <NavBar />
  </div>
    <div class="container">
        <h1>About Us</h1>
    </div>
   <h3>“A joint a day keeps the bad mood away.” -Unknown</h3>
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
    name: "AboutUsView"
}
</script>

<style scoped>
#search-form{
    margin-top: 20px;
}
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