<!-- Common Questions View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Questions | Best Buds</title>

    <!-- Display Header Component -->    
    <header id="top">
        <Header/>
    </header>

    <!-- Display View Body -->
    <body id="questions-body">

        <!-- Display Body's Main Content -->
        <main id="questions-main">

            <!-- Display Body Title -->
            <h1>Commonly Asked Questions About Cannabis</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>🌿Got cannabis questions? No worries!🌿</h2>
                <p>Whether you're curious about legality, how it works, or the best ways to use it, the plant’s got answers. From getting high or just chilling with CBD, to understanding health impacts and legal stuff, dive in and explore. Stay informed, use responsibly, and enjoy the journey!</p>
                <h3>We've got all your questions answered below!</h3>
            </section>

            <!-- Display Body Jump Links -->
             <section id="links">
                <div class="link"><a href="#dispensaries">Dispensaries</a></div>
                <div class="link"><a href="#cannabis">Cannabis</a></div>
                <div class="link"><a href="#cbd">CBD</a></div>
                <div class="link"><a href="#delta9">Delta-9</a></div>
                <div class="link"><a href="#flower">Flower</a></div>
                <div class="link"><a href="#wax">Wax</a></div>
                <div class="link"><a href="#oil">Oil</a></div>
                <div class="link"><a href="#tincture">Tincture</a></div>
                <div class="link"><a href="#smoking">Smoking</a></div>
                <div class="link"><a href="#vaporizing">Vaporizing</a></div>
                <div class="link"><a href="#edibles">Edibles</a></div>
                <div class="link"><a href="#topicals">Topicals</a></div>
             </section>

            <!-- Display Questions and Answers Information-->
            <section id="questions">

                <!-- Display Dispensaries Q&A Component -->
                <article id="dispensaries">
                    <DispensariesQA/>
                </article>

                <!-- Display Cannabis Q&A Component -->
                <article id="cannabis">
                    <CannabisQA/>
                </article>

                <!-- Display CBD Q&A Component -->
                <article id="cbd">
                    <CBDQA/>
                </article>

                <!-- Display Delta9 Q&A Component -->
                <article id="delta9">
                    <Delta9QA/>
                </article>

                <!-- Display Flower Q&A Component -->
                <article id="flower">
                    <FlowerQA/>
                </article>

                <!-- Display Wax Q&A Component -->
                <article id="wax">
                    <WaxQA/>
                </article>

                <!-- Display Oil Q&A Component -->
                <article id="oil">
                    <OilQA/>  
                </article>

                <!-- Display Tincture Q&A Component -->
                <article id="tincture">
                    <TinctureQA/>
                </article>

                <!-- Display Smoking Q&A Component -->
                <article id="smoking">
                    <SmokingQA/>  
                </article>
                
                <!-- Display Vaporizing Q&A Component -->
                <article id="vaporizing">
                    <VaporizingQA/>
                </article>

                <!-- Display Edibles Q&A Component -->
                <article id="edibles">
                    <EdiblesQA/>
                </article>

                <!-- Display Topicals Q&A Component -->
                <article id="topicals">
                    <TopicalsQA/>
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
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "CommonQuestions",
    components: { 
        Header,
        ViewJumpLinks,
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
        Quote, 
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