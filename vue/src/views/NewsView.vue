<!-- Cannabis News View Display -->
<template>

    <div
        id="news-view"
        aria-labelledby="news-heading"
    >

        <!-- =================================================
             News Page Introduction
             ================================================= -->

        <header id="news-header">

            <!-- Header Content -->
            <div class="news-header-content">

                <p class="news-eyebrow">
                    Best Buds News
                </p>

                <h1 id="news-heading">
                    Cannabis News
                    <span>
                        &amp; Current Coverage
                    </span>
                </h1>

                <p class="news-introduction">
                    Follow recent reporting about cannabis
                    policy, health, research, products,
                    business, and other developments.
                </p>

                <p class="news-description">
                    News coverage can change quickly and may
                    include reporting, analysis, commentary,
                    or developing information from outside
                    sources.
                </p>


                <!-- News Topics -->
                <div
                    class="news-topics"
                    aria-label="Cannabis news topics"
                >

                    <span>
                        Policy
                    </span>

                    <span>
                        Health
                    </span>

                    <span>
                        Research
                    </span>

                    <span>
                        Products
                    </span>

                    <span>
                        Industry
                    </span>

                </div>

            </div>


            <!-- Decorative News Graphic -->
            <div
                class="news-header-visual"
                aria-hidden="true"
            >

                <span class="news-line line-one"></span>
                <span class="news-line line-two"></span>
                <span class="news-line line-three"></span>

                <div class="news-visual-center">

                    <span class="news-visual-label">
                        News
                    </span>

                    <span class="news-visual-dot"></span>

                </div>

            </div>

        </header>


        <!-- =================================================
             News Information
             ================================================= -->

        <aside
            id="news-information"
            aria-labelledby="news-information-heading"
        >

            <span
                class="news-information-icon"
                aria-hidden="true"
            >
                i
            </span>


            <div>

                <h2 id="news-information-heading">
                    About the News Feed
                </h2>

                <p>
                    News articles come from external sources.
                    Best Buds provides access to the coverage
                    but does not control or independently
                    verify every claim made by those
                    publishers.
                </p>

                <p>
                    For health, safety, research, or legal
                    questions, use the educational resources
                    throughout Best Buds and verify important
                    information with appropriate official or
                    professional sources.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Cannabis News Feed
             ================================================= -->

        <section
            id="cannabis-news"
            aria-labelledby="cannabis-news-heading"
        >

            <!-- Section Introduction -->
            <header class="news-section-header">

                <p class="news-section-eyebrow">
                    Current Coverage
                </p>

                <h2 id="cannabis-news-heading">
                    Latest Cannabis News
                </h2>

                <p>
                    Browse recent stories or search for a
                    cannabis topic that interests you.
                </p>

            </header>


            <!-- News Feed -->
            <NewsFeed />

        </section>

    </div>

</template>


<script>

import NewsFeed
    from "../components/news/NewsFeed.vue";


export default {

    name: "NewsView",

    components: {
        NewsFeed
    }

};

</script>


<style scoped>

/* =========================================================
   News View
   ========================================================= */

#news-view {
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
   News Header
   ========================================================= */

#news-header {
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
.news-header-content {
    position: relative;

    max-width: 47rem;

    z-index: 2;
}


/* Header Eyebrow */
.news-eyebrow,
.news-section-eyebrow {
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
#news-heading {
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
#news-heading span {
    display: block;

    margin-top: 0.15em;

    color:
        var(--color-primary);
}


/* Introduction */
.news-introduction {
    max-width: 42rem;

    margin:
        0
        0
        0.8rem;

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
.news-description {
    max-width: 42rem;

    margin:
        0
        0
        1.5rem;

    color:
        var(--color-text-soft);

    font-size: 0.9rem;

    line-height: 1.7;
}


/* =========================================================
   News Topics
   ========================================================= */

.news-topics {
    display: flex;
    flex-wrap: wrap;

    gap: 0.5rem;
}


/* News Topic */
.news-topics span {
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
   Decorative News Graphic
   ========================================================= */

.news-header-visual {
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


/* News Lines */
.news-line {
    position: absolute;

    left: 50%;

    width: 80%;

    height: 1px;

    background:
        linear-gradient(
            to right,
            transparent,
            var(--color-gold),
            transparent
        );

    transform:
        translateX(-50%);
}


/* Individual Lines */
.line-one {
    top: 30%;
}


.line-two {
    top: 50%;

    width: 100%;
}


.line-three {
    top: 70%;

    width: 64%;
}


/* Center News Graphic */
.news-visual-center {
    position: relative;

    display: grid;
    place-items: center;

    width: 7.5rem;
    height: 7.5rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    box-shadow:
        0 16px 38px
        var(--color-shadow-strong);

    z-index: 2;
}


/* Center Label */
.news-visual-label {
    color:
        var(--color-background);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.18em;

    text-transform: uppercase;
}


/* Current News Dot */
.news-visual-dot {
    position: absolute;

    right: 1.3rem;
    bottom: 1.3rem;

    width: 0.55rem;
    height: 0.55rem;

    background:
        var(--color-gold);

    border-radius: 50%;
}


/* =========================================================
   News Information
   ========================================================= */

#news-information {
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
.news-information-icon {
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
#news-information h2 {
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
#news-information p {
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
   Cannabis News Section
   ========================================================= */

#cannabis-news {
    padding-top:
        clamp(
            3.5rem,
            8vw,
            6rem
        );
}


/* Section Header */
.news-section-header {
    max-width: 44rem;

    margin-bottom: 2rem;
}


/* Section Heading */
.news-section-header h2 {
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
.news-section-header > p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 849.98px) {

    #news-header {
        grid-template-columns: 1fr;
    }


    .news-header-visual {
        width: 13rem;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #news-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #news-header {
        padding:
            2rem
            1.4rem;
    }


    .news-header-visual {
        display: none;
    }


    #news-information {
        padding: 1rem;
    }

}

</style>