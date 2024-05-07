<template>
    <div class="tips-tricks-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>
        <div class="tips-tricks">
            <h1>Tips & Tricks</h1>
            <h2>Cannabis confusion got you burnt out?</h2>
            <h2>Check out some of the Tips and Tricks we've compiled below!</h2>
            <div class="links">
                <a href="https://www.colorado.com/articles/8-tips-safer-cannabis-consumption">8 Tips for Safer Cannabis Consumption</a>
           
                <a href="https://silverstemcannabis.com/news-articles/how-to-smoke-cannabis-the-right-way-tips-and-tricks">How to Smoke Cannabis The Right Way</a>
               
                <a href="https://cbd-alchemy.com/en/blog/a-comprehensive-guide-to-cannabis-strains/">A Comprehensive Guide to Cannabis Strains</a>
            
                <a href="https://420central.com/how-do-i-know-which-cannabis-products-are-right-for-me/">Choosing the Right Product for You</a>      
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
    name: "tips-tricks"
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