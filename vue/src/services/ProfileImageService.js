import axios from "axios";

export default {
    // Get the authenticated user's profile image
    getProfileImage() {
        return axios.get(
            "/api/profile/image",
            {
                responseType: "blob"
            }
        );
    },

    // Create or replace the authenticated user's profile image
    saveProfileImage(imageFile) {

        const formData =
                new FormData();

        formData.append(
                "image",
                imageFile
        );

        return axios.put(
            "/api/profile/image",
            formData,
            {
                responseType: "blob"
            }
        );
    },

    // Delete the authenticated user's profile image
    deleteProfileImage() {
        return axios.delete(
            "/api/profile/image"
        );
    }
};