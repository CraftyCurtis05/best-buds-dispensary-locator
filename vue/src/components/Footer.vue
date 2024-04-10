<template>
    <footer class="footer">
        <div class="logo">
            <img src="src\assets\dispensary_logo_white_green.png"/>
        </div>
        <div class="footer-links">
            <h2>Helpful Links</h2>
            <ul>
                <a href="www.google.com">Privacy Policy</a>
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
    height: 105px;
    margin-left: 25px;
}

.footer-links {
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
}

.footer-links h2 {
    color: white;
    margin-left: 15px;
}

ul {
    display: flex;
    text-align: center;
    justify-self: center;
}

a {
    text-decoration: none;
    color: white;
    margin-top: -15px;
}

.social-media {
    margin-right: 25px;
    display: flex;
    justify-content: center;
    flex-direction: column;
}

.social-media h2 {
    color: white;
    margin-left: 60px;
}

.social-media-logos {
    display: flex;
    margin-bottom: 25px;
    margin-top: -10px;
}


#facebook {
    display: flex;
    flex-direction: row;
    height: 45px;
    padding: 5px;
}

#instagram {
    display: flex;
    flex-direction: row;
    height: 45px; 
    padding: 5px;
}

#twitter {
    display: flex;
    flex-direction: row;
    height: 45px; 
    padding: 5px;
}

#linkedin {
    display: flex;
    flex-direction: row;
    height: 45px; 
    padding: 5px;
}
</style>