import axios from "axios";

export default {

    // Get dispensaries near the requested location
    getDispensaries(
        searchLocation
    ) {

        return axios.get(
            "/api/dispensaries/search",
            {
                params: {
                    location:
                        searchLocation
                }
            }
        );

    },

    // Get dispensaries near the user's saved home address
    getDispensariesNearHome() {

        return axios.get(
            "/api/dispensaries/near-home"
        );

    },

    // Get the featured dispensary for the home page
    getFeatured() {

        return axios.get(
            "/api/dispensaries/featured"
        );

    }

};