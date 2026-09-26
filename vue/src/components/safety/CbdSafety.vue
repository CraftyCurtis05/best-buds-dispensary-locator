<!-- CBD Consumption Component Display -->
<template>

    <section
        id="cbd-consumption"
        aria-labelledby="cbd-safety-heading"
    >

        <!-- Display CBD Consumption Introduction -->
        <h3 id="cbd-safety-heading">
            Safety Tips for Cannabidiol (CBD) Consumption
        </h3>

        <p>
            Take it slow with CBD edibles—start small and see
            how you feel! Read labels, choose quality, and
            check with your doc if you’re on meds. Be patient,
            store them right, and enjoy the chill without
            overdoing it. Keep an eye out for any side
            effects, and make sure it's all legal. Relax,
            snack responsibly, and let the calm vibes roll!
            Check out more safety tips below:
        </p>

        <!-- Display CBD Consumption Safety Tips -->
        <ol class="safety-list">

            <li>

                <h4>
                    Start with a Low Dose
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Initial Dose:</strong>
                        Begin with a small amount (typically
                        5-10 mg) to gauge your tolerance.
                    </li>

                    <li>
                        <strong>Gradual Increase:</strong>
                        If needed, slowly increase the dose
                        while monitoring how you feel.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Consult Your Doctor
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Medical Advice:</strong>
                        Discuss CBD use with a healthcare
                        professional, especially if you have
                        medical conditions or are on other
                        medications.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Choose Quality Products
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Third-Party Testing:</strong>
                        Select products that are tested for
                        purity and potency by independent labs.
                    </li>

                    <li>
                        <strong>Check Ingredients:</strong>
                        Ensure the product is free of
                        contaminants and additives.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Read Labels Carefully
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Dosage Information:</strong>
                        Follow the recommended serving size and
                        THC/CBD content on the label.
                    </li>

                    <li>
                        <strong>Serving Size:</strong>
                        Be aware of how many servings are in a
                        package.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Be Patient with Effects
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Onset Time:</strong>
                        Effects of CBD edibles can take
                        30 minutes to 2 hours to be felt.
                    </li>

                    <li>
                        <strong>
                            Avoid Premature Consumption:
                        </strong>
                        Wait for the effects before taking
                        more.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Avoid Mixing with Other Substances
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Interaction Risks:</strong>
                        Be cautious about combining CBD with
                        other substances or medications.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Store Safely
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Child and Pet Safety:</strong>
                        Keep CBD edibles out of reach of
                        children and pets.
                    </li>

                    <li>
                        <strong>Proper Storage:</strong>
                        Store in a cool, dark place to maintain
                        potency.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Monitor for Side Effects
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Watch for Reactions:</strong>
                        Possible side effects include dry
                        mouth, dizziness, or changes in
                        appetite.
                    </li>

                    <li>
                        <strong>Adjust Dosage:</strong>
                        Reduce the dose if you experience
                        adverse effects.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Know the Legal Status
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Legal Compliance:</strong>
                        Ensure CBD is legal in your area by
                        using our
                        <router-link
                            :to="{ name: 'legality' }"
                        >
                            state law list
                        </router-link>
                        and that you’re purchasing from a
                        reputable source.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Understand Individual Tolerance
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Personal Variation:</strong>
                        Individual responses to CBD can vary,
                        so adjust your dosage based on how you
                        feel.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Avoid Driving or Operating Machinery
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Impairment:</strong>
                        Although CBD is generally
                        non-psychoactive, it’s best to avoid
                        driving or using heavy machinery until
                        you know how it affects you.
                    </li>
                </ul>

            </li>

        </ol>

        <!-- Display CBD Safety Image -->
        <figure class="safety-image">

            <img
                :src="CbdSafetyImage"
                alt="CBD consumption safety"
            />

        </figure>

    </section>

</template>

<script>
import CbdSafetyImage
    from "../../assets/safety/cbd-safety.webp";

export default {
    name: "CbdSafety",

    data() {
        return {
            CbdSafetyImage
        };
    }
};
</script>

<style scoped>

</style>