<template>
    <div class="nav-bar">
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
        <div class="right-nav">
            <div id="profile-div">
                <router-link id="profile-nav" v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link>
            </div>
            <div id="logout-div">    
                <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            </div>    
        </div>
    </div>
</template>

<script>
</script>

<style scoped>
.nav-bar {
    display: flex;
    justify-content: space-between;
    box-sizing: border-box;
    background-color: #00331A;
}

.left-nav {
    display: flex;
}

.right-nav {
    display: flex;
}

#home-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}

#search-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}

#shop-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}

#tips-tricks-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}

#articles-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}

#about-us-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}

#profile-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}

#logout-nav {
    text-decoration: none;
    color: white;
    font-size: 90%;
    padding-inline: 2vw;
}
</style>