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

                <!-- GitHub Logo and Link -->
                <nav id="github">
                    <a href="https://github.com/CraftyCurtis05" target="_blank">
                        <img :src="GitHub"/>
                    </a>
                </nav>

                <!-- Portfolio Logo and Link -->
                <nav id="portfolio">
                    <a href="https://jennifercurtis.me/" target="_blank">
                        <img :src="Portfolio"/>
                    </a>
                </nav>

                <!-- LinkedIn Logo and Link -->
                <nav id="linkedin">
                    <a href="https://www.linkedin.com/in/jcurtisdeveloper/" target="_blank">
                        <img :src="LinkedIn" />
                    </a>
                </nav>
            </div>
        </section>

    </body>

</template>

<script>
import Logo from '../../assets/layout/logo/logo-dark-theme.png';
import GitHub from '../../assets/layout/social-media/github.png';
import Portfolio from '../../assets/layout/social-media/portfolio.png';
import LinkedIn from '../../assets/layout/social-media/linkedin.png';

export default {
    name: "AppFooter",
    
    data() {
      return {
        Logo,
        GitHub,
        Portfolio,
        LinkedIn,

        year: new Date().getFullYear(),  // Return Year and Company Name to use as Template Display for Trademark
        companyName: "Best Buds Locator"
      }
    }
};
</script>

<style scoped>

</style>