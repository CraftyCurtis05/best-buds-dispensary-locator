<!-- Application Footer Component -->
<template>

    <footer
        v-if="isAuthenticated"
        id="app-footer"
        class="site-footer"
    >

        <!-- Footer Content -->
        <div class="footer-inner">

            <!-- Best Buds Information -->
            <section
                class="footer-brand"
                aria-labelledby="footer-brand-heading"
            >

                <!-- Best Buds Logo -->
                <img
                    :src="logoIcon"
                    class="footer-logo"
                    alt=""
                    aria-hidden="true"
                />

                <div>

                    <h2 id="footer-brand-heading">
                        Best Buds
                    </h2>

                    <p class="footer-brand-subtitle">
                        Dispensary Locator
                    </p>

                    <p class="footer-description">
                        Find dispensaries, explore cannabis
                        education and make more informed
                        decisions.
                    </p>

                    <p class="footer-tagline">
                        We're Good To Grow!
                    </p>

                </div>

            </section>


            <!-- Explore Best Buds -->
            <nav
                class="footer-section"
                aria-labelledby="footer-explore-heading"
            >

                <h2 id="footer-explore-heading">
                    Explore
                </h2>

                <ul>

                    <li>

                        <router-link
                            :to="{ name: 'search' }"
                        >
                            Dispensary Locator
                        </router-link>

                    </li>

                    <li>

                        <router-link
                            :to="{ name: 'learn' }"
                        >
                            Learn Hub
                        </router-link>

                    </li>

                    <li>

                        <router-link
                            :to="{ name: 'articles' }"
                        >
                            Resource Center
                        </router-link>

                    </li>

                    <li>

                        <router-link
                            :to="{ name: 'legality' }"
                        >
                            Cannabis Legality
                        </router-link>

                    </li>

                </ul>

            </nav>


            <!-- Helpful Links -->
            <nav
                class="footer-section"
                aria-labelledby="footer-links-heading"
            >

                <h2 id="footer-links-heading">
                    Best Buds
                </h2>

                <ul>

                    <li>

                        <router-link
                            :to="{ name: 'about' }"
                        >
                            About Best Buds
                        </router-link>

                    </li>

                    <li>

                        <router-link
                            :to="{ name: 'privacy-policy' }"
                        >
                            Privacy Policy
                        </router-link>

                    </li>

                    <li>

                        <router-link
                            :to="{ name: 'contact-us' }"
                        >
                            Contact Us
                        </router-link>

                    </li>

                </ul>

            </nav>


            <!-- Developer Links -->
            <nav
                class="footer-section"
                aria-labelledby="footer-connect-heading"
            >

                <h2 id="footer-connect-heading">
                    Connect
                </h2>

                <ul>

                    <li>

                        <a
                            href="https://github.com/CraftyCurtis05"
                            target="_blank"
                            rel="noopener noreferrer"
                        >
                            GitHub

                            <span aria-hidden="true">
                                ↗
                            </span>
                        </a>

                    </li>

                    <li>

                        <a
                            href="https://jennifercurtis.me/"
                            target="_blank"
                            rel="noopener noreferrer"
                        >
                            Portfolio

                            <span aria-hidden="true">
                                ↗
                            </span>
                        </a>

                    </li>

                    <li>

                        <a
                            href="https://www.linkedin.com/in/jcurtisdeveloper/"
                            target="_blank"
                            rel="noopener noreferrer"
                        >
                            LinkedIn

                            <span aria-hidden="true">
                                ↗
                            </span>
                        </a>

                    </li>

                </ul>

            </nav>

        </div>


        <!-- Footer Bottom -->
        <div class="footer-bottom">

            <p>
                &copy;
                {{ year }}
                {{ companyName }}
            </p>

            <p>
                Built to help people find, learn and explore.
            </p>

        </div>

    </footer>

</template>


<script>

import logoIcon from "../../assets/layout/logo/logo-icon.png";

export default {

    name: "AppFooter",

    data() {

        return {

            // Store footer information
            year:
                new Date().getFullYear(),

            companyName:
                "Best Buds",

            logoIcon

        };

    },

    computed: {

        // Check whether the user has an active session
        isAuthenticated() {

            return (
                this.$store.state.token !== ""
            );

        }

    }

};

</script>


<style scoped>

/* Application Footer */
.site-footer {
    width: 100%;

    margin-top: auto;

    background:
        var(--color-footer-background);

    border-top:
        1px solid
        var(--color-border-strong);

    color:
        var(--color-footer-text);
}


/* Footer Content */
.footer-inner {
    display: grid;

    grid-template-columns:
        minmax(
            15rem,
            1.6fr
        )
        repeat(
            3,
            minmax(
                9rem,
                1fr
            )
        );

    gap:
        2.5rem
        3rem;

    width:
        min(
            100%,
            var(--page-max-width)
        );

    margin:
        0
        auto;

    padding:
        3.5rem
        2rem
        2.5rem;
}


/* =========================================================
   Footer Brand
   ========================================================= */

.footer-brand {
    display: flex;
    align-items: flex-start;

    gap: 1rem;

    max-width: 27rem;
}


/* Footer Logo */
.footer-logo {
    width: 3.5rem;
    height: 3.5rem;

    flex-shrink: 0;

    object-fit: contain;
}


/* Footer Brand Heading */
.footer-brand h2 {
    margin:
        0
        0
        0.25rem;

    color:
        var(--color-footer-text);

    font-size: 1.05rem;
    font-weight: 600;

    letter-spacing: 0.18em;

    text-transform: uppercase;
}


/* Footer Brand Subtitle */
.footer-brand-subtitle {
    margin:
        0
        0
        1rem;

    color:
        var(--color-gold);

    font-size: 0.67rem;
    font-weight: 500;

    letter-spacing: 0.18em;

    text-transform: uppercase;
}


/* Footer Description */
.footer-description {
    margin:
        0
        0
        0.75rem;

    color:
        var(--color-footer-text-soft);

    font-size: 0.88rem;

    line-height: 1.65;
}


/* Footer Tagline */
.footer-tagline {
    margin: 0;

    color:
        var(--color-gold);

    font-size: 0.82rem;
    font-weight: 600;

    letter-spacing: 0.05em;
}


/* =========================================================
   Footer Sections
   ========================================================= */

.footer-section h2 {
    margin:
        0
        0
        1rem;

    color:
        var(--color-footer-text);

    font-size: 0.75rem;
    font-weight: 600;

    letter-spacing: 0.14em;

    text-transform: uppercase;
}


/* Footer Lists */
.footer-section ul {
    display: flex;
    flex-direction: column;

    gap: 0.65rem;

    padding: 0;
    margin: 0;

    list-style: none;
}


/* Footer Links */
.footer-section a {
    display: inline-flex;
    align-items: center;

    gap: 0.35rem;

    color:
        var(--color-footer-text-soft);

    font-size: 0.84rem;

    text-decoration: none;

    transition:
        color 160ms ease,
        transform 160ms ease;
}


/* Footer Link Hover */
.footer-section a:hover {
    color:
        var(--color-gold);

    transform:
        translateX(2px);
}


/* Footer External Icon */
.footer-section a span {
    color:
        var(--color-gold);

    font-size: 0.72rem;
}


/* =========================================================
   Footer Bottom
   ========================================================= */

.footer-bottom {
    display: flex;
    align-items: center;
    justify-content: space-between;

    gap: 1rem;

    width:
        min(
            100%,
            var(--page-max-width)
        );

    margin:
        0
        auto;

    padding:
        1.25rem
        2rem;

    border-top:
        1px solid
        var(--color-footer-surface);

    color:
        var(--color-footer-text-soft);

    font-size: 0.74rem;
}


/* Footer Bottom Text */
.footer-bottom p {
    margin: 0;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 900px) {

    .footer-inner {
        grid-template-columns:
            repeat(
                2,
                1fr
            );
    }


    .footer-brand {
        max-width: none;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    .footer-inner {
        grid-template-columns: 1fr;

        gap: 2rem;

        padding:
            2.75rem
            1.25rem
            2rem;
    }


    .footer-logo {
        width: 3rem;
        height: 3rem;
    }


    .footer-bottom {
        flex-direction: column;
        align-items: flex-start;

        padding:
            1.25rem;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .footer-section a {
        transition: none;
    }


    .footer-section a:hover {
        transform: none;
    }

}

</style>