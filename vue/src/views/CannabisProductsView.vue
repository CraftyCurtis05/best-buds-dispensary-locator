<!-- Cannabis Products View Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Which Products? | Best Buds</title>

    <!-- Display View Body -->
    <body id="products-body">

        <!-- Display Body's Main Content -->
        <main id="products-main">

            <!-- Display Body Title -->
            <h1>Cannabis Products</h1>

            <!-- Display Body Summary -->
             <section id="summary">
                <h2>How To Choose Which Cannabis Product Is Right For You?</h2>
                <p>Choosing the right cannabis product is like picking your vibe! First choose the strain that is best for you by using our <router-link v-bind:to="{ name:'strainguide' }">strain guide</router-link>. Next consider how you want to consume—smoke, vape, or snack on an edible. Start with a low dose and see how it feels. Explore and find your perfect match!</p>
                <h3>Check out all the different types of cannabis products below!</h3>
            </section>
            
            <!-- Display Body Jump Links -->
            <section id="links">
                <div class="link"><a href="#flower">Flower</a></div>
                <div class="link"><a href="#edible">Edibles</a></div>
                <div class="link"><a href="#wax">Wax</a></div>
                <div class="link"><a href="#oil">Oil</a></div>
                <div class="link"><a href="#tincture">Tinctures</a></div>
                <div class="link"><a href="#topical">Topicals</a></div>
            </section>

            <!-- Display Cannabis Products Information -->
            <section id="products">

                <!-- Display Flower Component -->
                <article id="flower">
                    <Flower/>
                </article>

                <!-- Display Edible Component -->
                <article id="edible">
                    <Edible/>
                </article>

                <!-- Display Wax Component -->
                <article id="wax">
                    <Wax/>
                </article>

                <!-- Display Oil Component -->
                <article id="oil">
                    <Oil/>
                </article>

                <!-- Display Tincture Component -->
                <article id="tincture">
                    <Tincture/>
                </article>

                <!-- Display Topical Component -->
                <article id="topical">
                    <Topical/>
                </article>

            </section>

        </main>

        <!-- Display Strain Guide Visit Component -->
        <section id="strain-guide-visit">
            <StrainGuideVisit/>
        </section>
 
        <!-- Display Articles Visit Component -->
        <section id="articles-visit">
            <ArticlesVisit/>
        </section>

    </body>

</template>

<script>
import Flower from '../components/cannabis_products/Flower.vue';
import Edible from '../components/cannabis_products/Edible.vue';
import Wax from '../components/cannabis_products/Wax.vue';
import Oil from '../components/cannabis_products/Oil.vue';
import Tincture from '../components/cannabis_products/Tincture.vue';
import Topical from '../components/cannabis_products/Topical.vue';
import StrainGuideVisit from '../components/strain_guide/StrainGuideVisit.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
    name: "CannabisProductsView",
    components: { 
        Flower,
        Edible,
        Wax,
        Oil,
        Tincture,
        Topical,
        StrainGuideVisit,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>