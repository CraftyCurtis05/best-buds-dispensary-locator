<!-- Footer Component Display--->
<template>

    <!-- Display footer information with three(3) sections -->
    <footer class="footer">

        <!-- Display logo and slogan to the left -->
        <div id="logo">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''" target="_blank"><img src="src\assets\best_buds_logo_white.png"/></router-link>
            <p id="slogan"> "We're Good To Grow!" </p>
        </div>

        <!-- Display helpful links and trademark in the center -->
        <div class="footer-links">
            <h2>Helpful Links</h2>
            <router-link v-bind:to="{ name: 'privacypolicy' }" v-if="$store.state.token != ''">Privacy Policy</router-link>
            <span id="copyright"> @{{ year }} {{ companyName }} </span>
        </div>

        <!-- Display social media links to the right -->
        <div class="social-media">
            <h2>Follow Us</h2>
            <div id="social-media-logos">
                <div id="facebook">
                    <a href="https://www.facebook.com/" target="_blank"><img src="src\assets\facebook_logo.png"/></a>
                </div>
                <div id="instagram">
                    <a href="http://www.instagram.com/" target="_blank"><img src="src\assets\instagram_logo.png"/></a>
                </div>
                <div id="twitter">
                    <a href="http://x.com/" target="_blank"><img src="src\assets\twitter_logo.png"/></a>
                </div>
                <div id="linkedin">
                    <a href="http://www.linkedin.com/" target="_blank"><img src="src\assets\linkedIn_logo.png"/></a>
                </div>
            </div>
        </div>

    </footer>
</template>

<script>
export default {
    
    //Return company name and year to use as template display for trademark
    data() {
      return {
        year: new Date().getFullYear(),
        companyName: "Best Buds Locator",
      };
    }
  };
</script>

<style scoped>
.footer {
    display: flex;
    justify-content: space-around;
    background-color: #00331A;
    text-align: center;
    height: 12vw;
}

#logo img {
    display: flex;
    flex-direction: column;
    height: 7vw;
    padding-top: 15%;
}

#slogan {
    color: white;
    font-size: 0.8vw;
}

.footer-links {
    display: flex;
    flex-direction: column;
    padding-left: 10%;
    padding-right: 10%;
}

.footer-links h2 {
    color: white;
    text-align: center;
    font-size: 1.3vw;
    padding-block-start: 20%;
}

.footer-links a {
    color: white;
    text-align:center;
    text-decoration: none;
    font-size: 1vw;
}

#copyright {
    color: white;
    font-size: 0.77vw;
    padding-block: 50%;
}

.social-media {
    display: flex;
    flex-direction: column;
}

.social-media h2 {
    color: white;
    text-align: center;
    font-size: 1.3vw;
    padding-block-start: 20%;

}

#social-media-logos {
    display: flex;
    align-content: center;
    justify-content: center;
    margin-bottom: 3.5vw;
    margin-top: -1vw;
}

#facebook img {
    display: flex;
    flex-direction: row;
    height: 2.5vw;
    padding: 0.4vw;
}

#instagram img {
    display: flex;
    flex-direction: row;
    height: 2.5vw;
    padding: 0.4vw;
}

#twitter img {
    display: flex;
    flex-direction: row;
    height: 2.5vw;
    padding: 0.4vw;
}

#linkedin img {
    display: flex;
    flex-direction: row;
    height: 2.5vw;
    padding: 0.4vw;
}
</style>