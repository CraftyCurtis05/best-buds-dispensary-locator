<!-- Legality View Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Legality | Best Buds</title>

    <!-- Display View Body -->
    <body id="legality-body">

        <!-- Display Body's Main Content -->
        <main id="legality-main">

            <!-- Display Body Title -->
            <h1>Cannabis Legality In Each State</h1>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>Ever wondered if your cannabis stash is legal or if you’re just a really optimistic rebel?</h2>
                <p>States like California and Colorado are rolling out the green carpet for adults 21+, with legal shops and chill vibes. Many states have medical programs where patients get the green light with a doctor's thumbs-up. Some states have turned down the legal heat, making minor offenses more about a fine than a felony. States are dancing to their own beat, while federal rules are like the old-school DJ trying to keep things under control. In short, it’s a legal jamboree with states setting their own rules while federal law lingers in the background!</p>
                <h3>Click Interactive Map To View The Cannabis Laws In Each State!</h3>
            </section>

            <!-- Display Legality Inoformation -->
             <section id="legality">

                <!-- Display Interactive Legality Map Component -->
                <article id="map">
                    <LegalityMap />
                </article>

            </section>    

        </main>

        <!-- Display Strain Guide Visit Component -->
        <section id="strain-guide-visit">
            <StrainGuideVisit />
        </section>
 
        <!-- Display Articles Visit Component -->
        <section id="articles-visit">
            <ArticlesVisit />
        </section>

    </body>

</template>

<script>
import LegalityMap from '../components/legality/LegalityMap.vue';
import StrainGuideVisit from '../components/strain-guide/StrainGuideVisit.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
    name: "LegalityView",

    components: { 
        LegalityMap,
        StrainGuideVisit,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>