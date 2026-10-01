<!-- Legality View Display -->
<template>

    <div
        id="legality-view"
        aria-labelledby="legality-heading"
    >

        <!-- Display Page Introduction -->
        <header id="legality-header">

            <h1 id="legality-heading">
                Cannabis Legality In Each State
            </h1>

            <h2>
                Ever wondered if your cannabis stash is legal
                or if you're just a really optimistic rebel?
            </h2>

            <p>
                States like California and Colorado are rolling
                out the green carpet for adults 21+, with legal
                shops and chill vibes. Many states have medical
                programs where patients get the green light
                with a doctor's thumbs-up. Some states have
                turned down the legal heat, making minor
                offenses more about a fine than a felony.
                States are dancing to their own beat, while
                federal rules are like the old-school DJ trying
                to keep things under control. In short, it's a
                legal jamboree with states setting their own
                rules while federal law lingers in the
                background!
            </p>

            <p>
                Select a state on the interactive map below
                to view its cannabis laws.
            </p>

        </header>

        <!-- Display Cannabis Legality -->
        <section
            id="cannabis-legality"
            aria-labelledby="cannabis-legality-heading"
        >

            <h2 id="cannabis-legality-heading">
                Cannabis Laws By State
            </h2>

            <LegalityMap />

        </section>

    </div>

</template>

<script>
import LegalityMap from "../components/legality/LegalityMap.vue";

import UserActivityService from "../services/UserActivityService.js";

import {USER_ACTIVITY_TYPES} from "../constants/userActivityTypes.js";

export default {
    name: "LegalityView",

    components: {
        LegalityMap
    },

    emits: [
        "activity-recorded"
    ],

    mounted() {
        this.recordEducationView();
    },

    methods: {

        // Record that the user explored cannabis legality education
        recordEducationView() {

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.EDUCATION_VIEW,
                    "legality"
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {
                    // Activity tracking should not block education content
                });

        }

    }
};
</script>

<style scoped>

</style>