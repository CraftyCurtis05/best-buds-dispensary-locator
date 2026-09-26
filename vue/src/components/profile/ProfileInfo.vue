<!-- Profile Information Component Display -->
<template>

    <section
        id="profile-info"
        class="profile-info"
        aria-labelledby="profile-info-heading"
    >

        <!-- Display Profile Information Introduction -->
        <header class="profile-section-header">

            <h3 id="profile-info-heading">
                Profile Information
            </h3>

            <p>
                Update your personal information and home location.
            </p>

        </header>

        <!-- Display Loading Status -->
        <p
            v-if="isLoading"
            class="profile-status"
            role="status"
        >
            Loading your profile...
        </p>

        <!-- Display Profile Form -->
        <form
            v-else
            class="profile-form"
            @submit.prevent="saveProfile"
        >

            <!-- Display Profile Error -->
            <p
                v-if="profileError"
                class="form-error"
                role="alert"
            >
                {{ profileErrorMsg }}
            </p>

            <!-- Display Profile Success -->
            <p
                v-if="profileSaved"
                class="form-success"
                role="status"
            >
                Your profile has been updated.
            </p>

            <!-- Display Personal Information -->
            <section
                class="profile-form-section"
                aria-labelledby="personal-info-heading"
            >

                <h4 id="personal-info-heading">
                    Personal Information
                </h4>

                <!-- Display First Name Field -->
                <div class="form-input-group">

                    <label for="profile-first-name">
                        First Name
                    </label>

                    <input
                        id="profile-first-name"
                        v-model.trim="profile.firstName"
                        name="firstName"
                        type="text"
                        autocomplete="given-name"
                        maxlength="50"
                        required
                        @input="clearMessages"
                    />

                </div>

                <!-- Display Last Name Field -->
                <div class="form-input-group">

                    <label for="profile-last-name">
                        Last Name
                    </label>

                    <input
                        id="profile-last-name"
                        v-model.trim="profile.lastName"
                        name="lastName"
                        type="text"
                        autocomplete="family-name"
                        maxlength="50"
                        @input="clearMessages"
                    />

                </div>

                <!-- Display Birthday Field -->
                <div class="form-input-group">

                    <label for="profile-birthday">
                        Birthday
                    </label>

                    <!-- Display Editable Birthday -->
                    <input
                        v-if="!hasBirthday"
                        id="profile-birthday"
                        v-model="profile.birthday"
                        name="birthday"
                        type="date"
                        autocomplete="bday"
                        :max="maximumBirthday"
                        required
                        @change="clearMessages"
                    />

                    <!-- Display Saved Birthday -->
                    <p
                        v-else
                        id="profile-birthday"
                        class="profile-read-only"
                    >
                        {{ formattedBirthday }}
                    </p>

                    <p class="form-help">
                        {{
                            hasBirthday
                                ? "Your birthday cannot be changed after it has been set."
                                : "Your birthday can only be set once."
                        }}
                    </p>

                </div>

            </section>

            <!-- Display Home Location -->
            <section
                class="profile-form-section"
                aria-labelledby="home-location-heading"
            >

                <h4 id="home-location-heading">
                    Home Location
                </h4>

                <p>
                    Your home location is used for nearby dispensary
                    searches and personalized discovery.
                </p>

                <!-- Display Address Line 1 Field -->
                <div class="form-input-group">

                    <label for="profile-address-line-1">
                        Address Line 1
                    </label>

                    <input
                        id="profile-address-line-1"
                        v-model.trim="profile.addressLine1"
                        name="addressLine1"
                        type="text"
                        autocomplete="address-line1"
                        maxlength="150"
                        required
                        @input="clearMessages"
                    />

                </div>

                <!-- Display Address Line 2 Field -->
                <div class="form-input-group">

                    <label for="profile-address-line-2">
                        Address Line 2
                    </label>

                    <input
                        id="profile-address-line-2"
                        v-model.trim="profile.addressLine2"
                        name="addressLine2"
                        type="text"
                        autocomplete="address-line2"
                        maxlength="150"
                        @input="clearMessages"
                    />

                </div>

                <!-- Display City Field -->
                <div class="form-input-group">

                    <label for="profile-city">
                        City
                    </label>

                    <input
                        id="profile-city"
                        v-model.trim="profile.city"
                        name="city"
                        type="text"
                        autocomplete="address-level2"
                        maxlength="100"
                        required
                        @input="clearMessages"
                    />

                </div>

                <!-- Display State Field -->
                <div class="form-input-group">

                    <label for="profile-state">
                        State
                    </label>

                    <select
                        id="profile-state"
                        v-model="profile.stateAbbr"
                        name="stateAbbr"
                        autocomplete="address-level1"
                        required
                        @change="clearMessages"
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

                    <label for="profile-zipcode">
                        ZIP Code
                    </label>

                    <input
                        id="profile-zipcode"
                        v-model.trim="profile.zipcode"
                        name="zipcode"
                        type="text"
                        inputmode="numeric"
                        autocomplete="postal-code"
                        pattern="[0-9]{5}"
                        maxlength="5"
                        required
                        @input="clearMessages"
                    />

                </div>

            </section>

            <!-- Display Profile Actions -->
            <div class="profile-actions">

                <button
                    type="submit"
                    :disabled="isSubmitting"
                >
                    {{
                        isSubmitting
                            ? "Saving Changes..."
                            : "Save Changes"
                    }}
                </button>

            </div>

        </form>

    </section>

</template>

<script>
import ProfileService from "../../services/ProfileService.js";

import states from "../../data/forms/states.js";

export default {
    name: "ProfileInfo",

    data() {
        return {
            states,

            profile: {
                firstName: "",
                lastName: "",
                birthday: "",
                addressLine1: "",
                addressLine2: "",
                city: "",
                stateAbbr: "",
                zipcode: ""
            },

            isLoading: true,
            isSubmitting: false,

            profileError: false,
            profileSaved: false,
            profileErrorMsg:
                "Unable to load your profile. Please try again."
        };
    },

    computed: {

        // Check whether the birthday has already been set
        hasBirthday() {

            return Boolean(
                this.profile.birthday
            );

        },

        // Prevent future birthdays from being selected
        maximumBirthday() {

            return new Date()
                .toISOString()
                .split("T")[0];

        },

        // Format the saved birthday for display
        formattedBirthday() {

            if (!this.profile.birthday) {
                return "";
            }

            const birthdayParts =
                this.profile.birthday.split("-");

            if (birthdayParts.length !== 3) {
                return this.profile.birthday;
            }

            const birthday =
                new Date(
                    Number(
                        birthdayParts[0]
                    ),
                    Number(
                        birthdayParts[1]
                    ) - 1,
                    Number(
                        birthdayParts[2]
                    )
                );

            return birthday.toLocaleDateString(
                undefined,
                {
                    year: "numeric",
                    month: "long",
                    day: "numeric"
                }
            );

        }

    },

    created() {
        this.loadProfile();
    },

    methods: {

        // Load the user's saved profile information
        loadProfile() {

            this.isLoading = true;

            this.clearMessages();

            ProfileService
                .getProfile()
                .then((response) => {

                    if (response.status === 200) {

                        this.setProfile(
                            response.data
                        );

                    }

                })
                .catch(() => {

                    this.profileError = true;

                    this.profileErrorMsg =
                        "Unable to load your profile. Please try again.";

                })
                .finally(() => {

                    this.isLoading = false;

                });

        },

        // Save changes to the user's profile information
        saveProfile() {

            this.clearMessages();

            this.isSubmitting = true;

            ProfileService
                .saveProfile(
                    this.profile
                )
                .then((response) => {

                    if (response.status === 200) {

                        this.setProfile(
                            response.data
                        );

                        this.$store.commit(
                            "SET_PROFILE",
                            response.data
                        );

                        this.profileSaved = true;

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

        // Store profile information for editing
        setProfile(profile) {

            this.profile = {
                firstName:
                    profile.firstName || "",

                lastName:
                    profile.lastName || "",

                birthday:
                    profile.birthday || "",

                addressLine1:
                    profile.addressLine1 || "",

                addressLine2:
                    profile.addressLine2 || "",

                city:
                    profile.city || "",

                stateAbbr:
                    profile.stateAbbr || "",

                zipcode:
                    profile.zipcode || ""
            };

        },

        // Show an appropriate profile error
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

        // Clear the current profile messages
        clearMessages() {

            this.profileError = false;
            this.profileSaved = false;

            this.profileErrorMsg =
                "Unable to save your profile. Please try again.";

        }

    }
};
</script>

<style scoped>

</style>