<!-- Strain Guide Visit Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="visit-body">

        <!-- Display Strain Guide Visit Link -->
        <section id="visit">

            <h1>Eager to learn what’s behind the leaf?</h1>

            <p id="guide-link">
                Please check out our
                <router-link :to="{ name: 'strain-guide' }">
                    Strain Guide
                </router-link>
                for information.
            </p>
            
        </section>

    </body>

</template>

<script>
export default {
    name: "StrainGuideVisit"
};
</script>

<style scoped>

</style>