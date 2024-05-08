<template>
    <div class="profile-info">
    <h2>Profile Information</h2>
    <div>
        <p><strong>Name:</strong> {{ profile.name }}</p>
        <p><strong>Age:</strong> {{ profile.age }}</p>
        <p><strong>Email:</strong> {{ profile.email }}</p>
    </div>
    </div>
</template>

<script>
export default {
    props: {
    profile: {
        type: Object,
        required: true
    }
    }
}
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
