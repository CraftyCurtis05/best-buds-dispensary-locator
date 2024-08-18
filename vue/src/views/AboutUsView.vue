<!-- About Us Page Display --->
<template>

  <!-- Browser Tab Title -->
  <title>About Us | Best Buds</title>

  <header>
    <!-- Display Header Component -->
    <Header/>
  </header>

  <body class="about-us-view">

    <!-- Display About Us Description -->
    <div class="about-us-description">
      <h1>We Are Best Buds</h1>
        <p>At Best Buds, we're dedicated to providing a seamless experience for individuals seeking access to legal cannabis products. Our platform serves as a comprehensive guide, 
          connecting consumers with dispensaries that meet their specific needs and preferences. Whether you're a seasoned cannabis enthusiast or exploring its benefits for the first time, 
          we're here to help you navigate the landscape with ease.</p>
      <h2>Our Mission</h2>
        <p>Our mission is simple: to empower individuals with accurate information and resources to make informed decisions about cannabis consumption. We believe in the transformative power 
          of cannabis and its potential to enhance wellness and improve lives. By offering a user-friendly platform, we strive to foster a supportive community and promote responsible usage.</p>
      <h2>Our Commitment to Privacy and Security</h2>
        <p>At Best Buds, your privacy and security are our top priorities. We adhere to stringent data protection measures to safeguard your personal information and ensure a secure browsing 
          experience.</p>
      <h2>Get In Touch</h2>
        <p>Have questions or feedback? We'd love to hear from you! Feel free to reach out to our friendly team at {{ email }} for assistance or inquiries.</p>
        <p>Thank you for choosing Best Buds as your trusted guide in the world of cannabis. Together, let's explore, discover, and embrace the benefits of this remarkable plant.</p>
    </div>

    <!-- Display Want More Info with Articles Link -->
    <div class="want-more">
      <h5> Want More Information? </h5>
      <div id="articles-link">
        <router-link v-bind:to="{ name:'articles'}"> Visit our articles page for more information! </router-link>
      </div>
    </div> 

    <!-- Display Page Quote -->
    <h6>“A joint a day keeps the bad mood away.” -Unknown</h6> 
  </body>

  <footer>
    <!-- Display Footer Component -->
    <Footer />
  </footer> 

</template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';

export default {
  name: "aboutus",
  components: { Header, Footer },
  data() {
    return {
      email: ''//ourbudsarebest@gmail.com;
    }
  }
}
</script>

<style scoped>
.about-us-view {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

h1, 
h2, 
p, 
.want-more, 
h6 {
  text-align: center;
}

h1 {
  font-size: 1.8em;
  font-weight: bolder;
  margin-top: 4vw;
}

h2 {
  font-size: 1.5em;
  font-weight: light;
}

p {
  font-size: 1.1em;
  margin: auto 10vw;
}

.want-more {
  margin-top: 3vw;
}

#articles-link {
  margin-top: -1vw;
}

h6 {
  font-size: .9em;
  font-style: italic;
  font-weight: lighter;
  margin-bottom: 1vw;
}
</style>