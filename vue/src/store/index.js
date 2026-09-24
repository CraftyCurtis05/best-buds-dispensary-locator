import { createStore as _createStore } from "vuex";
import axios from "axios";

export function createStore(
    currentToken = "",
    currentUser = {}
) {
    return _createStore({
        state: {
            token: currentToken || "",
            user: currentUser || {},
            profile: null,
            profileLoaded: false,
            locationID: "",
            dispensaries: []
        },

        mutations: {

            // Store the authorization token
            SET_AUTH_TOKEN(state, token) {
                state.token = token;

                localStorage.setItem(
                    "token",
                    token
                );

                axios.defaults.headers.common[
                    "Authorization"
                ] = `Bearer ${token}`;
            },

            // Store the authenticated user
            SET_USER(state, user) {
                state.user = user;

                localStorage.setItem(
                    "user",
                    JSON.stringify(user)
                );
            },

            // Store the authenticated user's profile
            SET_PROFILE(state, profile) {
                state.profile = profile;
                state.profileLoaded = true;
            },

            // Record that the user does not have a profile
            SET_PROFILE_MISSING(state) {
                state.profile = null;
                state.profileLoaded = true;
            },

            SET_LOCATION(state, locationID) {
                state.locationID = locationID;
            },

            SET_DISPENSARIES(state, dispensaries) {
                state.dispensaries = dispensaries;
            },

            // Clear the authenticated session
            LOGOUT(state) {
                state.token = "";
                state.user = {};
                state.profile = null;
                state.profileLoaded = false;
                state.locationID = "";
                state.dispensaries = [];

                localStorage.removeItem("token");
                localStorage.removeItem("user");

                delete axios.defaults.headers.common[
                    "Authorization"
                ];
            }
        }
    });
}