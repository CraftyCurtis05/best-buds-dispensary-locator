<!-- Strain Guide View Display -->
<template>

    <div
        id="strain-guide-view"
        aria-labelledby="strain-guide-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="strain-guide-header"
            aria-labelledby="strain-guide-heading"
        >

            <h1 id="strain-guide-heading">
                Strain and Terpene Guide
            </h1>

            <h2>
                Ever wondered if your ideal strain is out
                there, just waiting to make your day?
            </h2>

            <p>
                Finding the perfect strain or terpene is like
                dating—sometimes you need a few awkward
                encounters before you find "the one." Our
                guide helps you swipe right on the ideal match
                for your mood, whether you’re seeking blissful
                relaxation or an energy boost to conquer your
                Netflix marathon. It’s all about finding your
                cannabis soulmate!
            </p>

            <p>
                Find the right one for you by using our
                complete guide below!
            </p>

        </header>

        <!-- Display Guide Jump Links -->
        <nav
            id="guide-links"
            aria-label="Strain and terpene guide topics"
        >

            <ul>

                <li>
                    <a href="#strain-101">
                        Strain 101
                    </a>
                </li>

                <li>
                    <a href="#terpene-101">
                        Terpene 101
                    </a>
                </li>

            </ul>

        </nav>

        <!-- Display Strain Guide -->
        <section
            id="strain-guide"
            aria-labelledby="strain-guide-section-heading"
        >

            <h2 id="strain-guide-section-heading">
                Strain Guide
            </h2>

            <!-- Display Strain Jump Links -->
            <nav
                id="strain-links"
                aria-label="Cannabis strain types"
            >

                <ul>

                    <li>
                        <a href="#indica">
                            Indica
                        </a>
                    </li>

                    <li>
                        <a href="#sativa">
                            Sativa
                        </a>
                    </li>

                    <li>
                        <a href="#hybrid">
                            Hybrid
                        </a>
                    </li>

                </ul>

            </nav>

            <StrainGuide />

        </section>

        <!-- Display Terpene Guide -->
        <section
            id="terpene-guide"
            aria-labelledby="terpene-guide-section-heading"
        >

            <h2 id="terpene-guide-section-heading">
                Terpene Guide
            </h2>

            <!-- Display Terpene Jump Links -->
            <nav
                id="terpene-links"
                aria-label="Cannabis terpenes"
            >

                <ul>

                    <li>
                        <a href="#humulene">
                            Humulene
                        </a>
                    </li>

                    <li>
                        <a href="#limonene">
                            Limonene
                        </a>
                    </li>

                    <li>
                        <a href="#myrcene">
                            Myrcene
                        </a>
                    </li>

                    <li>
                        <a href="#caryophyllene">
                            Caryophyllene
                        </a>
                    </li>

                    <li>
                        <a href="#linalool">
                            Linalool
                        </a>
                    </li>

                    <li>
                        <a href="#apinene">
                            Alpha-Pinene
                        </a>
                    </li>

                    <li>
                        <a href="#bpinene">
                            Beta-Pinene
                        </a>
                    </li>

                    <li>
                        <a href="#terpinolene">
                            Terpinolene
                        </a>
                    </li>

                    <li>
                        <a href="#ocimene">
                            Ocimene
                        </a>
                    </li>

                    <li>
                        <a href="#eucalyptol">
                            Eucalyptol
                        </a>
                    </li>

                    <li>
                        <a href="#nerolidol">
                            Nerolidol
                        </a>
                    </li>

                    <li>
                        <a href="#borneol">
                            Borneol
                        </a>
                    </li>

                    <li>
                        <a href="#camphene">
                            Camphene
                        </a>
                    </li>

                </ul>

            </nav>

            <TerpeneGuide />

        </section>

        <!-- Display Latest Articles -->
        <section
            id="strain-guide-articles"
            aria-labelledby="strain-guide-articles-heading"
        >

            <h2 id="strain-guide-articles-heading">
                Latest Cannabis Articles
            </h2>

            <ArticlesVisit />

        </section>

    </div>

</template>

<script>
import StrainGuide from "../components/strain-guide/StrainGuide.vue";
import TerpeneGuide from "../components/strain-guide/TerpeneGuide.vue";
import ArticlesVisit from "../components/articles/ArticlesVisit.vue";

export default {
    name: "StrainGuideView",

    components: {
        StrainGuide,
        TerpeneGuide,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>