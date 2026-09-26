<!-- Edible Products Component Display -->
<template>

    <section
        id="edible"
        aria-labelledby="edible-heading"
    >

        <!-- Display Edible Information -->
        <div class="product-information">

            <h3 id="edible-heading">
                Edibles
            </h3>

            <p>
                Edibles are food products infused with cannabis
                extract. Edibles come in many forms, including
                baked goods, candies, gummies, chocolates,
                lozenges, and beverages.
            </p>

            <!-- Display Edible Pros -->
            <section
                class="product-pros"
                aria-labelledby="edible-pros-heading"
            >

                <h4 id="edible-pros-heading">
                    Pros
                </h4>

                <ul>
                    <li>
                        Better for patients with respiratory and
                        cardiovascular conditions, or for
                        individuals who want to avoid smoking.
                    </li>

                    <li>
                        Come in an infinite array of options, so
                        consumers can take edibles that appeal
                        to their taste buds.
                    </li>

                    <li>
                        Can be bought or homemade.
                    </li>

                    <li>
                        Last longer than other methods, which
                        can offer prolonged relief from symptoms
                        of medical conditions such as chronic
                        pain.
                    </li>

                    <li>
                        A more discreet means of consumption.
                    </li>

                    <li>
                        According to a 2016 study, edibles have
                        been anecdotally reported to assist with
                        symptoms of conditions like muscle
                        spasms, pain, nausea and vomiting,
                        cancer, appetite stimulation, and
                        epilepsy, as well as several psychiatric
                        disorders such as depression and PTSD.
                    </li>
                </ul>

            </section>

            <!-- Display Edible Cons -->
            <section
                class="product-cons"
                aria-labelledby="edible-cons-heading"
            >

                <h4 id="edible-cons-heading">
                    Cons
                </h4>

                <ul>
                    <li>
                        Effects and benefits take longer to
                        kick in.
                    </li>

                    <li>
                        Easy to consume too much, whether by
                        miscalculating dosages or not waiting
                        long enough before taking more.
                    </li>

                    <li>
                        Though rare, there is a risk of inducing
                        psychosis when consuming too much.
                    </li>

                    <li>
                        Potential side effects associated with
                        overconsumption, such as confusion,
                        anxiety, panic, paranoia, hallucinations,
                        delusions, increased blood pressure,
                        faster heart rate, and nausea.
                    </li>

                    <li>
                        According to the same 2016 study,
                        overconsumption of edibles has been
                        linked to: cognitive and motor
                        impairment, extreme sedation,
                        agitation, anxiety, cardiac stress,
                        and vomiting.
                    </li>
                </ul>

            </section>

        </div>

        <!-- Display Edible Image -->
        <aside class="product-image">

            <img
                :src="EdibleProductsImage"
                alt="Cannabis edible products"
            />

        </aside>

    </section>

</template>

<script>
import EdibleProductsImage from "../../assets/products/edible-products.webp";

export default {
    name: "EdibleProducts",

    data() {
        return {
            EdibleProductsImage
        };
    }
};
</script>

<style scoped>

</style>