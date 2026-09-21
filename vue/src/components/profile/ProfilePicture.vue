<!-- Profile Picture Component Display --->
<template>

    <!-- Display Component Body -->
     <body id="picture-body">

        <!-- Display User Profile Picture -->
        <section id="picture">

            <img :src="DefaultUserImage" alt="image">

        </section>

    </body>

</template>

<script>
import DefaultUserImage from '../../assets/profile/default-user.webp';

export default {
    name: "ProfilePicture",

        data() {
        return {
            DefaultUserImage
        }
    },

    props: {
        src: {
            required: true
        }
    }
};
</script>

<style scoped>

</style>