<!-- Contact Us View Display --->
<template>

  <!-- Browser Tab Title -->
  <title>Contact Us | Best Buds</title>

  <!-- Display View Body -->
  <body id="contact-body">

    <!-- Display Body's Main Content -->
    <main id="contact-main">

      <!-- Display Body Title -->
      <h1>Contact Us</h1>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>Got Questions or Feedback? Let Us Hear from You!</h2>
        <p>Whether you're looking for more information on dispensaries, want to share your favorite strain, or have a general question, we're here to help. Reach out to us, and we'll get back to you as soon as we can!</p>
        <h3>Fill out the form below, and let's start the conversation!</h3>
      </section>

      <!-- Display Contact Us Information -->
      <section id="contact-us">
        <ContactUsForm/>
      </section>

    </main>      

  </body>

</template>

<script>
import ContactUsForm from '../components/contact_us/ContactUsForm.vue';

export default {
  name: "ContactUsView",
  components: { 
    ContactUsForm
  }
};    
</script>

<style scoped>

</style>