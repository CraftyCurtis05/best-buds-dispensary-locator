<!-- Drop Reveal Component Display -->
<template>

    <div
        v-if="isOpen"
        class="drop-reveal-overlay"
        @click.self="closeReveal"
    >

        <section
            class="drop-reveal"
            role="dialog"
            aria-modal="true"
            aria-labelledby="drop-reveal-heading"
        >

            <!-- Display Surprise -->
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

                <img
                    v-if="dropArtwork"
                    class="drop-reveal-artwork"
                    :src="dropArtwork"
                    :alt="dropArtworkAlt"
                />

                <p v-else>
                    {{ collectibleName }}
                </p>

                <button
                    type="button"
                    @click="viewStash"
                >
                    View My Stash
                </button>

            </div>

        </section>

    </div>

</template>

<script>
import {
    getDropArtwork
} from "../../data/collectibles/dropArtwork.js";

export default {
    name: "DropReveal",

    props: {

        // Control whether the Drop reveal is displayed
        isOpen: {
            type: Boolean,
            default: false
        },

        // Newly unlocked collectible returned by the backend
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

            return this.userCollectible.collectible || {};
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

        // Reset the reveal when a new Drop is opened
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

/* Cover the application while a Drop is being revealed */
.drop-reveal-overlay {
    position: fixed;
    inset: 0;
    z-index: 1000;

    display: flex;
    align-items: center;
    justify-content: center;

    padding: 1.5rem;

    background: rgba(0, 0, 0, 0.75);
}

/* Display the Drop reveal modal */
.drop-reveal {
    width: min(100%, 32rem);
    max-height: calc(100vh - 3rem);
    overflow-y: auto;

    padding: 2rem;

    background: #ffffff;
    border-radius: 1rem;

    text-align: center;
}

/* Organize the surprise and revealed Drop content */
.drop-surprise,
.drop-result {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 1rem;
}

/* Display the unlocked Drop artwork */
.drop-reveal-artwork {
    display: block;

    width: auto;
    max-width: 100%;
    height: auto;
}

/* Display modal actions */
.drop-reveal button {
    cursor: pointer;
}

</style>