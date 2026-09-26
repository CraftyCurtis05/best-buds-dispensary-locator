<!-- Contact Us View Display -->
<template>

    <div
        id="contact-us-view"
        aria-labelledby="contact-us-heading"
    >

        <!-- Display Page Introduction -->
        <header id="contact-us-header">

            <h1 id="contact-us-heading">
                Contact Us
            </h1>

            <p>
                Whether you're looking for more information
                on dispensaries, want to share your favorite
                strain, or have a general question, we're
                here to help.
            </p>

        </header>

        <!-- Display Contact Form -->
        <section
            id="contact-us"
            aria-labelledby="contact-form-heading"
        >

            <h2 id="contact-form-heading">
                Send Us a Message
            </h2>

            <p>
                Fill out the form below, and we'll get back
                to you as soon as we can.
            </p>

            <ContactUsForm />

        </section>

    </div>

</template>

<script>
import ContactUsForm from "../components/contact/ContactUsForm.vue";

export default {
    name: "ContactUsView",

    components: {
        ContactUsForm
    }
};
</script>

<style scoped>

</style>