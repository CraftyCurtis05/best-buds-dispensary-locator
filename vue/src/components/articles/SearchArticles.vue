<!-- Search Articles Component Display -->
<template>

    <!-- Display Component Body -->
     
    <body id="search-body">

        <!-- Display Search Bar that Takes in User Input as 'keyword' and Runs the searchArticles Function in Real-Time-->
        <section id="search-bar">
            <input id="user-input" name="user-input" type="text" v-model="keyword" placeholder="Enter Search Keyword"/>
        </section>

        <!-- Display Error Message If Articles Array Is Empty After Keyword Search -->
        <div id="error">{{ this.error }}</div>

        <!-- Display Results List from Array of Objects Created in searchArticles Function -->
        <section id="search-list">

            <!-- Loop Through Results Array and Bind Each Result Object By It's Title For Loop Function -->
            <article id="results" v-for="result in searchArticles(keyword)" :key="result.title">

                <!-- Display Result Image and Bind to Result URL -->
                <a v-bind:href="result.url" target="_blank">
                    <img :src="(`src/assets/articles/${result.image}`)"/>
                </a>

                <!-- Display Result Title, Author, Date and Description -->
                <h3>{{ result.title }}</h3>
                <h4>{{ result.author }}</h4>
                <h5>{{ result.date }}</h5>
                <h6>{{ result.description }}</h6>

            </article>
            
        </section>

    </body>

</template>

<script>
import Articles from "../../assets/articles/articles.js";

export default {
  name: "SearchArticles",

  data() {
    return {
      articles: Articles,
      keyword: '',
      results: [],
      error: ''
    }
  },

  methods: {

    searchArticles(keyword) {

      // Resets Error Message
      this.error = "";

      // User Input/Keyword is Converted to Lower Case and Whitespace is Removed
      keyword = keyword.toLowerCase().trim();

      // Variable Initialized Containing an Empty Array to Store Matched Results
      let results = [];

      // Loop Through Articles Array = article object [{}]
      this.articles.forEach((article) => {

        // Loop Through Article Object = article key [{key:}]
        Object.keys(article).forEach((key) => {

          // Loop Through Value String and Search for Keyword
          if(article[key].includes(keyword)) {   

            // Checks if Results Array Does Not Already Contain Article 
            if(!results.includes(article)) {

              // If Article Contains Keyword, Add Article Object to Results Array         
              results.push(article);
            }
          }
        })
      })

      // Checks and Verifies if Results Array is Empty and Sets Error Message Variable If It Is
      if(results.length === 0) {

        results = [];
        this.error = "No articles match. Please try again.";
        return results;
      }

      return results;
    }
  }
};
</script>

<style scoped>

</style>