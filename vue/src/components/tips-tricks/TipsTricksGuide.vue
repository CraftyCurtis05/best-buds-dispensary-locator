<!-- Tips and Tricks Guide Component Display -->
<template>

    <div id="tips-tricks-guide">

        <!-- Display Cannabis Products Guide -->
        <article
            id="choose-products"
            aria-labelledby="choose-products-heading"
        >

            <router-link
                :to="{ name: 'products' }"
                aria-label="Explore cannabis products"
            >
                <img
                    :src="ProductImage"
                    alt="Different types of cannabis products"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="choose-products-heading">
                <router-link
                    :to="{ name: 'products' }"
                >
                    Start with the Product
                </router-link>
            </h3>

            <p>
                Flower, edibles, concentrates, oils,
                tinctures, topicals, and vapes can be very
                different experiences. Before worrying about
                strain names or what someone else recommends,
                start by figuring out what kind of product
                you're actually looking at.
            </p>

            <p>
                Pay attention to THC and CBD content,
                potency, serving size, how the product is
                used, and whether the effects are expected to
                begin quickly or take more time. Those details
                usually tell you more than the packaging
                alone.
            </p>

            <p>
                Our
                <router-link
                    :to="{ name: 'products' }"
                >
                    cannabis product guide
                </router-link>
                breaks down the major product types in plain
                language, including what they are, why people
                choose them, what to look for, and what risks
                are worth knowing before you use them.
            </p>

        </article>

        <!-- Display Strain Guide -->
        <article
            id="strain-guide"
            aria-labelledby="strain-guide-heading"
        >

            <router-link
                :to="{ name: 'strain-guide' }"
                aria-label="Explore strains, cannabinoids, and terpenes"
            >
                <img
                    :src="StrainGuideImage"
                    alt="Cannabis strains, cannabinoids, and terpenes"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="strain-guide-heading">
                <router-link
                    :to="{ name: 'strain-guide' }"
                >
                    Look Beyond Indica, Sativa and Hybrid
                </router-link>
            </h3>

            <p>
                Indica, sativa, and hybrid are probably some
                of the first words you'll see when shopping
                for cannabis. They're useful labels for
                talking about products, but they don't
                guarantee exactly how something will make
                you feel.
            </p>

            <p>
                The actual product has more information to
                offer. THC, CBD, other cannabinoids,
                terpenes, potency, product type, and your own
                response can all be part of the experience.
                Even two products with the same strain name
                may not be chemically identical.
            </p>

            <p>
                Our
                <router-link
                    :to="{ name: 'strain-guide' }"
                >
                    strain and terpene guide
                </router-link>
                helps make sense of those pieces without
                pretending a strain name or terpene can
                predict exactly how you'll feel.
            </p>

        </article>

        <!-- Display Product Label Guide -->
        <article
            id="read-label"
            aria-labelledby="read-label-heading"
        >

            <router-link
                :to="{ name: 'products' }"
                aria-label="Learn how to understand cannabis products and labels"
            >
                <img
                    :src="ProductImage"
                    alt="Cannabis product information and labels"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="read-label-heading">
                <router-link
                    :to="{ name: 'products' }"
                >
                    Learn to Read the Product, Not the Hype
                </router-link>
            </h3>

            <p>
                Cannabis packaging can throw a lot at you:
                THC percentages, milligrams, CBD ratios,
                serving sizes, terpene names, strain names,
                extraction terms, and plenty of marketing.
                Not all of those details mean the same thing.
            </p>

            <p>
                Start with the basics. What cannabinoids are
                present? How much THC is in one serving?
                How much is in the whole package? How is the
                product meant to be used? Is there testing
                information or a Certificate of Analysis?
                Those are more useful questions than whether
                the package promises the perfect vibe.
            </p>

            <p>
                Labels and laboratory reports can provide
                useful information, but they don't guarantee
                exactly how a product will affect you or
                prove every claim made about it.
            </p>

        </article>

        <!-- Display Safety Guide -->
        <article
            id="safety-tips"
            aria-labelledby="safety-tips-heading"
        >

            <router-link
                :to="{ name: 'safety' }"
                aria-label="Explore cannabis safety information"
            >
                <img
                    :src="SafetyImage"
                    alt="Cannabis safety information"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="safety-tips-heading">
                <router-link
                    :to="{ name: 'safety' }"
                >
                    Cannabis Safety Without the Lecture
                </router-link>
            </h3>

            <p>
                Cannabis safety is about more than repeating
                "start low and go slow." Different products
                come with different risks, and things like
                potency, medications, alcohol, driving,
                pregnancy, storage, mental health, and how
                often you use cannabis can all matter.
            </p>

            <p>
                Smoking, vaping, eating an edible, using a
                concentrate, and applying a topical also
                aren't interchangeable. How cannabis gets
                into the body can change how quickly effects
                begin, how long they last, and what risks
                deserve the most attention.
            </p>

            <p>
                Our
                <router-link
                    :to="{ name: 'safety' }"
                >
                    cannabis safety guide
                </router-link>
                covers THC, CBD, smoking, and topicals with
                practical information meant to help you
                understand risk instead of simply telling you
                what to do.
            </p>

        </article>

        <!-- Display Edible Tip -->
        <article
            id="edible-timing"
            aria-labelledby="edible-timing-heading"
        >

            <router-link
                :to="{ name: 'questions' }"
                aria-label="Learn about cannabis edible timing and safety"
            >
                <img
                    :src="QuestionsImage"
                    alt="Cannabis edible questions and information"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="edible-timing-heading">
                <router-link
                    :to="{ name: 'questions' }"
                >
                    Edibles Don't Run on Your Schedule
                </router-link>
            </h3>

            <p>
                One of the easiest cannabis mistakes to make
                is assuming an edible isn't working and
                taking more too soon. Swallowed cannabis can
                take much longer to produce intoxicating
                effects than inhaled cannabis, and those
                effects may last longer than expected.
            </p>

            <p>
                Food, the product, the amount of THC,
                medications, alcohol, and individual
                differences can all change the experience.
                There isn't one exact timeline that applies
                to everybody.
            </p>

            <p>
                Before using an edible, check how much THC is
                in one serving and how much is in the entire
                package. A whole package is not automatically
                one serving.
            </p>

        </article>

        <!-- Display Too Much Cannabis Guide -->
        <article
            id="too-much"
            aria-labelledby="too-much-heading"
        >

            <router-link
                :to="{ name: 'too-much' }"
                aria-label="Learn what to do after too much cannabis"
            >
                <img
                    :src="TooMuchImage"
                    alt="Too much cannabis help and information"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="too-much-heading">
                <router-link
                    :to="{ name: 'too-much' }"
                >
                    Too High? Know What to Do
                </router-link>
            </h3>

            <p>
                Sometimes someone uses more cannabis than
                they meant to. An uncomfortable reaction can
                include anxiety, panic, paranoia, confusion,
                a fast heart rate, severe nausea or vomiting,
                and other intense symptoms.
            </p>

            <p>
                If that happens, stop using more cannabis,
                get somewhere safe, and don't drive or do
                anything where impairment could cause an
                injury. Staying with a trusted sober person
                can also help.
            </p>

            <p>
                There isn't a proven instant trick that
                simply switches a cannabis high off. Our
                <router-link
                    :to="{ name: 'too-much' }"
                >
                    too much cannabis guide
                </router-link>
                explains what you can do, what symptoms to
                watch for, and when it's time to get more
                help.
            </p>

            <p>
                In the United States, Poison Control can be
                reached at
                <strong>1-800-222-1222</strong>.
                Call 911 for a medical emergency.
            </p>

        </article>

        <!-- Display Driving Safety Guide -->
        <article
            id="driving"
            aria-labelledby="driving-heading"
        >

            <router-link
                :to="{ name: 'safety' }"
                aria-label="Learn about cannabis and driving safety"
            >
                <img
                    :src="SafetyImage"
                    alt="Cannabis impairment and driving safety"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="driving-heading">
                <router-link
                    :to="{ name: 'safety' }"
                >
                    Don't Guess Whether You're Okay to Drive
                </router-link>
            </h3>

            <p>
                THC can affect attention, coordination,
                judgment, perception, and reaction time —
                all things that matter behind the wheel.
            </p>

            <p>
                Feeling less high isn't a reliable test that
                every driving skill has returned to normal,
                and there isn't one waiting period that
                guarantees every person is safe to drive
                after using cannabis.
            </p>

            <p>
                If cannabis is part of your plans, make
                transportation part of the plan too. Use a
                sober driver, rideshare, taxi, public
                transportation, or another option that
                doesn't put an impaired person behind the
                wheel.
            </p>

        </article>

        <!-- Display Cannabis Legality Guide -->
        <article
            id="legality"
            aria-labelledby="legality-heading"
        >

            <router-link
                :to="{ name: 'legality' }"
                aria-label="Explore cannabis laws across the United States"
            >
                <img
                    :src="LegalImage"
                    alt="United States cannabis legality guide"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="legality-heading">
                <router-link
                    :to="{ name: 'legality' }"
                >
                    Legal Here Doesn't Mean Legal Everywhere
                </router-link>
            </h3>

            <p>
                "Is cannabis legal?" sounds like a simple
                question until you try to answer it. Federal
                law, state law, medical programs, adult-use
                laws, hemp rules, local restrictions, and
                even where you are standing can change the
                answer.
            </p>

            <p>
                States can have different rules for medical
                cannabis, adult-use cannabis, hemp-derived
                cannabinoids, age requirements, possession,
                purchasing, home growing, public use,
                driving, product regulations, and other
                situations.
            </p>

            <p>
                Legal possession also doesn't automatically
                mean cannabis can be used everywhere.
                Workplaces, rental properties, hotels,
                campuses, federal property, and other places
                can have additional restrictions.
            </p>

            <p>
                Our
                <router-link
                    :to="{ name: 'legality' }"
                >
                    U.S. cannabis law guide
                </router-link>
                is where Best Buds puts the detailed legal
                information instead of assuming every visitor
                lives under the same rules.
            </p>

        </article>

        <!-- Display Federal Cannabis Law Guide -->
        <article
            id="federal-law"
            aria-labelledby="federal-law-heading"
        >

            <router-link
                :to="{ name: 'legality' }"
                aria-label="Learn about federal cannabis law"
            >
                <img
                    :src="LegalImage"
                    alt="Federal cannabis law information"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="federal-law-heading">
                <router-link
                    :to="{ name: 'legality' }"
                >
                    State Law Isn't the Whole Story
                </router-link>
            </h3>

            <p>
                A state allowing medical or adult-use
                cannabis does not erase federal cannabis law.
                That difference can matter for federal
                property, interstate transportation, and
                other situations involving federal law.
            </p>

            <p>
                Federal marijuana law changed in 2026, but
                federal scheduling is not the same for every
                marijuana product. State legalization also
                does not automatically make marijuana
                federally legal.
            </p>

            <p>
                Check our
                <router-link
                    :to="{
                        name: 'legality',
                        hash: '#federal-cannabis-status'
                    }"
                >
                    federal cannabis status
                </router-link>
                for the current explanation.
            </p>

            <p>
                Cannabis law changes often enough that Best
                Buds should always treat legal information as
                something to verify, not something to assume.
            </p>

            <p class="legal-review-date">
                Legal information last reviewed:
                September 2026
            </p>

        </article>

        <!-- Display Common Questions Guide -->
        <article
            id="questions"
            aria-labelledby="questions-heading"
        >

            <router-link
                :to="{ name: 'questions' }"
                aria-label="Explore common cannabis questions"
            >
                <img
                    :src="QuestionsImage"
                    alt="Common cannabis questions and answers"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="questions-heading">
                <router-link
                    :to="{ name: 'questions' }"
                >
                    Ask the Questions People Actually Ask
                </router-link>
            </h3>

            <p>
                What's the difference between THC and CBD?
                How long can an edible take? Does indica
                really make you sleepy? What's a
                concentrate? Can you take too much? Is
                vaping safer than smoking? What does a COA
                tell you? Can cannabis affect a drug test?
            </p>

            <p>
                Those are useful questions, and they're the
                kind of questions Best Buds should answer.
                Our
                <router-link
                    :to="{ name: 'questions' }"
                >
                    cannabis questions and answers
                </router-link>
                gets into the details without assuming you're
                already an expert.
            </p>

            <p>
                You shouldn't need a chemistry degree, a law
                degree, or ten years of cannabis experience
                to understand what you're looking at.
            </p>

        </article>

        <!-- Display Getting Started Questions -->
        <article
            id="getting-started"
            aria-labelledby="getting-started-heading"
        >

            <router-link
                :to="{ name: 'questions' }"
                aria-label="Explore cannabis questions for getting started"
            >
                <img
                    :src="QuestionsImage"
                    alt="Getting started with cannabis education"
                    loading="lazy"
                    decoding="async"
                />
            </router-link>

            <h3 id="getting-started-heading">
                <router-link
                    :to="{ name: 'questions' }"
                >
                    Not Sure Where to Start?
                </router-link>
            </h3>

            <p>
                Start with a few simple questions:
            </p>

            <ul>

                <li>
                    What kind of product is this?
                </li>

                <li>
                    Does it contain THC, CBD, or both?
                </li>

                <li>
                    How potent is it?
                </li>

                <li>
                    How is it supposed to be used?
                </li>

                <li>
                    How quickly might the effects begin?
                </li>

                <li>
                    What risks come with this method?
                </li>

                <li>
                    Could it interact with medications,
                    alcohol, or another substance?
                </li>

                <li>
                    Will I need to drive or do anything that
                    requires full attention?
                </li>

                <li>
                    How will I keep it away from children and
                    pets?
                </li>

                <li>
                    What are the laws where I am?
                </li>

            </ul>

            <p>
                You don't have to know everything about
                cannabis before you can start asking better
                questions. That's really what this section of
                Best Buds is here for.
            </p>

        </article>

    </div>

</template>

<script>
import ProductImage from "../../assets/tips-tricks/product.webp";
import StrainGuideImage from "../../assets/tips-tricks/strain-guide.webp";
import SafetyImage from "../../assets/tips-tricks/safety.webp";
import TooMuchImage from "../../assets/tips-tricks/too-much.webp";
import LegalImage from "../../assets/tips-tricks/legal.webp";
import QuestionsImage from "../../assets/tips-tricks/questions.webp";

export default {
    name: "TipsTricksGuide",

    data() {
        return {
            ProductImage,
            StrainGuideImage,
            SafetyImage,
            TooMuchImage,
            LegalImage,
            QuestionsImage
        };
    }
};
</script>

<style scoped>

/* =========================================================
   Tips & Tricks Guide
   ========================================================= */

#tips-tricks-guide {
    display: grid;

    grid-template-columns:
        repeat(
            2,
            minmax(
                0,
                1fr
            )
        );

    align-items: start;

    gap: 1.25rem;

    width: 100%;

    counter-reset:
        guide-number;
}


/* =========================================================
   Guide Card
   ========================================================= */

#tips-tricks-guide
> article {
    position: relative;

    display: flex;
    flex-direction: column;

    min-width: 0;
    height: 100%;

    overflow: hidden;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 10px 26px
        var(--color-shadow);

    counter-increment:
        guide-number;

    transition:
        transform 160ms ease,
        border-color 160ms ease,
        box-shadow 160ms ease;
}


/* Guide Card Hover */
#tips-tricks-guide
> article:hover {
    border-color:
        var(--color-border-strong);

    box-shadow:
        0 16px 36px
        var(--color-shadow-strong);

    transform:
        translateY(-3px);
}


/* =========================================================
   Guide Number
   ========================================================= */

#tips-tricks-guide
> article::before {
    position: absolute;

    top: 0.85rem;
    left: 0.85rem;

    padding:
        0.32rem
        0.55rem;

    background:
        var(--color-header-background);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    box-shadow:
        0 4px 12px
        var(--color-shadow);

    color:
        var(--color-gold-dark);

    font-size: 0.58rem;
    font-weight: 600;

    letter-spacing: 0.09em;

    text-transform: uppercase;

    backdrop-filter:
        blur(10px);

    -webkit-backdrop-filter:
        blur(10px);

    content:
        "Guide "
        counter(
            guide-number,
            decimal-leading-zero
        );

    z-index: 2;
}


/* =========================================================
   Guide Image
   ========================================================= */

#tips-tricks-guide
> article
> a:first-child {
    display: block;

    aspect-ratio:
        16 / 9;

    overflow: hidden;

    background:
        var(--color-surface-soft);

    border-bottom:
        1px solid
        var(--color-border);
}


/* Guide Image */
#tips-tricks-guide
> article
> a:first-child
img {
    width: 100%;
    height: 100%;

    object-fit: cover;

    transition:
        transform 220ms ease;
}


/* Image Hover */
#tips-tricks-guide
> article:hover
> a:first-child
img {
    transform:
        scale(1.025);
}


/* =========================================================
   Guide Heading
   ========================================================= */

#tips-tricks-guide
> article
> h3 {
    margin:
        1.25rem
        1.25rem
        0.8rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.2rem,
            3vw,
            1.55rem
        );

    font-weight: 600;

    line-height: 1.25;

    letter-spacing: -0.02em;
}


/* Guide Heading Link */
#tips-tricks-guide
> article
> h3
a {
    color: inherit;

    text-decoration: none;
}


/* Heading Link Hover */
#tips-tricks-guide
> article
> h3
a:hover {
    color:
        var(--color-primary);

    text-decoration: underline;

    text-decoration-color:
        var(--color-gold);

    text-decoration-thickness: 1px;

    text-underline-offset: 0.2em;
}


/* =========================================================
   Guide Paragraphs
   ========================================================= */

#tips-tricks-guide
> article
> p {
    margin:
        0
        1.25rem
        0.85rem;

    color:
        var(--color-text-soft);

    font-size: 0.84rem;

    line-height: 1.7;
}


/* Stronger First Paragraph */
#tips-tricks-guide
> article
> h3
+ p {
    color:
        var(--color-text);
}


/* Last Paragraph */
#tips-tricks-guide
> article
> p:last-child {
    margin-bottom: 1.3rem;
}


/* =========================================================
   Guide Lists
   ========================================================= */

#tips-tricks-guide
> article
> ul {
    display: grid;

    gap: 0.5rem;

    padding:
        0
        1.25rem
        0
        2.4rem;

    margin:
        0
        0
        1rem;

    color:
        var(--color-text-soft);

    font-size: 0.82rem;

    line-height: 1.6;
}


/* List Marker */
#tips-tricks-guide
> article
> ul
li::marker {
    color:
        var(--color-gold);
}


/* =========================================================
   Inline Guide Links
   ========================================================= */

#tips-tricks-guide
> article
> p
a {
    color:
        var(--color-primary);

    font-weight: 600;

    text-decoration-color:
        var(--color-gold);

    text-underline-offset: 0.2rem;
}


/* Inline Link Hover */
#tips-tricks-guide
> article
> p
a:hover {
    color:
        var(--color-primary-hover);
}


/* =========================================================
   Higher Attention Guides
   ========================================================= */

/*
 * These sections use the same card design,
 * with a subtle accent to help important
 * safety and legal information stand out.
 */

#too-much {
    border-top:
        3px solid
        var(--color-danger) !important;
}


#driving {
    border-top:
        3px solid
        var(--color-primary) !important;
}


#legality,
#federal-law {
    border-top:
        3px solid
        var(--color-gold) !important;
}


/* =========================================================
   Legal Review Date
   ========================================================= */

.legal-review-date {
    align-self: flex-start;

    margin:
        0
        1.25rem
        1.3rem !important;

    padding:
        0.38rem
        0.6rem;

    background:
        var(--color-gold-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text-soft) !important;

    font-size:
        0.64rem !important;

    line-height: 1.4 !important;
}


/* =========================================================
   Getting Started Card
   ========================================================= */

#getting-started {
    background:
        linear-gradient(
            145deg,
            var(--color-surface),
            var(--color-primary-soft)
        );
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 899.98px) {

    #tips-tricks-guide {
        grid-template-columns: 1fr;
    }


    #tips-tricks-guide
    > article {
        max-width: 42rem;

        margin:
            0
            auto;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #tips-tricks-guide {
        gap: 1rem;
    }


    #tips-tricks-guide
    > article
    > h3 {
        margin:
            1.1rem
            1rem
            0.7rem;
    }


    #tips-tricks-guide
    > article
    > p {
        margin:
            0
            1rem
            0.8rem;
    }


    #tips-tricks-guide
    > article
    > p:last-child {
        margin-bottom: 1.1rem;
    }


    #tips-tricks-guide
    > article
    > ul {
        padding:
            0
            1rem
            0
            2.1rem;
    }


    .legal-review-date {
        margin:
            0
            1rem
            1.1rem !important;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    #tips-tricks-guide
    > article,
    #tips-tricks-guide
    > article
    > a:first-child
    img {
        transition: none;
    }


    #tips-tricks-guide
    > article:hover {
        transform: none;
    }


    #tips-tricks-guide
    > article:hover
    > a:first-child
    img {
        transform: none;
    }

}

</style>