<template>
    <section
        class="my-stash"
        aria-labelledby="my-stash-heading"
    >
        <!-- My Stash heading -->
        <header class="my-stash-header">
            <h2 id="my-stash-heading">
                My Stash
            </h2>

            <p>
                Your collection of Best Buds Drops.
            </p>
        </header>

        <!-- Loading state -->
        <p
            v-if="isLoading"
            class="my-stash-status"
            role="status"
        >
            Loading your stash...
        </p>

        <!-- Error state -->
        <p
            v-else-if="errorMessage"
            class="my-stash-error"
            role="alert"
        >
            {{ errorMessage }}
        </p>

        <!-- Empty state -->
        <div
            v-else-if="collectibles.length === 0"
            class="my-stash-empty"
        >
            <p>
                Your stash is empty.
            </p>

            <p>
                Explore Best Buds to discover Drops
                and grow your collection.
            </p>
        </div>

        <!-- Unlocked Drops -->
        <ul
            v-else
            class="my-stash-list"
        >
            <li
                v-for="userCollectible in collectibles"
                v-bind:key="userCollectible.id"
                class="my-stash-item"
            >
                <article class="drop-card">

                    <!-- Drop information -->
                    <div class="drop-content">
                        <h3>
                            {{ userCollectible.collectible.name }}
                        </h3>

                        <p
                            v-if="userCollectible.collectible.description"
                            class="drop-description"
                        >
                            {{
                                userCollectible.collectible.description
                            }}
                        </p>

                        <p
                            v-if="userCollectible.collectible.rarity"
                            class="drop-rarity"
                        >
                            Rarity:
                            {{
                                formatRarity(
                                    userCollectible.collectible.rarity
                                )
                            }}
                        </p>

                        <p
                            v-if="userCollectible.unlockedAt"
                            class="drop-unlocked-date"
                        >
                            Unlocked
                            {{
                                formatUnlockedDate(
                                    userCollectible.unlockedAt
                                )
                            }}
                        </p>
                    </div>

                </article>
            </li>
        </ul>
    </section>
</template>

<script>
import CollectibleService
    from "../../services/CollectibleService.js";

export default {
    name: "MyStash",

    data() {
        return {
            collectibles: [],
            isLoading: true,
            errorMessage: ""
        };
    },

    created() {
        this.loadCollectibles();
    },

    methods: {

        // Load the authenticated user's unlocked collectibles
        loadCollectibles() {

            this.isLoading = true;
            this.errorMessage = "";

            CollectibleService.getCollectibles()
            .then(response => {

                this.collectibles =
                    response.data || [];
            })
            .catch(error => {

                console.error(
                    "Unable to load collectibles:",
                    error
                );

                this.errorMessage =
                    "Unable to load your stash.";
            })
            .finally(() => {
                this.isLoading = false;
            });
        },

        // Format the collectible rarity for display
        formatRarity(rarity) {

            if (!rarity) {
                return "";
            }

            return rarity
                .toLowerCase()
                .replace(
                    /_/g,
                    " "
                )
                .replace(
                    /\b\w/g,
                    letter => letter.toUpperCase()
                );
        },

        // Format the date the collectible was unlocked
        formatUnlockedDate(unlockedAt) {

            const unlockedDate =
                new Date(
                    unlockedAt
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