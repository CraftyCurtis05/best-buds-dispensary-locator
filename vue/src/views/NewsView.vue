<!-- News View Display -->
<template>

    <div
        id="news-view"
        aria-labelledby="news-heading"
    >

        <!-- Display Page Introduction -->
        <header id="news-header">

            <h1 id="news-heading">
                Cannabis News
            </h1>

            <h2>
                Breaking the Stigma: Explore the World of Cannabis
            </h2>

            <p>
                Welcome to Best Buds, your go-to source for the
                latest news and trends in the ever-evolving
                world of cannabis. Whether you're interested
                in the medicinal benefits, the latest
                legislative changes, or the growing culture
                around cannabis, we've got you covered. Dive
                into our carefully curated articles to stay
                informed and ahead of the curve in this
                dynamic industry.
            </p>

            <p>
                Stay informed, stay curious, and explore the
                multifaceted world of cannabis through our
                curated news articles. Whether you're a casual
                reader or a cannabis connoisseur, this page is
                designed to keep you up-to-date and engaged
                with the latest developments and insights.
            </p>

        </header>

        <!-- Display Cannabis News -->
        <section
            id="cannabis-news"
            aria-labelledby="cannabis-news-heading"
        >

            <h2 id="cannabis-news-heading">
                Latest Cannabis News
            </h2>

            <NewsFeed />

        </section>

    </div>

</template>

<script>
import NewsFeed from "../components/news/NewsFeed.vue";

export default {
    name: "NewsView",

    components: {
        NewsFeed
    }
};
</script>

<style scoped>

</style>