<!-- Too Much Cannabis View Display -->
<template>

    <div
        id="too-much-view"
        aria-labelledby="too-much-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="too-much-header"
            aria-labelledby="too-much-heading"
        >

            <h1 id="too-much-heading">
                Too Much Cannabis
            </h1>

            <h2>
                Think You May Have Had Too Much?
            </h2>

            <p>
                Too much THC can cause uncomfortable effects such
                as anxiety, panic, confusion, dizziness, nausea,
                paranoia, or a fast heart rate.
            </p>

            <p>
                Many uncomfortable cannabis reactions improve with
                time, but serious symptoms can require medical help.
            </p>

            <p>
                Use the guide below to understand possible symptoms,
                what you can do next, and when it may be important
                to get additional help.
            </p>

        </header>

        <!-- Display Cannabis Overuse Navigation -->
        <OnThisPage
            :topics="overuseTopics"
        />

        <!-- Display Cannabis Overuse Information -->
        <section
            id="cannabis-overuse"
            aria-labelledby="cannabis-overuse-heading"
        >

            <h2 id="cannabis-overuse-heading">
                Cannabis Overuse Guide
            </h2>

            <!-- Display Overuse Symptoms -->
            <CannabisOveruseSymptoms />

            <!-- Display Immediate Overuse Guide -->
            <CannabisOveruseGuide />

            <!-- Display Overuse Coping Strategies -->
            <CannabisOveruseCoping />

        </section>

        <!-- Display Health Information Review Date -->
        <p class="health-review-date">
            Health and safety information last reviewed:
            October 2026
        </p>

    </div>

</template>

<script>
import OnThisPage from "../components/layout/OnThisPage.vue";
import CannabisOveruseSymptoms from "../components/too-much/CannabisOveruseSymptoms.vue";
import CannabisOveruseGuide from "../components/too-much/CannabisOveruseGuide.vue";
import CannabisOveruseCoping from "../components/too-much/CannabisOveruseCoping.vue";

import UserActivityService from "../services/UserActivityService.js";

import {USER_ACTIVITY_TYPES} from "../constants/userActivityTypes.js";

export default {
    name: "TooMuchView",

    components: {
        OnThisPage,
        CannabisOveruseSymptoms,
        CannabisOveruseGuide,
        CannabisOveruseCoping
    },

    emits: [
        "activity-recorded"
    ],

    data() {
        return {

            // Main cannabis overuse topics shown on this page
            overuseTopics: [
                {
                    id: "cannabis-overuse-symptoms",
                    label: "Signs & Symptoms"
                },
                {
                    id: "cannabis-overuse-guide",
                    label: "What To Do Now"
                },
                {
                    id: "cannabis-overuse-coping",
                    label: "How to Cope"
                }
            ]

        };
    },

    mounted() {
        this.recordEducationView();
    },

    methods: {

        // Record that the user explored cannabis overuse education
        recordEducationView() {

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.EDUCATION_VIEW,
                    "too-much"
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