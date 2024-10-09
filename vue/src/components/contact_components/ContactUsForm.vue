<template>

  <body>

    <!-- Display Contact Us Information -->
    <section id="contact-us">

      <!-- Display Contact Us Form -->
      <article id="contact-us-form">

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

          <Button type="submit">Submit</Button>

        </form>

      </article>

    </section>

  </body>

</template>

<script>
import emailjs from 'emailjs-com';

export default {
    name: "ContactUsForm",

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
                    console.log("You have successfully submitted your message", result.text);
                    location.reload(true);
                },
                (error) => {
                    console.log("This form failed to submit, please kindly check your internet connection", error.text);
                }
            );
        }
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
form {
    text-align: center;
}

#contact-us-form {
  display: flex;
  flex-direction: column;
  width: 450px;
  background-color: #00331A;
  color: black;
  padding: 2rem;
  margin: auto;
}

.form-group{
  display: flex;
}

.form-group textarea,
.form-group input {
  font-size: 1.2rem;
  font-family: Poppins;
} 

.form-group input{
  margin: 1vw;
  padding: .5rem;
  padding-left: 2rem;
}

input,
textarea {
  height: 5v;
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

button {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  font-size: 1.1rem;
  font-weight: bold;
  height: 3.2rem;
  width: 6.5rem;
  margin: auto;
  border: none;
  color: white;
  z-index: 0;
  border-radius: .6rem;
}

button:before,
button:after {
  position: absolute;
  width: 6.5rem;
  height: 3.2rem;
  border-radius: .7rem;
  z-index: -1;
  content: "";
}

button:before {
  -webkit-filter: blur(5px);
  filter: blur(5px);
  width: 7.5rem;
  height: 4rem;
  background: linear-gradient(
    45deg,
    #377306,
    #377306,
    #377306,
    #377306,
    #377306,
    #377306,
    #377306,
    #377306,
    #377306
  );
}

button:after {
  background: rgb(44, 44, 44);
}

button:hover {
  cursor: url('best_buds_logo_icon.ico'), pointer;
  color: #c6ff4a;
}
</style>

<!-- button {
  border: 1px solid;
  overflow: hidden;
  position: relative;
  
  span {
    z-index: 20;
  }
  
  &:after {
    background: #fff;
    content: "";
    height: 155px;
    left: -75px;
    opacity: .2;
    position: absolute;
    top: -50px;
    transform: rotate(35deg);
    transition: all 550ms cubic-bezier(0.19, 1, 0.22, 1);
    width: 50px;
    z-index: -10;
  }
}

button:hover {
  
  &:after {
    left: 120%;
    transition: all 550ms cubic-bezier(0.19, 1, 0.22, 1);
  }
} -->