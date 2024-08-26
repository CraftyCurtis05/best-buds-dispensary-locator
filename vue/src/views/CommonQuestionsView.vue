<!-- Common Questions Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Questions | Best Buds</title>

    <!-- Display Header Component -->    
    <header id="top">
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="questions-body">

        <!-- Display Common Questions Main Content -->
        <main id="questions-main">

            <!-- Display Page Title -->
            <h1>Commonly Asked Questions About Cannabis</h1>

            <!-- Display Page Summary -->
            <section id="page-summary">
                <h2>🌿Got cannabis questions? No worries!🌿</h2>
                <p>Whether you're curious about legality, how it works, or the best ways to use it, the plant’s got answers. From getting high or just chilling with CBD, to understanding health impacts and legal stuff, dive in and explore. We've got all your questions answered below, just navigate to a topic by selecting a topic below.</p>
                <p>Stay informed, use responsibly, and enjoy the journey!</p>
            </section>

            <!-- Display Jump Links -->
             <section id="links">
                <div class="link"><a href="#dispensaries-qa">Dispensaries</a></div>
                <div class="link"><a href="#cannabis-qa">Cannabis</a></div>
                <div class="link"><a href="#cbd-qa">CBD</a></div>
                <div class="link"><a href="#delta9-qa">Delta-9</a></div>
                <div class="link"><a href="#flower-qa">Flower</a></div>
                <div class="link"><a href="#wax-qa">Wax</a></div>
                <div class="link"><a href="#oil-qa">Oil</a></div>
                <div class="link"><a href="#tincture-qa">Tincture</a></div>
                <div class="link"><a href="#smoking-qa">Smoking</a></div>
                <div class="link"><a href="#vaporizing-qa">Vaporizing</a></div>
                <div class="link"><a href="#edibles-qa">Edibles</a></div>
                <div class="link"><a href="#topicals-qa">Topicals</a></div>
             </section>

             <!-- Display Page Jump Links -->
             <aside id="page-jump-links">
                <PageJumpLinks/>
             </aside>

            <!-- Display Qustions and Answers Components Information-->
            <section id="dispensaries-qa">
                <DispensariesQA/>
            </section>

            <section id="cannabis-qa">
                <CannabisQA/>
            </section>

            <section id="cbd-qa">
                <CBDQA/>
            </section>

            <section id="delta9-qa">
                <Delta9QA/>
            </section>

            <section id="flower-qa">
                <FlowerQA/>
            </section>

            <section id="wax-qa">
                <WaxQA/>
            </section>

            <section id="oil-qa">
                <OilQA/>  
            </section>

            <section id="tincture-qa">
                <TinctureQA/>
            </section>

             <section id="smoking-qa">
                <SmokingQA/>  
            </section>
            
            <section id="vaporizing-qa">
                <VaporizingQA/>
            </section>

            <section id="edibles-qa">
                <EdiblesQA/>
            </section>

            <section id="topicals-qa">
                <TopicalsQA/>
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
    <footer id="bottom">
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import PageJumpLinks from '@/components/PageJumpLinks.vue';
import DispensariesQA from '@/components/questions_components/DispensariesQA.vue';
import CannabisQA from '@/components/questions_components/CannabisQA.vue';
import CBDQA from '@/components/questions_components/CBDQA.vue';
import Delta9QA from '@/components/questions_components/Delta9QA.vue';
import FlowerQA from '@/components/questions_components/FlowerQA.vue';
import WaxQA from '@/components/questions_components/WaxQA.vue';
import OilQA from '@/components/questions_components/OilQA.vue';
import TinctureQA from '@/components/questions_components/TinctureQA.vue';
import SmokingQA from '@/components/questions_components/SmokingQA.vue';
import VaporizingQA from '@/components/questions_components/VaporizingQA.vue';
import EdiblesQA from '@/components/questions_components/EdiblesQA.vue';
import TopicalsQA from '@/components/questions_components/TopicalsQA.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "CommonQuestions",
    components: { 
        Header,
        PageJumpLinks,
        DispensariesQA,
        CannabisQA,
        CBDQA,
        Delta9QA,
        FlowerQA,
        WaxQA,
        OilQA,
        TinctureQA,
        SmokingQA,
        VaporizingQA,
        EdiblesQA,
        TopicalsQA,
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
#questions-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#questions-main {
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
    font-size: 1.2rem;
}

p {
    font-size: 1.1rem;
    margin: auto 8vw;
}

#page-summary {
    margin-bottom: 2vw;
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