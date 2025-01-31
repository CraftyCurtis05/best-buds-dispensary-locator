<!-- Strain Guide Visit Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="visit-body">

        <!-- Display Strain Guide Visit Link -->
        <section id="visit">

            <h1>Eager to learn what’s behind the leaf?</h1>

            <summary id="guide-link">
                Please check out our <router-link v-bind:to="{ name:'strainguide' }">Strain Guide</router-link> for information.
            </summary>
            
        </section>

    </body>

</template>

<script>
export default {
    name: "StrainGuideVisit"
};
</script>

<style scoped>
body {
    text-align: center;
    font-size: 1.1rem;
    font-weight: 500;
    padding-block: 1rem;
}

h1 {
    font-size: 1.1rem;
    font-weight: 600;
}
</style>