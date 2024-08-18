<!-- Contact Us Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Contact Us | Best Buds</title>

    <header>
        <!-- Display Header Component -->
        <Header/>
    </header>
    
    <body class="contact-us-view">

        <!-- Display Contact Us Information -->
        <div class="contact-us-info">
            <h1>Contact Us</h1>
            <h2>***PAGE DESCRIPTION***</h2>

            <!-- Display Contact Us Form -->
            <div class="contact-form">
                <h3>***CONTACT FORM***</h3>
            </div>
        </div>  

        <!-- Display Want More Info with Articles Link -->
        <div class="want-more">
            <h5> Want More Information? </h5>
            <div id="articles-link">
                <router-link v-bind:to="{ name:'articles'}"> Visit our articles page for more information! </router-link>
            </div>
        </div> 

        <!-- Display Page Quote -->
        <div id="quote">
            <h6> "NEED NEW QUOTE" -UNKNOWN </h6>
        </div>
    </body>

    <footer>
        <!-- Display Footer Component -->
        <Footer />
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
.want-more,
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

.want-more {
    margin-top: 3vw;
}

#articles-link {
    margin-top: -1vw;
}

h6 {
    font-size: .9em;
    font-style: italic;
    font-weight: lighter;
    margin-bottom: 1vw;
}
</style>