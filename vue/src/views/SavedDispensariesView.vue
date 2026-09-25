<!-- Saved Dispensaries View Display -->
<template>

    <main
        id="saved-dispensaries-view"
        aria-labelledby="saved-dispensaries-heading"
    >

        <!-- Display View Header -->
        <header>

            <h1 id="saved-dispensaries-heading">
                Saved Dispensaries
            </h1>

            <p>
                View and manage the dispensaries you have saved.
            </p>

        </header>

        <!-- Display Saved Dispensaries -->
        <SavedDispensaries />

    </main>

</template>

<script>
import SavedDispensaries from "../components/dispensaries/SavedDispensaries.vue";

export default {
    name: "SavedDispensariesView",

    components: {
        SavedDispensaries
    }
};
</script>

<style scoped>

</style>