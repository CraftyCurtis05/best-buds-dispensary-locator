<!-- Cannabis Safety View Display -->
<template>

    <div
        id="safety-view"
        aria-labelledby="safety-heading"
    >

        <!-- =================================================
             Safety Page Introduction
             ================================================= -->

        <header id="safety-header">

            <!-- Header Content -->
            <div class="safety-header-content">

                <p class="safety-eyebrow">
                    Best Buds Safety
                </p>

                <h1 id="safety-heading">
                    Cannabis Safety

                    <span>
                        Know What Matters
                    </span>
                </h1>

                <p class="safety-introduction">
                    Cannabis products can differ in potency,
                    ingredients, how they are used, how quickly
                    effects begin, and how long those effects
                    may last.
                </p>

                <p class="safety-description">
                    Explore practical information about THC,
                    CBD, smoking, and topical products,
                    including common risks, safer-use
                    considerations, and situations where
                    additional caution may be important.
                </p>


                <!-- Safety Topics -->
                <div
                    class="safety-topic-pills"
                    aria-label="Safety topics covered"
                >

                    <span>
                        THC
                    </span>

                    <span>
                        CBD
                    </span>

                    <span>
                        Smoking
                    </span>

                    <span>
                        Topicals
                    </span>

                </div>

            </div>


            <!-- Decorative Safety Graphic -->
            <div
                class="safety-header-visual"
                aria-hidden="true"
            >

                <span class="safety-ring ring-large"></span>
                <span class="safety-ring ring-medium"></span>
                <span class="safety-ring ring-small"></span>


                <div class="safety-center">

                    <span>
                        4
                    </span>

                    <small>
                        Safety Guides
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Safety Information
             ================================================= -->

        <aside
            id="safety-information"
            aria-labelledby="safety-information-heading"
        >

            <span
                class="safety-information-icon"
                aria-hidden="true"
            >
                !
            </span>


            <div>

                <h2 id="safety-information-heading">
                    Safety Depends on More Than the Product
                </h2>

                <p>
                    Potency, amount used, route of use,
                    frequency, age, health history,
                    medications, other substances, and the
                    setting can all affect risk.
                </p>

                <p>
                    Use these guides as educational
                    information, not as a substitute for
                    personalized medical advice.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Safety Navigation
             ================================================= -->

        <OnThisPage
            :topics="safetyTopics"
            heading="Explore Safety Topics"
        />


        <!-- =================================================
             Safety Guides
             ================================================= -->

        <section
            id="safety-tips"
            aria-labelledby="safety-tips-heading"
        >

            <!-- Section Introduction -->
            <header class="safety-section-header">

                <p class="safety-section-label">
                    Safety Guides
                </p>

                <h2 id="safety-tips-heading">
                    Cannabis Safety Information
                </h2>

                <p>
                    Explore each topic for practical
                    information about risks, product
                    differences, common misconceptions,
                    and safer-use considerations.
                </p>

            </header>


            <!-- THC Safety -->
            <ThcSafety />


            <!-- CBD Safety -->
            <CbdSafety />


            <!-- Smoking Safety -->
            <SmokingSafety />


            <!-- Topical Safety -->
            <TopicalSafety />

        </section>


        <!-- =================================================
             Additional Safety Considerations
             ================================================= -->

        <section
            id="additional-safety"
            aria-labelledby="additional-safety-heading"
        >

            <!-- Section Heading -->
            <header class="additional-safety-header">

                <p class="safety-section-label">
                    Extra Caution
                </p>

                <h2 id="additional-safety-heading">
                    When Extra Caution May Be Important
                </h2>

                <p>
                    Some situations can involve additional
                    risks or make professional guidance more
                    important.
                </p>

            </header>


            <!-- Additional Considerations -->
            <ul class="additional-safety-list">

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
                    Prescription medications or other
                    substances that may interact with cannabis
                    or CBD.
                </li>

                <li>
                    Frequent use, difficulty cutting back, or
                    other signs of cannabis use disorder.
                </li>

                <li>
                    Driving, operating machinery, or
                    performing tasks that require full
                    attention and coordination.
                </li>

                <li>
                    Children or pets who could accidentally
                    reach cannabis products.
                </li>

            </ul>


            <p class="additional-safety-note">
                Safety depends on more than the product
                itself. Health history, age, medications,
                amount used, frequency of use, and other
                substances can all matter.
            </p>

        </section>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import ThcSafety
    from "../components/safety/ThcSafety.vue";

import CbdSafety
    from "../components/safety/CbdSafety.vue";

import SmokingSafety
    from "../components/safety/SmokingSafety.vue";

import TopicalSafety
    from "../components/safety/TopicalSafety.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";


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

            // Track safety topics viewed
            // during this page visit
            safetyObserver:
                null,

            viewedSafetyTopics:
                new Set(),


            // Safety topics used for
            // navigation and activity tracking
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

        // Watch safety sections as
        // the user explores the page
        observeSafetySections() {

            this.safetyObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (
                                    !entry.isIntersecting
                                ) {
                                    return;
                                }

                                const safetyTopic =
                                    this.safetyTopics.find(
                                        (item) => {

                                            return (
                                                item.id
                                                === entry.target.id
                                            );

                                        }
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


        // Record a safety topic once
        // during this page visit
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
                    USER_ACTIVITY_TYPES
                        .SAFETY_VIEW,

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

/* =========================================================
   Safety View
   ========================================================= */

#safety-view {
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
   Safety Header
   ========================================================= */

#safety-header {
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
.safety-header-content {
    max-width: 47rem;
}


/* Header Eyebrow */
.safety-eyebrow,
.safety-section-label {
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
#safety-heading {
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
#safety-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.safety-introduction {
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
.safety-description {
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
   Safety Topic Pills
   ========================================================= */

.safety-topic-pills {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Topic Pill */
.safety-topic-pills span {
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
   Decorative Safety Graphic
   ========================================================= */

.safety-header-visual {
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


/* Safety Rings */
.safety-ring {
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


/* Safety Center */
.safety-center {
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


/* Safety Count */
.safety-center span {
    font-size: 1.45rem;

    font-weight: 500;
}


/* Safety Count Label */
.safety-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.54rem;

    font-weight: 600;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


/* =========================================================
   Safety Information
   ========================================================= */

#safety-information {
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


/* Safety Information Icon */
.safety-information-icon {
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
#safety-information h2 {
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
#safety-information p {
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
#safety-information p:last-child {
    margin-bottom: 0;
}


/* =========================================================
   Safety Tips Section
   ========================================================= */

#safety-tips {
    padding-top:
        clamp(
            2rem,
            5vw,
            3.5rem
        );
}


/* Section Header */
.safety-section-header {
    max-width: 46rem;

    margin-bottom: 1rem;
}


/* Section Heading */
.safety-section-header h2,
.additional-safety-header h2 {
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
.safety-section-header
> p:last-child,
.additional-safety-header
> p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Additional Safety
   ========================================================= */

#additional-safety {
    margin-top:
        clamp(
            3rem,
            8vw,
            5rem
        );

    padding:
        clamp(
            1.5rem,
            5vw,
            2.5rem
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

    border-left:
        3px solid
        var(--color-danger);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 14px 34px
        var(--color-shadow);
}


/* Additional Safety Header */
.additional-safety-header {
    max-width: 48rem;

    margin-bottom: 1.4rem;
}


/* =========================================================
   Additional Safety List
   ========================================================= */

.additional-safety-list {
    display: grid;

    grid-template-columns:
        repeat(
            2,
            minmax(
                0,
                1fr
            )
        );

    gap: 0.7rem;

    padding: 0;

    margin:
        0
        0
        1.3rem;

    list-style: none;
}


/* Additional Safety Item */
.additional-safety-list li {
    position: relative;

    padding:
        0.85rem
        0.9rem
        0.85rem
        2.15rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);

    color:
        var(--color-text-soft);

    font-size: 0.8rem;

    line-height: 1.55;
}


/* Additional Safety Marker */
.additional-safety-list li::before {
    position: absolute;

    top: 0.85rem;
    left: 0.85rem;

    display: grid;
    place-items: center;

    width: 1.05rem;
    height: 1.05rem;

    background:
        var(--color-gold-soft);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.62rem;

    font-weight: 700;

    content: "!";
}


/* Additional Safety Note */
.additional-safety-note {
    margin: 0;

    padding-top: 1rem;

    border-top:
        1px solid
        var(--color-border);

    color:
        var(--color-text-soft);

    font-size: 0.82rem;

    line-height: 1.65;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 849.98px) {

    #safety-header {
        grid-template-columns: 1fr;
    }


    .safety-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #safety-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #safety-header {
        padding:
            2rem
            1.4rem;
    }


    .safety-header-visual {
        display: none;
    }


    #safety-information {
        padding: 1rem;
    }


    .additional-safety-list {
        grid-template-columns: 1fr;
    }

}

</style>