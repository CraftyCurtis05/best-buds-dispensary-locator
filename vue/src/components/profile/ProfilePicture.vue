<!-- Profile Picture Component Display --->
<template>

    <!-- Display Component Body -->
     <body id="picture-body">

        <!-- Display User Profile Picture -->
        <section id="picture">

            <img :src="src" alt="image">

        </section>

    </body>

</template>

<script>
import Default from '../../assets/profile/default.png';

export default {
    name: "ProfilePicture",

        data() {
        return {
            Default
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