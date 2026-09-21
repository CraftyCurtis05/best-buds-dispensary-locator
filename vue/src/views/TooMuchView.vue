<!-- Too Much Cananbis View Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Too Much? | Best Buds</title>

    <!-- Display View Body -->
    <body id="toomuch-body">

        <!-- Display Body's Main Content -->
        <main id="toomuch-main">

            <!-- Display Body Title -->
            <h1>Too Much Cannabis</h1>

            <!-- Display Body Summary -->
            <section id="summary">
                <h2>Think you may have overdone it?</h2>
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

    </body>

</template>

<script>
import Symptoms from '../components/too-much/Symptoms.vue';
import Coping from '../components/too-much/Coping.vue';
import WhatToDo from '../components/too-much/WhatToDo.vue';
import StrainGuideVisit from '../components/strain-guide/Visit.vue';
import ArticlesVisit from '../components/articles/Visit.vue';

export default {
    name: "TooMuchView",

    components: { 
        Symptoms,
        Coping,
        WhatToDo,
        StrainGuideVisit,
        ArticlesVisit
    }
};
</script>

<style scoped>

</style>
