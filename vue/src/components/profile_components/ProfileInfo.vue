<!-- Profile Information Component Display--->
<template>

    <!-- Display Component Body -->
    <body id="info-body">

        <!-- Display Title -->
        <h1>Profile Information</h1>

        <!-- Display User 'Name', 'Age', 'Email' -->
        <section id="info">

            <h2 id="name">Name: {{ profile.name }}</h2>

            <h2 id="age">Age: {{ profile.age }}</h2>

            <h2 id="email">Email: {{ profile.email }}</h2>

        </section>

    </body>

</template>

<script>
// Export Component Properties of Profile Object and Mark as Required
export default { 
    name: "ProfileInfo",
    props: {
        profile: {
            type: Object,
            required: true
        }
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
body {
    margin-top: 20px;
}

#info {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

h1 {
    margin: 5px 0;
}
</style>
