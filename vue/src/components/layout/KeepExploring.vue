<!-- Keep Exploring Component Display -->
<template>

    <section
        v-if="exploration"
        id="keep-exploring"
        aria-labelledby="
            keep-exploring-heading
        "
    >

        <!-- Decorative Accent -->
        <div
            class="exploration-decoration"
            aria-hidden="true"
        >

            <span class="exploration-ring ring-one"></span>
            <span class="exploration-ring ring-two"></span>

        </div>


        <!-- Keep Exploring Content -->
        <div class="exploration-content">

            <!-- Section Label -->
            <p class="exploration-label">
                Keep Exploring
            </p>


            <!-- Exploration Category -->
            <h2 id="keep-exploring-heading">
                {{ exploration.category }}
            </h2>


            <!-- Exploration Message -->
            <p class="exploration-message">
                {{ currentMessage }}
            </p>


            <!-- Suggested Next Destination -->
            <router-link
                :to="{
                    name:
                        exploration.nextRoute
                }"
                class="exploration-link"
            >

                <span>
                    {{ exploration.nextLabel }}
                </span>

                <span
                    class="exploration-arrow"
                    aria-hidden="true"
                >
                    →
                </span>

            </router-link>

        </div>


        <!-- Visual Number -->
        <div
            class="exploration-mark"
            aria-hidden="true"
        >
            Next
        </div>

    </section>

</template>


<script>

import explorationContent
    from "../../data/keep-exploring/exploration.js";


export default {

    name: "KeepExploring",

    data() {

        return {

            // Store the message selected
            // for the current page
            currentMessage: ""

        };

    },

    computed: {

        // Get exploration content
        // for the current page
        exploration() {

            return (
                explorationContent[
                    this.$route.name
                ]
                || null
            );

        }

    },

    watch: {

        // Select a new message when
        // the user visits another page
        $route: {

            immediate: true,

            handler() {

                this.selectMessage();

            }

        }

    },

    methods: {

        // Select one message for the current page
        selectMessage() {

            if (
                !this.exploration
                ||
                this.exploration
                    .messages
                    .length === 0
            ) {

                this.currentMessage = "";

                return;

            }

            const randomIndex =
                Math.floor(
                    Math.random()
                    *
                    this.exploration
                        .messages
                        .length
                );

            this.currentMessage =
                this.exploration
                    .messages[
                        randomIndex
                    ];

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Keep Exploring
   ========================================================= */

#keep-exploring {
    position: relative;

    display: grid;

    grid-template-columns:
        minmax(
            0,
            1fr
        )
        auto;

    align-items: center;

    gap: 2rem;

    width:
        min(
            calc(100% - 2rem),
            76rem
        );

    margin:
        clamp(
            3rem,
            8vw,
            6rem
        )
        auto;

    overflow: hidden;

    padding:
        clamp(
            1.6rem,
            5vw,
            3rem
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
        0 18px 45px
        var(--color-shadow-strong);

    color:
        var(--color-text-light);

    isolation: isolate;
}


/* =========================================================
   Decorative Rings
   ========================================================= */

.exploration-decoration {
    position: absolute;

    top: 50%;
    right: -7rem;

    width: 18rem;
    height: 18rem;

    transform:
        translateY(-50%);

    opacity: 0.2;

    pointer-events: none;

    z-index: -1;
}


/* Exploration Ring */
.exploration-ring {
    position: absolute;

    top: 50%;
    left: 50%;

    border:
        1px solid
        var(--color-gold);

    border-radius: 50%;

    transform:
        translate(
            -50%,
            -50%
        );
}


/* Large Ring */
.ring-one {
    width: 100%;
    height: 100%;
}


/* Small Ring */
.ring-two {
    width: 58%;
    height: 58%;
}


/* =========================================================
   Exploration Content
   ========================================================= */

.exploration-content {
    max-width: 45rem;
}


/* Section Label */
.exploration-label {
    margin:
        0
        0
        0.55rem;

    color:
        var(--color-gold);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.18em;

    text-transform: uppercase;
}


/* Exploration Heading */
#keep-exploring h2 {
    margin:
        0
        0
        0.85rem;

    color:
        var(--color-text-light);

    font-size:
        clamp(
            1.6rem,
            4vw,
            2.5rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.025em;
}


/* Exploration Message */
.exploration-message {
    max-width: 39rem;

    margin:
        0
        0
        1.5rem;

    color:
        var(--color-footer-text-soft);

    font-size:
        clamp(
            0.9rem,
            2vw,
            1rem
        );

    line-height: 1.7;
}


/* =========================================================
   Exploration Link
   ========================================================= */

.exploration-link {
    display: inline-flex;
    align-items: center;

    gap: 0.7rem;

    min-height: 2.8rem;

    padding:
        0.6rem
        1rem;

    background:
        var(--color-gold);

    border:
        1px solid
        var(--color-gold);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-footer-background);

    font-size: 0.8rem;
    font-weight: 600;

    text-decoration: none;

    transition:
        transform 160ms ease,
        background 160ms ease;
}


/* Exploration Link Hover */
.exploration-link:hover {
    background:
        var(--color-gold-dark);

    transform:
        translateY(-2px);
}


/* Exploration Arrow */
.exploration-arrow {
    font-size: 1rem;

    transition:
        transform 160ms ease;
}


/* Exploration Arrow Hover */
.exploration-link:hover
.exploration-arrow {
    transform:
        translateX(4px);
}


/* =========================================================
   Exploration Mark
   ========================================================= */

.exploration-mark {
    position: relative;

    display: grid;
    place-items: center;

    width: 6.5rem;
    height: 6.5rem;

    border:
        1px solid
        var(--color-gold);

    border-radius: 50%;

    color:
        var(--color-gold);

    font-size: 0.65rem;
    font-weight: 600;

    letter-spacing: 0.15em;

    text-transform: uppercase;

    z-index: 1;
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 699.98px) {

    #keep-exploring {
        grid-template-columns: 1fr;

        gap: 1.5rem;

        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );
    }


    .exploration-mark {
        width: 4.5rem;
        height: 4.5rem;
    }


    .exploration-decoration {
        right: -10rem;
    }

}


/* =========================================================
   Small Mobile
   ========================================================= */

@media (max-width: 420px) {

    .exploration-mark {
        display: none;
    }


    .exploration-link {
        width: 100%;

        justify-content: space-between;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .exploration-link,
    .exploration-arrow {
        transition: none;
    }


    .exploration-link:hover,
    .exploration-link:hover
    .exploration-arrow {
        transform: none;
    }

}

</style>