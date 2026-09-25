<!-- Login View -->
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

        <LoginForm
            :registration-successful="registrationSuccessful"
            @authenticated="handleAuthentication"
        />
    </section>
</template>

<script>
import LoginForm from "../components/auth/LoginForm.vue";

import profileService from "../services/ProfileService.js";

import Logo from "../assets/layout/logo/logo-dark-theme.png";

export default {
    name: "LoginView",

    components: {
        LoginForm
    },

    data() {
        return {
            Logo
        };
    },

    computed: {

        // Check whether the user just created an account
        registrationSuccessful() {
            return this.$route.query.registration === "success";
        }

    },

    methods: {

        // Store the user session and continue onboarding
        handleAuthentication(loginResponse) {
            this.saveUserSession(
                loginResponse
            );

            return this.continueOnboarding(
                loginResponse.user
            );
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
        }

    }
};
</script>

<style scoped>
</style>