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
                Think you may have overdone it?
            </h2>

            <p>
                Using too much cannabis can lead to
                overthinking and heightened anxiety, making
                simple tasks seem overwhelming. It’s like your
                mind gets stuck in overdrive—what started as a
                relaxing evening can turn into a marathon of
                introspection. The key is moderation and
                knowing your limits to keep your experience
                enjoyable and stress-free.
            </p>

            <p>
                If you think you've had too much, please check
                out below to ease your mind!
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