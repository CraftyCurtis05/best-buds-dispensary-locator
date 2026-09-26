<!-- Tips and Tricks View Display -->
<template>

    <div
        id="tips-tricks-view"
        aria-labelledby="tips-tricks-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="tips-tricks-header"
            aria-labelledby="tips-tricks-heading"
        >

            <h1 id="tips-tricks-heading">
                Tips & Tricks For Cannabis Use
            </h1>

            <h2>
                Cannabis confusion got you burnt out?
            </h2>

            <p>
                You're not alone! With so many strains,
                products, and effects, it can feel like a
                wild, green maze. But don't stress—it's all
                part of the fun! Think of it as a
                choose-your-own-adventure. Whether you're
                giggling over strain names or puzzled by
                potency, embrace the journey. The key is to
                explore, experiment, and enjoy the ride!
            </p>

            <p>
                Check out some of the Tips and Tricks we've
                compiled below!
            </p>

        </header>

        <!-- Display Tips and Tricks Jump Links -->
        <nav
            id="tips-tricks-links"
            aria-label="Cannabis tips and tricks topics"
        >

            <ul>

                <li>
                    <a href="#choose-products">
                        Choose a Product
                    </a>
                </li>

                <li>
                    <a href="#strain-guide">
                        Strain Guide
                    </a>
                </li>

                <li>
                    <a href="#safety-tips">
                        Safety Tips
                    </a>
                </li>

                <li>
                    <a href="#too-much">
                        If You Have Too Much
                    </a>
                </li>

                <li>
                    <a href="#legality">
                        State Laws
                    </a>
                </li>

                <li>
                    <a href="#questions">
                        Common Questions
                    </a>
                </li>

            </ul>

        </nav>

        <!-- Display Tips and Tricks Guide -->
        <section
            id="tips-tricks"
            aria-labelledby="tips-tricks-guide-heading"
        >

            <h2 id="tips-tricks-guide-heading">
                Cannabis Tips & Tricks
            </h2>

            <TipsTricksGuide />

        </section>

        <!-- Display Latest Articles -->
        <section
            id="tips-tricks-articles"
            aria-labelledby="tips-tricks-articles-heading"
        >

            <h2 id="tips-tricks-articles-heading">
                Latest Cannabis Articles
            </h2>

            <ArticlesVisit />

        </section>

    </div>

</template>

<script>
import TipsTricksGuide from "../components/tips-tricks/TipsTricksGuide.vue";
import ArticlesVisit from "../components/articles/ArticlesVisit.vue";

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