<!-- Search View Display -->
<template>

    <main id="search-main">

        <!-- Display View Header -->
        <header id="search-header">

            <h1>Dispensary Locator</h1>

            <section
                id="summary"
                aria-labelledby="search-summary-title"
            >
                <h2 id="search-summary-title">
                    Need to find a dispensary?
                </h2>

                <p>
                    Lost in the sea of "where can I get my hands
                    on some top-shelf green"? Fear not! Our
                    dispensary locator is here to rescue you from
                    your herbless woes. Just enter your location
                    and let Best Buds help you find dispensaries
                    nearby.
                </p>

                <p>
                    Use the search below to find dispensaries
                    near you!
                </p>
            </section>

        </header>

        <!-- Display Dispensary Search -->
        <section
            id="search"
            aria-label="Dispensary search"
        >

            <SearchBar />

            <SearchList
                v-if="hasSearchLocation"
            />

            <SearchMap />

        </section>

        <!-- Display Additional Resources -->
        <StrainGuideVisit />

        <ArticlesVisit />

    </main>

</template>

<script>
import SearchBar from "../components/search/SearchBar.vue";
import SearchList from "../components/search/SearchList.vue";
import SearchMap from "../components/search/SearchMap.vue";
import StrainGuideVisit from "../components/strain-guide/StrainGuideVisit.vue";
import ArticlesVisit from "../components/articles/ArticlesVisit.vue";

export default {
    name: "SearchView",

    components: {
        SearchBar,
        SearchList,
        SearchMap,
        StrainGuideVisit,
        ArticlesVisit
    },

    computed: {

        // Check if the user has entered a search location
        hasSearchLocation() {
            return Boolean(
                this.$store.state.locationID
            );
        }

    }
};
</script>

<style scoped>

</style>