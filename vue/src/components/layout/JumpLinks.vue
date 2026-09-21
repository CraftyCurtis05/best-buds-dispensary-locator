<!-- View Jump Links Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="links-body">

        <!-- Display View Jump Links -->
        <section id="links">

            <!-- Display Top Arrow and Reference Top ID -->
            <div id="top-link"><a href="#top"><img :src="UpArrow"/></a></div>

            <!-- Display Bottom Arrow and Reference Bottom ID -->
            <div id="bottom-link"><a href="#bottom"><img :src="DownArrow"/></a></div>

        </section>

    </body>

</template>

<script>
import UpArrow from '../../assets/layout/jump-links/up-arrow.png';
import DownArrow from '../../assets/layout/jump-links/down-arrow.png';

export default {
    name: "JumpLinks",

    data() {
        return {
            UpArrow,
            DownArrow
        }
    }
};
</script>

<style scoped>
#links-body {
    position: fixed;
    margin-left: 90%;
}

#links-body img {
    width: 2rem;
    height: 1.5rem;
}

</style>