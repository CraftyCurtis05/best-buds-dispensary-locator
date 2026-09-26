<!-- Cannabis Overuse Symptoms Component Display -->
<template>

    <section
        id="symptoms"
        aria-labelledby="symptoms-heading"
    >

        <!-- Display Cannabis Overuse Symptoms Introduction -->
        <h3 id="symptoms-heading">
            Signs and Symptoms
        </h3>

        <p>
            Consuming too much cannabis can lead to a range of
            symptoms, from anxiety to nausea.
        </p>

        <!-- Display Cannabis Overuse Symptoms -->
        <ol class="symptoms-list">

            <li>

                <h4>
                    Physical Symptoms
                </h4>

                <ul class="symptoms-details">
                    <li>
                        Dizziness
                    </li>

                    <li>
                        Dry, red eyes
                    </li>

                    <li>
                        Fatigue or lethargy
                    </li>

                    <li>
                        Headaches
                    </li>

                    <li>
                        Increased heart rate
                    </li>

                    <li>
                        Nausea and change in appetite
                    </li>

                    <li>
                        Thirstiness or a dry mouth
                        (aka “cotton mouth”)
                    </li>

                    <li>
                        Vomiting
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Psychological Symptoms
                </h4>

                <ul class="symptoms-details">
                    <li>
                        Anxiety
                    </li>

                    <li>
                        Confusion
                    </li>

                    <li>
                        Difficulty concentrating
                    </li>

                    <li>
                        Mood changes
                    </li>

                    <li>
                        Thoughts racing
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    In rare cases, it can cause more serious
                    psychological symptoms like:
                </h4>

                <ul class="symptoms-details">
                    <li>
                        Hallucinations
                    </li>

                    <li>
                        Panic attacks
                    </li>

                    <li>
                        Paranoia
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    In some extremely rare cases, cannabis use
                    may contribute to the onset of psychosis.
                    which can include symptoms like:
                </h4>

                <ul class="symptoms-details">
                    <li>
                        Delusions
                    </li>

                    <li>
                        Confusion
                    </li>

                    <li>
                        Memory loss
                    </li>

                    <li>
                        Disorganized speech
                    </li>

                    <li>
                        Difficulty feeling or expressing
                        emotions
                    </li>
                </ul>

            </li>

        </ol>

        <!-- Display Medical Care Notice -->
        <p class="medical-care-notice">
            <strong>
                If you think you or someone else is
                experiencing psychosis, contact emergency
                services or get immediate medical care.
            </strong>
        </p>

        <!-- Display Cannabis Overuse Symptoms Image -->
        <figure class="symptoms-image">

            <img
                :src="CannabisOveruseSymptomsImage"
                alt="Cannabis overuse symptoms"
            />

        </figure>

    </section>

</template>

<script>
import CannabisOveruseSymptomsImage from "../../assets/too-much/cannabis-overuse-symptoms.webp";

export default {
    name: "CannabisOveruseSymptoms",

    data() {
        return {
            CannabisOveruseSymptomsImage
        };
    }
};
</script>

<style scoped>

</style>