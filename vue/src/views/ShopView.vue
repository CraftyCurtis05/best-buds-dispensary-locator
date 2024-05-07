<template>
  <div class="shop-view">
    <div class="header-nav">
        <div class="header"><Header/></div>
        <div class="nav-bar"><NavBar/></div>
    </div>
    <div class="shop">
        <h1>Shop our Favorite Products</h1>
        <h2>You deserve a little treat</h2>
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
    name: "ShopView"
}
</script>

<style scoped>
#search-form{
    margin-top: 20px;
}

.shop-view {
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
    font-style: italic; 
    font-weight: lighter; 
    font-size: 100%;
}


</style>