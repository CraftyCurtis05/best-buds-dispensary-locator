<template>
    <div class="container">
        <div class="header-nav">
        <div class="header"><Header/></div>
        <div class="nav-bar"><NavBar/></div>
    </div>

    <div class="main-content">
        <div class="profile">
        <!-- Profile Picture -->
        <ProfilePicture :src="profilePictureSrc" />
        <div class="profile-picture">
        </div>

        <!-- Favorite Locations -->
        <div class="favorite-locations">
            <FavoriteLocations :locations="favoriteLocations" />
        </div>

        <!-- Profile Information -->
        <div class="profile-info">
            <ProfileInfo :profile="profile" />
        </div>
        </div>
    </div>

    <Footer class="footer"></Footer>
    </div>
</template>

<script>
import Footer from '../components/Footer.vue';
import Header from '../components/Header.vue';
import NavBar from '../components/NavBar.vue';
import ProfilePicture from '../components/ProfilePicture.vue';
import FavoriteLocations from '../components/FavoriteLocations.vue';
import ProfileInfo from '../components/ProfileInfo.vue';
import profilePictureSrc from '@/assets/LARRY!.webp';




export default {
    components: { Header, NavBar, Footer, ProfilePicture, FavoriteLocations, ProfileInfo  },
    name: "ProfileView",
    data() {
    return {
        // Example data (replace with actual data)
        profilePictureSrc: profilePictureSrc,
        favoriteLocations: ['Location 1', 'Location 2', 'Location 3'],
        profile: {
        name: 'John Doe',
        age: 30,
        email: 'johndoe@example.com',
          // Add more profile information fields as needed
        }
    };
    }
}
</script>

<style scoped>
#search-form{
    margin-top: 20px;
}
</style>