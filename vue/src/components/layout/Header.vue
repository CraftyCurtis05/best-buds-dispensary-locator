<!-- Application Header Component -->
<template>

    <header
        v-if="isAuthenticated"
        id="app-header"
        class="site-header"
    >

        <div class="site-header-inner">

            <!-- Best Buds Brand -->
            <router-link
                :to="{ name: 'home' }"
                class="site-brand"
                aria-label="Best Buds Home"
            >

                <!-- Best Buds Logo -->
                <img
                    :src="logoIcon"
                    class="site-brand-logo"
                    alt=""
                    aria-hidden="true"
                />

                <!-- Best Buds Name -->
                <span class="site-brand-text">

                    <span class="site-brand-name">
                        Best Buds
                    </span>

                    <span class="site-brand-subtitle">
                        Dispensary Locator
                    </span>

                </span>

            </router-link>


            <!-- Main Navigation -->
            <NavBar />

        </div>

    </header>

</template>


<script>

import NavBar from "./NavBar.vue";

import logoIcon from "../../assets/layout/logo/logo-icon.png";

export default {

    name: "AppHeader",

    components: {
        NavBar
    },

    data() {

        return {
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

/* Application Header */
.site-header {
    position: sticky;

    top: 0;

    width: 100%;

    background:
        var(--color-header-background);

    border-bottom:
        1px solid
        var(--color-border);

    box-shadow:
        0 6px 24px
        var(--color-shadow);

    backdrop-filter: blur(16px);
    -webkit-backdrop-filter: blur(16px);

    z-index: 1000;
}


/* Header Content */
.site-header-inner {
    display: flex;
    align-items: center;
    justify-content: space-between;

    gap: 2rem;

    width: min(
        100%,
        var(--page-max-width)
    );

    min-height: 5.25rem;

    margin:
        0
        auto;

    padding:
        0.75rem
        2rem;
}


/* Best Buds Brand */
.site-brand {
    display: inline-flex;
    align-items: center;

    gap: 0.85rem;

    flex-shrink: 0;

    color:
        var(--color-text);

    text-decoration: none;
}


/* Brand Logo */
.site-brand-logo {
    width: 3.1rem;
    height: 3.1rem;

    object-fit: contain;

    transition:
        transform 180ms ease;
}


/* Brand Hover */
.site-brand:hover .site-brand-logo {
    transform:
        translateY(-2px);
}


/* Brand Text */
.site-brand-text {
    display: flex;
    flex-direction: column;

    line-height: 1.15;
}


/* Brand Name */
.site-brand-name {
    color:
        var(--color-primary);

    font-size: 1rem;
    font-weight: 600;

    letter-spacing: 0.19em;

    text-transform: uppercase;
}


/* Brand Subtitle */
.site-brand-subtitle {
    margin-top: 0.3rem;

    color:
        var(--color-gold-dark);

    font-size: 0.63rem;
    font-weight: 500;

    letter-spacing: 0.2em;

    text-transform: uppercase;
}


/* Tablet and Smaller Screens */
@media (max-width: 1049.98px) {

    .site-header-inner {
        gap: 1rem;

        min-height: 4.75rem;

        padding:
            0.65rem
            1.25rem;
    }


    .site-brand-logo {
        width: 2.8rem;
        height: 2.8rem;
    }

}


/* Small Screens */
@media (max-width: 575.98px) {

    .site-header-inner {
        padding:
            0.6rem
            1rem;
    }


    .site-brand {
        gap: 0.65rem;
    }


    .site-brand-logo {
        width: 2.55rem;
        height: 2.55rem;
    }


    .site-brand-name {
        font-size: 0.86rem;

        letter-spacing: 0.14em;
    }


    .site-brand-subtitle {
        font-size: 0.54rem;

        letter-spacing: 0.14em;
    }

}


/* Very Small Screens */
@media (max-width: 380px) {

    .site-brand-subtitle {
        display: none;
    }

}


/* Reduced Motion */
@media (prefers-reduced-motion: reduce) {

    .site-brand-logo {
        transition: none;
    }


    .site-brand:hover .site-brand-logo {
        transform: none;
    }

}

</style>