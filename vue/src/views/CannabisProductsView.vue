<!-- Cannabis Products Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Which Products? | Best Buds</title>

    <!-- Display Header Component -->
    <header>
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="cannabis-products-body">

        <!-- Display Main Content -->
        <main id="cannabis-products-main">

            <!-- Display Page Title -->
            <h1>How To Choose Which Cannabis Product Is Right For You</h1>

            <!-- Display Page Summary -->
            <p>Choosing the right cannabis product is like picking your vibe! First choose the strain that is best for you, using our <router-link v-bind:to="{ name:'strainguide' }">strain guide</router-link>. Next consider how you want to consume—smoke, vape, or snack on an edible. Start with a low dose and see how it feels. Explore and find your perfect match! Below we have organized a pro and con list of each cannabis product that's out there.</p>

            <!-- Display Edibles Component -->
            <section id="edible">
                <Edible/>
            </section>

            <!-- Display Flower Component -->
            <section id="flower">
                <Flower/>
            </section>

            <!-- Display Oil Component -->
            <section id="oil">
                <Oil/>
            </section>

            <!-- Display Tincture Component -->
            <section id="tincture">
                <Tincture/>
            </section>

            <!-- Display Topical Component -->
            <section id="topical">
                <Topical/>
            </section>

            <!-- Display Wax Component -->
            <section id="wax">
                <Wax/>
            </section>

        </main>

        <!-- Display Strain Guide Visit Component -->
        <section id="strain-guide-visit">
            <StrainGuideVisit/>
        </section>
 
        <!-- Display Articles Visit Component -->
        <section id="articles-visit">
            <ArticlesVisit/>
        </section>

        <!-- Display Quote Component -->
        <div id="quote">
            <QuoteComponent/>
        </div> 

    </body>

     <!-- Display Footer Component -->
    <footer>
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import Edible from '@/components/products_components/Edible.vue';
import Flower from '@/components/products_components/Flower.vue';
import Oil from '@/components/products_components/Oil.vue';
import Tincture from '@/components/products_components/Tincture.vue';
import Topical from '@/components/products_components/Topical.vue';
import Wax from '@/components/products_components/Wax.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "CannabisProducts",
    components: { 
        Header, 
        Edible, 
        Flower, 
        Oil, 
        Tincture, 
        Topical, 
        Wax, 
        StrainGuideVisit, 
        ArticlesVisit, 
        QuoteComponent, 
        Footer 
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#cannabis-products-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#cannabis-products-main {
    margin: 4vw;
}

h1,
p,
#strain-guide-visit,
#articles-visit {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

p {
    margin: auto 8vw;
}
</style>