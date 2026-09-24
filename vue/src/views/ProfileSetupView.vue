<template>
    <section
        id="profile-setup-view"
        class="auth-view"
        aria-labelledby="profile-setup-heading"
    >
        <!-- Profile setup introduction -->
        <header class="auth-header">
            <img
                :src="Logo"
                class="auth-logo"
                alt="Best Buds"
            />

            <h1 id="profile-setup-heading">
                Set Up Your Profile
            </h1>

            <p>
                Tell us a little about yourself and where you call home.
            </p>
        </header>

        <!-- Profile setup form -->
        <section
            class="auth-form-section"
            aria-label="Profile setup"
        >
            <p class="profile-setup-description">
                Your home location helps Best Buds find dispensaries near you.
                You can update this information later from your profile.
            </p>

            <!-- Profile setup error -->
            <p
                v-if="profileError"
                class="form-error"
                role="alert"
            >
                {{ profileErrorMsg }}
            </p>

            <form
                class="auth-form"
                @submit.prevent="saveProfile"
            >
                <!-- First name -->
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

                <!-- Address -->
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

                <!-- City -->
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

                <!-- State -->
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

                <!-- ZIP code -->
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
        </section>
    </section>
</template>

<script>
import profileService from "../services/ProfileService.js";

import Logo from "../assets/layout/logo/logo-dark-theme.png";

export default {
    name: "ProfileSetupView",

    data() {
        return {
            Logo,

            profile: {
                firstName: "",
                addressLine1: "",
                city: "",
                stateAbbr: "",
                zipcode: ""
            },

            states: [
                { abbreviation: "AL", name: "Alabama" },
                { abbreviation: "AK", name: "Alaska" },
                { abbreviation: "AZ", name: "Arizona" },
                { abbreviation: "AR", name: "Arkansas" },
                { abbreviation: "CA", name: "California" },
                { abbreviation: "CO", name: "Colorado" },
                { abbreviation: "CT", name: "Connecticut" },
                { abbreviation: "DE", name: "Delaware" },
                { abbreviation: "FL", name: "Florida" },
                { abbreviation: "GA", name: "Georgia" },
                { abbreviation: "HI", name: "Hawaii" },
                { abbreviation: "ID", name: "Idaho" },
                { abbreviation: "IL", name: "Illinois" },
                { abbreviation: "IN", name: "Indiana" },
                { abbreviation: "IA", name: "Iowa" },
                { abbreviation: "KS", name: "Kansas" },
                { abbreviation: "KY", name: "Kentucky" },
                { abbreviation: "LA", name: "Louisiana" },
                { abbreviation: "ME", name: "Maine" },
                { abbreviation: "MD", name: "Maryland" },
                { abbreviation: "MA", name: "Massachusetts" },
                { abbreviation: "MI", name: "Michigan" },
                { abbreviation: "MN", name: "Minnesota" },
                { abbreviation: "MS", name: "Mississippi" },
                { abbreviation: "MO", name: "Missouri" },
                { abbreviation: "MT", name: "Montana" },
                { abbreviation: "NE", name: "Nebraska" },
                { abbreviation: "NV", name: "Nevada" },
                { abbreviation: "NH", name: "New Hampshire" },
                { abbreviation: "NJ", name: "New Jersey" },
                { abbreviation: "NM", name: "New Mexico" },
                { abbreviation: "NY", name: "New York" },
                { abbreviation: "NC", name: "North Carolina" },
                { abbreviation: "ND", name: "North Dakota" },
                { abbreviation: "OH", name: "Ohio" },
                { abbreviation: "OK", name: "Oklahoma" },
                { abbreviation: "OR", name: "Oregon" },
                { abbreviation: "PA", name: "Pennsylvania" },
                { abbreviation: "RI", name: "Rhode Island" },
                { abbreviation: "SC", name: "South Carolina" },
                { abbreviation: "SD", name: "South Dakota" },
                { abbreviation: "TN", name: "Tennessee" },
                { abbreviation: "TX", name: "Texas" },
                { abbreviation: "UT", name: "Utah" },
                { abbreviation: "VT", name: "Vermont" },
                { abbreviation: "VA", name: "Virginia" },
                { abbreviation: "WA", name: "Washington" },
                { abbreviation: "WV", name: "West Virginia" },
                { abbreviation: "WI", name: "Wisconsin" },
                { abbreviation: "WY", name: "Wyoming" }
            ],

            profileError: false,
            profileErrorMsg:
                "Unable to save your profile. Please try again.",
            isSubmitting: false
        };
    },

    methods: {
        saveProfile() {
            this.clearError();
            this.isSubmitting = true;

            profileService
                .saveProfile(this.profile)
                .then((response) => {
                    if (response.status === 200) {
                        this.$store.commit(
                            "SET_PROFILE",
                            response.data
                        );

                        this.$router.push({
                            name: "home"
                        });
                    }
                })
                .catch((error) => {
                    this.handleProfileError(error);
                })
                .finally(() => {
                    this.isSubmitting = false;
                });
        },

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