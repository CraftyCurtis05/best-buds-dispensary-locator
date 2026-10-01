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

        <!-- Display Product Navigation -->
        <OnThisPage
            :topics="productSections"
        />

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

    </div>

</template>

<script>
import OnThisPage from "../components/layout/OnThisPage.vue";
import FlowerProducts from "../components/products/FlowerProducts.vue";
import EdibleProducts from "../components/products/EdibleProducts.vue";
import WaxProducts from "../components/products/WaxProducts.vue";
import OilProducts from "../components/products/OilProducts.vue";
import TinctureProducts from "../components/products/TinctureProducts.vue";
import TopicalProducts from "../components/products/TopicalProducts.vue";

import UserActivityService from "../services/UserActivityService.js";

import {USER_ACTIVITY_TYPES} from "../constants/userActivityTypes.js";

export default {
    name: "ProductsView",

    components: {
        OnThisPage,
        FlowerProducts,
        EdibleProducts,
        WaxProducts,
        OilProducts,
        TinctureProducts,
        TopicalProducts
    },

    emits: [
        "activity-recorded"
    ],

    data() {
        return {

            // Track product sections viewed during this page visit
            productObserver: null,
            viewedProducts: new Set(),

            // Product sections used for navigation and activity tracking
            productSections: [
                {
                    id: "flower",
                    label: "Flower",
                    value: "flower"
                },
                {
                    id: "edible",
                    label: "Edibles",
                    value: "edible"
                },
                {
                    id: "wax",
                    label: "Wax",
                    value: "wax"
                },
                {
                    id: "oil",
                    label: "Oil",
                    value: "oil"
                },
                {
                    id: "tincture",
                    label: "Tinctures",
                    value: "tincture"
                },
                {
                    id: "topical",
                    label: "Topicals",
                    value: "topical"
                }
            ]

        };
    },

    mounted() {
        this.observeProductsSections();
    },

    beforeUnmount() {

        if (this.productObserver) {
            this.productObserver.disconnect();
        }

    },

    methods: {

        // Watch product sections as the user explores the page
        observeProductsSections() {

            this.productObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (!entry.isIntersecting) {
                                    return;
                                }

                                const product =
                                        this.productSections.find(
                                                (item) =>
                                                    item.id
                                                    === entry.target.id
                                        );

                                if (!product) {
                                    return;
                                }

                                this.recordProductsView(
                                    product.value
                                );

                            }
                        );

                    },
                    {
                        threshold: 0.1
                    }
                );

            this.productSections.forEach(
                (product) => {

                    const section =
                        document.getElementById(
                            product.id
                        );

                    if (section) {
                        this.productObserver.observe(
                            section
                        );
                    }

                }
            );

        },

        // Record a product section once during this page visit
        recordProductsView(
            product
        ) {

            if (
                this.viewedProducts.has(
                    product
                )
            ) {
                return;
            }

            this.viewedProducts.add(
                product
            );

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.PRODUCTS_VIEW,
                    product
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {

                    this.viewedProducts.delete(
                        product
                    );

                });

        }

    }
};
</script>

<style scoped>

</style>