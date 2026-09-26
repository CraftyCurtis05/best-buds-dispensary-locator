<!-- Tips and Tricks Guide Component Display -->
<template>

    <div id="tips-tricks-guide">

        <!-- Display Cannabis Products Guide -->
        <article
            id="choose-products"
            aria-labelledby="choose-products-heading"
        >

            <router-link
                :to="{ name: 'products' }"
                aria-label="Explore cannabis products"
            >
                <img
                    :src="ProductImage"
                    alt="Cannabis products"
                />
            </router-link>

            <h3 id="choose-products-heading">
                <router-link
                    :to="{ name: 'products' }"
                >
                    How To Choose Which Cannabis Product Is
                    Right For You
                </router-link>
            </h3>

            <p>
                Choosing the right cannabis product is all
                about matching your mood and goals. Start by
                picking between sativas for energy, indicas
                for relaxation, or hybrids for balance by
                using our
                <router-link
                    :to="{ name: 'strain-guide' }"
                >
                    strain guide
                </router-link>
                to help you figure out what type is best for
                you. Consider the potency and method—like
                edibles for longer effects or vaping for quick
                hits. Experiment and enjoy the journey to find
                what suits you best!
            </p>

        </article>

        <!-- Display Strain Guide -->
        <article
            id="strain-guide"
            aria-labelledby="strain-guide-heading"
        >

            <router-link
                :to="{ name: 'strain-guide' }"
                aria-label="Explore the cannabis strain guide"
            >
                <img
                    :src="StrainGuideImage"
                    alt="Cannabis strain guide"
                />
            </router-link>

            <h3 id="strain-guide-heading">
                <router-link
                    :to="{ name: 'strain-guide' }"
                >
                    Comprehensive Strain Guide To Cannabis
                    Products
                </router-link>
            </h3>

            <p>
                Our strain guide acts as an inclusive liaison
                to your selection of cannabis types, focusing
                on varieties and effects. Whether you're into
                energizing sativas, relaxing indicas, or
                balanced hybrids, we've got you covered. Our
                easy-to-use guide helps you discover strains
                suited to your mood or needs, making the
                experience fun and tailored to you. Perfect
                for both newbies and seasoned enthusiasts!
            </p>

        </article>

        <!-- Display Safety Tips -->
        <article
            id="safety-tips"
            aria-labelledby="safety-tips-heading"
        >

            <router-link
                :to="{ name: 'safety' }"
                aria-label="Explore cannabis safety tips"
            >
                <img
                    :src="SafetyImage"
                    alt="Cannabis safety tips"
                />
            </router-link>

            <h3 id="safety-tips-heading">
                <router-link
                    :to="{ name: 'safety' }"
                >
                    Tips for Safer Consumption, Smoking and
                    Topicals
                </router-link>
            </h3>

            <p>
                For safer cannabis use, keep it chill and
                smart! Start with low doses, especially if
                you're new, and avoid mixing with alcohol.
                Stay hydrated, have snacks on hand, and enjoy
                in a comfortable setting. Don’t drive under
                the influence, and always store your stash
                securely. We've compiled a complete list of
                safety tips for all the ways you can use
                cannabis. Remember - relax, have fun, and keep
                it responsible!
            </p>

        </article>

        <!-- Display Too Much Cannabis Guide -->
        <article
            id="too-much"
            aria-labelledby="too-much-heading"
        >

            <router-link
                :to="{ name: 'too-much' }"
                aria-label="Learn what to do after too much cannabis"
            >
                <img
                    :src="TooMuchImage"
                    alt="Too much cannabis guide"
                />
            </router-link>

            <h3 id="too-much-heading">
                <router-link
                    :to="{ name: 'too-much' }"
                >
                    What To Do If You Have Too Much Cannabis
                </router-link>
            </h3>

            <p>
                Had a bit too much cannabis? No worries! First,
                stay calm—it’ll pass. Find a comfy spot, drink
                water, and munch on snacks. Distract yourself
                with something relaxing, like a movie or
                music. If anxiety kicks in, try deep
                breathing. Remember, it’s temporary, and
                you'll feel better soon! Take a look at our
                list of things you can do to ease your high
                and anxiety after too much marijuana.
            </p>

        </article>

        <!-- Display Cannabis Legality Guide -->
        <article
            id="legality"
            aria-labelledby="legality-heading"
        >

            <router-link
                :to="{ name: 'legality' }"
                aria-label="Explore cannabis laws by state"
            >
                <img
                    :src="LegalImage"
                    alt="Cannabis legality guide"
                />
            </router-link>

            <h3 id="legality-heading">
                <router-link
                    :to="{ name: 'legality' }"
                >
                    Curious About The Legal Use Within Your
                    Area
                </router-link>
            </h3>

            <p>
                Trying to figure out the current laws around
                cannabis in the United States? You are not
                alone. Cannabis is a federal no-show—it's
                still illegal under the Controlled Substances
                Act, with a "No Entry" sign from Uncle Sam.
                But enforcement? It's more like a polite
                suggestion. Each state has it's own laws
                regarding cannabis use. We have compiled a
                list of states and their laws for you, so you
                don't have to!
            </p>

        </article>

        <!-- Display Common Questions Guide -->
        <article
            id="questions"
            aria-labelledby="questions-heading"
        >

            <router-link
                :to="{ name: 'questions' }"
                aria-label="Explore common cannabis questions"
            >
                <img
                    :src="QuestionsImage"
                    alt="Common cannabis questions"
                />
            </router-link>

            <h3 id="questions-heading">
                <router-link
                    :to="{ name: 'questions' }"
                >
                    Commonly Asked Questions
                </router-link>
            </h3>

            <p>
                Got questions about cannabis? You're not
                alone! People often wonder about the
                difference between indica and sativa, how much
                to take, how long effects last, and whether
                it’s legal. Others ask about edibles, safety
                tips, and the best ways to enjoy it. Curious
                minds lead to better experiences, so ask away
                and enjoy the high times! We've compiled a
                list of the most frequently asked questions
                and answers.
            </p>

        </article>

    </div>

</template>

<script>
import ProductImage from "../../assets/tips-tricks/product.webp";
import StrainGuideImage from "../../assets/tips-tricks/strain-guide.webp";
import SafetyImage from "../../assets/tips-tricks/safety.webp";
import TooMuchImage from "../../assets/tips-tricks/too-much.webp";
import LegalImage from "../../assets/tips-tricks/legal.webp";
import QuestionsImage from "../../assets/tips-tricks/questions.webp";

export default {
    name: "TipsTricksGuide",

    data() {
        return {
            ProductImage,
            StrainGuideImage,
            SafetyImage,
            TooMuchImage,
            LegalImage,
            QuestionsImage
        };
    }
};
</script>

<style scoped>

</style>