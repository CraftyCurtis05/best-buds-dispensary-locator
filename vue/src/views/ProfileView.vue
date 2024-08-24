<!-- Profile Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Profile | Best Buds</title>

    <!-- Display Header Component -->
    <header>
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="profile-body">

        <!-- Display Main Content -->
        <main id="profile-main">

            <!-- Display Page Title -->
            <h1>***NEEDS A PAGE TITLE***</h1>

            <!-- Display User Picture -->
            <section id="profile-picture">
                <ProfilePictureComponent :src="profilePictureSrc"/>
            </section>

            <!-- Display User's Favorite Locations -->
            <section id="profile-favorites">
                <FavoritesComponent :locations="favoriteLocations"/>
            </section>

            <!-- Display User Information -->
            <section id="profile-info">
                <ProfileInfoComponent :profile="profile"/>
            </section>

        </main>

        <!-- Display Quote Component -->
        <div id="quote">
            <QuoteComponent/>
        </div>  

    </body>

    <!-- Display Footer Component -->
    <footer>
        <Footer/>
    </footer>

</template>

<script>
import Header from '@/components/Header.vue';
import profilePictureSrc from '@/assets/LARRY!.webp';
import ProfilePictureComponent from '@/components/profile_components/ProfilePicture.vue';
import FavoritesComponent from '@/components/favorite_components/FavoriteLocations.vue';
import ProfileInfoComponent from '@/components/profile_components/ProfileInfo.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "Profile",
    components: { 
        Header, 
        ProfilePictureComponent, 
        FavoritesComponent, 
        ProfileInfoComponent, 
        QuoteComponent, 
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

h1 {
    text-align: center;
    font-size: 1.6rem;
}
</style>