<template>
    <div class="header">
        <div class="logo-container">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''" target="_blank">
            <img src="src/assets/best_buds_logo_white.png" alt="Logo">
            </router-link>
        </div>
        <div id="banner">
            <img src="src/assets/dispensary_banner_cropped.png" alt="Banner">
        </div>
    </div>
</template>

<script>
export default {
}
</script>

<style scoped>
.header {
    display: flex;
    height: 10vw;
    width: 100vw;
    position: relative;
}

.logo-container {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
}

.logo-container img {
    height: 100%;
}

#banner {
    display: flex;
    margin: 0 auto;
}

#banner img {
    width: 100vw;
}
</style>
