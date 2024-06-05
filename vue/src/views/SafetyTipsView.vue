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
    name: "SafetyTipsView"
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