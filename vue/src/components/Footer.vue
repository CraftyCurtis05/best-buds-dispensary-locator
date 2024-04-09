<template>
    <footer class="footer">
        <div class="logo">
            <img src="src\assets\dispensary_logo_white_green.png"/>
        </div>
        <div class="footer-links">
            <ul>
                <h2>Helpful Links</h2>
            </ul>
        </div>
        <div class="social-media">
            <h2>Follow Us</h2>
            <div id="facebook">
                <img src="src\assets\facebook_logo.png"/>
            </div>
            <div id="instagram">
                <img src="src\assets\instagram_logo.png"/>
            </div>
            <div id="twitter">
                <img src="src\assets\twitter_logo.png"/>
            </div>
            <div id="linkedin">
                <img src="src\assets\linkedIn_logo.png"/>
            </div>
        </div>
    </footer>
</template>

<script>
</script>

<style scoped>
.footer {
    position: relative;
    display: flex;
    flex-direction: row;
    padding: 0;
}

.logo {
    position: relative;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    padding: 0;
    width: 5%;
    height: 5%; 
}

.footer-links {
    position: relative;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 0;
}

.social-media {
    position: relative;
    display: flex;
    flex-direction: row;
    padding: 0;
}

#facebook {
    position: relative;
    display: flex;
    flex-direction: row;
    padding: 0;
    width: 15%;
    height: 15%; 
}

#instagram {
    position: relative;
    display: flex;
    flex-direction: row;
    padding: 0;
    width: 15%;
    height: 15%; 
}

#twitter {
    position: relative;
    display: flex;
    flex-direction: row;
    padding: 0;
    width: 15%;
    height: 15%; 
}

#linkedin {
    position: relative;
    display: flex;
    flex-direction: row;
    padding: 0;
    width: 15%;
    height: 15%; 
}
</style>