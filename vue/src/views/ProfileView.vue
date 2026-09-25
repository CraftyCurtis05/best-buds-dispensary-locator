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
                Manage your information and personalize
                your Best Buds experience.
            </p>
        </header>

        <!-- Profile content -->
        <div class="profile-content">

            <!-- Profile image -->
            <aside
                class="profile-sidebar"
                aria-label="Profile picture"
            >
                <ProfileImage />
            </aside>

            <!-- Profile information -->
            <div class="profile-main">
                <ProfileInfo />
            </div>

        </div>

        <!-- Saved dispensaries -->
        <SavedDispensaries />

        <!-- My Stash -->
        <MyStash />
    </section>
</template>

<script>
import ProfileImage from "../components/profile/ProfileImage.vue";
import ProfileInfo from "../components/profile/ProfileInfo.vue";
import SavedDispensaries from "../components/dispensaries/SavedDispensaries.vue";
import MyStash from "../components/collectibles/MyStash.vue";

export default {
    name: "ProfileView",

    components: {
        ProfileImage,
        ProfileInfo,
        SavedDispensaries,
        MyStash
    }
};
</script>

<style scoped>
</style>