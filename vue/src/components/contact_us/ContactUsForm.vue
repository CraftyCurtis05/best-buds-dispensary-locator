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

</style>