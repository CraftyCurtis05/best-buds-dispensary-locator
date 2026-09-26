<!-- Application Footer Component Display -->
<template>

    <footer
        v-if="isAuthenticated"
        id="app-footer"
    >

        <!-- Display Best Buds Information -->
        <section aria-labelledby="footer-brand-heading">

            <h2 id="footer-brand-heading">
                Best Buds
            </h2>

            <p>
                We're Good To Grow!
            </p>

        </section>

        <!-- Display Helpful Links -->
        <nav aria-labelledby="footer-links-heading">

            <h2 id="footer-links-heading">
                Helpful Links
            </h2>

            <ul>

                <li>
                    <router-link :to="{ name: 'about' }">
                        About Best Buds
                    </router-link>
                </li>

                <li>
                    <router-link :to="{ name: 'privacy-policy' }">
                        Privacy Policy
                    </router-link>
                </li>

                <li>
                    <router-link :to="{ name: 'contact-us' }">
                        Contact Us
                    </router-link>
                </li>

            </ul>

        </nav>

        <!-- Display Social Links -->
        <nav aria-labelledby="social-links-heading">

            <h2 id="social-links-heading">
                Follow Best Buds
            </h2>

            <ul>

                <li>
                    <a
                        href="https://github.com/CraftyCurtis05"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        GitHub
                    </a>
                </li>

                <li>
                    <a
                        href="https://jennifercurtis.me/"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        Portfolio
                    </a>
                </li>

                <li>
                    <a
                        href="https://www.linkedin.com/in/jcurtisdeveloper/"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        LinkedIn
                    </a>
                </li>

            </ul>

        </nav>

        <!-- Display Copyright -->
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