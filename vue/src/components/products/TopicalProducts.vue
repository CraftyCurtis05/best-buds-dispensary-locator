<!-- Topical Products Component Display -->
<template>

    <section
        id="topical"
        aria-labelledby="topical-heading"
    >

        <!-- Display Topical Information -->
        <div class="product-information">

            <h3 id="topical-heading">
                Topical
            </h3>

            <p>
                THC topicals, and cannabis topicals in general,
                are cannabis products infused in things like
                gels, balms, and lotions and then applied to
                our skin. The idea behind them is that they may
                be able to treat acute symptoms, including pain
                or inflammation, by interacting with
                cannabinoid receptors in the skin. Because the
                THC doesn't actually make it through the skin
                into the bloodstream, THC topical enthusiasts
                don't have to worry about getting intoxicated
                when they use a cannabis topical.
            </p>

            <!-- Display Topical Pros -->
            <section
                class="product-pros"
                aria-labelledby="topical-pros-heading"
            >

                <h4 id="topical-pros-heading">
                    Pros
                </h4>

                <ul>
                    <li>
                        Cannabis topicals enter the bloodstream
                        through cannabinoid receptors in the
                        skin and offer fast-acting, localized
                        relief. They’re a fantastic way to
                        enjoy the therapeutic qualities of
                        cannabis without the psychoactive
                        effects.
                    </li>

                    <li>
                        While studies are ongoing, cannabis
                        topicals appear to offer several
                        potential benefits. They may be a
                        promising alternative to traditional
                        pain and inflammation treatments, help
                        soothe skin conditions, and intensify
                        sexual response when used in products
                        such as lubricants.
                    </li>

                    <li>
                        Because they offer little to no
                        psychoactive impact, there really
                        aren’t any side effects associated with
                        the use of cannabis topicals.
                    </li>
                </ul>

            </section>

            <!-- Display Topical Cons -->
            <section
                class="product-cons"
                aria-labelledby="topical-cons-heading"
            >

                <h4 id="topical-cons-heading">
                    Cons
                </h4>

                <ul>
                    <li>
                        These products would have to be more
                        seriously studied to know for sure, but
                        based on our own experience and the
                        anecdotal evidence we’ve heard, there
                        are no apparent downsides to THC
                        topicals.
                    </li>

                    <li>
                        The only exception is for those who have
                        seriously sensitive skin or an allergy
                        to some other ingredient the topical
                        contains.
                    </li>

                    <li>
                        If you’re afraid of experiencing a
                        reaction, make sure to do a “patch test”
                        before use.
                    </li>

                    <li>
                        Apply a little of the product to a few
                        inches of skin and monitor for a
                        reaction before you slather on a whole
                        bottle.
                    </li>
                </ul>

            </section>

        </div>

        <!-- Display Topical Image -->
        <aside class="product-image">

            <img
                :src="TopicalProductsImage"
                alt="Cannabis topical product"
            />

        </aside>

    </section>

</template>

<script>
import TopicalProductsImage from "../../assets/products/topical-products.webp";

export default {
    name: "TopicalProducts",

    data() {
        return {
            TopicalProductsImage
        };
    }
};
</script>

<style scoped>

</style>