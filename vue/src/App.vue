<!-- TO RUN APPLICATION DIRECTIONS -->
<!-- Install npm package in terminal: npm install -->
<!-- Install axios package in terminal: npm i axios -->


<!-- Install google maps package in terminal: npm i vue3-google-map -->
<!-- OR npm install -S vue3-google-map @googlemaps/js-api-loader -->
<!-- OR npm install -S @fawmi/vue-google-maps -->

<!-- Install emailjs package: npm install emailjs-com --save -->
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
  caret-color: transparent;
}

h1,
h2,
h3,
h4 {
  font-family: 'Raleway';
}

h1 {
  font-size: 1.6rem;
  font-weight: 700;
}

h2 {
  font-size: 1.2rem;
  font-weight: 650;
}

h3 {
  font-size: 1.1rem;
  font-weight: 650;
}

p {
  font-family: 'Roboto';
} 

input {
  caret-color: black;
}
</style>