<!-- Strain Guide Visit Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="strain-guide-visit-body">

        <!-- Display Strain Guide Visit Link -->
        <section id="strain-guide-visit">

            <h1>Looking for more information on types and strains?</h1>

            <summary id="strain-guide-link">
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
#strain-guide-visit-body {
    text-align: center;
}
</style>