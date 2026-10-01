<!-- Tips and Tricks View Display -->
<template>

    <div
        id="tips-tricks-view"
        aria-labelledby="tips-tricks-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="tips-tricks-header"
            aria-labelledby="tips-tricks-heading"
        >

            <h1 id="tips-tricks-heading">
                Tips & Tricks For Cannabis Use
            </h1>

            <h2>
                Cannabis confusion got you burnt out?
            </h2>

            <p>
                You're not alone! With so many strains,
                products, and effects, it can feel like a
                wild, green maze. But don't stress—it's all
                part of the fun! Think of it as a
                choose-your-own-adventure. Whether you're
                giggling over strain names or puzzled by
                potency, embrace the journey. The key is to
                explore, experiment, and enjoy the ride!
            </p>

            <p>
                Check out some of the Tips and Tricks we've
                compiled below!
            </p>

        </header>

        <!-- Display Tips & Tricks Navigation -->
        <OnThisPage
            :topics="tipsTricksSections"
        />

        <!-- Display Tips and Tricks Guide -->
        <section
            id="tips-tricks"
            aria-labelledby="tips-tricks-guide-heading"
        >

            <h2 id="tips-tricks-guide-heading">
                Cannabis Tips & Tricks
            </h2>

            <TipsTricksGuide />

        </section>

    </div>

</template>

<script>
import OnThisPage from "../components/layout/OnThisPage.vue";
import TipsTricksGuide from "../components/tips-tricks/TipsTricksGuide.vue";

import UserActivityService from "../services/UserActivityService.js";

import {USER_ACTIVITY_TYPES} from "../constants/userActivityTypes.js";

export default {
    name: "TipsTricksView",

    components: {
        OnThisPage,
        TipsTricksGuide
    },

    data() {
        return {
            // Tips and tricks sections used for navigation
            tipsTricksSections: [
                {
                    id: "choose-products",
                    label: "Choose a Product"
                },
                {
                    id: "strain-guide",
                    label: "Strain Guide"
                },
                {
                    id: "read-label",
                    label: "Read the Label"
                },
                {
                    id: "safety-tips",
                    label: "Safety Tips"
                },
                {
                    id: "edible-timing",
                    label: "Edible Timing"
                },
                {
                    id: "too-much",
                    label: "If You Have Too Much"
                },
                {
                    id: "driving",
                    label: "Driving"
                },
                {
                    id: "legality",
                    label: "State Laws"
                },
                {
                    id: "federal-law",
                    label: "Federal Law"
                },
                {
                    id: "questions",
                    label: "Common Questions"
                },
                {
                    id: "getting-started",
                    label: "Getting Started"
                }
            ]
        };
    },

    emits: [
        "activity-recorded"
    ],

    mounted() {
        this.recordEducationView();
    },

    methods: {

        // Record that the user explored tips and tricks
        recordEducationView() {

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.EDUCATION_VIEW,
                    "tips-tricks"
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {
                    // Activity tracking should not block education content
                });

        }

    }
};
</script>

<style scoped>

</style>