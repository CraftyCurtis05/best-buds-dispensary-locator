<template>
    <div class="header">
        <div id="logo">
            <img src="src\assets\best_buds_logo_white.png"/>
        </div>
        <div id="banner">
            <img src="src\assets\dispensary_banner_cropped.png"/>
        </div>
    </div>    
</template>

<script>
</script>

<style scoped>
.header {
    display: flex;
    height: 10vw;
}

#logo {
    position: absolute;
    display: flex;
    justify-content: flex-start;
    height: 10vw;
    z-index: 1;
    margin-left: 7vw;
}

#banner {
    display: flex;
    margin: 0 auto;
}

#banner img {
    width: 100vw;
}
</style>