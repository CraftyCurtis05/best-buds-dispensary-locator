<template>
    <div class="header">
        <div id="logo">
            <img src="src\assets\dispensary_logo_white_green.png"/>
        </div>
        <div id="banner">
            <img src="src\assets\dispensary_banner.png"/>
        </div>
    </div>    
</template>

<script>
</script>

<style scoped>
.header {
    display: flex;
    margin: 0 auto;
    max-width: 100%;
    align-items: center;
}

#logo {
    position: absolute;
    display: flex;
    width: 20%;
    height: 20%; 
    z-index: 1;
    justify-content: flex-start;
    margin-left: 15px;
}

#banner {
    display: flex;
    margin: 0 auto;
}

#banner img {
    width: 208.9vh;
}
</style>