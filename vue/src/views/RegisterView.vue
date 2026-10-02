<!-- Register View Display -->
<template>

    <div
        id="register-view"
        class="auth-view"
        aria-labelledby="register-heading"
    >

        <!-- =================================================
             Registration Introduction
             ================================================= -->

        <header class="auth-header">

            <img
                :src="Logo"
                class="auth-logo"
                alt="Best Buds"
            />

            <p class="auth-eyebrow">
                Join Best Buds
            </p>

            <h1 id="register-heading">
                Create Your Account
            </h1>

            <p>
                Create an account to save dispensaries,
                personalize your experience, and collect
                Best Buds Drops as you explore.
            </p>

        </header>


        <!-- =================================================
             Registration Form
             ================================================= -->

        <RegisterForm
            @registered="
                handleRegistration
            "
        />

    </div>

</template>


<script>

import RegisterForm
    from "../components/auth/RegisterForm.vue";

import Logo
    from "../assets/layout/logo/logo-dark-theme.png";


export default {

    name: "RegisterView",

    components: {
        RegisterForm
    },

    data() {

        return {
            Logo
        };

    },

    methods: {

        // Continue to login after
        // successful registration
        handleRegistration() {

            this.$router.push({
                name: "login",
                query: {
                    registration: "success"
                }
            });

        }

    }

};

</script>


<style scoped>

</style>