<!-- TESTING LINK - REMOVE BEFORE RELEASE-->
<template>
  <head>

  </head>
  <body>

  </body>
  <footer>

  </footer>
</template>

<script>
import articles from '../services/ArticlesObject.js';

export default {
  name: "TestView",
  
  methods: {
    getArticles(keyword) {
      for(let i = 0; i < articles.length; i++) {
        if(keyword === articles.keyword) {
          return articles.name;
        }
      }
    }
  }
};
</script>

<style scoped>
</style>