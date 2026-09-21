<!-- Navigation Bar Component Display--->
<template>

    <!-- Display Component Body -->
    <body id="nav-body">

        <!-- Display Left of Navigation Bar -->
        <section id="left-nav">
            <!-- Home -->
            <nav><router-link id="home-nav" v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link></nav>

            <!-- Search -->
            <nav><router-link id="search-nav" v-bind:to="{ name: 'search' }" v-if="$store.state.token != ''">Search</router-link></nav>

            <!-- Shop -->
            <nav><router-link id="shop-nav" v-bind:to="{ name: 'shop' }" v-if="$store.state.token != ''">Shop</router-link></nav>
            
            <!-- Tips & Tricks -->
            <nav><router-link id="tips-tricks-nav" v-bind:to="{ name: 'tips-tricks' }" v-if="$store.state.token != ''">Tips & Tricks</router-link></nav>
            
            <!-- Articles -->
            <nav><router-link id="articles-nav" v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">Articles</router-link></nav>

            <!-- News -->
            <nav><router-link id="news-nav" v-bind:to="{ name: 'news' }" v-if="$store.state.token != ''">News</router-link></nav>

            <!-- About Us -->
            <nav><router-link id="about-us-nav" v-bind:to="{ name: 'about' }" v-if="$store.state.token != ''">About Us</router-link></nav>
        </section>

        <!-- Display Right of Navigation Bar -->
        <section id="right-nav">
            <!-- Profile -->
            <nav><router-link id="profile-nav" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link></nav>

            <!-- Logout -->
            <nav v-if="$store.state.token != ''">
                <button
                    id="logout-nav"
                    type="button"
                    v-on:click="logout"
                >
                    Logout
                </button>
            </nav>
        </section>

    </body>

</template>

<script>
export default {
    name: "NavBar",

    methods: {

        // Sign out the current user
        logout() {
            this.$store.commit("LOGOUT");

            this.$router.push({
                name: "login"
            });
        }

    }
};
</script>

<style scoped>
#left-nav {
    display: flex;
    flex-direction: row;
    gap: 1.5rem;
}

#right-nav {
    display: flex;
    flex-direction: row-reverse;
    gap: 1.5rem;
}
</style>