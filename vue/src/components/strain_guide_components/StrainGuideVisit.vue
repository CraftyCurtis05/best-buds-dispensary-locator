<!-- Strain Guide Visit Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="articles-visit-body">

        <!-- Display Strain Guide Visit Link -->
        <section id="strain-guide">

            <h4>Looking for more information on types and strains?</h4>

            <summary id="strain-guide-link">
                Please check out our <router-link v-bind:to="{ name:'strainguide' }">Strain Guide</router-link> for information.
            </summary>
            
        </section>

    </body>

</template>

<script>
export default {
    name: "StrainGuideVisit"
}
</script>

<style scoped>
</style>