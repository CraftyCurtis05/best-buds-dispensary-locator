<!-- Footer Component Display--->
<template>

    <!-- Display Component Body -->
    <body id="footer-body">

        <!-- Display Logo and Slogan and Link to Home on the Left -->
        <section id="logo">
            <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">
                <img :src="Logo"/>
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
                        <img :src="Facebook"/>
                    </a>
                </nav>

                <!-- Instagram Logo and Link -->
                <nav id="instagram">
                    <a href="http://www.instagram.com/" target="_blank">
                        <img :src="Instagram"/>
                    </a>
                </nav>

                <!-- Twitter Logo and Link -->
                <nav id="twitter">
                    <a href="http://x.com/" target="_blank">
                        <img :src="Twitter"/>
                    </a>
                </nav>

                <!-- LinkedIn Logo and Link -->
                <nav id="linkedin">
                    <a href="http://www.linkedin.com/" target="_blank">
                        <img :src="LinkedIn" />
                    </a>
                </nav>
            </div>
        </section>

    </body>

</template>

<script>
import Logo from '../../assets/layout/logo/logo-dark-theme.png';
import Facebook from '../../assets/layout/social_media/facebook.png';
import Instagram from '../../assets/layout/social_media/instagram.png';
import Twitter from '../../assets/layout/social_media/twitter.png';
import LinkedIn from '../../assets/layout/social_media/linkedin.png';

export default {
    name: "AppFooter",
    
    data() {
      return {
        Logo,
        Facebook,
        Instagram,
        Twitter,
        LinkedIn,

        year: new Date().getFullYear(),  // Return Year and Company Name to use as Template Display for Trademark
        companyName: "Best Buds Locator"
      }
    }
};
</script>

<style scoped>

</style>