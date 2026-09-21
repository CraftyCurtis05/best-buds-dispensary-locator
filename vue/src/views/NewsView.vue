<template>

    <!-- Browser Tab Title -->
    <title>News | Best Buds</title>

    <!-- Display View Body -->
    <body id="news-body">

        <!-- Display Body's Main Content -->
        <main id="news-main">

            <!-- Display Body Title -->
            <h1>Cannabis News</h1>

            <!-- Display Body Summary -->
             <section id="summary">
                <h2>Breaking the Stigma: Explore the World of Cannabis</h2>
                <p>Welcome to Best Buds, your go-to source for the latest news and trends in the ever-evolving world of cannabis. Whether you're interested in the medicinal benefits, the latest legislative changes, or the growing culture around cannabis, we've got you covered. Dive into our carefully curated articles to stay informed and ahead of the curve in this dynamic industry.</p>
                <h3>Stay informed, stay curious, and explore the multifaceted world of cannabis through our curated news articles. Whether you’re a casual reader or a cannabis connoisseur, this page is designed to keep you up-to-date and engaged with the latest developments and insights.</h3>
            </section>

            <!-- Display News Component -->
            <NewsFeed />

        </main>

    </body>

</template>

<script>
import NewsFeed from '../components/news/NewsFeed.vue';

export default {
  name: "NewsView",

  components: { 
    NewsFeed
  }
};
</script>

<style scoped>

</style>
