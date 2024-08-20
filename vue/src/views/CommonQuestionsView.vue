<!-- Common Questions Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Questions | Best Buds</title>

    <!-- Display Header Component -->    
    <header>
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="common-questions-body">

        <!-- Display Common Questions Main Content -->
        <main id="common-questions-main">

            <!-- Display Page Title -->
            <h1>Commonly Asked Questions About Cannabis</h1>

            <!-- Display Smoking Qustions and Answers Information-->
             <section id="questions-smoking">
                <h2>Smoking Cannabis Q&A</h2>
                    <p>***NEED SMOKING Q&A SUMMARY***</p>

                <h3>What is the method of smoking cannabis?</h3>
                <ul id="questions-smoking-method-list">
                    <li>The most common method of smoking cannabis is to use a pipe, bong, or joint.</li>
                    <li>A pipe is a small, handheld device with a bowl at one end and a mouthpiece at the other.</li>
                    <li>A bong is a larger device with a water chamber that cools the smoke before it is inhaled.</li>
                    <li>A joint is a rolled cigarette made of cannabis and tobacco.</li>
                </ul>

                <h3>How do you take a good hit?</h3>
                <ul id="questions-smoking-hit-list">
                    <li>To take a good hit, first grind the cannabis.</li>
                    <li>Then, pack the bowl of your pipe or bong with the ground cannabis.</li>
                    <li>Light the bowl and inhale slowly and deeply.</li>
                    <li>Hold the smoke in your lungs for just a few seconds before exhaling.</li>
                </ul>

                <h3>How can I get higher smoking?</h3>
                <ul id="questions-smoking-higher-list">
                    <li>There are a few things you can do to get higher when smoking cannabis.</li>
                    <li>First, use more potent strains.</li>
                    <li>Second, take bigger hits.</li>
                    <li>And third - do not hold in the smoke.</li>
                    <li>The THC is absorbed in the lungs almost instantaneously so holding the smoke will lead to absorbing stuff you do not need and can actually be harmful to your lungs.</li>
                </ul>

                <h3>How to smoke cannabis the first time?</h3>
                <ul id="questions-smoking-first-list">
                    <li>If you are smoking cannabis for the first time, it is important to start slowly and gradually increase the amount you smoke.</li>
                    <li>This will help you avoid getting too high and feeling sick.</li>
                    <li>It is also important to be in a comfortable and relaxed setting when you first smoke cannabis.</li>
                    <li>Having a friend who knows cannabis help you is a great option.</li>
                </ul>

                <h3>How to inhale smoke for the first time?</h3>
                    <span>If you are new to smoking, it may be difficult to inhale the smoke properly. Here are a few tips:</span>
                <ul id="questions-smoking-inhale-list">
                    <li>Start by taking small, shallow breaths.</li>
                    <li>Don't try to inhale too much smoke at once.</li>
                    <li>Hold the smoke in your lungs briefly before exhaling.</li>
                    <li>Practice inhaling and exhaling with a clean pipe or bong before you smoke cannabis.</li>
                </ul>

                <h3>Does coughing get you higher?</h3>
                <ul id="questions-smoking-coughing-list">
                    <li>Coughing does not get you higher.</li>
                    <li>In fact, it can actually make you feel less high.</li>
                    <li>When you cough, you are expelling the smoke from your lungs before it has a chance to be absorbed into your bloodstream.</li>
                </ul>

                <h3>Does breathing deeper get you higher?</h3>
                <ul id="questions-smoking-breathing-list">
                    <li>Breathing deeper will not get you higher, but it can help you to absorb the smoke more efficiently.</li>
                    <li>When you breathe deeply, you are taking in more oxygen, which helps to carry the THC (the active ingredient in cannabis) into your bloodstream.</li>
                </ul>

                <h3>What is better for first time cannabis use?</h3>
                <ul id="questions-smoking-better-list">
                    <li> Please check out our <router-link v-bind:to="{ name:'strainguide'}"> Strain Guide </router-link> for information.</li>
                </ul>

                <h3>What are some tips for a better smoking experience?</h3>
                <ul id="questions-smoking-experience-list">
                    <li>Use a clean pipe or bong.</li>
                    <li>Grind the cannabis finely.</li>
                    <li>Light the bowl evenly.</li>
                    <li>Inhale slowly and deeply.</li>
                    <li>Don't hold the smoke in your lungs for too long.</li>
                    <li>Exhale the smoke slowly.</li>
                    <li>Drink plenty of water.</li>
                    <li>Stay hydrated.</li>
                </ul>
            </section>

            <section>
                ***ADD MORE Q&A CATEGORIES***
            </section>

        </main>

        <!-- Display Strain Guide Link -->
        <section id="strain-guide">
            <h4>Looking for more information on types and strains?</h4>
            <summary id="strain-guide-link">
                Please check out our <router-link v-bind:to="{ name:'strainguide' }">Strain Guide</router-link> for information.
            </summary>
        </section>
 
        <!-- Display Want More Info with Articles Link -->
        <section id="articles-visit">
            <h5>Looking for more information?</h5>
            <summary id="articles-link">
                <router-link v-bind:to="{ name:'articles' }">Visit our articles page</router-link>
            </summary>
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
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "CommonQuestions",
    components: { Header, QuoteComponent, Footer }
};
</script>

<style scoped>
#common-questions-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

.common-questions-info {
  margin-left: 5vw;
  margin-right: 5vw;
}

h1,
h2,
.want-more,
h6 {
  text-align: center;
}

h1 {
  font-size: 1.5em;
  font-weight: bolder;
  margin-top: 4vw;
  padding-bottom: 1vw;
}

h2 {
  font-size: 1.2em;
  font-weight: bolder;
  text-decoration: underline;
  padding-top: 2vw;
  margin-bottom: -.5vw;
}

h3 {
  font-size: 1.1em;
  font-style: italic;
  font-weight: bold;
  margin-bottom: 0vw;
}

li {
    font-size: 1em;
    margin-bottom: 1.2vw;
}

.strain-guide {
  margin-left: 7vw;
}

.want-more {
    margin-top: 3vw;
}

#strain-guide-link,
#articles-link {
    margin-top: -1vw;
}

h6 {
    font-size: .9em;
    font-style: italic;
    font-weight: lighter;
    margin-bottom: 1vw;
}
</style>