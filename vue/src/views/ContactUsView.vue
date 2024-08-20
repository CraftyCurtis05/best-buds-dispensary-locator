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

        <!-- Display Quote Component -->
        <div id="quote">
            <QuoteComponent/>
        </div>  

    </body>

     <!-- Display Footer Component -->
    <footer>
        <Footer/>
    </footer> 

</template>

<script>
import Header from '@/components/Header.vue';
import QuoteComponent from '@/components/Quote.vue';
import Footer from '@/components/Footer.vue';

export default {
    name: "ContactUs",
    components: { Header, QuoteComponent, Footer }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
#contact-us-body {
    width: 100vw;
    max-width: 100%;
    overflow-x: hidden;
    background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
    background-position: center;
    background-size: cover;
    background-attachment: fixed;
}

#contact-us-main {
    margin: 4vw;
}

h1,
h2,
p,
form {
    text-align: center;
}

h1 {
    font-size: 1.6rem;
}

h2 {
    font-size: 1.3rem;

}

p {
    margin: auto 8vw;
}

</style>