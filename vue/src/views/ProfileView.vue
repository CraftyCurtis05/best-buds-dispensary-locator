<!-- Profile View Display -->
<template>

    <div
        id="profile-view"
        class="profile-view"
        aria-labelledby="profile-heading"
    >

        <!-- Display Page Introduction -->
        <header class="profile-header">

            <h1 id="profile-heading">
                Your Profile
            </h1>

            <p>
                Manage your information and personalize
                your Best Buds experience.
            </p>

        </header>

        <!-- Display Profile Details -->
        <section
            id="profile-details"
            aria-labelledby="profile-details-heading"
        >

            <h2 id="profile-details-heading">
                Profile Details
            </h2>

            <div class="profile-content">

                <!-- Display Profile Image -->
                <div class="profile-sidebar">
                    <ProfileImage />
                </div>

                <!-- Display Profile Information -->
                <div class="profile-main">
                    <ProfileInfo />
                </div>

            </div>

        </section>

        <!-- Display Saved Dispensaries -->
        <section
            id="saved-dispensaries"
            aria-labelledby="saved-dispensaries-heading"
        >

            <h2 id="saved-dispensaries-heading">
                Saved Dispensaries
            </h2>

            <SavedDispensaries />

        </section>

        <!-- Display My Stash -->
        <section
            id="my-stash"
            aria-labelledby="my-stash-heading"
        >

            <h2 id="my-stash-heading">
                My Stash
            </h2>

            <MyStash />

        </section>

    </div>

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