<!-- Header Component Display--->
<template>

    <!-- Display Component Body -->
    <body id="header-body">

        <!-- Display NavBar Component -->
        <nav id="navbar" aria-label="Main Navigation">
            <NavBar/>
        </nav>

        <!-- Display Logo and Link to Home Page -->
        <section id="logo">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">
                <img :src="Logo" alt="logo">
            </router-link>
        </section>

        <!-- Display Banner Image -->
        <section id="banner">
            <img :src="Banner" alt="banner">
        </section>

    </body>

</template>

<script>
import Logo from '../../assets/layout/logo/logo-dark-theme.png';
import Banner from '../../assets/layout/header/banner-cropped.png';
import NavBar from "../../components/layout/NavBar.vue";

export default {
    name: "AppHeader",

    components: { NavBar },

    data() {
        return {
            Logo,
            Banner
        }
    }
}
</script>

<style scoped>

</style>
