<!-- Common Questions View Display -->
<template>

    <div
        id="questions-view"
        aria-labelledby="questions-heading"
    >

        <!-- Display Page Introduction -->
        <header id="questions-header">

            <h1 id="questions-heading">
                Common Cannabis Questions
            </h1>

            <h2>
                Clear Answers to Questions People Commonly Ask
            </h2>

            <p>
                Cannabis terminology, products, laws, effects, and
                safety information can be confusing.
            </p>

            <p>
                This section answers common questions about cannabis,
                CBD, Delta-9 THC, dispensaries, flower, concentrates,
                oils, tinctures, smoking, vaporizing, edibles, and
                topicals.
            </p>

            <p>
                Choose a topic below and explore the questions that
                are most useful to you.
            </p>

        </header>

        <!-- Display Questions Navigation -->
        <OnThisPage
            :topics="questionsSections"
        />

        <!-- Display Questions and Answers -->
        <section
            id="questions"
            aria-labelledby="questions-topics-heading"
        >

            <h2 id="questions-topics-heading">
                Cannabis Questions & Answers
            </h2>

            <DispensaryQuestions />

            <CannabisQuestions />

            <CbdQuestions />

            <Delta9Questions />

            <FlowerQuestions />

            <WaxQuestions />

            <OilQuestions />

            <TinctureQuestions />

            <SmokingQuestions />

            <VaporizingQuestions />

            <EdibleQuestions />

            <TopicalQuestions />

        </section>

    </div>

</template>

<script>
import OnThisPage from "../components/layout/OnThisPage.vue";
import DispensaryQuestions from "../components/questions/DispensaryQuestions.vue";
import CannabisQuestions from "../components/questions/CannabisQuestions.vue";
import CbdQuestions from "../components/questions/CbdQuestions.vue";
import Delta9Questions from "../components/questions/Delta9Questions.vue";
import FlowerQuestions from "../components/questions/FlowerQuestions.vue";
import WaxQuestions from "../components/questions/WaxQuestions.vue";
import OilQuestions from "../components/questions/OilQuestions.vue";
import TinctureQuestions from "../components/questions/TinctureQuestions.vue";
import SmokingQuestions from "../components/questions/SmokingQuestions.vue";
import VaporizingQuestions from "../components/questions/VaporizingQuestions.vue";
import EdibleQuestions from "../components/questions/EdibleQuestions.vue";
import TopicalQuestions from "../components/questions/TopicalQuestions.vue";

import UserActivityService from "../services/UserActivityService.js";

import {USER_ACTIVITY_TYPES} from "../constants/userActivityTypes.js";

export default {
    name: "QuestionsView",

    components: {
        OnThisPage,
        DispensaryQuestions,
        CannabisQuestions,
        CbdQuestions,
        Delta9Questions,
        FlowerQuestions,
        WaxQuestions,
        OilQuestions,
        TinctureQuestions,
        SmokingQuestions,
        VaporizingQuestions,
        EdibleQuestions,
        TopicalQuestions
    },

    emits: [
        "activity-recorded"
    ],

    data() {
        return {

            // Track question topics viewed during this page visit
            questionObserver: null,
            viewedQuestionTopics: new Set(),

            // Question sections used for navigation and activity tracking
            questionsSections: [
                {
                    id: "dispensaries",
                    label: "Dispensaries",
                    value: "dispensary"
                },
                {
                    id: "cannabis",
                    label: "Cannabis",
                    value: "cannabis"
                },
                {
                    id: "cbd",
                    label: "CBD",
                    value: "cbd"
                },
                {
                    id: "delta9",
                    label: "Delta-9",
                    value: "delta-9"
                },
                {
                    id: "flower",
                    label: "Flower",
                    value: "flower"
                },
                {
                    id: "wax",
                    label: "Wax",
                    value: "wax"
                },
                {
                    id: "oil",
                    label: "Oil",
                    value: "oil"
                },
                {
                    id: "tincture",
                    label: "Tincture",
                    value: "tincture"
                },
                {
                    id: "smoking",
                    label: "Smoking",
                    value: "smoking"
                },
                {
                    id: "vaporizing",
                    label: "Vaporizing",
                    value: "vaporizing"
                },
                {
                    id: "edibles",
                    label: "Edibles",
                    value: "edible"
                },
                {
                    id: "topicals",
                    label: "Topicals",
                    value: "topical"
                }
            ]
        };
    },

    mounted() {
        this.observeQuestionSections();
    },

    beforeUnmount() {

        if (this.questionObserver) {
            this.questionObserver.disconnect();
        }

    },

    methods: {

        // Watch question sections as the user explores the page
        observeQuestionSections() {

            this.questionObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (!entry.isIntersecting) {
                                    return;
                                }

                                const questionTopic =
                                    this.questionsSections.find(
                                        (item) =>
                                            item.id
                                            === entry.target.id
                                    );

                                if (!questionTopic) {
                                    return;
                                }

                                this.recordEducationView(
                                    questionTopic.value
                                );

                            }
                        );

                    },
                    {
                        threshold: 0.1
                    }
                );

            this.questionsSections.forEach(
                (questionTopic) => {

                    const section =
                        document.getElementById(
                            questionTopic.id
                        );

                    if (section) {
                        this.questionObserver.observe(
                            section
                        );
                    }

                }
            );

        },

        // Record an education topic once during this page visit
        recordEducationView(
            educationTopic
        ) {

            if (
                this.viewedQuestionTopics.has(
                    educationTopic
                )
            ) {
                return;
            }

            this.viewedQuestionTopics.add(
                educationTopic
            );

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.EDUCATION_VIEW,
                    educationTopic
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {

                    this.viewedQuestionTopics.delete(
                        educationTopic
                    );

                });

        }

    }
};
</script>

<style scoped>

</style>