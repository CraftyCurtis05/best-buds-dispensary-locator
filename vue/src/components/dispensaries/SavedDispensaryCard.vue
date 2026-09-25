<!-- Saved Dispensary Card Component Display -->
<template>

    <article class="saved-dispensary-card">

        <!-- Display Dispensary Image -->
        <img
            class="saved-dispensary-image"
            :src="dispensaryImage"
            :alt="dispensaryImageAlt"
            @error="useDefaultImage"
        />

        <!-- Display Dispensary Information -->
        <div class="saved-dispensary-content">

            <h2>
                {{ dispensary.name }}
            </h2>

            <!-- Display Dispensary Rating -->
            <p
                v-if="hasRating"
                class="saved-dispensary-rating"
            >
                {{ dispensary.rating }} / 5
            </p>

            <!-- Display Dispensary Address -->
            <address class="saved-dispensary-address">

                <span v-if="dispensary.address">
                    {{ dispensary.address }}
                </span>

                <span v-if="formattedLocation">
                    {{ formattedLocation }}
                </span>

            </address>

            <!-- Display Saved Date -->
            <p
                v-if="formattedSavedDate"
                class="saved-dispensary-date"
            >
                Saved {{ formattedSavedDate }}
            </p>

            <!-- Display Dispensary Control -->
            <button
                type="button"
                :disabled="isRemoving"
                @click="$emit(
                    'remove',
                    dispensary.yelpBusinessId
                )"
            >
                {{
                    isRemoving
                        ? "Removing..."
                        : "Remove"
                }}
            </button>

        </div>

    </article>

</template>

<script>
import defaultDispensaryImage
    from "../../assets/search/default-dispensary-image.png";

export default {
    name: "SavedDispensaryCard",

    emits: [
        "remove"
    ],

    props: {

        dispensary: {
            type: Object,
            required: true
        },

        isRemoving: {
            type: Boolean,
            default: false
        }

    },

    data() {
        return {
            imageLoadFailed: false
        };
    },

    computed: {

        // Check if the dispensary has a rating
        hasRating() {

            return (
                this.dispensary.rating !== null
                && this.dispensary.rating !== undefined
            );

        },

        // Get the saved dispensary image or use the default image
        dispensaryImage() {

            if (
                this.dispensary.imageUrl
                && !this.imageLoadFailed
            ) {
                return this.dispensary.imageUrl;
            }

            return defaultDispensaryImage;
        },

        // Get accessible text for the dispensary image
        dispensaryImageAlt() {

            if (
                this.dispensary.imageUrl
                && !this.imageLoadFailed
            ) {
                return `${this.dispensary.name} dispensary`;
            }

            return "";
        },

        // Format the dispensary city, state, and ZIP code
        formattedLocation() {

            const cityState = [
                this.dispensary.city,
                this.dispensary.stateAbbr
            ]
                .filter(Boolean)
                .join(", ");

            return [
                cityState,
                this.dispensary.zipcode
            ]
                .filter(Boolean)
                .join(" ");

        },

        // Format the date the dispensary was saved
        formattedSavedDate() {

            if (!this.dispensary.savedAt) {
                return "";
            }

            const savedDate =
                new Date(this.dispensary.savedAt);

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

    },

    methods: {

        // Use the default image if the saved image cannot load
        useDefaultImage() {
            this.imageLoadFailed = true;
        }

    }
};
</script>

<style scoped>

</style>