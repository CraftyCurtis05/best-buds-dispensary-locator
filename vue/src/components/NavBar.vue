<template>
    <div class="nav-bar">
        <div id="left-nav">
            <router-link id="home-nav" v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>
            <div class="separators" id="sep1"></div>
            <router-link id="search-nav" v-bind:to="{ name: 'search' }" v-if="$store.state.token != ''">Search</router-link>
            <router-link id="shop-nav" v-bind:to="{ name: 'Shop' }" v-if="$store.state.token != ''">Shop</router-link>
            <router-link id="tips-tricks-nav" v-bind:to="{ name: 'TipsTricks' }" v-if="$store.state.token != ''">Tips & Tricks</router-link>
            <router-link id="articles-nav" v-bind:to="{ name: 'Articles' }" v-if="$store.state.token != ''">Articles</router-link>
            <router-link id="about-us-nav" v-bind:to="{ name: 'About Us' }" v-if="$store.state.token != ''">About Us</router-link>
        </div>
        <div id="right-nav">
            <router-link id="profile-nav" v-bind:to="{ name: 'Profile' }" v-if="$store.state.token != ''">Profile</router-link>
            <router-link id="logout-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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
    color: white;
    align-items: center;
}

#left-nav {
    display: flex;
}

#right-nav {
    display: flex;
}

#home-nav {
    margin-left: 20px;
}

#search-nav {
    margin-left: 20px;
}

#shop-nav {
    margin-left: 20px;
}

#tips-tricks-nav {
    margin-left: 20px;
}

#articles-nav {
    margin-left: 20px;
}

#about-us-nav {
    margin-left: 20px;
}

#profile-nav {
    margin-right: 20px;
}

#logout-nav {
    margin-right: 20px;
}
</style>