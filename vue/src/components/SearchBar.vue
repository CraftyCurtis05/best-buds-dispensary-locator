<template>
    <div class="search-bar">
        <input id="input-location" type="text" name="user-location" placeholder="Enter your location"/>
        <button id="search-button" v-on:click="search()">Search</button>
    </div>    
</template>

<script>
export default {
    methods: {
        search() {

        }
    }
};    
</script>

<style scoped>
.search-bar {
    padding: 1%;
}
</style>