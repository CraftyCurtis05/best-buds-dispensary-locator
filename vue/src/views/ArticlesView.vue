<template>
    <div class="container">
        <div class="header-nav">
        <div class="header"><Header/></div>
        <div class="nav-bar"><NavBar/></div>
    </div> 
        <div class="main-content">
        <!-- Search Bar -->
        <div class="search-bar">
            <input type="text" placeholder="Search articles">
            <button @click="search">Search</button>
        </div>

        <!-- Article Boxes -->
        <div class="article-container" v-for="(article, index) in articles" :key="index">
            <div class="article-box">
                <h2>{{ article.title }}</h2>
                <p>{{ article.description }}</p>
                <a :href="article.link" target="_blank">Read more</a>
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
        articles: [
            {
            title: 'Article 1',
            description: 'Description of article 1',
            link: 'https://example.com/article1'
            },
            {
            title: 'Article 2',
            description: 'Description of article 2',
            link: 'https://example.com/article2'
            },
            {
            title: 'Article 3',
            description: 'Description of article 3',
            link: 'https://example.com/article3'
            },
            {
            title: 'Article 4',
            description: 'Description of article 4',
            link: 'https://example.com/article4'
            }
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

/* .container {
    display: block;
} */

.header-nav {
    position: static;
}

/* .main-content {
    flex: 1;
    display: flex;
    flex-wrap: wrap;
    border: 5px solid #007bff;
    border-radius: 20%;
} */

.search-bar {
    margin-bottom: 20px;
    display: flex;
    justify-content: flex-end;
    border: 5px solid #007bff;
    border-radius: 20%;
}

.article-container {
    width: 30%;
    padding: 0 10px;
    border: 5px solid #007bff;
    border-radius: 20%;
}

.article-box {
    margin-bottom: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
}

.archive-container {
    width: 25%;
    padding: 0 10px;
    border: 5px solid #f705a6;
    border-radius: 20%;
}

.archive {
    display: flex;
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 20px;
    justify-content: flex-end;
}

.article-box h2 {
    margin-bottom: 10px;
}

.article-box p {
    margin-bottom: 15px;
}

.article-box a {
    color: #007bff;
    text-decoration: none;
}
</style>
