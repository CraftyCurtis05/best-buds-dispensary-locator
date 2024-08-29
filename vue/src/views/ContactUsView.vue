<!-- Contact Us View Display --->
<template>

  <!-- Browser Tab Title -->
  <title>Contact Us | Best Buds</title>

  <!-- Display Header Component -->
  <header>
      <Header/>
  </header>

  <!-- Display View Body -->
  <body id="contact-body">

    <!-- Display Body's Main Content -->
    <main id="contact-main">

      <!-- Display Body Title -->
      <h1>Contact Us</h1>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>🌿***NEED ATTENTION GRABBER***🌿</h2>
        <p>***NEED PAGE SUMMARY***</p>
        <h3>***WHATS EXPECTED OF PAGE***</h3>
      </section>

      <!-- Display Contact Us Information -->
      <section id="contact-us">

        <!-- Display Contact Us Form -->
        <article id="contact-us-form">

          <div class="contact-container" style="width: 450px;">

            <card class="card-section" style="width: 450px; margin: auto">

              <form ref="values" @submit.prevent="sendEmail">

                <div class="form-group">
                  <input
                    class="form-input"
                    name="name"
                    v-model="user_name"
                    placeholder="Name"
                    required
                  />
                </div>

                <div class="form-group">
                  <input
                    class="form-input"
                    name="email"
                    v-model="user_email"
                    placeholder="Email"
                    required
                  />
                </div>

                <div class="form-group">
                  <input
                    class="form-input"
                    name="favstrain"
                    v-model="fav_strain"
                    placeholder="Favorite Strain"
                    required
                  />
                </div>

                <div class="form-group">
                  <textarea
                    class="form-input"
                    name="message"
                    v-model="user_message"
                    placeholder="Message"
                    :rows="4"
                    required
                  />
                </div>

                <div class="submit">
                  <Button id="submit-btn">Submit</Button>
                </div>

              </form>
            </card>
          </div>
        </article>

      </section>

    </main>      

    <!-- Display Quote Component -->
    <div id="quote">
        <Quote/>
    </div>  

  </body>

    <!-- Display Footer Component -->
  <footer>
      <Footer/>
  </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';
import emailjs from 'emailjs-com';

export default {
    name: "ContactUs",
    components: { 
      Header,
      Quote, 
      Footer 
    },
    data() {
    return {
      user_name: "",
      user_email: "",
      fav_strain: "",
      user_message: "",
    };
  },
  methods: {
    sendEmail() {
      emailjs
        .sendForm(
          "service_bmvzxb3",
          "template_jrn3z3o",
          this.$refs.values,
          "LtzYKLHpH1MiB7EPW"
        )
        .then(
          (result) => {
            console.log(
              "You have successfully submitted your message",
              result.text
            );
             location.reload(true);
          },
          (error) => {
            console.log(
              "This form failed to submit, please kindly check your internet connection",
              error.text
            );
          }
        );
    },
  },
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#contact-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#contact-main {
    margin: 4vw;
}

h1,
#summary,
form {
    text-align: center;
}

h1 {
    font-size: 1.6rem;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.3rem;

}

p {
    margin: auto 8vw;
}

.form-input{
  margin: 10px;
  padding: 2%;
  padding-left: 3%;
}
.form-group{
  display: flex;
  justify-content: center;
}
.form-group input{
  font-size: 100%;
  font-family: Poppins;
}
.form-group textarea{
  font-size: 100%;
  font-family: Poppins;
} 

#submit-btn {
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
  font-size: 100%;
  height: 50px;
  width: 100px;
  margin: auto;
  padding: 0.6em 2em;
  border: none;
  outline: none;
  color: rgb(255, 255, 255);
  background: #111;
  cursor: pointer;
  position: relative;
  z-index: 0;
  border-radius: 10px;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

#submit-btn:before {
  content: "";
  background: linear-gradient(
    45deg,
    #00ff00,
    #00ff00,
    #00ff00,
    #00ff00,
    #00ff00,
    #00ff00,
    #00ff00,
    #00ff00,
    #00ff00
  );
  position: absolute;
  top: -2px;
  left: -2px;
  background-size: 400%;
  z-index: -1;
  filter: blur(5px);
  -webkit-filter: blur(5px);
  width: calc(100% + 4px);
  height: calc(100% + 4px);
  animation: glowing-button-85 20s linear infinite;
  transition: opacity 0.3s ease-in-out;
  border-radius: 10px;
}

@keyframes glowing-button-85 {
  0% {
    background-position: 0 0;
  }
  50% {
    background-position: 400% 0;
  }
  100% {
    background-position: 0 0;
  }
}

#submit-btn:after {
  z-index: -1;
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background: #222;
  left: 0;
  top: 0;
  border-radius: 10px;
}
.example-col{
  padding-top: 2%;
}
.contact-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color:  #00331A;
  padding: 3%;
  color: black;
  margin: auto;
  margin-top: 2%;
}
input,
textarea {
  height: 5vh;
  width: 100%;
  margin: 20px;
  border-top: none;
  border-right: none;
  border-left: none;
  outline: 2px solid rgb(133, 133, 133);
  
  
}
input:focus {
    background-color: rgb(241, 240, 240);
}
textarea {
  height: 250px;
  border-bottom: 2px solid rgb(133, 133, 133);
}
textarea:focus {
    background-color: rgb(241, 240, 240);
}

</style>