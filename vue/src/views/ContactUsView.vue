<!-- Contact Us View Display -->
<template>

    <div
        id="contact-us-view"
        aria-labelledby="contact-us-heading"
    >

        <!-- =================================================
             Contact Page Introduction
             ================================================= -->

        <header id="contact-us-header">

            <!-- Header Content -->
            <div class="contact-header-content">

                <p class="contact-eyebrow">
                    Best Buds Contact
                </p>

                <h1 id="contact-us-heading">
                    Contact Us

                    <span>
                        We'd Like to Hear From You
                    </span>
                </h1>

                <p class="contact-introduction">
                    Have a question, suggestion, or something
                    you'd like to share about Best Buds?
                </p>

                <p class="contact-description">
                    Send us a message using the form below.
                    You can reach out about the app,
                    dispensary information, educational
                    content, or general feedback.
                </p>

            </div>


            <!-- Decorative Contact Graphic -->
            <div
                class="contact-header-visual"
                aria-hidden="true"
            >

                <span class="contact-ring ring-large"></span>
                <span class="contact-ring ring-medium"></span>


                <div class="contact-center">

                    <span>
                        Hello
                    </span>

                    <small>
                        Best Buds
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Contact Information
             ================================================= -->

        <aside class="contact-information">

            <span
                class="contact-information-icon"
                aria-hidden="true"
            >
                i
            </span>

            <div>

                <h2>
                    General Questions &amp; Feedback
                </h2>

                <p>
                    Please do not use this form for urgent
                    medical, safety, or emergency questions.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Contact Form
             ================================================= -->

        <section
            id="contact-us"
            aria-labelledby="contact-form-heading"
        >

            <!-- Section Header -->
            <header class="contact-section-header">

                <p class="contact-section-label">
                    Send a Message
                </p>

                <h2 id="contact-form-heading">
                    Get in Touch
                </h2>

                <p>
                    Fill out the form below and include
                    enough information for us to understand
                    what you're reaching out about.
                </p>

            </header>


            <ContactUsForm />

        </section>

    </div>

</template>


<script>

import ContactUsForm
    from "../components/contact/ContactUsForm.vue";


export default {

    name: "ContactUsView",

    components: {
        ContactUsForm
    }

};

</script>


<style scoped>

/* =========================================================
   Contact View
   ========================================================= */

#contact-us-view {
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
   Contact Header
   ========================================================= */

#contact-us-header {
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
.contact-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.contact-eyebrow,
.contact-section-label {
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
#contact-us-heading {
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
#contact-us-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.contact-introduction {
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
.contact-description {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.9rem;

    line-height: 1.7;
}


/* =========================================================
   Decorative Graphic
   ========================================================= */

.contact-header-visual {
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


.contact-ring {
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
    width: 66%;
    height: 66%;

    border-color:
        var(--color-gold);
}


.contact-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    width: 7rem;
    height: 7rem;

    background:
        var(--color-primary);

    border-radius: 50%;

    color:
        var(--color-background);

    box-shadow:
        0 16px 36px
        var(--color-shadow-strong);
}


.contact-center span {
    font-size: 0.78rem;
    font-weight: 600;

    letter-spacing: 0.12em;

    text-transform: uppercase;
}


.contact-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.52rem;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


/* =========================================================
   Information Note
   ========================================================= */

.contact-information {
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


.contact-information-icon {
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


.contact-information h2 {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text);

    font-size: 0.86rem;
    font-weight: 600;
}


.contact-information p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.6;
}


/* =========================================================
   Contact Form Section
   ========================================================= */

#contact-us {
    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


.contact-section-header {
    max-width: 44rem;

    margin-bottom: 1.5rem;
}


.contact-section-header h2 {
    margin:
        0
        0
        0.6rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.7rem,
            4vw,
            2.5rem
        );

    font-weight: 500;
}


.contact-section-header
> p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Responsive
   ========================================================= */

@media (max-width: 849.98px) {

    #contact-us-header {
        grid-template-columns: 1fr;
    }


    .contact-header-visual {
        width: 13rem;
    }

}


@media (max-width: 575.98px) {

    #contact-us-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #contact-us-header {
        padding:
            2rem
            1.4rem;
    }


    .contact-header-visual {
        display: none;
    }

}

</style>