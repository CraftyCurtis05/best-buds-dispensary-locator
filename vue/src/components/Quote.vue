<template>

    <body>

        <section id="quote" v-for="quote in getQuote(quotes)" :key="quote.id">
            <h1>{{ quote.quote }}</h1>
            <h2>{{ quote.author }}</h2>
            <h3>{{ quote.job }}</h3>
        </section>

    </body>

</template>

<script>
import Quotes from '@/assets/quote_assets/quote.js';

export default {
    name: "QuoteComponent",

    data() {
        return {
            quotes: Quotes,
            quote: []
        }    
    },

    methods: {

        getQuote(quotes) {
            const randomIndex = Math.floor(Math.random() * quotes.length);
            let quote = [];
            quote = quotes[randomIndex];
            console.log(quote);
            return quote;
        }
    }
};
</script>

<style scoped>

</style>