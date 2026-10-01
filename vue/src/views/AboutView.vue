<!-- About Us View Display -->
<template>

    <div
        id="about-view"
        aria-labelledby="about-heading"
    >

        <!-- Display Page Introduction -->
        <header id="about-header">

            <h1 id="about-heading">
                About Best Buds
            </h1>

            <p>
                Best Buds is designed to make cannabis
                information easier to find, understand, and
                explore.
            </p>

            <p>
                The app combines dispensary discovery,
                cannabis education, safety information,
                legal context, news, and helpful resources
                in one place.
            </p>

        </header>

        <!-- Display Our Mission -->
        <section
            id="our-mission"
            aria-labelledby="mission-heading"
        >

            <h2 id="mission-heading">
                Our Mission
            </h2>

            <p>
                Our mission is to give people clear,
                approachable information that can help them
                make more informed decisions about cannabis.
            </p>

            <p>
                Cannabis products, effects, laws, and research
                continue to change. Best Buds focuses on
                explaining what is known, what can vary, and
                where users can find additional reliable
                information.
            </p>

        </section>

        <!-- Display What Best Buds Offers -->
        <section
            id="what-we-offer"
            aria-labelledby="what-we-offer-heading"
        >

            <h2 id="what-we-offer-heading">
                What You Can Do With Best Buds
            </h2>

            <ul>

                <li>
                    Find dispensaries near a location or
                    near your saved home address.
                </li>

                <li>
                    Save dispensaries you want to visit
                    again.
                </li>

                <li>
                    Learn about cannabis products, strains,
                    terpenes, safety, and common questions.
                </li>

                <li>
                    Explore cannabis laws and legal
                    differences across the United States.
                </li>

                <li>
                    Read cannabis-related articles and news.
                </li>

                <li>
                    Discover collectible Drops as you
                    explore the app.
                </li>

            </ul>

        </section>

        <!-- Display Information Disclaimer -->
        <section
            id="information-disclaimer"
            aria-labelledby="information-disclaimer-heading"
        >

            <h2 id="information-disclaimer-heading">
                Educational Information
            </h2>

            <p>
                Best Buds provides general educational
                information. It is not a substitute for
                professional medical, legal, or emergency
                advice.
            </p>

            <p>
                Cannabis can affect people differently.
                Product contents, local laws, health risks,
                and individual circumstances can also vary.
                When something matters to your health or
                legal situation, verify it with a qualified
                professional or current government source.
            </p>

        </section>

        <!-- Display Privacy and Security Information -->
        <section
            id="privacy-security"
            aria-labelledby="privacy-security-heading"
        >

            <h2 id="privacy-security-heading">
                Privacy and Security
            </h2>

            <p>
                Best Buds is designed to protect the personal
                information users provide while using the
                application.
            </p>

            <p>
                You can learn more about how information is
                handled in our
                <router-link
                    :to="{ name: 'privacy-policy' }"
                >
                    privacy policy
                </router-link>.
            </p>

        </section>

        <!-- Display Contact Information -->
        <section
            id="get-in-touch"
            aria-labelledby="contact-heading"
        >

            <h2 id="contact-heading">
                Get In Touch
            </h2>

            <p>
                Have a question, suggestion, or feedback about
                Best Buds?
                Visit our
                <router-link
                    :to="{ name: 'contact-us' }"
                >
                    contact page
                </router-link>
                to get in touch.
            </p>

        </section>

    </div>

</template>

<script>
export default {
    name: "AboutView"
};
</script>

<style scoped>

</style>