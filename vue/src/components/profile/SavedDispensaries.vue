<template>
    <section
        class="saved-dispensaries"
        aria-labelledby="saved-dispensaries-heading"
    >
        <!-- Saved dispensaries heading -->
        <header class="saved-dispensaries-header">
            <h2 id="saved-dispensaries-heading">
                Saved Dispensaries
            </h2>

            <p>
                Keep track of dispensaries you want to visit again.
            </p>
        </header>

        <!-- Loading state -->
        <p
            v-if="isLoading"
            class="saved-dispensaries-status"
            role="status"
        >
            Loading saved dispensaries...
        </p>

        <!-- Error state -->
        <p
            v-else-if="errorMessage"
            class="saved-dispensaries-error"
            role="alert"
        >
            {{ errorMessage }}
        </p>

        <!-- Empty state -->
        <div
            v-else-if="savedDispensaries.length === 0"
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

        <!-- Saved dispensary list -->
        <ul
            v-else
            class="saved-dispensaries-list"
        >
            <li
                v-for="dispensary in savedDispensaries"
                :key="dispensary.yelpBusinessId"
                class="saved-dispensary"
            >
                <article class="saved-dispensary-card">

                    <!-- Dispensary image -->
                    <div
                        v-if="dispensary.imageUrl"
                        class="saved-dispensary-image"
                    >
                        <img
                            :src="dispensary.imageUrl"
                            :alt="`${dispensary.name} dispensary`"
                        >
                    </div>

                    <!-- Dispensary information -->
                    <div class="saved-dispensary-content">
                        <h3>
                            {{ dispensary.name }}
                        </h3>

                        <p
                            v-if="dispensary.rating !== null"
                            class="saved-dispensary-rating"
                        >
                            Rating:
                            {{ dispensary.rating }}
                            / 5
                        </p>

                        <address class="saved-dispensary-address">
                            <span v-if="dispensary.address">
                                {{ dispensary.address }}
                            </span>

                            <span>
                                {{ formatLocation(dispensary) }}
                            </span>
                        </address>

                        <p
                            v-if="dispensary.savedAt"
                            class="saved-dispensary-date"
                        >
                            Saved
                            {{ formatSavedDate(dispensary.savedAt) }}
                        </p>
                    </div>

                    <!-- Dispensary controls -->
                    <div class="saved-dispensary-controls">
                        <button
                            type="button"
                            :disabled="
                                deletingDispensaryId
                                === dispensary.yelpBusinessId
                            "
                            @click="
                                deleteSavedDispensary(
                                    dispensary.yelpBusinessId
                                )
                            "
                        >
                            {{
                                deletingDispensaryId
                                        === dispensary.yelpBusinessId
                                    ? "Removing..."
                                    : "Remove"
                            }}
                        </button>
                    </div>

                </article>
            </li>
        </ul>
    </section>
</template>

<script>
import savedDispensaryService
    from "../../services/SavedDispensaryService";

export default {
    name: "SavedDispensaries",

    data() {
        return {
            savedDispensaries: [],
            isLoading: true,
            deletingDispensaryId: null,
            errorMessage: ""
        };
    },

    created() {
        this.loadSavedDispensaries();
    },

    methods: {
        // Load the authenticated user's saved dispensaries
        async loadSavedDispensaries() {

            this.isLoading = true;
            this.errorMessage = "";

            try {
                const response =
                        await savedDispensaryService
                                .getSavedDispensaries();

                if (response.status === 200) {
                    this.savedDispensaries =
                            response.data;
                }

            } catch (error) {
                this.errorMessage =
                        "Unable to load your saved dispensaries.";

            } finally {
                this.isLoading = false;
            }
        },

        // Remove a dispensary from the user's saved dispensaries
        async deleteSavedDispensary(
            yelpBusinessId
        ) {

            this.deletingDispensaryId =
                    yelpBusinessId;

            this.errorMessage = "";

            try {
                const response =
                        await savedDispensaryService
                                .deleteSavedDispensary(
                                    yelpBusinessId
                                );

                if (response.status === 204) {
                    this.savedDispensaries =
                            this.savedDispensaries.filter(
                                dispensary =>
                                    dispensary.yelpBusinessId
                                        !== yelpBusinessId
                            );
                }

            } catch (error) {
                this.errorMessage =
                        "Unable to remove this dispensary.";

            } finally {
                this.deletingDispensaryId =
                        null;
            }
        },

        // Format the dispensary city, state, and ZIP code
        formatLocation(dispensary) {

            const cityState =
                    [
                        dispensary.city,
                        dispensary.stateAbbr
                    ]
                            .filter(Boolean)
                            .join(", ");

            return [
                cityState,
                dispensary.zipcode
            ]
                .filter(Boolean)
                .join(" ");
        },

        // Format the date the dispensary was saved
        formatSavedDate(savedAt) {

            const savedDate =
                    new Date(
                        savedAt
                    );

            if (
                Number.isNaN(
                    savedDate.getTime()
                )
            ) {
                return "";
            }

            return savedDate.toLocaleDateString(
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