<template>
    <div class="container">
        <div class="header-nav">
            <div class="header"><Header/></div>
        <div class="nav-bar"><NavBar/></div>
    </div>
        <div class="main-content">
<<<<<<< HEAD
        <!-- Search Bar -->
        <div class="search-bar">
            <input type="text" placeholder="Search articles">
            <button @click="search">Search</button>
        </div>
        <div class="articles">
        <!-- Article Boxes -->
            <div class="article-container1" v-for="(article, index) in article1" :key="index">
                <div class="article-box">
                <h2>{{ article.title }}</h2>
                <p>{{ article.description }}</p>
                <a :href="article.link" target="_blank">Read more</a>
=======
            <!-- Search Bar -->
            <div class="search-bar">
                <input type="text" placeholder="Search articles">
                <button @click="search">Search</button>
            </div>
            <div class="articles">
                <!-- Article Boxes -->
                <div class="article-container1" v-for="(article, index) in article1" :key="index">
                    <div class="article-box">
                        <h2>{{ article.title }}</h2>
                        <p>{{ article.description }}</p>
                        <a :href="article.link" target="_blank">Read more</a>
                    </div>
                </div>
                <div class="article-container2" v-for="(article, index) in article2" :key="index">
                    <div class="article-box">
                        <h2>{{ article.title }}</h2>
                        <p>{{ article.description }}</p>
                        <a :href="article.link" target="_blank">Read more</a>
                    </div>
                </div>
                <div class="article-container3" v-for="(article, index) in article3" :key="index">
                    <div class="article-box">
                        <h2>{{ article.title }}</h2>
                        <p>{{ article.description }}</p>
                        <a :href="article.link" target="_blank">Read more</a>
                    </div>
                </div>
                <div class="article-container4" v-for="(article, index) in article4" :key="index">
                    <div class="article-box">
                        <h2>{{ article.title }}</h2>
                        <p>{{ article.description }}</p>
                        <a :href="article.link" target="_blank">Read more</a>
                    </div>
                </div>
            </div>    
            <!-- Archive Section -->
            <div class="archive-container">
                <div class="archive">
                    <h2>Archive</h2>
                    <ul>
                        <li v-for="(month, index) in archive" :key="index">{{ month }}</li>
                    </ul>
                </div>
>>>>>>> a46a402e5ef39d077e1bcee6b35f4a2dcfef90b9
            </div>
        </div>
        <div class="article-container2" v-for="(article, index) in article2" :key="index">
            <div class="article-box">
                <h2>{{ article.title }}</h2>
                <p>{{ article.description }}</p>
                <a :href="article.link" target="_blank">Read more</a>
            </div>
        </div>
        <div class="article-container3" v-for="(article, index) in article3" :key="index">
            <div class="article-box">
                <h2>{{ article.title }}</h2>
                <p>{{ article.description }}</p>
                <a :href="article.link" target="_blank">Read more</a>
            </div>
        </div>
        <div class="article-container4" v-for="(article, index) in article4" :key="index">
            <div class="article-box">
                <h2>{{ article.title }}</h2>
                <p>{{ article.description }}</p>
                <a :href="article.link" target="_blank">Read more</a>
            </div>
        </div>
    </div>
    </div>
        <!-- Archive Section -->
    <div class="archive-container">
        <div class="archive">
            <h2>Archive</h2>
            <ul>
                <li v-for="(month, index) in archive" :key="index">{{ month }}</li>
            </ul>
        </div>
    </div>
    <Footer class="footer"></Footer>
    </div>
</template>

<script>
import Footer from '../components/Footer.vue';
import Header from '../components/Header.vue';
import NavBar from '../components/NavBar.vue';

export default {
    components: { Header, NavBar, Footer },
    name: "ArticlesView",
    data() {
    return {
        article1: [
            {
            title: 'Article 1',
            description: 'Description of article 1',
            link: 'https://example.com/article1'
            },
        ],
        article2: [
            {
            title: 'Article 1',
            description: 'Description of article 1',
            link: 'https://example.com/article1'
            },
        ],
        article3: [
            {
            title: 'Article 1',
            description: 'Description of article 1',
            link: 'https://example.com/article1'
            },
        ],
        article4: [
            {
            title: 'Article 1',
            description: 'Description of article 1',
            link: 'https://example.com/article1'
            },
        ],
        archive: ['January 2024', 'February 2024', 'March 2024'] // Sample archive data
        };
    },
    methods: {
        search() {
        // Implement search functionality here
        }
    }
};
</script>

<style scoped>
<<<<<<< HEAD
.container {
    position: relative;
    background-color: #ccc;
=======
.articles-view {
    /* position: relative;
    background-color: #ccc; */
    width: 100vw;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;
     margin-top: -1vw;
>>>>>>> a46a402e5ef39d077e1bcee6b35f4a2dcfef90b9
}

.header {
    position: fixed;
    top: 0;
    width: 100%;
    height:60px;
    z-index: 1000;
}

.nav-bar {
    position: fixed;
    top: 60px;
    width: 100%;
    height:30px;
    z-index: 1000;
}

.footer {
    position: fixed;
    bottom: 0;
    width: 100%;
    z-index: 1000;
}

.main-content {
    padding-top: 100px;
    padding-bottom: 50px;
    border: 5px solid #007bff;
    border-radius: 20%;
}

.search-bar {
    margin-bottom: 20px;
    display: flex;
    justify-content: flex-end;
    border: 5px solid #00ff37;
    border-radius: 20%;
    margin-left: 80%;
}

.articles {
    display: flex;
    width: 70%;
    flex-wrap: wrap;
    border: 5px solid #ff0022;
    height: 90vh;
    border-radius: 20%;
}

  .articles > * {       /*Why??*/
    flex: 1 1 33%;
    flex-wrap: wrap; 
}

.article-container1 {
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 40vh;
    width: 25%;
    border: 5px solid;
    border-radius: 20%;
}
.article-container2 {
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 40vh;
    width: 25%;
    border: 5px solid;
    border-radius: 20%;
}
.article-container3 {
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 40vh;
    width: 25%;
    border: 5px solid;
    border-radius: 20%;
}
.article-container4 {
    display: flex;
    flex-direction: row;
    align-items: center;
    height: 40vh;
    width: 25%;
    border: 5px solid;
    border-radius: 20%;
}

.article-box {
    margin-bottom: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    background-color: #00ccff;
    border-radius: 8px;
}

.archive-container {
<<<<<<< HEAD
    position: absolute;
    top: 20%;
    right: 0;
=======
    /* padding-top: 100px; */
    display: flex;
    /* position: absolute; */
    /* top: 20%;                             /*Utilize Flex to position archive instead of absolute, top, right
    right: 0; */
>>>>>>> a46a402e5ef39d077e1bcee6b35f4a2dcfef90b9
    height: 75vh;
    width: 25%;
    padding: 0 10px;
    border: 5px solid #f705a6;
    border-radius: 20%;
}

.archive {
    display: flex;
    flex-direction: column;
    border: 5px solid #f705a6;
    border-radius: 20%;
    padding: 20px;
    justify-content: flex-end;
}

.article-box h2 {
    margin-bottom: 10px;
    border: 5px solid #f705a6;
    border-radius: 20%;
}

.article-box p {
    margin-bottom: 15px;
    border: 5px solid #f705a6;
    border-radius: 20%;
}

.article-box a {
    color: #007bff;
    text-decoration: none;
    border: 5px solid #f705a6;
    border-radius: 20%;
}
</style>
