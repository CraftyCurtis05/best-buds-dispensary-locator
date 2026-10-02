<!-- Learn View Display -->
<template>

    <div
        id="learn-view"
        aria-labelledby="learn-heading"
    >

        <!-- =================================================
             Learn Page Introduction
             ================================================= -->

        <header id="learn-header">

            <!-- Header Content -->
            <div class="learn-header-content">

                <p class="learn-eyebrow">
                    Best Buds Learn
                </p>

                <h1 id="learn-heading">
                    Learn About
                    <span>
                        Cannabis
                    </span>
                </h1>

                <p class="learn-introduction">
                    Cannabis can feel complicated when you're
                    getting started, but it doesn't have to be.
                    Best Buds breaks information into smaller,
                    easier-to-explore topics.
                </p>

                <p class="learn-description">
                    Start with the basics, explore products and
                    strains, learn about safety, or dig deeper
                    into research and other cannabis resources.
                </p>

            </div>


            <!-- Learning Path Graphic -->
            <div
                class="learn-header-visual"
                aria-hidden="true"
            >

                <span class="learn-ring ring-large"></span>
                <span class="learn-ring ring-medium"></span>

                <div class="learn-center">

                    <span>
                        Learn
                    </span>

                    <small>
                        Your Way
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Learning Note
             ================================================= -->

        <aside class="learn-note">

            <span
                class="learn-note-icon"
                aria-hidden="true"
            >
                i
            </span>

            <p>
                Best Buds explains both what is currently known
                and where cannabis information can still be
                uncertain, changing, or different from person
                to person.
            </p>

        </aside>


        <!-- =================================================
             Start Here
             ================================================= -->

        <section
            id="learn-start-here"
            class="learn-section"
            aria-labelledby="learn-start-here-heading"
        >

            <!-- Section Heading -->
            <header class="learn-section-header">

                <div>

                    <p class="section-number">
                        01
                    </p>

                    <h2 id="learn-start-here-heading">
                        Start Here
                    </h2>

                </div>

                <p>
                    New to cannabis or not sure where to begin?
                    These topics are a good starting point.
                </p>

            </header>


            <!-- Learning Cards -->
            <div class="learn-card-grid">

                <!-- Getting Started -->
                <router-link
                    :to="{ name: 'tips-tricks' }"
                    class="learn-card"
                >

                    <span class="learn-card-label">
                        Basics
                    </span>

                    <h3>
                        Getting Started
                    </h3>

                    <p>
                        Explore basic cannabis tips,
                        terminology, products, and things to
                        keep in mind as you learn.
                    </p>

                    <span class="learn-card-link">
                        Explore Getting Started

                        <span aria-hidden="true">
                            →
                        </span>
                    </span>

                </router-link>


                <!-- Common Questions -->
                <router-link
                    :to="{ name: 'questions' }"
                    class="learn-card"
                >

                    <span class="learn-card-label">
                        Questions
                    </span>

                    <h3>
                        Common Questions
                    </h3>

                    <p>
                        Find clear answers to common questions
                        about cannabis, products, consumption,
                        and everyday use.
                    </p>

                    <span class="learn-card-link">
                        Explore Common Questions

                        <span aria-hidden="true">
                            →
                        </span>
                    </span>

                </router-link>

            </div>

        </section>


        <!-- =================================================
             Know the Plant
             ================================================= -->

        <section
            id="learn-plant"
            class="learn-section"
            aria-labelledby="learn-plant-heading"
        >

            <!-- Section Heading -->
            <header class="learn-section-header">

                <div>

                    <p class="section-number">
                        02
                    </p>

                    <h2 id="learn-plant-heading">
                        Know the Plant
                    </h2>

                </div>

                <p>
                    Learn about cannabis products, strains,
                    cannabinoids, and terpenes.
                </p>

            </header>


            <!-- Learning Cards -->
            <div class="learn-card-grid">

                <!-- Cannabis Products -->
                <router-link
                    :to="{ name: 'products' }"
                    class="learn-card"
                >

                    <span class="learn-card-label">
                        Products
                    </span>

                    <h3>
                        Cannabis Products
                    </h3>

                    <p>
                        Explore flower, edibles, wax, oils,
                        tinctures, topicals, and other common
                        cannabis products.
                    </p>

                    <span class="learn-card-link">
                        Explore Cannabis Products

                        <span aria-hidden="true">
                            →
                        </span>
                    </span>

                </router-link>


                <!-- Strains and Terpenes -->
                <router-link
                    :to="{ name: 'strain-guide' }"
                    class="learn-card"
                >

                    <span class="learn-card-label">
                        Plant Guide
                    </span>

                    <h3>
                        Strains &amp; Terpenes
                    </h3>

                    <p>
                        Learn how strains, cannabinoids,
                        aromas, and terpenes can differ across
                        cannabis varieties and products.
                    </p>

                    <span class="learn-card-link">
                        Explore Strains &amp; Terpenes

                        <span aria-hidden="true">
                            →
                        </span>
                    </span>

                </router-link>

            </div>

        </section>


        <!-- =================================================
             Use Responsibly
             ================================================= -->

        <section
            id="learn-responsibly"
            class="learn-section"
            aria-labelledby="learn-responsibly-heading"
        >

            <!-- Section Heading -->
            <header class="learn-section-header">

                <div>

                    <p class="section-number">
                        03
                    </p>

                    <h2 id="learn-responsibly-heading">
                        Use Responsibly
                    </h2>

                </div>

                <p>
                    Explore safety, overconsumption, and legal
                    information that can help provide useful
                    context for cannabis decisions.
                </p>

            </header>


            <!-- Learning Cards -->
            <div class="learn-card-grid learn-card-grid-three">

                <!-- Safety -->
                <router-link
                    :to="{ name: 'safety' }"
                    class="learn-card"
                >

                    <span class="learn-card-label">
                        Safety
                    </span>

                    <h3>
                        Cannabis Safety
                    </h3>

                    <p>
                        Explore practical safety information
                        for THC, CBD, smoking, topicals, and
                        other forms of cannabis use.
                    </p>

                    <span class="learn-card-link">
                        Explore Cannabis Safety

                        <span aria-hidden="true">
                            →
                        </span>
                    </span>

                </router-link>


                <!-- Too Much Cannabis -->
                <router-link
                    :to="{ name: 'too-much' }"
                    class="learn-card"
                >

                    <span class="learn-card-label">
                        Overconsumption
                    </span>

                    <h3>
                        Too Much Cannabis
                    </h3>

                    <p>
                        Learn about signs of overconsumption,
                        ways to stay calm, and when additional
                        help may be needed.
                    </p>

                    <span class="learn-card-link">
                        Learn What To Do

                        <span aria-hidden="true">
                            →
                        </span>
                    </span>

                </router-link>


                <!-- Cannabis Legality -->
                <router-link
                    :to="{ name: 'legality' }"
                    class="learn-card"
                >

                    <span class="learn-card-label">
                        Law
                    </span>

                    <h3>
                        Cannabis Legality
                    </h3>

                    <p>
                        Explore cannabis law information and
                        why rules can differ depending on the
                        product, activity, and location.
                    </p>

                    <span class="learn-card-link">
                        Explore Cannabis Legality

                        <span aria-hidden="true">
                            →
                        </span>
                    </span>

                </router-link>

            </div>

        </section>


        <!-- =================================================
             Dig Deeper
             ================================================= -->

        <section
            id="learn-deeper"
            class="learn-section"
            aria-labelledby="learn-deeper-heading"
        >

            <!-- Section Heading -->
            <header class="learn-section-header">

                <div>

                    <p class="section-number">
                        04
                    </p>

                    <h2 id="learn-deeper-heading">
                        Dig a Little Deeper
                    </h2>

                </div>

                <p>
                    Explore research, public-health information,
                    medical guidance, policy resources, and
                    other longer-form cannabis material.
                </p>

            </header>


            <!-- Resource Card -->
            <router-link
                :to="{ name: 'articles' }"
                class="learn-feature-card"
            >

                <div>

                    <span class="learn-card-label">
                        Resource Center
                    </span>

                    <h3>
                        Cannabis Articles &amp; Research
                    </h3>

                    <p>
                        Explore curated resources from
                        government agencies, medical
                        organizations, researchers, public
                        health programs, and other educational
                        sources.
                    </p>

                </div>

                <span
                    class="learn-feature-arrow"
                    aria-hidden="true"
                >
                    →
                </span>

            </router-link>

        </section>

    </div>

</template>


<script>

export default {

    name: "LearnView"

};

</script>


<style scoped>

/* =========================================================
   Learn View
   ========================================================= */

#learn-view {
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
   Learn Header
   ========================================================= */

#learn-header {
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
.learn-header-content {
    max-width: 46rem;
}


/* Eyebrow */
.learn-eyebrow {
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


/* Heading */
#learn-heading {
    margin:
        0
        0
        1.2rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            2.5rem,
            6vw,
            4.7rem
        );

    font-weight: 500;

    line-height: 0.98;

    letter-spacing: -0.045em;
}


/* Heading Accent */
#learn-heading span {
    display: block;

    color:
        var(--color-primary);
}


/* Introduction */
.learn-introduction {
    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text);

    font-size: 1.05rem;

    line-height: 1.7;
}


/* Description */
.learn-description {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.9rem;

    line-height: 1.7;
}


/* =========================================================
   Learn Visual
   ========================================================= */

.learn-header-visual {
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
.learn-ring {
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
    width: 68%;
    height: 68%;

    border-color:
        var(--color-gold);
}


/* Center */
.learn-center {
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
.learn-center span {
    font-size: 0.85rem;
    font-weight: 600;

    letter-spacing: 0.15em;

    text-transform: uppercase;
}


.learn-center small {
    margin-top: 0.25rem;

    color:
        var(--color-gold);

    font-size: 0.58rem;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


/* =========================================================
   Learn Note
   ========================================================= */

.learn-note {
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


/* Note Icon */
.learn-note-icon {
    display: grid;
    place-items: center;

    width: 1.8rem;
    height: 1.8rem;

    flex-shrink: 0;

    background:
        var(--color-gold-soft);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.75rem;
    font-weight: 700;
}


/* Note Text */
.learn-note p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.8rem;

    line-height: 1.6;
}


/* =========================================================
   Learn Sections
   ========================================================= */

.learn-section {
    padding-top:
        clamp(
            3.5rem,
            8vw,
            5.5rem
        );
}


/* Section Header */
.learn-section-header {
    display: grid;

    grid-template-columns:
        minmax(
            12rem,
            0.6fr
        )
        minmax(
            0,
            1fr
        );

    gap: 2rem;

    align-items: end;

    margin-bottom: 1.5rem;
}


/* Section Number */
.section-number {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-gold-dark);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.15em;
}


/* Section Heading */
.learn-section-header h2 {
    margin: 0;

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

    letter-spacing: -0.025em;
}


/* Section Description */
.learn-section-header > p {
    max-width: 34rem;

    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Learning Card Grid
   ========================================================= */

.learn-card-grid {
    display: grid;

    grid-template-columns:
        repeat(
            2,
            minmax(
                0,
                1fr
            )
        );

    gap: 1rem;
}


/* Three Card Grid */
.learn-card-grid-three {
    grid-template-columns:
        repeat(
            3,
            minmax(
                0,
                1fr
            )
        );
}


/* =========================================================
   Learning Card
   ========================================================= */

.learn-card {
    display: flex;
    flex-direction: column;

    min-height: 15rem;

    padding: 1.4rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 12px 28px
        var(--color-shadow);

    color:
        var(--color-text);

    text-decoration: none;

    transition:
        transform 160ms ease,
        background 160ms ease,
        border-color 160ms ease,
        box-shadow 160ms ease;
}


/* Card Hover */
.learn-card:hover {
    background:
        var(--color-surface-soft);

    border-color:
        var(--color-border-strong);

    box-shadow:
        0 18px 38px
        var(--color-shadow-strong);

    transform:
        translateY(-3px);
}


/* Card Label */
.learn-card-label {
    align-self: flex-start;

    padding:
        0.32rem
        0.55rem;

    background:
        var(--color-primary-soft);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.6rem;
    font-weight: 600;

    letter-spacing: 0.09em;

    text-transform: uppercase;
}


/* Card Heading */
.learn-card h3 {
    margin:
        1.5rem
        0
        0.65rem;

    font-size: 1.2rem;
    font-weight: 600;

    line-height: 1.2;
}


/* Card Description */
.learn-card p {
    margin:
        0
        0
        1.5rem;

    color:
        var(--color-text-soft);

    font-size: 0.84rem;

    line-height: 1.6;
}


/* Card Link */
.learn-card-link {
    display: flex;
    align-items: center;
    justify-content: space-between;

    gap: 1rem;

    margin-top: auto;

    padding-top: 0.9rem;

    border-top:
        1px solid
        var(--color-border);

    color:
        var(--color-primary);

    font-size: 0.76rem;
    font-weight: 600;
}


/* =========================================================
   Feature Resource Card
   ========================================================= */

.learn-feature-card {
    display: flex;
    align-items: center;
    justify-content: space-between;

    gap: 2rem;

    padding:
        clamp(
            1.5rem,
            4vw,
            2.3rem
        );

    background:
        linear-gradient(
            135deg,
            var(--color-primary),
            var(--color-footer-background)
        );

    border:
        1px solid
        var(--color-border-strong);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 18px 40px
        var(--color-shadow-strong);

    color:
        var(--color-text-light);

    text-decoration: none;

    transition:
        transform 160ms ease;
}


/* Feature Hover */
.learn-feature-card:hover {
    transform:
        translateY(-3px);
}


/* Feature Label */
.learn-feature-card
.learn-card-label {
    background:
        transparent;

    border:
        1px solid
        var(--color-gold);

    color:
        var(--color-gold);
}


/* Feature Heading */
.learn-feature-card h3 {
    margin:
        1rem
        0
        0.6rem;

    font-size:
        clamp(
            1.4rem,
            3vw,
            2rem
        );

    font-weight: 500;
}


/* Feature Description */
.learn-feature-card p {
    max-width: 42rem;

    margin: 0;

    color:
        var(--color-footer-text-soft);

    line-height: 1.65;
}


/* Feature Arrow */
.learn-feature-arrow {
    color:
        var(--color-gold);

    font-size: 2rem;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 899.98px) {

    #learn-header {
        grid-template-columns: 1fr;
    }


    .learn-header-visual {
        width: 13rem;
    }


    .learn-card-grid-three {
        grid-template-columns:
            repeat(
                2,
                minmax(
                    0,
                    1fr
                )
            );
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #learn-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #learn-header {
        padding:
            2rem
            1.4rem;
    }


    .learn-header-visual {
        display: none;
    }


    .learn-section-header {
        grid-template-columns: 1fr;

        gap: 0.65rem;
    }


    .learn-card-grid,
    .learn-card-grid-three {
        grid-template-columns: 1fr;
    }


    .learn-card {
        min-height: 13rem;
    }


    .learn-feature-card {
        align-items: flex-start;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .learn-card,
    .learn-feature-card {
        transition: none;
    }


    .learn-card:hover,
    .learn-feature-card:hover {
        transform: none;
    }

}

</style>