<template>
    <footer class="footer">
        <div class="logo">
            <img src="src\assets\dispensary_logo_white_green.png"/>
        </div>
        <div class="footer-links">
            <h2>Helpful Links</h2>
            <ul>
                
            </ul>
        </div>
        
        <div class="social-media">
            <h2>Follow Us</h2>
            <div class="social-media-logos">
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
        </div>
    </footer>
</template>

<script>
</script>

<style scoped>
.footer {
    display: flex;
    justify-content: space-between;
    box-sizing: border-box;
    background-color: #00331A;
    flex-direction: row;
    align-items: center;
}

.logo {
    display: flex;
    justify-content: flex-start;
    height: 75px;
    margin-left: 25px;
}

.footer-links {
    display: flex;
}

.social-media {
    /* display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center; */
    margin-right: 25px;
    
}

.social-media-logos {
    display: flex;
}


#facebook {
    display: flex;
    flex-direction: row;
    height: 15px;
    padding: 5px;
}

#instagram {
    display: flex;
    flex-direction: row;
    height: 15px; 
    padding: 5px;
}

#twitter {
    display: flex;
    flex-direction: row;
    height: 15px; 
    padding: 5px;
}

#linkedin {
    display: flex;
    flex-direction: row;
    height: 15px; 
    padding: 5px;
}
</style>