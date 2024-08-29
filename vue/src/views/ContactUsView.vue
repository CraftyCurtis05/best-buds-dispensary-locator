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
        <ContactUsForm/>
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
import ContactUsForm from '@/components/contact_components/ContactUsForm.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "ContactUs",
  components: { 
    Header,
    ContactUsForm,
    Quote, 
    Footer 
  }
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
</style>