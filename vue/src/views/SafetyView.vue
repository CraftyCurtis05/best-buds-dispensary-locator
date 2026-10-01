<!-- Safety Tips View Display -->
<template>

    <div
        id="safety-view"
        aria-labelledby="safety-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="safety-header"
            aria-labelledby="safety-heading"
        >

            <h1 id="safety-heading">
                Cannabis Safety
            </h1>

            <h2>
                Understanding Risks Can Help You Make More
                Informed Decisions
            </h2>

            <p>
                Cannabis products can differ widely in potency,
                ingredients, how they are used, how quickly effects
                begin, and how long those effects may last.
            </p>

            <p>
                THC, CBD, smoking, vaping, edibles, concentrates,
                tinctures, and topicals can also involve different
                safety considerations.
            </p>

            <p>
                Use the topics below to learn about common risks,
                ways to reduce avoidable harm, and situations where
                extra caution or professional medical guidance may
                be important.
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

        <!-- Display Additional Safety Considerations -->
        <section
            id="additional-safety"
            aria-labelledby="additional-safety-heading"
        >

            <h2 id="additional-safety-heading">
                When Extra Caution May Be Important
            </h2>

            <p>
                Cannabis can carry additional risks in some
                situations. Consider speaking with a qualified
                healthcare professional when cannabis use may
                involve:
            </p>

            <ul>

                <li>
                    Pregnancy or breastfeeding.
                </li>

                <li>
                    Children, teenagers, or young adults whose
                    brains are still developing.
                </li>

                <li>
                    A history of anxiety, panic, psychosis, or
                    other mental health concerns.
                </li>

                <li>
                    Heart or cardiovascular conditions.
                </li>

                <li>
                    Prescription medications or other substances
                    that may interact with cannabis or CBD.
                </li>

                <li>
                    Frequent use, difficulty cutting back, or other
                    signs of cannabis use disorder.
                </li>

                <li>
                    Driving, operating machinery, or performing
                    tasks that require full attention and
                    coordination.
                </li>

                <li>
                    Children or pets who could accidentally reach
                    cannabis products.
                </li>

            </ul>

            <p>
                Safety depends on more than the product itself.
                Health history, age, medications, dose, frequency
                of use, and other substances can all matter.
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