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
export default {
    name: "ProfilePicture",
    props: {
        src: {
            required: true
        }
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#picture {
    width: 150px;
    height: 150px;
    border-radius: 50%;
    overflow: hidden;
}

img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>