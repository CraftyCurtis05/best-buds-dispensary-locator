<!-- Strain Guide View Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Strain Guide | Best Buds</title>

  <!-- Display View Body -->
  <body id="guide-body">

    <!-- Display Body's Main Content -->
    <main id="guide-main">

      <!-- Display Body Title -->
      <h1>Strain and Terpene Guide</h1>

      <!-- Display Body Summary -->
      <section id="summary">
        <h2>Ever wondered if your ideal strain is out there, just waiting to make your day?</h2>
        <p>Finding the perfect strain or terpene is like dating—sometimes you need a few awkward encounters before you find "the one." Our guide helps you swipe right on the ideal match for your mood, whether you’re seeking blissful relaxation or an energy boost to conquer your Netflix marathon. It’s all about finding your cannabis soulmate!</p>
        <h3>Find the right one for you by using our complete guide below!</h3>
      </section>
      
      <!-- Display Body Jump Links -->
      <section id="links">
        <div class="link"><a href="#strain-101">Strain 101</a></div>
        <div class="link"><a href="#terpene-101">terpene 101</a></div>
      </section>

      <!-- Display Guide Information -->
       <section id="guide">

        <!-- Display Strain Jump Links -->
        <section id="links">
          <div class="strain-link"><a href="#indica">Indica</a></div>
          <div class="strain-link"><a href="#sativa">Sativa</a></div>
          <div class="strain-link"><a href="#hybrid">Hybrid</a></div>
        </section>

        <!-- Display Strain Guide Component -->
        <article id="strain-101">
          <StrainGuide />
        </article>

        <!-- Display terpene Jump Links -->
        <section id="links">
        <div class="terpene-link"><a href="#humulene">Humulene</a></div>
        <div class="terpene-link"><a href="#limonene">Limonene</a></div>
        <div class="terpene-link"><a href="#myrcene">Myrcene</a></div>
        <div class="terpene-link"><a href="#caryophyllene">Caryophyllene</a></div>
        <div class="terpene-link"><a href="#linalool">Linalool</a></div>
        <div class="terpene-link"><a href="#apinene">Alpha-Pinene</a></div>
        <div class="terpene-link"><a href="#bpinene">Beta-Pinene</a></div>
        <div class="terpene-link"><a href="#terpinolene">Terpinolene</a></div>
        <div class="terpene-link"><a href="#ocimene">Ocimene</a></div>
        <div class="terpene-link"><a href="#eucalyptol">Eucalyptol</a></div>
        <div class="terpene-link"><a href="#nerolidol">Nerolidol</a></div>
        <div class="terpene-link"><a href="#borneol">Borneol</a></div>
        <div class="terpene-link"><a href="#camphene">Camphene</a></div>
      </section>

        <!-- Display Terpene Guide Component -->
        <article id="terpene-101">
          <TerpeneGuide />
        </article>

      </section>

    </main>

    <!-- Display Articles Visit Component -->
    <section id="articles-visit">
      <ArticlesVisit />
    </section>

  </body>

</template>

<script>
import StrainGuide from '../components/strain-guide/StrainGuide.vue';
import TerpeneGuide from '../components/strain-guide/TerpeneGuide.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
  name: "StrainGuideView",

  components: { 
    StrainGuide,
    TerpeneGuide,
    ArticlesVisit
  }
};
</script>

<style scoped>

</style>