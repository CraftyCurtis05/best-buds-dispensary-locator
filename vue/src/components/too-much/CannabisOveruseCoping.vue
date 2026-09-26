<!-- Cannabis Overuse Coping Component Display -->
<template>

    <section
        id="coping"
        aria-labelledby="coping-heading"
    >

        <!-- Display Cannabis Overuse Coping Introduction -->
        <h3 id="coping-heading">
            Coping Tips
        </h3>

        <p>
            Consuming too much cannabis is rarely a medical
            emergency, despite how uncomfortable you may feel.
            Symptoms will subside as the effects wear off. In
            the meantime, these tips can help things feel more
            manageable:
        </p>

        <!-- Display Cannabis Overuse Coping Tips -->
        <ol class="coping-list">

            <li>

                <h4>
                    Remember that it will pass
                </h4>

                <ul class="coping-details">
                    <li>
                        When you have a bad reaction to
                        cannabis, you may begin to worry that
                        something is severely wrong with you
                        or that it may not end.
                    </li>

                    <li>
                        Try to remind yourself that these
                        feelings are temporary and will likely
                        disappear within a few hours.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Sleep it off
                </h4>

                <ul class="coping-details">
                    <li>
                        If you’re experiencing physical or
                        psychological symptoms, sleep might be
                        the best thing for you.
                    </li>

                    <li>
                        You’ll probably feel better when you
                        wake up. Prepare to feel a bit tired
                        and groggy, though.
                    </li>

                    <li>
                        Keep a glass of water handy, and place
                        a bucket next to your bed if you’re
                        feeling nauseous.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Stay hydrated
                </h4>

                <ul class="coping-details">
                    <li>
                        Sip on water.
                    </li>

                    <li>
                        This is especially helpful if you’re
                        experiencing cotton mouth, nausea, or
                        headaches.
                    </li>

                    <li>
                        The repetitive sensation of sipping
                        water may also help you feel a little
                        calmer.
                    </li>

                    <li>
                        If you’ve been throwing up, an
                        electrolyte drink might be helpful.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Relax
                </h4>

                <ul class="coping-details">
                    <li>
                        Overstimulation and stress can make you
                        feel more on edge.
                    </li>

                    <li>
                        If you’re in a crowd or a noisy area,
                        try to go somewhere quiet where you can
                        relax and unwind — even if it’s just a
                        bathroom or toilet stall.
                    </li>

                    <li>
                        Alternatively, getting some fresh air
                        on a balcony or in a garden might help
                        soothe anxiety, nausea, and racing
                        thoughts.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Use heat
                </h4>

                <ul class="coping-details">
                    <li>
                        If you’re experiencing the symptoms of
                        CHS, such as nausea, vomiting, and
                        abdominal pain, heat might be helpful.
                    </li>

                    <li>
                        Although there are currently no formal
                        treatments for CHS, a 2022 review
                        suggested that some people with CHS
                        can frequently take hot baths and
                        showers.
                    </li>

                    <li>
                        This might bring them temporary relief,
                        as can applying capsaicin cream to
                        their stomachs.
                    </li>

                    <li>
                        A hot water bottle may also help.
                    </li>

                    <li>
                        Why heat? It seems that a peripheral
                        tissue receptor interacts with the
                        endocannabinoid system.
                    </li>

                    <li>
                        It is also the only known capsaicin
                        receptor, and heat affects it.
                    </li>
                </ul>

            </li>

        </ol>

        <!-- Display Cannabis Overuse Coping Image -->
        <figure class="coping-image">

            <img
                :src="CannabisOveruseCopingImage"
                alt="Cannabis overuse coping"
            />

        </figure>

    </section>

</template>

<script>
import CannabisOveruseCopingImage from "../../assets/too-much/cannabis-overuse-coping.webp";

export default {
    name: "CannabisOveruseCoping",

    data() {
        return {
            CannabisOveruseCopingImage
        };
    }
};
</script>

<style scoped>

</style>