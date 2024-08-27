<!-- CBD Consumption Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="cbd-body">

        <!-- Display CBD Consumption Tips Information -->
        <section id="cbd"> 
            <h1>Safety Tips for Cannabinol(CBD) Consumption</h1>
            <p>Take it slow with CBD edibles—start small and see how you feel! Read labels, choose quality, and check with your doc if you’re on meds. Be patient, store them right, and enjoy the chill without overdoing it. Keep an eye out for any side effects, and make sure it's all legal. Relax, snack responsibly, and let the calm vibes roll! Check out more safety tips below:</p>

            <ol id="list">
                <li>Start with a Low Dose</li>
                <ul id="sub-list">
                    <li>Initial Dose:</li>
                    <span>Begin with a small amount (typically 5-10 mg) to gauge your tolerance.</span>
                    <li>Gradual Increase:</li>
                    <span>If needed, slowly increase the dose while monitoring how you feel.</span>
                </ul>

                <li>Consult Your Doctor</li>
                <ul id="sub-list">
                    <li>Medical Advice:</li>
                    <span>Discuss CBD use with a healthcare professional, especially if you have medical conditions or are on other medications.</span>
                </ul>

                <li>Choose Quality Products</li>
                <ul id="sub-list">
                    <li>Third-Party Testing:</li>
                    <span>Select products that are tested for purity and potency by independent labs.</span>
                    <li>Check Ingredients:</li>
                    <span>Ensure the product is free of contaminants and additives.</span>
                </ul>

                <li>Read Labels Carefully</li>
                <ul id="sub-list">
                    <li>Dosage Information:</li>
                    <span>Follow the recommended serving size and THC/CBD content on the label.</span>
                    <li>Serving Size:</li>
                    <span>Be aware of how many servings are in a package.</span>
                </ul>

                <li>Be Patient with Effects</li>
                <ul id="sub-list">
                    <li>Onset Time:</li>
                    <span>Effects of CBD edibles can take 30 minutes to 2 hours to be felt.</span>
                    <li>Avoid Premature Consumption:</li>
                    <span>Wait for the effects before taking more.</span>
                </ul>

                <li>Avoid Mixing with Other Substances</li>
                <ul id="sub-list">
                    <li>Interaction Risks:</li>
                    <span>Be cautious about combining CBD with other substances or medications.</span>
                </ul>

                <li>Store Safely</li>
                <ul id="sub-list">
                    <li>Child and Pet Safety:</li>
                    <span>Keep CBD edibles out of reach of children and pets.</span>
                    <li>Proper Storage:</li>
                    <span>Store in a cool, dark place to maintain potency.</span>
                </ul>

                <li>Monitor for Side Effects</li>
                <ul id="sub-list">
                    <li>Watch for Reactions:</li>
                    <span>Possible side effects include dry mouth, dizziness, or changes in appetite.</span>
                    <li>Adjust Dosage:</li>
                    <span>Reduce the dose if you experience adverse effects.</span>
                </ul>

                <li>Know the Legal Status</li>
                <ul id="sub-list">
                    <li>Legal Compliance:</li>
                    <span>Ensure CBD is legal in your area by using our <router-link v-bind:to="{ name:'legality' }">state law list</router-link> and that you’re purchasing from a reputable source.</span>
                </ul>

                <li>Understand Individual Tolerance</li>
                <ul id="sub-list">
                    <li>Personal Variation:</li>
                    <span>Individual responses to CBD can vary, so adjust your dosage based on how you feel.</span>
                </ul>

                <li>Avoid Driving or Operating Machinery</li>
                <ul id="sub-list">
                    <li>Impairment:</li>
                    <span>Although CBD is generally non-psychoactive, it’s best to avoid driving or using heavy machinery until you know how it affects you.</span>
                </ul>
            </ol>  
        </section>

        <!-- Display Photo -->
        <aside id="photo">
            <img src="@\assets\safety_assets\cbd_tips.jpg"/>
        </aside>

    </body>

</template>

<script>
export default {
    name: "CBDConsumption"
};
</script>

<style scoped>
img {
    width: 40rem;
    border: .2rem black solid;
}
</style>