<!-- TESTING LINK - REMOVE BEFORE RELEASE-->
<template>
  <header>

  </header>
  <body>

    <!-- Search bar that takes in user input as keyword and runs the searchArticles function when button is pressed -->
    <div class="search-bar">
      <input id="user-input" name="user-input" type="text" v-model="keyword" placeholder="Enter Search Keyword"/>
      <button id="search-button" v-on:click="searchArticles()">Search</button>
    </div>

    <!-- Display JSON result objects from search keyword -->
    <ul class="list">
      <li v-for="article in articlesArray" :key="article.title">
        <span>{{  article.title  }}</span>
      </li>
    </ul>

  </body>
  <footer>

  </footer>
</template>

<script>
// Importing array from local JSON file
import articles from "../assets/articles.js";

export default {
  name: "TestView",

  data() {
    return {
      keyword: '',
      articlesArray: []
    }
  },

  methods: {

    searchArticles(keyword) {

      // Initialize an empty array to store objects that contain keyword
      let articlesArray = [];
      let articlesObj = articles;

      // console.log(articlesObj); // FOR TESTING - DELETE WHEN DONE

      Object.entries(articlesObj).forEach(([key, value]) => {
        console.log(key, value); // This works!!!
        console.log(value.title); // This 
      })

      //console.log(articlesArray); // FOR TESTING - DELETE WHEN DONE

      return articlesArray;
    }  
  }
};
</script>

<style scoped>
.search-bar {
  display: flex;
  align-items: center;
  background-color: black;
  padding: .45%;
  max-width: 800px;
  margin: 0 auto;
}

#user-input {
  flex: 1;
  padding: 10px;
}

#search-button {
  border-radius: 5px;
  padding: 10px 20px;
  margin-left: 10px;
  cursor: pointer;
}

.list {
  margin: auto;
}
</style>