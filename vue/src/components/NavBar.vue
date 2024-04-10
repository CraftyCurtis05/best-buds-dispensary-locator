<template>
    <div class="nav-bar">
        <div id="left-nav">
            <div id="home-nav">
                <router-link v-bind:to="{ name: 'home' }">Home</router-link>
            </div>
            <div id="search-nav">
                <p>Search</p>
            </div>
            <div id="shop-nav">
                <p>Shop</p>
            </div>
            <div id="tips-tricks-nav">
                <p>Tips & Tricks</p>
            </div>
            <div id="articles-nav">
                <p>Articles</p>
            </div>
            <div id="about-us-nav">
                <p>About Us</p>
            </div>
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