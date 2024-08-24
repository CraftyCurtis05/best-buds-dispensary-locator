<!-- Topical Use Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="topical-body">

        <!-- Display Topical Use Tips Component -->
        <section id="topical">
            <h1>Safety Tips for Topical Use</h1>
            <p>For smooth sailing with cannabis topicals, start small, follow the label, and keep it clean. Patch test first, store safely, and skip sensitive spots. If irritation hits, wash off and chill. Enjoy the soothing vibes while keeping things simple and safe. By following these safety tips, you can use cannabis topicals effectively and safely while minimizing potential risks:</p>

            <ol id="list">
                <li>Patch Test First</li>
                <ul id="sub-list">
                    <li>Initial Test:</li>
                    <span>Apply a small amount of the topical to a small area of skin to check for any allergic reactions or irritation before using it more broadly.</span>
                </ul>

                <li>Choose the Right Product</li>
                <ul id="sub-list">
                    <li>Purpose:</li>
                    <span>Select topicals intended for your specific needs, such as pain relief, moisturizing, or skin conditions.</span>
                    <li>THC vs. CBD:</li>
                    <span>Know whether the product contains THC, CBD, or both, and choose according to your preference and needs.</span>
                </ul>

                <li>Read Ingredients Carefully</li>
                <ul id="sub-list">
                    <li>Avoid Allergens:</li>
                    <span>Check for potential allergens or irritating ingredients.</span>
                    <li>Product Quality:</li>
                    <span>Opt for products with high-quality, natural ingredients.</span>
                </ul>

                <li>Follow Application Instructions</li>
                <ul id="sub-list">
                    <li>Dosage:</li>
                    <span>Use the recommended amount as directed on the label.</span>
                    <li>Frequency:</li>
                    <span>Apply as directed, usually several times a day or as needed.</span>
                </ul>

                <li>Apply to Clean, Dry Skin</li>
                <ul id="sub-list">
                    <li>Preparation:</li>
                    <span>Ensure the skin is clean and dry before applying the topical to enhance absorption and effectiveness.</span>
                </ul>

                <li>Avoid Sensitive Areas</li>
                <ul id="sub-list">
                    <li>Sensitive Zones:</li>
                    <span>Keep topicals away from sensitive areas such as the eyes, mouth, and open wounds.</span>
                </ul>

                <li>Start with a Small Amount</li>
                <ul id="sub-list">
                    <li>Initial Application:</li>
                    <span>Begin with a small amount to gauge how your skin reacts before applying more.</span>
                </ul>

                <li>Wash Hands After Use</li>
                <ul id="sub-list">
                    <li>Avoid Transfer:</li>
                    <span>Wash your hands thoroughly after application to prevent accidental transfer to other areas (like your eyes).</span>
                </ul>

                <li>Store Properly</li>
                <ul id="sub-list">
                    <li>Temperature:</li>
                    <span>Store topicals in a cool, dry place, away from direct sunlight.</span>
                    <li>Child and Pet Safety:</li>
                    <span>Keep out of reach of children and pets.</span>
                </ul>

                <li>Be Aware of Absorption</li>
                <ul id="sub-list">
                    <li>Localized Effect:</li>
                    <span>Remember that cannabis topicals typically do not enter the bloodstream but work locally where applied.</span>
                </ul>

                <li>Monitor for Side Effects</li>
                <ul id="sub-list">
                    <li>Watch for Reactions:</li>
                    <span>Be alert for any signs of irritation, redness, or rash. Discontinue use if adverse effects occur.</span>
                </ul>

                <li>Consult a Healthcare Professional</li>
                <ul id="sub-list">
                    <li>Medical Conditions:</li>
                    <span>If you have pre-existing skin conditions or are unsure about using cannabis topicals, consult with a healthcare provider.</span>
                </ul>

                <li>Check Legal Status</li>
                <ul id="sub-list">
                    <li>Legal Compliance:</li>
                    <span>Ensure that cannabis topicals are legal in your area by using our <router-link v-bind:to="{ name:'legality' }">state law list</router-link> and purchased from reputable sources.</span>
                </ul>

                <li>Educate Yourself on Product Efficacy</li>
                <ul id="sub-list">
                    <li>Research:</li>
                    <span>Understand how different cannabinoids and terpenes in topicals can affect your condition and choose products accordingly.</span>
                </ul>

                <li>Avoid Applying Near Open Wounds</li>
                <ul id="sub-list">
                    <li>Infection Risk:</li>
                    <span>Avoid applying topicals to broken or irritated skin to reduce the risk of infection or further irritation.</span>
                </ul>

                <li>Be Cautious with High-THC Products</li>
                <ul id="sub-list">
                    <li>Psychoactive Effects:</li>
                    <span>Be aware that some topicals may contain THC, which might cause psychoactive effects if absorbed into the bloodstream, though this is rare.</span>
                </ul>
            </ol>
        </section>

        <aside id="photo">
            <img src="@\assets\safety_assets\topical_tips.jpg"/>
        </aside>

    </body>
    
</template>

<script>
export default {
    name: "Topical"
};
</script>

<style scoped>
img {
    width: 40rem;
    border: .2rem black solid;
}
</style>