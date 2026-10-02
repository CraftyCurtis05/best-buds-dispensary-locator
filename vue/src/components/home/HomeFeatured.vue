<!-- Home Featured Dispensary Component -->
<template>

    <div id="home-featured">

        <!-- =================================================
             Featured Dispensary
             ================================================= -->

        <article
            v-if="featuredDispensary"
            id="featured-details"
            aria-labelledby="featured-dispensary-name"
        >

            <!-- Featured Image -->
            <div class="featured-image-container">

                <img
                    v-if="featuredDispensary.image_url"
                    :src="featuredDispensary.image_url"
                    :alt="`${featuredDispensary.name} dispensary`"
                    class="featured-image"
                    width="640"
                    height="480"
                    loading="lazy"
                    decoding="async"
                    fetchpriority="low"
                />


                <!-- Image Placeholder -->
                <div
                    v-else
                    class="featured-image-placeholder"
                    aria-hidden="true"
                >

                    <img
                        :src="logoIcon"
                        alt=""
                    />

                </div>

            </div>


            <!-- Featured Information -->
            <div class="featured-content">

                <p class="featured-eyebrow">
                    Featured Today
                </p>


                <!-- Dispensary Name -->
                <h3 id="featured-dispensary-name">
                    {{ featuredDispensary.name }}
                </h3>


                <!-- Rating -->
                <p
                    v-if="featuredDispensary.rating"
                    class="featured-rating"
                >

                    <span aria-hidden="true">
                        ★
                    </span>

                    <strong>
                        {{ featuredDispensary.rating }}
                    </strong>

                    <span
                        v-if="
                            featuredDispensary.review_count
                        "
                    >
                        {{
                            formattedReviewCount
                        }}
                        reviews
                    </span>

                </p>


                <!-- Dispensary Address -->
                <address
                    v-if="featuredDispensary.location"
                    class="featured-address"
                >

                    <p v-if="streetAddress">
                        {{ streetAddress }}
                    </p>

                    <p v-if="cityStateZip">
                        {{ cityStateZip }}
                    </p>

                </address>


                <!-- Phone Number -->
                <p
                    v-if="
                        featuredDispensary.display_phone
                    "
                    class="featured-phone"
                >

                    <a
                        v-if="phoneUrl"
                        :href="phoneUrl"
                    >
                        {{
                            featuredDispensary.display_phone
                        }}
                    </a>

                    <span v-else>
                        {{
                            featuredDispensary.display_phone
                        }}
                    </span>

                </p>


                <!-- Featured Actions -->
                <div class="featured-actions">

                    <!-- View Dispensary -->
                    <a
                        v-if="featuredDispensary.url"
                        :href="featuredDispensary.url"
                        class="
                            featured-button
                            featured-button-primary
                        "
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        View Dispensary

                        <span aria-hidden="true">
                            ↗
                        </span>
                    </a>


                    <!-- Get Directions -->
                    <a
                        v-if="directionsUrl"
                        :href="directionsUrl"
                        class="
                            featured-button
                            featured-button-secondary
                        "
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        Directions

                        <span aria-hidden="true">
                            ↗
                        </span>
                    </a>

                </div>

            </div>

        </article>


        <!-- =================================================
             Loading State
             ================================================= -->

        <div
            v-else-if="isLoading"
            class="featured-status"
            role="status"
        >

            <div
                class="featured-status-icon"
                aria-hidden="true"
            >
                <img
                    :src="logoIcon"
                    alt=""
                />
            </div>

            <div>

                <p class="featured-status-title">
                    Finding today's featured dispensary...
                </p>

                <p>
                    You can keep exploring Best Buds while
                    this loads.
                </p>

            </div>

        </div>


        <!-- =================================================
             Unavailable State
             ================================================= -->

        <div
            v-else
            class="featured-status"
            role="status"
        >

            <div
                class="featured-status-icon"
                aria-hidden="true"
            >
                <img
                    :src="logoIcon"
                    alt=""
                />
            </div>

            <div>

                <p class="featured-status-title">
                    Featured dispensary unavailable
                </p>

                <p>
                    You can still search for dispensaries
                    near you.
                </p>

                <router-link
                    :to="{ name: 'search' }"
                    class="featured-search-link"
                >
                    Search Dispensaries
                    <span aria-hidden="true">
                        →
                    </span>
                </router-link>

            </div>

        </div>

    </div>

</template>


<script>
import YelpService from "../../services/YelpService.js";

import logoIcon from "../../assets/layout/logo/logo-icon.png";

export default {

    name: "HomeFeatured",

    data() {

        return {
            featuredDispensary: null,
            isLoading: true,
            logoIcon
        };

    },

    computed: {

        // Format the dispensary street address
        streetAddress() {

            if (!this.featuredDispensary?.location) {
                return "";
            }

            return [
                this.featuredDispensary.location.address1,
                this.featuredDispensary.location.address2
            ]
                .filter(Boolean)
                .join(" ");

        },


        // Format the dispensary city, state, and ZIP code
        cityStateZip() {

            if (!this.featuredDispensary?.location) {
                return "";
            }

            const location =
                this.featuredDispensary.location;

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


        // Create the full address for directions
        fullAddress() {

            return [
                this.streetAddress,
                this.cityStateZip
            ]
                .filter(Boolean)
                .join(", ");

        },


        // Create a Google Maps directions link
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


        // Create a clickable phone number
        phoneUrl() {

            const phone =
                this.featuredDispensary?.phone
                ||
                this.featuredDispensary
                    ?.display_phone;

            if (!phone) {
                return "";
            }

            const cleanPhone =
                phone.replace(
                    /[^\d+]/g,
                    ""
                );

            return `tel:${cleanPhone}`;

        },


        // Format large review counts
        formattedReviewCount() {

            const reviewCount =
                this.featuredDispensary
                    ?.review_count;

            if (!reviewCount) {
                return "";
            }

            return new Intl.NumberFormat(
                "en-US"
            ).format(
                reviewCount
            );

        }

    },

    created() {

        this.getFeaturedDispensary();

    },

    methods: {

        // Get today's featured dispensary
        getFeaturedDispensary() {

            YelpService
                .getFeatured()
                .then((response) => {

                    this.featuredDispensary =
                        response.data;

                })
                .catch((error) => {

                    console.error(
                        "Unable to load featured dispensary:",
                        error
                    );

                })
                .finally(() => {

                    this.isLoading = false;

                });

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Featured Dispensary
   ========================================================= */

#home-featured {
    width: 100%;
}


/* Featured Card */
#featured-details {
    display: grid;

    grid-template-columns:
        minmax(
            18rem,
            0.85fr
        )
        minmax(
            0,
            1.15fr
        );

    overflow: hidden;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 16px 40px
        var(--color-shadow);
}


/* =========================================================
   Featured Image
   ========================================================= */

.featured-image-container {
    min-height: 22rem;

    overflow: hidden;

    background:
        var(--color-surface-soft);
}


/* Dispensary Image */
.featured-image {
    width: 100%;
    height: 100%;

    object-fit: cover;
}


/* Image Placeholder */
.featured-image-placeholder {
    display: grid;
    place-items: center;

    width: 100%;
    height: 100%;

    min-height: 22rem;

    background:
        linear-gradient(
            135deg,
            var(--color-surface-soft),
            var(--color-surface-strong)
        );
}


/* Placeholder Logo */
.featured-image-placeholder img {
    width: 7rem;
    height: 7rem;

    object-fit: contain;

    opacity: 0.72;
}


/* =========================================================
   Featured Content
   ========================================================= */

.featured-content {
    display: flex;
    flex-direction: column;

    justify-content: center;

    padding:
        clamp(
            1.75rem,
            5vw,
            3.5rem
        );
}


/* Featured Label */
.featured-eyebrow {
    margin:
        0
        0
        0.75rem;

    color:
        var(--color-gold-dark);

    font-size: 0.7rem;
    font-weight: 600;

    letter-spacing: 0.16em;

    text-transform: uppercase;
}


/* Dispensary Name */
.featured-content h3 {
    margin:
        0
        0
        1rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.7rem,
            4vw,
            2.7rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.03em;
}


/* =========================================================
   Featured Rating
   ========================================================= */

.featured-rating {
    display: flex;
    flex-wrap: wrap;
    align-items: center;

    gap: 0.4rem;

    margin:
        0
        0
        1.25rem;

    color:
        var(--color-text-soft);

    font-size: 0.86rem;
}


/* Rating Star */
.featured-rating > span:first-child {
    color:
        var(--color-gold);
}


/* Rating Number */
.featured-rating strong {
    color:
        var(--color-text);

    font-weight: 600;
}


/* =========================================================
   Featured Address
   ========================================================= */

.featured-address {
    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text-soft);

    font-style: normal;

    line-height: 1.55;
}


/* Address Lines */
.featured-address p {
    margin: 0;
}


/* Featured Phone */
.featured-phone {
    margin:
        0
        0
        1.6rem;
}


/* Phone Link */
.featured-phone a {
    color:
        var(--color-primary);

    font-weight: 500;

    text-decoration-color:
        var(--color-gold);

    text-underline-offset: 0.2rem;
}


/* =========================================================
   Featured Actions
   ========================================================= */

.featured-actions {
    display: flex;
    flex-wrap: wrap;

    gap: 0.75rem;

    margin-top: auto;
}


/* Featured Button */
.featured-button {
    display: inline-flex;
    align-items: center;
    justify-content: center;

    gap: 0.5rem;

    min-height: 2.8rem;

    padding:
        0.65rem
        1rem;

    border-radius:
        var(--border-radius-pill);

    font-size: 0.82rem;
    font-weight: 600;

    text-decoration: none;

    transition:
        transform 160ms ease,
        background 160ms ease,
        border-color 160ms ease;
}


/* Primary Featured Button */
.featured-button-primary {
    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    color:
        var(--color-background);
}


/* Primary Featured Button Hover */
.featured-button-primary:hover {
    background:
        var(--color-primary-hover);

    border-color:
        var(--color-primary-hover);

    transform:
        translateY(-2px);
}


/* Secondary Featured Button */
.featured-button-secondary {
    background:
        transparent;

    border:
        1px solid
        var(--color-border-strong);

    color:
        var(--color-text);
}


/* Secondary Featured Button Hover */
.featured-button-secondary:hover {
    background:
        var(--color-surface-soft);

    transform:
        translateY(-2px);
}


/* =========================================================
   Loading and Error States
   ========================================================= */

.featured-status {
    display: flex;
    align-items: center;

    gap: 1.25rem;

    min-height: 13rem;

    padding:
        1.75rem;

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
}


/* Status Icon */
.featured-status-icon {
    display: grid;
    place-items: center;

    width: 4.5rem;
    height: 4.5rem;

    flex-shrink: 0;

    padding: 0.7rem;

    background:
        var(--color-surface-soft);

    border:
        1px solid
        var(--color-border);

    border-radius: 50%;
}


/* Status Logo */
.featured-status-icon img {
    width: 100%;
    height: 100%;

    object-fit: contain;
}


/* Status Text */
.featured-status p {
    margin:
        0.25rem
        0;

    color:
        var(--color-text-soft);
}


/* Status Title */
.featured-status
.featured-status-title {
    color:
        var(--color-text);

    font-size: 1rem;
    font-weight: 600;
}


/* Search Link */
.featured-search-link {
    display: inline-flex;
    align-items: center;

    gap: 0.45rem;

    margin-top: 0.65rem;

    color:
        var(--color-primary);

    font-size: 0.84rem;
    font-weight: 600;

    text-decoration: none;
}


/* Search Link Hover */
.featured-search-link:hover {
    color:
        var(--color-gold-dark);
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 749.98px) {

    #featured-details {
        grid-template-columns: 1fr;
    }


    .featured-image-container,
    .featured-image-placeholder {
        min-height: 16rem;
    }


    .featured-content {
        padding:
            1.6rem
            1.4rem
            1.8rem;
    }

}


/* =========================================================
   Small Mobile
   ========================================================= */

@media (max-width: 420px) {

    .featured-actions {
        flex-direction: column;
    }


    .featured-button {
        width: 100%;
    }


    .featured-status {
        align-items: flex-start;

        min-height: 0;

        padding: 1.4rem;
    }


    .featured-status-icon {
        width: 3.5rem;
        height: 3.5rem;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .featured-button {
        transition: none;
    }


    .featured-button:hover {
        transform: none;
    }

}

</style>