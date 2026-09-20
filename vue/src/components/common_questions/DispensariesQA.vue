<!-- Dispensaries Q&A Component Display -->
<template>

    <!-- Display Component Body -->
    <body id="dispensaries-body">

        <!-- Display Component Title and Summary -->
        <h1>Dispensaries Q&A</h1>
        <p>***NEED SUMMARY***</p>

        <!-- Display Dispensaries Q&A Component Information -->
        <section id="dispensaries">
            <ol id="list">
                <li>What is a cannabis dispensary?</li>
                <ul id="sub-list">
                    <li>A cannabis dispensary is a licensed retail store where consumers can purchase cannabis products, including flowers, edibles, concentrates, and other related items.</li>
                    <li>Dispensaries operate under state regulations and offer products for both recreational and medicinal use.</li>
                </ul>

                <li>Do I need a medical card to buy from a cannabis dispensary?</li>
                <ul id="sub-list">
                    <li>In places where cannabis is legalized for both recreational and medicinal use, a medical card is only required for purchasing medicinal cannabis.</li>
                    <li>For recreational use, a valid ID proving age (usually 21 or older) is sufficient.</li>
                </ul>

                <li>How can I find a cannabis dispensary near me?</li>
                <ul id="sub-list">
                    <li>You can find nearby dispensaries using our <router-link v-bind:to="{ name:'search' }">dispensary search</router-link>.</li>
                </ul>

                <li>What do I need to bring to a cannabis dispensary?</li>
                <ul id="sub-list">
                    <li>ID:</li>
                    <span>A government-issued photo ID proving you are of legal age (21 or older) is required.</span>
                    <li>Medical Card:</li>
                    <span>If purchasing medicinal cannabis, bring your medical marijuana card and a valid ID.</span>
                </ul>

                <li>What types of products are sold at cannabis dispensaries?</li>
                <ul id="sub-list">
                    <li>Cannabis Flower:</li>
                    <span>Dried buds for smoking or vaporizing.</span>
                    <li>Edibles:</li>
                    <span>Cannabis-infused foods and beverages.</span>
                    <li>Concentrates:</li>
                    <span>Products like oils, waxes, and shatter.</span>
                    <li>Topicals:</li>
                    <span>Creams and balms for topical application.</span>
                    <li>Tinctures:</li>
                    <span>Liquid cannabis extracts.</span>
                </ul>

                <li>How do I know what product to buy?</li>
                <ul id="sub-list">
                    <li>Dispensary staff, often referred to as budtenders, can help guide you based on your preferences, needs, and experience level.</li>
                    <li>They can recommend strains or products that align with your desired effects or medical conditions.</li>
                </ul>

                <li>Are cannabis dispensaries regulated?</li>
                <ul id="sub-list">
                    <li>Yes, cannabis dispensaries are heavily regulated by state and local governments.</li>
                    <li>They must comply with laws regarding product safety, labeling, and sales.</li>
                    <li>Regulations vary by location.</li>
                </ul>

                <li>Can I consume cannabis on-site at a dispensary?</li>
                <ul id="sub-list">
                    <li>Most dispensaries do not allow on-site consumption.</li>
                    <li>Consumption is typically restricted to private residences or designated consumption areas if permitted by local laws.</li>
                </ul>

                <li>Can I return or exchange cannabis products?</li>
                <ul id="sub-list">
                    <li>Policies on returns or exchanges vary by dispensary and state law.</li>
                    <li>Many dispensaries do not accept returns due to the nature of the products, but they may offer exchanges or store credits under certain conditions.</li>
                </ul>

                <li>What are dispensary hours?</li>
                <ul id="sub-list">
                    <li>Dispensary hours vary depending on location and local regulations.</li>
                    <li>Many dispensaries are open during regular business hours, but some may have extended hours or be closed on certain days.</li>
                </ul>

                <li>Do cannabis dispensaries offer delivery?</li>
                <ul id="sub-list">
                    <li>Many dispensaries offer delivery services, though availability depends on local laws and the specific dispensary.</li>
                    <li>Check with your local dispensaries for their delivery options.</li>
                </ul>

                <li>Are there discounts or loyalty programs at dispensaries?</li>
                <ul id="sub-list">
                    <li>Yes, some dispensaries offer discounts, promotions, or loyalty programs.</li>
                    <li>These may include first-time customer discounts, veterans’ discounts, or rewards for frequent purchases.</li>
                </ul>

                <li>How should I store cannabis products from a dispensary?</li>
                <ul id="sub-list">
                    <li>Store cannabis products in a cool, dark place in airtight containers to maintain freshness and potency.</li>
                    <li>Avoid exposure to light, heat, and moisture.</li>
                </ul>

                <li>Can I bring cannabis products from one state to another?</li>
                <ul id="sub-list">
                    <li>Transporting cannabis across state lines is illegal, even if traveling between states where cannabis is legal.</li>
                    <li>Always follow local laws and regulations regarding cannabis transport.</li>
                </ul>

                <li>What should I do if I have issues with a product purchased from a dispensary?</li>
                <ul id="sub-list">
                    <li>Contact the dispensary directly to address any issues.</li>
                    <li>They may offer assistance, such as exchanges or refunds, depending on their policies and the nature of the problem.</li>
                </ul>
            </ol>    
        </section>

    </body>

</template>

<script>
export default {
    name: "DispensariesQA"
};
</script>

<style scoped>

</style>