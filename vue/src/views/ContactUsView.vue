<!-- Contact Us Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Contact Us | Best Buds</title>

    <!-- Display Header Component -->
    <header>
        <Header/>
    </header>

    <!-- Display Page Body -->
    <body id="contact-us-body">

        <!-- Display Contact Us Main Content -->
        <main id="contact-us-main">

            <!-- Display Page Title -->
            <h1>Contact Us</h1>

            <!-- Display About Us Information -->
            <section id="contact-us-summary">
                <h2>Using the form below</h2>
                    <p>***NEED ABOUT US SUMMARY***</p>
            </section>

            <!-- Display Contact Us Form -->
            <section id="contact-us-form">
                <form>
                    ***NEED CONTACT US FORM***
                </form>
            </section>

        </main>      

        <!-- Display Page Quote -->
        <h6>***NEED QUOTE***</h6>

    </body>

     <!-- Display Footer Component -->
    <footer>
        <Footer/>
    </footer> 

</template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';

export default {
    name: "contactus",
    components: { Header, Footer }
};
</script>

<style scoped>
.contact-us-view {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

h1,
h2,
h3,
h6 {
    text-align: center;
}

h1 {
    font-size: 1.8em;
    font-weight: bolder;
    margin-top: 4vw;
}

h2 {
    font-size: 1.3em;
    font-weight: light;    
}

h3 {
    font-size: 1.3em;
    font-weight: light;    
}

h6 {
    font-size: .9em;
    font-style: italic;
    font-weight: lighter;
    margin-bottom: 1vw;
}
</style>