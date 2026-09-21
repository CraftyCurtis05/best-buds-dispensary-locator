<!-- Profile View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Profile | Best Buds</title>

    <!-- Display View Body -->
    <body id="profile-body">

        <!-- Display Body's Main Content -->
        <main id="profile-main">

            <!-- Display Body Title -->
            <h1>User Profile</h1>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>{{ this.profile.name }}'s' Go-To for Green Goodness!</h2>
                <p>Your favorite spots? They're like secret hideouts for top-shelf buds and legendary vibes. Let's roll and explore the finest herb together! We've gathered all your favorites in one place.</p>
                <h3>Below is a list of your favorited dispensaries!</h3>
            </section>

            <!-- Display Profile Information -->
            <section id="profile">

                <!-- Display User Picture Component -->
                <article id="profile-picture">
                    <ProfilePicture :src="DefaultUserImage" />
                </article>

                <!-- Display User Information Component -->
                <article id="profile-info">
                    <ProfileInfo :profile="profile" />
                </article>

            </section>

        </main>

    </body>

</template>

<script>
import ProfilePicture from '../components/profile/ProfilePicture.vue';
import ProfileInfo from '../components/profile/ProfileInfo.vue';

export default {
    name: "ProfileView",

    components: {
        ProfilePicture,
        ProfileInfo
    },

    data() {
        return {
            profile: {
                name: 'John Doe',
                age: 30,
                email: 'johndoe@example.com'
            }
        };
    }
};
</script>

<style scoped>

</style>