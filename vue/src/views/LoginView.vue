<template>
    <section
        id="login-view"
        class="auth-view"
        aria-labelledby="login-heading"
    >
        <!-- Best Buds branding -->
        <header class="auth-header">
            <img
                :src="Logo"
                class="auth-logo"
                alt="Best Buds"
            />

            <h1 id="login-heading">
                Welcome Back
            </h1>

            <p>
                Sign in to continue to Best Buds.
            </p>
        </header>

        <!-- Login form -->
        <section
            id="login-form"
            class="auth-form-section"
            aria-label="Account login"
        >
            <!-- Successful registration message -->
            <p
                v-if="registrationSuccessful"
                class="form-success"
                role="status"
            >
                Your account was created successfully. Please sign in.
            </p>

            <!-- Login error -->
            <p
                v-if="loginError"
                class="form-error"
                role="alert"
            >
                {{ loginErrorMsg }}
            </p>

            <form
                class="auth-form"
                @submit.prevent="login"
            >
                <!-- Username -->
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
                        @input="clearError"
                    />
                </div>

                <!-- Password -->
                <div class="form-input-group">
                    <label for="password">
                        Password
                    </label>

                    <input
                        id="password"
                        v-model="user.password"
                        name="password"
                        type="password"
                        autocomplete="current-password"
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
                            ? "Signing In..."
                            : "Sign In"
                    }}
                </button>
            </form>

            <p class="auth-link">
                Need an account?

                <router-link :to="{ name: 'register' }">
                    Create one.
                </router-link>
            </p>
        </section>
    </section>
</template>

<script>
import authService from "../services/AuthService.js";
import profileService from "../services/ProfileService.js";

import Logo from "../assets/layout/logo/logo-dark-theme.png";

export default {
    name: "LoginView",

    data() {
        return {
            Logo,

            user: {
                username: "",
                password: ""
            },

            loginError: false,
            loginErrorMsg:
                "Unable to sign in.",
            isSubmitting: false
        };
    },

    computed: {
        registrationSuccessful() {
            return this.$route.query.registration === "success";
        }
    },

    methods: {
        login() {
            this.clearError();
            this.isSubmitting = true;

            authService
                .login(this.user)
                .then((response) => {
                    if (response.status !== 200) {
                        return;
                    }

                    this.saveUserSession(
                        response.data
                    );

                    return this.continueOnboarding(
                        response.data.user
                    );
                })
                .catch((error) => {
                    this.handleLoginError(error);
                })
                .finally(() => {
                    this.isSubmitting = false;
                });
        },

        // Store the authenticated user and authorization token
        saveUserSession(loginResponse) {
            this.$store.commit(
                "SET_AUTH_TOKEN",
                loginResponse.token
            );

            this.$store.commit(
                "SET_USER",
                loginResponse.user
            );
        },

        // Send the user to the next required onboarding step
        continueOnboarding(user) {
            if (!user.ageConfirmed) {
                return this.$router.push({
                    name: "age-confirmation"
                });
            }

            return this.checkProfile();
        },

        // Check whether the user has completed profile setup
        checkProfile() {
            return profileService
                .getProfile()
                .then((response) => {
                    if (response.status === 204) {
                        this.$store.commit(
                            "SET_PROFILE_MISSING"
                        );

                        return this.$router.push({
                            name: "profile-setup"
                        });
                    }

                    this.$store.commit(
                        "SET_PROFILE",
                        response.data
                    );

                    return this.$router.push({
                        name: "home"
                    });
                });
        },

        handleLoginError(error) {
            this.loginError = true;

            if (!error.response) {
                this.loginErrorMsg =
                    "Unable to connect to Best Buds. Please try again.";

                return;
            }

            if (error.response.status === 401) {
                this.loginErrorMsg =
                    "The username or password you entered is incorrect.";

                return;
            }

            this.loginErrorMsg =
                "Unable to sign in. Please try again.";
        },

        clearError() {
            this.loginError = false;
            this.loginErrorMsg =
                "Unable to sign in.";
        }
    }
};
</script>

<style scoped>
</style>