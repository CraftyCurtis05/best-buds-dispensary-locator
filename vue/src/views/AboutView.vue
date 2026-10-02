<!-- About Us View Display -->
<template>

    <div
        id="about-view"
        aria-labelledby="about-heading"
    >

        <!-- =================================================
             About Page Introduction
             ================================================= -->

        <header id="about-header">

            <!-- Header Content -->
            <div class="about-header-content">

                <p class="about-eyebrow">
                    About Best Buds
                </p>

                <h1 id="about-heading">
                    Discover Cannabis

                    <span>
                        With Better Context
                    </span>
                </h1>

                <p class="about-introduction">
                    Best Buds is designed to make cannabis
                    information easier to find, understand,
                    and explore.
                </p>

                <p class="about-description">
                    The app combines dispensary discovery,
                    cannabis education, safety information,
                    legal context, news, and helpful
                    resources in one place.
                </p>


                <!-- Best Buds Areas -->
                <div
                    class="about-topic-pills"
                    aria-label="Best Buds features"
                >

                    <span>
                        Discover
                    </span>

                    <span>
                        Learn
                    </span>

                    <span>
                        Safety
                    </span>

                    <span>
                        Research
                    </span>

                    <span>
                        Collect
                    </span>

                </div>

            </div>


            <!-- Decorative About Graphic -->
            <div
                class="about-header-visual"
                aria-hidden="true"
            >

                <span class="about-ring ring-large"></span>
                <span class="about-ring ring-medium"></span>
                <span class="about-ring ring-small"></span>


                <div class="about-center">

                    <span>
                        Best
                    </span>

                    <small>
                        Buds
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             About Navigation
             ================================================= -->

        <OnThisPage
            :topics="aboutSections"
            heading="About Best Buds"
        />


        <!-- =================================================
             Our Mission
             ================================================= -->

        <section
            id="our-mission"
            class="about-section"
            aria-labelledby="mission-heading"
        >

            <p class="about-section-label">
                Our Purpose
            </p>

            <h2 id="mission-heading">
                Our Mission
            </h2>

            <div class="about-feature-card">

                <p>
                    Our mission is to give people clear,
                    approachable information that can help
                    them make more informed decisions about
                    cannabis.
                </p>

                <p>
                    Cannabis products, effects, laws, and
                    research continue to change. Best Buds
                    focuses on explaining what is known,
                    what can vary, and where users can find
                    additional reliable information.
                </p>

            </div>

        </section>


        <!-- =================================================
             What Best Buds Offers
             ================================================= -->

        <section
            id="what-we-offer"
            class="about-section"
            aria-labelledby="what-we-offer-heading"
        >

            <p class="about-section-label">
                Explore the App
            </p>

            <h2 id="what-we-offer-heading">
                What You Can Do With Best Buds
            </h2>


            <ul class="about-feature-grid">

                <li>

                    <span class="about-feature-number">
                        01
                    </span>

                    <p>
                        Find dispensaries near a location or
                        near your saved home address.
                    </p>

                </li>

                <li>

                    <span class="about-feature-number">
                        02
                    </span>

                    <p>
                        Save dispensaries you want to visit
                        again.
                    </p>

                </li>

                <li>

                    <span class="about-feature-number">
                        03
                    </span>

                    <p>
                        Learn about cannabis products,
                        strains, terpenes, safety, and
                        common questions.
                    </p>

                </li>

                <li>

                    <span class="about-feature-number">
                        04
                    </span>

                    <p>
                        Explore cannabis laws and legal
                        differences across the United
                        States.
                    </p>

                </li>

                <li>

                    <span class="about-feature-number">
                        05
                    </span>

                    <p>
                        Read cannabis-related articles and
                        news.
                    </p>

                </li>

                <li>

                    <span class="about-feature-number">
                        06
                    </span>

                    <p>
                        Discover collectible Drops as you
                        explore the app.
                    </p>

                </li>

            </ul>

        </section>


        <!-- =================================================
             Educational Information
             ================================================= -->

        <section
            id="information-disclaimer"
            class="about-section"
            aria-labelledby="
                information-disclaimer-heading
            "
        >

            <p class="about-section-label">
                Information
            </p>

            <h2 id="information-disclaimer-heading">
                Educational Information
            </h2>


            <div
                class="
                    about-feature-card
                    about-information-card
                "
            >

                <p>
                    Best Buds provides general educational
                    information. It is not a substitute for
                    professional medical, legal, or
                    emergency advice.
                </p>

                <p>
                    Cannabis can affect people differently.
                    Product contents, local laws, health
                    risks, and individual circumstances can
                    also vary. When something matters to
                    your health or legal situation, verify
                    it with a qualified professional or
                    current government source.
                </p>

            </div>

        </section>


        <!-- =================================================
             Privacy & Contact
             ================================================= -->

        <div class="about-link-grid">

            <!-- Privacy -->
            <section
                id="privacy-security"
                class="about-link-card"
                aria-labelledby="
                    privacy-security-heading
                "
            >

                <p class="about-section-label">
                    Privacy
                </p>

                <h2 id="privacy-security-heading">
                    Privacy &amp; Security
                </h2>

                <p>
                    Best Buds is designed to protect the
                    personal information users provide while
                    using the application.
                </p>

                <router-link
                    :to="{
                        name: 'privacy-policy'
                    }"
                >
                    Read the Privacy Policy

                    <span aria-hidden="true">
                        →
                    </span>
                </router-link>

            </section>


            <!-- Contact -->
            <section
                id="get-in-touch"
                class="about-link-card"
                aria-labelledby="contact-heading"
            >

                <p class="about-section-label">
                    Contact
                </p>

                <h2 id="contact-heading">
                    Get In Touch
                </h2>

                <p>
                    Have a question, suggestion, or feedback
                    about Best Buds?
                </p>

                <router-link
                    :to="{
                        name: 'contact-us'
                    }"
                >
                    Contact Best Buds

                    <span aria-hidden="true">
                        →
                    </span>
                </router-link>

            </section>

        </div>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";


export default {

    name: "AboutView",

    components: {
        OnThisPage
    },

    data() {

        return {

            // About page sections used
            // for quick navigation
            aboutSections: [

                {
                    id: "our-mission",
                    label: "Our Mission"
                },

                {
                    id: "what-we-offer",
                    label: "What Best Buds Offers"
                },

                {
                    id: "information-disclaimer",
                    label: "Educational Information"
                },

                {
                    id: "privacy-security",
                    label: "Privacy & Security"
                },

                {
                    id: "get-in-touch",
                    label: "Get In Touch"
                }

            ]

        };

    }

};

</script>


<style scoped>

/* =========================================================
   About View
   ========================================================= */

#about-view {
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
   About Header
   ========================================================= */

#about-header {
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
.about-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.about-eyebrow,
.about-section-label {
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
#about-heading {
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
#about-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.about-introduction {
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
.about-description {
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

.about-topic-pills {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


.about-topic-pills span {
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
   Decorative Graphic
   ========================================================= */

.about-header-visual {
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


.about-ring {
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


.about-center {
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


.about-center span {
    font-size: 0.8rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


.about-center small {
    margin-top: 0.15rem;

    color:
        var(--color-gold);

    font-size: 0.58rem;
    font-weight: 600;

    letter-spacing: 0.12em;

    text-transform: uppercase;
}


/* =========================================================
   About Sections
   ========================================================= */

.about-section {
    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


/* Section Heading */
.about-section
> h2,
.about-link-card
> h2 {
    margin:
        0
        0
        0.9rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.6rem,
            4vw,
            2.4rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.03em;
}


/* =========================================================
   Mission / Information Card
   ========================================================= */

.about-feature-card {
    max-width: 56rem;

    padding:
        clamp(
            1.3rem,
            4vw,
            1.8rem
        );

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-left:
        3px solid
        var(--color-primary);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 10px 28px
        var(--color-shadow);
}


.about-feature-card p {
    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text-soft);

    line-height: 1.75;
}


.about-feature-card
p:first-child {
    color:
        var(--color-text);
}


.about-feature-card
p:last-child {
    margin-bottom: 0;
}


/* Educational Information */
.about-information-card {
    border-left-color:
        var(--color-gold);
}


/* =========================================================
   Feature Grid
   ========================================================= */

.about-feature-grid {
    display: grid;

    grid-template-columns:
        repeat(
            3,
            minmax(
                0,
                1fr
            )
        );

    gap: 1rem;

    padding: 0;
    margin: 0;

    list-style: none;
}


.about-feature-grid li {
    padding: 1.25rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 8px 22px
        var(--color-shadow);
}


.about-feature-number {
    display: block;

    margin-bottom: 1.2rem;

    color:
        var(--color-gold-dark);

    font-size: 0.64rem;
    font-weight: 600;

    letter-spacing: 0.12em;
}


.about-feature-grid p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.82rem;

    line-height: 1.65;
}


/* =========================================================
   Privacy / Contact Cards
   ========================================================= */

.about-link-grid {
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

    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


.about-link-card {
    display: flex;
    flex-direction: column;

    padding:
        1.5rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 10px 28px
        var(--color-shadow);
}


.about-link-card
> p:not(
    .about-section-label
) {
    margin:
        0
        0
        1.5rem;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


.about-link-card a {
    display: inline-flex;
    align-items: center;
    justify-content: space-between;

    gap: 1rem;

    margin-top: auto;

    padding-top: 1rem;

    border-top:
        1px solid
        var(--color-border);

    color:
        var(--color-primary);

    font-size: 0.76rem;
    font-weight: 600;

    text-decoration: none;
}


.about-link-card a:hover {
    color:
        var(--color-gold-dark);
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 899.98px) {

    #about-header {
        grid-template-columns: 1fr;
    }


    .about-header-visual {
        width: 13rem;
    }


    .about-feature-grid {
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

    #about-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #about-header {
        padding:
            2rem
            1.4rem;
    }


    .about-header-visual {
        display: none;
    }


    .about-feature-grid,
    .about-link-grid {
        grid-template-columns: 1fr;
    }

}

</style>