<!-- Strain Guide Visit Component Display -->
<template>

    <div id="strain-guide-visit">

        <!-- Display Strain Guide Invitation -->
        <h3>
            Eager to learn what’s behind the leaf?
        </h3>

        <p>
            Please check out our
            <router-link
                :to="{ name: 'strain-guide' }"
            >
                Strain Guide
            </router-link>
            for information.
        </p>

    </div>

</template>

<script>
export default {
    name: "StrainGuideVisit"
};
</script>

<style scoped>

</style>