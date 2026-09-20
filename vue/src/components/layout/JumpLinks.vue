<!-- View Jump Links Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="links-body">

        <!-- Display View Jump Links -->
        <section id="links">

            <!-- Display Top Arrow and Reference Top ID -->
            <div id="top-link"><a href="#top">Top<img :src="Up"/></a></div>

            <!-- Display Bottom Arrow and Reference Bottom ID -->
            <div id="bottom-link"><a href="#bottom"><img :src="Down"/>Bottom</a></div>

        </section>

    </body>

</template>

<script>
import Up from '../../assets/layout/jump_links/up.png';
import Down from '../../assets/layout/jump_links/down.png';

export default {
    name: "JumpLinks",

    data() {
        return {
            Up,
            Down
        }
    }
};
</script>

<style scoped>

</style>