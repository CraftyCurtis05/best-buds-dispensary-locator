<!-- <<<<< NOT WORKING >>>>> -->
<!-- Favorite Component Display --->
<template>

    <!-- Display Component Body -->
    <body id="favorite-body">

        <!-- Display Component Title -->
        <h1>Favorite Locations</h1>

        <!-- Make List of Locations by Looping Through Each Location in Locations Array and Display Location Object -->
        <ul id="favorite-list">
            <li v-for="(location, index) in locations" :key="index">{{ location }}</li>
        </ul>

    </body>

</template>

<script>
export default {
    name: "FavoritesComponent",

    props: {
        locations: {
            type: Array,
            required: true
        }
    }
};
</script>

<style scoped>

</style>