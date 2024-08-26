<!-- Search Articles Component Display -->
<template>

    <!-- Display Component Body -->
    <body>

        <!-- Display Search Bar that Takes in User Input as 'keyword' and Runs the searchArticles Function in Real-Time-->
        <section id="search-bar">
            <input id="user-input" name="user-input" type="text" v-model="keyword" placeholder="Enter Search Keyword"/>
        </section>

        <div id="error" v-if="results.length === 0">{{ this.error }}</div>

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
  name: "SearchArticlesComponent",

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

      this.error = "";

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

      if(results.length === 0) { // Checks and verifies results array is empty and sets error message variable

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