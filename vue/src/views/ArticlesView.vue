<!-- Articles View Display -->
<template>

    <div
        id="articles-view"
        aria-labelledby="articles-heading"
    >

        <!-- =================================================
             Resource Center Introduction
             ================================================= -->

        <header id="articles-header">

            <!-- Header Content -->
            <div class="articles-header-content">

                <p class="articles-eyebrow">
                    Best Buds Resource Center
                </p>

                <h1 id="articles-heading">
                    Explore Cannabis
                    <span>
                        Research &amp; Resources
                    </span>
                </h1>

                <p class="articles-introduction">
                    Explore cannabis information from
                    government agencies, medical organizations,
                    researchers, public health programs, and
                    other educational sources.
                </p>

                <p class="articles-description">
                    Resources cover cannabis basics, health and
                    safety, medical guidance, research,
                    cannabis policy, and other topics that can
                    help you learn more.
                </p>


                <!-- Resource Types -->
                <div
                    class="resource-types"
                    aria-label="Types of resources included"
                >

                    <span>
                        Government
                    </span>

                    <span>
                        Medical
                    </span>

                    <span>
                        Research
                    </span>

                    <span>
                        Public Health
                    </span>

                    <span>
                        Policy
                    </span>

                </div>

            </div>


            <!-- Decorative Header Graphic -->
            <div
                class="articles-header-visual"
                aria-hidden="true"
            >

                <span class="resource-ring ring-large"></span>
                <span class="resource-ring ring-medium"></span>
                <span class="resource-ring ring-small"></span>

                <span class="resource-center-mark">
                    Research
                </span>

            </div>

        </header>


        <!-- =================================================
             Resource Information
             ================================================= -->

        <aside
            id="resource-information"
            aria-labelledby="resource-information-heading"
        >

            <span
                class="resource-information-icon"
                aria-hidden="true"
            >
                i
            </span>

            <div>

                <h2 id="resource-information-heading">
                    About These Resources
                </h2>

                <p>
                    Cannabis research and laws continue to
                    change. Best Buds prioritizes sources that
                    explain what is currently known while also
                    recognizing where evidence is still
                    developing.
                </p>

                <p>
                    Article links open the original source in a
                    new browser tab.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Cannabis Resources
             ================================================= -->

        <section
            id="cannabis-articles"
            aria-labelledby="cannabis-articles-heading"
        >

            <!-- Section Heading -->
            <header class="articles-section-header">

                <p class="articles-section-eyebrow">
                    Browse the Library
                </p>

                <h2 id="cannabis-articles-heading">
                    Cannabis Resources
                </h2>

                <p>
                    Search by topic, source, category, or
                    keyword. Resources are displayed with the
                    newest information first.
                </p>

            </header>


            <!-- Article Search -->
            <ArticlesSearch
                @activity-recorded="activityRecorded"
            />

        </section>

    </div>

</template>


<script>

import ArticlesSearch
    from "../components/articles/ArticlesSearch.vue";


export default {

    name: "ArticlesView",

    components: {
        ArticlesSearch
    },

    emits: [
        "activity-recorded"
    ],

    methods: {

        // Pass recorded activity to the application
        activityRecorded() {

            this.$emit(
                "activity-recorded"
            );

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Articles View
   ========================================================= */

#articles-view {
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
   Articles Header
   ========================================================= */

#articles-header {
    position: relative;

    display: grid;

    grid-template-columns:
        minmax(0, 1.35fr)
        minmax(15rem, 0.65fr);

    align-items: center;

    gap: 3rem;

    overflow: hidden;

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
.articles-header-content {
    position: relative;

    max-width: 47rem;

    z-index: 2;
}


/* Header Eyebrow */
.articles-eyebrow,
.articles-section-eyebrow {
    margin:
        0
        0
        0.75rem;

    color:
        var(--color-gold-dark);

    font-size: 0.7rem;
    font-weight: 600;

    letter-spacing: 0.18em;

    text-transform: uppercase;
}


/* Main Heading */
#articles-heading {
    margin:
        0
        0
        1.3rem;

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
#articles-heading span {
    display: block;

    margin-top: 0.15em;

    color:
        var(--color-primary);
}


/* Introduction */
.articles-introduction {
    max-width: 42rem;

    margin:
        0
        0
        0.85rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1rem,
            2vw,
            1.1rem
        );

    line-height: 1.7;
}


/* Description */
.articles-description {
    max-width: 42rem;

    margin:
        0
        0
        1.5rem;

    color:
        var(--color-text-soft);

    font-size: 0.92rem;

    line-height: 1.7;
}


/* =========================================================
   Resource Types
   ========================================================= */

.resource-types {
    display: flex;
    flex-wrap: wrap;

    gap: 0.5rem;
}


/* Resource Type */
.resource-types span {
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

    font-size: 0.66rem;
    font-weight: 600;

    letter-spacing: 0.07em;

    text-transform: uppercase;
}


/* =========================================================
   Decorative Research Graphic
   ========================================================= */

.articles-header-visual {
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


/* Resource Ring */
.resource-ring {
    position: absolute;

    border:
        1px solid
        var(--color-gold-soft);

    border-radius: 50%;
}


/* Large Ring */
.ring-large {
    width: 100%;
    height: 100%;
}


/* Medium Ring */
.ring-medium {
    width: 72%;
    height: 72%;
}


/* Small Ring */
.ring-small {
    width: 43%;
    height: 43%;

    border-color:
        var(--color-gold);
}


/* Center Research Mark */
.resource-center-mark {
    position: relative;

    display: grid;
    place-items: center;

    width: 7rem;
    height: 7rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-background);

    font-size: 0.66rem;
    font-weight: 600;

    letter-spacing: 0.14em;

    text-transform: uppercase;

    box-shadow:
        0 14px 32px
        var(--color-shadow-strong);
}


/* =========================================================
   Resource Information
   ========================================================= */

#resource-information {
    display: flex;
    align-items: flex-start;

    gap: 1rem;

    margin-top: 1rem;

    padding:
        1.1rem
        1.25rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);
}


/* Information Icon */
.resource-information-icon {
    display: grid;
    place-items: center;

    width: 2rem;
    height: 2rem;

    flex-shrink: 0;

    background:
        var(--color-gold-soft);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.8rem;
    font-weight: 700;
}


/* Information Heading */
#resource-information h2 {
    margin:
        0
        0
        0.4rem;

    color:
        var(--color-text);

    font-size: 0.88rem;
    font-weight: 600;
}


/* Information Text */
#resource-information p {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.55;
}


/* =========================================================
   Resource Section
   ========================================================= */

#cannabis-articles {
    padding-top:
        clamp(
            3.5rem,
            8vw,
            6rem
        );
}


/* Section Header */
.articles-section-header {
    max-width: 44rem;

    margin-bottom: 2rem;
}


/* Section Heading */
.articles-section-header h2 {
    margin:
        0
        0
        0.7rem;

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
.articles-section-header > p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 849.98px) {

    #articles-header {
        grid-template-columns: 1fr;
    }


    .articles-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #articles-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #articles-header {
        padding:
            2rem
            1.4rem;
    }


    .articles-header-visual {
        display: none;
    }


    #resource-information {
        padding: 1rem;
    }

}

</style>