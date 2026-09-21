<template>

  <section id="news">

    <!-- Search cannabis news -->
    <form
      class="news-search"
      @submit.prevent="searchNews"
    >
      <label for="news-search">
        Search Cannabis News
      </label>

      <input
        id="news-search"
        v-model="searchQuery"
        type="search"
        placeholder="Search cannabis news"
        maxlength="100"
      />

      <button
        type="submit"
        :disabled="isLoading || searchQuery.trim() === ''"
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

    <!-- Display news loading message -->
    <p
      v-if="isLoading"
      class="news-message"
      aria-live="polite"
    >
      {{ loadingMessage }}
    </p>

    <!-- Display news error message -->
    <p
      v-else-if="errorMessage"
      class="news-message"
      role="alert"
    >
      {{ errorMessage }}
    </p>

    <template v-else>

      <!-- Display news result information -->
      <p
        v-if="displayedNews.length > 0"
        class="news-results"
        aria-live="polite"
      >
        {{ resultsMessage }}
      </p>

      <!-- Display news articles -->
      <div
        v-if="displayedNews.length > 0"
        class="news-list"
      >
        <article
          v-for="news in displayedNews"
          :key="news.uuid"
          class="news-card"
        >
          <img
            v-if="news.imageUrl"
            :src="news.imageUrl"
            :alt="news.title"
            class="news-image"
            loading="lazy"
          />

          <div class="news-content">

            <h2>
              {{ news.title }}
            </h2>

            <p v-if="news.description">
              {{ news.description }}
            </p>

            <p class="news-details">
              <span v-if="news.source">
                {{ news.source }}
              </span>

              <span v-if="news.publishedAt">
                {{ formatDate(news.publishedAt) }}
              </span>
            </p>

            <a
              :href="news.url"
              target="_blank"
              rel="noopener noreferrer"
            >
              Read full article
            </a>

          </div>
        </article>
      </div>

      <!-- Display message when search has no results -->
      <p
        v-else-if="isSearchActive"
        class="news-message"
        aria-live="polite"
      >
        No results found for "{{ activeSearchQuery }}".
      </p>

      <!-- Display message when no news is available -->
      <p
        v-else
        class="news-message"
      >
        No news articles are currently available.
      </p>

    </template>

  </section>

</template>


<script>
import NewsService from "../../services/NewsService";

export default {
  name: "NewsFeed",

  data() {
    return {
      searchQuery: "",
      activeSearchQuery: "",
      fetchedNews: [],
      displayedNews: [],
      isSearchActive: false,
      isLoading: false,
      errorMessage: ""
    };
  },

  computed: {

    // Display the current loading message
    loadingMessage() {
      if (this.isSearchActive) {
        return "Searching cannabis news...";
      }

      return "Loading the latest cannabis news...";
    },

    // Display information about the current news results
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

  methods: {

    // Get the latest cannabis news
    async fetchNews() {
      this.isLoading = true;
      this.errorMessage = "";

      try {
        const response =
                await NewsService.getNews();

        this.fetchedNews =
                response.data;

        this.displayedNews =
                this.fetchedNews;
      } catch (error) {
        console.error(
          "Unable to load cannabis news:",
          error
        );

        this.errorMessage =
                "News is temporarily unavailable.";
      } finally {
        this.isLoading = false;
      }
    },

    // Search cannabis news
    async searchNews() {
      const query =
              this.searchQuery.trim();

      if (query === "") {
        return;
      }

      this.isSearchActive = true;
      this.activeSearchQuery = query;
      this.isLoading = true;
      this.errorMessage = "";

      try {
        const response =
                await NewsService.searchNews(query);

        this.displayedNews =
                response.data;
      } catch (error) {
        console.error(
          "Unable to search cannabis news:",
          error
        );

        this.errorMessage =
                "Unable to search news right now.";
      } finally {
        this.isLoading = false;
      }
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

  },

  mounted() {
    this.fetchNews();
  }
};
</script>


<style scoped>

</style>