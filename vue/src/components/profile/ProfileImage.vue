<!-- Profile Image Component Display -->
<template>

    <section
        id="profile-image"
        class="profile-image"
        aria-labelledby="profile-image-heading"
    >

        <!-- Display Profile Image Introduction -->
        <header class="profile-image-header">

            <h3 id="profile-image-heading">
                Profile Picture
            </h3>

            <p>
                Add a picture to personalize your Best Buds profile.
            </p>

        </header>

        <!-- Display Profile Image -->
        <div class="profile-image-display">

            <img
                :src="profileImageUrl"
                alt="User profile"
                class="profile-image-picture"
            />

        </div>

        <!-- Display Loading Status -->
        <p
            v-if="isLoading"
            class="profile-image-status"
            role="status"
        >
            Loading profile picture...
        </p>

        <!-- Display Processing Status -->
        <p
            v-if="isProcessing"
            class="profile-image-status"
            role="status"
        >
            Preparing your image...
        </p>

        <!-- Display Profile Image Error -->
        <p
            v-if="errorMessage"
            class="profile-image-error"
            role="alert"
        >
            {{ errorMessage }}
        </p>

        <!-- Display Profile Image Success -->
        <p
            v-if="successMessage"
            class="profile-image-success"
            role="status"
        >
            {{ successMessage }}
        </p>

        <!-- Display Profile Image Controls -->
        <div
            v-if="!isLoading"
            class="profile-image-controls"
        >

            <label
                for="profile-image-input"
                class="profile-image-label"
            >
                Choose an Image
            </label>

            <input
                id="profile-image-input"
                ref="imageInput"
                type="file"
                accept="image/*"
                :disabled="isProcessing || isSubmitting"
                @change="selectImage"
            />

            <p class="profile-image-help">
                Choose an image up to 20 MB.
                Large images are automatically resized and compressed.
            </p>

            <button
                type="button"
                :disabled="
                    !selectedImage
                    || isProcessing
                    || isSubmitting
                "
                @click="saveProfileImage"
            >
                {{
                    isSubmitting
                        ? "Uploading..."
                        : uploadButtonText
                }}
            </button>

            <button
                v-if="hasProfileImage"
                type="button"
                :disabled="isProcessing || isSubmitting"
                @click="deleteProfileImage"
            >
                Remove Picture
            </button>

        </div>

    </section>

</template>

<script>
import DefaultUserImage from "../../assets/profile/default-user.webp";

import ProfileImageService from "../../services/ProfileImageService";

export default {
    name: "ProfileImage",

    data() {
        return {
            DefaultUserImage,

            profileImageUrl: DefaultUserImage,
            objectUrl: null,
            selectedImage: null,

            hasProfileImage: false,
            isLoading: true,
            isProcessing: false,
            isSubmitting: false,

            errorMessage: "",
            successMessage: ""
        };
    },

    computed: {

        // Get the appropriate profile image upload button text
        uploadButtonText() {

            return this.hasProfileImage
                ? "Replace Picture"
                : "Upload Picture";

        }

    },

    created() {
        this.loadProfileImage();
    },

    beforeUnmount() {
        this.revokeObjectUrl();
    },

    methods: {

        // Load the user's saved profile picture
        async loadProfileImage() {

            this.isLoading = true;
            this.errorMessage = "";

            try {

                const response =
                    await ProfileImageService
                        .getProfileImage();

                if (
                    response.status === 204
                    || !response.data
                    || response.data.size === 0
                ) {

                    this.showDefaultImage();

                    return;

                }

                this.showProfileImage(
                    response.data
                );

            } catch {

                this.showDefaultImage();

                this.errorMessage =
                    "Unable to load your profile picture.";

            } finally {

                this.isLoading = false;

            }

        },

        // Validate and prepare the image selected by the user
        async selectImage(event) {

            this.selectedImage = null;
            this.errorMessage = "";
            this.successMessage = "";

            const imageFile =
                event.target.files[0];

            if (!imageFile) {
                return;
            }

            if (!imageFile.type.startsWith("image/")) {

                this.errorMessage =
                    "Please choose a valid image file.";

                this.clearImageInput();

                return;

            }

            if (imageFile.size > 20 * 1024 * 1024) {

                this.errorMessage =
                    "Profile image must be 20 MB or smaller.";

                this.clearImageInput();

                return;

            }

            this.isProcessing = true;

            try {

                this.selectedImage =
                    await this.compressImage(
                        imageFile
                    );

            } catch {

                this.errorMessage =
                    "Unable to prepare this image. Please try another image.";

                this.clearImageInput();

            } finally {

                this.isProcessing = false;

            }

        },

        // Resize and compress an image before uploading it
        async compressImage(imageFile) {

            const image =
                await this.loadImage(
                    imageFile
                );

            const dimensions =
                this.calculateImageDimensions(
                    image.width,
                    image.height,
                    1000
                );

            const canvas =
                document.createElement(
                    "canvas"
                );

            canvas.width =
                dimensions.width;

            canvas.height =
                dimensions.height;

            const context =
                canvas.getContext(
                    "2d"
                );

            if (!context) {

                throw new Error(
                    "Unable to prepare image canvas."
                );

            }

            context.drawImage(
                image,
                0,
                0,
                dimensions.width,
                dimensions.height
            );

            const imageBlob =
                await this.createImageBlob(
                    canvas
                );

            if (imageBlob.size > 5 * 1024 * 1024) {

                throw new Error(
                    "Compressed image is too large."
                );

            }

            return new File(
                [imageBlob],
                "profile-image.jpg",
                {
                    type: "image/jpeg"
                }
            );

        },

        // Load a selected file into a browser image
        loadImage(imageFile) {

            return new Promise(
                (resolve, reject) => {

                    const image =
                        new Image();

                    const imageUrl =
                        URL.createObjectURL(
                            imageFile
                        );

                    image.onload = () => {

                        URL.revokeObjectURL(
                            imageUrl
                        );

                        resolve(
                            image
                        );

                    };

                    image.onerror = () => {

                        URL.revokeObjectURL(
                            imageUrl
                        );

                        reject(
                            new Error(
                                "Unable to load image."
                            )
                        );

                    };

                    image.src =
                        imageUrl;

                }
            );

        },

        // Calculate new dimensions without changing aspect ratio
        calculateImageDimensions(
            originalWidth,
            originalHeight,
            maximumDimension
        ) {

            const scale =
                Math.min(
                    1,
                    maximumDimension
                        / Math.max(
                            originalWidth,
                            originalHeight
                        )
                );

            return {
                width: Math.round(
                    originalWidth * scale
                ),

                height: Math.round(
                    originalHeight * scale
                )
            };

        },

        // Convert the resized canvas into a compressed JPEG
        createImageBlob(canvas) {

            return new Promise(
                (resolve, reject) => {

                    canvas.toBlob(
                        (imageBlob) => {

                            if (!imageBlob) {

                                reject(
                                    new Error(
                                        "Unable to compress image."
                                    )
                                );

                                return;

                            }

                            resolve(
                                imageBlob
                            );

                        },
                        "image/jpeg",
                        0.85
                    );

                }
            );

        },

        // Upload or replace the user's profile picture
        async saveProfileImage() {

            if (!this.selectedImage) {
                return;
            }

            this.isSubmitting = true;
            this.errorMessage = "";
            this.successMessage = "";

            try {

                const response =
                    await ProfileImageService
                        .saveProfileImage(
                            this.selectedImage
                        );

                if (
                    response.status === 200
                    && response.data
                    && response.data.size > 0
                ) {

                    this.showProfileImage(
                        response.data
                    );

                    this.selectedImage = null;

                    this.clearImageInput();

                    this.successMessage =
                        "Profile picture updated.";

                }

            } catch (error) {

                this.errorMessage =
                    this.getErrorMessage(
                        error,
                        "Unable to update your profile picture."
                    );

            } finally {

                this.isSubmitting = false;

            }

        },

        // Delete the user's saved profile picture
        async deleteProfileImage() {

            this.isSubmitting = true;
            this.errorMessage = "";
            this.successMessage = "";

            try {

                const response =
                    await ProfileImageService
                        .deleteProfileImage();

                if (response.status === 204) {

                    this.showDefaultImage();

                    this.selectedImage = null;

                    this.clearImageInput();

                    this.successMessage =
                        "Profile picture removed.";

                }

            } catch {

                this.errorMessage =
                    "Unable to remove your profile picture.";

            } finally {

                this.isSubmitting = false;

            }

        },

        // Display an image returned by the profile image API
        showProfileImage(imageBlob) {

            this.revokeObjectUrl();

            this.objectUrl =
                URL.createObjectURL(
                    imageBlob
                );

            this.profileImageUrl =
                this.objectUrl;

            this.hasProfileImage = true;

        },

        // Return to the default profile image
        showDefaultImage() {

            this.revokeObjectUrl();

            this.profileImageUrl =
                this.DefaultUserImage;

            this.hasProfileImage = false;

        },

        // Release temporary browser image URLs
        revokeObjectUrl() {

            if (this.objectUrl) {

                URL.revokeObjectURL(
                    this.objectUrl
                );

                this.objectUrl = null;

            }

        },

        // Clear the file input after upload or removal
        clearImageInput() {

            if (this.$refs.imageInput) {

                this.$refs.imageInput.value = "";

            }

        },

        // Get a safe message from an upload error
        getErrorMessage(
            error,
            defaultMessage
        ) {

            const responseMessage =
                error.response?.data?.message;

            if (
                typeof responseMessage === "string"
                && responseMessage.trim() !== ""
            ) {
                return responseMessage;
            }

            return defaultMessage;

        }

    }
};
</script>

<style scoped>

</style>