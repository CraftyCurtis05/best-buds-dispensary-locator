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
      <p>Shopping for cannabis products? It’s a fun adventure! Browse through a variety of strains, from energizing sativas to relaxing indicas. Check out edibles, vapes, and concentrates to match your style. Look for quality and lab-tested products to ensure a great experience. Enjoy discovering your perfect pick!</p>

      <!-- Display Shop Information -->
      <section id="shop">
        <h2>We're still packing this bowl full of the best deals we can find, stay tuned!</h2>
          <img src="@/assets/shop_assets/shopping_cart.jpg"/>
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
  name: "Shop",
  components: { Header, QuoteComponent, Footer }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#shop-body {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

#shop-main {
  margin: 4vw;
}

h1,
h2,
p,
#strain-guide,
#articles-visit {
  text-align: center;
}

img {
  width: 40rem;
  margin: auto 25vw;
}

h1 {
  font-size: 1.6rem;
}

h2 {
  font-size: 1.3rem;
  padding-top: 2rem;
}

p {
    margin: auto 8vw;
}

h4,
h5 {
    font-size: 1rem;
    margin: .1vw;
}

#strain-guide,
#articles-visit {
    padding: 1vw;
}
</style>