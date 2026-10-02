import { createApp } from "vue";
import axios from "axios";

import BestBudsApp from "./BestBudsApp.vue";
import { createRouter } from "./router";
import { createStore } from "./store";

import "./assets/layout/styles/global.css";
import "./assets/layout/styles/products.css";
import "./assets/layout/styles/questions.css";
import "./assets/layout/styles/safety.css";
import "./assets/layout/styles/too-much.css";
import "./assets/layout/styles/strain-guide.css";
import "./assets/layout/styles/account.css";
import "./assets/layout/styles/auth.css";

// Restore the saved user session
const savedToken = localStorage.getItem("token");
const savedUser = localStorage.getItem("user");

let currentToken = "";
let currentUser = {};

if (savedToken && savedUser) {
    try {
        currentUser = JSON.parse(savedUser);
        currentToken = savedToken;

        axios.defaults.headers.common[
            "Authorization"
        ] = `Bearer ${currentToken}`;
    } catch {
        localStorage.removeItem("token");
        localStorage.removeItem("user");
    }
} else {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
}

// Create the application
const store = createStore(
    currentToken,
    currentUser
);

const router = createRouter(store);
const app = createApp(BestBudsApp);

app.use(store);
app.use(router);

app.mount("#app");