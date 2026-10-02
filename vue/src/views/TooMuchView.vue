<!-- Too Much Cannabis View Display -->
<template>

    <div
        id="too-much-view"
        aria-labelledby="too-much-heading"
    >

        <!-- =================================================
             Page Introduction
             ================================================= -->

        <header id="too-much-header">

            <!-- Header Content -->
            <div class="too-much-header-content">

                <p class="too-much-eyebrow">
                    Best Buds Safety Guide
                </p>

                <h1 id="too-much-heading">
                    Too Much Cannabis

                    <span>
                        What To Do Next
                    </span>
                </h1>

                <p class="too-much-introduction">
                    Too much THC can cause uncomfortable
                    effects such as anxiety, panic,
                    confusion, dizziness, nausea, paranoia,
                    or a fast heart rate.
                </p>

                <p class="too-much-description">
                    Many uncomfortable cannabis reactions
                    improve with time, but serious symptoms
                    can require medical help. This guide
                    explains what to look for, what to do
                    next, and ways to get through an
                    uncomfortable experience.
                </p>


                <!-- Guide Topics -->
                <div
                    class="too-much-topics"
                    aria-label="Cannabis overuse guide topics"
                >

                    <span>
                        Signs &amp; Symptoms
                    </span>

                    <span>
                        What To Do
                    </span>

                    <span>
                        Coping
                    </span>

                </div>

            </div>


            <!-- Decorative Guide Graphic -->
            <div
                class="too-much-header-visual"
                aria-hidden="true"
            >

                <span class="too-much-ring ring-large"></span>
                <span class="too-much-ring ring-medium"></span>
                <span class="too-much-ring ring-small"></span>


                <div class="too-much-center">

                    <span>
                        3
                    </span>

                    <small>
                        Steps
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Guide Direction
             ================================================= -->

        <aside
            id="too-much-start"
            aria-labelledby="too-much-start-heading"
        >

            <span
                class="too-much-start-icon"
                aria-hidden="true"
            >
                !
            </span>


            <div>

                <h2 id="too-much-start-heading">
                    Start With What You Need Right Now
                </h2>

                <p>
                    If you're trying to understand what
                    you're feeling, start with Signs &amp;
                    Symptoms. If you already know you used
                    too much, jump directly to What To Do
                    Now.
                </p>


                <!-- Quick Start Links -->
                <div class="too-much-start-links">

                    <a
                        href="#cannabis-overuse-symptoms"
                    >
                        Signs &amp; Symptoms
                    </a>

                    <a
                        href="#cannabis-overuse-guide"
                    >
                        What To Do Now
                    </a>

                </div>

            </div>

        </aside>


        <!-- =================================================
             Overuse Navigation
             ================================================= -->

        <OnThisPage
            :topics="overuseTopics"
            heading="Explore This Guide"
        />


        <!-- =================================================
             Cannabis Overuse Guide
             ================================================= -->

        <section
            id="cannabis-overuse"
            aria-labelledby="cannabis-overuse-heading"
        >

            <!-- Section Introduction -->
            <header class="overuse-section-header">

                <p class="overuse-section-label">
                    Cannabis Overuse
                </p>

                <h2 id="cannabis-overuse-heading">
                    Too Much Cannabis Guide
                </h2>

                <p>
                    Work through the guide in order or jump
                    directly to the section that matches what
                    you need right now.
                </p>

            </header>


            <!-- Signs and Symptoms -->
            <CannabisOveruseSymptoms />


            <!-- What To Do Now -->
            <CannabisOveruseGuide />


            <!-- Coping Strategies -->
            <CannabisOveruseCoping />

        </section>


        <!-- =================================================
             Health Review Date
             ================================================= -->

        <p class="health-review-date">
            Health and safety information last reviewed:
            October 2026
        </p>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import CannabisOveruseSymptoms
    from "../components/too-much/CannabisOveruseSymptoms.vue";

import CannabisOveruseGuide
    from "../components/too-much/CannabisOveruseGuide.vue";

import CannabisOveruseCoping
    from "../components/too-much/CannabisOveruseCoping.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";


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

            // Main cannabis overuse topics
            // shown on this page
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

        // Record that the user explored
        // cannabis overuse education
        recordEducationView() {

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES
                        .EDUCATION_VIEW,

                    "too-much"
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {

                    /*
                     * Activity tracking should not
                     * block education content.
                     */

                });

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Too Much Cannabis View
   ========================================================= */

#too-much-view {
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
   Page Header
   ========================================================= */

#too-much-header {
    display: grid;

    grid-template-columns:
        minmax(
            0,
            1.35fr
        )
        minmax(
            15rem,
            0.65fr
        );

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
.too-much-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.too-much-eyebrow,
.overuse-section-label {
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


/* Main Heading */
#too-much-heading {
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
#too-much-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.too-much-introduction {
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
.too-much-description {
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
   Topic Pills
   ========================================================= */

.too-much-topics {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Topic Pill */
.too-much-topics span {
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
   Decorative Header Graphic
   ========================================================= */

.too-much-header-visual {
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


/* Rings */
.too-much-ring {
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


/* Center */
.too-much-center {
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


/* Center Number */
.too-much-center span {
    font-size: 1.45rem;
    font-weight: 500;
}


/* Center Label */
.too-much-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.56rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


/* =========================================================
   Start Here Panel
   ========================================================= */

#too-much-start {
    display: flex;
    align-items: flex-start;

    gap: 0.9rem;

    margin-top: 1rem;

    padding:
        1rem
        1.2rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-left:
        3px solid
        var(--color-gold);

    border-radius:
        var(--border-radius-medium);
}


/* Start Icon */
.too-much-start-icon {
    display: grid;
    place-items: center;

    width: 1.9rem;
    height: 1.9rem;

    flex-shrink: 0;

    background:
        var(--color-gold-soft);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.75rem;
    font-weight: 700;
}


/* Start Heading */
#too-much-start h2 {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text);

    font-size: 0.88rem;
    font-weight: 600;
}


/* Start Text */
#too-much-start p {
    max-width: 46rem;

    margin:
        0
        0
        0.75rem;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.6;
}


/* =========================================================
   Quick Start Links
   ========================================================= */

.too-much-start-links {
    display: flex;
    flex-wrap: wrap;

    gap: 0.5rem;
}


/* Quick Start Link */
.too-much-start-links a {
    padding:
        0.4rem
        0.7rem;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.72rem;
    font-weight: 600;

    text-decoration: none;
}


/* Quick Start Hover */
.too-much-start-links a:hover {
    border-color:
        var(--color-border-strong);

    background:
        var(--color-surface-strong);
}


/* =========================================================
   Overuse Guide
   ========================================================= */

#cannabis-overuse {
    padding-top:
        clamp(
            2rem,
            5vw,
            3.5rem
        );
}


/* Section Header */
.overuse-section-header {
    max-width: 48rem;

    margin-bottom: 1rem;
}


/* Guide Heading */
.overuse-section-header h2 {
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


/* Guide Description */
.overuse-section-header
> p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 849.98px) {

    #too-much-header {
        grid-template-columns: 1fr;
    }


    .too-much-header-visual {
        width: 13rem;
    }

}


@media (max-width: 575.98px) {

    #too-much-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #too-much-header {
        padding:
            2rem
            1.4rem;
    }


    .too-much-header-visual {
        display: none;
    }


    #too-much-start {
        padding: 1rem;
    }


    .too-much-start-links {
        flex-direction: column;
        align-items: flex-start;
    }

}

</style>