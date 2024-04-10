<template>
  <div class="header">
    <Header />
  </div>
  <div class="nav-bar">
    <NavBar />
  </div>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
     <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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


