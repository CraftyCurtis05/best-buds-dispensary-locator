<!-- Article Card Component -->
<template>

    <article class="article-card">

        <!-- =================================================
             Decorative Background
             ================================================= -->

        <div
            class="article-card-decoration"
            aria-hidden="true"
        >

            <span class="article-ring ring-large"></span>
            <span class="article-ring ring-small"></span>
            <span class="article-dot"></span>

        </div>


        <!-- =================================================
             Card Header
             ================================================= -->

        <header class="article-card-header">

            <!-- Best Buds Branding -->
            <div class="article-brand">

                <img
                    :src="logoIcon"
                    class="article-brand-icon"
                    alt=""
                    aria-hidden="true"
                    width="36"
                    height="36"
                />


                <div class="article-brand-text">

                    <span class="article-brand-name">
                        Best Buds
                    </span>

                    <span class="article-brand-subtitle">
                        Resource Center
                    </span>

                </div>

            </div>


            <!-- Article Category -->
            <span class="article-category">
                {{ article.category }}
            </span>

        </header>


        <!-- =================================================
             Article Content
             ================================================= -->

        <div class="article-card-content">

            <!-- Source Type -->
            <p class="article-source-type">

                <span
                    aria-hidden="true"
                >
                    ✦
                </span>

                {{ article.sourceType }}

            </p>


            <!-- Article Title -->
            <h3 class="article-title">

                <a
                    :href="article.url"
                    target="_blank"
                    rel="noopener noreferrer"
                    @click="openArticle"
                >
                    {{ article.title }}
                </a>

            </h3>


            <!-- Decorative Divider -->
            <div
                class="article-divider"
                aria-hidden="true"
            ></div>


            <!-- Article Metadata -->
            <div class="article-meta">

                <p class="article-author">
                    {{ article.author }}
                </p>

                <p class="article-date">

                    <span aria-hidden="true">
                        •
                    </span>

                    <time>
                        {{ article.date }}
                    </time>

                </p>

            </div>


            <!-- Article Description -->
            <p class="article-description">
                {{ article.description }}
            </p>

        </div>


        <!-- =================================================
             Card Footer
             ================================================= -->

        <footer class="article-card-footer">

            <p class="external-resource-label">
                External Resource
            </p>


            <a
                :href="article.url"
                class="article-link"
                target="_blank"
                rel="noopener noreferrer"
                :aria-label="
                    `Read ${article.title} on the original website`
                "
                @click="openArticle"
            >

                <span>
                    Read Article
                </span>

                <span
                    class="article-link-arrow"
                    aria-hidden="true"
                >
                    ↗
                </span>

            </a>

        </footer>

    </article>

</template>


<script>

import logoIcon
    from "../../assets/layout/logo/logo-icon.png";


export default {

    name: "ArticleCard",

    emits: [
        "article-opened"
    ],

    props: {

        article: {
            type: Object,
            required: true
        }

    },

    data() {

        return {
            logoIcon
        };

    },

    methods: {

        // Tell the parent that the article was opened
        openArticle() {

            this.$emit(
                "article-opened",
                this.article
            );

        }

    }

};

</script>


<style scoped>

/* =========================================================
   Article Card
   ========================================================= */

.article-card {
    position: relative;

    display: flex;
    flex-direction: column;

    width: 100%;
    max-width: 400px;

    min-height: 600px;

    overflow: hidden;

    padding: 1.5rem;

    background:
        linear-gradient(
            155deg,
            var(--color-surface),
            var(--color-surface-soft)
        );

    /*
     * Optional Article Card Background
     *
     * Uncomment after choosing the final
     * article card background image.
     *
     * Suggested location:
     * src/assets/articles/article-card-background.webp
     */

    /*
    background-image:
        linear-gradient(
            var(--color-overlay),
            var(--color-overlay)
        ),
        url(
            "../../assets/articles/article-card-background.webp"
        );

    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    */

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 14px 34px
        var(--color-shadow);

    color:
        var(--color-text);

    isolation: isolate;

    transition:
        transform 180ms ease,
        border-color 180ms ease,
        box-shadow 180ms ease;
}


/* Article Card Hover */
.article-card:hover {
    border-color:
        var(--color-border-strong);

    box-shadow:
        0 20px 46px
        var(--color-shadow-strong);

    transform:
        translateY(-4px);
}


/* =========================================================
   Decorative Background
   ========================================================= */

.article-card-decoration {
    position: absolute;

    right: -5rem;
    bottom: -5rem;

    width: 15rem;
    height: 15rem;

    opacity: 0.22;

    pointer-events: none;

    z-index: -1;
}


/* Decorative Ring */
.article-ring {
    position: absolute;

    top: 50%;
    left: 50%;

    border:
        1px solid
        var(--color-gold);

    border-radius: 50%;

    transform:
        translate(
            -50%,
            -50%
        );
}


/* Large Ring */
.ring-large {
    width: 13rem;
    height: 13rem;
}


/* Small Ring */
.ring-small {
    width: 7.5rem;
    height: 7.5rem;
}


/* Decorative Dot */
.article-dot {
    position: absolute;

    top: 50%;
    left: 50%;

    width: 0.55rem;
    height: 0.55rem;

    background:
        var(--color-gold);

    border-radius: 50%;

    transform:
        translate(
            -50%,
            -50%
        );
}


/* =========================================================
   Card Header
   ========================================================= */

.article-card-header {
    display: flex;
    align-items: flex-start;
    justify-content: space-between;

    gap: 0.8rem;

    margin-bottom: 1.5rem;
}


/* Best Buds Brand */
.article-brand {
    display: flex;
    align-items: center;

    gap: 0.6rem;
}


/* Brand Icon */
.article-brand-icon {
    width: 2rem;
    height: 2rem;

    flex-shrink: 0;

    object-fit: contain;
}


/* Brand Text */
.article-brand-text {
    display: flex;
    flex-direction: column;
}


/* Brand Name */
.article-brand-name {
    color:
        var(--color-primary);

    font-size: 0.7rem;
    font-weight: 600;

    letter-spacing: 0.16em;

    text-transform: uppercase;
}


/* Brand Subtitle */
.article-brand-subtitle {
    margin-top: 0.1rem;

    color:
        var(--color-text-soft);

    font-size: 0.55rem;
    font-weight: 500;

    letter-spacing: 0.12em;

    text-transform: uppercase;
}


/* =========================================================
   Category
   ========================================================= */

.article-category {
    max-width: 9rem;

    padding:
        0.35rem
        0.6rem;

    background:
        var(--color-gold-soft);

    border:
        1px solid
        var(--color-border-strong);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-gold-dark);

    font-size: 0.6rem;
    font-weight: 600;

    letter-spacing: 0.06em;

    line-height: 1.3;

    text-align: center;

    text-transform: uppercase;
}


/* =========================================================
   Article Content
   ========================================================= */

.article-card-content {
    display: flex;
    flex: 1;
    flex-direction: column;
}


/* Source Type */
.article-source-type {
    display: inline-flex;
    align-items: center;

    align-self: flex-start;

    gap: 0.4rem;

    margin:
        0
        0
        1rem;

    color:
        var(--color-gold-dark);

    font-size: 0.65rem;
    font-weight: 600;

    letter-spacing: 0.12em;

    text-transform: uppercase;
}


/* Source Type Icon */
.article-source-type span {
    color:
        var(--color-gold);
}


/* =========================================================
   Article Title
   ========================================================= */

.article-title {
    margin:
        0
        0
        1rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.45rem,
            3vw,
            1.9rem
        );

    font-weight: 500;

    line-height: 1.16;

    letter-spacing: -0.03em;
}


/* Title Link */
.article-title a {
    color: inherit;

    text-decoration: none;
}


/* Title Hover */
.article-title a:hover {
    color:
        var(--color-primary);

    text-decoration: underline;

    text-decoration-color:
        var(--color-gold);

    text-decoration-thickness: 1px;

    text-underline-offset: 0.25em;
}


/* =========================================================
   Divider
   ========================================================= */

.article-divider {
    width: 4rem;
    height: 1px;

    margin-bottom: 1rem;

    background:
        var(--color-gold);
}


/* =========================================================
   Metadata
   ========================================================= */

.article-meta {
    margin-bottom: 1rem;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.5;
}


/* Author */
.article-author {
    margin:
        0
        0
        0.25rem;

    color:
        var(--color-text);

    font-weight: 500;
}


/* Date */
.article-date {
    display: flex;
    align-items: center;

    gap: 0.4rem;

    margin: 0;
}


/* Date Dot */
.article-date span {
    color:
        var(--color-gold);
}


/* =========================================================
   Description
   ========================================================= */

.article-description {
    margin:
        0
        0
        1.4rem;

    color:
        var(--color-text-soft);

    font-size: 0.88rem;

    line-height: 1.65;
}


/* =========================================================
   Card Footer
   ========================================================= */

.article-card-footer {
    display: flex;
    align-items: center;
    justify-content: space-between;

    gap: 1rem;

    margin-top: auto;

    padding-top: 1rem;

    border-top:
        1px solid
        var(--color-border);
}


/* External Resource Label */
.external-resource-label {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.58rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


/* Article Link */
.article-link {
    display: inline-flex;
    align-items: center;

    gap: 0.4rem;

    color:
        var(--color-primary);

    font-size: 0.76rem;
    font-weight: 600;

    text-decoration: none;
}


/* Article Link Hover */
.article-link:hover {
    color:
        var(--color-gold-dark);
}


/* Link Arrow */
.article-link-arrow {
    font-size: 0.9rem;

    transition:
        transform 160ms ease;
}


/* Link Arrow Hover */
.article-link:hover
.article-link-arrow {
    transform:
        translate(
            2px,
            -2px
        );
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    .article-card {
        max-width: 100%;

        min-height: auto;

        padding: 1.25rem;
    }


    .article-card-header {
        flex-direction: column;
    }


    .article-category {
        max-width: 100%;
    }


    .article-card-footer {
        align-items: flex-start;
        flex-direction: column;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .article-card,
    .article-link-arrow {
        transition: none;
    }


    .article-card:hover,
    .article-link:hover
    .article-link-arrow {
        transform: none;
    }

}

</style>