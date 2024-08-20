<!-- Register Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Register | Best Buds</title>

  <!-- Display Page Body -->
  <body id="register-body">

    <!-- Display Register Main Content -->
    <main id="register-main">

      <!-- Display Page Title -->
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
            <input type="password" id="confirmPassword" v-model="user.confirmPassword" required/>
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
import authService from '@/services/AuthService';

export default {
  name: "Register",

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
#register-body {
  width: 100vw;
  max-width: 100%;
  height: 45vw;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

.register-form {
  display: flex;
  justify-content: center;
  text-align: center;
  margin-top: 10vw;
}

.form-input-group {
  margin-bottom: 1em;
}

label {
  margin-right: 0.5em;
}
</style>
