<!-- Application Footer Component -->
<template>
    <footer
        v-if="isAuthenticated"
        id="app-footer"
    >
        <!-- Best Buds Information -->
        <section aria-labelledby="footer-brand-heading">
            <h2 id="footer-brand-heading">
                Best Buds
            </h2>

            <p>
                We're Good To Grow!
            </p>
        </section>

        <!-- Helpful Links -->
        <nav aria-labelledby="footer-links-heading">
            <h2 id="footer-links-heading">
                Helpful Links
            </h2>

            <router-link :to="{ name: 'about' }">
                About Best Buds
            </router-link>

            <router-link :to="{ name: 'privacy-policy' }">
                Privacy Policy
            </router-link>

            <router-link :to="{ name: 'contact-us' }">
                Contact Us
            </router-link>
        </nav>

        <!-- Social Links -->
        <nav aria-labelledby="social-links-heading">
            <h2 id="social-links-heading">
                Follow Best Buds
            </h2>

            <a
                href="https://github.com/CraftyCurtis05"
                target="_blank"
                rel="noopener noreferrer"
            >
                GitHub
            </a>

            <a
                href="https://jennifercurtis.me/"
                target="_blank"
                rel="noopener noreferrer"
            >
                Portfolio
            </a>

            <a
                href="https://www.linkedin.com/in/jcurtisdeveloper/"
                target="_blank"
                rel="noopener noreferrer"
            >
                LinkedIn
            </a>
        </nav>

        <!-- Copyright -->
        <p>
            &copy; {{ year }} {{ companyName }}
        </p>
    </footer>
</template>

<script>
export default {
    name: "AppFooter",

    data() {
        return {

            // Store the current year and application name
            year: new Date().getFullYear(),
            companyName: "Best Buds"

        };
    },

    computed: {

        // Check whether the user has an active session
        isAuthenticated() {
            return this.$store.state.token !== "";
        }

    }
};
</script>

<style scoped>
</style>