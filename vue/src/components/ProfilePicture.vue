<!-- User Profile Picture Component Display--->
<template>

    <!-- Display user profile picture; Allow user to upload image and save on profile-->
    <div class="profile-picture">
        <img :src="src" alt="Profile Picture">
    </div>

</template>

<script>

//Export component properties of profile picture "" and mark as required
export default {
    props: {
        src: {
            type: String,
            required: true
        }
    }
};
</script>

<style scoped>
.profile-picture {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    overflow: hidden;
}

.profile-picture img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>