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
                <p>Choosing the right cannabis product is like picking your vibe! First choose the strain that is best for you by using our <router-link v-bind:to="{ name:'strain-guide' }">strain guide</router-link>. Next consider how you want to consume—smoke, vape, or snack on an edible. Start with a low dose and see how it feels. Explore and find your perfect match!</p>
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
                    <FlowerProducts />
                </article>

                <!-- Display Edible Component -->
                <article id="edible">
                    <EdibleProducts />
                </article>

                <!-- Display Wax Component -->
                <article id="wax">
                    <WaxProducts />
                </article>

                <!-- Display Oil Component -->
                <article id="oil">
                    <OilProducts />
                </article>

                <!-- Display Tincture Component -->
                <article id="tincture">
                    <TinctureProducts />
                </article>

                <!-- Display Topical Component -->
                <article id="topical">
                    <TopicalProducts />
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
import FlowerProducts from '../components/products/FlowerProducts.vue';
import EdibleProducts from '../components/products/EdibleProducts.vue';
import WaxProducts from '../components/products/WaxProducts.vue';
import OilProducts from '../components/products/OilProducts.vue';
import TinctureProducts from '../components/products/TinctureProducts.vue';
import TopicalProducts from '../components/products/TopicalProducts.vue';
import StrainGuideVisit from '../components/strain-guide/StrainGuideVisit.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
    name: "ProductsView",

    components: { 
        FlowerProducts,
        EdibleProducts,
        WaxProducts,
        OilProducts,
        TinctureProducts,
        TopicalProducts,
        StrainGuideVisit,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>