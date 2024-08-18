<!-- Tips and Tricks Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Tips & Tricks | Best Buds</title>

    <header>
        <!-- Display Header Component -->
        <Header/>
    </header>    

    <body class="tips-tricks-view">

        <!-- Display Tips and Tricks Description and Link List -->
        <div class="tips-tricks-description">
            <h1>Tips & Tricks</h1>
            <h2>Cannabis confusion got you burnt out?</h2>
            <h2>Check out some of the Tips and Tricks we've compiled below!</h2>
            <div class="link-list">
                <h3><router-link v-bind:to="{ name:'cannabisproducts'}">How To Choose Which Cannabis Product Is Right For You</router-link></h3>
                <h3><router-link v-bind:to="{ name:'strainguide'}">Comprehensive Strain Guide To Cannabis Products</router-link></h3>
                <h3><router-link v-bind:to="{ name:'safetytips'}">Tips for Safer Consumption, Smoking and Topicals</router-link></h3>
                <h3><router-link v-bind:to="{ name:'toomuchcannabis'}">What To Do If You Have Too Much Cannabis</router-link></h3>
                <h3><router-link v-bind:to="{ name:'legality'}">Curious About The Legal Use Within Your Area</router-link></h3>
                <h3><router-link v-bind:to="{ name:'commonquestions'}">Commonly Asked Questions</router-link></h3>
            </div>
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
    name: "tipstricks",
    components: { Header, Footer }
}
</script>

<style scoped>
.tips-tricks-view {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

.tips-tricks-description {
    margin-left: 5vw;
    margin-right: 5vw
}

h1, 
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

h2 {
    font-size: 1.2em;
    font-weight: bolder;
}

h3 {
    font-size: 1.1em;
    font-weight: bold;
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