<!-- Header Component Display--->
<template>

    <!-- Display Header Body -->
    <body>

        <!-- NavBar Component -->
        <section id="navbar">
            <NavBarComponent/>
        </section>

        <!-- Logo and Link to Home Page -->
        <section id="logo">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">
                <img src="src\assets\logo_assets\best_buds_logo_white.png" alt="Logo">
            </router-link>
        </section>

        <!-- Banner Image -->
        <section id="banner">
            <img src="src\assets\header_assets\dispensary_banner_cropped.png" alt="Banner">
        </section>

    </body>

</template>

<script>
import NavBarComponent from "../components/NavBar.vue";

export default {
    name: "Header",
    components: { NavBarComponent }
}
</script>

<style scoped>
body {
    display: flex;
    width: 100vw;
    max-width: 100vw; 
    overflow-x: hidden;
}

#logo {
    position: absolute;
    margin-top: .3vw;
    margin-left: 3.5vw;
}

#logo img {
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
