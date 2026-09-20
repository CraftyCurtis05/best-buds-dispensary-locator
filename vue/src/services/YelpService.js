import axios from 'axios';

export default {

  // Get dispensaries near the user's location
  getGreen(locationID) {
    return axios.get('/dispensaries/search', {
      params: {
        location: locationID
      }
    });
  },

  // Get the featured dispensary for the home page
  getFeatured(state) {

    const config = {};

    if (state) {
      config.params = {
        location: state
      };
    }

    return axios.get('/dispensaries/featured', config);
  }

};
