<!-- Saved Dispensaries View -->
<template>
    <section
        id="saved-dispensaries-view"
        aria-labelledby="saved-dispensaries-heading"
    >
        <!-- Page Header -->
        <header>
            <h1 id="saved-dispensaries-heading">
                Saved Dispensaries
            </h1>

            <p>
                View and manage the dispensaries you have saved.
            </p>
        </header>

        <!-- Saved Dispensaries -->
        <SavedDispensaries />
    </section>
</template>

<script>
import SavedDispensaries from "../components/profile/SavedDispensaries.vue";

export default {
    name: "SavedDispensariesView",

    components: {
        SavedDispensaries
    }
};
</script>

<style scoped>
</style>