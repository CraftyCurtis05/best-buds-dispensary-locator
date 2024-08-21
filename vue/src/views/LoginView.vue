<!-- Login Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Login | Best Buds</title>

  <!-- Display Page Body -->
  <body id="login-body">

    <!-- Display Login Main Content -->
    <main id="login-main">

      <!-- Display Logo -->
      <img src="src\assets\logo_assets\cropped\best_buds_logo_black cropped.png"/>

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
import authService from "@/services/AuthService";

export default {
  name: "Login",
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
/* ALL = vw (Will not move with zoom) */
#login-body {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  max-width: 100%;
  height: 45.7vw;
  overflow-x: hidden;
  overflow-y: hidden;
  background: linear-gradient(0deg, rgba(0, 0, 0, 0.497), rgba(164, 164, 164, 0.881)), url('https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExdjI1ZXR4Z3g3c2k2c2gzbnRqeTczNmlwb29oaHE5M3QwdmRscTc1cCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/ftfVpeWsm95QgGfOZ8/giphy.gif');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#login-main {
  position: fixed;
  display: flex;
  flex-direction: column;
  text-align: center;
}

img {
  width: 20vw;
  margin-inline-end: 1vw;
}

h1 {
  font-size: 1.5vw;
  margin-top: .7vw;
  margin-bottom: .1vw;
}

.form-input-group {
  margin: 1vw;
}

label {
  display: flex;
  flex-direction: column;
  font-size: 1.2vw;
}

#username,
#password {
  width: 12vw;
  max-width: 12vw;
  height: 1.5vw;
  max-height: 1.5vw;
  font-size: 1.1vw;
  margin: .1vw;
}

button {
  width: 9vw;
  height: 2.3vw;
  font-size: 1.1vw;
  border-radius: .3vw;
  background-color: #377306;
  margin: .5vw auto;
}

button:hover {
  cursor: url('best_buds_logo_icon.ico'), pointer;
  color: black;
  background: linear-gradient(270deg, #377306, transparent) #01331b;
}

p {
  font-size: 1.2vw;
  margin: 1vw auto;
}
</style>