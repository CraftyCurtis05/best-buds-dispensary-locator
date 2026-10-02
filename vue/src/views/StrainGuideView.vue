<!-- Strain Guide View Display -->
<template>

    <div
        id="strain-guide-view"
        aria-labelledby="strain-guide-heading"
    >

        <!-- =================================================
             Guide Page Introduction
             ================================================= -->

        <header id="strain-guide-header">

            <!-- Header Content -->
            <div class="strain-header-content">

                <p class="strain-eyebrow">
                    Best Buds Plant Guide
                </p>

                <h1 id="strain-guide-heading">
                    Strains &amp; Terpenes

                    <span>
                        Look Beyond the Name
                    </span>
                </h1>

                <p class="strain-introduction">
                    Cannabis products are often described
                    using strain names, indica, sativa,
                    hybrid, cannabinoid content, and terpene
                    profiles.
                </p>

                <p class="strain-description">
                    These labels can help describe a
                    product, but they do not guarantee a
                    specific effect. Use this guide to
                    understand the information behind the
                    name and learn what else may be useful
                    when comparing cannabis products.
                </p>


                <!-- Guide Topics -->
                <div
                    class="strain-topic-pills"
                    aria-label="Strain and terpene guide topics"
                >

                    <span>
                        Strains
                    </span>

                    <span>
                        Indica
                    </span>

                    <span>
                        Sativa
                    </span>

                    <span>
                        Hybrid
                    </span>

                    <span>
                        Cannabinoids
                    </span>

                    <span>
                        Terpenes
                    </span>

                </div>

            </div>


            <!-- Decorative Guide Graphic -->
            <div
                class="strain-header-visual"
                aria-hidden="true"
            >

                <span class="strain-ring ring-large"></span>
                <span class="strain-ring ring-medium"></span>
                <span class="strain-ring ring-small"></span>


                <div class="strain-center">

                    <span>
                        2
                    </span>

                    <small>
                        Guides
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Guide Information
             ================================================= -->

        <aside
            id="strain-guide-information"
            aria-labelledby="
                strain-guide-information-heading
            "
        >

            <span
                class="strain-information-icon"
                aria-hidden="true"
            >
                i
            </span>


            <div>

                <h2 id="strain-guide-information-heading">
                    Labels Are Clues, Not Guarantees
                </h2>

                <p>
                    A strain name, indica or sativa label,
                    THC percentage, or individual terpene
                    can tell you something about a product,
                    but none of them can predict exactly how
                    that product will affect you.
                </p>

                <p>
                    The actual product, its cannabinoid and
                    terpene profile, product type, amount
                    used, and individual differences all
                    matter.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Main Guide Navigation
             ================================================= -->

        <OnThisPage
            :topics="guideSections"
            heading="Explore the Guides"
        />


        <!-- =================================================
             Strain Guide
             ================================================= -->

        <section
            id="strain-guide"
            class="main-guide-section"
            aria-labelledby="
                strain-guide-section-heading
            "
        >

            <!-- Section Introduction -->
            <header class="main-guide-header">

                <p class="main-guide-label">
                    Guide 01
                </p>

                <h2 id="strain-guide-section-heading">
                    Strain Guide
                </h2>

                <p>
                    Learn how strain names and indica,
                    sativa, and hybrid labels are commonly
                    used, what those labels can tell you,
                    and what they cannot reliably predict.
                </p>

            </header>


            <!-- Strain Guide Navigation -->
            <OnThisPage
                :topics="strainGuideSections"
                heading="Strain Guide Topics"
            />


            <!-- Strain Education -->
            <StrainGuide />

        </section>


        <!-- =================================================
             Terpene Guide
             ================================================= -->

        <section
            id="terpene-guide"
            class="main-guide-section"
            aria-labelledby="
                terpene-guide-section-heading
            "
        >

            <!-- Section Introduction -->
            <header class="main-guide-header">

                <p class="main-guide-label">
                    Guide 02
                </p>

                <h2 id="terpene-guide-section-heading">
                    Terpene Guide
                </h2>

                <p>
                    Learn what terpenes are, how terpene
                    profiles describe cannabis products,
                    and why popular terpene claims should
                    not be treated as guaranteed effects.
                </p>

            </header>


            <!-- Terpene Guide Navigation -->
            <OnThisPage
                :topics="terpeneGuideSections"
                heading="Terpene Guide Topics"
            />


            <!-- Terpene Education -->
            <TerpeneGuide />

        </section>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import StrainGuide
    from "../components/strain-guide/StrainGuide.vue";

import TerpeneGuide
    from "../components/strain-guide/TerpeneGuide.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";


export default {

    name: "StrainGuideView",

    components: {
        OnThisPage,
        StrainGuide,
        TerpeneGuide
    },

    emits: [
        "activity-recorded"
    ],

    data() {

        return {

            // Track strain guide topics viewed
            // during this page visit
            strainGuideObserver:
                null,

            viewedStrainGuideTopics:
                new Set(),


            // Main guide sections used
            // for page navigation
            guideSections: [

                {
                    id: "strain-guide",
                    label: "Strain 101"
                },

                {
                    id: "terpene-guide",
                    label: "Terpene 101"
                }

            ],


            // Strain guide sections
            // used for navigation
            strainGuideSections: [

                {
                    id: "indica",
                    label: "Indica"
                },

                {
                    id: "sativa",
                    label: "Sativa"
                },

                {
                    id: "hybrid",
                    label: "Hybrid"
                }

            ],


            // Terpene guide sections
            // used for navigation
            terpeneGuideSections: [

                {
                    id: "humulene",
                    label: "Humulene"
                },

                {
                    id: "limonene",
                    label: "Limonene"
                },

                {
                    id: "myrcene",
                    label: "Myrcene"
                },

                {
                    id: "caryophyllene",
                    label: "Beta-Caryophyllene"
                },

                {
                    id: "linalool",
                    label: "Linalool"
                },

                {
                    id: "alpha-pinene",
                    label: "Alpha-Pinene"
                },

                {
                    id: "beta-pinene",
                    label: "Beta-Pinene"
                },

                {
                    id: "terpinolene",
                    label: "Terpinolene"
                },

                {
                    id: "ocimene",
                    label: "Ocimene"
                },

                {
                    id: "eucalyptol",
                    label: "Eucalyptol"
                },

                {
                    id: "nerolidol",
                    label: "Nerolidol"
                },

                {
                    id: "borneol",
                    label: "Borneol"
                },

                {
                    id: "camphene",
                    label: "Camphene"
                }

            ]

        };

    },

    mounted() {

        this.observeStrainGuideSections();

    },

    beforeUnmount() {

        if (this.strainGuideObserver) {

            this.strainGuideObserver.disconnect();

        }

    },

    methods: {

        // Watch the two main guide sections
        // as the user explores the page
        observeStrainGuideSections() {

            const trackedSections = [

                {
                    id: "strain-101",
                    value: "strain-guide"
                },

                {
                    id: "terpene-101",
                    value: "terpenes"
                }

            ];


            this.strainGuideObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (
                                    !entry.isIntersecting
                                ) {
                                    return;
                                }

                                const guideTopic =
                                    trackedSections.find(
                                        (item) => {

                                            return (
                                                item.id
                                                === entry.target.id
                                            );

                                        }
                                    );

                                if (!guideTopic) {
                                    return;
                                }

                                this.recordEducationView(
                                    guideTopic.value
                                );

                            }
                        );

                    },
                    {
                        threshold: 0.1
                    }
                );


            trackedSections.forEach(
                (guideTopic) => {

                    const section =
                        document.getElementById(
                            guideTopic.id
                        );

                    if (section) {

                        this.strainGuideObserver.observe(
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
                this.viewedStrainGuideTopics.has(
                    educationTopic
                )
            ) {
                return;
            }

            this.viewedStrainGuideTopics.add(
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

                    this.viewedStrainGuideTopics.delete(
                        educationTopic
                    );

                });

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Strain Guide View
   ========================================================= */

#strain-guide-view {
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

#strain-guide-header {
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
.strain-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.strain-eyebrow,
.main-guide-label {
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
#strain-guide-heading {
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
#strain-guide-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.strain-introduction {
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
.strain-description {
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

.strain-topic-pills {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Topic Pill */
.strain-topic-pills span {
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

.strain-header-visual {
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


/* Decorative Rings */
.strain-ring {
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
.strain-center {
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


/* Guide Count */
.strain-center span {
    font-size: 1.45rem;
    font-weight: 500;
}


/* Guide Label */
.strain-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.56rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


/* =========================================================
   Guide Information
   ========================================================= */

#strain-guide-information {
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
.strain-information-icon {
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
#strain-guide-information h2 {
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
#strain-guide-information p {
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
#strain-guide-information
p:last-child {
    margin-bottom: 0;
}


/* =========================================================
   Main Guide Section
   ========================================================= */

.main-guide-section {
    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


/* Second Main Guide */
#terpene-guide {
    margin-top: 1rem;

    border-top:
        1px solid
        var(--color-border);
}


/* Main Guide Header */
.main-guide-header {
    max-width: 48rem;

    margin-bottom: 1.5rem;
}


/* Guide Heading */
.main-guide-header h2 {
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
.main-guide-header
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

    #strain-guide-header {
        grid-template-columns: 1fr;
    }


    .strain-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #strain-guide-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #strain-guide-header {
        padding:
            2rem
            1.4rem;
    }


    .strain-header-visual {
        display: none;
    }


    #strain-guide-information {
        padding: 1rem;
    }

}

</style>