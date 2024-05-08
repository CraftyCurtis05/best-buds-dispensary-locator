<template>
    <div class="favorite-locations">
    <h2>Favorite Locations</h2>
    <ul>
        <li v-for="(location, index) in locations" :key="index">{{ location }}</li>
    </ul>
    </div>
</template>

<script>
export default {
    props: {
    locations: {
        type: Array,
        required: true
    }
}
}
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
