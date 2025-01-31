<!-- Legality View Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Legality | Best Buds</title>

    <!-- Display Header Component -->  
    <header id="top">
        <Header/>
    </header>

    <!-- Display View Body -->
    <body id="legality-body">

        <!-- Display Body's Main Content -->
        <main id="legality-main">

            <!-- Display Body Title -->
            <h1>Cannabis Legality In Each State</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>🌿Ever wondered if your cannabis stash is legal or if you’re just a really optimistic rebel?🌿</h2>
                <p>States like California and Colorado are rolling out the green carpet for adults 21+, with legal shops and chill vibes. Many states have medical programs where patients get the green light with a doctor's thumbs-up. Some states have turned down the legal heat, making minor offenses more about a fine than a felony. States are dancing to their own beat, while federal rules are like the old-school DJ trying to keep things under control. In short, it’s a legal jamboree with states setting their own rules while federal law lingers in the background!</p>
                <h3>Click Interactive Map To View The Cannabis Laws In Each State!</h3>
            </section>

            <!-- Display Legality Inoformation -->
             <section id="legality">

                <!-- Display Interactive Legality Map Component -->
                <article id="map">
                    <LegalityMap/>
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
import LegalityMap from '@/components/legality_components/LegalityMap.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "LegalityView",
    components: { 
        Header,
        ViewJumpLinks,
        LegalityMap,
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
#legality-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#legality-main {
    margin: 4vw;
}

h1,
#summary {
    text-align: center;
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
</style>