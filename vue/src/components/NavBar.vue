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
            <nav><router-link id="tips-tricks-nav" v-bind:to="{ name: 'tipstricks' }" v-if="$store.state.token != ''">Tips & Tricks</router-link></nav>
            
            <!-- Articles -->
            <nav><router-link id="articles-nav" v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">Articles</router-link></nav>
            
            <!-- About Us -->
            <nav><router-link id="about-us-nav" v-bind:to="{ name: 'aboutus' }" v-if="$store.state.token != ''">About Us</router-link></nav>
        </section>

        <!-- Display Right of Navigation Bar -->
        <section id="right-nav">
            <!-- Profile -->
            <nav><router-link id="profile-nav" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link></nav>

            <!-- Logout -->
            <nav><router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></nav>
        </section>

    </body>

</template>

<script>
export default {
    name: "NavBar"
};
</script>

<style scoped>
/* PLEASE DO NOT TOUCH STYLING */
body {
    position: absolute;
    align-items: center;
    max-width: 100%;
    height: 2vw;
    overflow-x: hidden;
    overflow-y: hidden;
    background-color: #00331A;
}

#left-nav,
#right-nav {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    font-weight: bolder;
    max-width: 60vw;
    max-height: 2vw;
}

#left-nav {
    margin-inline-end: auto;
}

#right-nav {
    margin-inline-start: auto;
}

#home-nav,
#search-nav,
#shop-nav,
#tips-tricks-nav,
#articles-nav,
#about-us-nav,
#profile-nav,
#logout-nav  {
    color: white;
    font-size: 1.2rem;
    text-decoration: none;
    border-radius: .1vw;
    padding-inline: 2.2vw;
    padding-block: 5rem;
}

#home-nav:hover,
#search-nav:hover,
#shop-nav:hover,
#tips-tricks-nav:hover,
#articles-nav:hover,
#about-us-nav:hover,
#profile-nav:hover,
#logout-nav:hover {
    cursor: url('best_buds_logo_icon.ico'), pointer;
    color: hwb(151 0% 85%);
    background: linear-gradient(270deg, #377306, transparent) #01331b;
}
</style>