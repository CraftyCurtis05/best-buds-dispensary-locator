<!-- On This Page Navigation -->
<template>

    <nav
        v-if="topics.length"
        class="on-this-page"
        :aria-label="heading"
    >

        <h2>
            {{ heading }}
        </h2>

        <ul>

            <li
                v-for="topic in topics"
                :key="topic.id"
            >

                <a
                    :href="`#${topic.id}`"
                >
                    {{ topic.label }}
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

</style>