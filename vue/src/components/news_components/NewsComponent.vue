<template>
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
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: "NewsComponent",
    props: {
      articles: {
        type: Array,
        required: true,
      },
    },
    data() {
      return {
        searchQuery: '',
        fetchedArticles: [],  // To store articles fetched from the API
      };
    },
    computed: {
      filteredArticles() {
        return this.fetchedArticles.filter(article =>
          article.title.toLowerCase().includes(this.searchQuery.toLowerCase())
        );
      },
    },
    methods: {
      async fetchArticles() {
        try {
          const response = await axios.get('https://api.thenewsapi.com/v1/news/all', {
            params: {
              title: this.searchQuery,
              api_token: 'WYKYp9K37PkhTQosYnP2jrsOh5687P8bkV2IHdGQ',
              language: 'en',
              limit: 3,
              published_after: '2024-01-01'
            }
          });
          this.fetchedArticles = response.data.data;
        } catch (error) {
          console.error('Error fetching articles:', error);
        }
      },
      search() {
        this.fetchArticles();
      }
    },
    mounted() {
      this.fetchArticles();
    },
  };
  </script>
  
<style scoped>
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
  