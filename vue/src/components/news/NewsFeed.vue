<!-- Cannabis News Feed Component -->
<template>

    <div id="news-feed">

        <!-- =================================================
             News Search
             ================================================= -->

        <div class="news-search-panel">

            <form
                id="news-search"
                role="search"
                @submit.prevent="searchNews"
            >

                <label for="news-search-input">
                    Search Cannabis News
                </label>

                <p id="news-search-help">
                    Search recent cannabis coverage by topic
                    or keyword.
                </p>


                <!-- Search Controls -->
                <div class="news-search-row">

                    <input
                        id="news-search-input"
                        v-model="searchQuery"
                        type="search"
                        name="news-search"
                        placeholder="Try legalization, CBD, research..."
                        maxlength="100"
                        aria-describedby="news-search-help"
                        autocomplete="off"
                    />


                    <button
                        type="submit"
                        class="news-search-button"
                        :disabled="
                            isLoading
                            ||
                            searchQuery.trim() === ''
                        "
                    >
                        Search

                        <span aria-hidden="true">
                            →
                        </span>
                    </button>

                </div>


                <!-- Active Search -->
                <div
                    v-if="isSearchActive"
                    class="active-search"
                >

                    <span>
                        Searching for:
                        <strong>
                            {{ activeSearchQuery }}
                        </strong>
                    </span>

                    <button
                        type="button"
                        @click="clearSearch"
                    >
                        Clear Search
                    </button>

                </div>

            </form>

        </div>


        <!-- =================================================
             Loading State
             ================================================= -->

        <div
            v-if="isLoading"
            class="news-status"
            role="status"
            aria-live="polite"
        >

            <span
                class="news-status-marker"
                aria-hidden="true"
            ></span>

            <div>

                <p class="news-status-title">
                    {{ loadingMessage }}
                </p>

                <p>
                    This may take a moment.
                </p>

            </div>

        </div>


        <!-- =================================================
             Error State
             ================================================= -->

        <div
            v-else-if="errorMessage"
            class="
                news-status
                news-status-error
            "
            role="alert"
        >

            <span
                class="news-status-marker"
                aria-hidden="true"
            >
                !
            </span>

            <div>

                <p class="news-status-title">
                    News unavailable
                </p>

                <p>
                    {{ errorMessage }}
                </p>


                <button
                    v-if="!isSearchActive"
                    type="button"
                    class="retry-button"
                    @click="fetchNews"
                >
                    Try Again
                </button>

            </div>

        </div>


        <!-- =================================================
             News Results
             ================================================= -->

        <template
            v-else-if="displayedNews.length"
        >

            <!-- Results Summary -->
            <div
                class="news-results-summary"
                role="status"
                aria-live="polite"
            >

                <p>
                    {{ resultsMessage }}
                </p>

            </div>


            <!-- News Cards -->
            <section
                id="news-results"
                aria-label="Cannabis news articles"
            >

                <article
                    v-for="news in visibleNews"
                    :key="news.uuid"
                    class="news-card"
                >

                    <!-- =================================================
                         News Image
                         ================================================= -->

                    <div class="news-image-container">

                        <img
                            v-if="
                                news.imageUrl
                                &&
                                !hasImageError(
                                    news.uuid
                                )
                            "
                            :src="news.imageUrl"
                            :alt="news.title"
                            class="news-image"
                            width="640"
                            height="360"
                            loading="lazy"
                            decoding="async"
                            fetchpriority="low"
                            @error="
                                handleImageError(
                                    news.uuid
                                )
                            "
                        />


                        <!-- Image Fallback -->
                        <div
                            v-else
                            class="news-image-placeholder"
                            aria-hidden="true"
                        >

                            <span class="placeholder-label">
                                Best Buds
                            </span>

                            <span class="placeholder-title">
                                News
                            </span>

                            <span class="placeholder-line"></span>

                        </div>


                        <!-- News Badge -->
                        <span class="news-card-badge">
                            News
                        </span>

                    </div>


                    <!-- =================================================
                         News Content
                         ================================================= -->

                    <div class="news-content">

                        <!-- Source and Date -->
                        <div
                            v-if="
                                news.source
                                ||
                                news.publishedAt
                            "
                            class="news-meta"
                        >

                            <span
                                v-if="news.source"
                                class="news-source"
                            >
                                {{ news.source }}
                            </span>


                            <span
                                v-if="
                                    news.source
                                    &&
                                    news.publishedAt
                                "
                                aria-hidden="true"
                            >
                                •
                            </span>


                            <time
                                v-if="news.publishedAt"
                                :datetime="
                                    news.publishedAt
                                "
                            >
                                {{
                                    formatDate(
                                        news.publishedAt
                                    )
                                }}
                            </time>

                        </div>


                        <!-- News Title -->
                        <h3>

                            <a
                                v-if="news.url"
                                :href="news.url"
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                {{ news.title }}
                            </a>

                            <span v-else>
                                {{ news.title }}
                            </span>

                        </h3>


                        <!-- Description -->
                        <p
                            v-if="news.description"
                            class="news-description"
                        >
                            {{ news.description }}
                        </p>


                        <!-- Card Footer -->
                        <footer
                            v-if="news.url"
                            class="news-card-footer"
                        >

                            <span class="external-label">
                                External News
                            </span>

                            <a
                                :href="news.url"
                                target="_blank"
                                rel="noopener noreferrer"
                                :aria-label="
                                    `Read ${news.title} on the original website`
                                "
                            >
                                Read Article

                                <span aria-hidden="true">
                                    ↗
                                </span>

                            </a>

                        </footer>

                    </div>

                </article>

            </section>


            <!-- =================================================
                 Load More News
                 ================================================= -->

            <div
                v-if="hasMoreNews"
                class="load-more-container"
            >

                <p>
                    Showing
                    {{ visibleNews.length }}
                    of
                    {{ displayedNews.length }}
                    articles
                </p>

                <button
                    type="button"
                    class="load-more-button"
                    @click="showMoreNews"
                >
                    Load More News

                    <span aria-hidden="true">
                        ↓
                    </span>
                </button>

            </div>

        </template>


        <!-- =================================================
             No Search Results
             ================================================= -->

        <div
            v-else-if="isSearchActive"
            class="news-status"
            role="status"
            aria-live="polite"
        >

            <span
                class="news-status-marker"
                aria-hidden="true"
            >
                ?
            </span>

            <div>

                <p class="news-status-title">
                    No news found
                </p>

                <p>
                    No results were found for
                    "{{ activeSearchQuery }}".
                </p>

                <button
                    type="button"
                    class="retry-button"
                    @click="clearSearch"
                >
                    Return to Latest News
                </button>

            </div>

        </div>


        <!-- =================================================
             No News Available
             ================================================= -->

        <div
            v-else
            class="news-status"
            role="status"
        >

            <span
                class="news-status-marker"
                aria-hidden="true"
            >
                i
            </span>

            <div>

                <p class="news-status-title">
                    No news available
                </p>

                <p>
                    No cannabis news articles are currently
                    available.
                </p>

            </div>

        </div>

    </div>

</template>


<script>

import NewsService
    from "../../services/NewsService.js";


export default {

    name: "NewsFeed",

    data() {

        return {

            // Store the search input
            searchQuery:
                "",

            // Store the active search term
            activeSearchQuery:
                "",

            // Store latest news from the API
            fetchedNews:
                [],

            // Store the news currently displayed
            displayedNews:
                [],

            // Track whether search results are active
            isSearchActive:
                false,

            // Track the current loading state
            isLoading:
                true,

            // Store user-facing errors
            errorMessage:
                "",

            // Number of articles shown at first
            visibleCount:
                12,

            // Number of articles added with Load More
            articlesPerPage:
                12,

            // Track images that fail to load
            failedImageIDs:
                []

        };

    },

    computed: {

        // Get the current loading message
        loadingMessage() {

            if (this.isSearchActive) {

                return (
                    "Searching cannabis news..."
                );

            }

            return (
                "Loading the latest cannabis news..."
            );

        },


        // Sort current news from newest to oldest
        sortedNews() {

            return [
                ...this.displayedNews
            ].sort(
                (
                    firstArticle,
                    secondArticle
                ) => {

                    return (
                        this.getPublishedDateValue(
                            secondArticle.publishedAt
                        )
                        -
                        this.getPublishedDateValue(
                            firstArticle.publishedAt
                        )
                    );

                }
            );

        },


        // Get only the articles currently visible
        visibleNews() {

            return this.sortedNews.slice(
                0,
                this.visibleCount
            );

        },


        // Check if more articles can be shown
        hasMoreNews() {

            return (
                this.visibleNews.length
                <
                this.displayedNews.length
            );

        },


        // Get information about current results
        resultsMessage() {

            const resultCount =
                this.displayedNews.length;

            if (this.isSearchActive) {

                const resultWord =
                    resultCount === 1
                        ? "result"
                        : "results";

                return (
                    `${resultCount} ${resultWord}`
                    + ` for "${this.activeSearchQuery}"`
                );

            }

            const articleWord =
                resultCount === 1
                    ? "article"
                    : "articles";

            return (
                `${resultCount} latest ${articleWord}`
            );

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

            this.resetVisibleCount();

            NewsService
                .getNews()
                .then((response) => {

                    this.fetchedNews =
                        response.data
                        || [];

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

            this.activeSearchQuery =
                query;

            this.isLoading = true;

            this.errorMessage = "";

            this.resetVisibleCount();

            NewsService
                .searchNews(
                    query
                )
                .then((response) => {

                    this.displayedNews =
                        response.data
                        || [];

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

            this.resetVisibleCount();

        },


        // Show another group of news articles
        showMoreNews() {

            this.visibleCount +=
                this.articlesPerPage;

        },


        // Reset the number of visible articles
        resetVisibleCount() {

            this.visibleCount =
                this.articlesPerPage;

        },


        // Check if a news image failed
        hasImageError(
            newsID
        ) {

            return this.failedImageIDs.includes(
                newsID
            );

        },


        // Store a news image error
        handleImageError(
            newsID
        ) {

            if (
                !this.failedImageIDs.includes(
                    newsID
                )
            ) {

                this.failedImageIDs.push(
                    newsID
                );

            }

        },


        // Convert publication date for sorting
        getPublishedDateValue(
            publishedAt
        ) {

            if (!publishedAt) {
                return 0;
            }

            const publishedDate =
                new Date(
                    publishedAt
                );

            if (
                Number.isNaN(
                    publishedDate.getTime()
                )
            ) {
                return 0;
            }

            return publishedDate.getTime();

        },


        // Format the article publication date
        formatDate(
            publishedAt
        ) {

            if (!publishedAt) {
                return "";
            }

            const publishedDate =
                new Date(
                    publishedAt
                );

            if (
                Number.isNaN(
                    publishedDate.getTime()
                )
            ) {
                return "";
            }

            return publishedDate.toLocaleDateString(
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

/* =========================================================
   News Feed
   ========================================================= */

#news-feed {
    width: 100%;
}


/* =========================================================
   Search Panel
   ========================================================= */

.news-search-panel {
    margin-bottom: 1.5rem;

    padding: 1.4rem;

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


/* Search Form */
#news-search {
    width:
        min(
            100%,
            44rem
        );
}


/* Search Label */
#news-search label {
    display: block;

    margin-bottom: 0.25rem;

    color:
        var(--color-text);

    font-size: 0.82rem;
    font-weight: 600;
}


/* Search Help */
#news-search-help {
    margin:
        0
        0
        0.7rem;

    color:
        var(--color-text-soft);

    font-size: 0.74rem;
}


/* Search Row */
.news-search-row {
    display: flex;

    gap: 0.65rem;
}


/* Search Input */
#news-search-input {
    flex: 1;

    min-width: 0;

    min-height: 3.1rem;

    padding:
        0.7rem
        1rem;

    background:
        var(--color-background);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text);

    font-size: 0.86rem;
}


/* Search Placeholder */
#news-search-input::placeholder {
    color:
        var(--color-text-soft);

    opacity: 0.72;
}


/* Search Input Focus */
#news-search-input:focus {
    border-color:
        var(--color-border-strong);

    box-shadow:
        0 0 0 3px
        var(--color-primary-soft);
}


/* Search Button */
.news-search-button {
    display: inline-flex;
    align-items: center;
    justify-content: center;

    gap: 0.45rem;

    min-width: 7rem;

    min-height: 3.1rem;

    padding:
        0.65rem
        1rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-background);

    font-size: 0.78rem;
    font-weight: 600;

    cursor: pointer;
}


/* Search Button Hover */
.news-search-button:hover:not(:disabled) {
    background:
        var(--color-primary-hover);
}


/* Disabled Search */
.news-search-button:disabled {
    cursor: not-allowed;

    opacity: 0.48;
}


/* =========================================================
   Active Search
   ========================================================= */

.active-search {
    display: flex;
    align-items: center;
    justify-content: space-between;

    gap: 1rem;

    margin-top: 0.9rem;

    padding-top: 0.9rem;

    border-top:
        1px solid
        var(--color-border);

    color:
        var(--color-text-soft);

    font-size: 0.74rem;
}


/* Active Search Term */
.active-search strong {
    color:
        var(--color-text);
}


/* Clear Search */
.active-search button {
    padding:
        0.4rem
        0.7rem;

    background:
        transparent;

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.7rem;
    font-weight: 600;

    cursor: pointer;
}


/* Clear Search Hover */
.active-search button:hover {
    background:
        var(--color-primary-soft);
}


/* =========================================================
   Results Summary
   ========================================================= */

.news-results-summary {
    margin:
        0
        0
        1.25rem;

    color:
        var(--color-text-soft);

    font-size: 0.8rem;
}


/* Results Summary Text */
.news-results-summary p {
    margin: 0;
}


/* =========================================================
   News Grid
   ========================================================= */

#news-results {
    display: grid;

    grid-template-columns:
        repeat(
            3,
            minmax(
                0,
                1fr
            )
        );

    align-items: stretch;

    gap: 1.25rem;
}


/* =========================================================
   News Card
   ========================================================= */

.news-card {
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


/* News Card Hover */
.news-card:hover {
    border-color:
        var(--color-border-strong);

    box-shadow:
        0 18px 40px
        var(--color-shadow-strong);

    transform:
        translateY(-3px);
}


/* =========================================================
   News Image
   ========================================================= */

.news-image-container {
    position: relative;

    aspect-ratio: 16 / 9;

    overflow: hidden;

    background:
        var(--color-surface-soft);
}


/* News Image */
.news-image {
    width: 100%;
    height: 100%;

    object-fit: cover;
}


/* Image Placeholder */
.news-image-placeholder {
    display: flex;
    flex-direction: column;
    justify-content: center;

    width: 100%;
    height: 100%;

    padding: 1.4rem;

    background:
        linear-gradient(
            135deg,
            var(--color-primary),
            var(--color-footer-background)
        );

    color:
        var(--color-text-light);
}


/* Placeholder Label */
.placeholder-label {
    color:
        var(--color-gold);

    font-size: 0.58rem;
    font-weight: 600;

    letter-spacing: 0.18em;

    text-transform: uppercase;
}


/* Placeholder Title */
.placeholder-title {
    margin-top: 0.35rem;

    font-size: 1.45rem;
    font-weight: 500;

    letter-spacing: -0.02em;
}


/* Placeholder Line */
.placeholder-line {
    width: 3.5rem;
    height: 1px;

    margin-top: 0.8rem;

    background:
        var(--color-gold);
}


/* News Badge */
.news-card-badge {
    position: absolute;

    top: 0.75rem;
    left: 0.75rem;

    padding:
        0.3rem
        0.55rem;

    background:
        var(--color-header-background);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.58rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;

    backdrop-filter:
        blur(10px);

    -webkit-backdrop-filter:
        blur(10px);
}


/* =========================================================
   News Content
   ========================================================= */

.news-content {
    display: flex;
    flex: 1;
    flex-direction: column;

    padding: 1.2rem;
}


/* News Metadata */
.news-meta {
    display: flex;
    flex-wrap: wrap;
    align-items: center;

    gap: 0.35rem;

    margin-bottom: 0.75rem;

    color:
        var(--color-text-soft);

    font-size: 0.67rem;

    line-height: 1.4;
}


/* News Source */
.news-source {
    color:
        var(--color-gold-dark);

    font-weight: 600;
}


/* News Heading */
.news-content h3 {
    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text);

    font-size: 1.05rem;
    font-weight: 600;

    line-height: 1.3;
}


/* News Title Link */
.news-content h3 a {
    color: inherit;

    text-decoration: none;
}


/* News Title Hover */
.news-content h3 a:hover {
    color:
        var(--color-primary);

    text-decoration: underline;

    text-decoration-color:
        var(--color-gold);

    text-decoration-thickness: 1px;

    text-underline-offset: 0.2em;
}


/* News Description */
.news-description {
    display: -webkit-box;

    margin:
        0
        1.2rem;

    overflow: hidden;

    color:
        var(--color-text-soft);

    font-size: 0.8rem;

    line-height: 1.6;

    -webkit-box-orient: vertical;
    -webkit-line-clamp: 4;
}


/* =========================================================
   Card Footer
   ========================================================= */

.news-card-footer {
    display: flex;
    align-items: center;
    justify-content: space-between;

    gap: 0.75rem;

    margin-top: auto;

    padding-top: 1rem;

    border-top:
        1px solid
        var(--color-border);
}


/* External Label */
.external-label {
    color:
        var(--color-text-soft);

    font-size: 0.55rem;
    font-weight: 600;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


/* Read Article */
.news-card-footer a {
    display: inline-flex;
    align-items: center;

    gap: 0.35rem;

    color:
        var(--color-primary);

    font-size: 0.72rem;
    font-weight: 600;

    text-decoration: none;
}


/* Read Article Hover */
.news-card-footer a:hover {
    color:
        var(--color-gold-dark);
}


/* =========================================================
   Status Messages
   ========================================================= */

.news-status {
    display: flex;
    align-items: flex-start;

    gap: 1rem;

    min-height: 8rem;

    padding: 1.4rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    color:
        var(--color-text-soft);
}


/* Status Marker */
.news-status-marker {
    display: grid;
    place-items: center;

    width: 2.5rem;
    height: 2.5rem;

    flex-shrink: 0;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius: 50%;

    color:
        var(--color-primary);

    font-size: 0.75rem;
    font-weight: 700;
}


/* Loading Marker */
.news-status-marker:empty::after {
    width: 0.55rem;
    height: 0.55rem;

    background:
        var(--color-gold);

    border-radius: 50%;

    content: "";
}


/* Error Marker */
.news-status-error
.news-status-marker {
    color:
        var(--color-danger);
}


/* Status Text */
.news-status p {
    margin:
        0.15rem
        0;
}


/* Status Title */
.news-status
.news-status-title {
    color:
        var(--color-text);

    font-weight: 600;
}


/* Retry Button */
.retry-button {
    margin-top: 0.65rem;

    padding:
        0.45rem
        0.75rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-background);

    font-size: 0.72rem;
    font-weight: 600;

    cursor: pointer;
}


/* =========================================================
   Load More
   ========================================================= */

.load-more-container {
    display: flex;
    flex-direction: column;
    align-items: center;

    gap: 0.7rem;

    margin-top: 2.5rem;
}


/* Load More Count */
.load-more-container p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.74rem;
}


/* Load More Button */
.load-more-button {
    display: inline-flex;
    align-items: center;

    gap: 0.6rem;

    min-height: 2.8rem;

    padding:
        0.6rem
        1rem;

    background:
        transparent;

    border:
        1px solid
        var(--color-border-strong);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.78rem;
    font-weight: 600;

    cursor: pointer;

    transition:
        background 160ms ease,
        transform 160ms ease;
}


/* Load More Hover */
.load-more-button:hover {
    background:
        var(--color-primary-soft);

    transform:
        translateY(-2px);
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 999.98px) {

    #news-results {
        grid-template-columns:
            repeat(
                2,
                minmax(
                    0,
                    1fr
                )
            );
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 649.98px) {

    #news-results {
        grid-template-columns: 1fr;
    }


    .news-search-row {
        flex-direction: column;
    }


    .news-search-button {
        width: 100%;
    }


    .active-search {
        align-items: flex-start;
        flex-direction: column;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .news-card,
    .load-more-button {
        transition: none;
    }


    .news-card:hover,
    .load-more-button:hover {
        transform: none;
    }

}

</style>