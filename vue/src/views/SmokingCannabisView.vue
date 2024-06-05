<template>
    <div class="smoking-cannabis-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>  
        <div class="smoking-tips">
            <h1> Tips for Smoking Cannabis </h1>
            <ul id="smoking-tips-list">
                <li> Use a clean pipe or bong. </li>
                <li>  </li>
            </ul>
        </div>
        <div class="smoker-tips">
            <h1> Tips for Cannabis Smokers </h1>
        </div>
        <div class="common-questions">
            <h1> Common Questions for First-Time Smokers </h1>
        </div>
        <div class="want-more">
            <h1> Do You Want More Information? </h1>
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