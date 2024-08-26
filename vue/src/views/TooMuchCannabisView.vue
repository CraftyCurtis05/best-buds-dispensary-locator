<!-- Too Much Cananbis Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Too Much? | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="too-much-body">

        <!-- Display Main Content -->
        <main id="too-much-main">

            <!-- Display Page Title -->
            <h1>What To Expect If You've Had Too Much Cannabis</h1>

            <!-- Display Page Jump Links -->
            <aside id="page-jump-links">
                <PageJumpLinks/>
            </aside>

            <!-- Display Page Summary -->
            <section id="page-summary">
                <h2>***NEED CATCHY PHRASE***</h2>
                <p>***NEED SUMMARY***</p>
            </section>

            <!-- Display Jump Links -->
            <section id="links">
                <div class="link"><a href="#symptoms">Signs and Symptoms</a></div>
                <div class="link"><a href="#coping">How to Cope</a></div>
                <div class="link"><a href="#what-to-do">What To Do</a></div>
            </section> 

            <!-- Display Too Much Symptoms Information -->
            <section id="symptoms">
                <Symptoms/>
            </section>

            <!-- Display Too Much Coping Information -->
            <section id="coping">
                <Coping/>
            </section>

            <!-- Display Too Much What To Do Information -->
            <section id="what-to-do">
                <WhatToDo/>
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
    <footer id="bottom">
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import PageJumpLinks from '@/components/PageJumpLinks.vue';
import Symptoms from '@/components/too_much_components/Symptoms.vue';
import Coping from '@/components/too_much_components/Coping.vue';
import WhatToDo from '@/components/too_much_components/WhatToDo.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "TooMuchCannabis",
    components: { 
        Header,
        PageJumpLinks,
        Symptoms,
        Coping,
        WhatToDo,
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
#too-much-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#too-much-main {
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

#page-summary {
    margin-bottom: 2vw;
}

h2 {
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
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

#strain-guide-visit,
#articles-visit {
    padding: 1vw;
}
</style>
