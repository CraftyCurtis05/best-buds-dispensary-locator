<!-- Register Form Component Display -->
<template>

    <div
        id="register-form"
        class="auth-form-section"
    >

        <!-- Display Registration Error -->
        <p
            v-if="registrationErrors"
            class="form-error"
            role="alert"
        >
            {{ registrationErrorMsg }}
        </p>

        <!-- Display Registration Form -->
        <form
            class="auth-form"
            @submit.prevent="register"
        >

            <!-- Display Username Field -->
            <div class="form-input-group">

                <label for="username">
                    Username
                </label>

                <input
                    id="username"
                    v-model.trim="user.username"
                    name="username"
                    type="text"
                    autocomplete="username"
                    required
                    autofocus
                    @input="clearErrors"
                />

            </div>

            <!-- Display Email Field -->
            <div class="form-input-group">

                <label for="email">
                    Email
                </label>

                <input
                    id="email"
                    v-model.trim="user.email"
                    name="email"
                    type="email"
                    autocomplete="email"
                    required
                    @input="clearErrors"
                />

            </div>

            <!-- Display Password Field -->
            <div class="form-input-group">

                <label for="password">
                    Password
                </label>

                <input
                    id="password"
                    v-model="user.password"
                    name="password"
                    type="password"
                    autocomplete="new-password"
                    minlength="8"
                    required
                    @input="clearErrors"
                />

            </div>

            <!-- Display Confirm Password Field -->
            <div class="form-input-group">

                <label for="confirm-password">
                    Confirm Password
                </label>

                <input
                    id="confirm-password"
                    v-model="user.confirmPassword"
                    name="confirmPassword"
                    type="password"
                    autocomplete="new-password"
                    minlength="8"
                    required
                    @input="clearErrors"
                />

            </div>

            <!-- Display Submit Button -->
            <button
                type="submit"
                :disabled="isSubmitting"
            >
                {{
                    isSubmitting
                        ? "Creating Account..."
                        : "Create Account"
                }}
            </button>

        </form>

        <!-- Display Login Link -->
        <p class="auth-link">
            Already have an account?

            <router-link
                :to="{ name: 'login' }"
            >
                Log in.
            </router-link>
        </p>

    </div>

</template>

<script>
import AuthService from "../../services/AuthService.js";

export default {
    name: "RegisterForm",

    emits: [
        "registered"
    ],

    data() {
        return {
            user: {
                username: "",
                email: "",
                password: "",
                confirmPassword: ""
            },

            registrationErrors: false,
            registrationErrorMsg:
                "There were problems creating your account.",
            isSubmitting: false
        };
    },

    methods: {

        // Create a new Best Buds account
        register() {

            this.clearErrors();

            if (
                this.user.password
                !== this.user.confirmPassword
            ) {

                this.registrationErrors = true;

                this.registrationErrorMsg =
                    "Password and Confirm Password do not match.";

                return;

            }

            this.isSubmitting = true;

            AuthService
                .register(this.user)
                .then((response) => {

                    if (response.status === 201) {

                        this.$emit(
                            "registered"
                        );

                    }

                })
                .catch((error) => {

                    this.handleRegistrationError(
                        error
                    );

                })
                .finally(() => {

                    this.isSubmitting = false;

                });

        },

        // Show an appropriate account registration error
        handleRegistrationError(error) {

            this.registrationErrors = true;

            if (!error.response) {

                this.registrationErrorMsg =
                    "Unable to connect to Best Buds. Please try again.";

                return;

            }

            if (error.response.status === 400) {

                this.registrationErrorMsg =
                    this.getValidationErrorMessage(
                        error.response.data
                    );

                return;

            }

            if (error.response.status === 409) {

                this.registrationErrorMsg =
                    "That username or email is already in use.";

                return;

            }

            this.registrationErrorMsg =
                "There were problems creating your account. Please try again.";

        },

        // Get a useful validation message from the server response
        getValidationErrorMessage(responseData) {

            if (
                typeof responseData === "string"
                && responseData.trim()
            ) {
                return responseData;
            }

            if (responseData?.message) {
                return responseData.message;
            }

            if (responseData?.errors) {

                const validationErrors =
                    Object.values(
                        responseData.errors
                    );

                if (validationErrors.length > 0) {
                    return validationErrors[0];
                }

            }

            return "Please check your registration information and try again.";

        },

        // Clear the current account registration error
        clearErrors() {

            this.registrationErrors = false;

            this.registrationErrorMsg =
                "There were problems creating your account.";

        }

    }
};
</script>

<style scoped>

</style>