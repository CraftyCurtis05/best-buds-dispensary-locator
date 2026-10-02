<!-- On This Page Navigation Component -->
<template>

    <nav
        v-if="topics.length"
        class="on-this-page"
        :aria-label="heading"
    >

        <!-- Navigation Header -->
        <header class="on-this-page-header">

            <div>

                <p class="on-this-page-label">
                    Quick Navigation
                </p>

                <h2>
                    {{ heading }}
                </h2>

            </div>


            <!-- Topic Count -->
            <span class="topic-count">

                {{ topics.length }}

                {{
                    topics.length === 1
                        ? "section"
                        : "sections"
                }}

            </span>

        </header>


        <!-- Page Topics -->
        <ul class="topic-list">

            <li
                v-for="(
                    topic,
                    index
                ) in topics"
                :key="topic.id"
            >

                <a
                    :href="`#${topic.id}`"
                    class="topic-link"
                >

                    <!-- Topic Number -->
                    <span
                        class="topic-number"
                        aria-hidden="true"
                    >
                        {{
                            String(
                                index + 1
                            )
                                .padStart(
                                    2,
                                    "0"
                                )
                        }}
                    </span>


                    <!-- Topic Label -->
                    <span class="topic-label">
                        {{ topic.label }}
                    </span>


                    <!-- Topic Arrow -->
                    <span
                        class="topic-arrow"
                        aria-hidden="true"
                    >
                        ↓
                    </span>

                </a>

            </li>

        </ul>

    </nav>

</template>


<script>

export default {

    name: "OnThisPage",

    props: {

        topics: {
            type: Array,
            default: () => []
        },

        heading: {
            type: String,
            default: "On This Page"
        }

    }

};

</script>


<style scoped>

/* =========================================================
   On This Page Navigation
   ========================================================= */

.on-this-page {
    width: 100%;

    margin:
        2rem
        0
        3rem;

    padding:
        1.4rem;

    background:
        linear-gradient(
            135deg,
            var(--color-surface),
            var(--color-surface-soft)
        );

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 12px 30px
        var(--color-shadow);
}


/* =========================================================
   Navigation Header
   ========================================================= */

.on-this-page-header {
    display: flex;
    align-items: flex-end;
    justify-content: space-between;

    gap: 1rem;

    margin-bottom: 1rem;
}


/* Navigation Label */
.on-this-page-label {
    margin:
        0
        0
        0.3rem;

    color:
        var(--color-gold-dark);

    font-size: 0.65rem;
    font-weight: 600;

    letter-spacing: 0.16em;

    text-transform: uppercase;
}


/* Navigation Heading */
.on-this-page h2 {
    margin: 0;

    color:
        var(--color-text);

    font-size: 1.15rem;
    font-weight: 600;
}


/* Topic Count */
.topic-count {
    color:
        var(--color-text-soft);

    font-size: 0.72rem;

    white-space: nowrap;
}


/* =========================================================
   Topic List
   ========================================================= */

.topic-list {
    display: grid;

    grid-template-columns:
        repeat(
            3,
            minmax(
                0,
                1fr
            )
        );

    gap: 0.6rem;

    padding: 0;
    margin: 0;

    list-style: none;
}


/* =========================================================
   Topic Link
   ========================================================= */

.topic-link {
    display: grid;

    grid-template-columns:
        auto
        1fr
        auto;

    align-items: center;

    gap: 0.65rem;

    min-height: 3.2rem;

    padding:
        0.65rem
        0.75rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);

    color:
        var(--color-text);

    text-decoration: none;

    transition:
        transform 160ms ease,
        background 160ms ease,
        border-color 160ms ease;
}


/* Topic Link Hover */
.topic-link:hover {
    background:
        var(--color-primary-soft);

    border-color:
        var(--color-border-strong);

    transform:
        translateY(-2px);
}


/* =========================================================
   Topic Number
   ========================================================= */

.topic-number {
    display: grid;
    place-items: center;

    min-width: 1.8rem;
    height: 1.8rem;

    background:
        var(--color-surface-soft);

    border:
        1px solid
        var(--color-border);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.62rem;
    font-weight: 600;
}


/* =========================================================
   Topic Label
   ========================================================= */

.topic-label {
    min-width: 0;

    font-size: 0.78rem;
    font-weight: 500;

    line-height: 1.3;
}


/* =========================================================
   Topic Arrow
   ========================================================= */

.topic-arrow {
    color:
        var(--color-gold-dark);

    font-size: 0.8rem;

    transition:
        transform 160ms ease;
}


/* Topic Arrow Hover */
.topic-link:hover
.topic-arrow {
    transform:
        translateY(3px);
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 899.98px) {

    .topic-list {
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

@media (max-width: 575.98px) {

    .on-this-page {
        margin:
            1.5rem
            0
            2.5rem;

        padding: 1rem;
    }


    .on-this-page-header {
        align-items: flex-start;
        flex-direction: column;

        gap: 0.35rem;
    }


    .topic-list {
        grid-template-columns: 1fr;
    }


    .topic-link {
        min-height: 3rem;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .topic-link,
    .topic-arrow {
        transition: none;
    }


    .topic-link:hover,
    .topic-link:hover
    .topic-arrow {
        transform: none;
    }

}

</style>