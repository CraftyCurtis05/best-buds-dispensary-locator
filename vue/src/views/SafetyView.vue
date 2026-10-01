<!-- Safety Tips View Display -->
<template>

    <div
        id="safety-view"
        aria-labelledby="safety-heading"
    >

        <!-- Display Page Introduction -->
        <header id="safety-header">

            <h1 id="safety-heading">
                Tips for Safer Cannabis Consumption, Smoking
                and Topicals
            </h1>

            <h2>
                Want to keep your high smooth and groovy?
            </h2>

            <p>
                Cannabis use safety is like mastering the art
                of throwing a great party—keep the vibes
                positive, don’t overdo it, and have a plan to
                get home safely if needed. Balance your snacks
                with hydration, and remember: moderation is
                key. So, enjoy the high, but don’t let it turn
                into a wild rave without a designated driver!
            </p>

            <p>
                Take a gander at the safety tips for cannabis
                use below!
            </p>

        </header>

        <!-- Display Safety Topic Navigation -->
        <OnThisPage
            :topics="safetyTopics"
        />

        <!-- Display Safety Tips -->
        <section
            id="safety-tips"
            aria-labelledby="safety-tips-heading"
        >

            <h2 id="safety-tips-heading">
                Cannabis Safety Tips
            </h2>

            <ThcSafety />

            <CbdSafety />

            <SmokingSafety />

            <TopicalSafety />

        </section>

        <!-- Display Conclusion -->
        <section
            id="safety-conclusion"
            aria-labelledby="safety-conclusion-heading"
        >

            <h2 id="safety-conclusion-heading">
                Conclusion
            </h2>

            <p>
                Your first cannabis experience can be a
                wonderful journey when approached with care
                and responsibility. As for the question, "Is
                it better to use weed the first time alone or
                in company?", having a trusted, sober friend
                nearby can make the experience more comforting
                and enjoyable. By following the tips shared in
                this guide, first-time cannabis smokers can
                look forward to a positive and memorable first
                high. If you are contemplating using cannabis
                for the first time, undertake comprehensive
                research and connect with experienced cannabis
                users for their insights. This can empower you
                to make an informed decision about whether
                cannabis is the right choice for you.
            </p>

            <p>
                Cannabis comes in a variety of forms including
                edibles and concentrates but they are not the
                best choice for your first time. Extracts
                including vape cartridges are too potent and
                hard to handle for a novice and edibles are
                not that predictable in terms of dosage and
                effects (which depend on numerous factors like
                tolerance and the time of onset) the buzz may
                start hours from ingestion and last for up to
                8 hours.
            </p>

            <p>
                <strong>
                    Remember, responsible consumption is
                    crucial for any enjoyable cannabis
                    experience.
                </strong>
            </p>

        </section>

    </div>

</template>

<script>
import OnThisPage from "../components/layout/OnThisPage.vue";
import ThcSafety from "../components/safety/ThcSafety.vue";
import CbdSafety from "../components/safety/CbdSafety.vue";
import SmokingSafety from "../components/safety/SmokingSafety.vue";
import TopicalSafety from "../components/safety/TopicalSafety.vue";

import UserActivityService from "../services/UserActivityService.js";

import {USER_ACTIVITY_TYPES} from "../constants/userActivityTypes.js";

export default {
    name: "SafetyView",

    components: {
        OnThisPage,
        ThcSafety,
        CbdSafety,
        SmokingSafety,
        TopicalSafety
    },

    emits: [
        "activity-recorded"
    ],

    data() {
        return {

            // Track safety topics viewed during this page visit
            safetyObserver: null,
            viewedSafetyTopics: new Set(),

            // Safety topics used for navigation and activity tracking
            safetyTopics: [
                {
                    id: "thc-consumption",
                    label: "THC Consumption",
                    value: "thc"
                },
                {
                    id: "cbd-consumption",
                    label: "CBD Consumption",
                    value: "cbd"
                },
                {
                    id: "smoking-safety",
                    label: "Cannabis Smoking",
                    value: "smoking"
                },
                {
                    id: "topical-use",
                    label: "Topical Use",
                    value: "topical"
                }
            ]

        };
    },

    mounted() {
        this.observeSafetySections();
    },

    beforeUnmount() {

        if (this.safetyObserver) {
            this.safetyObserver.disconnect();
        }

    },

    methods: {

        // Watch safety sections as the user explores the page
        observeSafetySections() {

            this.safetyObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (!entry.isIntersecting) {
                                    return;
                                }

                                const safetyTopic =
                                        this.safetyTopics.find(
                                            (item) =>
                                                item.id
                                                === entry.target.id
                                        );

                                if (!safetyTopic) {
                                    return;
                                }

                                this.recordSafetyView(
                                    safetyTopic.value
                                );

                            }
                        );

                    },
                    {
                        threshold: 0.1
                    }
                );

                this.safetyTopics.forEach(
                    (safetyTopic) => {

                        const section =
                            document.getElementById(
                                safetyTopic.id
                            );

                        if (section) {
                            this.safetyObserver.observe(
                                section
                            );
                        }

                    }
                );

        },

        // Record a safety topic once during this page visit
        recordSafetyView(
            safetyTopic
        ) {

            if (
                this.viewedSafetyTopics.has(
                    safetyTopic
                )
            ) {
                return;
            }

            this.viewedSafetyTopics.add(
                safetyTopic
            );

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.SAFETY_VIEW,
                    safetyTopic
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {

                    this.viewedSafetyTopics.delete(
                        safetyTopic
                    );

                });

        }

    }
};
</script>

<style scoped>

</style>