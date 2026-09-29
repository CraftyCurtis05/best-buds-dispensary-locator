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

        <!-- Display Cannabis Overuse Jump Links -->
        <nav
            id="too-much-links"
            aria-label="Cannabis overuse topics"
        >

            <ul>

                <li>
                    <a href="#symptoms">
                        Signs and Symptoms
                    </a>
                </li>

                <li>
                    <a href="#coping">
                        How to Cope
                    </a>
                </li>

                <li>
                    <a href="#what-to-do">
                        What To Do
                    </a>
                </li>

            </ul>

        </nav>

        <!-- Display Cannabis Overuse Information -->
        <section
            id="cannabis-overuse"
            aria-labelledby="cannabis-overuse-heading"
        >

            <h2 id="cannabis-overuse-heading">
                Cannabis Overuse Guide
            </h2>

            <CannabisOveruseSymptoms />

            <CannabisOveruseCoping />

            <CannabisOveruseGuide />

        </section>

        <!-- Display Strain Guide -->
        <section
            id="too-much-strain-guide"
            aria-labelledby="too-much-strain-guide-heading"
        >

            <h2 id="too-much-strain-guide-heading">
                Explore Our Strain Guide
            </h2>

            <StrainGuideVisit />

        </section>

        <!-- Display Latest Articles -->
        <section
            id="too-much-articles"
            aria-labelledby="too-much-articles-heading"
        >

            <h2 id="too-much-articles-heading">
                Latest Cannabis Articles
            </h2>

            <ArticlesVisit />

        </section>

    </div>

</template>

<script>
import CannabisOveruseSymptoms from "../components/too-much/CannabisOveruseSymptoms.vue";
import CannabisOveruseCoping from "../components/too-much/CannabisOveruseCoping.vue";
import CannabisOveruseGuide from "../components/too-much/CannabisOveruseGuide.vue";
import StrainGuideVisit from "../components/strain-guide/StrainGuideVisit.vue";
import ArticlesVisit from "../components/articles/ArticlesVisit.vue";

import UserActivityService from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";

export default {
    name: "TooMuchView",

    components: {
        CannabisOveruseSymptoms,
        CannabisOveruseCoping,
        CannabisOveruseGuide,
        StrainGuideVisit,
        ArticlesVisit
    },

    emits: [
        "activity-recorded"
    ],

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