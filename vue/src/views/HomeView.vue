<!-- Home View Display -->
<template>

    <div
        id="home-view"
        aria-labelledby="hero-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="hero"
            aria-labelledby="hero-heading"
        >

            <h1 id="hero-heading">
                Welcome to Best Buds!
            </h1>

            <p>
                Need to find the nearest spot to grab some legal goodies?
            </p>

            <p>
                Our dispensary locator is like a GPS for your chill...
            </p>

        </header>

        <!-- Display Featured Dispensary -->
        <section
            id="featured-dispensary"
            aria-labelledby="featured-heading"
        >

            <h2 id="featured-heading">
                Featured Dispensary
            </h2>

            <HomeFeatured />

        </section>

    </div>

</template>

<script>
import HomeFeatured from "../components/home/HomeFeatured.vue";

export default {
    name: "HomeView",

    components: {
        HomeFeatured
    }
};
</script>

<style scoped>

</style>