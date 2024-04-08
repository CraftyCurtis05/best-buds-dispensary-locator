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
    position: relative;
    display: flex;
    padding: 0;
}

#logo {
    position: absolute;
    display: flex;
    width: 15%;
    height: 15%; 
    z-index: 1;
    top: 50px;
    left: 25px;
}

#banner {
    position: absolute;
    width: 100%;
    height: 25%;
    border: 0px;
    display: flex;
    padding: 0;
    overflow: hidden;
}
</style>