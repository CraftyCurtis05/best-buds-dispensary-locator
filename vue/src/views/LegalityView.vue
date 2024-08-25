<!-- Legality Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Legality | Best Buds</title>

    <!-- Display Header Component -->  
    <header>
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="legality-body">

        <!-- Display Main Content -->
        <main id="legality-main">

            <!-- Display Page Title -->
            <h1>Quick Guide to the Laws in Each State</h1>

            <!-- Display Page Summary -->
            <p>States like California and Colorado are rolling out the green carpet for adults 21+, with legal shops and chill vibes. Many states have medical programs where patients get the green light with a doctor's thumbs-up. Some states have turned down the legal heat, making minor offenses more about a fine than a felony. States are dancing to their own beat, while federal rules are like the old-school DJ trying to keep things under control. In short, it’s a legal jamboree with states setting their own rules while federal law lingers in the background!</p>

            <!-- Display Interactive Legality Map Component -->
            <section id="legality-map">
                <LegalityMap/>
            </section>

        </main>

        <!-- Display Strain Guide Link -->
        <section id="strain-guide-visit">
            <StrainGuideVisit/>
        </section>
 
        <!-- Display Want More Info with Articles Link -->
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
import LegalityMap from '@/components/legality_components/LegalityMap.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "Legality",
    components: { 
        Header,
        LegalityMap,
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
h2,
p,
#strain-guide-visit,
#articles-visit {
    text-align: center;
}

h1 {
    font-size: 1.6rem;
}

h2 {
    font-size: 1.3rem;
    padding-top: 2rem;
}

p {
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
    margin-bottom: 0vw;
}

ul {
    font-size: 1.15rem;
}

li {
    padding: .15vw;
}

h4,
h5 {
    font-size: 1rem;
    margin: .1vw;
}

#strain-guide-visit,
#articles-visit {
    padding: 1vw;
}
</style>