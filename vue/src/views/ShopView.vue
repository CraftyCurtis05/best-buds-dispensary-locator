<!-- Shop View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Shop | Best Buds</title>

  <!-- Display Header Component -->
  <header id="top">
    <Header/>
  </header>

  <!-- Display View Body -->
  <body id="shop-body">

    <!-- Display Body's Main Content -->
    <main id="shop-main">

      <!-- Display Body Title -->
      <h1>Shop our Favorite Products</h1>

      <!-- Display View Jump Links Component -->
      <aside id="view-links">
        <ViewJumpLinks/>
      </aside>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>🌿Shopping for cannabis products?🌿</h2>
        <p>It’s a fun adventure! Browse through a variety of strains, from energizing sativas to relaxing indicas. Check out edibles, vapes, and concentrates to match your style. Look for quality and lab-tested products to ensure a great experience. Enjoy discovering your perfect pick!</p>
        <h3>We're still packing this bowl full of the best deals we can find, stay tuned!</h3>
      </section>

      <!-- Display Shop Information -->
      <section id="shop">

        <!-- Display Products Component -->
        <article id="products">
          <img src="@/assets/shop_assets/shopping_cart.jpg"/>
        </article>

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

    <!-- Display Quote Component -->
    <div id="quote">
      <Quote/>
    </div>  

    </body>

  <!-- Display Footer Component -->
  <footer id="bottom">
    <Footer/>
  </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import ViewJumpLinks from '@/components/ViewJumpLinks.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: "ShopView",
  components: { 
    Header,
    ViewJumpLinks,
    StrainGuideVisit, 
    ArticlesVisit, 
    Quote, 
    Footer 
  }
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
#summary {
    text-align: center;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}

img {
  width: 40rem;
  margin: auto 25vw;
}
</style>