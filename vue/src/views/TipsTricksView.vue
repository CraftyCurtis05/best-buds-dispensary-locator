<template>
    <title>Tips & Tricks | Best Buds</title>
    <div class="tips-tricks-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>
        <div class="tips-tricks">
            <h1>Tips & Tricks</h1>
            <h2>Cannabis confusion got you burnt out?</h2>
            <h2>Check out some of the Tips and Tricks we've compiled below!</h2>
            <div class="tips-list">
                <ul>
                    <li>
                        <router-link v-bind:to="{ name:'cannabisproducts'}">How To Choose Which Cannabis Product Is Right For You</router-link>
                    </li>
                    <li>
                        <router-link v-bind:to="{ name:'strainguide'}">Comprehensive Strain Guide To Cannabis Products</router-link>
                    </li>
                    <li>
                        <router-link v-bind:to="{ name:'smokingcannabis'}">Safety Tips for Smoking Cannabis</router-link>
                    </li>
                    <li>
                        <router-link v-bind:to="{ name:'safetytips'}">Saftey Tips for Cannabis Consumption</router-link>
                    </li>
                    <li>
                        <router-link v-bind:to="{ name:'topicals'}">Saftey Tips for Cannabis Topicals</router-link> 
                    </li>
                    <li>
                        <router-link v-bind:to="{ name:'toomuchcannabis'}">What To Do If You Have Too Much Cannabis</router-link> 
                    </li>
                    <li>
                        <router-link v-bind:to="{ name:'legality'}">Curious About The Legal Use Within Your Area</router-link> 
                    </li>

                </ul>     
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
    name: "tipstricks"
}
</script>

<style scoped>
/* #search-form{
    margin-top: 20px;
} */

.tips-tricks-view {
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
    font-size: 100%; 
    font-weight: lighter; 
}

.links {
    display: grid;
    width: 100%; 
    height: auto;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 1fr 1fr;
    gap: 20px;
    /* grid-template-columns: 20% 20%;
    grid-template-rows: 20% 20%; */
    /* grid-template-areas: 
        "a a"
        "a a"; */
    align-items: center;
    justify-items: center;
}

a:link {
  text-decoration: none;
}

a:visited {
  text-decoration: none;
}



</style>