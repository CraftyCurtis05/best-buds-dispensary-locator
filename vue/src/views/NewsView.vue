<template>

    <!-- Browser Tab Title -->
    <title>News | Best Buds</title>
  
    <!-- Display Header Component -->
    <header id="top">
      <Header/>
    </header>

    <!-- Display View Body -->
    <body id="news-body">

        <!-- Display Body's Main Content -->
        <main id="news-main">

            <!-- Display Body Title -->
            <h1>Cannabis News</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
             <section id="summary">
                <h2>🌿 Breaking the Stigma: Explore the World of Cannabis 🌿</h2>
                <p>Welcome to Best Buds, your go-to source for the latest news and trends in the ever-evolving world of cannabis. Whether you're interested in the medicinal benefits, the latest legislative changes, or the growing culture around cannabis, we've got you covered. Dive into our carefully curated articles to stay informed and ahead of the curve in this dynamic industry.</p>
                <h3>Stay informed, stay curious, and explore the multifaceted world of cannabis through our curated news articles. Whether you’re a casual reader or a cannabis connoisseur, this page is designed to keep you up-to-date and engaged with the latest developments and insights.</h3>
            </section>

            <!-- Display News Component -->
            <NewsComponent :articles="articles"/>

        </main>

        <!-- Display Quote Component -->
        <div id="quote">
            <Quote/>
        </div>  

    </body>

    <!-- Display Footer Component -->
    <footer id="bottom">
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import ViewJumpLinks from '@/components/ViewJumpLinks.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';
import NewsComponent from '../components/news_components/NewsComponent.vue';
import axios from 'axios';

export default {
  name: "News",
  components: { 
    Header,
    ViewJumpLinks,
    Quote, 
    Footer,
    NewsComponent 
  }
};
</script>

<style scoped>
#news-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#news-main {
    margin: 4vw;
}

h1,
#summary {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}
</style>
