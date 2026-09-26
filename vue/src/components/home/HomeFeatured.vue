<!-- Home Featured Component Display -->
<template>

    <div id="home-featured">

        <!-- Display Featured Dispensary -->
        <article
            v-if="featuredDispensary"
            id="featured-details"
            aria-labelledby="featured-dispensary-name"
        >

            <!-- Display Dispensary Name -->
            <h3 id="featured-dispensary-name">
                {{ featuredDispensary.name }}
            </h3>

            <!-- Display Dispensary Image -->
            <a
                v-if="featuredDispensary.url"
                :href="featuredDispensary.url"
                target="_blank"
                rel="noopener noreferrer"
            >
                <img
                    v-if="featuredDispensary.image_url"
                    :src="featuredDispensary.image_url"
                    :alt="`${featuredDispensary.name} dispensary`"
                />
            </a>

            <!-- Display Dispensary Address -->
            <address v-if="featuredDispensary.location">

                <p v-if="streetAddress">
                    {{ streetAddress }}
                </p>

                <p v-if="cityStateZip">
                    {{ cityStateZip }}
                </p>

            </address>

            <!-- Display Dispensary Phone Number -->
            <p v-if="featuredDispensary.display_phone">
                {{ featuredDispensary.display_phone }}
            </p>

            <!-- Display Dispensary Rating -->
            <p v-if="featuredDispensary.rating">
                {{ featuredDispensary.rating }} ★
                ({{ featuredDispensary.review_count }} reviews)
            </p>

        </article>

        <!-- Display Loading Message -->
        <p
            v-else-if="isLoading"
            role="status"
        >
            Finding today's featured dispensary...
        </p>

        <!-- Display Error Message -->
        <p
            v-else
            role="status"
        >
            Featured dispensary is unavailable right now.
        </p>

    </div>

</template>

<script>
import YelpService from "../../services/YelpService.js";

export default {
    name: "HomeFeatured",

    data() {
        return {
            featuredDispensary: null,
            isLoading: true
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

</style>