
<template>

    <!-- Display Component Body -->
    <body>

        <!-- Display Search Bar that Takes in User Input as 'keyword' and Runs the searchArticles Function in Real-Time-->
        <section id="search-bar">
            <input id="user-input" name="user-input" type="text" v-model="keyword" placeholder="Enter Search Keyword"/>
        </section>

        <!-- Display Results List from Array of Objects Created in searchArticles Function --> 
        <section id="search-list">

            <!-- Loop Through Results Array and Bind Each  -->
            <article id="results" v-for="result in searchArticles(keyword)" :key="result.title">
                <a v-bind:href="result.url" target="_blank"> <!-- Bind result url to result image -->
                    <img :src="(`src/assets/article_assets/${result.image}`)"/> <!-- Display result image -->
                </a>
                <h3>{{  result.title  }}</h3>     <!-- Display result title -->
                <h4>{{ result.author }}</h4>      <!-- Display result author -->
                <h5>{{ result.date }}</h5>        <!-- Display result date -->
                <h6>{{ result.description }}</h6> <!-- Display result description -->
            </article>
        </section>

    </body>

</template>

<script>

</script>

<style scoped>
#search-bar {
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

#search-list {
  display: flex;
  flex-wrap: wrap;
}

#results {
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