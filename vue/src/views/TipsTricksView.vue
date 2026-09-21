<!-- Tips and Tricks View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Tips & Tricks | Best Buds</title>   

    <!-- Display View Body -->
    <body id="tips-body">

        <!-- Display Body's Main Content -->
        <main id="tips-main">

            <!-- Display Body Title -->
            <h1>Tips & Tricks For Cannabis Use</h1>

            <!-- Display Page Summary -->
             <section id="summary">
                <h2>Cannabis confusion got you burnt out?</h2>
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
                    <TipsTricksGuide />
                </article>

            </section>

        </main>

        <!-- Display Articles Visit Component -->
        <section id="articles-visit">
            <ArticlesVisit/>
        </section>

    </body>

</template>

<script>
import TipsTricksGuide from '../components/tips-tricks/TipsTricksGuide.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
    name: "TipsTricksView",

    components: { 
        TipsTricksGuide,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>