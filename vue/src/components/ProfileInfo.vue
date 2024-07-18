<!-- User Profile Information Component Display--->
<template>

    <!-- Display profile information -->
    <div class="profile-info">
        <h2>Profile Information</h2>

        <!-- Display user 'Name', 'Age', 'Email' -->
        <div>
            <p>Name: {{ profile.name }}</p>
            <p>Age: {{ profile.age }}</p>
            <p>Email: {{ profile.email }}</p>
        </div>

    </div>
</template>

<script>

//Export component properties of profile object and mark as required
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
.profile-info {
    margin-top: 20px;
}

.profile-info div {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.profile-info p {
    margin: 5px 0;
}
</style>
