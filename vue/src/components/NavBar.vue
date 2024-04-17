<template>
    <div class="nav-bar">
        <div id="left-nav">
            <div id="home-nav">
                <router-link v-bind:to="{ name: 'home' }">Home</router-link>
            </div>
            <div id="search-nav">
                <router-link v-bind:to="{ name: 'search' }">Search</router-link>
            </div>
            <div id="shop-nav">
                <router-link v-bind:to="{ name: 'Shop' }">Shop</router-link>
            </div>
            <div id="tips-tricks-nav">
                <router-link v-bind:to="{ name: 'TipsTricks' }">Tips & Tricks</router-link>
            </div>
            <div id="articles-nav">
                <router-link v-bind:to="{ name: 'Articles' }">Articles</router-link>
            </div>
            <div id="about-us-nav">
                <router-link v-bind:to="{ name: 'About Us' }">About Us</router-link>
        </div>
        <div id="right-nav">
            <div id="profile-nav">
                <p>Profile</p>
            </div>
            <div id="logout-nav">
                <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            </div>
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