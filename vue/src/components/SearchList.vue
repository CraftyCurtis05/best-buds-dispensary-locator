<template>
    <div class="locator-search">
        <h1 id="search-list-title">List of dispensaries near you:</h1>
        <div class="search-list">
            <ul>
                <div v-for="result in results" v-bind:key="result.id">
                    <div id="shop-item">
                        <a id="shop-name" v-bind:href="result.url" target="_blank"> {{ result.name }} </a>
                        <div id="shop-details">
                            <p id="shop-address"><a href="https:www.google.com/maps/dir/?api=1" target="_blank"> {{ result.location.address1 }} </a> </p>
                            <a id="shop-name" v-bind:href="result.url" target="_blank"><img id="shop-image" v-bind:src="result.image_url" /> </a>
                        </div>
                        <button id="favorite-button" v-on:click.prevent="setFavorite(result.id)">Favorite Dispensary</button>
                    </div>
                </div>
            </ul>
        </div>
    </div>        
</template>

<script>
export default {
    data() {
        return {
            results: [],
            locationID: ''
        }
    },
    methods: {
        getResults(locationID) {
        }
    }
};    
</script>

<style scoped>
.locator-search {
    background-color: grey;
    width: 23vw;
}

#search-list-title {
    font-size: 110%;
    text-decoration: underline;
}

.search-list {
    font-size: 100%;
    font-weight: bold;
}
</style>