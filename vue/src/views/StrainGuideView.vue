<template>
    <div class="strain-guide-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>  
        <div class="strain-guide">
            <h1> Strain, Type and Terpene Guide </h1>
            <h2>Every cannabis strain has a name, a type and terpenes. While most dispensaries categorize cannabis by the type--indica, sativa or hybrid; terpenes are another great way to find the best cannabis strain for you. Below is a basic guide to strains and the most common terpenes. </h2>
            <div class="strain-and-terpene-list">
            <ul id="strain-list">
                <h2> Strain 101 </h2>
                <li>Indica: |EFFECTS| relaxing, "body" high, pain relief, nauseau reduction |COMMON STRAINS| Granddaddy Purple, Z, Blueberry, Rainbow Runtz, King Louis, Watermelon </li>
                <li>Sativa: |EFFECTS| energizing, "mind" high, anxiety-reducing, stimulating  |COMMON STRAINS| Durban Poison, Tropicana Cookies, Maui Wowie, Acapulco Gold, Tangie</li>
                <li>Hybrid: |EFFECTS| a mix of indica and sativa, effects have a wide range from anxiolytic to anti-inflammatory |COMMON STRAINS| CG4, Wedding Cake, Blue Dream, Lemon Cherry Gelato, Runtz, Gelato </li>
            </ul>
            <ul id="terpene-list">
                <h2> Terpene 101 </h2>
                <li>Humulene: |EFFECTS| anti-inflammatory, appetite suppressant |STRAINS| Gelato, Atlantis, Sour Diesel</li>
                <li>Limonene: |EFFECTS| antidepressant, antifungal, antimicobial, anxiolytic, gastroprotective, immunostimulant |COMMON STRAINS| Wedding Cake, Quantum Kush, Berry White</li>
                <li>Myrcene: |EFFECTS| analgesic, anti-inflammatory, antipsychotic, muscle relaxant, sedative, antispasmodic |COMMON STRAINS| OG Kush, Girl Scout Cookies, Grape Ape </li>
                <li>Caryophyllene: |EFFECTS| anti-inflammatory, analgesic, protects digestive tract lining, antidepressant |COMMON STRAINS| Runtz, Gelato, Gorilla Glue, Wedding Cake </li>
                <li>Linalool: |EFFECTS| analgesic, anticonvulsant, antiepileptic, antineoplastic, antipsychotic, anxiolytic, sedative |COMMON STRAINS| Durban, Mazar, Candy OG, Red Haze </li>
                <li>A-Pinene: |EFFECTS| anti-inflammatory, gastroprotective, energy boosting, bronchodilator, memory aid, antibacterial |COMMON STRAINS| Haze Berry, OG Kush, Blue Dream, Skunkberry </li>
            </ul>
            </div>

            <div id="articles-link">
                <router-link v-bind:to="{ name:'articles'}"> Visit our articles page for more information! </router-link>
            </div>
        </div>    
        <div id="quote">
            <h3> "Struggle is the enemy, but weed is the remedy" -Kid Cudi </h3>
        </div>
        <div class="footer"><Footer/></div>
    </div>  
  </template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
import NavBar from '../components/NavBar.vue';

export default {
    components: { Header, Footer, NavBar },
    name: "SafetyTipsView"
};
</script>

<style scoped>
.strain-guide-view {
  width: 100vw;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
  margin-top: -1vw;
}

.header-nav {
  position: fixed;
}

h1 {
  text-align: center;
  font-size: 130%;
  font-weight: bolder;
  padding-top: 15%;
}

h2 {
  text-align: center;
  font-size: 105%;
  font-weight: lighter;
}

h3 {
  text-align: center;
  font-style: italic;
  font-weight: lighter;
  font-size: 100%;
}
</style>