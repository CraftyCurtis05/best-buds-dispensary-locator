<!-- Learn View Display -->
<template>

    <div
        id="learn-view"
        aria-labelledby="learn-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="learn-header"
            aria-labelledby="learn-heading"
        >

            <h1 id="learn-heading">
                Learn About Cannabis
            </h1>

            <p>
                Cannabis can feel complicated when you're
                getting started, but it doesn't have to be.
                Best Buds breaks things down into smaller,
                easier-to-explore topics.
            </p>

            <p>
                Start with the basics, explore products and
                strains, learn about safety, or dig deeper
                into the topics that interest you.
            </p>

            <p>
                Best Buds explains both what is currently known
                and where cannabis information can still be
                uncertain, changing, or different from person
                to person.
            </p>

        </header>


        <!-- Display Start Here Learning Section -->
        <section
            id="learn-start-here"
            aria-labelledby="learn-start-here-heading"
        >

            <h2 id="learn-start-here-heading">
                Start Here
            </h2>

            <p>
                New to cannabis or not sure where to begin?
                These topics are a good starting point.
            </p>

            <ul>

                <li>

                    <h3>
                        Getting Started
                    </h3>

                    <p>
                        Explore basic cannabis tips,
                        terminology, products, and things to
                        keep in mind as you learn.
                    </p>

                    <router-link
                        :to="{ name: 'tips-tricks' }"
                    >
                        Explore Getting Started →
                    </router-link>

                </li>

                <li>

                    <h3>
                        Common Questions
                    </h3>

                    <p>
                        Find answers to common questions about
                        cannabis, products, consumption, and
                        everyday use.
                    </p>

                    <router-link
                        :to="{ name: 'questions' }"
                    >
                        Explore Common Questions →
                    </router-link>

                </li>

            </ul>

        </section>


        <!-- Display Know the Plant Learning Section -->
        <section
            id="learn-plant"
            aria-labelledby="learn-plant-heading"
        >

            <h2 id="learn-plant-heading">
                Know the Plant
            </h2>

            <p>
                Learn more about cannabis products, strains,
                cannabinoids, and terpenes.
            </p>

            <ul>

                <li>

                    <h3>
                        Cannabis Products
                    </h3>

                    <p>
                        Explore flower, edibles, wax, oils,
                        tinctures, topicals, and other common
                        cannabis products.
                    </p>

                    <router-link
                        :to="{ name: 'products' }"
                    >
                        Explore Cannabis Products →
                    </router-link>

                </li>

                <li>

                    <h3>
                        Strains &amp; Terpenes
                    </h3>

                    <p>
                        Learn how strains, cannabinoids,
                        aromas, and terpenes can differ across
                        cannabis varieties.
                    </p>

                    <router-link
                        :to="{ name: 'strain-guide' }"
                    >
                        Explore Strains &amp; Terpenes →
                    </router-link>

                </li>

            </ul>

        </section>


        <!-- Display Responsible Use Learning Section -->
        <section
            id="learn-responsibly"
            aria-labelledby="learn-responsibly-heading"
        >

            <h2 id="learn-responsibly-heading">
                Use Responsibly
            </h2>

            <p>
                Understanding safety, moderation, and local
                laws is an important part of learning about
                cannabis.
            </p>

            <ul>

                <li>

                    <h3>
                        Cannabis Safety
                    </h3>

                    <p>
                        Explore practical safety information
                        for THC, CBD, smoking, topicals, and
                        other forms of cannabis use.
                    </p>

                    <router-link
                        :to="{ name: 'safety' }"
                    >
                        Explore Cannabis Safety →
                    </router-link>

                </li>

                <li>

                    <h3>
                        Too Much Cannabis
                    </h3>

                    <p>
                        Learn about signs of cannabis overuse,
                        ways to stay calm, and steps that may
                        help when an experience feels
                        overwhelming.
                    </p>

                    <router-link
                        :to="{ name: 'too-much' }"
                    >
                        Learn What To Do →
                    </router-link>

                </li>

                <li>

                    <h3>
                        Cannabis Legality
                    </h3>

                    <p>
                        Explore information about cannabis
                        laws and why the rules can differ
                        depending on where you are.
                    </p>

                    <router-link
                        :to="{ name: 'legality' }"
                    >
                        Explore Cannabis Legality →
                    </router-link>

                </li>

            </ul>

        </section>


        <!-- Display Deeper Learning Section -->
        <section
            id="learn-deeper"
            aria-labelledby="learn-deeper-heading"
        >

            <h2 id="learn-deeper-heading">
                Dig a Little Deeper
            </h2>

            <p>
                Ready to explore beyond the basics? Take a
                deeper look at cannabis topics through Best
                Buds articles.
            </p>

            <ul>

                <li>

                    <h3>
                        Cannabis Articles
                    </h3>

                    <p>
                        Explore longer-form information about
                        cannabis, research, products, safety,
                        culture, and other topics.
                    </p>

                    <router-link
                        :to="{ name: 'articles' }"
                    >
                        Explore Cannabis Articles →
                    </router-link>

                </li>

            </ul>

        </section>

    </div>

</template>

<script>
export default {
    name: "LearnView"
};
</script>

<style scoped>

</style>