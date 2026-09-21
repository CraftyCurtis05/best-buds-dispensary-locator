<!-- Home Page Featured Component Display -->
<template>

    <section id="featured">

        <!-- Display Featured Dispensary -->
        <article id="details" v-if="featuredDispensary">

            <!-- Display Dispensary Name -->
            <h1>{{ featuredDispensary.name }}</h1>

            <!-- Display Dispensary Image -->
            <a
                v-bind:href="featuredDispensary.url"
                target="_blank"
                rel="noopener noreferrer"
            >
                <img
                    v-bind:src="featuredDispensary.image_url"
                    v-bind:alt="featuredDispensary.name"
                />
            </a>

            <!-- Display Dispensary Address -->
            <h2 id="address1">
                {{ featuredDispensary.location.address1 }}
                {{ featuredDispensary.location.address2 }}
            </h2>

            <h2 id="address2">
                {{ featuredDispensary.location.city }},
                {{ featuredDispensary.location.state }}
                {{ featuredDispensary.location.zip_code }}
            </h2>

            <!-- Display Dispensary Phone Number -->
            <h3 id="phone">
                {{ featuredDispensary.display_phone }}
            </h3>

            <!-- Display Dispensary Rating -->
            <p id="rating">
                {{ featuredDispensary.rating }} ★
                ({{ featuredDispensary.review_count }} reviews)
            </p>

        </article>

        <!-- Display Loading Message -->
        <p v-else-if="isLoading">
            Finding today's featured dispensary...
        </p>

        <!-- Display Error Message -->
        <p v-else>
            Featured dispensary is unavailable right now.
        </p>

    </section>

</template>

<script>
import YelpService from '../../services/YelpService.js';

export default {
    name: "HomeFeatured",

    data() {
        return {
            featuredDispensary: null,
            isLoading: true
        }
    },

    methods: {

        // Get today's featured dispensary
        getFeaturedDispensary() {

            YelpService.getFeatured()
            .then(response => {
                this.featuredDispensary = response.data;
            })
            .catch(error => {
                console.error("Unable to load featured dispensary:", error);
            })
            .finally(() => {
                this.isLoading = false;
            });
        }
    },

    created() {
        this.getFeaturedDispensary();
    }
};
</script>

<style scoped>

</style>
