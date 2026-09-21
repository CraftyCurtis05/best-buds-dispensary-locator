<!-- Cannabis Q&A Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="cannabis-body">

        <!-- Display Component Title and Summary -->
        <h1>Cannabis Q&A</h1>
        <p>***NEED SUMMARY***</p>

        <!-- Display Cannabis Q&A Component Information -->
        <section id="cannabis">
            <ol id="list">
                <li>What is cannabis?</li>
                <ul id="sub-list">
                    <li>Cannabis is a plant genus that includes various species, such as Cannabis sativa, Cannabis indica, and Cannabis ruderalis.</li>
                    <li>It has been used for thousands of years for medicinal, recreational, and industrial purposes.</li>
                </ul>

                <li>What are the main components of cannabis?</li>
                <ul id="sub-list">
                    <li>The two primary cannabinoids in cannabis are THC (tetrahydrocannabinol) and CBD (cannabidiol).</li>
                    <li>THC is responsible for most of the psychoactive effects, while CBD is known for its potential therapeutic benefits without causing a high.</li>
                </ul>

                <li>What are the different ways to consume cannabis?</li>
                <ul id="sub-list">
                    <li>Smoking:</li>
                    <span>Using joints, blunts, pipes, or bongs.</span>
                    <li>Vaporizing:</li>
                    <span>Using a vaporizer to heat cannabis without burning it.</span>
                    <li>Edibles:</li>
                    <span>Consuming cannabis-infused foods or beverages.</span>
                    <li>Tinctures:</li>
                    <span>Using liquid extracts taken under the tongue.</span>
                    <li>Topicals:</li>
                    <span>Applying cannabis-infused creams or balms to the skin.</span>
                    <li>Concentrates:</li>
                    <span>Consuming highly concentrated forms of cannabis, such as oils, waxes, or shatter.</span>
                </ul>

                <li>What are the effects of cannabis?</li>
                <ul id="sub-list">
                    <li>The effects of cannabis can vary depending on the strain, dosage, and individual.</li>
                    <li>Common effects include relaxation, euphoria, altered perception of time, increased appetite, and enhanced sensory experiences.</li>
                    <li>It can also cause dry mouth, red eyes, and sometimes anxiety or paranoia.</li>
                </ul>

                <li>How does cannabis affect the brain?</li>
                <ul id="sub-list">
                    <li>Cannabis interacts with the endocannabinoid system in the brain, primarily affecting areas related to pleasure, memory, and movement.</li>
                    <li>THC binds to cannabinoid receptors, leading to its psychoactive effects.</li>
                </ul>

                <li>Can cannabis be addictive?</li>
                <ul id="sub-list">
                    <li>Cannabis has a lower potential for addiction compared to substances like nicotine or opioids, but it is possible to develop a dependence or addiction.</li>
                    <li>Approximately 9% of users may develop a cannabis use disorder, with the risk increasing with frequent use.</li>
                </ul>

                <li>Is cannabis legal?</li>
                <ul id="sub-list">
                    <li>The legality of cannabis varies by country and region.</li>
                    <li>In some places, it is legal for both recreational and medicinal use, while in others, it may be legal only for medical purposes or illegal altogether.</li>
                    <li>Always check local laws to ensure compliance by using our <router-link v-bind:to="{ name:'legality' }">state law map</router-link>.</li>
                </ul>

                <li>What are the medical uses of cannabis?</li>
                <ul id="sub-list">
                    <li>Cannabis is used to treat a variety of conditions, including chronic pain, nausea, epilepsy, multiple sclerosis, and certain types of cancer-related symptoms.</li>
                    <li>CBD, in particular, has shown promise in treating conditions like anxiety and epilepsy.</li>
                </ul>

                <li>How does cannabis affect driving?</li>
                <ul id="sub-list">
                    <li>Cannabis impairs motor skills, coordination, and reaction times, making it unsafe to drive under its influence.</li>
                    <li>Many regions have strict laws against driving while impaired by cannabis, similar to alcohol.</li>
                </ul>

                <li>What are cannabis strains, and how do they differ?</li>
                <ul id="sub-list">
                    <li>Sativa:</li>
                    <span>Often associated with energizing and uplifting effects.</span>
                    <li>Indica:</li>
                    <span>Typically provides relaxing and sedative effects.</span>
                    <li>Hybrid:</li>
                    <span>A mix of both sativa and indica, combining effects from both types.</span>
                </ul>

                <li>How can I store cannabis properly?</li>
                <ul id="sub-list">
                    <li>Store cannabis in an airtight container in a cool, dark place to maintain its potency and flavor.</li>
                    <li>Avoid exposing it to excessive light, heat, or moisture.</li>
                </ul>

                <li>What are terpenes, and why are they important?</li>
                <ul id="sub-list">
                    <li>Terpenes are aromatic compounds found in cannabis (and other plants) that contribute to the plant's scent and flavor.</li>
                    <li>They may also influence the effects of different strains.</li>
                    <li>For example, limonene has a citrus aroma and may have mood-enhancing effects, while myrcene has a musky smell and may contribute to relaxing effects.</li>
                </ul>

                <li>Can cannabis interact with other medications?</li>
                <ul id="sub-list">
                    <li>Yes, cannabis can interact with certain medications, potentially affecting their efficacy or increasing side effects.</li>
                    <li>Always consult with a healthcare provider before using cannabis if you are on medication.</li>
                </ul>

                <li>What is CBD, and how does it differ from THC?</li>
                <ul id="sub-list">
                    <li>CBD (cannabidiol) is a non-psychoactive cannabinoid that does not produce a high.</li>
                    <li>It is often used for its potential therapeutic benefits, such as reducing anxiety or pain, without the intoxicating effects associated with THC (tetrahydrocannabinol).</li>
                </ul>

                <li>How can I find the right dosage?</li>
                <ul id="sub-list">
                    <li>Finding the right dosage of cannabis depends on the method of consumption, the strain, and individual tolerance.</li>
                    <li>Start with a low dose and gradually increase until you find the right amount for your needs.</li>
                    <li>Consult with a healthcare professional for personalized advice.</li>
                </ul>
            </ol>
        </section>

    </body>

</template>

<script>
export default {
    name: "CannabisQA"
};
</script>

<style scoped>

</style>