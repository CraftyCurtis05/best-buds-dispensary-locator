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
                    <img :src="(`src/assets/article_assets/${result.image}`)"/>
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
import Articles from "@/assets/article_assets/articles.js";

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
/* OBJECTS = rem */
/* SPACING = vw */
#search-bar {
  display: flex;
  align-items: center;
  background-color: black;
  padding: .25%;
  max-width: 800px;
  margin: 40px auto;
}

#user-input {
  flex: 1;
  padding: 10px;
}

#search-list {
  display: flex;
  flex-wrap: wrap;
}

#results {
  border: .2rem solid black;
  width: 14em;
  height: 20em;
  text-align: center; 
  margin: auto;
  margin-bottom: 15px;
  padding: .5em;
  cursor: url('best_buds_logo_icon.ico'), pointer;
}

#results:hover {
 transform: scale(1.1);

}

img {
  width: 9em;
  height: 7em;
  cursor: url('best_buds_logo_icon.ico'), pointer;
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