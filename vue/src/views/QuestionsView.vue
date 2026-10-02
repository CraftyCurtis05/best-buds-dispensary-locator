<!-- Common Questions View Display -->
<template>

    <div
        id="questions-view"
        aria-labelledby="questions-heading"
    >

        <!-- =================================================
             Questions Page Introduction
             ================================================= -->

        <header id="questions-header">

            <!-- Header Content -->
            <div class="questions-header-content">

                <p class="questions-eyebrow">
                    Best Buds Q&amp;A
                </p>

                <h1 id="questions-heading">
                    Common Cannabis

                    <span>
                        Questions
                    </span>
                </h1>

                <p class="questions-introduction">
                    Cannabis terminology, products, effects,
                    safety information, and laws can become
                    confusing quickly.
                </p>

                <p class="questions-description">
                    Explore straightforward answers covering
                    cannabis basics, cannabinoids,
                    dispensaries, products, consumption
                    methods, safety, and other commonly asked
                    questions.
                </p>


                <!-- Question Categories -->
                <div
                    class="question-categories"
                    aria-label="Topics covered"
                >

                    <span>
                        Cannabis
                    </span>

                    <span>
                        CBD &amp; THC
                    </span>

                    <span>
                        Products
                    </span>

                    <span>
                        Consumption
                    </span>

                    <span>
                        Dispensaries
                    </span>

                    <span>
                        Safety
                    </span>

                </div>

            </div>


            <!-- Decorative Q&A Graphic -->
            <div
                class="questions-header-visual"
                aria-hidden="true"
            >

                <span class="question-ring ring-large"></span>
                <span class="question-ring ring-medium"></span>
                <span class="question-ring ring-small"></span>


                <div class="questions-center">

                    <span>
                        {{ questionsSections.length }}
                    </span>

                    <small>
                        Topic Guides
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Questions Information
             ================================================= -->

        <aside
            id="questions-information"
            aria-labelledby="
                questions-information-heading
            "
        >

            <span
                class="questions-information-icon"
                aria-hidden="true"
            >
                ?
            </span>


            <div>

                <h2 id="questions-information-heading">
                    Start With the Question You Have
                </h2>

                <p>
                    You do not need to read this page from
                    beginning to end. Use the topic navigation
                    below to jump directly to the area that
                    interests you.
                </p>

                <p>
                    Where health, safety, or legal information
                    is involved, Best Buds also notes when the
                    information was last reviewed.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Questions Navigation
             ================================================= -->

        <OnThisPage
            :topics="questionsSections"
            heading="Explore Question Topics"
        />


        <!-- =================================================
             Questions and Answers
             ================================================= -->

        <section
            id="questions"
            aria-labelledby="questions-topics-heading"
        >

            <!-- Section Introduction -->
            <header class="questions-section-header">

                <p class="questions-section-label">
                    Cannabis Q&amp;A
                </p>

                <h2 id="questions-topics-heading">
                    Questions &amp; Answers
                </h2>

                <p>
                    Browse by topic or use the quick
                    navigation above to jump directly to a
                    particular section.
                </p>

            </header>


            <!-- Dispensary Questions -->
            <DispensaryQuestions />


            <!-- General Cannabis Questions -->
            <CannabisQuestions />


            <!-- CBD Questions -->
            <CbdQuestions />


            <!-- Delta-9 THC Questions -->
            <Delta9Questions />


            <!-- Flower Questions -->
            <FlowerQuestions />


            <!-- Wax and Concentrate Questions -->
            <WaxQuestions />


            <!-- Cannabis Oil Questions -->
            <OilQuestions />


            <!-- Tincture Questions -->
            <TinctureQuestions />


            <!-- Smoking Questions -->
            <SmokingQuestions />


            <!-- Vaporizing Questions -->
            <VaporizingQuestions />


            <!-- Edible Questions -->
            <EdibleQuestions />


            <!-- Topical Questions -->
            <TopicalQuestions />

        </section>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import DispensaryQuestions
    from "../components/questions/DispensaryQuestions.vue";

import CannabisQuestions
    from "../components/questions/CannabisQuestions.vue";

import CbdQuestions
    from "../components/questions/CbdQuestions.vue";

import Delta9Questions
    from "../components/questions/Delta9Questions.vue";

import FlowerQuestions
    from "../components/questions/FlowerQuestions.vue";

import WaxQuestions
    from "../components/questions/WaxQuestions.vue";

import OilQuestions
    from "../components/questions/OilQuestions.vue";

import TinctureQuestions
    from "../components/questions/TinctureQuestions.vue";

import SmokingQuestions
    from "../components/questions/SmokingQuestions.vue";

import VaporizingQuestions
    from "../components/questions/VaporizingQuestions.vue";

import EdibleQuestions
    from "../components/questions/EdibleQuestions.vue";

import TopicalQuestions
    from "../components/questions/TopicalQuestions.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";


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

            // Track question topics viewed
            // during this page visit
            questionObserver:
                null,

            viewedQuestionTopics:
                new Set(),


            // Question sections used for
            // navigation and activity tracking
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
                    label: "Wax & Concentrates",
                    value: "wax"
                },

                {
                    id: "oil",
                    label: "Cannabis Oil",
                    value: "oil"
                },

                {
                    id: "tincture",
                    label: "Tinctures",
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

        // Watch question sections as
        // the user explores the page
        observeQuestionSections() {

            this.questionObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (
                                    !entry.isIntersecting
                                ) {
                                    return;
                                }

                                const questionTopic =
                                    this.questionsSections.find(
                                        (item) => {

                                            return (
                                                item.id
                                                === entry.target.id
                                            );

                                        }
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


        // Record an education topic once
        // during this page visit
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
                    USER_ACTIVITY_TYPES
                        .EDUCATION_VIEW,

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

/* =========================================================
   Questions View
   ========================================================= */

#questions-view {
    width:
        min(
            calc(100% - 2rem),
            76rem
        );

    margin:
        0
        auto;

    padding:
        2.5rem
        0
        5rem;
}


/* =========================================================
   Questions Header
   ========================================================= */

#questions-header {
    display: grid;

    grid-template-columns:
        minmax(0, 1.35fr)
        minmax(15rem, 0.65fr);

    align-items: center;

    gap: 3rem;

    padding:
        clamp(
            2rem,
            6vw,
            4rem
        );

    background:
        linear-gradient(
            135deg,
            var(--color-surface),
            var(--color-surface-soft)
        );

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 18px 45px
        var(--color-shadow);
}


/* Header Content */
.questions-header-content {
    max-width: 47rem;
}


/* Header Eyebrow */
.questions-eyebrow,
.questions-section-label {
    margin:
        0
        0
        0.7rem;

    color:
        var(--color-gold-dark);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.17em;

    text-transform: uppercase;
}


/* Page Heading */
#questions-heading {
    margin:
        0
        0
        1.25rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            2.4rem,
            6vw,
            4.5rem
        );

    font-weight: 500;

    line-height: 1;

    letter-spacing: -0.045em;
}


/* Heading Accent */
#questions-heading span {
    display: block;

    color:
        var(--color-primary);
}


/* Introduction */
.questions-introduction {
    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text);

    font-size: 1.03rem;

    line-height: 1.7;
}


/* Description */
.questions-description {
    margin:
        0
        0
        1.4rem;

    color:
        var(--color-text-soft);

    font-size: 0.9rem;

    line-height: 1.7;
}


/* =========================================================
   Question Categories
   ========================================================= */

.question-categories {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Category */
.question-categories span {
    padding:
        0.36rem
        0.65rem;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.62rem;
    font-weight: 600;

    letter-spacing: 0.07em;

    text-transform: uppercase;
}


/* =========================================================
   Decorative Question Graphic
   ========================================================= */

.questions-header-visual {
    position: relative;

    display: grid;
    place-items: center;

    width:
        min(
            100%,
            18rem
        );

    aspect-ratio: 1;

    margin:
        0
        auto;
}


/* Question Rings */
.question-ring {
    position: absolute;

    border:
        1px solid
        var(--color-gold-soft);

    border-radius: 50%;
}


.ring-large {
    width: 100%;
    height: 100%;
}


.ring-medium {
    width: 72%;
    height: 72%;
}


.ring-small {
    width: 44%;
    height: 44%;

    border-color:
        var(--color-gold);
}


/* Question Center */
.questions-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    width: 7.5rem;
    height: 7.5rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-background);

    box-shadow:
        0 16px 36px
        var(--color-shadow-strong);
}


/* Question Count */
.questions-center span {
    font-size: 1.45rem;
    font-weight: 500;
}


/* Question Count Label */
.questions-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.54rem;
    font-weight: 600;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


/* =========================================================
   Questions Information
   ========================================================= */

#questions-information {
    display: flex;
    align-items: flex-start;

    gap: 0.85rem;

    margin-top: 1rem;

    padding:
        1rem
        1.2rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);
}


/* Information Icon */
.questions-information-icon {
    display: grid;
    place-items: center;

    width: 1.9rem;
    height: 1.9rem;

    flex-shrink: 0;

    background:
        var(--color-gold-soft);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.75rem;
    font-weight: 700;
}


/* Information Heading */
#questions-information h2 {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text);

    font-size: 0.86rem;
    font-weight: 600;
}


/* Information Text */
#questions-information p {
    margin:
        0
        0
        0.3rem;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.6;
}


/* Last Information Paragraph */
#questions-information p:last-child {
    margin-bottom: 0;
}


/* =========================================================
   Questions Section
   ========================================================= */

#questions {
    padding-top:
        clamp(
            2rem,
            5vw,
            3.5rem
        );
}


/* Questions Section Header */
.questions-section-header {
    max-width: 46rem;

    margin-bottom: 1rem;
}


/* Section Heading */
.questions-section-header h2 {
    margin:
        0
        0
        0.65rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.8rem,
            4vw,
            2.7rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.03em;
}


/* Section Description */
.questions-section-header
> p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 849.98px) {

    #questions-header {
        grid-template-columns: 1fr;
    }


    .questions-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #questions-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #questions-header {
        padding:
            2rem
            1.4rem;
    }


    .questions-header-visual {
        display: none;
    }


    #questions-information {
        padding: 1rem;
    }

}

</style>