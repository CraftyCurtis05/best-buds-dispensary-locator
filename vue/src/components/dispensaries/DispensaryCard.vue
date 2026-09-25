<!-- Dispensary Card Component Display -->
<template>

    <article class="dispensary-card">

        <!-- Display Dispensary Image -->
        <img
            class="dispensary-image"
            :src="dispensaryImage"
            :alt="dispensaryImageAlt"
            @error="useDefaultImage"
        />

        <!-- Display Dispensary Information -->
        <div class="dispensary-information">

            <header class="dispensary-header">

                <h2>
                    {{ dispensary.name }}
                </h2>

                <p
                    v-if="dispensary.rating"
                    class="dispensary-rating"
                >
                    {{ dispensary.rating }} / 5

                    <span v-if="dispensary.review_count">
                        · {{ reviewCountText }}
                    </span>
                </p>

            </header>

            <!-- Display Dispensary Categories -->
            <p
                v-if="categoryText"
                class="dispensary-categories"
            >
                {{ categoryText }}
            </p>

            <!-- Display Dispensary Address -->
            <address class="dispensary-address">

                <span v-if="streetAddress">
                    {{ streetAddress }}
                </span>

                <span v-if="cityStateZip">
                    {{ cityStateZip }}
                </span>

            </address>

            <!-- Display Dispensary Distance -->
            <p
                v-if="distanceText"
                class="dispensary-distance"
            >
                {{ distanceText }}
            </p>

            <!-- Display Dispensary Phone -->
            <a
                v-if="dispensary.display_phone"
                class="dispensary-phone"
                :href="phoneLink"
            >
                {{ dispensary.display_phone }}
            </a>

            <!-- Display Dispensary Controls -->
            <div class="dispensary-controls">

                <a
                    v-if="dispensary.url"
                    :href="dispensary.url"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    View on Yelp
                </a>

                <button
                    type="button"
                    :disabled="isSaving"
                    @click="$emit('toggle-saved', dispensary)"
                >
                    {{ saveButtonText }}
                </button>

            </div>

        </div>

    </article>

</template>

<script>
import defaultDispensaryImage from "../../assets/search/default-dispensary-image.png";

export default {
    name: "DispensaryCard",

    emits: [
        "toggle-saved"
    ],

    props: {

        dispensary: {
            type: Object,
            required: true
        },

        isSaved: {
            type: Boolean,
            default: false
        },

        isSaving: {
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

        // Get the dispensary image or use the default image
        dispensaryImage() {

            if (
                this.dispensary.image_url
                && !this.imageLoadFailed
            ) {
                return this.dispensary.image_url;
            }

            return defaultDispensaryImage;
        },

        // Get accessible text for the dispensary image
        dispensaryImageAlt() {

            if (
                this.dispensary.image_url
                && !this.imageLoadFailed
            ) {
                return `${this.dispensary.name} dispensary`;
            }

            return "";
        },

        // Format the dispensary review count
        reviewCountText() {

            const reviewCount =
                this.dispensary.review_count;

            if (reviewCount === 1) {
                return "1 review";
            }

            return `${reviewCount} reviews`;
        },

        // Format the dispensary categories
        categoryText() {

            const categories =
                this.dispensary.categories || [];

            return categories
                .map(category => category.title)
                .filter(Boolean)
                .join(" · ");
        },

        // Format the dispensary street address
        streetAddress() {

            const location =
                this.dispensary.location || {};

            return [
                location.address1,
                location.address2
            ]
                .filter(Boolean)
                .join(" ");
        },

        // Format the dispensary city, state, and ZIP code
        cityStateZip() {

            const location =
                this.dispensary.location || {};

            const cityState = [
                location.city,
                location.state
            ]
                .filter(Boolean)
                .join(", ");

            return [
                cityState,
                location.zip_code
            ]
                .filter(Boolean)
                .join(" ");
        },

        // Convert the dispensary distance from meters to miles
        distanceText() {

            if (
                this.dispensary.distance === null
                || this.dispensary.distance === undefined
            ) {
                return "";
            }

            const miles =
                this.dispensary.distance / 1609.344;

            return `${miles.toFixed(1)} mi away`;
        },

        // Create a phone link from the dispensary phone number
        phoneLink() {

            if (!this.dispensary.phone) {
                return "";
            }

            return `tel:${this.dispensary.phone}`;
        },

        // Display the correct saved dispensary button text
        saveButtonText() {

            if (this.isSaving) {

                if (this.isSaved) {
                    return "Removing...";
                }

                return "Saving...";
            }

            if (this.isSaved) {
                return "Saved";
            }

            return "Save";
        }

    },

    methods: {

        // Use the default image if the dispensary image cannot load
        useDefaultImage() {
            this.imageLoadFailed = true;
        }

    }
};
</script>

<style scoped>

</style>