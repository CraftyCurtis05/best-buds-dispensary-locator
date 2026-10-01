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
                Getting Started With Cannabis
            </h1>

            <h2>
                Not sure where to begin?
            </h2>

            <p>
                Cannabis can feel complicated when you're learning
                about it for the first time. Products, potency,
                labels, laws, and effects can all vary.
            </p>

            <p>
                This guide covers practical things to know before
                choosing a product, reading a label, using cannabis,
                driving, understanding the law, or deciding where
                to learn more.
            </p>

            <p>
                Start with the topics that matter to you and take
                your time exploring.
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