<!-- Search View Display -->
<template>

    <div
        id="search-view"
        aria-labelledby="search-heading"
    >

        <!-- Display Page Introduction -->
        <header id="search-header">

            <h1 id="search-heading">
                Dispensary Locator
            </h1>

            <h2>
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

        </header>

        <!-- Display Dispensary Search -->
        <section
            id="dispensary-search"
            aria-labelledby="dispensary-search-heading"
        >

            <h2 id="dispensary-search-heading">
                Find Dispensaries
            </h2>

            <SearchBar
                @search="searchDispensaries"
            />

            <!-- Display Travel & Legal Reminder -->
            <aside
                id="search-legal-reminder"
                aria-labelledby="search-legal-reminder-heading"
            >

                <h3 id="search-legal-reminder-heading">
                    Before You Travel
                </h3>

                <p>
                    Cannabis laws can change when you cross a
                    state line. A product that is legal in one
                    state may not be legal in another, and
                    transporting cannabis across state lines can
                    violate federal law.
                </p>

                <p>
                    State legalization also doesn't mean cannabis
                    is permitted on federal property or everywhere
                    within that state.
                </p>

                <p>
                    Always check the laws where you are,
                    where you're going, and anywhere you'll
                    travel through before taking cannabis with you.
                </p>

            </aside>

            <SearchList
                v-if="hasSearchLocation"
                ref="searchList"
            />

            <SearchMap
                @activity-recorded="activityRecorded"
            />

        </section>

        <!-- Display Strain Guide -->
        <section
            id="search-strain-guide"
            aria-labelledby="search-strain-guide-heading"
        >

            <h2 id="search-strain-guide-heading">
                Explore Our Strain Guide
            </h2>

            <StrainGuideVisit />

        </section>

        <!-- Display Latest Articles -->
        <section
            id="search-articles"
            aria-labelledby="search-articles-heading"
        >

            <h2 id="search-articles-heading">
                Latest Cannabis Articles
            </h2>

            <ArticlesVisit />

        </section>

    </div>

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

    emits: [
        "activity-recorded"
    ],

    computed: {

        // Check if the user has entered a search location
        hasSearchLocation() {

            return Boolean(
                this.$store.state.locationID
            );

        }

    },

    methods: {

        // Start a dispensary search
        searchDispensaries(location) {

            this.$nextTick(() => {

                this.$refs.searchList?.search(
                    location
                );

            });

        },

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