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

    // Get the featured dispensary for the home page
    getFeatured() {

        return axios.get(
            "/api/dispensaries/featured"
        );

    }

};