<template>
    <div
        v-if="isOpen"
        class="drop-reveal-overlay"
        role="presentation"
        v-on:click.self="closeReveal"
    >
        <section
            class="drop-reveal"
            role="dialog"
            aria-modal="true"
            aria-labelledby="drop-reveal-heading"
        >
            <!-- Surprise state -->
            <div
                v-if="!isRevealed"
                class="drop-surprise"
            >
                <h2 id="drop-reveal-heading">
                    You've got a drop. 👀
                </h2>

                <p>
                    Something new just landed in your stash.
                </p>

                <button
                    type="button"
                    v-on:click="revealDrop"
                >
                    Reveal My Drop
                </button>
            </div>

            <!-- Revealed Drop -->
            <div
                v-else
                class="drop-result"
            >
                <p class="drop-label">
                    Best Buds Drop
                </p>

                <h2 id="drop-reveal-heading">
                    {{ collectibleName }}
                </h2>

                <p
                    v-if="collectibleDescription"
                    class="drop-description"
                >
                    {{ collectibleDescription }}
                </p>

                <p
                    v-if="collectibleRarity"
                    class="drop-rarity"
                >
                    {{ collectibleRarity }}
                </p>

                <button
                    type="button"
                    v-on:click="viewStash"
                >
                    View My Stash
                </button>
            </div>
        </section>
    </div>
</template>

<script>
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

        // Get the collectible from the user's unlocked collectible
        collectible() {

            if (!this.userCollectible) {
                return null;
            }

            return this.userCollectible.collectible;
        },

        // Get the collectible name
        collectibleName() {

            if (!this.collectible) {
                return "New Drop";
            }

            return this.collectible.name;
        },

        // Get the collectible description
        collectibleDescription() {

            if (!this.collectible) {
                return "";
            }

            return this.collectible.description;
        },

        // Format the collectible rarity for display
        collectibleRarity() {

            if (
                !this.collectible
                || !this.collectible.rarity
            ) {
                return "";
            }

            return this.collectible.rarity
                .toLowerCase()
                .replace(
                    /_/g,
                    " "
                )
                .replace(
                    /\b\w/g,
                    letter => letter.toUpperCase()
                );
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
/* Full-screen background behind the Drop reveal */
.drop-reveal-overlay {
    position: fixed;
    inset: 0;
    z-index: 1000;

    display: flex;
    align-items: center;
    justify-content: center;

    padding: 1.5rem;

    background: rgba(0, 0, 0, 0.7);
}

/* Drop reveal modal */
.drop-reveal {
    width: 100%;
    max-width: 32rem;

    padding: 2.5rem;

    background: #ffffff;
    border-radius: 1rem;

    text-align: center;

    box-shadow:
        0 1rem 3rem
        rgba(0, 0, 0, 0.35);
}

/* Surprise and revealed Drop content */
.drop-surprise,
.drop-result {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 1rem;
}

.drop-reveal h2,
.drop-reveal p {
    margin: 0;
}

/* Small label shown after revealing the Drop */
.drop-label {
    font-weight: 700;
    text-transform: uppercase;
    letter-spacing: 0.08em;
}

/* Drop rarity */
.drop-rarity {
    font-weight: 700;
}

/* Drop reveal actions */
.drop-reveal button {
    margin-top: 0.75rem;
    padding: 0.75rem 1.5rem;

    border: none;
    border-radius: 0.5rem;

    cursor: pointer;
}

/* Keep the modal comfortable on smaller screens */
@media (max-width: 600px) {
    .drop-reveal-overlay {
        padding: 1rem;
    }

    .drop-reveal {
        padding: 2rem 1.5rem;
    }
}
</style>