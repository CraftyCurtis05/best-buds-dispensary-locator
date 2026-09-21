<!-- View Jump Links Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="links-body">

        <!-- Display View Jump Links -->
        <section id="links">

            <!-- Display Top Arrow and Reference Top ID -->
            <div id="top-link"><a href="#top"><img :src="Up"/></a></div>

            <!-- Display Bottom Arrow and Reference Bottom ID -->
            <div id="bottom-link"><a href="#bottom"><img :src="Down"/></a></div>

        </section>

    </body>

</template>

<script>
import Up from '../../assets/layout/jump-links/up.png';
import Down from '../../assets/layout/jump-links/down.png';

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