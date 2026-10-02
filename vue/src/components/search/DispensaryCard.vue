<!-- Dispensary Card Component Display -->
<template>

    <article class="dispensary-card">

        <!-- =================================================
             Dispensary Image
             ================================================= -->

        <div class="dispensary-image-container">

            <img
                class="dispensary-image"
                :src="dispensaryImage"
                :alt="dispensaryImageAlt"
                width="640"
                height="480"
                loading="lazy"
                decoding="async"
                fetchpriority="low"
                @error="useDefaultImage"
            />


            <!-- Distance Badge -->
            <span
                v-if="distanceText"
                class="dispensary-distance"
            >
                {{ distanceText }}
            </span>

        </div>


        <!-- =================================================
             Dispensary Information
             ================================================= -->

        <div class="dispensary-information">

            <!-- Dispensary Header -->
            <header class="dispensary-header">

                <h3>
                    {{ dispensary.name }}
                </h3>


                <!-- Rating -->
                <p
                    v-if="hasRating"
                    class="dispensary-rating"
                >

                    <span
                        class="rating-star"
                        aria-hidden="true"
                    >
                        ★
                    </span>

                    <strong>
                        {{ dispensary.rating }}
                    </strong>

                    <span
                        v-if="
                            dispensary.review_count
                        "
                    >
                        · {{ reviewCountText }}
                    </span>

                </p>

            </header>


            <!-- Categories -->
            <p
                v-if="categoryText"
                class="dispensary-categories"
            >
                {{ categoryText }}
            </p>


            <!-- Address -->
            <address class="dispensary-address">

                <span v-if="streetAddress">
                    {{ streetAddress }}
                </span>

                <span v-if="cityStateZip">
                    {{ cityStateZip }}
                </span>

            </address>


            <!-- Phone -->
            <a
                v-if="
                    dispensary.display_phone
                "
                class="dispensary-phone"
                :href="phoneLink"
            >
                {{
                    dispensary.display_phone
                }}
            </a>


            <!-- Spacer -->
            <div class="dispensary-spacer"></div>


            <!-- =================================================
                 Dispensary Controls
                 ================================================= -->

            <div class="dispensary-controls">

                <!-- Yelp Link -->
                <a
                    v-if="dispensary.url"
                    :href="dispensary.url"
                    class="
                        dispensary-button
                        dispensary-button-primary
                    "
                    target="_blank"
                    rel="noopener noreferrer"
                    :aria-label="
                        `View ${dispensary.name} on Yelp`
                    "
                >
                    View Details

                    <span aria-hidden="true">
                        ↗
                    </span>
                </a>


                <!-- Directions -->
                <a
                    v-if="directionsUrl"
                    :href="directionsUrl"
                    class="dispensary-text-link"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Directions
                </a>


                <!-- Save Dispensary -->
                <button
                    type="button"
                    class="save-button"
                    :class="{
                        'save-button--saved':
                            isSaved
                    }"
                    :disabled="isSaving"
                    :aria-pressed="isSaved"
                    @click="
                        $emit(
                            'toggle-saved',
                            dispensary
                        )
                    "
                >
                    {{ saveButtonText }}
                </button>

            </div>

        </div>

    </article>

</template>


<script>

import DefaultDispensaryImage
    from "../../assets/search/default-dispensary-image.webp";


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

        // Check if the dispensary has a rating
        hasRating() {

            return (
                this.dispensary.rating
                    !== null
                &&
                this.dispensary.rating
                    !== undefined
            );

        },


        // Get the dispensary image
        dispensaryImage() {

            if (
                this.dispensary.image_url
                && !this.imageLoadFailed
            ) {

                return (
                    this.dispensary.image_url
                );

            }

            return DefaultDispensaryImage;

        },


        // Get accessible image text
        dispensaryImageAlt() {

            if (
                this.dispensary.image_url
                && !this.imageLoadFailed
            ) {

                return (
                    `${this.dispensary.name} dispensary`
                );

            }

            /*
             * The default Best Buds image is
             * decorative because the dispensary
             * name is already displayed below.
             */
            return "";

        },


        // Format the review count
        reviewCountText() {

            const reviewCount =
                this.dispensary.review_count;

            if (reviewCount === 1) {
                return "1 review";
            }

            return (
                `${reviewCount} reviews`
            );

        },


        // Format dispensary categories
        categoryText() {

            const categories =
                this.dispensary.categories
                || [];

            return categories
                .map(
                    (category) =>
                        category.title
                )
                .filter(Boolean)
                .join(" · ");

        },


        // Format the street address
        streetAddress() {

            const location =
                this.dispensary.location
                || {};

            return [
                location.address1,
                location.address2
            ]
                .filter(Boolean)
                .join(" ");

        },


        // Format city, state, and ZIP code
        cityStateZip() {

            const location =
                this.dispensary.location
                || {};

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


        // Build the full address
        fullAddress() {

            return [
                this.streetAddress,
                this.cityStateZip
            ]
                .filter(Boolean)
                .join(", ");

        },


        // Create a directions link
        directionsUrl() {

            if (!this.fullAddress) {
                return "";
            }

            return (
                "https://www.google.com/maps/search/"
                + "?api=1&query="
                + encodeURIComponent(
                    this.fullAddress
                )
            );

        },


        // Convert distance from meters to miles
        distanceText() {

            if (
                this.dispensary.distance
                    === null
                ||
                this.dispensary.distance
                    === undefined
            ) {
                return "";
            }

            const miles =
                this.dispensary.distance
                / 1609.344;

            return (
                `${miles.toFixed(1)} mi`
            );

        },


        // Create a phone link
        phoneLink() {

            const phone =
                this.dispensary.phone
                ||
                this.dispensary
                    .display_phone;

            if (!phone) {
                return "";
            }

            const cleanPhone =
                phone.replace(
                    /[^\d+]/g,
                    ""
                );

            return (
                `tel:${cleanPhone}`
            );

        },


        // Display the correct save button text
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

        // Use the default image after an image error
        useDefaultImage() {

            this.imageLoadFailed = true;

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Dispensary Card
   ========================================================= */

.dispensary-card {
    display: flex;
    flex-direction: column;

    min-width: 0;
    height: 100%;

    overflow: hidden;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 12px 30px
        var(--color-shadow);

    transition:
        transform 160ms ease,
        border-color 160ms ease,
        box-shadow 160ms ease;
}


/* Card Hover */
.dispensary-card:hover {
    border-color:
        var(--color-border-strong);

    box-shadow:
        0 18px 40px
        var(--color-shadow-strong);

    transform:
        translateY(-3px);
}


/* =========================================================
   Dispensary Image
   ========================================================= */

.dispensary-image-container {
    position: relative;

    aspect-ratio: 4 / 3;

    overflow: hidden;

    background:
        var(--color-surface-soft);
}


/* Image */
.dispensary-image {
    width: 100%;
    height: 100%;

    object-fit: cover;
}


/* Distance Badge */
.dispensary-distance {
    position: absolute;

    right: 0.8rem;
    bottom: 0.8rem;

    margin: 0;

    padding:
        0.35rem
        0.6rem;

    background:
        var(--color-header-background);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text);

    font-size: 0.68rem;
    font-weight: 600;

    box-shadow:
        0 4px 12px
        var(--color-shadow);

    backdrop-filter:
        blur(10px);
}


/* =========================================================
   Dispensary Information
   ========================================================= */

.dispensary-information {
    display: flex;
    flex: 1;
    flex-direction: column;

    padding: 1.25rem;
}


/* Card Heading */
.dispensary-header h3 {
    margin:
        0
        0
        0.6rem;

    color:
        var(--color-text);

    font-size: 1.15rem;
    font-weight: 600;

    line-height: 1.25;
}


/* =========================================================
   Rating
   ========================================================= */

.dispensary-rating {
    display: flex;
    flex-wrap: wrap;
    align-items: center;

    gap: 0.3rem;

    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;
}


/* Rating Star */
.rating-star {
    color:
        var(--color-gold);
}


/* Rating Number */
.dispensary-rating strong {
    color:
        var(--color-text);

    font-weight: 600;
}


/* =========================================================
   Categories
   ========================================================= */

.dispensary-categories {
    display: -webkit-box;

    margin:
        0
        0
        0.8rem;

    overflow: hidden;

    color:
        var(--color-gold-dark);

    font-size: 0.72rem;
    font-weight: 500;

    line-height: 1.45;

    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
}


/* =========================================================
   Address
   ========================================================= */

.dispensary-address {
    display: flex;
    flex-direction: column;

    gap: 0.1rem;

    margin:
        0
        0
        0.55rem;

    color:
        var(--color-text-soft);

    font-size: 0.8rem;

    font-style: normal;

    line-height: 1.5;
}


/* =========================================================
   Phone
   ========================================================= */

.dispensary-phone {
    align-self: flex-start;

    color:
        var(--color-primary);

    font-size: 0.8rem;
    font-weight: 500;

    text-decoration-color:
        var(--color-gold);

    text-underline-offset: 0.2rem;
}


/* Flexible Card Spacer */
.dispensary-spacer {
    flex: 1;

    min-height: 1.2rem;
}


/* =========================================================
   Card Controls
   ========================================================= */

.dispensary-controls {
    display: grid;

    grid-template-columns:
        1fr
        auto;

    align-items: center;

    gap:
        0.75rem
        0.6rem;

    padding-top: 1rem;

    border-top:
        1px solid
        var(--color-border);
}


/* Main Details Button */
.dispensary-button {
    display: inline-flex;
    align-items: center;
    justify-content: center;

    gap: 0.4rem;

    min-height: 2.6rem;

    padding:
        0.55rem
        0.85rem;

    border-radius:
        var(--border-radius-pill);

    font-size: 0.76rem;
    font-weight: 600;

    text-decoration: none;
}


/* Primary Button */
.dispensary-button-primary {
    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    color:
        var(--color-background);
}


/* Details Hover */
.dispensary-button-primary:hover {
    background:
        var(--color-primary-hover);
}


/* Directions Link */
.dispensary-text-link {
    color:
        var(--color-text-soft);

    font-size: 0.74rem;
    font-weight: 500;

    text-decoration: none;
}


/* Directions Hover */
.dispensary-text-link:hover {
    color:
        var(--color-gold-dark);
}


/* Save Button */
.save-button {
    grid-column:
        1
        / -1;

    width: 100%;

    min-height: 2.45rem;

    padding:
        0.5rem
        0.8rem;

    background:
        transparent;

    border:
        1px solid
        var(--color-border-strong);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.76rem;
    font-weight: 600;

    cursor: pointer;
}


/* Saved Button */
.save-button--saved {
    background:
        var(--color-primary-soft);
}


/* Save Hover */
.save-button:hover:not(:disabled) {
    background:
        var(--color-primary-soft);
}


/* Disabled Save Button */
.save-button:disabled {
    cursor: wait;

    opacity: 0.65;
}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .dispensary-card {
        transition: none;
    }


    .dispensary-card:hover {
        transform: none;
    }

}

</style>