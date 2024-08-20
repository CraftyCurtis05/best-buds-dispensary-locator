<!-- Footer Component Display--->
<template>

    <!-- Display Footer Body -->
    <body>

        <!-- Display Logo and Slogan and Link to Home on the Left -->
        <section id="logo">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">
                <img src="src\assets\logo_assets\best_buds_logo_white.png"/>
            </router-link>
            <p id="slogan">"We're Good To Grow!"</p>
        </section>

        <!-- Display Helpful Links and Copyright in the Center -->
        <section id="footer-links">
            <h1>Helpful Links</h1>
                <nav><router-link v-bind:to="{ name: 'privacypolicy' }" v-if="$store.state.token != ''">Privacy Policy</router-link></nav>
                <nav><router-link v-bind:to="{ name: 'contactus' }" v-if="$store.state.token != ''">Contact Us</router-link></nav>
            <span id="copyright"> @{{ year }} {{ companyName }} </span>
        </section>

        <!-- Display Social Media Links to the Right -->
        <section id="social-media">
            <h2>Follow Us</h2>
            <div id="social-media-logos">

                <!-- Facebook Logo and Link -->
                <nav id="facebook">
                    <a href="https://www.facebook.com/" target="_blank">
                        <img src="src\assets\social_media_assets\facebook_logo.png"/>
                    </a>
                </nav>

                <!-- Instagram Logo and Link -->
                <nav id="instagram">
                    <a href="http://www.instagram.com/" target="_blank">
                        <img src="src\assets\social_media_assets\instagram_logo.png"/>
                    </a>
                </nav>

                <!-- Twitter Logo and Link -->
                <nav id="twitter">
                    <a href="http://x.com/" target="_blank">
                        <img src="src\assets\social_media_assets\twitter_logo.png"/>
                    </a>
                </nav>

                <!-- LinkedIn Logo and Link -->
                <nav id="linkedin">
                    <a href="http://www.linkedin.com/" target="_blank">
                        <img src="src\assets\social_media_assets\linkedIn_logo.png"/>
                    </a>
                </nav>
            </div>
        </section>

    </body>

</template>

<script>
export default {
    name: "Footer",
    
    data() {
      return {
        year: new Date().getFullYear(),  // Return Year and Company Name to use as Template Display for Trademark
        companyName: "Best Buds Locator"
      }
    }
};
</script>

<style scoped>
/* PLEASE DO NOT TOUCH STYLING */
body {
    display: flex;
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    justify-content: space-around;
    text-align: center;
    background-color: #00331A;
}

#logo img {
    display: flex;
    flex-direction: column;
    height: 10vw;
    padding-top: 1.5vw;
}

#slogan {
    color: white;
    font-size: 1vw;
    margin-top: 5px;
}

#footer-links {
    display: flex;
    flex-direction: column;
    padding-left: 10vw;
    padding-right: 10vw;
}

#footer-links h1 {
    color: white;
    text-align: center;
    font-size: 1.3vw;
    padding-block-start: 1.5vw;
}

#footer-links a {
    color: white;
    text-align:center;
    text-decoration: none;
    font-size: 1vw;
}

#copyright {
    color: white;
    font-size: .75vw;
    margin-top: 5vw;
    padding-bottom: 1vw;
}

#social-media {
    display: flex;
    flex-direction: column;
}

#social-media h2 {
    color: white;
    text-align: center;
    font-size: 1.2vw;
    padding-block-start: 4vw;

}

#social-media-logos {
    display: flex;
    align-content: center;
    justify-content: center;
    margin-bottom: 3vw;
    margin-top: -1vw;
}

#facebook img,
#instagram img,
#twitter img,
#linkedin img {
    display: flex;
    flex-direction: row;
    height: 2.5vw;
    padding: .4vw;
}
</style>