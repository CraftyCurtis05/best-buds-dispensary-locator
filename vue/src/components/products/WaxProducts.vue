<!-- Wax Products Component Display -->
<template>

    <section
        id="wax"
        aria-labelledby="wax-heading"
    >

        <!-- Display Wax Information -->
        <div class="product-information">

            <h3 id="wax-heading">
                Wax
            </h3>

            <p>
                THC wax is a highly concentrated form of
                tetrahydrocannabinol (THC), the main
                intoxicating substance found in cannabis. THC
                wax has 40-80 percent more THC per dose than
                more traditional, dried forms of cannabis.
                Different types of weed concentrate can have
                the texture of a: Sticky, gummy liquid; Soft,
                solid lip balm; Hard, dark-yellow solid resin.
            </p>

            <!-- Display Wax Pros -->
            <section
                class="product-pros"
                aria-labelledby="wax-pros-heading"
            >

                <h4 id="wax-pros-heading">
                    Pros
                </h4>

                <ul>
                    <li>
                        The effect is much cleaner and stronger
                        than a joint or vaporizer.
                    </li>

                    <li>
                        Though dabbing is not typically used by
                        medicinal cannabis users, it
                        theoretically could be an effective
                        route for acute symptoms because it is
                        fast acting and effective.
                    </li>

                    <li>
                        Other inhalation methods would not
                        deliver as high a dose of cannabinoids
                        in a single inhalation.
                    </li>

                    <li>
                        The researchers concluded that there
                        were no more problems or accidents from
                        cannabis dabbing compared to smoking
                        cannabis flowers.
                    </li>
                </ul>

            </section>

            <!-- Display Wax Cons -->
            <section
                class="product-cons"
                aria-labelledby="wax-cons-heading"
            >

                <h4 id="wax-cons-heading">
                    Cons
                </h4>

                <ul>
                    <li>
                        Some find dabbing scary because the act
                        is reminiscent of smoking crack — the
                        device is made out of glass and a blow
                        torch is required to heat the nail. As
                        a result, there are people who claim
                        that it does not contribute to a
                        positive image of cannabis.
                    </li>

                    <li>
                        The concentrate itself, however, can be
                        a problem. Making a cannabis concentrate
                        is a painstaking job which involves
                        chemical solvents such as ethanol,
                        alcohol, propane or butane. A pure
                        concentrate devoid of residual solvents
                        is difficult to achieve without the
                        correct knowledge and expertise. This
                        leads to a lot of people to YouTube-style
                        self-tuition, which often ends in a
                        contaminated product. If customers
                        purchase professionally-made cannabis
                        concentrates however, there are far
                        fewer risks of residual solvent.
                    </li>

                    <li>
                        Another danger is overdosing. Although
                        it is still not possible to die from a
                        cannabis overdose, the effects can be
                        very unpleasant if too large a dose is
                        inhaled. Caution is therefore advised.
                    </li>
                </ul>

            </section>

        </div>

        <!-- Display Wax Image -->
        <aside class="product-image">

            <img
                :src="WaxProductsImage"
                alt="Cannabis wax product"
            />

        </aside>

    </section>

</template>

<script>
import WaxProductsImage from "../../assets/products/wax-products.webp";

export default {
    name: "WaxProducts",

    data() {
        return {
            WaxProductsImage
        };
    }
};
</script>

<style scoped>

</style>