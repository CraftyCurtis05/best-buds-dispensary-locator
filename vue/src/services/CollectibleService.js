import axios from "axios";

export default {

    // Get the authenticated user's unlocked collectibles
    getCollectibles() {

        return axios.get(
            "/api/collectibles"
        );

    },

    // Check whether the authenticated user has earned new Drops
    checkForDrops() {

        return axios.post(
            "/api/collectibles/check"
        );

    }

};