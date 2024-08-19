<!-- Navigation Bar Component Display--->
<template>

    <!-- Display Navigation Bar Body -->
    <body>

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
}
</script>

<style scoped>
body {
    display: flex;
    position: absolute;
    align-items: center;
    max-width: 100vw;
    height: 2vw;
    z-index: 100;
    overflow-x: hidden;
    box-sizing: border-box;
    background-color: #00331A;
}

#left-nav,
#right-nav {
    display: flex;
    position: absolute;
    font-weight: bold;
}

#right-nav {
    margin-left: 80vw;
}

#home-nav,
#search-nav,
#shop-nav,
#tips-tricks-nav,
#articles-nav,
#about-us-nav,
#profile-nav,
#logout-nav  {
    margin-left: 4vw;
    text-decoration: none;
    color: white;
    font-size: 1.1rem;
}
</style>