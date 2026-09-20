<!-- Register View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Register | Best Buds</title>

  <!-- Display View Body -->
  <body id="register-body">

    <!-- Display Body's Main Content -->
    <main id="register-main">

      <!-- Display Logo -->
      <img src="src\assets\logo_assets\cropped\best_buds_logo_black cropped.png"/>

      <!-- Display Body Title -->
      <h1>Create Account</h1>

      <!-- Display Register Form -->
      <section id="register-form">
        <form v-on:submit.prevent="register">

          <!-- Alert If Invalid Registration Credentials -->
          <div role="alert" v-if="registrationErrors">{{ registrationErrorMsg }}</div>

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

          <!-- Confirm Password Text Input -->
          <div class="form-input-group">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirm-password" v-model="user.confirmPassword" required/>
          </div>

          <!-- Submit Button -->
          <button type="submit">Create Account</button>

          <!-- Link to Login Page If Already Have Account -->
          <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
        </form>
      </section>

    </main>  

  </body>

</template>

<script>
import authService from '../services/AuthService.js';

export default {
  name: "RegisterView",

  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },

  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

</style>
