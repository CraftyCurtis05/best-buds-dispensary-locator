<!-- Navigation Bar Component Display--->
<template>

    <!-- Display Navigation Bar Information -->
    <body>

        <!-- Display 'Home', 'Search', 'Shop', 'Tips & Tricks', 'Articles', 'About Us' to the Left of Navigation Bar -->
        <div class="left-nav">
            <div id="home-div">
                <router-link id="home-nav" v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>
            </div>
            <div id="search-div">    
                <router-link id="search-nav" v-bind:to="{ name: 'search' }" v-if="$store.state.token != ''">Search</router-link>
            </div>
            <div id="shop-div">    
                <router-link id="shop-nav" v-bind:to="{ name: 'shop' }" v-if="$store.state.token != ''">Shop</router-link>
            </div>
            <div id="tips-tricks-div">    
                <router-link id="tips-tricks-nav" v-bind:to="{ name: 'tipstricks' }" v-if="$store.state.token != ''">Tips & Tricks</router-link>
            </div>
            <div id="articles-div">    
                <router-link id="articles-nav" v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">Articles</router-link>
            </div>
            <div id="about-us-div">    
                <router-link id="about-us-nav" v-bind:to="{ name: 'aboutus' }" v-if="$store.state.token != ''">About Us</router-link>
            </div>    
        </div>

        <!-- Display 'Profile', 'Logout' to the Right of Navigation Bar -->
        <div class="right-nav">
            <div id="profile-div">
                <router-link id="profile-nav" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link>
            </div>
            <div id="logout-div">    
                <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            </div>    
        </div>
        
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

.left-nav,
.right-nav {
    display: flex;
    position: absolute;
    font-weight: bold;
}

.right-nav {
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