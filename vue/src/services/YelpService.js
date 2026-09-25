import axios from "axios";

export default {

    // Get dispensaries near the user's location
    getDispensaries(locationID) {

        return axios.get(
            "/api/dispensaries/search",
            {
                params: {
                    location: locationID
                }
            }
        );

    },

    // Get the featured dispensary for the home page
    getFeatured(state) {

        const config = {};

        if (state) {
            config.params = {
                location: state
            };
        }

        return axios.get(
            "/api/dispensaries/featured",
            config
        );

    }

};