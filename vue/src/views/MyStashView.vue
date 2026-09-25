<!-- My Stash View -->
<template>
    <section
        id="my-stash-view"
        aria-labelledby="my-stash-heading"
    >
        <!-- Page Header -->
        <header>
            <h1 id="my-stash-heading">
                My Stash
            </h1>

            <p>
                View the Best Buds Drops you have collected.
            </p>
        </header>

        <!-- Best Buds Drops -->
        <MyStash />
    </section>
</template>

<script>
import MyStash from "../components/profile/MyStash.vue";

export default {
    name: "MyStashView",

    components: {
        MyStash
    }
};
</script>

<style scoped>
</style>