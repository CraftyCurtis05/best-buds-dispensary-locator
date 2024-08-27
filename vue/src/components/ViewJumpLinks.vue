<!-- View Jump Links Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="links-body">

        <!-- Display View Jump Links -->
        <section id="links">

            <!-- Display Top Arrow and Reference Top ID -->
            <div id="top-link"><a href="#top">Top<img src="@\assets\arrow_assets\top_arrow.png"/></a></div>

            <!-- Display Bottom Arrow and Reference Bottom ID -->
            <div id="bottom-link"><a href="#bottom"><img src="@\assets\arrow_assets\bottom_arrow.png"/>Bottom</a></div>

        </section>

    </body>

</template>

<script>
export default {
    name: "ViewJumpLinks"
};
</script>

<style scoped>
#links {
    position: fixed;
    display: flex;
    flex-direction: column;
    text-align: center;
    font-size: .9vw;
    margin-inline: 90vw;
    margin-block: 3vw;
}

#links:hover {
    cursor: url('best_buds_logo_icon.ico'), pointer;
}

a {
    color: black;
    text-decoration: none;
}

img {
    width: 3vw;
    height: auto;
    opacity: 60%;
}
</style>