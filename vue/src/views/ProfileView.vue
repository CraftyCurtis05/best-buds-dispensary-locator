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
                    <ProfilePicture :src="profilePictureSrc"/>
                </article>

                <!-- Display User's Favorite Locations Component -->
                <article id="profile-favorites">
                    <Favorites :locations="favoriteLocations"/>
                </article>

                <!-- Display User Information Component -->
                <article id="profile-info">
                    <ProfileInfo :profile="profile"/>
                </article>

            </section>

        </main>

    </body>

</template>

<script>
import profilePictureSrc from '../assets/profile/default.webp';
import ProfilePicture from '../components/profile/Picture.vue';
import Favorites from '../components/profile/favorite/Dispensaries.vue';
import ProfileInfo from '../components/profile/Details.vue';

export default {
    name: "ProfileView",

    components: {
        ProfilePicture,
        Favorites,
        ProfileInfo
    },

    data() {
        return {
            profilePictureSrc: profilePictureSrc,
            favoriteLocations: ['Location 1', 'Location 2', 'Location 3'],
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