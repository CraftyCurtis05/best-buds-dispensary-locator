<!-- Flower Component Body -->
<template>

    <!-- Display Component Body -->
    <body id="flower-body">

        <!-- Display Flower Information -->
        <section id="flower">
            <h1>Flower</h1>
            <p>Cannabis smoking is the inhalation of smoke or vapor released by heating the flowers, leaves, or extracts of cannabis and releasing the main psychoactive chemical, Δ9-tetrahydrocannabinol (THC), which is absorbed into the bloodstream via the lungs. Cannabis can be smoked in a variety of pipe-like implements made in different shapes and of different materials including hand pipes ("bowls"), water pipes ("bongs"), cigarettes ("joints"), or blunts.</p>

            <h2>Pros</h2>
            <ul id="flower-pro">
                <li>Rapid onset rate, which means that consumers will feel effects and benefit from cannabis almost immediately.</li>
                <li>Easier to manage how much is being consumed.</li>
                <li>Delivers higher bioavailability rates in comparison to other methods.</li>
                <li>Effects fade more quickly (about 1-2 hours); overdoing it is more difficult and will wear off sooner and less intensely than with edibles.</li>
                <li>Has a reduced risk of being eaten by pets and children since it does not look like a delicious treat.</li>
                <li>Quick and convenient means of consumption.</li>
            </ul>

            <h2>Cons</h2>
            <ul id="flower-con">
                <li>May compromise respiratory function since some of the same chemicals found in cigarettes can be found in cannabis smoke.</li>
                <li>Has a shorter duration in terms of experiencing effects and benefiting from compounds.</li>
                <li>Compounds can be lost in side-stream smoke.</li>
                <li>Similarly to edibles, and other means of consumption, smoking cannabis with a potency that is too high can lead to adverse effects such as anxiety.</li>
                <li>Emits a noticeable smell.</li>
            </ul>
        </section>

    </body>

</template>

<script>
export default {
    name: "Flower"
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
</style>