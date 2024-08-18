<!-- Legality Page Display --->
<template>

    <!-- Browser Tab Title -->
    <title>Safety Tips | Best Buds</title>

    <header>
        <!-- Display Header Component -->
        <Header/>
    </header>

    <body class="safety-tips-view">
    
        <!-- Display Safety Tips Information -->
        <div class="safety-tips-info">
            <h1>Tips for Safer Consumption, Smoking and Topicals</h1>

            <!-- Display Safety Tips For Safer Cannabis(THC) Consumption -->
            <h2>Safety Tips for Cannabis(THC) Consumption</h2> 
            <ul class="list">
                <h3>Verify Your Medication and Health Conditions</h3>
                <li>Consider asking your doctor for advice before sampling THC-infused products.</li>
                <li>If you live in a state where marijuana isn't legal, or you are not comfortable talking to your doctor about it, please call 1-844-LEAF411, a free cannabis 
                    hotline staffed by registered nurses.</li>
                <li>Some medical conditions or medications do not mix well with THC or CBD. (Ex: Pregnancy, anxiety meds, blood thinners, etc.)</li>
                <li>It is NEVER okay to use any cannabis products when pregnant or nursing.</li>
            </ul>

            <ul class="list">
                <h3>Read Dosing Labels and Start with Small Amounts</h3>
                <li>Everyone responds differently to THC, so rule of thumb is to start with a low dosage and slow usage.</li>
                <li>Recommended start level is just 2.5mg to 5mg at first.</li>
                <li>To prevent overconsumption of edibles, it's recommended to wait at least four(4) hours before consuming any more.</li>
                <li>Just listen to your body, as THC potency can vary between products and strains, along with age, weight, higher elevations and many other factors can play 
                    a role.</li>
                <li>While smokables typically take effect sonner than edibles, you still want to give yourself some time to see how you feel before upping the amount.</li>
            </ul>

            <ul class="list">
                <h3>Know When You've Had Too Much</h3>
                <p>There is no known case of a fatal overdose from marijuana; however, using too much can be a major bummer and could even lead to a hospital visit.</p>
                    <span>The Centers for Disease Control and Prevention (CDC) says the severe effects that are warning signs you’ve had too much include:</span>
                    <li>Extreme confusion</li> 
                    <li>Anxiety</li>
                    <li>Paranoia</li>
                    <li>Panic</li>
                    <li>Fast heart rate</li>
                    <li>Delusions or hallucinations</li>
                    <li>Increased blood pressure</li>
                    <li>Severe nausea and vomiting</li>
                </ul>
                <p>If you think you’ve accidentally overdone it, call the American Association of Poison Control Centers at 1-800-222-1222. 
                    They’re open 24/7 and are trained to help you. (There aren’t any legal repercussions for calling, either.)
                </p>

            <ul class="list">
                <h3>Don't Mix Weed with Other Substances</h3>
                <li>The best way to enjoy your high is to stick to one lane, meaning don’t mix marijuana with other substances, including alcohol.</li>
                <li>There's no need to overdo it.</li>
            </ul>

            <ul class="list">
                <h3>Skip the Drive If You’re High</h3>
                <li>Just like you shouldn’t drive drunk, you shouldn’t drive high.</li>
                <li>If you’re found with 5 nanograms of active THC in your blood, you can get charged with a DUI.</li>
                <li>Wait out your high at least six(6) hours if you’ve smoked and upwards of eight(8) hours if you’ve consumed edibles before getting behind the wheel.</li>
            </ul>

            <!-- Display Safety Tips For Cannabinol(CBD) Consumption -->
            <h2>Safety Tips for Cannabinol(CBD) Consumption</h2> 
            <ul class="list">
                <h3>Smart CBD Consumption</h3>
                <li>Cannabinol(CBD) is another active ingredient in cannabis, but it doesn’t get you high.</li>
                <li>Unlike THC smokables and edibles, you can find hemp-based CBD products containing less than 0.3 percent THC being sold in a variety of stores outside of 
                    dispensaries, like health stores, coffee shops and so on.</li>
                <li>Dosing is important as well: Just because a CBD product is low- or no THC doesn’t mean you should swig the whole bottle.</li>
                <li>Pay attention to labeling or consult the manufacturer if you have questions about how much to take.</li>
            </ul>

            <ul class="list">
                <h3>Talk to Your Doctor Or a Pharmacist</h3>
                <li>Like vitamins, supplements or additives, CBD products can interact with certain medications.</li>
                <li>Ask your doctor or a pharmacist before trying CBD to make sure it’s OK to use with any meds you take or with any medical conditions you might have.</li>
                <li>The Food and Drug Administration(FDA) says pregnant and nursing moms should steer clear of CBD.</li>
            </ul>

            <ul class="list">
                <h3>Understand the FDA’s Stance</h3>
                <li>To date, the FDA has only approved one CBD-derived drug product: Epidolex, which has to be prescribed by a doctor.</li>
                <li>Aside from that, CBD remedies don’t have the FDA’s stamp of approval.</li>
            </ul>

            <ul class="list">
                <h3>Read the Instructions & Ingredients</h3>
                <li>Some CBD topicals and edibles are infused with THC, so be sure to read the label.</li>
                <li>CBD products containing THC above levels of 0.3 percent can only be bought at dispensaries.</li>
                <li>However, some dispensaries also sell CBD products not mixed with THC.</li>
                <li>If you’re in doubt, ask your budtender to point you in the right direction and look for the state’s diamond-shaped “THC” Universal Symbol on the product or its 
                    packaging to be sure.</li>
                <li>And, of course, always follow the instructions to the letter, starting low and slow, just as you would with THC.</li>
            </ul>
            
            <!-- Display Safety Tips for Cannabis Smokers -->
            <h2>Safety Tips for Smoking Cannabis</h2>
            <span>If you've found yourself asking, "What is the first feeling of weed?", it's important to understand that each person's reaction can be quite diverse. 
                As you ponder, "Is it okay to start smoking weed?", remember that preparation is paramount. A comprehensive understanding of the varying cannabis strains, 
                a cautious starting approach, and ensuring a comfortable, secure environment can lay the groundwork for an enjoyable and memorable first-time experience.</span>
            <ul class="list">
                <h3>Understanding Cannabis:</h3>
                <li>Cannabis is a versatile plant with hundreds of strains, each one uniquely characterized by its distinct effects.</li>
                <li>These strains range from those known for inducing relaxation and tranquility to those that stimulate creativity and energy.</li>
                <li>Being aware of these differences is the first step towards selecting a strain that aligns with your expectations and comfort level.</li>
                <li> Please check out our <router-link v-bind:to="{ name:'strainguide'}"> Strain Guide </router-link> for information.</li>
            </ul>

            <ul class="list">
                <h3>How to Enjoy Your First High:</h3>
                <span>To fully appreciate your first cannabis experience, consider these tips for first-time weed smokers:</span>
                <ul class="sub-list">
                    <h7>Choose the Right Strain:</h7>
                    <li>Start with a strain known for its mild and relaxing effects.</li>
                    <li>This can ease you into the world of cannabis, mitigating the potential for any discomfort.</li>
                    <li>Make sure to check out the strain’s potency and pick the dosage accordingly.</li>
                    <li>Always start small - you can get more anytime but if you overdo it, you will ruin your first experience.</li>
                </ul>
                <ul class="sub-list">
                    <h7>Start Slowly:</h7>
                    <li>Moderation is key when starting your cannabis journey.</li>
                    <li>Begin with a small quantity and assess your comfort level and reaction.</li>
                    <li>Remember, you can always smoke more if desired, but reversing the effects of overconsumption can be challenging.</li>
                </ul>
                <ul class="sub-list">
                    <h7>Environment Matters:</h7>
                    <li>The setting in which you consume cannabis can significantly influence your experience.</li>
                    <li>Choose a calm, comfortable, and safe environment where you can relax and enjoy the experience without stress or anxiety.</li>
                </ul>
                <ul class="sub-list">
                    <h7>Have a Sober Friend with You:</h7>
                    <li>For your first time, it's advantageous to have a sober, experienced friend by your side.</li>
                    <li>This person can provide reassurance, guidance, and answer any questions you may have.</li>
                </ul>
                <ul class="sub-list">
                    <h7>Stay Hydrated:</h7>
                    <li>Ensure you drink plenty of water before, during, and after smoking.</li>
                    <li>Hydration can mitigate some of the dry-mouth effects that can come with smoking cannabis.</li>
                </ul>
                <ul class="sub-list">
                    <h7>Eat Before You Smoke:</h7>
                    <li>Cannabis is known to stimulate the appetite.</li>
                    <li>Having a meal before smoking can prevent overeating or choosing unhealthy snacks when the "munchies" kick in.</li>
                </ul>
                <ul class="sub-list">
                    <h7>Listen to Your Body:</h7>
                    <li>Respect your body's signals.</li>    
                    <li>If at any point you feel uncomfortable or anxious, stop and take a break.</li>
                    <li>Your comfort and safety should always be the priority.</li>
                </ul>
                <ul class="sub-list">
                    <h7>Stay calm:</h7>
                    <li>Fight back with cannabidiol (CBD) - an anxiety-fighting compound that comes handy when it comes to fighting pot jitters.</li>
                    <li>Fight back with black pepper. Both pot and pepper affect the body’s endocannabinoid system. The phytocannabinoid-terpenoid effect not only kills anxiety, 
                        but it also helps with addiction, depression, as well as pain.</li>
                    <li>Don’t panic! You can’t overdose (OD) and die on weed. What hospital Emergency Rooms (ERs) are reporting is increased panic attacks and anxiety reactions, 
                        not overdoses. No one is suffering systemic organ failures, or losing their lives because they ingested too much pot.</li>
                    <li>Be smart on dosing. When starting out, limit yourself to only 10 milligrams of Tetrahydrocannabinol (THC) and note how it affects you. If smoking it, 
                        you’ll know within a few minutes how high you’re going to get. If using edibles, wait at least an hour.</li>   
                </ul>
                <p>*Cannabis comes in a variety of forms including edibles and concentrates but they are not the best choice for your first time. Extracts including vape 
                    cartridges are too potent and hard to handle for a novice and edibles are not that predictable in terms of dosage and effects (which depend on numerous 
                    factors like tolerance and the time of onset) the buzz may start hours from ingestion and last for up to 8 hours.</p>
            </ul>

            <!-- Display Tips for Topical Use -->
            <h2>Safety Tips for Topical Use</h2>
            <ul class="list">
                <h3>Verify Your Medication and Health Conditions</h3>
                <li>Consider asking your doctor for advice before sampling THC-infused products.</li>
                <li>If you live in a state where marijuana isn't legal, or you are not comfortable talking to your doctor about it, please call 1-844-LEAF411, a free cannabis 
                    hotline staffed by registered nurses.</li>
                <li>Check ingredients for any allergies before using topicals.</li>
                <li>Some medical conditions or medications do not mix well with THC or CBD. (Ex: Pregnancy, anxiety meds, blood thinners, etc.)</li>
                <li>It is NEVER okay to use any cannabis products when pregnant or nursing.</li>
            </ul>

            <ul class="list">
                <h3>Read Dosing Labels and Start with Small Amounts</h3>
                <li>Everyone responds differently to THC, so rule of thumb is to start with a low dosage and slow usage.</li>
                <li>Just listen to your body, as THC potency can vary between products and strains, along with age, weight, higher elevations and many other factors can play a role.</li>
            </ul>

            <!-- Display Consclusion -->
            <h2>Conclusion:</h2>
            <span>Your first cannabis experience can be a wonderful journey when approached with care and responsibility. As for the question, "Is it better to use weed the 
                first time alone or in company?", having a trusted, sober friend nearby can make the experience more comforting and enjoyable. By following the tips shared in 
                this guide, first-time cannabis smokers can look forward to a positive and memorable first high. If you are contemplating using cannabis for the first time, 
                undertake comprehensive research and connect with experienced cannabis users for their insights. This can empower you to make an informed decision about whether 
                cannabis is the right choice for you.</span>
            <p>Remember, responsible consumption is crucial for any enjoyable cannabis experience.</p>
        </div>        

        <!-- Display Strain Guide Link -->
        <div class="strain-guide">
            <h4> What is best for first time cannabis use? </h4>
            <div id="strain-guide-link">              
                <p> Please check out our <router-link v-bind:to="{ name:'strainguide'}"> Strain Guide </router-link> for information. </p>       
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
        <h6>***NEED QUOTE***</h6> 
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
    name: "safetytips",
    components: { Header, Footer }
};
</script>

<style scoped>
.safety-tips-view {
    width: 100vw;
  max-width: 100%;
  overflow-x: hidden;
  background: linear-gradient(0deg, rgba(255, 255, 255, 0.497), rgba(255, 255, 255, 0.881)), url('src\\assets\\green_smoke.png');
  background-position: center;
  background-size: cover;
  background-attachment: fixed;
}

.safety-tips-info {
    margin-left: 5vw;
    margin-right: 5vw;    
}

h1,
h2,
.want-more,
h6 {
  text-align: center;
}

h1 {
  font-size: 1.5em;
  font-weight: bolder;
  margin-top: 4vw;
  padding-bottom: 1vw;
}

h2 {
  font-size: 1.2em;
  font-weight: bolder;
  text-decoration: underline;
  padding-top: 2vw;
  margin-bottom: -.5vw;
}

h3 {
  font-size: 1.1em;
  font-style: italic;
  font-weight: bold;
  margin-bottom: 0vw;
}

h7 {
    font-weight: bold;
}

li {
    font-size: 1em;
    margin-bottom: 1.2vw;
}

.strain-guide {
  margin-left: 7vw;
}

.want-more {
    margin-top: 3vw;
}

#strain-guide-link,
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