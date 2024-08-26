<!-- Common Questions Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Questions | Best Buds</title>

    <!-- Display Header Component -->    
    <header>
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="questions-body">

        <!-- Display Common Questions Main Content -->
        <main id="questions-main">

            <!-- Display Page Title -->
            <h1>Commonly Asked Questions About Cannabis</h1>

            <!-- Display Page Summary -->
             <p>***PAGE SUMMARY***</p>

            <!-- Display Qustions and Answers Components Information-->
            <section id="questions-dispensaries">
                <DispensariesQA/>
            </section>

            <section id="questions-cannabis">
                <CannabisQA/>
            </section>

            <section id="questions-cbd">
                <CBDQA/>
            </section>

            <section id="questions-delta9">
                <Delta9QA/>
            </section>

            <section id="questions-flower">
                <FlowerQA/>
            </section>

            <section id="questions-wax">
                <WaxQA/>
            </section>

            <section id="questions-oil">
                <OilQA/>  
            </section>

            <section id="questions-tincture">
                <TinctureQA/>
            </section>

             <section id="questions-smoking">
                <SmokingQA/>  
            </section>
            
            <section id="questions-vaporizing">
                <VaporizingQA/>
            </section>

            <section id="questions-edibles">
                <EdiblesQA/>
            </section>

            <section id="questions-topicals">
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
    <footer>
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
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
  font-size: 1.3rem;
  padding-top: 2rem;
}

p {
    margin: auto 8vw;
}

h3 {
    font-size: 1.1rem;
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

#strain-guide,
#articles-visit {
    padding: 1vw;
}
</style>