<!-- Common Questions View Display -->
<template>

    <div
        id="questions-view"
        aria-labelledby="questions-heading"
    >

        <!-- Display Page Introduction -->
        <header id="questions-header">

            <h1 id="questions-heading">
                Commonly Asked Questions About Cannabis
            </h1>

            <h2>
                Got cannabis questions? No worries!
            </h2>

            <p>
                Whether you're curious about legality, how it
                works, or the best ways to use it, the plant’s
                got answers. From getting high or just chilling
                with CBD, to understanding health impacts and
                legal stuff, dive in and explore. Stay
                informed, use responsibly, and enjoy the
                journey!
            </p>

            <p>
                We've got all your questions answered below!
            </p>

        </header>

        <!-- Display Question Jump Links -->
        <nav
            id="question-links"
            aria-label="Cannabis question topics"
        >

            <ul>

                <li>
                    <a href="#dispensaries">
                        Dispensaries
                    </a>
                </li>

                <li>
                    <a href="#cannabis">
                        Cannabis
                    </a>
                </li>

                <li>
                    <a href="#cbd">
                        CBD
                    </a>
                </li>

                <li>
                    <a href="#delta9">
                        Delta-9
                    </a>
                </li>

                <li>
                    <a href="#flower">
                        Flower
                    </a>
                </li>

                <li>
                    <a href="#wax">
                        Wax
                    </a>
                </li>

                <li>
                    <a href="#oil">
                        Oil
                    </a>
                </li>

                <li>
                    <a href="#tincture">
                        Tincture
                    </a>
                </li>

                <li>
                    <a href="#smoking">
                        Smoking
                    </a>
                </li>

                <li>
                    <a href="#vaporizing">
                        Vaporizing
                    </a>
                </li>

                <li>
                    <a href="#edibles">
                        Edibles
                    </a>
                </li>

                <li>
                    <a href="#topicals">
                        Topicals
                    </a>
                </li>

            </ul>

        </nav>

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

        <!-- Display Strain Guide -->
        <section
            id="questions-strain-guide"
            aria-labelledby="questions-strain-guide-heading"
        >

            <h2 id="questions-strain-guide-heading">
                Explore Our Strain Guide
            </h2>

            <StrainGuideVisit />

        </section>

        <!-- Display Latest Articles -->
        <section
            id="questions-articles"
            aria-labelledby="questions-articles-heading"
        >

            <h2 id="questions-articles-heading">
                Latest Cannabis Articles
            </h2>

            <ArticlesVisit />

        </section>

    </div>

</template>

<script>
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
import StrainGuideVisit from "../components/strain-guide/StrainGuideVisit.vue";
import ArticlesVisit from "../components/articles/ArticlesVisit.vue";

import UserActivityService from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";

export default {
    name: "QuestionsView",

    components: {
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
        TopicalQuestions,
        StrainGuideVisit,
        ArticlesVisit
    },

    emits: [
        "activity-recorded"
    ],

    data() {
        return {

            // Track question topics viewed during this page visit
            questionObserver: null,
            viewedQuestionTopics: new Set()

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

            const questionSections = [
                {
                    id: "dispensaries",
                    value: "dispensary"
                },
                {
                    id: "cannabis",
                    value: "cannabis"
                },
                {
                    id: "cbd",
                    value: "cbd"
                },
                {
                    id: "delta9",
                    value: "delta-9"
                },
                {
                    id: "flower",
                    value: "flower"
                },
                {
                    id: "wax",
                    value: "wax"
                },
                {
                    id: "oil",
                    value: "oil"
                },
                {
                    id: "tincture",
                    value: "tincture"
                },
                {
                    id: "smoking",
                    value: "smoking"
                },
                {
                    id: "vaporizing",
                    value: "vaporizing"
                },
                {
                    id: "edibles",
                    value: "edible"
                },
                {
                    id: "topicals",
                    value: "topical"
                }
            ];

            this.questionObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (!entry.isIntersecting) {
                                    return;
                                }

                                const questionTopic =
                                    questionSections.find(
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

            questionSections.forEach(
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