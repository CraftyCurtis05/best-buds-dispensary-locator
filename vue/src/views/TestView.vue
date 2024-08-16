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
    <div class="search-list">
      <div v-for="result in searchArticles(keyword)" :key="result.title">
        <a v-bind:href="result.url" target="_blank"><img src="result.image"/></a> <!-- Display result image and bind url to image ***NOT WORKING???** -->
        <h3>{{  result.title  }}</h3>     <!-- Display result title -->
        <h4>{{ result.author }}</h4>      <!-- Display result author -->
        <h5>{{ result.date }}</h5>        <!-- Display result date -->
        <h6>{{ result.description }}</h6> <!-- Display result description -->
      </div>
    </div>

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
      keyword: '',
      results: []
    }
  },

  methods: {

    searchArticles(keyword) {

      keyword = keyword.toLowerCase().trim(); // User input/keyword is converted to lower case and whitespace is trimmed off both sides

      let results = []; // Variable initialized containing an empty array to store matched results

      this.articles.forEach((article) => { // Loop through the articles array = article object [{}]

        Object.keys(article).forEach((key) => { // Loop through article object = article key [{key:}]

          if(article[key].includes(keyword)) { // Loop through value string and search for keyword   
            
            if(!results.includes(article)) { // Checks if results array does not already contain article             
              results.push(article); // If article contains keyword, add article object to results array
            }
          }
        })
      })
      if(results.length === 0) { // Checks results array to verify it is not empty
        console.log("No articles match. Please try again.") // FOR TESTING - DELETE WHEN FUNCTION WORKS
        results.push("No articles match. Please try again.");  // *** NEED TO FIGURE OUT HOW TO DISPLAY ON PAGE WHEN NO RESULTS ***
      }
      console.log(results); // FOR TESTING - DELETE WHEN FUNCTION WORKS
      return results; //
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