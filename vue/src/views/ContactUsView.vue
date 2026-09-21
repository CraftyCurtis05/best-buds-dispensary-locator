<template>

  <main id="contact-main">

    <!-- Page Header -->
    <header>
      <h1>Contact Us</h1>

      <p>
        Whether you're looking for more information on dispensaries,
        want to share your favorite strain, or have a general question,
        we're here to help.
      </p>
    </header>

    <!-- Contact Form -->
    <section
      id="contact-us"
      aria-labelledby="contact-form-heading"
    >
      <h2 id="contact-form-heading">
        Send Us a Message
      </h2>

      <p>
        Fill out the form below, and we'll get back to you as soon as we can.
      </p>

      <ContactUsForm />
    </section>

  </main>

</template>

<script>
import ContactUsForm from "../components/contact/Form.vue";

export default {
  name: "ContactUsView",

  components: {
    ContactUsForm
  }
};
</script>
