<!-- Cannabis Products View Display -->
<template>

    <div
        id="products-view"
        aria-labelledby="products-heading"
    >

        <!-- Display Page Introduction -->
        <header id="products-header">

            <h1 id="products-heading">
                Cannabis Products
            </h1>

            <h2>
                How To Choose Which Cannabis Product Is Right For You?
            </h2>

            <p>
                Choosing the right cannabis product is like
                picking your vibe! First choose the strain that
                is best for you by using our
                <router-link
                    :to="{ name: 'strain-guide' }"
                >
                    strain guide
                </router-link>.
                Next consider how you want to consume—smoke,
                vape, or snack on an edible. Start with a low
                dose and see how it feels. Explore and find
                your perfect match!
            </p>

            <p>
                Check out all the different types of cannabis
                products below!
            </p>

        </header>

        <!-- Display Product Jump Links -->
        <nav
            id="product-links"
            aria-label="Cannabis product sections"
        >

            <ul>

                <li>
                    <a href="#flower">
                        Flower
                    </a>
                </li>

                <li>
                    <a href="#edible">
                        Edibles
                    </a>
                </li>

                <li>
                    <a href="#wax">
                        Wax
                    </a>
                </li>

                <li>
                    <a href="#oil">
                        Oil
                    </a>
                </li>

                <li>
                    <a href="#tincture">
                        Tinctures
                    </a>
                </li>

                <li>
                    <a href="#topical">
                        Topicals
                    </a>
                </li>

            </ul>

        </nav>

        <!-- Display Cannabis Products -->
        <section
            id="cannabis-products"
            aria-labelledby="cannabis-products-heading"
        >

            <h2 id="cannabis-products-heading">
                Types of Cannabis Products
            </h2>

            <!-- Display Flower Products -->
            <FlowerProducts />

            <!-- Display Edible Products -->
            <EdibleProducts />

            <!-- Display Wax Products -->
            <WaxProducts />

            <!-- Display Oil Products -->
            <OilProducts />

            <!-- Display Tincture Products -->
            <TinctureProducts />

            <!-- Display Topical Products -->
            <TopicalProducts />

        </section>

        <!-- Display Strain Guide -->
        <section
            id="products-strain-guide"
            aria-labelledby="products-strain-guide-heading"
        >

            <h2 id="products-strain-guide-heading">
                Explore Our Strain Guide
            </h2>

            <StrainGuideVisit />

        </section>

        <!-- Display Latest Articles -->
        <section
            id="products-articles"
            aria-labelledby="products-articles-heading"
        >

            <h2 id="products-articles-heading">
                Latest Cannabis Articles
            </h2>

            <ArticlesVisit />

        </section>

    </div>

</template>

<script>
import FlowerProducts from "../components/products/FlowerProducts.vue";

import EdibleProducts from "../components/products/EdibleProducts.vue";

import WaxProducts from "../components/products/WaxProducts.vue";

import OilProducts from "../components/products/OilProducts.vue";

import TinctureProducts from "../components/products/TinctureProducts.vue";

import TopicalProducts from "../components/products/TopicalProducts.vue";

import StrainGuideVisit from "../components/strain-guide/StrainGuideVisit.vue";

import ArticlesVisit from "../components/articles/ArticlesVisit.vue";

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