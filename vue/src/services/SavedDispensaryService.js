import axios from "axios";

export default {

    // Get the authenticated user's saved dispensaries
    getSavedDispensaries() {

        return axios.get(
            "/api/saved-dispensaries"
        );

    },

    // Save a dispensary for the authenticated user
    saveDispensary(dispensary) {

        return axios.post(
            "/api/saved-dispensaries",
            dispensary
        );

    },

    // Remove a dispensary from the authenticated user's saved dispensaries
    deleteSavedDispensary(yelpBusinessId) {

        return axios.delete(
            `/api/saved-dispensaries/${encodeURIComponent(
                yelpBusinessId
            )}`
        );

    }

};