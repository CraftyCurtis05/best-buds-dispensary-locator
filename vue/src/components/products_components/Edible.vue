<!-- Edible Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="edible-body">

        <!-- Display Edibles Information -->
        <section id="edible">
            <h1>Edibles</h1>
            <p>Edibles are food products infused with cannabis extract. Edibles come in many forms, including baked goods, candies, gummies, chocolates, lozenges, and beverages.</p>

            <h2>Pros</h2>
            <ul id="edible-pro">
                <li>Better for patients with respiratory and cardiovascular conditions, or for individuals who want to avoid smoking.</li>
                <li>Come in an infinite array of options, so consumers can take edibles that appeal to their taste buds.</li>
                <li>Can be bought or homemade.</li>
                <li>Last longer than other methods, which can offer prolonged relief from symptoms of medical conditions such as chronic pain.</li>
                <li>A more discreet means of consumption.</li>
                <li> According to a 2016 study, edibles have been anecdotally reported to assist with symptoms of conditions like muscle spasms, pain, nausea and vomiting, cancer, appetite stimulation, and epilepsy, as well as several psychiatric disorders such as depression and PTSD.</li>
            </ul>

            <h2>Cons</h2>
            <ul id="edible-con">
                <li>Effects and benefits take longer to kick in.</li>
                <li>Easy to consume too much, whether by miscalculating dosages or not waiting long enough before taking more.</li>
                <li>Though rare, there is a risk of inducing psychosis when consuming too much.</li>
                <li> Potential side effects associated with overconsumption, such as confusion, anxiety, panic, paranoia, hallucinations, delusions, increased blood pressure, faster heart rate, and nausea.</li>
                <li>According to the same 2016 study, overconsumption of edibles has been linked to: cognitive and motor impairment, extreme sedation, agitation, anxiety, cardiac stress, and vomiting.</li>
            </ul>
        </section>

        <!-- Display Photo -->
        <aside id="photo">
            <img src="@\assets\products_assets\edible.jpg"/>
        </aside>

    </body>

</template>

<script>
export default {
    name: "Edible"
};
</script>

<style scoped>
h1 {
    font-size: 1.3rem;
    padding-top: 2rem;
}

h2 {
    font-size: 1.1rem;
}

ul {
    font-size: 1.15rem;
}

li {
    padding: .15vw;
}

img {
    width: 40rem;
    border: .2rem black solid;
}
</style>