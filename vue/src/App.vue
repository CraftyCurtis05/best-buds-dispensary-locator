<!-- App.vue -->
<template>
  <div id="app-container">

    <!-- Global Header with Site-Wide Navbar -->
    <header id="top" role="banner">
      <AppHeader />
    </header>  

    <!-- The core content block of the page -->
    <main id="main-content">

      <!-- In-Page Table of Contents (Jump Links) -->
      <nav id="jump-links" aria-label="On this page">
        <JumpLinks />
      </nav>

      <!-- Dynamic Page Views -->
      <router-view />

      <!-- Global Page Quote -->
      <section id="quote" aria-label="Page Quote">
        <AppQuote />
      </section>  

    </main>

    <!-- Global Footer -->
    <footer id="bottom" role="contentinfo">
      <AppFooter />
    </footer>

  </div>
</template>

<script>
import AppHeader from './components/layout/Header.vue';
import JumpLinks from './components/layout/JumpLinks.vue';
import AppQuote from './components/layout/Quote.vue';
import AppFooter from './components/layout/Footer.vue';

export default {

  components: {
    AppHeader,
    JumpLinks,
    AppQuote,
    AppFooter
  },

  computed: {
    notification() {
      return this.$store.state.notification;
    },
    notificationClass() {
      return {
        'status-message': true,
        error: this.notification?.type?.toLowerCase() === 'error',
        success: this.notification?.type?.toLowerCase() === 'success'
      };
    }
  },

  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    }
  }
};
</script>

<style>

</style>