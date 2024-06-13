<template>
    <div class="too-much-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>  
        <div class="symptoms-too-much">
            <h1> What To Expect If You've Had Too Much Cannabis </h1>
            <h3> Consuming too much cannabis can lead to a range of symptoms, from anxiety to nausea. </h3>
            <ul class="list">
                <li> Physical Symptoms: </li>
                <ul class="sub-list">
                    <li> Dizziness </li>
                    <li> Dry, red eyes </li>
                    <li> Fatigue or lethargy </li>
                    <li> Headaches </li>
                    <li> Increased heart rate </li>
                    <li> Nausea and change in appetite </li>
                    <li> Thirstiness or a dry mouth (aka “cotton mouth”) </li>
                    <li> Vomiting </li>
                </ul>
            </ul>
            <ul class="list">
                <li> Psychological Symptoms: </li>
                <h4> *High doses of cannabis can also cause psychological symptoms like: </h4>
                <ul class="sub-list">
                    <li> Anxiety </li>
                    <li> Confusion </li>
                    <li> Difficulty concentrating </li>
                    <li> Mood changes </li>
                    <li> Thoughts racing </li>
                </ul>
                <h4> *In rare cases, it can cause more serious psychological symptoms like: </h4>
                <ul class="sub-list">
                    <li> Hallucinations </li>
                    <li> Panic attacks </li>
                    <li> Paranoia </li>
                </ul>
                <h4> *In some extremely rare cases, cannabis use may contribute to the onset of psychosis. which can include symptoms like: </h4>
                <ul class="sub-list">
                    <li> Delusions </li>
                    <li> Confusion </li>
                    <li> Memory loss </li>
                    <li> Disorganized speech </li>
                    <li> Difficulty feeling or expressing emotions </li>
                </ul>
                <h4> If you think you or someone else is experiencing psychosis, contact emergency services or get immediate medical care. </h4>
            </ul>
        </div>
        <div class="coping-tips">
            <h1> Coping Tips: </h1>
            <h3> *Consuming too much cannabis is rarely a medical emergency, despite how uncomfortable you may feel. 
                Symptoms will subside as the effects wear off. In the meantime, these tips can help things feel more manageable: </h3>   
            <ul class="list">
                <li> Remember that it will pass </li>
                <ul class="sub-list">
                    <li> When you have a bad reaction to cannabis, you may begin to worry that something is severely wrong with you or that it may not end. </li>
                    <li> Try to remind yourself that these feelings are temporary and will likely disappear within a few hours. </li>
                </ul>
                <li> Sleep it off </li>
                <ul class="sub-list">
                    <li> If you’re experiencing physical or psychological symptoms, sleep might be the best thing for you. </li>
                    <li> You’ll probably feel better when you wake up. Prepare to feel a bit tired and groggy, though. </li>
                    <li> Keep a glass of water handy, and place a bucket next to your bed if you’re feeling nauseous. </li>
                </ul>
                <li> Stay hydrated </li>
                <ul class="sub-list">
                    <li> Sip on water. </li>
                    <li> This is especially helpful if you’re experiencing cotton mouth, nausea, or headaches. </li>
                    <li> The repetitive sensation of sipping water may also help you feel a little calmer. </li>
                    <li> If you’ve been throwing up, an electrolyte drink might be helpful. </li>
                </ul>
                <li> Relax </li>
                <ul class="sub-list">
                    <li> Overstimulation and stress can make you feel more on edge. </li>
                    <li> If you’re in a crowd or a noisy area, try to go somewhere quiet where you can relax and unwind — even if it’s just a bathroom or toilet stall. </li>
                    <li> Alternatively, getting some fresh air on a balcony or in a garden might help soothe anxiety, nausea, and racing thoughts. </li>
                </ul>
                <li> Use heat </li>
                <ul class="sub-list">
                    <li> If you’re experiencing the symptoms of CHS, such as nausea, vomiting, and abdominal pain, heat might be helpful. </li>
                    <li> Although there are currently no formal treatments for CHS, a 2022 review suggested that some people with CHS can frequently take hot baths and showers. </li>
                    <li> This might bring them temporary relief, as can applying capsaicin cream to their stomachs. </li>
                    <li> A hot water bottle may also help. </li>
                    <li> Why heat? It seems that a peripheral tissue receptor interacts with the endocannabinoid system. </li>
                    <li> It is also the only known capsaicin receptor, and heat affects it. </li>
                </ul>
            </ul>
        </div>
        <div class="what-to-do-too-much">
            <h1> What To Do If You've Had Too Much Cannabis </h1>
            <h3> *While these symptoms usually don’t cause lasting health effects, there are a few cases when you may want to get medical care. </h3>
            <ul class="list">
                <li> Counteract effects with CBD </li>
                <ul class="sub-list">
                    <li> *PUT SOMETHING HERE!!!* </li>
                </ul>
            </ul> 
            <ul class="list">
                <li> Chew on a whole black peppercorn </li>
                <ul class="sub-list">
                    <li> *PUT SOMETHING HERE!!!* </li>
                </ul>
            </ul> 
        </div>
        
        <div class="want-more">
            <h1> Do You Want More Information? </h1>
            <div id="articles-link">
                <router-link v-bind:to="{ name:'articles'}"> Visit our articles page for more information! </router-link>
            </div>
        </div>    
        <div id="quote">
            <h3> "NEED NEW QUOTE" -UNKNOWN </h3>
        </div>
        <div class="footer"><Footer/></div>
    </div>  
  </template>

<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
import NavBar from '../components/NavBar.vue';

export default {
    components: { Header, Footer, NavBar },
    name: "toomuchcannabis"
};
</script>

<style scoped>
.safety-tips-view {
  width: 100vw;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
  margin-top: -1vw;
}

.header-nav {
  position: fixed;
}

h1 {
  text-align: center;
  font-size: 130%;
  font-weight: bolder;
  padding-top: 15%;
}

h2 {
  text-align: center;
  font-size: 105%;
  font-weight: lighter;
}

h3 {
  text-align: center;  
  font-style: italic;
  font-weight: lighter;
  font-size: 100%;
}

h4 {
  font-style: italic;
  font-weight: lighter;
  font-size: 100%;
}
</style>
