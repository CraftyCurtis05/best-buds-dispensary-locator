<!-- Too Much Cananbis View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Too Much? | Best Buds</title>

    <!-- Display Header Component -->
    <header id="top">
        <Header/>
    </header>

    <!-- Display View Body -->
    <body id="toomuch-body">

        <!-- Display Body's Main Content -->
        <main id="toomuch-main">

            <!-- Display Body Title -->
            <h1>Too Much Cannabis</h1>

            <!-- Display View Jump Links Component -->
            <aside id="view-links">
                <ViewJumpLinks/>
            </aside>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>🌿Think you may have overdone it?🌿</h2>
                <p>Using too much cannabis can lead to overthinking and heightened anxiety, making simple tasks seem overwhelming. It’s like your mind gets stuck in overdrive—what started as a relaxing evening can turn into a marathon of introspection. The key is moderation and knowing your limits to keep your experience enjoyable and stress-free.</p>
                <h3>If you think you've had too much, please check out below to ease your mind!</h3>
            </section>

            <!-- Display Body Jump Links -->
            <section id="links">
                <div class="link"><a href="#symptoms">Signs and Symptoms</a></div>
                <div class="link"><a href="#coping">How to Cope</a></div>
                <div class="link"><a href="#what-to-do">What To Do</a></div>
            </section> 

            <!-- Display Too Much Cannabis Information -->
             <section id="toomuch">

                <!-- Display Too Much Symptoms Component -->
                <article id="symptoms">
                    <Symptoms/>
                </article>

                <!-- Display Too Much Coping Component -->
                <article id="coping">
                    <Coping/>
                </article>

                <!-- Display Too Much What To Do Component -->
                <article id="what">
                    <WhatToDo/>
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
import Symptoms from '@/components/too_much_components/Symptoms.vue';
import Coping from '@/components/too_much_components/Coping.vue';
import WhatToDo from '@/components/too_much_components/WhatToDo.vue';
import StrainGuideVisit from '@/components/strain_guide_components/StrainGuideVisit.vue';
import ArticlesVisit from '@/components/articles_components/ArticlesVisit.vue';
import Quote from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "TooMuchCannabis",
    components: { 
        Header,
        ViewJumpLinks,
        Symptoms,
        Coping,
        WhatToDo,
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
#toomuch-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#toomuch-main {
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
