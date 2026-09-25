import axios from "axios";

export default {

    // Get the authenticated user's account information
    getAccount() {
        return axios.get(
            "/api/account"
        );
    },

    // Update the authenticated user's username
    updateUsername(username, currentPassword) {
        return axios.put(
            "/api/account/username",
            {
                username,
                currentPassword
            }
        );
    },

    // Update the authenticated user's email
    updateEmail(email, currentPassword) {
        return axios.put(
            "/api/account/email",
            {
                email,
                currentPassword
            }
        );
    },

    // Update the authenticated user's password
    updatePassword(
        currentPassword,
        newPassword,
        confirmPassword
    ) {
        return axios.put(
            "/api/account/password",
            {
                currentPassword,
                newPassword,
                confirmPassword
            }
        );
    }

};