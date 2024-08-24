<!-- Signs and Symptoms Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="symptoms-body">

        <!-- Display Too Much Symptoms Information -->
        <section id="symptoms">
                <h1>Signs and Symptoms</h1>
                <p>Consuming too much cannabis can lead to a range of symptoms, from anxiety to nausea.</p>

                <ol id="list">
                    <li>Physical Symptoms:</li>
                    <ul id="sub-list">
                        <li>Dizziness</li>
                        <li>Dry, red eyes</li>
                        <li>Fatigue or lethargy</li>
                        <li>Headaches</li>
                        <li>Increased heart rate</li>
                        <li>Nausea and change in appetite</li>
                        <li>Thirstiness or a dry mouth (aka “cotton mouth”)</li>
                        <li>Vomiting</li>
                    </ul>

                    <li>Psychological Symptoms:</li>
                    <ul id="sub-list">
                        <li>Anxiety</li>
                        <li>Confusion</li>
                        <li>Difficulty concentrating</li>
                        <li>Mood changes</li>
                        <li>Thoughts racing</li>
                    </ul>

                    <li>In rare cases, it can cause more serious psychological symptoms like:</li>
                    <ul id="sub-list">
                        <li>Hallucinations</li>
                        <li>Panic attacks</li>
                        <li>Paranoia</li>
                    </ul>

                    <li>In some extremely rare cases, cannabis use may contribute to the onset of psychosis. which can include symptoms like:</li>
                    <ul id="sub-list">
                        <li>Delusions</li>
                        <li>Confusion</li>
                        <li>Memory loss</li>
                        <li>Disorganized speech</li>
                        <li>Difficulty feeling or expressing emotions</li>
                    </ul>
                </ol>    
                <mark>If you think you or someone else is experiencing psychosis, contact emergency services or get immediate medical care.</mark>
            </section>

            <aside id="photo">
                <img src="@\assets\toomuch_assets\symptoms.jpg"/>
            </aside>

    </body>

</template>

<script>
export default {
    name: "Symptoms"
};
</script>

<style scoped>
img {
    width: 40rem;
    border: .2rem black solid;
}
</style>