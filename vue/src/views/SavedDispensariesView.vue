<!-- Saved Dispensaries View Display -->
<template>

    <div
        id="saved-dispensaries-view"
        aria-labelledby="saved-dispensaries-heading"
    >

        <!-- Display Page Introduction -->
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

    </div>

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