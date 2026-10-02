<!-- Tips and Tricks View Display -->
<template>

    <div
        id="tips-tricks-view"
        aria-labelledby="tips-tricks-heading"
    >

        <!-- =================================================
             Getting Started Introduction
             ================================================= -->

        <header id="tips-tricks-header">

            <!-- Header Content -->
            <div class="tips-header-content">

                <p class="tips-eyebrow">
                    Best Buds Getting Started Guide
                </p>

                <h1 id="tips-tricks-heading">
                    Getting Started

                    <span>
                        With Cannabis
                    </span>
                </h1>

                <p class="tips-introduction">
                    Cannabis can feel complicated when you're
                    learning about it for the first time.
                    Products, potency, labels, effects, safety,
                    and laws can all vary.
                </p>

                <p class="tips-description">
                    This guide brings the most useful starting
                    points together so you can explore the
                    topics that matter to you without needing
                    to understand everything at once.
                </p>


                <!-- Guide Topics -->
                <div
                    class="tips-topics"
                    aria-label="Getting started topics"
                >

                    <span>
                        Products
                    </span>

                    <span>
                        Labels
                    </span>

                    <span>
                        Safety
                    </span>

                    <span>
                        Edibles
                    </span>

                    <span>
                        Driving
                    </span>

                    <span>
                        Laws
                    </span>

                </div>

            </div>


            <!-- Decorative Guide Graphic -->
            <div
                class="tips-header-visual"
                aria-hidden="true"
            >

                <span class="tips-ring ring-large"></span>
                <span class="tips-ring ring-medium"></span>
                <span class="tips-ring ring-small"></span>


                <div class="tips-center">

                    <span>
                        {{ tipsTricksSections.length }}
                    </span>

                    <small>
                        Guide Topics
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Getting Started Note
             ================================================= -->

        <aside
            id="getting-started-note"
            aria-labelledby="
                getting-started-note-heading
            "
        >

            <span
                class="getting-started-note-icon"
                aria-hidden="true"
            >
                i
            </span>


            <div>

                <h2 id="getting-started-note-heading">
                    You Don't Need to Learn Everything at Once
                </h2>

                <p>
                    Start with the product, question, or
                    situation that brought you here. Each
                    guide connects to more detailed Best Buds
                    resources when you want to keep learning.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Tips & Tricks Navigation
             ================================================= -->

        <OnThisPage
            :topics="tipsTricksSections"
            heading="Explore This Guide"
        />


        <!-- =================================================
             Tips & Tricks Guide
             ================================================= -->

        <section
            id="tips-tricks"
            aria-labelledby="
                tips-tricks-guide-heading
            "
        >

            <!-- Section Introduction -->
            <header class="tips-section-header">

                <p class="tips-section-label">
                    Start Here
                </p>

                <h2 id="tips-tricks-guide-heading">
                    Cannabis Tips &amp; Tricks
                </h2>

                <p>
                    Browse the full guide or jump directly to
                    a topic above. Each section focuses on one
                    practical idea and points you toward more
                    detailed information when appropriate.
                </p>

            </header>


            <!-- Getting Started Guide -->
            <TipsTricksGuide />

        </section>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import TipsTricksGuide
    from "../components/tips-tricks/TipsTricksGuide.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";


export default {

    name: "TipsTricksView",

    components: {
        OnThisPage,
        TipsTricksGuide
    },

    emits: [
        "activity-recorded"
    ],

    data() {

        return {

            // Tips and tricks sections used
            // for page navigation
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

    mounted() {

        this.recordEducationView();

    },

    methods: {

        // Record that the user explored
        // the getting started guide
        recordEducationView() {

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES
                        .EDUCATION_VIEW,

                    "tips-tricks"
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
   Tips & Tricks View
   ========================================================= */

#tips-tricks-view {
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
   Getting Started Header
   ========================================================= */

#tips-tricks-header {
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
.tips-header-content {
    max-width: 47rem;
}


/* Header Eyebrow */
.tips-eyebrow,
.tips-section-label {
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
#tips-tricks-heading {
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
#tips-tricks-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.tips-introduction {
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
.tips-description {
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

.tips-topics {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Topic Pill */
.tips-topics span {
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
   Decorative Guide Graphic
   ========================================================= */

.tips-header-visual {
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


/* Guide Rings */
.tips-ring {
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


/* Guide Center */
.tips-center {
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


/* Topic Count */
.tips-center span {
    font-size: 1.45rem;
    font-weight: 500;
}


/* Topic Count Label */
.tips-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.54rem;
    font-weight: 600;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


/* =========================================================
   Getting Started Note
   ========================================================= */

#getting-started-note {
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


/* Note Icon */
.getting-started-note-icon {
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


/* Note Heading */
#getting-started-note h2 {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text);

    font-size: 0.86rem;
    font-weight: 600;
}


/* Note Text */
#getting-started-note p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.6;
}


/* =========================================================
   Guide Section
   ========================================================= */

#tips-tricks {
    padding-top:
        clamp(
            2rem,
            5vw,
            3.5rem
        );
}


/* Section Header */
.tips-section-header {
    max-width: 46rem;

    margin-bottom: 1.5rem;
}


/* Section Heading */
.tips-section-header h2 {
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
.tips-section-header
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

    #tips-tricks-header {
        grid-template-columns: 1fr;
    }


    .tips-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #tips-tricks-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #tips-tricks-header {
        padding:
            2rem
            1.4rem;
    }


    .tips-header-visual {
        display: none;
    }


    #getting-started-note {
        padding: 1rem;
    }

}

</style>