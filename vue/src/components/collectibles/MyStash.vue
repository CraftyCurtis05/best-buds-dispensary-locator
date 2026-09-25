<!-- My Stash Component Display -->
<template>

    <section
        class="my-stash"
        aria-label="Best Buds Drops"
    >

        <!-- Display Loading Message -->
        <p
            v-if="isLoading"
            class="my-stash-status"
            role="status"
        >
            Loading your stash...
        </p>

        <!-- Display Error Message -->
        <p
            v-else-if="errorMessage"
            class="my-stash-error"
            role="alert"
        >
            {{ errorMessage }}
        </p>

        <!-- Display Empty Message -->
        <div
            v-else-if="!collectibles.length"
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

        <!-- Display Unlocked Drops -->
        <ul
            v-else
            class="my-stash-list"
        >

            <li
                v-for="userCollectible in collectibles"
                :key="userCollectible.id"
                class="my-stash-item"
            >

                <DropCard
                    :user-collectible="userCollectible"
                />

            </li>

        </ul>

    </section>

</template>

<script>
import DropCard from "../collectibles/DropCard.vue";
import CollectibleService from "../../services/CollectibleService.js";

export default {
    name: "MyStash",

    components: {
        DropCard
    },

    data() {
        return {
            collectibles: [],
            isLoading: true,
            errorMessage: ""
        };
    },

    created() {

        // Load the user's unlocked Drops
        this.loadCollectibles();

    },

    methods: {

        // Load the user's unlocked Drops
        loadCollectibles() {

            this.isLoading = true;
            this.errorMessage = "";

            CollectibleService
                .getCollectibles()
                .then((response) => {

                    this.collectibles =
                        response.data || [];

                })
                .catch((error) => {

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

        }

    }
};
</script>

<style scoped>

</style>