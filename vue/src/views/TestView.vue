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
      <!-- <li v-for="result in searchResults" :key="result.title">
        <span>{{  result.title  }}</span>
      </li> -->
    </ul>

  </body>
  <footer>

  </footer>
</template>

<script>
// Importing array from local JSON file
import Articles from "../assets/articles.js";

export default {
  name: "TestView",

  data() {
    return {
      articles: Articles,
      keyword: ''
    }
  },

  methods: {

    searchArticles(keyword) {

      let results = [];

      this.articles.forEach((article) => { // Loop through the articles array = article object [{}]

        Object.keys(article).forEach((key) => { // Loop through article object = article key [{key:}]

          console.log("key : " + key + " - value : " + article[key]); // ***FOR TESTING - DELETE WHEN FUNCTION WORKS

          // if(article[key].includes(keyword)) { // Loop through value string and search for keyword                      /* LEFT OFF HERE */
          //   results.push(article);             // If article contains keyword, add article object to results array
          // }
        })
      })
      //console.log(results);
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