<!-- Legality View Display -->
<template>

    <div
        id="legality-view"
        aria-labelledby="legality-heading"
    >

        <!-- Display Page Introduction -->
        <header id="legality-header">

            <h1 id="legality-heading">
                Cannabis Laws in the United States
            </h1>

            <h2>
                Cannabis Laws Can Change Depending on Where You Are
            </h2>

            <p>
                Cannabis laws differ across the United States.
                Some states allow adult-use cannabis, some allow
                medical cannabis, some permit only limited products,
                and others remain more restrictive.
            </p>

            <p>
                State legality also does not mean cannabis is
                allowed everywhere. Rules can differ for age,
                possession, purchasing, home growing, public use,
                driving, employment, housing, federal property,
                and crossing state lines.
            </p>

            <p>
                Use the interactive map below as a starting point,
                and verify important legal information with current
                state, local, and federal government sources.
            </p>

        </header>

        <!-- Display Federal Cannabis Status -->
        <section
            id="federal-cannabis-status"
            aria-labelledby="federal-cannabis-status-heading"
        >

            <h2 id="federal-cannabis-status-heading">
                Federal Cannabis Status in 2026
            </h2>

            <p>
                Federal marijuana law changed in 2026, but not all
                marijuana products are treated the same way.
            </p>

            <p>
                In April 2026, the U.S. Department of Justice and
                Drug Enforcement Administration placed FDA-approved
                marijuana products and marijuana products regulated
                under qualifying state medical-marijuana licenses
                into Schedule III of the federal Controlled
                Substances Act.
            </p>

            <p>
                The broader rescheduling process should not be
                described as complete unless the federal government
                issues a final change.
            </p>

            <p>
                State cannabis laws remain separate from federal law
                and can be more permissive or more restrictive
                depending on the activity, product, and location.
            </p>

            <p>
                <small>
                    Federal information last reviewed:
                    September 2026.
                </small>
            </p>

        </section>

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