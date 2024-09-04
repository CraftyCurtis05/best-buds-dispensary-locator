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
import authService from '@/services/AuthService';

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
/* ALL = vw (Will not move with zoom) */
#register-body {
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

#register-main {
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
#password,
#confirm-password {
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
