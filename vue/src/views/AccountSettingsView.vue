<!-- Account Settings View Display -->
<template>

    <div
        id="account-settings-view"
        class="account-settings-view"
        aria-labelledby="account-settings-heading"
    >

        <!-- Display Page Introduction -->
        <header class="account-settings-header">

            <h1 id="account-settings-heading">
                Account Settings
            </h1>

            <p>
                Manage your username, email address,
                and password.
            </p>

        </header>

        <!-- Display Account Settings -->
        <AccountSettingsForm />

    </div>

</template>

<script>
import AccountSettingsForm
    from "../components/account/AccountSettingsForm.vue";

export default {
    name: "AccountSettingsView",

    components: {
        AccountSettingsForm
    }
};
</script>

<style scoped>

</style>