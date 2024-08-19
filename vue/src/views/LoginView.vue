<!-- Login Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Login | Best Buds</title>

  <!-- Display Page Body -->
  <body id="login-body">

    <!-- Display Login Main Content -->
    <main id="login-main">

      <!-- Display Page Title -->
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
import authService from "../services/AuthService";

export default {
  name: "login",
  data() {
    return {
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
            this.$router.push("/");
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
.login-view {
  width: 100vw;
  max-width: 100%;
  height: 45vw;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

.login-form {
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