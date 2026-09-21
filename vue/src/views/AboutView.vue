<!-- About Us View Display --->
<template>

  <!-- Browser Tab Title -->
  <title>About Us | Best Buds</title>

  <!-- Display View Body -->
  <body id="about-body">

    <!-- Display Body's Main Content -->
    <main id="about-main">

      <!-- Display Body Title -->
      <h1>We Are Best Buds</h1>

      <!-- Display About Us Information -->
      <section id="about-us">
        <h2>At Best Buds, we're dedicated to providing a seamless experience for individuals seeking access to legal cannabis products. Our platform serves as a comprehensive guide, connecting consumers with dispensaries that meet their specific needs and preferences. Whether you're a seasoned cannabis enthusiast or exploring its benefits for the first time, we're here to help you navigate the landscape with ease.</h2>

        <h3>Our Mission</h3>
        <p>Our mission is simple: to empower individuals with accurate information and resources to make informed decisions about cannabis consumption. We believe in the transformative power of cannabis and its potential to enhance wellness and improve lives. By offering a user-friendly platform, we strive to foster a supportive community and promote responsible usage.</p>

        <h3>Our Commitment to Privacy and Security</h3>
        <p>At Best Buds, your privacy and security are our top priorities. We adhere to stringent data protection measures to safeguard your personal information and ensure a secure browsing experience.</p>
        
        <h3>Get In Touch</h3>
        <p>Have questions or feedback? We'd love to hear from you! Feel free to reach out to our friendly team from our <router-link v-bind:to="{ name:'contactus' }">contact page</router-link> for assistance or inquiries.</p>
        
        <h4>Thank you for choosing Best Buds as your trusted guide in the world of cannabis. Together, let's explore, discover, and embrace the benefits of this remarkable plant.</h4>
      </section>

    </main>

    <!-- Display Strain Guide Visit Component -->
    <section id="strain-guide-visit">
      <StrainGuideVisit/>
    </section>
 
    <!-- Display Articles Visit Component -->
    <section id="articles-visit">
      <ArticlesVisit/>
    </section>

  </body>

</template>

<script>
import StrainGuideVisit from '../components/strain-guide/Visit.vue';
import ArticlesVisit from '../components/articles/Visit.vue';

export default {
  name: "AboutView",

  components: { 
    StrainGuideVisit, 
    ArticlesVisit
  }
};
</script>

<style scoped>

</style>