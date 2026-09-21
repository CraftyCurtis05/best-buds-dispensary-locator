<!-- Shop View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Shop | Best Buds</title>

  <!-- Display View Body -->
  <body id="shop-body">

    <!-- Display Body's Main Content -->
    <main id="shop-main">

      <!-- Display Body Title -->
      <h1>Shop our Favorite Products</h1>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>Shopping for cannabis products?</h2>
        <p>It’s a fun adventure! Browse through a variety of strains, from energizing sativas to relaxing indicas. Check out edibles, vapes, and concentrates to match your style. Look for quality and lab-tested products to ensure a great experience. Enjoy discovering your perfect pick!</p>
        <h3>We're still packing this bowl full of the best deals we can find, stay tuned!</h3>
      </section>

      <!-- Display Shop Information -->
      <section id="shop">

        <!-- Display Products Component -->
        <article id="products">
          <img :src="ShoppingCart"/>
        </article>

      </section>

    </main>

    <!-- Display Strain Guide Visit Component -->
    <section id="strain-guide-visit">
      <StrainGuideVisit />
    </section>

    <!-- Display Articles Visit Component -->
    <section id="articles-visit">
      <ArticlesVisit />
    </section>

    </body>

</template>

<script>
import ShoppingCart from '../assets/shop/shopping-cart.webp';
import StrainGuideVisit from '../components/strain-guide/StrainGuideVisit.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
  name: "ShopView",

  data() {
    return {
      ShoppingCart
    }
  },

  components: { 
    StrainGuideVisit,
    ArticlesVisit
  }
};
</script>

<style scoped>

</style>