<!-- Keep Exploring Component -->
<template>
    <section
        v-if="exploration"
        aria-labelledby="keep-exploring-heading"
    >
        <!-- Exploration Category -->
        <h2 id="keep-exploring-heading">
            {{ exploration.category }}
        </h2>

        <!-- Exploration Message -->
        <p>
            {{ currentMessage }}
        </p>

        <!-- Suggested Next Destination -->
        <router-link
            :to="{ name: exploration.nextRoute }"
        >
            {{ exploration.nextLabel }} →
        </router-link>
    </section>
</template>

<script>
import explorationContent from "../../data/keep-exploring/exploration.js";

export default {
    name: "KeepExploring",

    data() {
        return {

            // Store the message selected for the current page
            currentMessage: ""

        };
    },

    computed: {

        // Get the exploration content for the current page
        exploration() {
            return explorationContent[this.$route.name] || null;
        }

    },

    watch: {

        // Select a new message whenever the user visits another page
        $route: {
            immediate: true,
            handler() {
                this.selectMessage();
            }
        }

    },

    methods: {

        // Select one of the messages available for the current page
        selectMessage() {
            if (
                !this.exploration ||
                this.exploration.messages.length === 0
            ) {
                this.currentMessage = "";
                return;
            }

            const randomIndex = Math.floor(
                Math.random() *
                this.exploration.messages.length
            );

            this.currentMessage =
                this.exploration.messages[randomIndex];
        }

    }
};
</script>

<style scoped>
</style>