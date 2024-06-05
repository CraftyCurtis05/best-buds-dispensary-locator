<template>
    <div class="safety-tips-view">
      <div class="header-nav">
        <div class="header"><Header/></div>
        <div class="nav-bar"><NavBar/></div>
      </div>  
      <div class="safety-tips">
        <h1> Tips for Safer Cannabis Consumption </h1>
        <div class="tips-list">
        <ul id="verify-meds-health">
            <h2> Verify Your Medication and Health Conditions </h2>
            <li> Consider asking your doctor for advice before sampling THC-infused products. </li>
            <li> If you live in a state where marijuana isn't legal, or you are not comfortable talking to your doctor about it, please call 1-844-LEAF411, a free cannabis hotline staffed by registered nurses. </li>
            <li> Some medical conditions or medications do not mix well with THC or CBD. (Ex: Pregnancy, anxiety meds, blood thinners, etc.) </li>
            <li> It is NEVER okay to use any cannabis products when pregnant or nursing. </li>
        </ul>
        <ul id="labels-start-small">
            <h2> Read Dosing Labels and Start with Small Amounts </h2>
            <li> Everyone responds differently to THC, so rule of thumb is to start with a low dosage and slow usage. </li>
            <li> Recommended start level is just 2.5mg to 5mg at first. </li>
            <li>  </li>
            <li>  </li>
        </ul>
        </div>
        <div id="quote">
          <h3> "NEED NEW QUOTE" -UNKNOWN </h3>
        </div>
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