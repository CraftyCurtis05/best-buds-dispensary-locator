<!-- Flower Products Component Display -->
<template>

    <section
        id="flower"
        aria-labelledby="flower-heading"
    >

        <!-- Display Flower Information -->
        <div class="product-information">

            <h3 id="flower-heading">
                Flower
            </h3>

            <p>
                Cannabis smoking is the inhalation of smoke or
                vapor released by heating the flowers, leaves,
                or extracts of cannabis and releasing the main
                psychoactive chemical, Δ9-tetrahydrocannabinol
                (THC), which is absorbed into the bloodstream
                via the lungs. Cannabis can be smoked in a
                variety of pipe-like implements made in
                different shapes and of different materials
                including hand pipes ("bowls"), water pipes
                ("bongs"), cigarettes ("joints"), or blunts.
            </p>

            <!-- Display Flower Pros -->
            <section
                class="product-pros"
                aria-labelledby="flower-pros-heading"
            >

                <h4 id="flower-pros-heading">
                    Pros
                </h4>

                <ul>
                    <li>
                        Rapid onset rate, which means that
                        consumers will feel effects and benefit
                        from cannabis almost immediately.
                    </li>

                    <li>
                        Easier to manage how much is being
                        consumed.
                    </li>

                    <li>
                        Delivers higher bioavailability rates
                        in comparison to other methods.
                    </li>

                    <li>
                        Effects fade more quickly (about 1-2
                        hours); overdoing it is more difficult
                        and will wear off sooner and less
                        intensely than with edibles.
                    </li>

                    <li>
                        Has a reduced risk of being eaten by
                        pets and children since it does not
                        look like a delicious treat.
                    </li>

                    <li>
                        Quick and convenient means of
                        consumption.
                    </li>
                </ul>

            </section>

            <!-- Display Flower Cons -->
            <section
                class="product-cons"
                aria-labelledby="flower-cons-heading"
            >

                <h4 id="flower-cons-heading">
                    Cons
                </h4>

                <ul>
                    <li>
                        May compromise respiratory function
                        since some of the same chemicals found
                        in cigarettes can be found in cannabis
                        smoke.
                    </li>

                    <li>
                        Has a shorter duration in terms of
                        experiencing effects and benefiting
                        from compounds.
                    </li>

                    <li>
                        Compounds can be lost in side-stream
                        smoke.
                    </li>

                    <li>
                        Similarly to edibles, and other means
                        of consumption, smoking cannabis with
                        a potency that is too high can lead to
                        adverse effects such as anxiety.
                    </li>

                    <li>
                        Emits a noticeable smell.
                    </li>
                </ul>

            </section>

        </div>

        <!-- Display Flower Image -->
        <aside class="product-image">

            <img
                :src="FlowerProductsImage"
                alt="Cannabis flower product"
            />

        </aside>

    </section>

</template>

<script>
import FlowerProductsImage from "../../assets/products/flower-products.webp";

export default {
    name: "FlowerProducts",

    data() {
        return {
            FlowerProductsImage
        };
    }
};
</script>

<style scoped>

</style>