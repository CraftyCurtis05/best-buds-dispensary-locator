<!-- News View Display --->
<template>

    <!-- Browser Tab Title -->
    <title>News | Best Buds</title>
  
    <!-- Display Header Component -->
    <header id="top">
      <Header/>
    </header>

    <!-- Display View Body -->
    <body id="news-body">

        <!-- Display Body's Main Content -->
        <main id="news-main">

            <!-- Display Body Title -->
            <h1>Cannabis News</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
             <section id="summary">
                <h2>🌿***NEED ATTENTION GRABBER***🌿</h2>
                <p>***NEED PAGE SUMMARY***</p>
                <h3>***WHATS EXPECTED OF PAGE***</h3>
            </section>

            <!-- Display News Information -->
            <section id="news">
                
                <!-- Display News Search Bar -->
                <article id="search-bar">
                    <input type="text" v-model="searchQuery" placeholder="Search news articles" />
                    <button @click="search">Search</button>
                </article>
                
                <!-- Display News Article Objects -->
                <article id="article-object">
                    <div id="article-container" v-for="(article, index) in filteredArticles" :key="index">
                        <div id="article-box">
                            <h2>{{ article.title }}</h2>
                            <p>{{ article.description }}</p>
                            <a :href="article.link" target="_blank">Read more</a>
                        </div>
                    </div>
                </article>

            </section>

        </main>

        <!-- Display Quote Component -->
        <div id="quote">
            <Quote/>
        </div>  

    </body>

    <!-- Display Footer Component -->
    <footer id="bottom">
        <Footer/>
    </footer> 

</template>

<script>
import axios from 'axios';
import Header from '@/components/Header.vue';
import ViewJumpLinks from '@/components/ViewJumpLinks.vue';
import Search from '@/assets/news_assets/search.js';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "News",
    components: { 
        Header,
        ViewJumpLinks,
        Quote, 
        Footer 
    },
    
    data() {
        return {
            searchQuery: '',
            search: Search,
            newsSearch: '',
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
                }
            ]
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
        randomSearch() {
            const random = Math.floor(Math.random() * this.search.length);
            this.newsSearch = this.search[random];
            console.log(this.newsSearch);
        },
        async fetchArticles() {
            try {
                // const date = new Date.getFullYear('July 20, 23 00:20:18');
                const response = await axios.get('https://api.thenewsapi.com/v1/news/all', {
                params: {
                    title: this.newsSearch,
                    api_token: 'WYKYp9K37PkhTQosYnP2jrsOh5687P8bkV2IHdGQ',
                    language: 'en',
                    limit:  3,
                    published_after: '2024-01-01'
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
    },
    created() {
        this.randomSearch();
    }
};
</script>

<style scoped>
#news-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#news-main {
    margin: 4vw;
}

h1,
#summary {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}

#search-bar {
margin-bottom: 20px;
display: flex;
justify-content: flex-end;
/* border: 5px solid #00ff37;
border-radius: 20%; */
margin-right: 5%;
}

#article-object {
display: flex;
flex-wrap: wrap;
width: 70%;
height: 90vh;
/* border: 5px solid #ff0022;
border-radius: 20%; */
}

#article-object > * {
flex: 1 1 45%;
flex-wrap: wrap;
}

#article-container {
display: flex;
flex-direction: row;
align-items: center;
height: 40vh;
width: 30%;
/* border: 5px solid; */
border-radius: 20%;
}

#article-box {
margin-bottom: 20px;
padding: 20px;
/* border: 1px solid #ccc;
background-color: #00ccff; */
border-radius: 8px;
}
</style>
