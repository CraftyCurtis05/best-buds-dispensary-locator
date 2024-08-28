<!-- TO RUN APPLICATION DIRECTIONS -->
<!-- Install npm package in terminal: npm install -->
<!-- Install axios package in terminal: npm i axios -->
<!-- Install google maps package in terminal: npm i vue3-google-map -->
<!-- npm run dev -->

<template>
  <div id="capstone-app">
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
  margin: 0;
  padding: 0;	
}

</style>