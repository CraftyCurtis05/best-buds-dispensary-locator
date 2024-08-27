<!-- Articles Visit Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="articles-body">

        <!-- Display Articles Visit Information -->
        <section id="articles-visit">

            <!-- Display Component Title -->
            <h1>Looking for more information?</h1>

            <!-- Display Visit Articles Link That Routes To Articles View -->
            <article id="articles-link">
                <router-link v-bind:to="{ name:'articles' }">Visit our articles page</router-link>
            </article>
            
        </section>

    </body>

</template>

<script>
export default {
    name: "ArticlesVisit"
};
</script>

<style scoped>
body {
    text-align: center;
}
</style>