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

        <!-- Display Strain Guide -->
        <section
            id="strain-guide"
            aria-labelledby="strain-guide-heading"
        >

            <h2 id="strain-guide-heading">
                Explore Our Strain Guide
            </h2>

            <StrainGuideVisit />

        </section>

        <!-- Display Latest Articles -->
        <section
            id="latest-articles"
            aria-labelledby="articles-heading"
        >

            <h2 id="articles-heading">
                Latest Cannabis Articles
            </h2>

            <ArticlesVisit />

        </section>

    </div>

</template>

<script>
import HomeFeatured from "../components/home/HomeFeatured.vue";
import StrainGuideVisit from "../components/strain-guide/StrainGuideVisit.vue";
import ArticlesVisit from "../components/articles/ArticlesVisit.vue";

export default {
    name: "HomeView",

    components: {
        HomeFeatured,
        StrainGuideVisit,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>