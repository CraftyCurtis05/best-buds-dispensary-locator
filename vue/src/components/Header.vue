<!-- Header Component Display--->
<template>

    <!-- Display Component Body -->
    <body id="header-body">

        <!-- Display NavBar Component -->
        <section id="navbar">
            <NavBar/>
        </section>

        <!-- Display Logo and Link to Home Page -->
        <section id="logo">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">
                <img src="@\assets\logo_assets\cropped\best_buds_logo_white cropped.png" alt="logo">
            </router-link>
        </section>

        <!-- Display Banner Image -->
        <section id="banner">
            <img src="@\assets\header_assets\dispensary_banner_cropped.png" alt="banner">
        </section>

    </body>

</template>

<script>
import NavBar from "../components/NavBar.vue";

export default {
    name: "Header",
    components: { NavBar }
}
</script>

<style scoped>
/* PLEASE DO NOT TOUCH STYLING */
body {
    display: flex;
    width: 100vw;
    max-width: 100%; 
    overflow-x: hidden;
}

#logo {
    position: absolute;
    margin-top: .5vw;
    margin-left: 6.5vw;
}

#logo img {
    position: absolute;
    height: 11vw;
    cursor: url('best_buds_logo_icon.ico'), pointer;
}

#banner img {
    width: 100vw;
    height: 12vw;
}

#navbar {
    margin-top: 12vw;
}
</style>
