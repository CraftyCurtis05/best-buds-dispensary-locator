<!-- Profile View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Profile | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>

    <!-- Display View Body -->
    <body id="profile-body">

        <!-- Display Body's Main Content -->
        <main id="profile-main">

            <!-- Display Body Title -->
            <h1>User Profile</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>🌿{{ this.profile.name }}'s' Go-To for Green Goodness!🌿</h2>
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

        <!-- Display Quote Component -->
        <div id="quote">
            <Quote/>
        </div>  

    </body>

    <!-- Display Footer Component -->
    <footer id="bottom">
        <Footer/>
    </footer>

</template>

<script>
import Header from '@/components/Header.vue';
import ViewJumpLinks from '@/components/ViewJumpLinks.vue';
import profilePictureSrc from '@/assets/LARRY!.webp';
import ProfilePicture from '@/components/profile_components/ProfilePicture.vue';
import Favorites from '@/components/favorite_components/FavoriteLocations.vue';
import ProfileInfo from '@/components/profile_components/ProfileInfo.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "Profile",
    components: {
        Header,
        ViewJumpLinks,
        ProfilePicture,
        Favorites,
        ProfileInfo,
        Quote,
        Footer
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
/* OBJECTS = rem */
/* SPACING = vw */
#profile-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#profile-main {
    margin: 4vw;
}

h1,
#summary {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}
</style>