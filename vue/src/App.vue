<!-- Install npm package in terminal: npm install -->
<!-- Install axios package in terminal: npm i axios -->
<!-- Open: https://cors-anywhere.herokuapp.com/corsdemo - Select 'Request temporary access to the demo server' -->
<!-- Install google maps package in terminal: npm i vue3-google-map -->
 <!-- npm run dev -->

<template>
  <div id="capstone-app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <router-view />
  </div>
</template>

<script>
export default {
  components: {

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
body {
  padding: 0;
  margin: 0;
}

</style>