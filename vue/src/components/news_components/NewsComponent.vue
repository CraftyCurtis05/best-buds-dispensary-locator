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
          <p><strong>Published on:</strong> {{ new Date(news.published_at).toLocaleDateString() }}</p>
          <img :src="news.image_url" alt="News Image" v-if="news.image_url" />
          <a :href="news.url" target="_blank">Read more</a>
        </div>

      </div>

    </article>

  </section>

</template>


<script>
import axios from 'axios';

export default {
  name: "NewsComponent",
  data() {
    return {
      searchQuery: '',
      fetchedNews: [], // Array to store fetched news
    };
  },
  computed: {
    filteredNews() {
      return this.fetchedNews.filter(news =>
        news.title.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    },
  },
  methods: {
    async fetchNews() {
      try {
        const response = await axios.get('https://api.thenewsapi.com/v1/news/all', {
          params: {
            search: 'cannabis',
            api_token: 'WYKYp9K37PkhTQosYnP2jrsOh5687P8bkV2IHdGQ',
            language: 'en',
            limit: 3,
            published_after: '2024-01-01'
          }
        });
        console.log('API Response:', response.data); // Log API response
        this.fetchedNews = response.data.data; // Set fetched news
      } catch (error) {
        console.error('Error fetching news:', error); // Log any errors
      }
    },
    search() {
      this.fetchNews();
    },
  },
  mounted() {
    this.fetchNews();
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

#news-object {
display: flex;
flex-wrap: wrap;
width: 70%;
height: 90vh;
/* border: 5px solid #ff0022;
border-radius: 20%; */
}

#news-object > * {
flex: 1 1 45%;
flex-wrap: wrap;
}

#news-container {
display: flex;
flex-direction: row;
align-items: center;
height: 40vh;
width: 30%;
/* border: 5px solid; */
border-radius: 20%;
}

#news-box {
margin-bottom: 20px;
padding: 20px;
/* border: 1px solid #ccc;
background-color: #00ccff; */
border-radius: 8px;
}
</style>
