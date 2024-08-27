<!-- Coping Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="coping-body">

         <!-- Display Too Much Coping Information -->
         <section id="coping">
            <h1>Coping Tips:</h1>
            <p>Consuming too much cannabis is rarely a medical emergency, despite how uncomfortable you may feel. Symptoms will subside as the effects wear off. In the meantime, these tips can help things feel more manageable:</p>

            <ol id="list">
                <li>Remember that it will pass</li>
                <ul id="sub-list">
                    <li>When you have a bad reaction to cannabis, you may begin to worry that something is severely wrong with you or that it may not end.</li>
                    <li>Try to remind yourself that these feelings are temporary and will likely disappear within a few hours.</li>
                </ul>    

                <li>Sleep it off</li>
                <ul id="sub-list">
                    <li>If you’re experiencing physical or psychological symptoms, sleep might be the best thing for you.</li>
                    <li>You’ll probably feel better when you wake up. Prepare to feel a bit tired and groggy, though.</li>
                    <li>Keep a glass of water handy, and place a bucket next to your bed if you’re feeling nauseous.</li>
                </ul>    

                <li>Stay hydrated</li>
                <ul id="sub-list">
                    <li>Sip on water.</li>
                    <li>This is especially helpful if you’re experiencing cotton mouth, nausea, or headaches.</li>
                    <li>The repetitive sensation of sipping water may also help you feel a little calmer.</li>
                    <li>If you’ve been throwing up, an electrolyte drink might be helpful.</li>
                </ul>    

                <li>Relax</li>
                <ul id="sub-list">
                    <li>Overstimulation and stress can make you feel more on edge.</li>
                    <li>If you’re in a crowd or a noisy area, try to go somewhere quiet where you can relax and unwind — even if it’s just a bathroom or toilet stall.</li>
                    <li>Alternatively, getting some fresh air on a balcony or in a garden might help soothe anxiety, nausea, and racing thoughts.</li>
                </ul>    

                <li>Use heat</li>
                <ul id="sub-list">
                    <li>If you’re experiencing the symptoms of CHS, such as nausea, vomiting, and abdominal pain, heat might be helpful.</li>
                    <li>Although there are currently no formal treatments for CHS, a 2022 review suggested that some people with CHS can frequently take hot baths and showers.</li>
                    <li>This might bring them temporary relief, as can applying capsaicin cream to their stomachs.</li>
                    <li>A hot water bottle may also help.</li>
                    <li>Why heat? It seems that a peripheral tissue receptor interacts with the endocannabinoid system.</li>
                    <li>It is also the only known capsaicin receptor, and heat affects it.</li>
                </ul>
            </ol>    
        </section>

        <!-- Display Photo -->
        <aside id="photo">
            <img src="@\assets\toomuch_assets\coping.jpg"/>
        </aside>

    </body>

</template>

<script>
export default {
    name: "Coping"
};
</script>

<style scoped>
img {
    width: 40rem;
    border: .2rem black solid;
}
</style>