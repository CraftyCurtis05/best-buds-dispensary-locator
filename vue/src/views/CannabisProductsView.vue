<!-- Cannabis Products View Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Which Products? | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>

    <!-- Display View Body -->
    <body id="products-body">

        <!-- Display Body's Main Content -->
        <main id="products-main">

            <!-- Display Body Title -->
            <h1>Cannabis Products</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
             <section id="summary">
                <h2>🌿How To Choose Which Cannabis Product Is Right For You?🌿</h2>
                <p>Choosing the right cannabis product is like picking your vibe! First choose the strain that is best for you by using our <router-link v-bind:to="{ name:'strainguide' }">strain guide</router-link>. Next consider how you want to consume—smoke, vape, or snack on an edible. Start with a low dose and see how it feels. Explore and find your perfect match!</p>
                <h3>Check out all the different types of cannabis products below!</h3>
            </section>
            
            <!-- Display Body Jump Links -->
            <section id="links">
                <div class="link"><a href="#flower">Flower</a></div>
                <div class="link"><a href="#edible">Edibles</a></div>
                <div class="link"><a href="#wax">Wax</a></div>
                <div class="link"><a href="#oil">Oil</a></div>
                <div class="link"><a href="#tincture">Tinctures</a></div>
                <div class="link"><a href="#topical">Topicals</a></div>
            </section>

            <!-- Display Cannabis Products Information -->
            <section id="products">

                <!-- Display Flower Component -->
                <article id="flower">
                    <Flower/>
                </article>

                <!-- Display Edible Component -->
                <article id="edible">
                    <Edible/>
                </article>

                <!-- Display Wax Component -->
                <article id="wax">
                    <Wax/>
                </article>

                <!-- Display Oil Component -->
                <article id="oil">
                    <Oil/>
                </article>

                <!-- Display Tincture Component -->
                <article id="tincture">
                    <Tincture/>
                </article>

                <!-- Display Topical Component -->
                <article id="topical">
                    <Topical/>
                </article>

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
            <Quote/>
        </div> 

    </body>

     <!-- Display Footer Component -->
    <footer id="bottom">
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import ViewJumpLinks from '@/components/ViewJumpLinks.vue';
import Flower from '@/components/products_components/Flower.vue';
import Edible from '@/components/products_components/Edible.vue';
import Wax from '@/components/products_components/Wax.vue';
import Oil from '@/components/products_components/Oil.vue';
import Tincture from '@/components/products_components/Tincture.vue';
import Topical from '@/components/products_components/Topical.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "CannabisProductsView",
    components: { 
        Header,
        ViewJumpLinks, 
        Flower,
        Edible,
        Wax, 
        Oil, 
        Tincture, 
        Topical,  
        StrainGuideVisit, 
        ArticlesVisit, 
        Quote, 
        Footer 
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#products-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#products-main {
    margin: 4vw;
}

h1,
#summary {
    text-align: center;
}

h1 {
  font-size: 1.6rem;
}

#summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
}

#links {
    display: flex;
    flex-direction: row;
    justify-content: center;
}

.link {
    font-size: 1.2rem;
    font-weight: bolder;
    margin-inline: 1vw;
}

.link:hover {
    text-decoration: underline;
}
</style>