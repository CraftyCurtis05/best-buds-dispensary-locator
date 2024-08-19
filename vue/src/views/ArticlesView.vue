<!-- Articles Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Articles | Best Buds</title>

    <!-- Display Header Component -->
    <header>
      <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="articles-body">

        <!-- Display Articles Main Content -->
        <main id="articles-main">

            <!-- Display Page Title -->
            <h1>***NEEDS PAGE TITLE***</h1>

            <!-- Display Articles Information -->
            <section id="articles">
                <h2>***NEEDS PAGE HEADLINER***</h2>
                    <p>***NEEDS PAGE SUMMARY***</p>

                <!-- Display Articles Search Bar -->
                <article id="search-bar">
                    <input type="text" v-model="searchQuery" placeholder="Search articles"/>
                    <button @click="search">Search</button>
                </article>

                <!-- Display Article Result Objects -->
                <article id="articles-object" v-for="(article, index) in filteredArticles" :key="index">
                    <h3>{{ article.title }}</h3>
                    <h4>{{ article.description }}</h4>
                    <nav>
                        <a :href="article.link" target="_blank">Read more</a>
                    </nav>
                </article>

            </section>

            <!-- Display Archives information -->
            <section id="archive">
                <h5>Archive</h5>
                    <ul>
                        <li v-for="(month, index) in archive" :key="index">{{ month }}</li>
                    </ul>
            </section>

        </main>

        <!-- Display Page Quote -->
        <h6>***NEED QUOTE***</h6>

    </body>

    <!-- Display Footer Component -->
    <footer>
        <Footer/>
    </footer> 

</template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
import axios from 'axios';

export default {
    name: 'articles',
    components: { Header, Footer },
    
    data() {
        return {
            searchQuery: '',
            articles: [
                {
                    title: 'Article 1',
                    description: 'Description of article 1',
                    link: 'https://example.com/article1',
                },
                {
                    title: 'Article 2',
                    description: 'Description of article 2',
                    link: 'https://example.com/article2',
                },
                {
                    title: 'Article 3',
                    description: 'Description of article 3',
                    link: 'https://example.com/article3',
                },
                {
                    title: 'Article 4',
                    description: 'Description of article 4',
                    link: 'https://example.com/article4',
                }
            ],
            archive: ['January 2024', 'February 2024', 'March 2024'], // Sample archive data
        }
    },
    computed: {
        filteredArticles: function() {
            return this.articles.filter(article =>
            article.title.toLowerCase().includes(this.searchQuery.toLowerCase())
            );
        }
    },
    methods: {
        async fetchArticles() {
            try {
            const response = await axios.get('https://api.thenewsapi.com/v1/news/all', {
                params: {
                    categories: 'marijuana',
                    api_token: 'WYKYp9K37PkhTQosYnP2jrsOh5687P8bkV2IHdGQ',
                    language: 'en',
                    limit: 4  
                },
                paramsSerializer: params => {
                    return new URLSearchParams(params).toString();
                }
            });
            console.log('API Response:', response);
            this.articles = response.data.data; // Ensure you're accessing the correct part of the response
            } catch (error) {
                console.error('Error fetching articles:', error);
            }      
        }
    },
    mounted() {
        this.fetchArticles();
    }
};
</script>

<style scoped>
#articles-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

h6 {
    text-align: center;
    font-size: .9em;
    font-style: italic;
    font-weight: lighter;
    margin-bottom: 1em;
}
</style>
