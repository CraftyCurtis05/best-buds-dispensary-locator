<!-- News Feed Component Display -->
<template>

    <div id="news-feed">

        <!-- Display News Search -->
        <form
            id="news-search"
            role="search"
            @submit.prevent="searchNews"
        >

            <label for="news-search-input">
                Search Cannabis News
            </label>

            <input
                id="news-search-input"
                v-model="searchQuery"
                type="search"
                name="news-search"
                placeholder="Search cannabis news"
                maxlength="100"
            />

            <button
                type="submit"
                :disabled="
                    isLoading
                    || searchQuery.trim() === ''
                "
            >
                Search
            </button>

            <button
                v-if="isSearchActive"
                type="button"
                @click="clearSearch"
            >
                Clear Search
            </button>

        </form>

        <!-- Display Loading Message -->
        <p
            v-if="isLoading"
            role="status"
            aria-live="polite"
        >
            {{ loadingMessage }}
        </p>

        <!-- Display Error Message -->
        <p
            v-else-if="errorMessage"
            role="alert"
        >
            {{ errorMessage }}
        </p>

        <!-- Display News Results -->
        <div
            v-else-if="displayedNews.length"
            id="news-results"
        >

            <p
                class="news-results-summary"
                role="status"
                aria-live="polite"
            >
                {{ resultsMessage }}
            </p>

            <div class="news-list">

                <article
                    v-for="news in displayedNews"
                    :key="news.uuid"
                    class="news-card"
                >

                    <!-- Display News Image -->
                    <img
                        v-if="news.imageUrl"
                        :src="news.imageUrl"
                        :alt="news.title"
                        class="news-image"
                        loading="lazy"
                    />

                    <!-- Display News Information -->
                    <div class="news-content">

                        <h3>
                            {{ news.title }}
                        </h3>

                        <p v-if="news.description">
                            {{ news.description }}
                        </p>

                        <p
                            v-if="
                                news.source
                                || news.publishedAt
                            "
                            class="news-details"
                        >

                            <span v-if="news.source">
                                {{ news.source }}
                            </span>

                            <span v-if="news.publishedAt">
                                {{ formatDate(news.publishedAt) }}
                            </span>

                        </p>

                        <a
                            v-if="news.url"
                            :href="news.url"
                            target="_blank"
                            rel="noopener noreferrer"
                        >
                            Read full article
                        </a>

                    </div>

                </article>

            </div>

        </div>

        <!-- Display No Search Results Message -->
        <p
            v-else-if="isSearchActive"
            role="status"
            aria-live="polite"
        >
            No results found for "{{ activeSearchQuery }}".
        </p>

        <!-- Display No News Message -->
        <p
            v-else
            role="status"
        >
            No news articles are currently available.
        </p>

    </div>

</template>

<script>
import NewsService from "../../services/NewsService.js";

export default {
    name: "NewsFeed",

    data() {
        return {
            searchQuery: "",
            activeSearchQuery: "",
            fetchedNews: [],
            displayedNews: [],
            isSearchActive: false,
            isLoading: true,
            errorMessage: ""
        };
    },

    computed: {

        // Get the current loading message
        loadingMessage() {

            if (this.isSearchActive) {
                return "Searching cannabis news...";
            }

            return "Loading the latest cannabis news...";

        },

        // Get information about the current news results
        resultsMessage() {

            const resultCount =
                this.displayedNews.length;

            if (this.isSearchActive) {

                const resultWord =
                    resultCount === 1
                        ? "result"
                        : "results";

                return `${resultCount} ${resultWord} for "${this.activeSearchQuery}"`;

            }

            const articleWord =
                resultCount === 1
                    ? "article"
                    : "articles";

            return `${resultCount} latest ${articleWord}`;

        }

    },

    created() {
        this.fetchNews();
    },

    methods: {

        // Get the latest cannabis news
        fetchNews() {

            this.isLoading = true;
            this.errorMessage = "";

            NewsService
                .getNews()
                .then((response) => {

                    this.fetchedNews =
                        response.data;

                    this.displayedNews =
                        this.fetchedNews;

                })
                .catch((error) => {

                    console.error(
                        "Unable to load cannabis news:",
                        error
                    );

                    this.errorMessage =
                        "News is temporarily unavailable.";

                })
                .finally(() => {

                    this.isLoading = false;

                });

        },

        // Search cannabis news
        searchNews() {

            const query =
                this.searchQuery.trim();

            if (!query) {
                return;
            }

            this.isSearchActive = true;
            this.activeSearchQuery = query;
            this.isLoading = true;
            this.errorMessage = "";

            NewsService
                .searchNews(query)
                .then((response) => {

                    this.displayedNews =
                        response.data;

                })
                .catch((error) => {

                    console.error(
                        "Unable to search cannabis news:",
                        error
                    );

                    this.errorMessage =
                        "Unable to search news right now.";

                })
                .finally(() => {

                    this.isLoading = false;

                });

        },

        // Clear the current news search
        clearSearch() {

            this.searchQuery = "";
            this.activeSearchQuery = "";
            this.isSearchActive = false;
            this.errorMessage = "";

            this.displayedNews =
                this.fetchedNews;

        },

        // Format the article publication date
        formatDate(publishedAt) {

            return new Date(
                publishedAt
            ).toLocaleDateString(
                "en-US",
                {
                    year: "numeric",
                    month: "long",
                    day: "numeric"
                }
            );

        }

    }
};
</script>

<style scoped>

</style>