<!-- Login View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Login | Best Buds</title>

  <!-- Display View Body -->
  <body id="login-body">

    <!-- Display Body's Main Content -->
    <main id="login-main">

      <!-- Display Logo -->
      <img :src="Logo" alt="Best Buds logo"/>

      <!-- Display Body Title -->
      <h1>Please Sign In</h1>

      <!-- Display Login Form -->
      <section id="login-form">
        <form v-on:submit.prevent="login">

          <!-- Alert If Invalid Login Credentials -->
          <div role="alert" v-if="invalidCredentials">
            Invalid username and password!
          </div>

          <!-- Alert If Newly Registered -->
          <div role="alert" v-if="this.$route.query.registration">
            Thank you for registering, please sign in.
          </div>

          <!-- Username Text Input -->
          <div class="form-input-group">
            <label for="username">Username</label>
            <input type="text" id="username" v-model="user.username" required autofocus/>
          </div>

          <!-- Password Text Input -->
          <div class="form-input-group">
            <label for="password">Password</label>
            <input type="password" id="password" v-model="user.password" required/>
          </div>

          <!-- Submit Button -->
          <button type="submit">Sign in</button>

          <!-- Link to Register Page If No Account -->
          <p><router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
        </form>
        
      </section>

    </main>

  </body>

</template>

<script>
import authService from "../services/AuthService.js";
import Logo from '../assets/layout/logo/logo-dark-theme.png';

export default {
  name: "LoginView",

  data() {
    return {
      Logo,

      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },

  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/home");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

</style>