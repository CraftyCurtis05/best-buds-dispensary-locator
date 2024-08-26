<!-- Articles Visit Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="articles-visit-body">

        <!-- Display Articles Visit Information -->
        <section id="articles-visit">

            <h1>Looking for more information?</h1>

            <summary id="articles-link">
                <router-link v-bind:to="{ name:'articles' }">Visit our articles page</router-link>
            </summary>
            
        </section>

    </body>

</template>

<script>
export default {
    name: "ArticlesVisit"
};
</script>

<style scoped>
#articles-visit-body {
    text-align: center;
}
</style>