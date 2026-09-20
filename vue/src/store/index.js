import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {

  const store = _createStore({

    state: {
      token: currentToken || '',
      user: currentUser || {},
      locationID: ''
    },

    mutations: {

      // Store the user's authorization token
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },

      // Store the current user
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },

      // Store the current dispensary search location
      SET_LOCATION(state, locationID) {
        state.locationID = locationID;
      },

      // Clear the current user session
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');

        state.token = '';
        state.user = {};

        delete axios.defaults.headers.common['Authorization'];
      }

    }

  });

  return store;
}
