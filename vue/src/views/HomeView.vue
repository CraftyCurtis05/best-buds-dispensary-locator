<!-- Home Page Display --->
<template>

  <!-- Browser Tab Title -->
  <head>
    <title>Home | Best Buds</title>
  </head>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="home-body">

    <!-- Display Main Content -->
    <main id="home-main">

      <!-- Display Page Title -->
      <h1>Welcome to Best Buds!</h1>

      <!-- Display Home Page Information -->
      <section id="home"> 
        <h2>Find And Connect With Your Dispensary Here</h2>

        <router-link v-bind:to="{ name:'test'}">Jen Dev Testing</router-link>  <!-- <<<<<<<<<<<< FOR TESTING >>>>>>>>>>>>>>> -->

        <!-- <article id="home-featured">
          <HomeFeaturedComponent/>         <<<<<<<<<<<< ACTIVELY WORKING ON >>>>>>>>>>>>>>
        </article> -->

      </section>

    </main>  

    <!-- Display Quote Component -->
    <div id="quote">
      <QuoteComponent/>
    </div>  

  </body>

  <!-- Display Footer Component -->
  <footer>
    <Footer/>
  </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
//import HomeFeaturedComponent from '@/components/home_components/HomeFeatured.vue';  <<<<<<<<<<<< ACTIVELY WORKING ON >>>>>>>>>>>>>>
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "Home",
  components: { 
    Header, 
    QuoteComponent, 
    Footer 
  }, // HomeFeaturedComponent, <<<<<<<<<<<< ACTIVELY WORKING ON >>>>>>>>>>>>>>
  methods: {
    
  }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#home-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#home-main {
  margin: 4vw;
}

h1, 
h2 {
  text-align: center;
}

h1 {
  font-size: 1.6rem;
}

h2 {
  font-size: 1.3rem;
  font-weight: lighter;
}
</style>


