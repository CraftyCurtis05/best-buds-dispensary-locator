<!-- TESTING LINK - REMOVE BEFORE RELEASE-->
<template>

  <header>
    <Header/>
  </header>

  <body>
    <!-- Search bar that takes in user input as keyword and runs the searchArticles function when button is pressed -->
    <div class="search-bar">
      <input id="user-input" name="user-input" type="text" v-model="keyword" placeholder="Enter Search Keyword"/>
    </div>

    <!-- Display JSON result objects from search keyword --> 
    <div class="search-list">
      <div class="results" v-for="result in searchArticles(keyword)" :key="result.title">
        <a v-bind:href="result.url" target="_blank"> <!-- Bind result url to result image -->
          <img :src="(`src/assets/article_assets/${result.image}`)"/> <!-- Display result image -->
        </a>
        <h3>{{  result.title  }}</h3>     <!-- Display result title -->
        <h4>{{ result.author }}</h4>      <!-- Display result author -->
        <h5>{{ result.date }}</h5>        <!-- Display result date -->
        <h6>{{ result.description }}</h6> <!-- Display result description -->
      </div>
    </div>
  </body>

  <footer>
    <Footer/>
  </footer>

</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import Articles from "@/assets/article_assets/articles.js";

export default {
  name: "Test",
  components: { Header, Footer },

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
        results = []; // Verify that array is empty of proxy objects
        console.log("No articles match. Please try again.") // FOR TESTING - DELETE WHEN FUNCTION WORKS
        return results; // *** NEED TO FIGURE OUT HOW TO DISPLAY MESSAGE ON PAGE WHEN NO RESULTS *** <<<<<<<<<<
        
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
  margin: 40px auto;
}

#user-input {
  flex: 1;
  padding: 10px;
}

.search-list {
  display: flex;
  flex-wrap: wrap;
}

.results {
  border: .3em solid black;
  width: 14em;
  height: 20em;
  text-align: center; 
  margin: auto;
  margin-bottom: 15px;
  padding: .5em;
}

img {
  width: 9em;
  height: 7em;
}

h3 {
  font-size: .95em;
  font-weight: bolder;
  margin: .2em;
}

h4 {
  font-size: .75em;
  font-weight: bold;
  margin: .5em;
}

h5 {
  font-size: .60em;
  font-style: italic;
  margin: .5em;
}

h6 {
  font-size: .73em;
  font-weight: lighter;
}
</style>