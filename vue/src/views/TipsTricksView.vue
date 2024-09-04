<!-- Tips and Tricks View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Tips & Tricks | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>    

    <!-- Display View Body -->
    <body id="tips-body">

        <!-- Display Body's Main Content -->
        <main id="tips-main">

            <!-- Display Body Title -->
            <h1>Tips & Tricks For Cannabis Use</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Page Summary -->
             <section id="summary">
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
            <section id="tips">

                <!-- Display Tips and Tricks Component -->
                <article id="tips-tricks">
                    <TipsAndTricks/>
                </article>

            </section>

        </main>

        <!-- Display Articles Visit Component -->
        <section id="articles-visit">
            <ArticlesVisit/>
        </section>

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
import TipsAndTricks from '@/components/tips_tricks_components/TipsTricks.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "TipsTricksView",
    components: { 
        Header,
        ViewJumpLinks,
        TipsAndTricks,
        ArticlesVisit, 
        Quote, 
        Footer 
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#tips-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#tips-main {
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