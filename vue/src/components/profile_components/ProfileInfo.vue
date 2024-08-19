<!-- Profile Information Component Display--->
<template>

    <!-- Display Component Body -->
    <body id="profile-info-body">

        <!-- Display Title -->
        <h2>Profile Information</h2>

        <!-- Display User 'Name', 'Age', 'Email' -->
        <section id="profile-info">

            <p>Name: {{ profile.name }}</p>

            <p>Age: {{ profile.age }}</p>

            <p>Email: {{ profile.email }}</p>

        </section>

    </body>

</template>

<script>
// Export Component Properties of Profile Object and Mark as Required
export default { 
    props: {
        profile: {
            type: Object,
            required: true
        }
    }
};
</script>

<style scoped>
#profile-info-body {
    margin-top: 20px;
}

#profile-info-body div {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

#profile-info-body p {
    margin: 5px 0;
}
</style>
