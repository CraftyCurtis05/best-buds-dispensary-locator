<!-- Cannabis Legality View Display -->
<template>

    <div
        id="legality-view"
        aria-labelledby="legality-heading"
    >

        <!-- =================================================
             Legality Page Introduction
             ================================================= -->

        <header id="legality-header">

            <!-- Header Content -->
            <div class="legality-header-content">

                <p class="legality-eyebrow">
                    Cannabis Law &amp; Policy
                </p>

                <h1 id="legality-heading">
                    Cannabis Laws
                    <span>
                        in the United States
                    </span>
                </h1>

                <p class="legality-introduction">
                    Cannabis laws differ across the United
                    States and can depend on the product,
                    activity, location, and whether cannabis
                    is being used through a medical program.
                </p>

                <p class="legality-description">
                    Use this page as a starting point and
                    verify important legal information with
                    current state, local, and federal
                    government sources.
                </p>

            </div>


            <!-- Decorative Legal Graphic -->
            <div
                class="legality-header-visual"
                aria-hidden="true"
            >

                <span class="legal-ring ring-large"></span>
                <span class="legal-ring ring-small"></span>

                <div class="legal-center">

                    <span>
                        U.S.
                    </span>

                    <small>
                        Cannabis Law
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Legal Reminder
             ================================================= -->

        <aside class="legality-reminder">

            <span
                class="legality-reminder-icon"
                aria-hidden="true"
            >
                !
            </span>

            <p>
                State legality does not mean cannabis is
                permitted everywhere. Rules may differ for
                age, possession, purchasing, home growing,
                public use, driving, employment, housing,
                federal property, and crossing state lines.
            </p>

        </aside>


        <!-- =================================================
             Federal Cannabis Status
             ================================================= -->

        <section
            id="federal-cannabis-status"
            aria-labelledby="
                federal-cannabis-status-heading
            "
        >

            <!-- Federal Status Heading -->
            <header class="legality-section-header">

                <p class="section-label">
                    Federal Law
                </p>

                <h2
                    id="
                        federal-cannabis-status-heading
                    "
                >
                    Federal Cannabis Status in 2026
                </h2>

            </header>


            <!-- Federal Status Card -->
            <div class="federal-status-card">

                <div class="federal-status-marker">

                    <span>
                        2026
                    </span>

                </div>


                <div class="federal-status-content">

                    <p>
                        Federal marijuana law changed in 2026,
                        but not all marijuana products are
                        treated the same way.
                    </p>

                    <p>
                        In April 2026, the U.S. Department of
                        Justice and Drug Enforcement
                        Administration placed FDA-approved
                        marijuana products and marijuana
                        products regulated under qualifying
                        state medical-marijuana licenses into
                        Schedule III of the federal Controlled
                        Substances Act.
                    </p>

                    <p>
                        The broader rescheduling process
                        should not be described as complete
                        unless the federal government issues
                        a final change.
                    </p>

                    <p>
                        State cannabis laws remain separate
                        from federal law and can be more
                        permissive or more restrictive
                        depending on the activity, product,
                        and location.
                    </p>


                    <!-- Review Date -->
                    <p class="legal-review-date">
                        Federal information last reviewed:
                        September 2026.
                    </p>

                </div>

            </div>

        </section>


        <!-- =================================================
             State Cannabis Laws
             ================================================= -->

        <section
            id="cannabis-legality"
            aria-labelledby="
                cannabis-legality-heading
            "
        >

            <!-- Section Heading -->
            <header class="legality-section-header">

                <p class="section-label">
                    State Laws
                </p>

                <h2 id="cannabis-legality-heading">
                    Cannabis Laws By State
                </h2>

                <p>
                    Select a state on the map to review its
                    general cannabis-program status and a
                    short summary.
                </p>

            </header>


            <!-- Interactive Legality Map -->
            <LegalityMap />

        </section>

    </div>

</template>


<script>

import LegalityMap
    from "../components/legality/LegalityMap.vue";

import UserActivityService
    from "../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../constants/userActivityTypes.js";


export default {

    name: "LegalityView",

    components: {
        LegalityMap
    },

    emits: [
        "activity-recorded"
    ],

    mounted() {

        this.recordEducationView();

    },

    methods: {

        // Record that the user explored
        // cannabis legality education
        recordEducationView() {

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES
                        .EDUCATION_VIEW,

                    "legality"
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
   Legality View
   ========================================================= */

#legality-view {
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
   Legality Header
   ========================================================= */

#legality-header {
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
.legality-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.legality-eyebrow,
.section-label {
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
#legality-heading {
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
#legality-heading span {
    display: block;

    color:
        var(--color-primary);
}


/* Introduction */
.legality-introduction {
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
.legality-description {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.9rem;

    line-height: 1.7;
}


/* =========================================================
   Header Graphic
   ========================================================= */

.legality-header-visual {
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
.legal-ring {
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


.ring-small {
    width: 65%;
    height: 65%;

    border-color:
        var(--color-gold);
}


/* Center */
.legal-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    width: 7.5rem;
    height: 7.5rem;

    background:
        var(--color-primary);

    border-radius: 50%;

    color:
        var(--color-background);

    box-shadow:
        0 16px 36px
        var(--color-shadow-strong);
}


/* Center Text */
.legal-center span {
    font-size: 1.2rem;
    font-weight: 600;
}


.legal-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.56rem;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


/* =========================================================
   Legal Reminder
   ========================================================= */

.legality-reminder {
    display: flex;
    align-items: flex-start;

    gap: 0.8rem;

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


/* Reminder Icon */
.legality-reminder-icon {
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


/* Reminder Text */
.legality-reminder p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.8rem;

    line-height: 1.6;
}


/* =========================================================
   Legality Sections
   ========================================================= */

#federal-cannabis-status,
#cannabis-legality {
    padding-top:
        clamp(
            3.5rem,
            8vw,
            5.5rem
        );
}


/* Section Header */
.legality-section-header {
    max-width: 45rem;

    margin-bottom: 1.5rem;
}


/* Section Heading */
.legality-section-header h2 {
    margin:
        0
        0
        0.65rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.7rem,
            4vw,
            2.5rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.03em;
}


/* Section Description */
.legality-section-header > p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Federal Status Card
   ========================================================= */

.federal-status-card {
    display: grid;

    grid-template-columns:
        auto
        minmax(
            0,
            1fr
        );

    gap: 1.5rem;

    padding:
        clamp(
            1.4rem,
            4vw,
            2rem
        );

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-left:
        3px solid
        var(--color-gold);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 12px 30px
        var(--color-shadow);
}


/* Status Marker */
.federal-status-marker {
    display: grid;
    place-items: center;

    width: 4rem;
    height: 4rem;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius: 50%;
}


/* Marker Text */
.federal-status-marker span {
    color:
        var(--color-primary);

    font-size: 0.7rem;
    font-weight: 600;

    letter-spacing: 0.06em;
}


/* Federal Content */
.federal-status-content p {
    margin:
        0
        0
        0.85rem;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* First Paragraph */
.federal-status-content
p:first-child {
    color:
        var(--color-text);

    font-weight: 600;
}


/* Review Date */
.federal-status-content
.legal-review-date {
    margin:
        1.2rem
        0
        0;

    padding-top: 0.8rem;

    border-top:
        1px solid
        var(--color-border);

    color:
        var(--color-text-soft);

    font-size: 0.72rem;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 849.98px) {

    #legality-header {
        grid-template-columns: 1fr;
    }


    .legality-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #legality-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #legality-header {
        padding:
            2rem
            1.4rem;
    }


    .legality-header-visual {
        display: none;
    }


    .federal-status-card {
        grid-template-columns: 1fr;
    }


    .federal-status-marker {
        width: 3.3rem;
        height: 3.3rem;
    }

}

</style>