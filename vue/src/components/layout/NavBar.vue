<!-- Main Navigation Component -->
<template>
    <div
        v-if="isAuthenticated"
        ref="navContainer"
        @keydown.esc="closeMenu"
    >
        <!-- Primary Navigation -->
        <ul>
            <!-- Home -->
            <li>
                <router-link :to="{ name: 'home' }">
                    Home
                </router-link>
            </li>

            <!-- Discover Menu -->
            <li>
                <button
                    type="button"
                    aria-haspopup="true"
                    :aria-expanded="openMenu === 'discover'"
                    aria-controls="discover-menu"
                    @click="toggleMenu('discover')"
                >
                    Discover
                    <span aria-hidden="true">▾</span>
                </button>

                <ul
                    v-if="openMenu === 'discover'"
                    id="discover-menu"
                >
                    <li>
                        <router-link
                            :to="{ name: 'search' }"
                            @click="closeMenu"
                        >
                            Dispensary Locator
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'saved-dispensaries' }"
                            @click="closeMenu"
                        >
                            Saved Dispensaries
                        </router-link>
                    </li>
                </ul>
            </li>

            <!-- Learn Menu -->
            <li>
                <button
                    type="button"
                    aria-haspopup="true"
                    :aria-expanded="openMenu === 'learn'"
                    aria-controls="learn-menu"
                    @click="toggleMenu('learn')"
                >
                    Learn
                    <span aria-hidden="true">▾</span>
                </button>

                <ul
                    v-if="openMenu === 'learn'"
                    id="learn-menu"
                >
                    <li>
                        <router-link
                            :to="{ name: 'tips-tricks' }"
                            @click="closeMenu"
                        >
                            Getting Started
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'products' }"
                            @click="closeMenu"
                        >
                            Products
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'strain-guide' }"
                            @click="closeMenu"
                        >
                            Strains &amp; Terpenes
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'safety' }"
                            @click="closeMenu"
                        >
                            Safety
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'questions' }"
                            @click="closeMenu"
                        >
                            Common Questions
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'articles' }"
                            @click="closeMenu"
                        >
                            Articles
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'legality' }"
                            @click="closeMenu"
                        >
                            Legality
                        </router-link>
                    </li>
                </ul>
            </li>

            <!-- News -->
            <li>
                <router-link :to="{ name: 'news' }">
                    News
                </router-link>
            </li>
        </ul>

        <!-- User Navigation -->
        <ul>
            <!-- Profile Menu -->
            <li>
                <button
                    type="button"
                    aria-haspopup="true"
                    :aria-expanded="openMenu === 'profile'"
                    aria-controls="profile-menu"
                    @click="toggleMenu('profile')"
                >
                    Profile
                    <span aria-hidden="true">▾</span>
                </button>

                <ul
                    v-if="openMenu === 'profile'"
                    id="profile-menu"
                >
                    <li>
                        <router-link
                            :to="{ name: 'profile' }"
                            @click="closeMenu"
                        >
                            My Profile
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'my-stash' }"
                            @click="closeMenu"
                        >
                            My Stash
                        </router-link>
                    </li>

                    <li>
                        <router-link
                            :to="{ name: 'account-settings' }"
                            @click="closeMenu"
                        >
                            Account Settings
                        </router-link>
                    </li>
                </ul>
            </li>

            <!-- Logout -->
            <li>
                <button
                    type="button"
                    @click="logout"
                >
                    Logout
                </button>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    name: "NavBar",

    data() {
        return {

            // Track the currently open dropdown menu
            openMenu: null

        };
    },

    computed: {

        // Check whether the user has an active session
        isAuthenticated() {
            return this.$store.state.token !== "";
        }

    },

    watch: {

        // Close open menus after navigating to another page
        $route() {
            this.closeMenu();
        }

    },

    mounted() {

        // Close open menus when clicking outside the navigation
        document.addEventListener(
            "click",
            this.handleOutsideClick
        );
    },

    beforeUnmount() {

        // Remove the document listener when the component is removed
        document.removeEventListener(
            "click",
            this.handleOutsideClick
        );
    },

    methods: {

        // Open the selected menu or close it if it is already open
        toggleMenu(menuName) {
            if (this.openMenu === menuName) {
                this.openMenu = null;
                return;
            }

            this.openMenu = menuName;
        },

        // Close the currently open dropdown menu
        closeMenu() {
            this.openMenu = null;
        },

        // Close open menus when clicking outside the navigation
        handleOutsideClick(event) {
            if (
                this.$refs.navContainer &&
                !this.$refs.navContainer.contains(event.target)
            ) {
                this.closeMenu();
            }
        },

        // Sign out the current user
        logout() {
            this.closeMenu();

            this.$store.commit("LOGOUT");

            this.$router.push({
                name: "login"
            });
        }

    }
};
</script>

<style scoped>
</style>