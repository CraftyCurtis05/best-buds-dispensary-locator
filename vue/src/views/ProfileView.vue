<!-- Profile Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Profile | Best Buds</title>


    <header>
        <!-- Display Header Component -->
        <Header/>
    </header>

    <!-- Display Profile Information -->
    <body class="profile-view">

        <!-- Display Profile Picture -->
        <div class="profile-picture">
            <ProfilePicture :src="profilePictureSrc" />
        </div>

        <!-- Display Favorite Locations -->
        <div class="favorite-locations">
            <FavoriteLocations :locations="favoriteLocations" />
        </div>

        <!-- Display Profile Information -->
        <div class="profile-info">
            <ProfileInfo :profile="profile" />
        </div>

        <!-- Display Page Quote -->
        <h6>***NEED QUOTE***</h6> 
    </body>

    <footer>
        <!-- Display Footer Component -->
        <Footer />
    </footer> 

</template>

<script>
import Footer from '../components/Footer.vue';
import Header from '../components/Header.vue';
import ProfilePicture from '../components/profile_components/ProfilePicture.vue';
import FavoriteLocations from '../components/favorite_components/FavoriteLocations.vue';
import ProfileInfo from '../components/profile_components/ProfileInfo.vue';
import profilePictureSrc from '@/assets/LARRY!.webp';

export default {
    name: "profile",
    components: { Header, Footer, ProfilePicture, FavoriteLocations, ProfileInfo  },
    data() {
        return {
            profilePictureSrc: profilePictureSrc,
            favoriteLocations: ['Location 1', 'Location 2', 'Location 3'],
            profile: {
                name: 'John Doe',
                age: 30,
                email: 'johndoe@example.com',
            }
        };
    }
}
</script>

<style scoped>
.profile-view {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

.profile-picture,
.favorite-locations,
.profile-info {
    margin-left: 2vw;
}

.profile-picture {
    margin: 3vw;
}

h6 {
    text-align: center;
  font-size: .9em;
  font-style: italic;
  font-weight: lighter;
  margin-bottom: 1vw;
}
</style>