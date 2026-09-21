import { createStore as createVuexStore } from "vuex";
import axios from "axios";

export function createStore(currentToken, currentUser) {

  return createVuexStore({

    state: {
      token: currentToken || "",
      user: currentUser || {},
      locationID: "",
      dispensaries: []
    },

    mutations: {

      // Store the user's authorization token
      SET_AUTH_TOKEN(state, token) {
        state.token = token;

        localStorage.setItem("token", token);

        axios.defaults.headers.common["Authorization"] =
                `Bearer ${token}`;
      },

      // Store the current user
      SET_USER(state, user) {
        state.user = user;

        localStorage.setItem(
          "user",
          JSON.stringify(user)
        );
      },

      // Store the current dispensary search location
      SET_LOCATION(state, locationID) {
        state.locationID = locationID;
      },

      // Store the current dispensary search results
      SET_DISPENSARIES(state, dispensaries) {
        state.dispensaries = dispensaries;
      },

      // Clear the current user session
      LOGOUT(state) {
        state.token = "";
        state.user = {};
        state.locationID = "";
        state.dispensaries = [];

        localStorage.removeItem("token");
        localStorage.removeItem("user");

        delete axios.defaults.headers.common["Authorization"];
      }

    }

  });

}
