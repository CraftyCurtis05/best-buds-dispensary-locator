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

    <!-- Best Buds Drop Reveal -->
    <DropReveal
      v-bind:is-open="isDropRevealOpen"
      v-bind:user-collectible="newDrop"
      v-on:close="closeDropReveal"
      v-on:view-stash="viewStash"
    />

  </div>
</template>

<script>
import AppHeader from './components/layout/Header.vue';
import JumpLinks from './components/layout/JumpLinks.vue';
import AppQuote from './components/layout/Quote.vue';
import AppFooter from './components/layout/Footer.vue';
import DropReveal from './components/collectibles/DropReveal.vue';

import CollectibleService from './services/CollectibleService.js';

export default {

  components: {
    AppHeader,
    JumpLinks,
    AppQuote,
    AppFooter,
    DropReveal
  },

  data() {
    return {
      newDrop: null,
      isDropRevealOpen: false,
      hasCheckedForDrops: false
    };
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
    },

    // Check whether the user is ready to use the application
    isUserReady() {

      const onboardingRoutes = [
        'login',
        'register',
        'age-confirmation',
        'profile-setup'
      ];

      return this.$store.state.token !== ''
        && this.$store.state.user?.ageConfirmed
        && this.$store.state.profile
        && !onboardingRoutes.includes(
          this.$route.name
        );
    }
  },

  watch: {

    // Check for new Drops after authentication and onboarding
    isUserReady: {
      immediate: true,
      handler(isUserReady) {

        if (
          isUserReady
          && !this.hasCheckedForDrops
        ) {
          this.checkForDrops();
        }

        if (!isUserReady) {
          this.hasCheckedForDrops = false;
        }
      }
    }
  },

  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    },

    // Check whether the authenticated user has earned a new Drop
    checkForDrops() {

      this.hasCheckedForDrops = true;

      CollectibleService.checkForDrops()
      .then(response => {

        if (
          response.status === 200
          && response.data
        ) {
          this.newDrop = response.data;
          this.isDropRevealOpen = true;
        }
      })
      .catch(error => {

        console.error(
          "Unable to check for new Drops:",
          error
        );
      });
    },

    // Close the Drop reveal
    closeDropReveal() {
      this.isDropRevealOpen = false;
    },

    // Continue to the user's My Stash collection
    viewStash() {
      this.isDropRevealOpen = false;

      this.$router.push({
        name: 'profile'
      });
    }
  }
};
</script>

<style>
#app-container {
  font-size: 70%;
}

img {
  height: 10rem;
}

#main-content {
  margin-top: 11rem;
}
</style>