<!-- Search Articles Component Display -->
<template>

    <div id="articles-search">

        <!-- Display Article Search -->
        <form
            id="article-search-bar"
            role="search"
            @submit.prevent
        >

            <label
                for="article-search-input"
                class="visually-hidden"
            >
                Search cannabis articles
            </label>

            <input
                id="article-search-input"
                v-model="keyword"
                type="search"
                name="article-search"
                placeholder="Enter search keyword"
            />

        </form>

        <!-- Display No Results Message -->
        <p
            v-if="hasNoResults"
            role="status"
        >
            No articles match. Please try again.
        </p>

        <!-- Display Article Results -->
        <div
            v-else
            id="article-results"
        >

            <article
                v-for="article in filteredArticles"
                :key="article.url"
                class="article-result"
            >

                <!-- Display Article Image -->
                <a
                    :href="article.url"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <img
                        :src="getArticleImage(article.image)"
                        :alt="article.title"
                    />
                </a>

                <!-- Display Article Information -->
                <div class="article-information">

                    <h3>
                        <a
                            :href="article.url"
                            target="_blank"
                            rel="noopener noreferrer"
                        >
                            {{ article.title }}
                        </a>
                    </h3>

                    <p class="article-author">
                        {{ article.author }}
                    </p>

                    <p class="article-date">
                        {{ article.date }}
                    </p>

                    <p class="article-description">
                        {{ article.description }}
                    </p>

                </div>

            </article>

        </div>

    </div>

</template>

<script>
import ArticlesList from "../../data/articles/articles.js";

export default {
    name: "ArticlesSearch",

    data() {
        return {
            articles: ArticlesList,
            keyword: ""
        };
    },

    computed: {

        // Filter articles using the search keyword
        filteredArticles() {

            const keyword =
                this.keyword
                    .toLowerCase()
                    .trim();

            if (!keyword) {
                return this.articles;
            }

            return this.articles.filter(
                (article) => {

                    const searchableText = [
                        article.title,
                        article.author,
                        article.date,
                        article.description
                    ]
                        .filter(Boolean)
                        .join(" ")
                        .toLowerCase();

                    return searchableText.includes(
                        keyword
                    );

                }
            );

        },

        // Check if the search returned no articles
        hasNoResults() {

            return (
                this.keyword.trim() !== ""
                && this.filteredArticles.length === 0
            );

        }

    },

    methods: {

        // Get the local image for an article
        getArticleImage(image) {

            return new URL(
                `../../assets/articles/${image}`,
                import.meta.url
            ).href;

        }

    }
};
</script>

<style scoped>

</style>