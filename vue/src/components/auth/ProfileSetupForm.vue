<!-- Profile Setup Form Component Display -->
<template>

    <div
        id="profile-setup-form"
        class="auth-form-section"
    >

        <!-- Display Profile Setup Information -->
        <p class="profile-setup-description">
            Your home location helps Best Buds find dispensaries near you.
            Your birthday can only be set once, so make sure it is correct
            before continuing.
        </p>

        <!-- Display Profile Setup Error -->
        <p
            v-if="profileError"
            class="form-error"
            role="alert"
        >
            {{ profileErrorMsg }}
        </p>

        <!-- Display Profile Setup Form -->
        <form
            class="auth-form"
            @submit.prevent="saveProfile"
        >

            <!-- Display First Name Field -->
            <div class="form-input-group">

                <label for="first-name">
                    First Name
                </label>

                <input
                    id="first-name"
                    v-model.trim="profile.firstName"
                    name="firstName"
                    type="text"
                    autocomplete="given-name"
                    maxlength="50"
                    required
                    autofocus
                    @input="clearError"
                />

            </div>

            <!-- Display Birthday Field -->
            <div class="form-input-group">

                <label for="birthday">
                    Birthday
                </label>

                <input
                    id="birthday"
                    v-model="profile.birthday"
                    name="birthday"
                    type="date"
                    autocomplete="bday"
                    :max="maximumBirthday"
                    required
                    @change="clearError"
                />

                <p class="form-help">
                    Your birthday can only be set once.
                </p>

            </div>

            <!-- Display Address Field -->
            <div class="form-input-group">

                <label for="address-line-1">
                    Home Address
                </label>

                <input
                    id="address-line-1"
                    v-model.trim="profile.addressLine1"
                    name="addressLine1"
                    type="text"
                    autocomplete="address-line1"
                    maxlength="150"
                    required
                    @input="clearError"
                />

            </div>

            <!-- Display City Field -->
            <div class="form-input-group">

                <label for="city">
                    City
                </label>

                <input
                    id="city"
                    v-model.trim="profile.city"
                    name="city"
                    type="text"
                    autocomplete="address-level2"
                    maxlength="100"
                    required
                    @input="clearError"
                />

            </div>

            <!-- Display State Field -->
            <div class="form-input-group">

                <label for="state">
                    State
                </label>

                <select
                    id="state"
                    v-model="profile.stateAbbr"
                    name="stateAbbr"
                    autocomplete="address-level1"
                    required
                    @change="clearError"
                >
                    <option
                        value=""
                        disabled
                    >
                        Select a state
                    </option>

                    <option
                        v-for="state in states"
                        :key="state.abbreviation"
                        :value="state.abbreviation"
                    >
                        {{ state.name }}
                    </option>
                </select>

            </div>

            <!-- Display ZIP Code Field -->
            <div class="form-input-group">

                <label for="zipcode">
                    ZIP Code
                </label>

                <input
                    id="zipcode"
                    v-model.trim="profile.zipcode"
                    name="zipcode"
                    type="text"
                    inputmode="numeric"
                    autocomplete="postal-code"
                    pattern="[0-9]{5}"
                    maxlength="5"
                    required
                    @input="clearError"
                />

            </div>

            <!-- Display Submit Button -->
            <button
                type="submit"
                :disabled="isSubmitting"
            >
                {{
                    isSubmitting
                        ? "Saving Profile..."
                        : "Continue to Best Buds"
                }}
            </button>

        </form>

    </div>

</template>

<script>
import ProfileService from "../../services/ProfileService.js";

import states from "../../data/forms/states.js";

export default {
    name: "ProfileSetupForm",

    emits: [
        "profile-saved"
    ],

    data() {
        return {
            states,

            profile: {
                firstName: "",
                birthday: "",
                addressLine1: "",
                city: "",
                stateAbbr: "",
                zipcode: ""
            },

            profileError: false,
            profileErrorMsg:
                "Unable to save your profile. Please try again.",
            isSubmitting: false
        };
    },

    computed: {

        // Prevent future birthdays from being selected
        maximumBirthday() {

            return new Date()
                .toISOString()
                .split("T")[0];

        }

    },

    methods: {

        // Save the user's initial profile information
        saveProfile() {

            this.clearError();

            this.isSubmitting = true;

            ProfileService
                .saveProfile(this.profile)
                .then((response) => {

                    if (response.status === 200) {

                        this.$emit(
                            "profile-saved",
                            response.data
                        );

                    }

                })
                .catch((error) => {

                    this.handleProfileError(
                        error
                    );

                })
                .finally(() => {

                    this.isSubmitting = false;

                });

        },

        // Show an appropriate profile setup error
        handleProfileError(error) {

            this.profileError = true;

            if (!error.response) {

                this.profileErrorMsg =
                    "Unable to connect to Best Buds. Please try again.";

                return;

            }

            if (error.response.status === 400) {

                this.profileErrorMsg =
                    this.getValidationErrorMessage(
                        error.response.data
                    );

                return;

            }

            this.profileErrorMsg =
                "Unable to save your profile. Please try again.";

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

            return "Please check your profile information and try again.";

        },

        // Clear the current profile setup error
        clearError() {

            this.profileError = false;

            this.profileErrorMsg =
                "Unable to save your profile. Please try again.";

        }

    }
};
</script>

<style scoped>

</style>