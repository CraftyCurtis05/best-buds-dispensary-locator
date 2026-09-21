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
                    <DispensaryQuestions />
                </article>

                <!-- Display Cannabis Q&A Component -->
                <article id="cannabis">
                    <CannabisQuestions />
                </article>

                <!-- Display CBD Q&A Component -->
                <article id="cbd">
                    <CbdQuestions />
                </article>

                <!-- Display Delta9 Q&A Component -->
                <article id="delta9">
                    <Delta9Questions />
                </article>

                <!-- Display Flower Q&A Component -->
                <article id="flower">
                    <FlowerQuestions />
                </article>

                <!-- Display Wax Q&A Component -->
                <article id="wax">
                    <WaxQuestions />
                </article>

                <!-- Display Oil Q&A Component -->
                <article id="oil">
                    <OilQuestions />  
                </article>

                <!-- Display Tincture Q&A Component -->
                <article id="tincture">
                    <TinctureQuestions />
                </article>

                <!-- Display Smoking Q&A Component -->
                <article id="smoking">
                    <SmokingQuestions />  
                </article>
                
                <!-- Display Vaporizing Q&A Component -->
                <article id="vaporizing">
                    <VaporizingQuestions />
                </article>

                <!-- Display Edibles Q&A Component -->
                <article id="edibles">
                    <EdibleQuestions />
                </article>

                <!-- Display Topicals Q&A Component -->
                <article id="topicals">
                    <TopicalQuestions />
                </article>

            </section>

        </main>

        <!-- Display Strain Guide Visit Component -->
        <section id="strain-guide-visit">
            <StrainGuideVisit />
        </section>
 
        <!-- Display Articles Visit Component -->
        <section id="articles-visit">
            <ArticlesVisit />
        </section>

    </body>

</template>

<script>
import DispensaryQuestions from '../components/questions/DispensaryQuestions.vue';
import CannabisQuestions from '../components/questions/CannabisQuestions.vue';
import CbdQuestions from '../components/questions/CbdQuestions.vue';
import Delta9Questions from '../components/questions/Delta9Questions.vue';
import FlowerQuestions from '../components/questions/FlowerQuestions.vue';
import WaxQuestions from '../components/questions/WaxQuestions.vue';
import OilQuestions from '../components/questions/OilQuestions.vue';
import TinctureQuestions from '../components/questions/TinctureQuestions.vue';
import SmokingQuestions from '../components/questions/SmokingQuestions.vue';
import VaporizingQuestions from '../components/questions/VaporizingQuestions.vue';
import EdibleQuestions from '../components/questions/EdibleQuestions.vue';
import TopicalQuestions from '../components/questions/TopicalQuestions.vue';
import StrainGuideVisit from '../components/strain-guide/StrainGuideVisit.vue';
import ArticlesVisit from '../components/articles/ArticlesVisit.vue';

export default {
    name: "QuestionsView",

    components: { 
        DispensaryQuestions,
        CannabisQuestions,
        CbdQuestions,
        Delta9Questions,
        FlowerQuestions,
        WaxQuestions,
        OilQuestions,
        TinctureQuestions,
        SmokingQuestions,
        VaporizingQuestions,
        EdibleQuestions,
        TopicalQuestions,
        StrainGuideVisit,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>