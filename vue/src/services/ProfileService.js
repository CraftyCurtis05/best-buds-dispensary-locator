import axios from "axios";

export default {

    // Get the authenticated user's profile
    getProfile() {
        return axios.get("/api/profile");
    },

    // Create or update the authenticated user's profile
    saveProfile(profile) {
        return axios.put(
            "/api/profile",
            profile
        );
    }

};