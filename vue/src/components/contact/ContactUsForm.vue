<!-- Contact Us Form Component Display -->
<template>

    <form
        id="contact-us-form"
        @submit.prevent="submitForm"
    >

        <!-- Display Name Field -->
        <div class="form-group">

            <label for="contact-name">
                Name
            </label>

            <input
                id="contact-name"
                v-model.trim="form.name"
                class="form-input"
                type="text"
                name="name"
                autocomplete="name"
                maxlength="100"
                required
            />

        </div>

        <!-- Display Email Field -->
        <div class="form-group">

            <label for="contact-email">
                Email
            </label>

            <input
                id="contact-email"
                v-model.trim="form.email"
                class="form-input"
                type="email"
                name="email"
                autocomplete="email"
                maxlength="254"
                required
            />

        </div>

        <!-- Display Favorite Strain Field -->
        <div class="form-group">

            <label for="favorite-strain">
                Favorite Strain
            </label>

            <input
                id="favorite-strain"
                v-model.trim="form.favoriteStrain"
                class="form-input"
                type="text"
                name="favoriteStrain"
                maxlength="100"
            />

        </div>

        <!-- Display Message Field -->
        <div class="form-group">

            <label for="contact-message">
                Message
            </label>

            <textarea
                id="contact-message"
                v-model.trim="form.message"
                class="form-input"
                name="message"
                rows="6"
                maxlength="2000"
                required
            ></textarea>

        </div>

        <!-- Display Spam Protection -->
        <div
            class="honeypot"
            aria-hidden="true"
        >

            <label for="contact-website">
                Website
            </label>

            <input
                id="contact-website"
                v-model="form.website"
                type="text"
                name="website"
                tabindex="-1"
                autocomplete="off"
            />

        </div>

        <!-- Display Form Status -->
        <p
            v-if="statusMessage"
            role="status"
            aria-live="polite"
        >
            {{ statusMessage }}
        </p>

        <!-- Display Submit Button -->
        <button
            type="submit"
            :disabled="isSubmitting"
        >
            {{ isSubmitting ? "Sending..." : "Submit" }}
        </button>

    </form>

</template>

<script>
import axios from "axios";

export default {
    name: "ContactUsForm",

    data() {
        return {
            form: {
                name: "",
                email: "",
                favoriteStrain: "",
                message: "",
                website: ""
            },

            isSubmitting: false,
            statusMessage: ""
        };
    },

    methods: {

        // Submit the contact form
        async submitForm() {

            this.isSubmitting = true;
            this.statusMessage = "";

            try {

                await axios.post(
                    "/api/contact.php",
                    this.form
                );

                this.statusMessage =
                    "Your message was sent successfully.";

                this.resetForm();

            } catch (error) {

                console.error(
                    "Contact form submission failed:",
                    error
                );

                this.statusMessage =
                    "Your message could not be sent. Please try again.";

            } finally {

                this.isSubmitting = false;

            }

        },

        // Clear the contact form
        resetForm() {

            this.form = {
                name: "",
                email: "",
                favoriteStrain: "",
                message: "",
                website: ""
            };

        }

    }
};
</script>

<style scoped>

</style>