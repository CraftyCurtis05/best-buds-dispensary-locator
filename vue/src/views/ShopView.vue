<!-- Shop Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Shop | Best Buds</title>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="shop-body">

    <!-- Display Shop Main Content -->
    <main id="shop-main">

      <!-- Display Page Title -->
      <h1>Shop our Favorite Products</h1>

      <!-- Display Shop Information -->
      <section id="shop">
        <h2>We're still packing this bowl full of the best deals we can find, stay tuned!</h2>
          <p>***NEED SHOP SUMMARY***</p>
      </section>

    </main>

    <!-- Display Strain Guide Link -->
    <section id="strain-guide">
      <h4>Looking for more information on types and strains?</h4>
      <summary id="strain-guide-link">
        Please check out our <router-link v-bind:to="{ name:'strainguide' }">Strain Guide</router-link> for information.
      </summary>
    </section>

    <!-- Display Want More Info with Articles Link -->
    <section id="articles-visit">
      <h5>Looking for more information?</h5>
      <summary id="articles-link">
        <router-link v-bind:to="{ name:'articles' }">Visit our articles page</router-link>
      </summary>
    </section>

    <!-- Display Page Quote -->
    <h6>***NEED QUOTE***</h6>

  </body>

  <!-- Display Footer Component -->
  <footer>
    <Footer/>
  </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "Shop",
  components: { Header, Footer }
};
</script>

<style scoped>
.shop-view {
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