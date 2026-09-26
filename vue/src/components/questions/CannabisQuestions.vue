<!-- Cannabis Q&A Component Display -->
<template>

    <section
        id="cannabis"
        aria-labelledby="cannabis-heading"
    >

        <!-- Display Cannabis Q&A Introduction -->
        <h3 id="cannabis-heading">
            Cannabis Q&A
        </h3>

        <!-- Display Cannabis Questions and Answers -->
        <ol class="question-list">

            <li>

                <h4>
                    What is cannabis?
                </h4>

                <ul class="answer-list">
                    <li>
                        Cannabis is a plant genus that includes
                        various species, such as Cannabis
                        sativa, Cannabis indica, and Cannabis
                        ruderalis.
                    </li>

                    <li>
                        It has been used for thousands of years
                        for medicinal, recreational, and
                        industrial purposes.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What are the main components of cannabis?
                </h4>

                <ul class="answer-list">
                    <li>
                        The two primary cannabinoids in
                        cannabis are THC
                        (tetrahydrocannabinol) and CBD
                        (cannabidiol).
                    </li>

                    <li>
                        THC is responsible for most of the
                        psychoactive effects, while CBD is
                        known for its potential therapeutic
                        benefits without causing a high.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What are the different ways to consume
                    cannabis?
                </h4>

                <ul class="answer-list">
                    <li>
                        <strong>Smoking:</strong>
                        Using joints, blunts, pipes, or bongs.
                    </li>

                    <li>
                        <strong>Vaporizing:</strong>
                        Using a vaporizer to heat cannabis
                        without burning it.
                    </li>

                    <li>
                        <strong>Edibles:</strong>
                        Consuming cannabis-infused foods or
                        beverages.
                    </li>

                    <li>
                        <strong>Tinctures:</strong>
                        Using liquid extracts taken under the
                        tongue.
                    </li>

                    <li>
                        <strong>Topicals:</strong>
                        Applying cannabis-infused creams or
                        balms to the skin.
                    </li>

                    <li>
                        <strong>Concentrates:</strong>
                        Consuming highly concentrated forms of
                        cannabis, such as oils, waxes, or
                        shatter.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What are the effects of cannabis?
                </h4>

                <ul class="answer-list">
                    <li>
                        The effects of cannabis can vary
                        depending on the strain, dosage, and
                        individual.
                    </li>

                    <li>
                        Common effects include relaxation,
                        euphoria, altered perception of time,
                        increased appetite, and enhanced
                        sensory experiences.
                    </li>

                    <li>
                        It can also cause dry mouth, red eyes,
                        and sometimes anxiety or paranoia.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    How does cannabis affect the brain?
                </h4>

                <ul class="answer-list">
                    <li>
                        Cannabis interacts with the
                        endocannabinoid system in the brain,
                        primarily affecting areas related to
                        pleasure, memory, and movement.
                    </li>

                    <li>
                        THC binds to cannabinoid receptors,
                        leading to its psychoactive effects.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Can cannabis be addictive?
                </h4>

                <ul class="answer-list">
                    <li>
                        Cannabis has a lower potential for
                        addiction compared to substances like
                        nicotine or opioids, but it is possible
                        to develop a dependence or addiction.
                    </li>

                    <li>
                        Approximately 9% of users may develop a
                        cannabis use disorder, with the risk
                        increasing with frequent use.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Is cannabis legal?
                </h4>

                <ul class="answer-list">
                    <li>
                        The legality of cannabis varies by
                        country and region.
                    </li>

                    <li>
                        In some places, it is legal for both
                        recreational and medicinal use, while
                        in others, it may be legal only for
                        medical purposes or illegal altogether.
                    </li>

                    <li>
                        Always check local laws to ensure
                        compliance by using our
                        <router-link
                            :to="{ name: 'legality' }"
                        >
                            state law map
                        </router-link>.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What are the medical uses of cannabis?
                </h4>

                <ul class="answer-list">
                    <li>
                        Cannabis is used to treat a variety of
                        conditions, including chronic pain,
                        nausea, epilepsy, multiple sclerosis,
                        and certain types of cancer-related
                        symptoms.
                    </li>

                    <li>
                        CBD, in particular, has shown promise
                        in treating conditions like anxiety and
                        epilepsy.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    How does cannabis affect driving?
                </h4>

                <ul class="answer-list">
                    <li>
                        Cannabis impairs motor skills,
                        coordination, and reaction times,
                        making it unsafe to drive under its
                        influence.
                    </li>

                    <li>
                        Many regions have strict laws against
                        driving while impaired by cannabis,
                        similar to alcohol.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What are cannabis strains, and how do they
                    differ?
                </h4>

                <ul class="answer-list">
                    <li>
                        <strong>Sativa:</strong>
                        Often associated with energizing and
                        uplifting effects.
                    </li>

                    <li>
                        <strong>Indica:</strong>
                        Typically provides relaxing and
                        sedative effects.
                    </li>

                    <li>
                        <strong>Hybrid:</strong>
                        A mix of both sativa and indica,
                        combining effects from both types.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    How can I store cannabis properly?
                </h4>

                <ul class="answer-list">
                    <li>
                        Store cannabis in an airtight container
                        in a cool, dark place to maintain its
                        potency and flavor.
                    </li>

                    <li>
                        Avoid exposing it to excessive light,
                        heat, or moisture.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What are terpenes, and why are they
                    important?
                </h4>

                <ul class="answer-list">
                    <li>
                        Terpenes are aromatic compounds found
                        in cannabis (and other plants) that
                        contribute to the plant's scent and
                        flavor.
                    </li>

                    <li>
                        They may also influence the effects of
                        different strains.
                    </li>

                    <li>
                        For example, limonene has a citrus
                        aroma and may have mood-enhancing
                        effects, while myrcene has a musky
                        smell and may contribute to relaxing
                        effects.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Can cannabis interact with other
                    medications?
                </h4>

                <ul class="answer-list">
                    <li>
                        Yes, cannabis can interact with certain
                        medications, potentially affecting
                        their efficacy or increasing side
                        effects.
                    </li>

                    <li>
                        Always consult with a healthcare
                        provider before using cannabis if you
                        are on medication.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What is CBD, and how does it differ from
                    THC?
                </h4>

                <ul class="answer-list">
                    <li>
                        CBD (cannabidiol) is a non-psychoactive
                        cannabinoid that does not produce a
                        high.
                    </li>

                    <li>
                        It is often used for its potential
                        therapeutic benefits, such as reducing
                        anxiety or pain, without the
                        intoxicating effects associated with
                        THC (tetrahydrocannabinol).
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    How can I find the right dosage?
                </h4>

                <ul class="answer-list">
                    <li>
                        Finding the right dosage of cannabis
                        depends on the method of consumption,
                        the strain, and individual tolerance.
                    </li>

                    <li>
                        Start with a low dose and gradually
                        increase until you find the right
                        amount for your needs.
                    </li>

                    <li>
                        Consult with a healthcare professional
                        for personalized advice.
                    </li>
                </ul>

            </li>

        </ol>

    </section>

</template>

<script>
export default {
    name: "CannabisQuestions"
};
</script>

<style scoped>

</style>