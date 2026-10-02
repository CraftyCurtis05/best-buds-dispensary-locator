<!-- Drop Reveal Component Display -->
<template>

    <div
        v-if="isOpen"
        class="drop-reveal-overlay"
        @click.self="closeReveal"
    >

        <div
            class="drop-reveal"
            role="dialog"
            aria-modal="true"
            aria-labelledby="drop-reveal-heading"
        >

            <!-- Display Drop Surprise -->
            <div
                v-if="!isRevealed"
                class="drop-surprise"
            >

                <h2 id="drop-reveal-heading">
                    You've got a Drop. 👀
                </h2>

                <p>
                    Something new just landed in your stash.
                </p>

                <button
                    type="button"
                    @click="revealDrop"
                >
                    Reveal My Drop
                </button>

            </div>

            <!-- Display Revealed Drop -->
            <div
                v-else
                class="drop-result"
            >

                <h2 id="drop-reveal-heading">
                    Drop Unlocked!
                </h2>

                <!-- Display Drop Artwork -->
                <img
                    v-if="dropArtwork"
                    class="drop-reveal-artwork"
                    :src="dropArtwork"
                    :alt="dropArtworkAlt"
                />

                <!-- Display Drop Name -->
                <p v-else>
                    {{ collectibleName }}
                </p>

                <!-- Display Stash Link -->
                <button
                    type="button"
                    @click="viewStash"
                >
                    View My Stash
                </button>

            </div>

        </div>

    </div>

</template>

<script>
import {
    getDropArtwork
} from "../../data/collectibles/dropArtwork.js";

export default {
    name: "DropReveal",

    props: {

        isOpen: {
            type: Boolean,
            default: false
        },

        userCollectible: {
            type: Object,
            default: null
        }

    },

    emits: [
        "close",
        "view-stash"
    ],

    data() {
        return {
            isRevealed: false
        };
    },

    computed: {

        // Get the collectible information
        collectible() {

            if (!this.userCollectible) {
                return {};
            }

            return this.userCollectible.collectible
                || {};

        },

        // Get the collectible name
        collectibleName() {

            return this.collectible.name
                || "New Drop";

        },

        // Get the artwork for the collectible
        dropArtwork() {

            return getDropArtwork(
                this.collectible.code
            );

        },

        // Get accessible text for the Drop artwork
        dropArtworkAlt() {

            return `${this.collectibleName} Best Buds Drop`;

        }

    },

    watch: {

        // Reset the reveal when a Drop is opened
        isOpen(isOpen) {

            if (isOpen) {
                this.isRevealed = false;
            }

        }

    },

    methods: {

        // Reveal the newly unlocked Drop
        revealDrop() {

            this.isRevealed = true;

        },

        // Close the Drop reveal
        closeReveal() {

            this.$emit(
                "close"
            );

        },

        // Continue to the user's My Stash collection
        viewStash() {

            this.$emit(
                "view-stash"
            );

        }

    }
};
</script>

<style scoped>

/* =========================================================
   Drop Reveal Overlay
   ========================================================= */

.drop-reveal-overlay {
    position: fixed;
    inset: 0;

    display: flex;
    align-items: center;
    justify-content: center;

    padding: 1.5rem;

    background:
        var(--color-overlay);

    backdrop-filter:
        blur(8px);

    -webkit-backdrop-filter:
        blur(8px);

    z-index: 1000;
}


/* =========================================================
   Drop Reveal
   ========================================================= */

.drop-reveal {
    position: relative;

    width:
        min(
            100%,
            32rem
        );

    max-height:
        calc(
            100vh
            - 3rem
        );

    overflow-y: auto;

    padding:
        clamp(
            1.5rem,
            5vw,
            2.5rem
        );

    background:
        linear-gradient(
            145deg,
            var(--color-surface),
            var(--color-surface-soft)
        );

    border:
        1px solid
        var(--color-border-strong);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 24px 70px
        var(--color-shadow-strong);

    color:
        var(--color-text);

    text-align: center;
}


/* Decorative Ring */
.drop-reveal::before {
    position: absolute;

    top: -5rem;
    right: -5rem;

    width: 12rem;
    height: 12rem;

    border:
        1px solid
        var(--color-gold-soft);

    border-radius: 50%;

    content: "";

    pointer-events: none;
}


/* =========================================================
   Surprise / Result
   ========================================================= */

.drop-surprise,
.drop-result {
    position: relative;

    display: flex;
    flex-direction: column;
    align-items: center;

    gap: 1rem;

    z-index: 1;
}


/* Heading */
.drop-reveal h2 {
    margin: 0;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.5rem,
            5vw,
            2.2rem
        );

    font-weight: 500;

    line-height: 1.15;

    letter-spacing: -0.03em;
}


/* Text */
.drop-reveal p {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.6;
}


/* =========================================================
   Drop Artwork
   ========================================================= */

.drop-reveal-artwork {
    display: block;

    width: auto;
    max-width: 100%;

    max-height: 24rem;

    object-fit: contain;

    margin:
        0.5rem
        auto;

    border-radius:
        var(--border-radius-medium);

    filter:
        drop-shadow(
            0 12px 20px
            var(--color-shadow-strong)
        );
}


/* =========================================================
   Drop Reveal Button
   ========================================================= */

.drop-reveal button {
    min-height: 2.8rem;

    padding:
        0.6rem
        1rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-background);

    font-size: 0.78rem;
    font-weight: 600;

    cursor: pointer;

    transition:
        background 160ms ease,
        transform 160ms ease;
}


/* Button Hover */
.drop-reveal
button:hover {
    background:
        var(--color-primary-hover);

    transform:
        translateY(-2px);
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    .drop-reveal-overlay {
        padding: 0.75rem;
    }


    .drop-reveal {
        max-height:
            calc(
                100vh
                - 1.5rem
            );
    }


    .drop-reveal-artwork {
        max-height: 19rem;
    }


    .drop-reveal button {
        width: 100%;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .drop-reveal button {
        transition: none;
    }


    .drop-reveal
    button:hover {
        transform: none;
    }

}

</style>