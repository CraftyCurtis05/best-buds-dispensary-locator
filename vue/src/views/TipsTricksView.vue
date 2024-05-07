<template>
    <div class="tips-tricks-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>
        <div class="tips-tricks">
            <h1>Tips & Tricks</h1>
            <h2>Something witty about how we have tips and tricks to help you consume your dispensary goodies!</h2>
            <p>This is where the buttons will go</p>
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
    font-size: 105%; 
    font-weight: lighter; 
}

p {
    text-align: center; 
    font-size: 100%; 
    margin-left: 16%; 
    margin-right: 16%;
}

</style>