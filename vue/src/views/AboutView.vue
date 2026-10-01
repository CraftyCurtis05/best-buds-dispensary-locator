<!-- About Us View Display -->
<template>

    <div
        id="about-view"
        aria-labelledby="about-heading"
    >

        <!-- Display Page Introduction -->
        <header id="about-header">

            <h1 id="about-heading">
                We Are Best Buds
            </h1>

            <p>
                At Best Buds, we're dedicated to providing a seamless
                experience for individuals seeking access to legal cannabis
                products. Our platform serves as a comprehensive guide,
                connecting consumers with dispensaries that meet their
                specific needs and preferences. Whether you're a seasoned
                cannabis enthusiast or exploring its benefits for the first
                time, we're here to help you navigate the landscape with ease.
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
                Our mission is simple: to empower individuals with accurate
                information and resources to make informed decisions about
                cannabis consumption. We believe in the transformative power
                of cannabis and its potential to enhance wellness and improve
                lives. By offering a user-friendly platform, we strive to
                foster a supportive community and promote responsible usage.
            </p>

        </section>

        <!-- Display Privacy and Security Information -->
        <section
            id="privacy-security"
            aria-labelledby="privacy-security-heading"
        >

            <h2 id="privacy-security-heading">
                Our Commitment to Privacy and Security
            </h2>

            <p>
                At Best Buds, your privacy and security are our top
                priorities. We adhere to stringent data protection measures
                to safeguard your personal information and ensure a secure
                browsing experience.
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
                Have questions or feedback? We'd love to hear from you!
                Feel free to reach out to our friendly team from our
                <router-link
                    :to="{ name: 'contact-us' }"
                >
                    contact page
                </router-link>
                for assistance or inquiries.
            </p>

        </section>

        <!-- Display Closing Message -->
        <p id="about-closing">
            Thank you for choosing Best Buds as your trusted guide in the
            world of cannabis. Together, let's explore, discover, and embrace
            the benefits of this remarkable plant.
        </p>

    </div>

</template>

<script>
export default {
    name: "AboutView"
};
</script>

<style scoped>

</style>