<template>
    <div class="header">
    <Header />
  </div>
  <div class="nav-bar">
    <NavBar />
  </div>
    <div class="container">
        <h1>We Are Best Buds</h1>
          <p>At Best Buds, we're dedicated to providing a seamless experience for individuals seeking access to legal cannabis products. Our platform serves as a comprehensive guide, connecting consumers with dispensaries that meet their specific needs and preferences. Whether you're a seasoned cannabis enthusiast or exploring its benefits for the first time, we're here to help you navigate the landscape with ease.</p>
        <h2>Our Mission</h2>
          <p>Our mission is simple: to empower individuals with accurate information and resources to make informed decisions about cannabis consumption. We believe in the transformative power of cannabis and its potential to enhance wellness and improve lives. By offering a user-friendly platform, we strive to foster a supportive community and promote responsible usage.</p>
        <h2>Our Commitment to Privacy and Security</h2>
          <p>At Best Buds, your privacy and security are our top priorities. We adhere to stringent data protection measures to safeguard your personal information and ensure a secure browsing experience.</p>
        <h2>Get In Touch</h2>
          <p>Have questions or feedback? We'd love to hear from you! Feel free to reach out to our friendly team at [contact email] for assistance or inquiries.</p>
          <p>Thank you for choosing Best Buds as your trusted guide in the world of cannabis. Together, let's explore, discover, and embrace the benefits of this remarkable plant.</p>
    </div>
   <h3>“A joint a day keeps the bad mood away.” -Unknown</h3>
    <div class="footer">
    <Footer />
  </div>
</template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
import NavBar from '../components/NavBar.vue';

export default {
    components: { Header, Footer, NavBar },
    name: "AboutUsView"
}
</script>

<style scoped>
#search-form{
    margin-top: 20px;
}
h1 {
  text-align: center;
  font-size: 200%;
  font-weight: bolder;
}

h2 {
  text-align: center;
  font-size: 150%;
  font-weight: light;
}

h3 {
  text-align: center;
  font-style: italic;
  font-weight: lighter;
  font-size: 100%;
}
p {
  text-align: center;
  font-size: 100%;
  margin-left: 16%;
  margin-right: 16%;
}
</style>