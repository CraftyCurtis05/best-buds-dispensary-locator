<!-- Saved Dispensaries Component Display -->
<template>

    <section
        class="saved-dispensaries"
        aria-label="Saved dispensaries"
    >

        <!-- Display Loading Message -->
        <p
            v-if="isLoading"
            class="saved-dispensaries-status"
            role="status"
        >
            Loading saved dispensaries...
        </p>

        <!-- Display Error Message -->
        <p
            v-else-if="errorMessage"
            class="saved-dispensaries-error"
            role="alert"
        >
            {{ errorMessage }}
        </p>

        <!-- Display Empty Message -->
        <div
            v-else-if="!savedDispensaries.length"
            class="saved-dispensaries-empty"
        >

            <p>
                You haven't saved any dispensaries yet.
            </p>

            <RouterLink
                :to="{ name: 'search' }"
                class="saved-dispensaries-search-link"
            >
                Find Dispensaries
            </RouterLink>

        </div>

        <!-- Display Saved Dispensaries -->
        <ul
            v-else
            class="saved-dispensaries-list"
        >

            <li
                v-for="dispensary in savedDispensaries"
                :key="dispensary.yelpBusinessId"
                class="saved-dispensary"
            >

                <SavedDispensaryCard
                    :dispensary="dispensary"
                    :is-removing="
                        isRemoving(
                            dispensary.yelpBusinessId
                        )
                    "
                    @remove="deleteSavedDispensary"
                />

            </li>

        </ul>

    </section>

</template>

<script>
import SavedDispensaryCard
    from "./SavedDispensaryCard.vue";
import SavedDispensaryService
    from "../../services/SavedDispensaryService.js";

export default {
    name: "SavedDispensaries",

    components: {
        SavedDispensaryCard
    },

    data() {
        return {
            savedDispensaries: [],
            isLoading: true,
            deletingDispensaryID: null,
            errorMessage: ""
        };
    },

    created() {

        // Load the user's saved dispensaries
        this.loadSavedDispensaries();

    },

    methods: {

        // Load the user's saved dispensaries
        async loadSavedDispensaries() {

            this.isLoading = true;
            this.errorMessage = "";

            try {

                const response =
                    await SavedDispensaryService
                        .getSavedDispensaries();

                if (response.status === 200) {
                    this.savedDispensaries =
                        response.data || [];
                }

            } catch (error) {

                console.error(
                    "Unable to load saved dispensaries:",
                    error
                );

                this.errorMessage =
                    "Unable to load your saved dispensaries.";

            } finally {
                this.isLoading = false;
            }

        },

        // Check if a dispensary is currently being removed
        isRemoving(yelpBusinessId) {

            return this.deletingDispensaryID
                === yelpBusinessId;

        },

        // Remove a dispensary from the user's saved dispensaries
        async deleteSavedDispensary(
            yelpBusinessId
        ) {

            this.deletingDispensaryID =
                yelpBusinessId;

            this.errorMessage = "";

            try {

                const response =
                    await SavedDispensaryService
                        .deleteSavedDispensary(
                            yelpBusinessId
                        );

                if (response.status === 204) {

                    this.savedDispensaries =
                        this.savedDispensaries.filter(
                            (dispensary) =>
                                dispensary.yelpBusinessId
                                    !== yelpBusinessId
                        );

                }

            } catch (error) {

                console.error(
                    "Unable to remove saved dispensary:",
                    error
                );

                this.errorMessage =
                    "Unable to remove this dispensary.";

            } finally {
                this.deletingDispensaryID = null;
            }

        }

    }
};
</script>

<style scoped>

</style>