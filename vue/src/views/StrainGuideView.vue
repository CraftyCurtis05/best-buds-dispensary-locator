<!-- Strain Guide Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Strain Guide | Best Buds</title>

  <header>
    <!-- Display Header Component -->
    <Header/>
  </header>

  <body class="strain-guide-view">

    <!-- Display Strain Guide Information -->
    <div class="strain-guide-info">
      <h1> Strain, Type and Terpene Guide </h1>
      <p>Every cannabis strain has a name, a type and terpenes. While most dispensaries categorize cannabis by the type--indica, sativa or hybrid; 
        terpenes are another great way to find the best cannabis strain for you. Below is a basic guide to strains and the most common terpenes. </p>

      <!-- Display Strain Guide List -->
      <h2> Strain 101 </h2>
      <ul class="list">
        <h3>Indica</h3> 
          <h4>Effects:</h4> Relaxing, "body" high, pain relief, nauseau reduction.
          <h4>Common Strains</h4> Granddaddy Purple, Z, Blueberry, Rainbow Runtz, King Louis, Watermelon
        <h3>Sativa</h3> 
          <h4>Effects:</h4> Energizing, "mind" high, anxiety-reducing, stimulating.
          <h4>Common Strains</h4> Durban Poison, Tropicana Cookies, Maui Wowie, Acapulco Gold, Tangie
        <h3>Hybrid</h3> 
          <h4>Effects:</h4> A mix of indica and sativa, effects have a wide range from anxiolytic to anti-inflammatory.
          <h4>Common Strains</h4> CG4, Wedding Cake, Blue Dream, Lemon Cherry Gelato, Runtz, Gelato
      </ul>

      <!-- Display Terpene Guide List -->
      <h2> Terpene 101 </h2>
      <ul class="list">
        <h3>Humulene</h3> 
          <h4>Effects:</h4> Anti-inflammatory, appetite suppressant.
          <h4>Common Strains:</h4> Gelato, Atlantis, Sour Diesel
        <h3>Limonene</h3> 
          <h4>Effects:</h4> Antidepressant, antifungal, antimicobial, anxiolytic, gastroprotective, immunostimulant.
          <h4>Common Strains:</h4> Wedding Cake, Quantum Kush, Berry White
        <h3>Myrcene</h3> 
          <h4>Effects:</h4> Analgesic, anti-inflammatory, antipsychotic, muscle relaxant, sedative, antispasmodic.
          <h4>Common Strains:</h4> OG Kush, Girl Scout Cookies, Grape Ape
        <h3>Caryophyllene</h3> 
          <h4>Effects:</h4> Anti-inflammatory, analgesic, protects digestive tract lining, antidepressant.
          <h4>Common Strains:</h4> Runtz, Gelato, Gorilla Glue, Wedding Cake
        <h3>Linalool</h3> 
          <h4>Effects:</h4> Analgesic, anticonvulsant, antiepileptic, antineoplastic, antipsychotic, anxiolytic, sedative.
          <h4>Common Strains:</h4> Durban, Mazar, Candy OG, Red Haze
        <h3>A-Pinene</h3> 
          <h4>Effects:</h4> Anti-inflammatory, gastroprotective, energy boosting, bronchodilator, memory aid, antibacterial.
          <h4>Common Strains:</h4> Haze Berry, OG Kush, Blue Dream, Skunkberry
      </ul>
    </div>

    <!-- Display Want More Info with Articles Link -->
    <div class="want-more">
      <h5> Want More Information? </h5>
      <div id="articles-link">
        <router-link v-bind:to="{ name:'articles'}"> Visit our articles page for more information! </router-link>
      </div>
    </div> 

    <!-- Display Page Quote -->
    <h6>***NEED QUOTE***</h6> 
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
  name: "strainguide",
  components: { Header, Footer }
};
</script>

<style scoped>
.strain-guide-view {
  width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed
}

.strain-guide-info {
    margin-left: 5vw;
    margin-right: 5vw;
}

h1,
p,
h2,
.want-more,
h6 {
  text-align: center;
}

h1 {
  font-size: 1.5em;
  font-weight: bolder;
  margin-top: 4vw;
  padding-bottom: 1vw;
}

p {
  font-size: 1.1em;
}

h2 {
  font-size: 1.3em;
  font-weight: bolder;
  text-decoration: underline;
  padding-top: 2vw;
  margin-bottom: -.5vw;
}

h3 {
  font-size: 1.2em;
  font-weight: bold;
  margin-bottom: -1vw;
}

h4 {
  font-size: 1.1em;
  font-style: italic;
  font-weight: bold;
  margin-bottom: 0vw;
}

li {
  font-size: 1em;
  margin-bottom: 1.2vw;
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