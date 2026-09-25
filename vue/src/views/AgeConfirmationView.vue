<!-- Age Confirmation View -->
<template>
    <section
        id="age-confirmation-view"
        class="auth-view"
        aria-labelledby="age-confirmation-heading"
    >
        <!-- Best Buds branding -->
        <header class="auth-header">
            <img
                :src="Logo"
                class="auth-logo"
                alt="Best Buds"
            />

            <h1 id="age-confirmation-heading">
                Are You 21 or Older?
            </h1>

            <p>
                You must be at least 21 years old to use Best Buds.
            </p>
        </header>

        <!-- Age confirmation -->
        <section
            class="auth-form-section"
            aria-label="Age confirmation"
        >
            <div class="age-confirmation-content">
                <p>
                    By continuing, you confirm that you are 21 years of age
                    or older.
                </p>

                <p>
                    Best Buds uses this confirmation to restrict access to
                    age-appropriate content and features.
                </p>

                <!-- Confirmation error -->
                <p
                    v-if="confirmationError"
                    class="form-error"
                    role="alert"
                >
                    {{ confirmationErrorMsg }}
                </p>

                <div class="age-confirmation-actions">
                    <button
                        type="button"
                        :disabled="isSubmitting"
                        @click="confirmAge"
                    >
                        {{
                            isSubmitting
                                ? "Confirming..."
                                : "Yes, I Am 21 or Older"
                        }}
                    </button>

                    <button
                        type="button"
                        :disabled="isSubmitting"
                        @click="logout"
                    >
                        No, I Am Under 21
                    </button>
                </div>
            </div>
        </section>
    </section>
</template>

<script>
import authService from "../services/AuthService.js";

import Logo from "../assets/layout/logo/logo-dark-theme.png";

export default {
    name: "AgeConfirmationView",

    data() {
        return {
            Logo,

            confirmationError: false,
            confirmationErrorMsg:
                "Unable to confirm your age. Please try again.",
            isSubmitting: false
        };
    },

    methods: {

        // Confirm that the current user meets the age requirement
        confirmAge() {
            this.clearError();
            this.isSubmitting = true;

            authService
                .confirmAge()
                .then((response) => {
                    if (response.status === 204) {
                        this.updateAgeConfirmation();
                        this.continueOnboarding();
                    }
                })
                .catch((error) => {
                    this.handleConfirmationError(error);
                })
                .finally(() => {
                    this.isSubmitting = false;
                });
        },

        // Update the user's age confirmation in the store
        updateAgeConfirmation() {
            const updatedUser = {
                ...this.$store.state.user,
                ageConfirmed: true
            };

            this.$store.commit(
                "SET_USER",
                updatedUser
            );
        },

        // Continue to the next onboarding step
        continueOnboarding() {
            this.$router.push({
                name: "profile-setup"
            });
        },

        // Sign out users who do not meet the age requirement
        logout() {
            this.$store.commit("LOGOUT");

            this.$router.push({
                name: "login"
            });
        },

        // Show an appropriate age confirmation error
        handleConfirmationError(error) {
            this.confirmationError = true;

            if (!error.response) {
                this.confirmationErrorMsg =
                    "Unable to connect to Best Buds. Please try again.";

                return;
            }

            this.confirmationErrorMsg =
                "Unable to confirm your age. Please try again.";
        },

        // Clear the current age confirmation error
        clearError() {
            this.confirmationError = false;
            this.confirmationErrorMsg =
                "Unable to confirm your age. Please try again.";
        }

    }
};
</script>

<style scoped>
</style>