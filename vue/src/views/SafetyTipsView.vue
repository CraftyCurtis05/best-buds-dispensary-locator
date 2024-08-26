<!-- Safety Tips Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Safety Tips | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="safety-tips-body">

        <!-- Display Main Content -->
        <main id="safety-tips-main">

            <!-- Display Page Title -->
            <h1>Tips for Safer Cannabis Consumption, Smoking and Topicals</h1>

            <!-- Display Page Summary -->
            <p>***PAGE SUMMARY***</p>

            <!-- Display Page Jump Links -->
            <aside id="page-jump-links">
                <PageJumpLinks/>
            </aside>

            <!-- Display THC Consumption Tips Component -->
            <section id="thc-consumption">
                <THCConsumption/>
            </section>    

            <!-- Display CBD Consumption Tips Component -->
            <section id="cbd-consumption"> 
                <CBDConsumption/>
            </section>

            <!-- Display Cannabis Smoking Tips Component -->
            <section id="smoking">
                <Smoking/>
            </section>

            <!-- Display Topical Use Tips Component -->
             <section id="topical">
                <Topical/>
            </section>    

            <!-- Display Conclusion Information -->
            <section id="conclusion"> 
                <h2>Conclusion:</h2>
                <p>Your first cannabis experience can be a wonderful journey when approached with care and responsibility. As for the question, "Is it better to use weed the first time alone or in company?", having a trusted, sober friend nearby can make the experience more comforting and enjoyable. By following the tips shared in this guide, first-time cannabis smokers can look forward to a positive and memorable first high. If you are contemplating using cannabis for the first time, undertake comprehensive research and connect with experienced cannabis users for their insights. This can empower you to make an informed decision about whether cannabis is the right choice for you.</p>
                <mark>Cannabis comes in a variety of forms including edibles and concentrates but they are not the best choice for your first time. Extracts including vape cartridges are too potent and hard to handle for a novice and edibles are not that predictable in terms of dosage and effects (which depend on numerous factors like tolerance and the time of onset) the buzz may start hours from ingestion and last for up to 8 hours.</mark>
                <mark>Remember, responsible consumption is crucial for any enjoyable cannabis experience.</mark>
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
import THCConsumption from '@/components/safety_tips_components/THCConsumption.vue';
import CBDConsumption from '@/components/safety_tips_components/CBDConsumption.vue';
import Smoking from '@/components/safety_tips_components/Smoking.vue';
import Topical from '@/components/safety_tips_components/Topical.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "SafetyTips",
    components: { 
        Header,
        PageJumpLinks,
        THCConsumption,
        CBDConsumption,
        Smoking,
        Topical,
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
#safety-tips-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#safety-tips-main {
    margin: 4vw;
}

h1,
h2,
p,
mark,
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

#strain-guide-visit,
#articles-visit {
    padding: 1vw;
}
</style>