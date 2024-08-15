<!-- TESTING LINK - REMOVE BEFORE RELEASE-->
<template>
  <header>

  </header>
  <body>

    <!-- Search bar that takes in user input as keyword and runs the searchArticles function when button is pressed -->
    <div class="search-bar">
      <input id="user-input" name="user-input" type="text" v-model="keyword" placeholder="Enter Search Keyword"/>
      <button id="search-button" v-on:click="searchArticles(keyword)">Search</button>
    </div>

    <!-- Display JSON result objects from search keyword -->
    <ul class="list">
      <li v-for="result in results" :key="result.name">
        <span>{{  result.name  }}</span>
        <span>{{ result.author }}</span>
        <span>{{ result.date }}</span>
        <span>{{ result.description }}</span>
        <img src="result.image" />
      </li>
    </ul>

  </body>
  <footer>

  </footer>
</template>

<script>
// Importing array from local JSON file
import articles from "../assets/articles.json";

export default {
  name: "TestView",

  data() {
    return {
      keyword: '',
      results: []
    }
  },

  methods: {

    searchArticles(keyword) {

      // Initialize an empty array to store objects that contain keyword
      let results = [];

      // Loop through articles objects
      for(let i = 0; i < articles.length; i++) {

        // Loop through articles objects properties
        for(let j = 0; j < articles[i].length; j++) {

          // If articles objects property contains keyowrd then add articles object to results array
          if(articles[i][j].includes(keyword.toLowerCase())) {
          results.push(articles[i]);
          } 
        }
      }

      // If results array is empty return nothing else return results array
      if(results.length === 0) {
        return '';
      } else {
        console.log(results); // For testing in dev tools - delete when working
        return results;
      }
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