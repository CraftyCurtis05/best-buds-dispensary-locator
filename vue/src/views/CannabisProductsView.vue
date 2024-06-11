<template>
    <div class="safety-tips-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>  
        <div class="safety-tips-thc">
            <h1>How To Choose Which Cannabis Product Is Right For You</h1>
            <div class="thc-tips-list">
            <ul id="verify-meds-health">
                <h2>Edibles</h2>
                <p>Edibles are food products infused with cannabis extract. Edibles come in many forms, including baked goods, candies, gummies, chocolates, lozenges, and beverages.</p>
                <h3>Pros</h3>
                <li></li>
                <li></li>
                <h3>Cons</h3>
                <li></li>
                <li></li>
            </ul>
            <ul id="labels-start-small">
                <h2>Flower</h2>
                <p>Cannabis smoking is the inhalation of smoke or vapor released by heating the flowers, leaves, or extracts of cannabis and releasing the main psychoactive chemical, Δ9-tetrahydrocannabinol (THC), which is absorbed into the bloodstream via the lungs. Cannabis can be smoked in a variety of pipe-like implements made in different shapes and of different materials including hand pipes ("bowls"), water pipes ("bongs"), cigarettes ("joints"), or blunts.</p>
                <h3>Pros</h3>
                <li></li>
                <li></li>
                <h3>Cons</h3>
                <li></li>
                <li></li>
                
            </ul>
            <ul id="too-much-edibles">
                <h2>Oil</h2>
                <p>Hash oil or cannabis oil is an oleoresin obtained by the extraction of cannabis or hashish. It is a cannabis concentrate containing many of its resins and terpenes - in particular, tetrahydrocannabinol, cannabidiol, and other cannabinoids. Hash oil is usually consumed by smoking, vaporizing or eating.</p>
                <h3>Pros</h3>
                <li></li>
                <li></li>
                <h3>Cons</h3>   
                <li></li>
            </ul>
            <ul id="dont-mix">
                <h2>Tincture</h2>
                <p>A tincture in the most basic sense is a cannabis extract, in which a liquid is infused with cannabis, meant for sublingual consumption, not vaporization or smoking. The cannabis plant soaks in a base liquid, such as food-grade alcohol, glycerin, or even oil, and after days of steeping, the plant matter is strained out and—voilà! The cannabinoids, terpenes, and other compounds have melded with the base liquid, ready to dose and consume. </p>
                <h3>Pros</h3>
                <li></li>
                <h3>Cons</h3>
                <li></li>
            </ul>
            <ul id="skip-drive">
                <h2>Topical</h2>
                <p>THC topicals, and cannabis topicals in general, are cannabis products infused in things like gels, balms, and lotions and then applied to our skin. The idea behind them is that they may be able to treat acute symptoms, including pain or inflammation, by interacting with cannabinoid receptors in the skin. Because the THC doesn't actually make it through the skin into the bloodstream, THC topical enthusiasts don't have to worry about getting intoxicated when they use a cannabis topical.</p>
                <h3>Pros</h3>
                <li></li>
                <li></li>
                <h3>Cons</h3>
                <li></li>
            </ul>
            <ul id="skip-drive">
                <h2>Wax</h2>
                <p>THC wax is a highly concentrated form of tetrahydrocannabinol (THC), the main intoxicating substance found in cannabis. THC wax has 40-80 percent more THC per dose than more traditional, dried forms of cannabis.

                Different types of weed concentrate can have the texture of a:
                    Sticky, gummy liquid.
                    Soft solid lip balm.
                    Hard, dark-yellow solid resin.</p>
                <h3>Pros</h3>
                <li></li>
                <li></li>
                <h3>Cons</h3>
                <li></li>
            </ul>
            </div>
        </div>
        
        <div class="want-more">
            <h1> Want More Information? </h1>
            <div id="articles-link">
                <router-link v-bind:to="{ name:'articles'}"> Visit our articles page for more information! </router-link>
            </div>
        </div>    
        <div id="quote">
            <h3> "NEED NEW QUOTE" -UNKNOWN </h3>
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
.safety-tips-view {
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