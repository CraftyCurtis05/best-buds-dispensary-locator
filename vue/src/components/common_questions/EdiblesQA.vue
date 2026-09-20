<!-- Edibles Q&A Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="edibles-body">

        <!-- Display Component Title and Summary -->
        <h1>Edibles Q&A</h1>
        <p>***NEED SUMMARY***</p>

        <!-- Display Edibles Q&A Component Information -->
        <section id="edibles">
            <ol id="list">
                <li>What are cannabis edibles?</li>
                <ul id="sub-list">
                    <li>Cannabis edibles are food products infused with cannabinoids, such as THC (tetrahydrocannabinol) and CBD (cannabidiol).</li>
                    <li>They come in various forms like gummies, brownies, chocolates, or beverages.</li>
                </ul>

                <li>How do cannabis edibles work?</li>
                <ul id="sub-list">
                    <li>When you consume an edible, it passes through your digestive system and is metabolized by the liver.</li>
                    <li>The liver converts THC into a more potent form, which can lead to more intense effects compared to other methods of consumption.</li>
                </ul>

                <li>How long does it take for edibles to kick in?</li>
                <ul id="sub-list">
                    <li>Edibles can take anywhere from 30 minutes to 2 hours to take effect, depending on factors like metabolism, the contents of the edible, and whether you have eaten recently.</li>
                    <li>It’s important to be patient and not take more before the effects are fully felt.</li>
                </ul>

                <li>How much should I start with?</li>
                <ul id="sub-list">
                    <li>If you’re new to edibles, it’s best to start with a low dose, typically 5 to 10 milligrams of THC.</li>
                    <li>You can always take more later if needed, but starting small helps prevent overwhelming effects.</li>
                </ul>

                <li>What are the common effects of cannabis edibles?</li>
                <ul id="sub-list">
                    <li>Effects can include relaxation, euphoria, altered perception of time, and increased appetite.</li>
                    <li>Some people may also experience anxiety or paranoia, especially with higher doses or in unfamiliar situations.</li>
                </ul>

                <li>Can I overdose on cannabis edibles?</li>
                <ul id="sub-list">
                    <li>While it's unlikely to be life-threatening, consuming too much can lead to unpleasant effects like severe anxiety, paranoia, or confusion.</li>
                    <li>Always start with a low dose and wait for the effects to fully manifest before consuming more.</li>
                </ul>

                <li>How long do the effects last?</li>
                <ul id="sub-list">
                    <li>The effects of cannabis edibles can last between 4 to 12 hours, with the peak effects occurring 2 to 4 hours after consumption.</li>
                    <li>The duration can vary based on individual metabolism and the dose.</li>
                </ul>

                <li>What should I do if I feel too high?</li>
                <ul id="sub-list">
                    <li>If you’ve consumed too much and feel uncomfortable, try to stay calm.</li>
                    <li>Drinking water, resting in a comfortable environment, and eating a light snack can help.</li>
                    <li>CBD might help counteract some of the psychoactive effects of THC.</li>
                </ul>
                
                <li>Are edibles legal?</li>
                <ul id="sub-list">
                    <li>The legality of cannabis edibles varies by location.</li>
                    <li>In places where cannabis is legal, edibles are typically regulated and available for purchase.</li>
                    <li>Always check local laws to ensure compliance by using our <router-link v-bind:to="{ name:'legality' }">state law map</router-link>.</li>
                </ul>

                <li>Can edibles be made at home?</li>
                <ul id="sub-list">
                    <li>Yes, you can make cannabis edibles at home using cannabis-infused oils or butters.</li>
                    <li>However, homemade edibles can be difficult to dose accurately, so it's important to be cautious with amounts.</li>
                </ul>

                <li>How should I store edibles?</li>
                <ul id="sub-list">
                    <li>Store edibles in a cool, dry place, and keep them out of reach of children and pets.</li>
                    <li>Proper labeling can help avoid accidental consumption.</li>
                </ul>

                <li>Can I mix edibles with alcohol?</li>
                <ul id="sub-list">
                    <li>Combining cannabis edibles with alcohol can amplify effects and increase the risk of unpleasant experiences.</li>
                    <li>It's generally advisable to avoid mixing the two until you understand how each affects you individually.</li>
                </ul>
            </ol>
        </section>

    </body>

</template>

<script>
export default {
    name: "EdiblesQA"
};
</script>

<style scoped>

</style>