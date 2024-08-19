<!-- Profile Picture Component Display --->
<template>

    <!-- Display Component Body -->
     <body id="profile-picture-body">

        <!-- Display User Profile Picture -->
        <section id="profile-picture">
            <img :src="src" alt="profile-pic">
        </section>

    </body>

</template>

<script>
export default {
    props: {
        src: {
            required: true
        }
    }
};
</script>

<style scoped>
#profile-picture {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    overflow: hidden;
}

#profile-picture img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>