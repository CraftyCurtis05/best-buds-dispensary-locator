<!-- Home Page Display --->
<template>

  <!-- Browser Tab Title -->
  <title>Home | Best Buds</title>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="home-body">

    <!-- Display Home Main Content -->
    <main id="home-main">

      <!-- Display Page Title -->
      <h1>Welcome to Best Buds!</h1>

      <!-- Display Home Page Information -->
      <section id="home"> 
        <h2>Find And Connect With Your Dispensary Here</h2>

        <!-- ***TESTING LINK - REMOVE BEFORE WHEN FINISHED*** -->
        <router-link v-bind:to="{ name:'test'}">Jen Dev Testing</router-link> <!-- ********** -->

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
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "Home",
  components: { Header, QuoteComponent, Footer }
};
</script>

<style scoped>
.home-view {
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
h3,
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


