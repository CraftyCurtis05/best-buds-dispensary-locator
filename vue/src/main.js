import { createApp } from "vue";
import axios from "axios";

import BestBudsApp from "./BestBudsApp.vue";
import router from "./router";
import { createStore } from "./store";

// Restore the saved user session
const currentToken = localStorage.getItem("token");
const savedUser = localStorage.getItem("user");

let currentUser = {};

if (savedUser) {
  try {
    currentUser = JSON.parse(savedUser);
  } catch {
    localStorage.removeItem("user");
  }
}

if (currentToken) {
  axios.defaults.headers.common["Authorization"] =
          `Bearer ${currentToken}`;
}

// Create the application
const store = createStore(currentToken, currentUser);
const app = createApp(BestBudsApp);

app.use(store);
app.use(router);

app.mount("#app");
