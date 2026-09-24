<template>
    <section
        id="profile-view"
        class="profile-view"
        aria-labelledby="profile-heading"
    >
        <!-- Profile introduction -->
        <header class="profile-header">
            <h1 id="profile-heading">
                Your Profile
            </h1>

            <p>
                Manage your personal information and personalize
                your Best Buds experience.
            </p>
        </header>

        <!-- Profile content -->
        <div class="profile-content">
            <aside
                class="profile-sidebar"
                aria-label="Profile picture"
            >
                <ProfilePicture />
            </aside>

            <div class="profile-main">
                <ProfileInfo />
            </div>
        </div>
    </section>
</template>

<script>
import ProfilePicture from "../components/profile/ProfilePicture.vue";
import ProfileInfo from "../components/profile/ProfileInfo.vue";

export default {
    name: "ProfileView",

    components: {
        ProfilePicture,
        ProfileInfo
    }
};
</script>

<style scoped>
</style>