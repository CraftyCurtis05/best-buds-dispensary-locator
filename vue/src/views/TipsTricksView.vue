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

                <!-- Display Page Summary -->
                <p>Cannabis confusion got you burnt out? You're not alone! With so many strains, products, and effects, it can feel like a wild, green maze. But don't stress—it's all part of the fun! Think of it as a choose-your-own-adventure. Whether you're giggling over strain names or puzzled by potency, embrace the journey. The key is to explore, experiment, and enjoy the ride!</p>

            <!-- Display Tips and Tricks Information -->
            <section id="tips-tricks">
                <h2>Check out some of the Tips and Tricks we've compiled below!</h2>

                <div id="tips-tricks-list">

                    <!-- Display Cannabis Products Link and Information -->
                    <article id="tips-tricks-choose-products">
                        <router-link v-bind:to="{ name:'cannabisproducts' }"><img src="@/assets/tipstricks_assets/which_product.jpg"/></router-link>
                        <h3><router-link v-bind:to="{ name:'cannabisproducts' }">How To Choose Which Cannabis Product Is Right For You</router-link></h3>
                        <span>
                            Choosing the right cannabis product is all about matching your mood and goals. Start by picking between sativas for energy, indicas for relaxation, or hybrids for balance by using our <router-link v-bind:to="{ name:'strainguide' }">strain guide</router-link> to help you figure out what type is best for you. Consider the potency and method—like edibles for longer effects or vaping for quick hits. Experiment and enjoy the journey to find what suits you best!</span>
                    </article>

                    <!-- Display Strain Guide Link and Information -->
                    <article id="tips-tricks-strain-guide">
                        <router-link v-bind:to="{ name:'strainguide' }"><img src="@/assets/tipstricks_assets/strain_guide.jpg"/></router-link>
                        <h3><router-link v-bind:to="{ name:'strainguide' }">Comprehensive Strain Guide To Cannabis Products</router-link></h3>
                        <span>Our strain guide acts as an inclusive liaison to your selection of cannabis types, focusing on varieties and effects. Whether you're into energizing sativas, relaxing indicas, or balanced hybrids, we've got you covered. Our easy-to-use guide helps you discover strains suited to your mood or needs, making the experience fun and tailored to you. Perfect for both newbies and seasoned enthusiasts!</span>
                    </article>

                    <!-- Display Safety Tips Link and Information -->
                    <article id="tips-tricks-safety-tips">
                        <router-link v-bind:to="{ name:'safetytips' }"><img src="@/assets/tipstricks_assets/safety_tips.jpg"/></router-link>
                        <h3><router-link v-bind:to="{ name:'safetytips' }">Tips for Safer Consumption, Smoking and Topicals</router-link></h3>
                        <span>For safer cannabis use, keep it chill and smart! Start with low doses, especially if you're new, and avoid mixing with alcohol. Stay hydrated, have snacks on hand, and enjoy in a comfortable setting. Don’t drive under the influence, and always store your stash securely. We've compiled a complete list of safety tips for all the ways you can use cannabis. Remember - relax, have fun, and keep it responsible!  </span>
                    </article>

                    <!-- Display Too Much Cannabis Link and Information -->
                    <article id="tips-tricks-too-much">
                        <router-link v-bind:to="{ name:'toomuchcannabis' }"><img src="src\assets\tipstricks_assets\too_much.jpg"/></router-link>
                        <h3><router-link v-bind:to="{ name:'toomuchcannabis' }">What To Do If You Have Too Much Cannabis</router-link></h3>
                        <span>Had a bit too much cannabis? No worries! First, stay calm—it’ll pass. Find a comfy spot, drink water, and munch on snacks. Distract yourself with something relaxing, like a movie or music. If anxiety kicks in, try deep breathing. Remember, it’s temporary, and you'll feel better soon! Take a look at our list of things you can do to ease your high and anxiety after too much marijuana.</span>
                    </article>

                    <!-- Display Legality Link and Information -->
                    <article id="tips-tricks-legality">
                        <router-link v-bind:to="{ name:'legality' }"><img src="@/assets/tipstricks_assets/legal_use.jpg"/></router-link>
                        <h3><router-link v-bind:to="{ name:'legality' }">Curious About The Legal Use Within Your Area</router-link></h3>
                        <span>Trying to figure out the current laws around cannabis in the United States? You are not alone. Cannabis is a federal no-show—it's still illegal under the Controlled Substances Act, with a "No Entry" sign from Uncle Sam. But enforcement? It's more like a polite suggestion. Each state has it's own laws regarding cannabis use. We have compiled a list of states and their laws for you, so you don't have to!</span>
                    </article>

                    <!-- Display Common Questions Link and Information -->
                    <article id="tips-tricks-questions">
                        <router-link v-bind:to="{ name:'commonquestions' }"><img src="@/assets/tipstricks_assets/questions.jpg"/></router-link>
                        <h3><router-link v-bind:to="{ name:'commonquestions' }">Commonly Asked Questions</router-link></h3>
                        <span>Got questions about cannabis? You're not alone! People often wonder about the difference between indica and sativa, how much to take, how long effects last, and whether it’s legal. Others ask about edibles, safety tips, and the best ways to enjoy it. Curious minds lead to better experiences, so ask away and enjoy the high times! We've compiled a list of the most frequently asked questions and answers.</span>
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
/* OBJECTS = rem */
/* SPACING = vw */
#tips-tricks-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\background_assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#tips-tricks-main {
    margin: 4vw;
}

#tips-tricks-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
}

img {
    width: 35rem;
    height: 22rem;
    border: .3rem black solid;
}

#tips-tricks-choose-products,
#tips-tricks-strain-guide,
#tips-tricks-safety-tips,
#tips-tricks-too-much,
#tips-tricks-legality,
#tips-tricks-questions {
    text-align: center;
    width: 35rem;
    height: 20rem;
    margin-block: 2vw;
    margin-inline: 2vw;
    padding-block: 5vw;
    /*border: .1rem black solid; /* <<<<<<<<<< DELETE WHEN FINISHED >>>>>>>>>> */
}

img:hover,
h3:hover {
    cursor: url('best_buds_logo_icon.ico'), pointer;
}

h1,
h2,
p,
h3,
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

article {
    padding: 1vw;
}

h4 {
    margin-bottom: .5vw;
}

h5 {
    font-size: 1rem;
    margin: .1vw;
}

#articles-visit {
    padding: 1vw;
}
</style>