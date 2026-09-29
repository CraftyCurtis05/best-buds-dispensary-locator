<!-- Articles View Display -->
<template>

    <div
        id="articles-view"
        aria-labelledby="articles-heading"
    >

        <!-- Display Page Introduction -->
        <header id="articles-header">

            <h1 id="articles-heading">
                The Cannabis Resource Center
            </h1>

            <h2>
                Explore the World of Cannabis
            </h2>

            <p>
                Our articles cover everything from strain
                breakdowns to the latest trends, so you can
                navigate the world of cannabis with confidence.
                Whether you're a beginner or a seasoned
                enthusiast, we've got something for everyone!
            </p>

            <p>
                Looking for more info? Dive into our library
                of cannabis articles below!
            </p>

        </header>

        <!-- Display Cannabis Articles -->
        <section
            id="cannabis-articles"
            aria-labelledby="cannabis-articles-heading"
        >

            <h2 id="cannabis-articles-heading">
                Cannabis Articles
            </h2>

            <ArticlesSearch
                @activity-recorded="activityRecorded"
            />

        </section>

        <!-- Display Strain Guide -->
        <section
            id="articles-strain-guide"
            aria-labelledby="articles-strain-guide-heading"
        >

            <h2 id="articles-strain-guide-heading">
                Explore Our Strain Guide
            </h2>

            <StrainGuideVisit />

        </section>

    </div>

</template>

<script>
import ArticlesSearch from "../components/articles/ArticlesSearch.vue";
import StrainGuideVisit from "../components/strain-guide/StrainGuideVisit.vue";

export default {
    name: "ArticlesView",

    components: {
        ArticlesSearch,
        StrainGuideVisit
    },

    emits: [
        "activity-recorded"
    ],

    methods: {

        // Pass the recorded activity to the application
        activityRecorded() {

            this.$emit(
                "activity-recorded"
            );

        }

    }
};
</script>

<style scoped>

</style>