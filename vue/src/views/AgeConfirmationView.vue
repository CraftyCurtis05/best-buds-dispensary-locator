<!-- Age Confirmation View Display -->
<template>

    <div
        id="age-confirmation-view"
        class="auth-view"
        aria-labelledby="age-confirmation-heading"
    >

        <!-- Display Page Introduction -->
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
                Best Buds is intended for adults
                21 years of age or older.
            </p>

        </header>

        <!-- Display Age Confirmation -->
        <div class="auth-form-section">

            <div class="age-confirmation-content">

                <p>
                    Please confirm that you are at least
                    21 years old before continuing.
                </p>

                <p>
                    You must confirm your age before you
                    can enter Best Buds, log in, or create
                    an account.
                </p>

                <!-- Display Age Restriction Message -->
                <p
                    v-if="ageRestricted"
                    class="form-error"
                    role="alert"
                >
                    Best Buds is intended for adults
                    21 years of age or older.
                </p>

                <!-- Display Confirmation Actions -->
                <div class="age-confirmation-actions">

                    <button
                        type="button"
                        @click="confirmVisitorAge"
                    >
                        Yes, I Am 21 or Older
                    </button>

                    <button
                        type="button"
                        @click="denyAccess"
                    >
                        No, I Am Under 21
                    </button>

                </div>

            </div>

        </div>

    </div>

</template>

<script>
import Logo from "../assets/layout/logo/logo-dark-theme.png";

export default {
    name: "AgeConfirmationView",

    data() {
        return {
            Logo,
            ageRestricted: false
        };
    },

    methods: {

        // Confirm that the visitor meets the age requirement
        confirmVisitorAge() {

            sessionStorage.setItem(
                "best-buds-age-confirmed",
                "true"
            );

            this.ageRestricted = false;

            this.continueToBestBuds();

        },

        // Continue to the appropriate Best Buds page
        continueToBestBuds() {

            if (this.$store.state.token !== "") {
                this.$router.replace({
                    name: "home"
                });

                return;
            }

            this.$router.replace({
                name: "login"
            });

        },

        // Keep underage visitors outside of the application
        denyAccess() {

            sessionStorage.removeItem(
                "best-buds-age-confirmed"
            );

            this.ageRestricted = true;

        }

    }
};
</script>

<style scoped>

</style>