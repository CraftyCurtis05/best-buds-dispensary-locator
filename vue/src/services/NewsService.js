import axios from "axios";

export default {

  // Get the latest cannabis news
  getNews() {
    return axios.get("/api/news");
  },

  // Search cannabis news
  searchNews(query) {
    return axios.get(
      "/api/news/search",
      {
        params: {
          query: query
        }
      }
    );
  }

};