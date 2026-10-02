<!-- Search Articles Component Display -->
<template>

    <div id="articles-search">

        <!-- =================================================
             Article Search Controls
             ================================================= -->

        <div class="article-search-controls">

            <!-- Article Search -->
            <form
                id="article-search-bar"
                role="search"
                @submit.prevent
            >

                <label for="article-search-input">
                    Search Resources
                </label>

                <p id="article-search-help">
                    Search titles, topics, authors, categories,
                    or source types.
                </p>


                <div class="article-search-input-row">

                    <input
                        id="article-search-input"
                        v-model="keyword"
                        type="search"
                        name="article-search"
                        placeholder="Try CBD, safety, CDC, research..."
                        aria-describedby="article-search-help"
                        autocomplete="off"
                    />


                    <!-- Clear Search -->
                    <button
                        v-if="keyword"
                        type="button"
                        class="clear-search-button"
                        @click="clearSearch"
                    >
                        Clear
                    </button>

                </div>

            </form>


            <!-- =================================================
                 Category Filters
                 ================================================= -->

            <div class="article-category-filters">

                <p class="filter-label">
                    Filter by category
                </p>


                <div
                    class="filter-buttons"
                    aria-label="Filter resources by category"
                >

                    <!-- All Categories -->
                    <button
                        type="button"
                        class="filter-button"
                        :class="{
                            'filter-button--active':
                                selectedCategory === 'All'
                        }"
                        :aria-pressed="
                            selectedCategory === 'All'
                        "
                        @click="selectCategory('All')"
                    >
                        All
                    </button>


                    <!-- Article Categories -->
                    <button
                        v-for="category in categories"
                        :key="category"
                        type="button"
                        class="filter-button"
                        :class="{
                            'filter-button--active':
                                selectedCategory
                                === category
                        }"
                        :aria-pressed="
                            selectedCategory
                            === category
                        "
                        @click="
                            selectCategory(
                                category
                            )
                        "
                    >
                        {{ category }}
                    </button>

                </div>

            </div>

        </div>


        <!-- =================================================
             Results Information
             ================================================= -->

        <div
            v-if="!hasNoResults"
            class="article-results-summary"
            aria-live="polite"
        >

            <p>

                <strong>
                    {{ filteredArticles.length }}
                </strong>

                {{
                    filteredArticles.length === 1
                        ? "resource"
                        : "resources"
                }}

                <span aria-hidden="true">
                    ·
                </span>

                Newest first

            </p>

        </div>


        <!-- =================================================
             No Results
             ================================================= -->

        <div
            v-if="hasNoResults"
            class="article-no-results"
            role="status"
        >

            <span
                class="no-results-mark"
                aria-hidden="true"
            >
                ?
            </span>

            <div>

                <h3>
                    No resources found
                </h3>

                <p>
                    Try another keyword or choose a different
                    category.
                </p>


                <button
                    type="button"
                    @click="resetFilters"
                >
                    Reset Search
                </button>

            </div>

        </div>


        <!-- =================================================
             Article Results
             ================================================= -->

        <template v-else>

            <section
                id="article-results"
                aria-label="Cannabis article resources"
            >

                <ArticleCard
                    v-for="article in visibleArticles"
                    :key="article.url"
                    :article="article"
                    @article-opened="
                        recordArticleView
                    "
                />

            </section>


            <!-- =================================================
                 Load More Resources
                 ================================================= -->

            <div
                v-if="hasMoreArticles"
                class="load-more-container"
            >

                <p>
                    Showing
                    {{ visibleArticles.length }}
                    of
                    {{ filteredArticles.length }}
                    resources
                </p>

                <button
                    type="button"
                    class="load-more-button"
                    @click="showMoreArticles"
                >
                    Load More Resources

                    <span aria-hidden="true">
                        ↓
                    </span>
                </button>

            </div>

        </template>

    </div>

</template>


<script>

import ArticlesList
    from "../../data/articles/articles.js";

import ArticleCard
    from "./ArticleCard.vue";

import UserActivityService
    from "../../services/UserActivityService.js";

import {
    USER_ACTIVITY_TYPES
} from "../../constants/userActivityTypes.js";


export default {

    name: "ArticlesSearch",

    components: {
        ArticleCard
    },

    emits: [
        "activity-recorded"
    ],

    data() {

        return {

            // Store all article resources
            articles:
                ArticlesList,

            // Store the current search keyword
            keyword:
                "",

            // Store the selected category
            selectedCategory:
                "All",

            // Number of articles shown at first
            visibleCount:
                12,

            // Number of additional articles
            // shown when Load More is selected
            articlesPerPage:
                12

        };

    },

    computed: {

        // Get all available article categories
        categories() {

            const categories =
                this.articles
                    .map(
                        (article) =>
                            article.category
                    )
                    .filter(Boolean);

            return [
                ...new Set(
                    categories
                )
            ].sort();

        },


        // Sort articles from newest to oldest
        sortedArticles() {

            return [
                ...this.articles
            ].sort(
                (
                    firstArticle,
                    secondArticle
                ) => {

                    return (
                        this.getArticleDateValue(
                            secondArticle.date
                        )
                        -
                        this.getArticleDateValue(
                            firstArticle.date
                        )
                    );

                }
            );

        },


        // Filter articles by keyword and category
        filteredArticles() {

            const keyword =
                this.keyword
                    .toLowerCase()
                    .trim();

            return this.sortedArticles.filter(
                (article) => {

                    const matchesCategory =
                        this.selectedCategory === "All"
                        ||
                        article.category
                            === this.selectedCategory;

                    const searchableText = [
                        article.title,
                        article.author,
                        article.date,
                        article.category,
                        article.sourceType,
                        article.description
                    ]
                        .filter(Boolean)
                        .join(" ")
                        .toLowerCase();

                    const matchesKeyword =
                        !keyword
                        ||
                        searchableText.includes(
                            keyword
                        );

                    return (
                        matchesCategory
                        &&
                        matchesKeyword
                    );

                }
            );

        },


        // Show only the current number of articles
        visibleArticles() {

            return this.filteredArticles.slice(
                0,
                this.visibleCount
            );

        },


        // Check if more articles can be displayed
        hasMoreArticles() {

            return (
                this.visibleArticles.length
                <
                this.filteredArticles.length
            );

        },


        // Check if the search returned no results
        hasNoResults() {

            return (
                this.filteredArticles.length
                === 0
            );

        }

    },

    watch: {

        // Reset visible article count
        // whenever the keyword changes
        keyword() {

            this.resetVisibleCount();

        }

    },

    methods: {

        // Convert an article date into a sortable number
        getArticleDateValue(
            date
        ) {

            const monthNumbers = {
                January: 0,
                February: 1,
                March: 2,
                April: 3,
                May: 4,
                June: 5,
                July: 6,
                August: 7,
                September: 8,
                October: 9,
                November: 10,
                December: 11
            };

            const dateParts =
                date
                    .replace(",", "")
                    .split(" ");

            const month =
                monthNumbers[
                    dateParts[0]
                ];

            const year =
                Number(
                    dateParts[
                        dateParts.length - 1
                    ]
                );

            const day =
                dateParts.length === 3
                    ? Number(
                        dateParts[1]
                    )
                    : 1;

            return new Date(
                year,
                month,
                day
            ).getTime();

        },


        // Select an article category
        selectCategory(
            category
        ) {

            this.selectedCategory =
                category;

            this.resetVisibleCount();

        },


        // Display another group of articles
        showMoreArticles() {

            this.visibleCount +=
                this.articlesPerPage;

        },


        // Reset the number of visible articles
        resetVisibleCount() {

            this.visibleCount =
                this.articlesPerPage;

        },


        // Clear only the keyword search
        clearSearch() {

            this.keyword = "";

        },


        // Reset all article filters
        resetFilters() {

            this.keyword = "";

            this.selectedCategory =
                "All";

            this.resetVisibleCount();

        },


        // Record that the user opened an article
        recordArticleView(
            article
        ) {

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES
                        .ARTICLES_VIEW,

                    article.url
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {

                    /*
                     * Activity tracking should not
                     * block the external article.
                     */

                });

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Articles Search
   ========================================================= */

#articles-search {
    width: 100%;
}


/* =========================================================
   Search Controls
   ========================================================= */

.article-search-controls {
    margin-bottom: 1.5rem;

    padding:
        1.4rem;

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


/* Article Search Form */
#article-search-bar {
    width:
        min(
            100%,
            42rem
        );
}


/* Search Label */
#article-search-bar label {
    display: block;

    margin-bottom: 0.25rem;

    color:
        var(--color-text);

    font-size: 0.82rem;
    font-weight: 600;
}


/* Search Help */
#article-search-help {
    margin:
        0
        0
        0.7rem;

    color:
        var(--color-text-soft);

    font-size: 0.74rem;
}


/* Search Input Row */
.article-search-input-row {
    position: relative;

    display: flex;

    gap: 0.6rem;
}


/* Search Input */
#article-search-input {
    width: 100%;

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
#article-search-input::placeholder {
    color:
        var(--color-text-soft);

    opacity: 0.72;
}


/* Search Focus */
#article-search-input:focus {
    border-color:
        var(--color-border-strong);

    box-shadow:
        0 0 0 3px
        var(--color-primary-soft);
}


/* Clear Search Button */
.clear-search-button {
    min-width: 4.5rem;

    padding:
        0.5rem
        0.8rem;

    background:
        transparent;

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text-soft);

    font-size: 0.76rem;
    font-weight: 600;

    cursor: pointer;
}


/* Clear Search Hover */
.clear-search-button:hover {
    background:
        var(--color-surface-soft);

    color:
        var(--color-text);
}


/* =========================================================
   Category Filters
   ========================================================= */

.article-category-filters {
    margin-top: 1.4rem;

    padding-top: 1.2rem;

    border-top:
        1px solid
        var(--color-border);
}


/* Filter Label */
.filter-label {
    margin:
        0
        0
        0.65rem;

    color:
        var(--color-text-soft);

    font-size: 0.72rem;
    font-weight: 600;

    letter-spacing: 0.05em;
}


/* Filter Buttons */
.filter-buttons {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Filter Button */
.filter-button {
    min-height: 2.25rem;

    padding:
        0.4rem
        0.75rem;

    background:
        transparent;

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text-soft);

    font-size: 0.7rem;
    font-weight: 600;

    cursor: pointer;

    transition:
        background 160ms ease,
        border-color 160ms ease,
        color 160ms ease;
}


/* Filter Hover */
.filter-button:hover {
    background:
        var(--color-primary-soft);

    border-color:
        var(--color-border-strong);

    color:
        var(--color-primary);
}


/* Active Filter */
.filter-button--active {
    background:
        var(--color-primary);

    border-color:
        var(--color-primary);

    color:
        var(--color-background);
}


/* =========================================================
   Results Summary
   ========================================================= */

.article-results-summary {
    margin:
        0
        0
        1.5rem;

    color:
        var(--color-text-soft);

    font-size: 0.8rem;
}


/* Summary Text */
.article-results-summary p {
    margin: 0;
}


/* Summary Emphasis */
.article-results-summary strong {
    color:
        var(--color-text);

    font-weight: 600;
}


/* Summary Divider */
.article-results-summary span {
    margin:
        0
        0.3rem;

    color:
        var(--color-gold);
}


/* =========================================================
   Article Results Grid
   ========================================================= */

#article-results {
    display: grid;

    grid-template-columns:
        repeat(
            auto-fit,
            minmax(
                min(
                    100%,
                    20rem
                ),
                1fr
            )
        );

    align-items: stretch;

    gap: 1.5rem;

    width: 100%;
}


/* =========================================================
   No Results
   ========================================================= */

.article-no-results {
    display: flex;
    align-items: flex-start;

    gap: 1rem;

    padding:
        1.5rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);
}


/* No Results Mark */
.no-results-mark {
    display: grid;
    place-items: center;

    width: 2.5rem;
    height: 2.5rem;

    flex-shrink: 0;

    background:
        var(--color-primary-soft);

    border-radius: 50%;

    color:
        var(--color-primary);

    font-weight: 700;
}


/* No Results Heading */
.article-no-results h3 {
    margin:
        0
        0
        0.3rem;

    color:
        var(--color-text);

    font-size: 1rem;
}


/* No Results Text */
.article-no-results p {
    margin:
        0
        0
        0.75rem;

    color:
        var(--color-text-soft);

    font-size: 0.82rem;
}


/* Reset Search Button */
.article-no-results button {
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

    font-size: 0.74rem;
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

    font-size: 0.8rem;
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
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    .article-search-controls {
        padding: 1rem;
    }


    .article-search-input-row {
        flex-direction: column;
    }


    .clear-search-button {
        align-self: flex-start;
    }


    #article-results {
        grid-template-columns: 1fr;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .filter-button,
    .load-more-button {
        transition: none;
    }


    .load-more-button:hover {
        transform: none;
    }

}

</style>