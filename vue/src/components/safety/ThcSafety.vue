<!-- THC Consumption Component Display -->
<template>

    <section
        id="thc-consumption"
        aria-labelledby="thc-safety-heading"
    >

        <!-- Display THC Consumption Introduction -->
        <h3 id="thc-safety-heading">
            Safety Tips for Cannabis (THC) Consumption
        </h3>

        <p>
            Start low, go slow — THC edibles are no joke!
            Wait for the magic (it takes a while), keep snacks
            and water handy, and chill in your happy place.
            No mixing with booze, and definitely no driving.
            And remember, stash those treats safely! If you
            overdo it, just relax—time is your friend. By
            following these safety tips, you can enjoy a more
            positive and controlled experience with THC
            edibles:
        </p>

        <!-- Display THC Consumption Safety Tips -->
        <ol class="safety-list">

            <li>

                <h4>
                    Start Low, Go Slow
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Initial Dose:</strong>
                        Begin with a low dose (2.5-5 mg of THC)
                        to gauge your tolerance.
                    </li>

                    <li>
                        <strong>Wait Time:</strong>
                        Wait at least 2 hours before taking
                        more to avoid overconsumption.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Understand Delayed Effects
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Onset Time:</strong>
                        Edibles can take 30 minutes to 2 hours
                        to take effect.
                    </li>

                    <li>
                        <strong>
                            Avoid Premature Consumption:
                        </strong>
                        Resist taking additional edibles if you
                        don’t feel the effects immediately.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Read and Follow Labels
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Dosage:</strong>
                        Check the THC content and serving size
                        on the label.
                    </li>

                    <li>
                        <strong>Servings:</strong>
                        Be aware of how many servings are in
                        each package.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Avoid Mixing with Alcohol or Other
                    Substances
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Increased Effects:</strong>
                        Combining edibles with alcohol or other
                        substances can intensify effects and
                        lead to unwanted reactions.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Consume in a Safe Environment
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Comfortable Setting:</strong>
                        Use edibles in a familiar and
                        comfortable place to minimize anxiety
                        and manage unexpected effects.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Don’t Drive or Operate Machinery
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Impairment:</strong>
                        THC can impair your coordination and
                        reaction time, so avoid driving or
                        operating heavy machinery.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Stay Hydrated and Have Snacks
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Hydrate:</strong>
                        Keep water nearby to counteract dry
                        mouth.
                    </li>

                    <li>
                        <strong>Snacks:</strong>
                        Have snacks on hand for managing
                        increased appetite (the munchies).
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Store Edibles Safely
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Child and Pet Safety:</strong>
                        Keep edibles out of reach of children
                        and pets.
                    </li>

                    <li>
                        <strong>Proper Storage:</strong>
                        Store in a cool, dark place to maintain
                        potency and freshness.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Know How to Handle Overconsumption
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Stay Calm:</strong>
                        If you overconsume, find a quiet place
                        to relax and wait for the effects to
                        subside.
                    </li>

                    <li>
                        <strong>Hydrate:</strong>
                        Drink water and stay calm—effects will
                        wear off with time.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Consult a Healthcare Professional
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Medical Conditions:</strong>
                        If you have any health conditions or
                        are on medication, consult your doctor
                        before using THC edibles.
                    </li>

                    <li>
                        <strong>
                            Avoid If Pregnant Or Nursing:
                        </strong>
                        THC can potentially affect fetal
                        development and may pass into breast
                        milk, impacting your baby’s health.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Avoid Sharing with Others
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Dosage Control:</strong>
                        If sharing, make sure everyone knows
                        the potency and effects of the edibles.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Check Legal Status
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Legal Compliance:</strong>
                        Ensure that THC edibles are legal in
                        your area and purchase from licensed
                        dispensaries.
                    </li>

                    <li>
                        <strong>Laws In Each State:</strong>
                        If you would like to check out the
                        legality of THC consumption in any U.S.
                        state, check out our
                        <router-link
                            :to="{ name: 'legality' }"
                        >
                            state law list
                        </router-link>.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Understand Individual Tolerance
                </h4>

                <ul class="safety-details">
                    <li>
                        <strong>Personal Variation:</strong>
                        THC effects can vary widely between
                        individuals, so what works for one
                        person might not be suitable for
                        another.
                    </li>
                </ul>

            </li>

        </ol>

        <!-- Display THC Safety Image -->
        <figure class="safety-image">

            <img
                :src="ThcSafetyImage"
                alt="THC consumption safety"
            />

        </figure>

    </section>

</template>

<script>
import ThcSafetyImage from "../../assets/safety/thc-safety.webp";

export default {
    name: "ThcSafety",

    data() {
        return {
            ThcSafetyImage
        };
    }
};
</script>

<style scoped>

</style>