<template>

  <section id="news">

    <!-- Display News Search Bar -->
    <article id="search-bar">
      <input type="text" v-model="searchQuery" placeholder="Search news" />
      <button @click="search">Search</button>
    </article>

    <!-- Display News Objects -->
    <article id="news-object">

      <div id="news-container" v-for="(news, index) in filteredNews" :key="index">

        <div id="news-box">
          <h2>{{ news.title }}</h2>
          <p>{{ news.description }}</p>
          <p><strong>Published on:</strong>{{ new Date(news.published_at).toLocaleDateString() }}</p>
          <img :src="news.image_url" alt="news-image" v-if="news.image_url" />
          <a :href="news.url" target="_blank">Read more</a>
        </div>

      </div>

    </article>

  </section>

</template>


<script>
import axios from 'axios';

export default {
  name: "News",
  data() {
    return {
      
      // Variable for user input for filteredNews()
      searchQuery: '',

      // Array to store fetched news
      fetchedNews: []
    };
  },
  computed: {

    // User input is used to filter the news search
    filteredNews() {
      return this.fetchedNews.filter(news =>
        news.title.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    },
  },
  methods: {

    // Make API to TheNewsAPI using specified search parameters
    async fetchNews() {
      try {
        const response = await axios.get('https://api.thenewsapi.com/v1/news/all', {
          params: {
            api_token: 'WYKYp9K37PkhTQosYnP2jrsOh5687P8bkV2IHdGQ',
            search: 'cannabis',
            language: 'en',
            limit: 3,
            published_after: '2024-01-01'
          }
        });
        // Log API response
        console.log('API Response:', response.data);

        // Set fetched news to fetchedNews array
        this.fetchedNews = response.data.data;

      } catch (error) {
        console.error('Error fetching news:', error); // Log any errors
      }
    },
      search() {
      this.fetchNews();
    },
  },
  // Run fetchNews() right after web page is rendered
  mounted() {
    this.fetchNews();
  },
};
</script>


<style scoped>
#search-bar {
display: flex;
justify-content: flex-end;
margin-right: 5%;
margin-bottom: 20px;
}

#news-object {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

#news-box {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 35vw;
  height: 35vw;
  padding: 2vw;
  margin: 1vw;
  border: 1px solid #000000;
}

img {
  width: 30vw;
  height: 20vw;
}
</style>
