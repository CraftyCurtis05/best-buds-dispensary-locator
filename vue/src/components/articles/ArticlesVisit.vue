<!-- Articles Visit Component Display -->
<template>

    <div id="articles-visit">

        <!-- Display Articles Invitation -->
        <h3>
            Want to elevate your knowledge?
        </h3>

        <p>
            Please
            <router-link
                :to="{ name: 'articles' }"
            >
                visit our articles page
            </router-link>
            to learn more.
        </p>

    </div>

</template>

<script>
export default {
    name: "ArticlesVisit"
};
</script>

<style scoped>

</style>