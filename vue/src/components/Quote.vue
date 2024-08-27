<!-- Quote Component Display -->
<template>

    <!-- Quote Component Body -->
    <body id="quote-body">

        <!-- Display Random Quote Object From Quotes Array -->
        <section id="quote">
            <h1>"{{ getQuote().quote }}"</h1>
            <h2>{{ quote.author }}</h2>
            <h3>{{ quote.job }}</h3>
        </section>

    </body>

</template>

<script>
import Quotes from '@/assets/quote_assets/quote.js';

export default {
    name: "Quote",

    data() {
        return {
            quotes: Quotes
        }    
    },

    methods: {

        // Create Random Number; Set Variable to Quotes Array[randomIndex]; Return Random Quote Object
        getQuote() {
            const randomIndex = Math.floor(Math.random() * this.quotes.length);
            this.quote = this.quotes[randomIndex];
            return this.quote;
        }
    }
};
</script>

<style scoped>
/* OBJECTS = rem */
/* SPACING = vw */
body {
    margin-inline: 20vw;
}

#quote {
    text-align: center;
    margin-top: 3vw;
}

h1,
h2,
h3 {
    font-weight: lighter;
}

h1 {
    font-size: 1rem;
}

h2 {
    font-size: 1rem;
    margin-top: -.3vw;
}

h3 {
    font-size: .9rem;
    font-style: italic;
    margin-top: -.8vw;
}
</style>