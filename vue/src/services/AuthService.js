import axios from "axios";

export default {

    // Authenticate the user
    login(user) {
        return axios.post(
            "/api/auth/login",
            user
        );
    },

    // Register a new user
    register(user) {
        return axios.post(
            "/api/auth/register",
            user
        );
    },

    // Confirm that the user meets the age requirement
    confirmAge() {
        return axios.post(
            "/api/age/confirm"
        );
    }

};