<!-- Application Header Component Display -->
<template>

    <header
        v-if="isAuthenticated"
        id="app-header"
    >

        <!-- Display Application Brand -->
        <router-link
            :to="{ name: 'home' }"
            aria-label="Best Buds Home"
        >
            Best Buds
        </router-link>

        <!-- Display Main Application Navigation -->
        <nav aria-label="Main Navigation">
            <NavBar />
        </nav>

    </header>

</template>

<script>
import NavBar from "./NavBar.vue";

export default {
    name: "AppHeader",

    components: {
        NavBar
    },

    computed: {

        // Check whether the user has an active session
        isAuthenticated() {
            return this.$store.state.token !== "";
        }

    }
};
</script>

<style scoped>

</style>