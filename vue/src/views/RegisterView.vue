<!-- Register View -->
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

        <RegisterForm
            @registered="handleRegistration"
        />
    </section>
</template>

<script>
import RegisterForm from "../components/auth/RegisterForm.vue";

import Logo from "../assets/layout/logo/logo-dark-theme.png";

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

        // Continue to login after successful registration
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