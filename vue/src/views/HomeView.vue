<!-- Home View Display -->
<template>

    <div id="home-view">

        <!-- =================================================
             Home Hero
             ================================================= -->

        <section
            id="home-hero"
            aria-labelledby="home-heading"
        >

            <!-- Hero Content -->
            <div class="hero-content">

                <p class="hero-eyebrow">
                    Dispensary Locator + Cannabis Education
                </p>

                <h1 id="home-heading">
                    Find what you need.
                    <span>
                        Understand what you're choosing.
                    </span>
                </h1>

                <p class="hero-description">
                    Best Buds helps you find nearby
                    dispensaries and explore clear cannabis
                    information about products, safety,
                    research and laws.
                </p>


                <!-- Hero Actions -->
                <div class="hero-actions">

                    <router-link
                        :to="{ name: 'search' }"
                        class="hero-button hero-button-primary"
                    >
                        Find Dispensaries

                        <span aria-hidden="true">
                            →
                        </span>
                    </router-link>

                    <router-link
                        :to="{ name: 'learn' }"
                        class="hero-button hero-button-secondary"
                    >
                        Explore the Learn Hub
                    </router-link>

                </div>


                <!-- Hero Highlights -->
                <ul class="hero-highlights">

                    <li>
                        Nearby dispensary search
                    </li>

                    <li>
                        Clear cannabis education
                    </li>

                    <li>
                        Safety and legal resources
                    </li>

                </ul>

            </div>


            <!-- Decorative Locator Graphic -->
            <div
                class="hero-visual"
                aria-hidden="true"
            >

                <span class="locator-ring locator-ring-one"></span>
                <span class="locator-ring locator-ring-two"></span>
                <span class="locator-ring locator-ring-three"></span>

                <div class="locator-logo">

                    <img
                        :src="logoIcon"
                        alt=""
                        width="180"
                        height="180"
                    />

                </div>

                <span class="locator-label">
                    Find · Learn · Explore
                </span>

            </div>

        </section>


        <!-- =================================================
             Quick Navigation
             ================================================= -->

        <section
            id="home-actions"
            aria-labelledby="home-actions-heading"
        >

            <!-- Section Introduction -->
            <header class="home-section-heading">

                <p class="section-eyebrow">
                    Explore Best Buds
                </p>

                <h2 id="home-actions-heading">
                    Start with what you need
                </h2>

                <p>
                    Get to the most useful parts of Best Buds
                    without digging through menus.
                </p>

            </header>


            <!-- Quick Action Cards -->
            <div class="quick-actions-grid">

                <!-- Find Dispensaries -->
                <router-link
                    :to="{ name: 'search' }"
                    class="quick-action-card"
                >

                    <span class="quick-action-number">
                        01
                    </span>

                    <span class="quick-action-label">
                        Find
                    </span>

                    <h3>
                        Search Dispensaries
                    </h3>

                    <p>
                        Find dispensaries and explore
                        locations near you.
                    </p>

                    <span
                        class="quick-action-arrow"
                        aria-hidden="true"
                    >
                        →
                    </span>

                </router-link>


                <!-- Learn About Cannabis -->
                <router-link
                    :to="{ name: 'learn' }"
                    class="quick-action-card"
                >

                    <span class="quick-action-number">
                        02
                    </span>

                    <span class="quick-action-label">
                        Learn
                    </span>

                    <h3>
                        Cannabis Education
                    </h3>

                    <p>
                        Explore products, strains, common
                        questions and research.
                    </p>

                    <span
                        class="quick-action-arrow"
                        aria-hidden="true"
                    >
                        →
                    </span>

                </router-link>


                <!-- Safety Information -->
                <router-link
                    :to="{ name: 'safety' }"
                    class="quick-action-card"
                >

                    <span class="quick-action-number">
                        03
                    </span>

                    <span class="quick-action-label">
                        Safety
                    </span>

                    <h3>
                        Know the Risks
                    </h3>

                    <p>
                        Review practical information about
                        THC, CBD, smoking and topical use.
                    </p>

                    <span
                        class="quick-action-arrow"
                        aria-hidden="true"
                    >
                        →
                    </span>

                </router-link>


                <!-- Cannabis Legality -->
                <router-link
                    :to="{ name: 'legality' }"
                    class="quick-action-card"
                >

                    <span class="quick-action-number">
                        04
                    </span>

                    <span class="quick-action-label">
                        Law
                    </span>

                    <h3>
                        Cannabis Legality
                    </h3>

                    <p>
                        Review federal and state cannabis
                        information before making decisions.
                    </p>

                    <span
                        class="quick-action-arrow"
                        aria-hidden="true"
                    >
                        →
                    </span>

                </router-link>

            </div>

        </section>


        <!-- =================================================
             Featured Dispensary
             ================================================= -->

        <section
            id="featured-dispensary"
            aria-labelledby="featured-heading"
        >

            <!-- Section Introduction -->
            <header class="home-section-heading">

                <p class="section-eyebrow">
                    Discover
                </p>

                <h2 id="featured-heading">
                    Featured Dispensary
                </h2>

                <p>
                    Explore today's featured dispensary or
                    start your own search.
                </p>

            </header>


            <!-- Featured Dispensary -->
            <HomeFeatured />

        </section>

    </div>

</template>


<script>

import HomeFeatured from "../components/home/HomeFeatured.vue";

import logoIcon from "../assets/layout/logo/logo-icon.png";


export default {

    name: "HomeView",

    components: {
        HomeFeatured
    },

    data() {

        return {
            logoIcon
        };

    }

};

</script>


<style scoped>

/* =========================================================
   Home View
   ========================================================= */

#home-view {
    width:
        min(
            calc(100% - 2rem),
            76rem
        );

    margin:
        0
        auto;

    padding:
        2rem
        0
        5rem;
}


/* =========================================================
   Home Hero
   ========================================================= */

#home-hero {
    position: relative;

    display: grid;

    grid-template-columns:
        minmax(0, 1.3fr)
        minmax(18rem, 0.7fr);

    align-items: center;

    gap: 4rem;

    min-height: 31rem;

    overflow: hidden;

    padding:
        clamp(
            2rem,
            6vw,
            4.5rem
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


/* Hero Content */
.hero-content {
    position: relative;

    z-index: 2;

    max-width: 44rem;
}


/* Hero Eyebrow */
.hero-eyebrow,
.section-eyebrow {
    margin:
        0
        0
        0.85rem;

    color:
        var(--color-gold-dark);

    font-size: 0.72rem;
    font-weight: 600;

    letter-spacing: 0.18em;

    text-transform: uppercase;
}


/* Hero Heading */
#home-heading {
    max-width: 42rem;

    margin:
        0
        0
        1.4rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            2.4rem,
            6vw,
            4.8rem
        );

    font-weight: 500;

    line-height: 0.98;

    letter-spacing: -0.045em;
}


/* Hero Heading Accent */
#home-heading span {
    display: block;

    margin-top: 0.2em;

    color:
        var(--color-primary);
}


/* Hero Description */
.hero-description {
    max-width: 39rem;

    margin:
        0
        0
        1.8rem;

    color:
        var(--color-text-soft);

    font-size:
        clamp(
            1rem,
            2vw,
            1.15rem
        );

    line-height: 1.7;
}


/* =========================================================
   Hero Buttons
   ========================================================= */

.hero-actions {
    display: flex;
    flex-wrap: wrap;

    gap: 0.85rem;

    margin-bottom: 1.6rem;
}


/* Hero Button */
.hero-button {
    display: inline-flex;
    align-items: center;
    justify-content: center;

    gap: 0.65rem;

    min-height: 3rem;

    padding:
        0.75rem
        1.15rem;

    border-radius:
        var(--border-radius-pill);

    font-size: 0.86rem;
    font-weight: 600;

    letter-spacing: 0.03em;

    text-decoration: none;

    transition:
        transform 160ms ease,
        background 160ms ease,
        border-color 160ms ease;
}


/* Primary Hero Button */
.hero-button-primary {
    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    color:
        var(--color-background);
}


/* Primary Hero Button Hover */
.hero-button-primary:hover {
    background:
        var(--color-primary-hover);

    border-color:
        var(--color-primary-hover);

    transform:
        translateY(-2px);
}


/* Secondary Hero Button */
.hero-button-secondary {
    background:
        transparent;

    border:
        1px solid
        var(--color-border-strong);

    color:
        var(--color-text);
}


/* Secondary Hero Button Hover */
.hero-button-secondary:hover {
    background:
        var(--color-surface-strong);

    transform:
        translateY(-2px);
}


/* =========================================================
   Hero Highlights
   ========================================================= */

.hero-highlights {
    display: flex;
    flex-wrap: wrap;

    gap:
        0.55rem
        1.2rem;

    padding: 0;
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    list-style: none;
}


/* Hero Highlight */
.hero-highlights li {
    position: relative;

    padding-left: 0.9rem;
}


/* Hero Highlight Dot */
.hero-highlights li::before {
    position: absolute;

    top: 0.62em;
    left: 0;

    width: 0.3rem;
    height: 0.3rem;

    background:
        var(--color-gold);

    border-radius: 50%;

    content: "";
}


/* =========================================================
   Decorative Locator Graphic
   ========================================================= */

.hero-visual {
    position: relative;

    display: grid;
    place-items: center;

    width: min(
        100%,
        22rem
    );

    aspect-ratio: 1;

    margin:
        0
        auto;
}


/* Locator Rings */
.locator-ring {
    position: absolute;

    border:
        1px solid
        var(--color-gold-soft);

    border-radius: 50%;
}


.locator-ring-one {
    width: 100%;
    height: 100%;
}


.locator-ring-two {
    width: 73%;
    height: 73%;
}


.locator-ring-three {
    width: 45%;
    height: 45%;

    border-color:
        var(--color-gold);
}


/* Center Logo */
.locator-logo {
    position: relative;

    display: grid;
    place-items: center;

    width: 42%;
    aspect-ratio: 1;

    padding: 1rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    box-shadow:
        0 16px 38px
        var(--color-shadow-strong);

    z-index: 2;
}


/* Logo Image */
.locator-logo img {
    width: 100%;
    height: 100%;

    object-fit: contain;
}


/* Locator Label */
.locator-label {
    position: absolute;

    right: 0;
    bottom: 10%;

    padding:
        0.45rem
        0.75rem;

    background:
        var(--color-primary);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-background);

    font-size: 0.65rem;
    font-weight: 600;

    letter-spacing: 0.13em;

    text-transform: uppercase;

    box-shadow:
        0 10px 24px
        var(--color-shadow);
}


/* =========================================================
   Home Sections
   ========================================================= */

#home-actions,
#featured-dispensary {
    padding-top:
        clamp(
            3.5rem,
            8vw,
            6rem
        );
}


/* Section Heading */
.home-section-heading {
    max-width: 42rem;

    margin-bottom: 2rem;
}


/* Section Heading Title */
.home-section-heading h2 {
    margin:
        0
        0
        0.75rem;

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

    letter-spacing: -0.025em;
}


/* Section Heading Description */
.home-section-heading > p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Quick Actions
   ========================================================= */

.quick-actions-grid {
    display: grid;

    grid-template-columns:
        repeat(
            4,
            minmax(
                0,
                1fr
            )
        );

    gap: 1rem;
}


/* Quick Action Card */
.quick-action-card {
    position: relative;

    display: flex;
    flex-direction: column;

    min-height: 17rem;

    padding: 1.4rem;

    overflow: hidden;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 12px 30px
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


/* Quick Action Card Accent */
.quick-action-card::before {
    position: absolute;

    top: 0;
    right: 1.4rem;
    left: 1.4rem;

    height: 1px;

    background:
        var(--color-gold);

    content: "";
}


/* Quick Action Hover */
.quick-action-card:hover {
    background:
        var(--color-surface-soft);

    border-color:
        var(--color-border-strong);

    box-shadow:
        0 18px 38px
        var(--color-shadow-strong);

    transform:
        translateY(-4px);
}


/* Quick Action Number */
.quick-action-number {
    align-self: flex-end;

    color:
        var(--color-gold-dark);

    font-size: 0.72rem;

    letter-spacing: 0.12em;
}


/* Quick Action Label */
.quick-action-label {
    margin-top: 2.3rem;

    color:
        var(--color-gold-dark);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.16em;

    text-transform: uppercase;
}


/* Quick Action Heading */
.quick-action-card h3 {
    margin:
        0.5rem
        0
        0.7rem;

    color:
        var(--color-text);

    font-size: 1.2rem;
    font-weight: 500;

    line-height: 1.2;
}


/* Quick Action Description */
.quick-action-card p {
    margin:
        0
        0
        1.5rem;

    color:
        var(--color-text-soft);

    font-size: 0.84rem;

    line-height: 1.6;
}


/* Quick Action Arrow */
.quick-action-arrow {
    margin-top: auto;

    color:
        var(--color-gold-dark);

    font-size: 1.4rem;

    transition:
        transform 160ms ease;
}


/* Quick Action Arrow Hover */
.quick-action-card:hover
.quick-action-arrow {
    transform:
        translateX(5px);
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 999.98px) {

    #home-hero {
        grid-template-columns:
            minmax(0, 1fr)
            minmax(14rem, 0.45fr);

        gap: 2rem;
    }


    .quick-actions-grid {
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

@media (max-width: 699.98px) {

    #home-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1rem;
    }


    #home-hero {
        grid-template-columns: 1fr;

        min-height: 0;

        padding:
            2.25rem
            1.4rem;
    }


    .hero-visual {
        width: min(
            80%,
            15rem
        );

        margin-top: 0.5rem;
    }


    .locator-label {
        right: -0.5rem;

        font-size: 0.56rem;
    }


    .quick-actions-grid {
        grid-template-columns: 1fr;
    }


    .quick-action-card {
        min-height: 14rem;
    }

}


/* =========================================================
   Very Small Screens
   ========================================================= */

@media (max-width: 420px) {

    .hero-actions {
        flex-direction: column;
    }


    .hero-button {
        width: 100%;
    }


    .hero-visual {
        display: none;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .hero-button,
    .quick-action-card,
    .quick-action-arrow {
        transition: none;
    }


    .hero-button:hover,
    .quick-action-card:hover {
        transform: none;
    }


    .quick-action-card:hover
    .quick-action-arrow {
        transform: none;
    }

}

</style>