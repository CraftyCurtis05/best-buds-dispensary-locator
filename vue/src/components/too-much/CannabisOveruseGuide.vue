<!-- Cannabis Overuse Guide Component Display -->
<template>

    <section
        id="what-to-do"
        aria-labelledby="what-to-do-heading"
    >

        <!-- Display Cannabis Overuse Guide Introduction -->
        <h3 id="what-to-do-heading">
            What To Do If You've Had Too Much Cannabis
        </h3>

        <p>
            While these symptoms usually don’t cause lasting
            health effects, there are a few cases when you may
            want to get medical care. Keep reading to learn
            more about what people can do to reduce the
            ‘high.’ Note that many of these tips are anecdotal
            or based on animal studies, which means they lack
            rigorous human research.
        </p>

        <!-- Display Cannabis Overuse Guide -->
        <ol class="overuse-list">

            <li>

                <h4>
                    Shift the focus and relax
                </h4>

                <ul class="overuse-details">
                    <li>
                        Listening to some favorite music.
                    </li>

                    <li>
                        Watching a film or some funny clips
                        online.
                    </li>

                    <li>
                        Doing some breathing exercises or yoga.
                    </li>

                    <li>
                        Doing a jigsaw, doodling, playing a
                        computer game.
                    </li>

                    <li>
                        Playing an instrument or painting,
                        doing something creative.
                    </li>

                    <li>
                        Being productive in a simple way, for
                        example, organizing a wardrobe or
                        doing some cleaning.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Hydrate
                </h4>

                <ul class="overuse-details">
                    <li>
                        Drinking plenty of water, tea, or other
                        soft drinks to keep hydrated can also
                        minimize discomfort from being too
                        high.
                    </li>

                    <li>
                        Having a dry mouth (xerostomia) from
                        smoking or ingesting marijuana can make
                        a person feel worse.
                    </li>

                    <li>
                        The American Dental Association
                        indicate a link between using marijuana
                        and oral dryness.
                    </li>

                    <li>
                        A person should avoid drinking alcohol
                        when they are already too high.
                    </li>

                    <li>
                        It can worsen the effects of weed and
                        the ‘high feeling.’
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Eat
                </h4>

                <ul class="overuse-details">
                    <li>
                        There is some evidence that cannabis
                        consumption can lead to increased
                        hunger and appetite.
                    </li>

                    <li>
                        There are no scientific studies to
                        support the anecdotal claim that eating
                        will diminish the psychoactive effects
                        of weed.
                    </li>

                    <li>
                        According to an article in the British
                        Journal of Pharmacology, compounds
                        called terpenoids found in some plant
                        foods might have therapeutic
                        properties that may serve as an
                        antidote to a cannabis high.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Take a shower
                </h4>

            </li>

            <li>

                <h4>
                    Walk it off
                </h4>

            </li>

            <li>

                <h4>
                    Talk it through
                </h4>

            </li>

            <li>

                <h4>
                    Try some CBD
                </h4>

            </li>

            <li>

                <h4>
                    Chew on whole black peppercorn
                </h4>

            </li>

            <li>

                <h4>
                    Sleep
                </h4>

            </li>

        </ol>

        <!-- Display Cannabis Overuse Guide Image -->
        <figure class="overuse-image">

            <img
                :src="CannabisOveruseGuideImage"
                alt="Cannabis overuse guide"
            />

        </figure>

    </section>

</template>

<script>
import CannabisOveruseGuideImage from "../../assets/too-much/cannabis-overuse-guide.webp";

export default {
    name: "CannabisOveruseGuide",

    data() {
        return {
            CannabisOveruseGuideImage
        };
    }
};
</script>

<style scoped>

</style>