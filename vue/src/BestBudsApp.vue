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
            <router-view />

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
                }
            }
        }

    },

    methods: {

        // Check whether the authenticated user has earned a new Drop
        checkForDrops() {
            this.hasCheckedForDrops = true;

            CollectibleService
                .checkForDrops()
                .then((response) => {
                    if (
                        response.status === 200
                        && response.data
                    ) {
                        this.newDrop = response.data;
                        this.isDropRevealOpen = true;
                    }
                })
                .catch((error) => {
                    console.error(
                        "Unable to check for new Drops:",
                        error
                    );
                });
        },

        // Close the Drop reveal
        closeDropReveal() {
            this.isDropRevealOpen = false;
        },

        // Continue to the user's My Stash collection
        viewStash() {
            this.isDropRevealOpen = false;

            this.$router.push({
                name: "my-stash"
            });
        }

    }
};
</script>

<style>

</style>