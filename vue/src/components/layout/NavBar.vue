<!-- Main Navigation Component -->
<template>

    <nav
        id="nav-bar"
        ref="navContainer"
        class="main-navigation"
        aria-label="Main navigation"
        @keydown.esc="closeNavigation"
    >

        <!-- Mobile Navigation Button -->
        <button
            type="button"
            class="nav-toggle"
            :aria-expanded="isMobileMenuOpen"
            aria-controls="main-navigation-menu"
            @click="toggleMobileMenu"
        >

            <span class="nav-toggle-text">
                Menu
            </span>

            <!-- Mobile Menu Icon -->
            <span
                class="nav-toggle-icon"
                aria-hidden="true"
            >
                <span></span>
                <span></span>
                <span></span>
            </span>

        </button>


        <!-- Navigation Menu -->
        <div
            id="main-navigation-menu"
            class="nav-menu"
            :class="{
                'nav-menu--open':
                    isMobileMenuOpen
            }"
        >

            <!-- Primary Navigation -->
            <ul class="nav-list nav-list-primary">

                <!-- Home -->
                <li class="nav-item">

                    <router-link
                        :to="{ name: 'home' }"
                        class="nav-link"
                        @click="closeNavigation"
                    >
                        Home
                    </router-link>

                </li>


                <!-- Discover Menu -->
                <li class="nav-item nav-item-dropdown">

                    <button
                        type="button"
                        class="nav-link nav-dropdown-button"
                        aria-haspopup="true"
                        :aria-expanded="
                            openMenu === 'discover'
                        "
                        aria-controls="discover-menu"
                        @click="toggleMenu('discover')"
                    >

                        <span>
                            Discover
                        </span>

                        <span
                            class="nav-arrow"
                            :class="{
                                'nav-arrow--open':
                                    openMenu === 'discover'
                            }"
                            aria-hidden="true"
                        >
                            ▾
                        </span>

                    </button>


                    <!-- Discover Dropdown -->
                    <ul
                        v-if="openMenu === 'discover'"
                        id="discover-menu"
                        class="nav-dropdown"
                    >

                        <li>

                            <router-link
                                :to="{ name: 'search' }"
                                @click="closeNavigation"
                            >
                                <span class="dropdown-link-title">
                                    Dispensary Locator
                                </span>

                                <span class="dropdown-link-description">
                                    Find dispensaries near you.
                                </span>
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{
                                    name: 'saved-dispensaries'
                                }"
                                @click="closeNavigation"
                            >
                                <span class="dropdown-link-title">
                                    Saved Dispensaries
                                </span>

                                <span class="dropdown-link-description">
                                    Return to places you saved.
                                </span>
                            </router-link>

                        </li>

                    </ul>

                </li>


                <!-- Learn Menu -->
                <li class="nav-item nav-item-dropdown">

                    <button
                        type="button"
                        class="nav-link nav-dropdown-button"
                        aria-haspopup="true"
                        :aria-expanded="
                            openMenu === 'learn'
                        "
                        aria-controls="learn-menu"
                        @click="toggleMenu('learn')"
                    >

                        <span>
                            Learn
                        </span>

                        <span
                            class="nav-arrow"
                            :class="{
                                'nav-arrow--open':
                                    openMenu === 'learn'
                            }"
                            aria-hidden="true"
                        >
                            ▾
                        </span>

                    </button>


                    <!-- Learn Dropdown -->
                    <ul
                        v-if="openMenu === 'learn'"
                        id="learn-menu"
                        class="nav-dropdown nav-dropdown-wide"
                    >

                        <li>

                            <router-link
                                :to="{ name: 'learn' }"
                                @click="closeNavigation"
                            >
                                <span class="dropdown-link-title">
                                    Learn Hub
                                </span>

                                <span class="dropdown-link-description">
                                    Start exploring cannabis education.
                                </span>
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'tips-tricks' }"
                                @click="closeNavigation"
                            >
                                Getting Started
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'products' }"
                                @click="closeNavigation"
                            >
                                Products
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'strain-guide' }"
                                @click="closeNavigation"
                            >
                                Strains &amp; Terpenes
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'safety' }"
                                @click="closeNavigation"
                            >
                                Safety
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'too-much' }"
                                @click="closeNavigation"
                            >
                                Too Much Cannabis
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'questions' }"
                                @click="closeNavigation"
                            >
                                Common Questions
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'articles' }"
                                @click="closeNavigation"
                            >
                                Articles
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'legality' }"
                                @click="closeNavigation"
                            >
                                Legality
                            </router-link>

                        </li>

                    </ul>

                </li>


                <!-- News -->
                <li class="nav-item">

                    <router-link
                        :to="{ name: 'news' }"
                        class="nav-link"
                        @click="closeNavigation"
                    >
                        News
                    </router-link>

                </li>

            </ul>


            <!-- User Navigation -->
            <ul class="nav-list nav-list-user">

                <!-- Profile Menu -->
                <li class="nav-item nav-item-dropdown">

                    <button
                        type="button"
                        class="nav-link nav-dropdown-button"
                        aria-haspopup="true"
                        :aria-expanded="
                            openMenu === 'profile'
                        "
                        aria-controls="profile-menu"
                        @click="toggleMenu('profile')"
                    >

                        <span>
                            Profile
                        </span>

                        <span
                            class="nav-arrow"
                            :class="{
                                'nav-arrow--open':
                                    openMenu === 'profile'
                            }"
                            aria-hidden="true"
                        >
                            ▾
                        </span>

                    </button>


                    <!-- Profile Dropdown -->
                    <ul
                        v-if="openMenu === 'profile'"
                        id="profile-menu"
                        class="nav-dropdown nav-dropdown-right"
                    >

                        <li>

                            <router-link
                                :to="{ name: 'profile' }"
                                @click="closeNavigation"
                            >
                                My Profile
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{ name: 'my-stash' }"
                                @click="closeNavigation"
                            >
                                My Stash
                            </router-link>

                        </li>


                        <li>

                            <router-link
                                :to="{
                                    name: 'account-settings'
                                }"
                                @click="closeNavigation"
                            >
                                Account Settings
                            </router-link>

                        </li>

                    </ul>

                </li>


                <!-- Logout -->
                <li class="nav-item">

                    <button
                        type="button"
                        class="logout-button"
                        @click="logout"
                    >
                        Logout
                    </button>

                </li>

            </ul>

        </div>

    </nav>

</template>


<script>
export default {

    name: "NavBar",

    data() {

        return {

            // Track the currently open dropdown menu
            openMenu: null,

            // Track whether the mobile menu is open
            isMobileMenuOpen: false

        };

    },

    watch: {

        // Close the navigation after changing pages
        $route() {

            this.closeNavigation();

        }

    },

    mounted() {

        // Close the navigation when clicking outside of it
        document.addEventListener(
            "click",
            this.handleOutsideClick
        );

    },

    beforeUnmount() {

        // Remove the click listener when this component is removed
        document.removeEventListener(
            "click",
            this.handleOutsideClick
        );

    },

    methods: {

        // Open or close the mobile navigation
        toggleMobileMenu() {

            this.isMobileMenuOpen =
                !this.isMobileMenuOpen;

            // Close dropdowns when closing the mobile menu
            if (!this.isMobileMenuOpen) {
                this.openMenu = null;
            }

        },


        // Open the selected dropdown menu
        toggleMenu(
            menuName
        ) {

            if (
                this.openMenu === menuName
            ) {

                this.openMenu = null;

                return;

            }

            this.openMenu = menuName;

        },


        // Close all navigation menus
        closeNavigation() {

            this.openMenu = null;

            this.isMobileMenuOpen = false;

        },


        // Close menus when clicking outside the navigation
        handleOutsideClick(
            event
        ) {

            if (
                this.$refs.navContainer
                &&
                !this.$refs.navContainer.contains(
                    event.target
                )
            ) {

                this.closeNavigation();

            }

        },


        // Sign out the current user
        logout() {

            this.closeNavigation();

            this.$store.commit(
                "LOGOUT"
            );

            this.$router.push({
                name: "login"
            });

        }

    }

};

</script>


<style scoped>

/* Main Navigation */
.main-navigation {
    position: relative;

    display: flex;
    align-items: center;

    margin-left: auto;
}


/* =========================================================
   Mobile Menu Button
   ========================================================= */

.nav-toggle {
    display: inline-flex;
    align-items: center;

    gap: 0.7rem;

    min-height: 2.75rem;

    padding:
        0.65rem
        0.9rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-text);

    cursor: pointer;
}


/* Mobile Menu Text */
.nav-toggle-text {
    font-size: 0.78rem;
    font-weight: 600;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


/* Mobile Menu Icon */
.nav-toggle-icon {
    display: flex;
    flex-direction: column;

    gap: 0.25rem;

    width: 1.1rem;
}


/* Mobile Menu Icon Lines */
.nav-toggle-icon span {
    width: 100%;
    height: 1px;

    background:
        var(--color-gold);
}


/* =========================================================
   Navigation Menu
   ========================================================= */

.nav-menu {
    position: absolute;

    top: calc(100% + 0.75rem);
    right: 0;

    display: none;

    width:
        min(
            88vw,
            23rem
        );

    max-height:
        calc(
            100vh
            - 7rem
        );

    overflow-y: auto;

    padding: 0.8rem;

    background:
        var(--color-dropdown-background);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 20px 45px
        var(--color-shadow-strong);
}


/* Open Mobile Navigation */
.nav-menu--open {
    display: block;
}


/* Navigation Lists */
.nav-list {
    display: flex;
    flex-direction: column;

    gap: 0.25rem;

    padding: 0;
    margin: 0;

    list-style: none;
}


/* User Navigation */
.nav-list-user {
    margin-top: 0.75rem;

    padding-top: 0.75rem;

    border-top:
        1px solid
        var(--color-border);
}


/* Navigation Item */
.nav-item {
    position: relative;
}


/* =========================================================
   Navigation Links
   ========================================================= */

.nav-link,
.nav-dropdown-button,
.logout-button {
    display: flex;
    align-items: center;
    justify-content: space-between;

    width: 100%;

    min-height: 2.7rem;

    padding:
        0.65rem
        0.85rem;

    background:
        transparent;

    border:
        1px solid
        transparent;

    border-radius:
        var(--border-radius-medium);

    color:
        var(--color-text);

    font-size: 0.86rem;
    font-weight: 500;

    text-decoration: none;

    cursor: pointer;

    transition:
        background 160ms ease,
        border-color 160ms ease,
        color 160ms ease;
}


/* Navigation Hover */
.nav-link:hover,
.nav-dropdown-button:hover {
    background:
        var(--color-nav-hover);

    border-color:
        var(--color-border);
}


/* Active Router Link */
.nav-link.router-link-active {
    color:
        var(--color-primary);

    background:
        var(--color-primary-soft);
}


/* Dropdown Button */
.nav-dropdown-button {
    font-family: inherit;
}


/* Dropdown Arrow */
.nav-arrow {
    margin-left: 0.45rem;

    color:
        var(--color-gold);

    transition:
        transform 160ms ease;
}


/* Open Dropdown Arrow */
.nav-arrow--open {
    transform:
        rotate(180deg);
}


/* =========================================================
   Dropdown Menus
   ========================================================= */

.nav-dropdown {
    display: flex;
    flex-direction: column;

    gap: 0.2rem;

    padding:
        0.45rem;

    margin:
        0.25rem
        0
        0.5rem
        0.6rem;

    background:
        var(--color-surface-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);

    list-style: none;
}


/* Dropdown Links */
.nav-dropdown a {
    display: flex;
    flex-direction: column;

    gap: 0.15rem;

    padding:
        0.7rem
        0.8rem;

    border-radius:
        var(--border-radius-small);

    color:
        var(--color-text);

    font-size: 0.82rem;

    text-decoration: none;

    transition:
        background 160ms ease,
        color 160ms ease;
}


/* Dropdown Link Hover */
.nav-dropdown a:hover {
    background:
        var(--color-surface);

    color:
        var(--color-primary);
}


/* Dropdown Active Link */
.nav-dropdown a.router-link-active {
    background:
        var(--color-primary-soft);

    color:
        var(--color-primary);
}


/* Dropdown Link Title */
.dropdown-link-title {
    font-weight: 600;
}


/* Dropdown Link Description */
.dropdown-link-description {
    color:
        var(--color-text-soft);

    font-size: 0.72rem;

    line-height: 1.35;
}


/* =========================================================
   Logout Button
   ========================================================= */

.logout-button {
    color:
        var(--color-danger);
}


/* Logout Hover */
.logout-button:hover {
    color:
        var(--color-danger-hover);

    background:
        var(--color-surface-soft);

    border-color:
        var(--color-border);
}


/* =========================================================
   Desktop Navigation
   ========================================================= */

@media (min-width: 1050px) {

    /* Hide Mobile Button */
    .nav-toggle {
        display: none;
    }


    /* Display Navigation */
    .nav-menu {
        position: static;

        display: flex;

        align-items: center;

        gap: 1rem;

        width: auto;
        max-height: none;

        overflow: visible;

        padding: 0;

        background:
            transparent;

        border: 0;

        border-radius: 0;

        box-shadow: none;
    }


    /* Navigation Lists */
    .nav-list {
        flex-direction: row;
        align-items: center;

        gap: 0.2rem;
    }


    /* User Navigation */
    .nav-list-user {
        margin: 0;

        padding:
            0
            0
            0
            1rem;

        border-top: 0;

        border-left:
            1px solid
            var(--color-border);
    }


    /* Navigation Links */
    .nav-link,
    .nav-dropdown-button,
    .logout-button {
        width: auto;

        min-height: 2.55rem;

        padding:
            0.55rem
            0.72rem;

        border-radius:
            var(--border-radius-pill);

        font-size: 0.8rem;
    }


    /* Dropdown Menus */
    .nav-dropdown {
        position: absolute;

        top: calc(100% + 0.65rem);
        left: 0;

        width: 16rem;

        margin: 0;

        padding: 0.55rem;

        background:
            var(--color-dropdown-background);

        box-shadow:
            0 18px 38px
            var(--color-shadow-strong);

        z-index: 100;
    }


    /* Wide Learn Menu */
    .nav-dropdown-wide {
        width: 18rem;
    }


    /* Right Aligned Profile Menu */
    .nav-dropdown-right {
        right: 0;
        left: auto;

        width: 14rem;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .nav-link,
    .nav-dropdown-button,
    .logout-button,
    .nav-arrow {
        transition: none;
    }

}

</style>