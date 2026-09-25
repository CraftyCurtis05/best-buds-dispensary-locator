<template>
    <section
        id="account-settings-view"
        class="account-settings-view"
        aria-labelledby="account-settings-heading"
    >
        <!-- Account settings introduction -->
        <header class="account-settings-header">
            <h1 id="account-settings-heading">
                Account Settings
            </h1>

            <p>
                Manage your username, email address,
                and password.
            </p>
        </header>

        <!-- Loading state -->
        <p
            v-if="isLoading"
            role="status"
        >
            Loading account settings...
        </p>

        <!-- Account settings -->
        <div
            v-else-if="accountLoaded"
            class="account-settings-content"
        >

            <!-- Username settings -->
            <section
                class="account-settings-section"
                aria-labelledby="username-settings-heading"
            >
                <h2 id="username-settings-heading">
                    Username
                </h2>

                <p>
                    Current username:
                    <strong>{{ account.username }}</strong>
                </p>

                <form @submit.prevent="updateUsername">
                    <div>
                        <label for="username">
                            New Username
                        </label>

                        <input
                            id="username"
                            v-model.trim="usernameForm.username"
                            type="text"
                            autocomplete="username"
                            minlength="3"
                            maxlength="50"
                            required
                        />
                    </div>

                    <div>
                        <label for="username-current-password">
                            Current Password
                        </label>

                        <input
                            id="username-current-password"
                            v-model="usernameForm.currentPassword"
                            type="password"
                            autocomplete="current-password"
                            required
                        />
                    </div>

                    <p
                        v-if="usernameMessage"
                        role="status"
                    >
                        {{ usernameMessage }}
                    </p>

                    <p
                        v-if="usernameError"
                        role="alert"
                    >
                        {{ usernameError }}
                    </p>

                    <button
                        type="submit"
                        :disabled="isUpdatingUsername"
                    >
                        {{
                            isUpdatingUsername
                                ? "Updating..."
                                : "Update Username"
                        }}
                    </button>
                </form>
            </section>

            <!-- Email settings -->
            <section
                class="account-settings-section"
                aria-labelledby="email-settings-heading"
            >
                <h2 id="email-settings-heading">
                    Email
                </h2>

                <p>
                    Current email:
                    <strong>{{ account.email }}</strong>
                </p>

                <form @submit.prevent="updateEmail">
                    <div>
                        <label for="email">
                            New Email
                        </label>

                        <input
                            id="email"
                            v-model.trim="emailForm.email"
                            type="email"
                            autocomplete="email"
                            maxlength="254"
                            required
                        />
                    </div>

                    <div>
                        <label for="email-current-password">
                            Current Password
                        </label>

                        <input
                            id="email-current-password"
                            v-model="emailForm.currentPassword"
                            type="password"
                            autocomplete="current-password"
                            required
                        />
                    </div>

                    <p
                        v-if="emailMessage"
                        role="status"
                    >
                        {{ emailMessage }}
                    </p>

                    <p
                        v-if="emailError"
                        role="alert"
                    >
                        {{ emailError }}
                    </p>

                    <button
                        type="submit"
                        :disabled="isUpdatingEmail"
                    >
                        {{
                            isUpdatingEmail
                                ? "Updating..."
                                : "Update Email"
                        }}
                    </button>
                </form>
            </section>

            <!-- Password settings -->
            <section
                class="account-settings-section"
                aria-labelledby="password-settings-heading"
            >
                <h2 id="password-settings-heading">
                    Password
                </h2>

                <p>
                    Change your password using your
                    current password.
                </p>

                <form @submit.prevent="updatePassword">
                    <div>
                        <label for="current-password">
                            Current Password
                        </label>

                        <input
                            id="current-password"
                            v-model="passwordForm.currentPassword"
                            type="password"
                            autocomplete="current-password"
                            required
                        />
                    </div>

                    <div>
                        <label for="new-password">
                            New Password
                        </label>

                        <input
                            id="new-password"
                            v-model="passwordForm.newPassword"
                            type="password"
                            autocomplete="new-password"
                            minlength="8"
                            maxlength="100"
                            required
                        />
                    </div>

                    <div>
                        <label for="confirm-password">
                            Confirm New Password
                        </label>

                        <input
                            id="confirm-password"
                            v-model="passwordForm.confirmPassword"
                            type="password"
                            autocomplete="new-password"
                            required
                        />
                    </div>

                    <p
                        v-if="passwordMessage"
                        role="status"
                    >
                        {{ passwordMessage }}
                    </p>

                    <p
                        v-if="passwordError"
                        role="alert"
                    >
                        {{ passwordError }}
                    </p>

                    <button
                        type="submit"
                        :disabled="isUpdatingPassword"
                    >
                        {{
                            isUpdatingPassword
                                ? "Updating..."
                                : "Update Password"
                        }}
                    </button>
                </form>
            </section>

        </div>

        <!-- Account loading error -->
        <p
            v-else-if="accountError"
            role="alert"
        >
            {{ accountError }}
        </p>
    </section>
</template>

<script>
import AccountService from "../services/AccountService";

export default {
    name: "AccountSettingsView",

    data() {
        return {
            account: {
                username: "",
                email: ""
            },

            accountLoaded: false,
            accountError: "",
            isLoading: true,

            usernameForm: {
                username: "",
                currentPassword: ""
            },

            emailForm: {
                email: "",
                currentPassword: ""
            },

            passwordForm: {
                currentPassword: "",
                newPassword: "",
                confirmPassword: ""
            },

            usernameMessage: "",
            usernameError: "",
            emailMessage: "",
            emailError: "",
            passwordMessage: "",
            passwordError: "",

            isUpdatingUsername: false,
            isUpdatingEmail: false,
            isUpdatingPassword: false
        };
    },

    created() {
        this.loadAccount();
    },

    methods: {

        // Load the authenticated user's account information
        async loadAccount() {
            this.isLoading = true;
            this.accountError = "";

            try {
                const response =
                    await AccountService.getAccount();

                this.account = response.data;
                this.usernameForm.username =
                    response.data.username;
                this.emailForm.email =
                    response.data.email;

                this.accountLoaded = true;

            } catch (error) {
                this.accountLoaded = false;
                this.accountError =
                    this.getErrorMessage(
                        error,
                        "Unable to load your account settings."
                    );

            } finally {
                this.isLoading = false;
            }
        },

        // Update the authenticated user's username
        async updateUsername() {
            this.usernameMessage = "";
            this.usernameError = "";
            this.isUpdatingUsername = true;

            try {
                const response =
                    await AccountService.updateUsername(
                        this.usernameForm.username,
                        this.usernameForm.currentPassword
                    );

                this.account.username =
                    response.data.username;

                this.usernameForm.currentPassword = "";

                if (response.data.reauthenticationRequired) {
                    this.usernameMessage =
                        "Your username was updated. "
                        + "Please sign in again.";

                    this.$store.commit("LOGOUT");

                    this.$router.push({
                        name: "login",
                        query: {
                            accountUpdated: "username"
                        }
                    });

                    return;
                }

                this.usernameMessage =
                    "Your username is already up to date.";

            } catch (error) {
                this.usernameError =
                    this.getErrorMessage(
                        error,
                        "Unable to update your username."
                    );

            } finally {
                this.isUpdatingUsername = false;
            }
        },

        // Update the authenticated user's email
        async updateEmail() {
            this.emailMessage = "";
            this.emailError = "";
            this.isUpdatingEmail = true;

            try {
                const response =
                    await AccountService.updateEmail(
                        this.emailForm.email,
                        this.emailForm.currentPassword
                    );

                this.account.email =
                    response.data.email;

                this.emailForm.email =
                    response.data.email;

                this.emailForm.currentPassword = "";

                this.emailMessage =
                    "Your email was updated successfully.";

            } catch (error) {
                this.emailError =
                    this.getErrorMessage(
                        error,
                        "Unable to update your email."
                    );

            } finally {
                this.isUpdatingEmail = false;
            }
        },

        // Update the authenticated user's password
        async updatePassword() {
            this.passwordMessage = "";
            this.passwordError = "";

            if (
                this.passwordForm.newPassword
                !== this.passwordForm.confirmPassword
            ) {
                this.passwordError =
                    "New passwords do not match.";

                return;
            }

            this.isUpdatingPassword = true;

            try {
                await AccountService.updatePassword(
                    this.passwordForm.currentPassword,
                    this.passwordForm.newPassword,
                    this.passwordForm.confirmPassword
                );

                this.passwordForm.currentPassword = "";
                this.passwordForm.newPassword = "";
                this.passwordForm.confirmPassword = "";

                this.passwordMessage =
                    "Your password was updated successfully.";

            } catch (error) {
                this.passwordError =
                    this.getErrorMessage(
                        error,
                        "Unable to update your password."
                    );

            } finally {
                this.isUpdatingPassword = false;
            }
        },

        // Use the backend message when one is available
        getErrorMessage(error, fallbackMessage) {
            const responseData =
                error.response?.data;

            if (typeof responseData === "string") {
                return responseData;
            }

            if (
                responseData
                && typeof responseData.message === "string"
            ) {
                return responseData.message;
            }

            return fallbackMessage;
        }
    }
};
</script>

<style scoped>
</style>