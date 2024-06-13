<template>
    <div class="safety-tips-view">
        <div class="header-nav">
            <div class="header"><Header/></div>
            <div class="nav-bar"><NavBar/></div>
        </div>  
        <div class="safety-tips-thc">
            <h1> Tips for Safer Cannabis(THC) Consumption </h1>
            <div class="thc-tips-list">
            <ul id="verify-meds-health">
                <h2> Verify Your Medication and Health Conditions </h2>
                <li> Consider asking your doctor for advice before sampling THC-infused products. </li>
                <li> If you live in a state where marijuana isn't legal, or you are not comfortable talking to your doctor about it, please call 1-844-LEAF411, a free cannabis hotline staffed by registered nurses. </li>
                <li> Some medical conditions or medications do not mix well with THC or CBD. (Ex: Pregnancy, anxiety meds, blood thinners, etc.) </li>
                <li> It is NEVER okay to use any cannabis products when pregnant or nursing. </li>
            </ul>
            <ul id="labels-start-small">
                <h2> Read Dosing Labels and Start with Small Amounts </h2>
                <li> Everyone responds differently to THC, so rule of thumb is to start with a low dosage and slow usage. </li>
                <li> Recommended start level is just 2.5mg to 5mg at first. </li>
                <li> To prevent overconsumption of edibles, it's recommended to wait at least four(4) hours before consuming any more. </li>
                <li> Just listen to your body, as THC potency can vary between products and strains, along with age, weight, higher elevations and many other factors can play a role. </li>
                <li> While smokables typically take effect sonner than edibles, you still want to give yourself some time to see how you feel before upping the amount. </li>
            </ul>
            <ul id="too-much-edibles">
                <h2> Know When You've Had Too Much </h2>
                <li> There is no known case of a fatal overdose from marijuana; however, using too much can be a major bummer and could even lead to a hospital visit. </li>
                <li> The Centers for Disease Control and Prevention (CDC) says the severe effects that are warning signs you’ve had too much include: </li>
                    <ul><li> Extreme confusion </li> 
                    <li> Anxiety </li>
                    <li> Paranoia </li>
                    <li> Panic </li>
                    <li> Fast heart rate </li>
                    <li> Delusions or hallucinations </li>
                    <li> Increased blood pressure </li>
                    <li> Severe nausea and vomiting </li>
                    </ul>
                <li> If you think you’ve accidentally overdone it, call the American Association of Poison Control Centers at 1-800-222-1222. They’re open 24/7 and are trained to help you. (There aren’t any legal repercussions for calling, either.) </li>
            </ul>
            <ul id="dont-mix">
                <h2> Don't Mix Weed with Other Substances </h2>
                <li> The best way to enjoy your high is to stick to one lane, meaning don’t mix marijuana with other substances, including alcohol. </li>
                <li> There's no need to overdo it. </li>
            </ul>
            <ul id="skip-drive">
                <h2> Skip the Drive If You’re High </h2>
                <li> Just like you shouldn’t drive drunk, you shouldn’t drive high. </li>
                <li> if you’re found with 5 nanograms of active THC in your blood, you can get charged with a DUI. </li>
                <li> Wait out your high at least six(6) hours if you’ve smoked and upwards of eight(8) hours if you’ve consumed edibles before getting behind the wheel. </li>
            </ul>
            </div>
        </div>
        <div class="safety-tips-cbd">
            <h1> Tips for Safer Cannabinol(CBD) Consumption </h1>
            <div class="cbd-tips-list">   
            <ul id="smart-cbd">
                <h2> Smart CBD Consumption </h2>
                <li> Cannabinol(CBD) is another active ingredient in cannabis, but it doesn’t get you high. </li>
                <li> Unlike THC smokables and edibles, you can find hemp-based CBD products containing less than 0.3 percent THC being sold in a variety of stores outside of dispensaries, like health stores, coffee shops and so on. </li>
                <li> Dosing is important as well: Just because a CBD product is low- or no THC doesn’t mean you should swig the whole bottle. </li>
                <li> Pay attention to labeling or consult the manufacturer if you have questions about how much to take. </li>
            </ul>
            <ul id="talk-to-doctor">
                <h2> Talk to Your Doctor Or a Aharmacist </h2>
                <li> Like vitamins, supplements or additives, CBD products can interact with certain medications. </li>
                <li> Ask your doctor or a pharmacist before trying CBD to make sure it’s OK to use with any meds you take or with any medical conditions you might have. </li>
                <li> The Food and Drug Administration(FDA) says pregnant and nursing moms should steer clear of CBD. </li>
            </ul>
            <ul id="fda-stance">
                <h2> Understand the FDA’s Stance </h2>
                <li> To date, the FDA has only approved one CBD-derived drug product: Epidolex, which has to be prescribed by a doctor. </li>
                <li> Aside from that, CBD remedies don’t have the FDA’s stamp of approval. </li>
            </ul>
            <ul id="instructions-ingredients">
                <h2> Read the Instructions & Ingredients </h2>
                <li> Some CBD topicals and edibles are infused with THC, so be sure to read the label. </li>
                <li> CBD products containing THC above levels of 0.3 percent can only be bought at dispensaries. </li>
                <li> However, some dispensaries also sell CBD products not mixed with THC. </li>
                <li> If you’re in doubt, ask your budtender to point you in the right direction and look for the state’s diamond-shaped “THC” Universal Symbol on the product or its packaging to be sure. </li>
                <li> And, of course, always follow the instructions to the letter, starting low and slow, just as you would with THC. </li>
            </ul>
            </div>
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
    name: "safetytips"
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
</style>