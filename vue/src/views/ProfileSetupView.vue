<!-- Profile Setup View -->
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

        <ProfileSetupForm
            @profile-saved="handleProfileSaved"
        />
    </section>
</template>

<script>
import ProfileSetupForm from "../components/auth/ProfileSetupForm.vue";

import Logo from "../assets/layout/logo/logo-dark-theme.png";

export default {
    name: "ProfileSetupView",

    components: {
        ProfileSetupForm
    },

    data() {
        return {
            Logo
        };
    },

    methods: {

        // Store the completed profile and continue to Best Buds
        handleProfileSaved(profile) {
            this.$store.commit(
                "SET_PROFILE",
                profile
            );

            this.$router.push({
                name: "home"
            });
        }

    }
};
</script>

<style scoped>
</style>