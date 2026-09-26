<!-- Best Buds Application -->
<template>
    <div id="app-container">
        <!-- Global application header -->
        <AppHeader />

        <!-- Main application content -->
        <main
            id="main-content"
            tabindex="-1"
        >
            <JumpLinks />

            <!-- Current page -->
            <router-view
                @activity-recorded="activityRecorded"
            />

            <!-- Suggested next destination -->
            <KeepExploring />
        </main>

        <!-- Global application footer -->
        <AppFooter />

        <!-- Best Buds Drop reveal -->
        <DropReveal
            :is-open="isDropRevealOpen"
            :user-collectible="newDrop"
            @close="closeDropReveal"
            @view-stash="viewStash"
        />
    </div>
</template>

<script>
import AppHeader from "./components/layout/Header.vue";
import JumpLinks from "./components/layout/JumpLinks.vue";
import KeepExploring from "./components/layout/KeepExploring.vue";
import AppFooter from "./components/layout/Footer.vue";
import DropReveal from "./components/collectibles/DropReveal.vue";

import CollectibleService from "./services/CollectibleService.js";

export default {
    name: "App",

    components: {
        AppHeader,
        JumpLinks,
        KeepExploring,
        AppFooter,
        DropReveal
    },

    data() {
        return {

            // Store the current Drop reveal state
            newDrop: null,
            dropQueue: [],
            isDropRevealOpen: false,
            hasCheckedForDrops: false

        };
    },

    computed: {

        // Check whether the user is ready to use the application
        isUserReady() {
            const onboardingRoutes = [
                "login",
                "register",
                "age-confirmation",
                "profile-setup"
            ];

            return this.$store.state.token !== ""
                && this.$store.state.user?.ageConfirmed
                && this.$store.state.profile
                && !onboardingRoutes.includes(
                    this.$route.name
                );
        }

    },

    watch: {

        // Check for new Drops after authentication and onboarding
        isUserReady: {
            immediate: true,

            handler(isUserReady) {
                if (
                    isUserReady
                    && !this.hasCheckedForDrops
                ) {
                    this.checkForDrops();
                }

                if (!isUserReady) {
                    this.hasCheckedForDrops = false;
                    this.clearDropQueue();
                }
            }
        }

    },

    methods: {

        // Check for new Drops after an activity is recorded
        activityRecorded() {
            this.checkForDrops();
        },

        // Check whether the authenticated user has earned new Drops
        checkForDrops() {
            this.hasCheckedForDrops = true;

            CollectibleService
                .checkForDrops()
                .then((response) => {
                    if (
                        response.status !== 200
                        || !Array.isArray(
                            response.data
                        )
                        || response.data.length === 0
                    ) {
                        return;
                    }

                    this.addDropsToQueue(
                        response.data
                    );

                    this.showNextDrop();
                })
                .catch((error) => {
                    console.error(
                        "Unable to check for new Drops:",
                        error
                    );
                });
        },

        // Add newly unlocked Drops to the reveal queue
        addDropsToQueue(newDrops) {

            newDrops.forEach((drop) => {

                const isCurrentDrop =
                    this.newDrop?.id
                    === drop.id;

                const isAlreadyQueued =
                    this.dropQueue.some(
                        (queuedDrop) =>
                            queuedDrop.id
                            === drop.id
                    );

                if (
                    !isCurrentDrop
                    && !isAlreadyQueued
                ) {
                    this.dropQueue.push(
                        drop
                    );
                }

            });

        },

        // Display the next Drop waiting to be revealed
        showNextDrop() {

            if (
                this.isDropRevealOpen
                || this.dropQueue.length === 0
            ) {
                return;
            }

            this.newDrop =
                this.dropQueue.shift();

            this.isDropRevealOpen = true;
        },

        // Close the current Drop and reveal the next one
        closeDropReveal() {
            this.isDropRevealOpen = false;
            this.newDrop = null;

            this.$nextTick(() => {
                this.showNextDrop();
            });
        },

        // Continue to the user's My Stash collection
        viewStash() {
            this.isDropRevealOpen = false;
            this.newDrop = null;
            this.dropQueue = [];

            this.$router.push({
                name: "my-stash"
            });
        },

        // Clear the Drop reveal state
        clearDropQueue() {
            this.newDrop = null;
            this.dropQueue = [];
            this.isDropRevealOpen = false;
        }

    }
};
</script>

<style>
img {
    max-height: 10rem;
}
</style>