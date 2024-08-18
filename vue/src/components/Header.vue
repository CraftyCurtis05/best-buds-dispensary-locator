<!-- Header Component Display--->
<template>

    <!-- Display Header information -->
    <body>

        <!-- Display NavBar -->
        <div id="navbar">
            <NavBar/>
        </div>

        <!-- Display Logo to the Left and In Front of Banner Image; Link Logo to Home Page, unless NOT Logged In -->
        <div class="logo">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">
                <img src="src\assets\logo_assets\best_buds_logo_white.png" alt="Logo">
            </router-link>
        </div>

        <!-- Display banner image across header as background, behind logo image-->
        <div id="banner">
            <img src="src\assets\header_assets\dispensary_banner_cropped.png" alt="Banner">
        </div>
    
    </body>
</template>

<script>
import NavBar from "../components/NavBar.vue";
export default {
    components: { NavBar }
}
</script>

<style scoped>
body {
    display: flex;
    width: 100vw;
    max-width: 100vw; 
    overflow-x: hidden;
}

.logo {
    position: absolute;
    margin-top: .3vw;
    margin-left: 3.5vw;
}

.logo img {
    position: absolute;
    height: 11.8vw;
}

#banner img {
    width: 100vw;
    height: 12.5vw;
}

#navbar {
    margin-top: 12.5vw;
}
</style>
