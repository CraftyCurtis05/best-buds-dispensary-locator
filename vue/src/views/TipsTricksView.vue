<!-- Tips and Tricks Page Display -->
<template>

    <!-- Browser Tab Title -->
    <title>Tips & Tricks | Best Buds</title>

    <!-- Display Header Component -->
    <header>
        <Header/>
    </header>    

    <!-- Display Page Body -->
    <body id="tips-tricks-body">

        <!-- Display Tips and Tricks Main Content -->
        <main id="tips-tricks-main">

            <!-- Display Page Title -->
            <h1>Tips & Tricks</h1>

            <!-- Display Tips and Tricks Information -->
            <section id="tips-tricks">
                <h2>Cannabis confusion got you burnt out?</h2>
                <p>***NEED TIPS AND TRICKS SUMMARY***</p>
                <h3>Check out some of the Tips and Tricks we've compiled below!</h3>

                <div id="tips-tricks-list">

                    <!-- Display Cannabis Products Link and Information -->
                    <article id="tips-tricks-choose-products">
                        <h4><router-link v-bind:to="{ name:'cannabisproducts' }">How To Choose Which Cannabis Product Is Right For You</router-link></h4>
                        <span>***NEED SUMMARY ABOUT CHOOSING THE RIGHT PRODUCTS***</span>
                    </article>

                    <!-- Display Strain Guide Link and Information -->
                    <article id="tips-tricks-strain-guide">
                        <h4><router-link v-bind:to="{ name:'strainguide' }">Comprehensive Strain Guide To Cannabis Products</router-link></h4>
                        <span>***NEED SUMMARY ABOUT STRAIN GUIDE***</span>
                    </article>

                    <!-- Display Safety Tips Link and Information -->
                    <article id="tips-tricks-safety-tips">
                        <h4><router-link v-bind:to="{ name:'safetytips' }">Tips for Safer Consumption, Smoking and Topicals</router-link></h4>
                        <span>***NEED SUMMARY ABOUT SAFETY TIPS***</span>
                    </article>

                    <!-- Display Too Much Cannabis Link and Information -->
                    <article id="tips-tricks-too-much">
                        <h4><router-link v-bind:to="{ name:'toomuchcannabis' }">What To Do If You Have Too Much Cannabis</router-link></h4>
                        <span>***NEED SUMMARY ABOUT WHAT TO DO IF TOO MUCH***</span>
                    </article>

                    <!-- Display Legality Link and Information -->
                    <article id="tips-tricks-legality">
                        <h4><router-link v-bind:to="{ name:'legality' }">Curious About The Legal Use Within Your Area</router-link></h4>
                        <span>***NEED SUMMARY ABOUT U.S. LAWS AND LEGALITY***</span>
                    </article>

                    <!-- Display Common Questions Link and Information -->
                    <article id="tips-tricks-questions">
                        <h4><router-link v-bind:to="{ name:'commonquestions' }">Commonly Asked Questions</router-link></h4>
                        <span>***NEED SUMMARY ABOUT COMMON QUESTIONS***</span>
                    </article>
                </div>
                
            </section>

        </main>

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
    name: "TipsTricks",
    components: { Header, QuoteComponent, Footer }
};
</script>

<style scoped>
.tips-tricks-view {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

.tips-tricks-description {
    margin-left: 5vw;
    margin-right: 5vw
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
}

h3 {
    font-size: 1.1em;
    font-weight: bold;
}

.want-more {
  margin-top: 3vw;
}

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