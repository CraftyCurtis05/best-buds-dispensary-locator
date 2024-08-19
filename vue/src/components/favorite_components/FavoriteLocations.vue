<!-- Favorite Locations Component Display--->

<template>
    <div class="favorite-locations">
        <h2>Favorite Locations</h2>

        <!-- Make list of locations by looping through each location in locations array by index and display location -->
        <ul>
            <li v-for="(location, index) in locations" :key="index">{{ location }}</li>
        </ul>
    </div>
</template>

<script>
//Export component properties of locations array and mark as required
export default {
    props: {
        locations: {
            type: Array,
            required: true
        }
    }
};
</script>

<style scoped>
.favorite-locations {
    margin-top: 20px;
}

.favorite-locations ul {
    list-style: none;
    padding: 0;
}

.favorite-locations li {
    margin-bottom: 10px;
}
</style>