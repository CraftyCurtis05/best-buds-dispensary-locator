<!-- My Stash View Display -->
<template>

    <main
        id="my-stash-view"
        aria-labelledby="my-stash-heading"
    >

        <!-- Display View Header -->
        <header>

            <h1 id="my-stash-heading">
                My Stash
            </h1>

            <p>
                View the Best Buds Drops you have collected.
            </p>

        </header>

        <!-- Display Best Buds Drops -->
        <MyStash />

    </main>

</template>

<script>
import MyStash
    from "../components/collectibles/MyStash.vue";

export default {
    name: "MyStashView",

    components: {
        MyStash
    }
};
</script>

<style scoped>

</style>