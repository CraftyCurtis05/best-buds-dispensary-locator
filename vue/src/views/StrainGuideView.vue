<!-- Strain Guide Page Display -->
<template>

  <!-- Browser Tab Title -->
  <title>Strain Guide | Best Buds</title>

  <!-- Display Header Component -->
  <header>
    <Header/>
  </header>

  <!-- Display Page Body -->
  <body id="strain-guide-view">

    <!-- Display Strain Guide Main Content -->
    <main id="strain-guide-main">

      <!-- Display Page Title -->
      <h1>Strain Type and Terpene Guide</h1>

      <!-- Display Strain Guide Summary -->
      <p>Every cannabis strain has a name, a type and terpenes. While most dispensaries categorize cannabis by the type--indica, sativa or hybrid; terpenes are another great way to find the best cannabis strain for you. Below is a basic guide to strains and the most common terpenes.</p>

      <!-- Display Strain Guide  -->
      <section id="strain-101">
        <h2>Strain 101</h2>
        <p>***NEED STRAIN SUMMARY***</p>

        <!-- Display Indica Strain Information -->
        <article id="indica">
          <h3>Indica</h3>
          <h4>Effects:</h4>
          <span>Relaxing, "body" high, pain relief, nauseau reduction.</span>
          <h4>Common Strains:</h4>
          <ul id="indica-strains">
            <li>Granddaddy Purple</li>
            <li>Z</li>
            <li>Blueberry</li>
            <li>Rainbow Runtz</li>
            <li>King Louis</li>
            <li>Watermelon</li>
          </ul>
        </article>

        <!-- Display Sativa Strain Information -->
        <article id="sativa">
          <h3>Sativa</h3>
          <h4>Effects:</h4>
          <span>Energizing, "mind" high, anxiety-reducing, stimulating.</span>
          <h4>Common Strains:</h4>
          <ul id="sativa-strains">
            <li>Durban Poison</li>
            <li>Tropicana Cookies</li>
            <li>Maui Wowie</li>
            <li>Acapulco Gold</li>
            <li>Tangie</li>
          </ul>
        </article>

        <!-- Display Hybrid Strain Information -->
        <article id="hybrid">
          <h3>Hybrid</h3>
          <h4>Effects:</h4>
          <span>A mix of indica and sativa, effects have a wide range from anxiolytic to anti-inflammatory.</span>
          <h4>Common Strains</h4>
          <ul id="hybrid-strains">
            <li>CG4</li>
            <li>Wedding Cake</li>
            <li>Blue Dream</li>
            <li>Lemon Cherry Gelato</li>
            <li>Runtz</li>
            <li>Gelato</li>
          </ul>
        </article>    
      </section>

      <!-- Display Terpene Guide  -->
      <section id="terpene-101">
        <h2>Terpene 101</h2>
        <p>***NEED STRAIN SUMMARY***</p>

        <!-- Display Humulene Information -->
        <article id="humulene">
          <h3>Humulene</h3>
          <h4>Effects:</h4>
          <span>Anti-inflammatory, appetite suppressant.</span>
          <h4>Common Strains:</h4>
          <ul id="humulene-strains">
            <li>Gelato</li>
            <li>Atlantis</li>
            <li>Sour Diesel</li>
          </ul>
        </article>

        <!-- Display Limonene Information -->
        <article id="limonene">
          <h3>Limonene</h3>
          <h4>Effects:</h4>
          <span>Antidepressant, antifungal, antimicobial, anxiolytic, gastroprotective, immunostimulant.</span>
          <h4>Common Strains:</h4>
          <ul id="limonene-strains">
            <li>Wedding Cake</li>
            <li>Quantum Kush</li>
            <li>Berry White</li>
          </ul>
        </article>

        <!-- Display Myrcene Information -->
        <article id="myrcene">
          <h3>Myrcene</h3>
          <h4>Effects:</h4>
          <span>Analgesic, anti-inflammatory, antipsychotic, muscle relaxant, sedative, antispasmodic.</span>
          <h4>Common Strains:</h4>
          <ul id="myrcene-strains">
            <li>OG Kush</li>
            <li>Girl Scout Cookies</li>
            <li>Grape Ape</li>
          </ul>
        </article>

        <!-- Display Caryophyllene Information -->
        <article id="caryophyllene">
          <h3>Caryophyllene</h3>
          <h4>Effects:</h4>
          <span>Anti-inflammatory, analgesic, protects digestive tract lining, antidepressant.</span>
          <h4>Common Strains:</h4>
          <ul id="caryophyllene-strains">
            <li>Runtz</li>
            <li>Gelato</li>
            <li>Gorilla Glue</li>
            <li>Wedding Cake</li>
          </ul>
        </article>

        <!-- Display Linalool Information -->
        <article id="linalool">
          <h3>Linalool</h3>
          <h4>Effects:</h4>
          <span>Analgesic, anticonvulsant, antiepileptic, antineoplastic, antipsychotic, anxiolytic, sedative.</span>
          <h4>Common Strains:</h4>
          <ul id="linalool-strains">
            <li>Durban</li>
            <li>Mazar</li>
            <li>Candy OG</li>
            <li>Red Haze</li>
          </ul>
        </article>

        <!-- Display A-Pinene Information -->
        <article id="apinene">
          <h3>A-Pinene</h3>
          <h4>Effects:</h4>
          <span>Anti-inflammatory, gastroprotective, energy boosting, bronchodilator, memory aid, antibacterial.</span>
          <h4>Common Strains:</h4>
          <ul id="apinene-strains">
            <li>Haze Berry</li>
            <li>OG Kush</li>
            <li>Blue Dream</li>
            <li>Skunkberry</li>
          </ul>
        </article>

      </section>

    </main>

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