<!-- Cannabis Products View Display -->
<template>

    <div
        id="products-view"
        aria-labelledby="products-heading"
    >

        <!-- =================================================
             Products Page Introduction
             ================================================= -->

        <header id="products-header">

            <!-- Header Content -->
            <div class="products-header-content">

                <p class="products-eyebrow">
                    Best Buds Product Guide
                </p>

                <h1 id="products-heading">
                    Cannabis Products

                    <span>
                        Understand the Differences
                    </span>
                </h1>

                <p class="products-introduction">
                    Cannabis comes in many forms, and different
                    products can behave differently depending
                    on how they are made and used.
                </p>

                <p class="products-description">
                    Compare common product types, learn what
                    information to look for on labels, and
                    explore important considerations involving
                    effects, safety, and use.
                </p>


                <!-- Product Types -->
                <div
                    class="product-types"
                    aria-label="Cannabis product types covered"
                >

                    <span>
                        Flower
                    </span>

                    <span>
                        Edibles
                    </span>

                    <span>
                        Concentrates
                    </span>

                    <span>
                        Oils
                    </span>

                    <span>
                        Tinctures
                    </span>

                    <span>
                        Topicals
                    </span>

                </div>

            </div>


            <!-- Decorative Product Graphic -->
            <div
                class="products-header-visual"
                aria-hidden="true"
            >

                <span class="product-ring ring-large"></span>
                <span class="product-ring ring-medium"></span>
                <span class="product-ring ring-small"></span>


                <div class="product-center">

                    <span>
                        6
                    </span>

                    <small>
                        Product Guides
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Product Information Note
             ================================================= -->

        <aside
            id="product-guide-note"
            aria-labelledby="product-guide-note-heading"
        >

            <span
                class="product-guide-note-icon"
                aria-hidden="true"
            >
                i
            </span>


            <div>

                <h2 id="product-guide-note-heading">
                    Product Names Don't Tell the Whole Story
                </h2>

                <p>
                    Products can differ in cannabinoid
                    concentration, ingredients, serving size,
                    intended route of use, and how quickly or
                    strongly they affect someone.
                </p>

                <p>
                    A product name, strain name, package
                    design, or THC percentage does not
                    guarantee a particular experience.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Product Navigation
             ================================================= -->

        <OnThisPage
            :topics="productSections"
            heading="Explore Product Types"
        />


        <!-- =================================================
             Cannabis Products
             ================================================= -->

        <section
            id="cannabis-products"
            aria-labelledby="cannabis-products-heading"
        >

            <!-- Section Introduction -->
            <header class="products-section-header">

                <p class="products-section-label">
                    Product Education
                </p>

                <h2 id="cannabis-products-heading">
                    Types of Cannabis Products
                </h2>

                <p>
                    Explore each product type to understand
                    what it is, why people choose it, what
                    information to look for, and important
                    safety considerations.
                </p>

            </header>


            <!-- Flower Products -->
            <FlowerProducts />


            <!-- Edible Products -->
            <EdibleProducts />


            <!-- Wax and Concentrates -->
            <WaxProducts />


            <!-- Cannabis Oil -->
            <OilProducts />


            <!-- Tinctures -->
            <TinctureProducts />


            <!-- Topicals -->
            <TopicalProducts />

        </section>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import FlowerProducts
    from "../components/products/FlowerProducts.vue";

import EdibleProducts
    from "../components/products/EdibleProducts.vue";

import WaxProducts
    from "../components/products/WaxProducts.vue";

import OilProducts
    from "../components/products/OilProducts.vue";

import TinctureProducts
    from "../components/products/TinctureProducts.vue";

import TopicalProducts
    from "../components/products/TopicalProducts.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";


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

            // Track product sections viewed
            // during this page visit
            productObserver:
                null,

            viewedProducts:
                new Set(),


            // Product sections used for
            // navigation and activity tracking
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
                    label: "Wax & Concentrates",
                    value: "wax"
                },

                {
                    id: "oil",
                    label: "Cannabis Oil",
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

        // Watch product sections as
        // the user explores the page
        observeProductsSections() {

            this.productObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (
                                    !entry.isIntersecting
                                ) {
                                    return;
                                }

                                const product =
                                    this.productSections.find(
                                        (item) => {

                                            return (
                                                item.id
                                                === entry.target.id
                                            );

                                        }
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


        // Record a product section once
        // during this page visit
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
                    USER_ACTIVITY_TYPES
                        .PRODUCTS_VIEW,

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

/* =========================================================
   Products View
   ========================================================= */

#products-view {
    width:
        min(
            calc(100% - 2rem),
            76rem
        );

    margin:
        0
        auto;

    padding:
        2.5rem
        0
        5rem;
}


/* =========================================================
   Products Header
   ========================================================= */

#products-header {
    display: grid;

    grid-template-columns:
        minmax(0, 1.35fr)
        minmax(15rem, 0.65fr);

    align-items: center;

    gap: 3rem;

    padding:
        clamp(
            2rem,
            6vw,
            4rem
        );

    background:
        linear-gradient(
            135deg,
            var(--color-surface),
            var(--color-surface-soft)
        );

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 18px 45px
        var(--color-shadow);
}


/* Header Content */
.products-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.products-eyebrow,
.products-section-label {
    margin:
        0
        0
        0.7rem;

    color:
        var(--color-gold-dark);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.17em;

    text-transform: uppercase;
}


/* Page Heading */
#products-heading {
    margin:
        0
        0
        1.25rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            2.4rem,
            6vw,
            4.5rem
        );

    font-weight: 500;

    line-height: 1;

    letter-spacing: -0.045em;
}


/* Heading Accent */
#products-heading span {
    display: block;

    margin-top: 0.12em;

    color:
        var(--color-primary);
}


/* Introduction */
.products-introduction {
    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text);

    font-size:
        1.03rem;

    line-height: 1.7;
}


/* Description */
.products-description {
    margin:
        0
        0
        1.4rem;

    color:
        var(--color-text-soft);

    font-size: 0.9rem;

    line-height: 1.7;
}


/* =========================================================
   Product Type Pills
   ========================================================= */

.product-types {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Product Type */
.product-types span {
    padding:
        0.36rem
        0.65rem;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.62rem;
    font-weight: 600;

    letter-spacing: 0.07em;

    text-transform: uppercase;
}


/* =========================================================
   Decorative Product Graphic
   ========================================================= */

.products-header-visual {
    position: relative;

    display: grid;
    place-items: center;

    width:
        min(
            100%,
            18rem
        );

    aspect-ratio: 1;

    margin:
        0
        auto;
}


/* Product Rings */
.product-ring {
    position: absolute;

    border:
        1px solid
        var(--color-gold-soft);

    border-radius: 50%;
}


.ring-large {
    width: 100%;
    height: 100%;
}


.ring-medium {
    width: 72%;
    height: 72%;
}


.ring-small {
    width: 44%;
    height: 44%;

    border-color:
        var(--color-gold);
}


/* Product Center */
.product-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    width: 7.5rem;
    height: 7.5rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-background);

    box-shadow:
        0 16px 36px
        var(--color-shadow-strong);
}


/* Product Number */
.product-center span {
    font-size: 1.5rem;
    font-weight: 500;
}


/* Product Center Label */
.product-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.55rem;
    font-weight: 600;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


/* =========================================================
   Product Guide Note
   ========================================================= */

#product-guide-note {
    display: flex;
    align-items: flex-start;

    gap: 0.85rem;

    margin-top: 1rem;

    padding:
        1rem
        1.2rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);
}


/* Note Icon */
.product-guide-note-icon {
    display: grid;
    place-items: center;

    width: 1.9rem;
    height: 1.9rem;

    flex-shrink: 0;

    background:
        var(--color-gold-soft);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.75rem;
    font-weight: 700;
}


/* Note Heading */
#product-guide-note h2 {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text);

    font-size: 0.86rem;
    font-weight: 600;
}


/* Note Text */
#product-guide-note p {
    margin:
        0
        0
        0.3rem;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.6;
}


/* Last Note Paragraph */
#product-guide-note p:last-child {
    margin-bottom: 0;
}


/* =========================================================
   Cannabis Products Section
   ========================================================= */

#cannabis-products {
    padding-top:
        clamp(
            2rem,
            5vw,
            3.5rem
        );
}


/* Section Header */
.products-section-header {
    max-width: 46rem;

    margin-bottom: 1rem;
}


/* Section Heading */
.products-section-header h2 {
    margin:
        0
        0
        0.65rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.8rem,
            4vw,
            2.7rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.03em;
}


/* Section Description */
.products-section-header > p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 849.98px) {

    #products-header {
        grid-template-columns: 1fr;
    }


    .products-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #products-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #products-header {
        padding:
            2rem
            1.4rem;
    }


    .products-header-visual {
        display: none;
    }


    #product-guide-note {
        padding: 1rem;
    }

}

</style>