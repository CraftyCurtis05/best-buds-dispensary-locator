<!-- Drop Card Component Display -->
<template>

    <article class="drop-card">

        <!-- Display Drop Artwork -->
        <img
            v-if="dropArtwork"
            class="drop-artwork"
            :src="dropArtwork"
            :alt="dropArtworkAlt"
        />

        <!-- Display Drop Information -->
        <div class="drop-information">

            <p
                v-if="formattedUnlockedDate"
                class="drop-unlocked-date"
            >
                Unlocked {{ formattedUnlockedDate }}
            </p>

        </div>

    </article>

</template>

<script>
import {
    getDropArtwork
} from "../../data/collectibles/dropArtwork.js";

export default {
    name: "DropCard",

    props: {

        userCollectible: {
            type: Object,
            required: true
        }

    },

    computed: {

        // Get the collectible information
        collectible() {
            return this.userCollectible.collectible || {};
        },

        // Get the artwork for the collectible
        dropArtwork() {

            return getDropArtwork(
                this.collectible.name
            );

        },

        // Get accessible text for the Drop artwork
        dropArtworkAlt() {

            if (!this.collectible.name) {
                return "Best Buds Drop";
            }

            return `${this.collectible.name} Best Buds Drop`;
        },

        // Format the date the collectible was unlocked
        formattedUnlockedDate() {

            if (!this.userCollectible.unlockedAt) {
                return "";
            }

            const unlockedDate =
                new Date(
                    this.userCollectible.unlockedAt
                );

            if (
                Number.isNaN(
                    unlockedDate.getTime()
                )
            ) {
                return "";
            }

            return unlockedDate.toLocaleDateString(
                undefined,
                {
                    year: "numeric",
                    month: "short",
                    day: "numeric"
                }
            );

        }

    }
};
</script>

<style scoped>

</style>