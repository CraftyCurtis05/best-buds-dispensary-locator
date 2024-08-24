<!-- Smoking Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="smoking-body">

        <!-- Display Cannabis Smoking Tips Information -->
        <section id="smoking">
            <h1>Safety Tips for Smoking Cannabis</h1>
            <p>If you've found yourself asking, "What is the first feeling of weed?", it's important to understand that each person's reaction can be quite diverse. As you ponder, "Is it okay to start smoking weed?", remember that preparation is paramount. A comprehensive understanding of the varying cannabis strains, a cautious starting approach, and ensuring a comfortable, secure environment can lay the groundwork for an enjoyable and memorable first-time experience.</p>

            <ol id="list">
                <li>Start with a Low Dose</li>
                <ul id="sub-list">
                    <li>Begin Small:</li>
                    <span>Start with a small amount, especially if you’re new or trying a new strain.</span>
                    <li>Monitor Effects:</li>
                    <span>Increase gradually based on your tolerance and desired effects.</span>
                </ul>

                <li>Know Your Strain</li>
                <ul id="sub-list">
                    <li>Research Strains:</li>
                    <span>Understand the THC and CBD content and the strain type by using our <router-link v-bind:to="{ name:'strainguide' }">strain guide</router-link>.</span>
                    <li>Effects:</li>
                    <span>Be aware of the effects associated with the strain, such as relaxation or stimulation.</span>
                </ul>

                <li>Use Safe and Clean Devices</li>
                <ul id="sub-list">
                    <li>Quality Gear:</li>
                    <span>Use high-quality, safe smoking devices like pipes, bongs, or vaporizers.</span>
                    <li>Regular Cleaning:</li>
                    <span>Clean your devices regularly to prevent residue build-up and contamination.</span>
                </ul>

                <li>Be Patient with Effects</li>
                <ul id="sub-list">
                    <li>Onset Time:</li>
                    <span>Effects can begin quickly but may take a few minutes to reach their peak.</span>
                    <li>Avoid Premature Use:</li>
                    <span>Don’t consume more until you understand the effects of your initial dose.</span>
                </ul>

                <li>Avoid Mixing Substances</li>
                <ul id="sub-list">
                    <li>No Alcohol or Drugs:</li>
                    <span>Avoid combining cannabis with alcohol or other substances to prevent adverse reactions.</span>
                </ul>

                <li>Follow Legal Guidelines</li>
                <ul id="sub-list">
                    <li>Legal Status:</li>
                    <span>Ensure cannabis use is legal in your area and follow local regulations on possession and consumption by using our <router-link v-bind:to="{ name:'legality' }">state law list</router-link>.</span>
                </ul>

                <li>Practice Good Smoking Etiquette</li>
                <ul id="sub-list">
                    <li>Designated Areas:</li>
                    <span>Smoke in areas where it is allowed and avoid exposing non-smokers to secondhand smoke.</span>
                    <li>Respect Others:</li>
                    <span>Always ask for permission before smoking in someone else’s space.</span>
                </ul>

                <li>Be Mindful of Secondhand Smoke</li>
                <ul id="sub-list">
                    <li>Ventilation:</li>
                    <span>Smoke in well-ventilated areas to minimize secondhand smoke exposure for others.</span>
                </ul>

                <li>Store Cannabis Properly</li>
                <ul id="sub-list">
                    <li>Secure Storage:</li>
                    <span>Keep cannabis in a cool, dark place, away from children and pets.</span>
                    <li>Childproof Containers:</li>
                    <span>Use child-resistant containers to prevent accidental ingestion.</span>
                </ul>

                <li>Stay Hydrated and Have Snacks</li>
                <ul id="sub-list">
                    <li>Hydration:</li>
                    <span>Drink plenty of water to avoid dry mouth.</span>
                    <li>Snacks:</li>
                    <span>Have food available to manage increased appetite (the munchies).</span>
                </ul>

                <li>Avoid Driving or Operating Machinery</li>
                <ul id="sub-list">
                    <li>Impairment:</li>
                    <span>Cannabis can impair coordination and reaction times. Avoid driving or using machinery.</span>
                </ul>

                <li>Monitor for Side Effects</li>
                <ul id="sub-list">
                    <li>Common Reactions:</li>
                    <span>Be aware of side effects like dry mouth, red eyes, and altered perception. Adjust consumption as needed.</span>
                    <li>Seek Help:</li>
                    <span>If experiencing severe adverse effects, seek medical assistance.</span>
                </ul>

                <li>Be Cautious with High-THC Products</li>
                <ul id="sub-list">
                    <li>Potency Awareness:</li>
                    <span>High-THC strains or products can produce stronger effects. Start with lower-THC options if unfamiliar with high potency.</span>
                </ul>

                <li>Consult a Healthcare Professional</li>
                <ul id="sub-list">
                    <li>Medical Conditions:</li>
                    <span>If you have health conditions or are on medication, consult your doctor before using cannabis.</span>
                </ul>

                <li>Avoid Smoking Near Sensitive Areas</li>
                <ul id="sub-list">
                    <li>Sensitive Areas:</li>
                    <span>Avoid smoking in places with children, pets, or where smoking is prohibited.</span>
                </ul>

                <li>Use in a Safe Environment</li>
                <ul id="sub-list">
                    <li>Comfortable Setting:</li>
                    <span>Smoke in a familiar, comfortable place where you feel safe and relaxed.</span>
                </ul>

                <li>Keep Track of Consumption</li>
                <ul id="sub-list">
                    <li>Monitor Use:</li>
                    <span>Keep track of how much you smoke and how it affects you to prevent overconsumption.</span>
                </ul>

                <li>Educate Yourself on Cannabis Laws</li>
                <ul id="sub-list">
                    <li>Know the Rules:</li>
                    <span>Stay informed about the legal status and regulations regarding cannabis in your area by using our <router-link v-bind:to="{ name:'legality' }">state law list</router-link>.</span>
                </ul>
            </ol>
        </section>

    </body>
    
</template>

<script>
export default {
    name: "Smoking"
};
</script>

<style scoped>

</style>