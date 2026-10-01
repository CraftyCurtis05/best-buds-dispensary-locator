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
                Trusted Information for Learning More
            </h2>

            <p>
                This resource center brings together cannabis
                information from government agencies, medical
                organizations, researchers, public health
                programs, and other educational sources.
            </p>

            <p>
                Topics include cannabis basics, health and
                safety, CBD, THC, edibles, medical research,
                cannabis use disorder, laws, and other areas
                that can help you explore the subject in more
                detail.
            </p>

            <p>
                Cannabis research and laws continue to change.
                Best Buds prioritizes sources that explain both
                what is currently known and where evidence is
                still developing.
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

    </div>

</template>

<script>
import ArticlesSearch from "../components/articles/ArticlesSearch.vue";

export default {
    name: "ArticlesView",

    components: {
        ArticlesSearch
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