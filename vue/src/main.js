import { createApp } from "vue";
import axios from "axios";

import BestBudsApp from "./BestBudsApp.vue";
import router from "./router";
import { createStore } from "./store";

// Restore the saved user session
const savedToken = localStorage.getItem("token");
const savedUser = localStorage.getItem("user");

let currentToken = "";
let currentUser = {};

if (savedToken && savedUser) {
  try {
    currentUser = JSON.parse(savedUser);
    currentToken = savedToken;

    axios.defaults.headers.common["Authorization"] =
            `Bearer ${currentToken}`;
  } catch {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
  }
} else {
  localStorage.removeItem("token");
  localStorage.removeItem("user");
}

// Create the application
const store = createStore(currentToken, currentUser);
const app = createApp(BestBudsApp);

app.use(store);
app.use(router);

app.mount("#app");
