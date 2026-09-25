import axios from "axios";

export default {
    // Get the authenticated user's unlocked collectibles
    getCollectibles() {
        return axios.get(
            "/api/collectibles"
        );
    },

    // Check for a new automatic collectible
    checkForDrops() {
        return axios.post(
            "/api/collectibles/check"
        );
    },

    // Get a specific collectible unlocked by the authenticated user
    getCollectible(code) {
        return axios.get(
            `/api/collectibles/${encodeURIComponent(
                code
            )}`
        );
    }
};