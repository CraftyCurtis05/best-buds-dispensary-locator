<!-- Safety Tips View Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Safety Tips | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>

    <!-- Display View Body -->
    <body id="tips-body">

        <!-- Display Body's Main Content -->
        <main id="tips-main">

            <!-- Display Body Title -->
            <h1>Tips for Safer Cannabis Consumption, Smoking and Topicals</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>🌿Want to keep your high smooth and groovy? 🌿</h2>
                <p>Cannabis use safety is like mastering the art of throwing a great party—keep the vibes positive, don’t overdo it, and have a plan to get home safely if needed. Balance your snacks with hydration, and remember: moderation is key. So, enjoy the high, but don’t let it turn into a wild rave without a designated driver!</p>
                <h3>Take a gander at the safety tips for cannabis use below!</h3>
            </section>

            <!-- Display Body Jump Links -->
            <section id="links">
                <div class="link"><a href="#thc-consumption">THC Consumption</a></div>
                <div class="link"><a href="#cbd-consumption">CBD Consumption</a></div>
                <div class="link"><a href="#smoking">Cannabis Smoking</a></div>
                <div class="link"><a href="#topical">Topical Use</a></div>
            </section>

            <!-- Display Safety Tips Information -->
             <section id="tips">

                <!-- Display THC Consumption Tips Component -->
                <article id="thc-consumption">
                    <THCConsumption/>
                </article>    

                <!-- Display CBD Consumption Tips Component -->
                <article id="cbd-consumption"> 
                    <CBDConsumption/>
                </article>

                <!-- Display Cannabis Smoking Tips Component -->
                <article id="smoking">
                    <Smoking/>
                </article>

                <!-- Display Topical Use Tips Component -->
                <article id="topical">
                    <Topical/>
                </article>    

                <!-- Display Conclusion Information -->
                <article id="conclusion"> 
                    <h3>Conclusion:</h3>
                    <p>Your first cannabis experience can be a wonderful journey when approached with care and responsibility. As for the question, "Is it better to use weed the first time alone or in company?", having a trusted, sober friend nearby can make the experience more comforting and enjoyable. By following the tips shared in this guide, first-time cannabis smokers can look forward to a positive and memorable first high. If you are contemplating using cannabis for the first time, undertake comprehensive research and connect with experienced cannabis users for their insights. This can empower you to make an informed decision about whether cannabis is the right choice for you.</p>
                    <h4>Cannabis comes in a variety of forms including edibles and concentrates but they are not the best choice for your first time. Extracts including vape cartridges are too potent and hard to handle for a novice and edibles are not that predictable in terms of dosage and effects (which depend on numerous factors like tolerance and the time of onset) the buzz may start hours from ingestion and last for up to 8 hours.</h4>
                    <h5>Remember, responsible consumption is crucial for any enjoyable cannabis experience.</h5>
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
import THCConsumption from '@/components/safety_tips_components/THCConsumption.vue';
import CBDConsumption from '@/components/safety_tips_components/CBDConsumption.vue';
import Smoking from '@/components/safety_tips_components/Smoking.vue';
import Topical from '@/components/safety_tips_components/Topical.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "SafetyTips",
    components: { 
        Header,
        ViewJumpLinks,
        THCConsumption,
        CBDConsumption,
        Smoking,
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
#tips-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#tips-main {
    margin: 4vw;
}

h1,
#summary,
#conclusion {
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