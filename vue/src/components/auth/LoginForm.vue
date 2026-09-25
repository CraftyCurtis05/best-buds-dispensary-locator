<!-- Login Form -->
<template>
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
</template>

<script>
import authService from "../../services/AuthService.js";

export default {
    name: "LoginForm",

    props: {
        registrationSuccessful: {
            type: Boolean,
            default: false
        }
    },

    emits: [
        "authenticated"
    ],

    data() {
        return {
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

    methods: {

        // Sign in the user
        login() {
            this.clearError();
            this.isSubmitting = true;

            authService
                .login(this.user)
                .then((response) => {
                    if (response.status === 200) {
                        this.$emit(
                            "authenticated",
                            response.data
                        );
                    }
                })
                .catch((error) => {
                    this.handleLoginError(error);
                })
                .finally(() => {
                    this.isSubmitting = false;
                });
        },

        // Show an appropriate login error
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

        // Clear the current login error
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