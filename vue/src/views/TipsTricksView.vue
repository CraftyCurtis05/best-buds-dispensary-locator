<!-- Tips and Tricks View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Tips & Tricks | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>    

    <!-- Display View Body -->
    <body id="tips-tricks-body">

        <!-- Display Main Content -->
        <main id="tips-tricks-main">

            <!-- Display Page Title -->
            <h1>Tips & Tricks For Cannabis Use</h1>

            <!-- Display Page Jump Links -->
            <aside id="page-jump-links">
                <PageJumpLinks/>
            </aside>

            <!-- Display Page Summary -->
             <section id="page-summary">
                <h2>🌿Cannabis confusion got you burnt out?🌿</h2>
                <p>You're not alone! With so many strains, products, and effects, it can feel like a wild, green maze. But don't stress—it's all part of the fun! Think of it as a choose-your-own-adventure. Whether you're giggling over strain names or puzzled by potency, embrace the journey. The key is to explore, experiment, and enjoy the ride!</p>
                <h3>Check out some of the Tips and Tricks we've compiled below!</h3>
            </section>

            <!-- Display Jump Links -->
            <section id="links">
                <div class="link"><a href="#choose-products">Choose a Product</a></div>
                <div class="link"><a href="#strain-guide">Strain Guide</a></div>
                <div class="link"><a href="#safety-tips">Safety Tips</a></div>
                <div class="link"><a href="#too-much">If You Have Too Much</a></div>
                <div class="link"><a href="#legality">State Laws</a></div>
                <div class="link"><a href="#questions">Common Questions</a></div>
            </section>    

            <!-- Display Tips and Tricks Information -->
            <section id="tips-tricks">
                <TipsTricksComponent/>
            </section>

        </main>

        <!-- Display Want More Info with Articles Link -->
        <section id="articles-visit">
            <ArticlesVisit/>
        </section>

        <!-- Display Quote Component -->
        <div id="quote">
            <QuoteComponent/>
        </div>  

    </body>

    <!-- Display Footer Component -->
    <footer id="bottom">
        <Footer/>
    </footer>

</template>

<script>
import Header from '@/components/Header.vue';
import PageJumpLinks from '@/components/PageJumpLinks.vue';
import TipsTricksComponent from '@/components/tips_tricks_components/TipsTricks.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "TipsTricks",
    components: { 
        Header,
        PageJumpLinks,
        TipsTricksComponent,
        ArticlesVisit, 
        QuoteComponent, 
        Footer 
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#tips-tricks-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#tips-tricks-main {
    margin: 4vw;
}

h1,
h2,
p,
h3 {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

#page-summary {
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

#links {
    display: flex;
    flex-direction: row;
    justify-content: center;
}

.link {
    font-size: 1.2rem;
    font-weight: bolder;
    margin-inline: 1vw;
}

.link:hover {
    text-decoration: underline;
}
</style>