<!-- Logout Page NOT Displayed -->
<template>

  <!-- Browser Tab Title -->
  <title>Logout | Best Buds</title>

  <body class="logout-view">
    <h1>Logout</h1>
  </body> 

</template>

<script>
export default {
  name: "Logout",
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>