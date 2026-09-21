<!-- Common Questions View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Questions | Best Buds</title>

    <!-- Display View Body -->
    <body id="questions-body">

        <!-- Display Body's Main Content -->
        <main id="questions-main">

            <!-- Display Body Title -->
            <h1>Commonly Asked Questions About Cannabis</h1>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>Got cannabis questions? No worries!</h2>
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

    </body>

</template>

<script>
import DispensariesQA from '../components/questions/Dispensaries.vue';
import CannabisQA from '../components/questions/Cannabis.vue';
import CBDQA from '../components/questions/CBD.vue';
import Delta9QA from '../components/questions/Delta9.vue';
import FlowerQA from '../components/questions/Flower.vue';
import WaxQA from '../components/questions/Wax.vue';
import OilQA from '../components/questions/Oil.vue';
import TinctureQA from '../components/questions/Tincture.vue';
import SmokingQA from '../components/questions/Smoking.vue';
import VaporizingQA from '../components/questions/Vaporizing.vue';
import EdiblesQA from '../components/questions/Edibles.vue';
import TopicalsQA from '../components/questions/Topicals.vue';
import StrainGuideVisit from '../components/strain-guide/Visit.vue';
import ArticlesVisit from '../components/articles/Visit.vue';

export default {
    name: "QuestionsView",

    components: { 
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
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>