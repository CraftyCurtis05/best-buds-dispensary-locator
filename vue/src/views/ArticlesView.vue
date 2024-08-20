<!-- Articles Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Articles | Best Buds</title>
  
    <header>
      <!-- Display Header Component -->
      <Header/>
    </header>

    <body class="articles-view">
        <!-- Display main article content -->
        <div class="main-content">

            <!-- Articles search bar -->
            <div class="search-bar">
                <input type="text" v-model="searchQuery" placeholder="Search articles" />
                <button @click="search">Search</button>
            </div>
            
            <!-- Article Boxes -->
            <div class="articles">
                <div class="article-container" v-for="(article, index) in filteredArticles" :key="index">
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

        <!-- Display Quote Component -->
        <div id="quote">
            <QuoteComponent/>
        </div> 

    </body>

    <footer>
        <!-- Display Footer Component -->
        <Footer />
    </footer> 

</template>

<script>
import axios from 'axios';
import Footer from '@/components/Footer.vue';
import Header from '@/components/Header.vue';
import QuoteComponent from '@/components/Quote.vue';

export default {
    name: "Articles",
    components: { Header, QuoteComponent, Footer },
    
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
.articles-view {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

.main-content {
padding-top: 100px;
padding-bottom: 50px;
/* border: 5px solid #007bff;
border-radius: 20%; */
}

.search-bar {
margin-bottom: 20px;
display: flex;
justify-content: flex-end;
/* border: 5px solid #00ff37;
border-radius: 20%; */
margin-left: 80%;
}

.articles {
display: flex;
flex-wrap: wrap;
width: 70%;
height: 90vh;
/* border: 5px solid #ff0022;
border-radius: 20%; */
}

.articles > * {
flex: 1 1 45%;
flex-wrap: wrap;
}

.article-container {
display: flex;
flex-direction: row;
align-items: center;
height: 40vh;
width: 30%;
/* border: 5px solid; */
border-radius: 20%;
}

.article-box {
margin-bottom: 20px;
padding: 20px;
/* border: 1px solid #ccc;
background-color: #00ccff; */
border-radius: 8px;
}

.archive-container {
position: absolute;
top: 20%;
right: 0;
height: 75vh;
width: 25%;
/* padding: 0 10px;
border: 5px solid #f705a6; */
border-radius: 20%;
}

.archive {
display: flex;
flex-direction: column;
/* border: 5px solid #f705a6;
border-radius: 20%; */
padding: 20px;
justify-content: flex-end;
}

/* .article-box h2 {
margin-bottom: 10px;
border: 5px solid #f705a6;
border-radius: 20%;
} */

/* .article-box p {
margin-bottom: 15px;
border: 5px solid #f705a6;
border-radius: 20%;
} */

/* .article-box a {
color: #007bff;
text-decoration: none;
border: 5px solid #f705a6;
border-radius: 20%;
} */

h6 {
    text-align: center;
    font-size: .9em;
    font-style: italic;
    font-weight: lighter;
    margin-bottom: 1em;
}
</style>
