<template>
    <section
        id="register-view"
        class="auth-view"
        aria-labelledby="register-heading"
    >
        <!-- Best Buds branding -->
        <header class="auth-header">
            <img
                :src="Logo"
                class="auth-logo"
                alt="Best Buds"
            />

            <h1 id="register-heading">
                Create Account
            </h1>

            <p>
                Create your Best Buds account to get started.
            </p>
        </header>

        <!-- Account registration form -->
        <section
            id="register-form"
            class="auth-form-section"
            aria-label="Account registration"
        >
            <form
                class="auth-form"
                @submit.prevent="register"
            >
                <!-- Registration error -->
                <p
                    v-if="registrationErrors"
                    class="form-error"
                    role="alert"
                >
                    {{ registrationErrorMsg }}
                </p>

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
                        @input="clearErrors"
                    />
                </div>

                <!-- Email -->
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
                        autocomplete="new-password"
                        minlength="8"
                        required
                        @input="clearErrors"
                    />
                </div>

                <!-- Confirm password -->
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

                <button
                    type="submit"
                    :disabled="isSubmitting"
                >
                    {{ isSubmitting ? 'Creating Account...' : 'Create Account' }}
                </button>
            </form>

            <p class="auth-link">
                Already have an account?
                <router-link :to="{ name: 'login' }">
                    Log in.
                </router-link>
            </p>
        </section>
    </section>
</template>

<script>
import authService from '../services/AuthService.js';
import Logo from '../assets/layout/logo/logo-dark-theme.png';

export default {
    name: 'RegisterView',

    data() {
        return {
            Logo,

            user: {
                username: '',
                email: '',
                password: '',
                confirmPassword: ''
            },

            registrationErrors: false,
            registrationErrorMsg: 'There were problems creating your account.',
            isSubmitting: false
        };
    },

    methods: {
        register() {
            this.clearErrors();

            if (this.user.password !== this.user.confirmPassword) {
                this.registrationErrors = true;
                this.registrationErrorMsg =
                    'Password and Confirm Password do not match.';

                return;
            }

            this.isSubmitting = true;

            authService
                .register(this.user)
                .then((response) => {
                    if (response.status === 201) {
                        this.$router.push({
                            name: 'login',
                            query: {
                                registration: 'success'
                            }
                        });
                    }
                })
                .catch((error) => {
                    this.handleRegistrationError(error);
                })
                .finally(() => {
                    this.isSubmitting = false;
                });
        },

        handleRegistrationError(error) {
            this.registrationErrors = true;

            if (!error.response) {
                this.registrationErrorMsg =
                    'Unable to connect to Best Buds. Please try again.';

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
                    'That username or email is already in use.';

                return;
            }

            this.registrationErrorMsg =
                'There were problems creating your account. Please try again.';
        },

        getValidationErrorMessage(responseData) {
            if (typeof responseData === 'string'
                    && responseData.trim()) {
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

            return 'Please check your registration information and try again.';
        },

        clearErrors() {
            this.registrationErrors = false;
            this.registrationErrorMsg =
                'There were problems creating your account.';
        }
    }
};
</script>

<style scoped>
</style>