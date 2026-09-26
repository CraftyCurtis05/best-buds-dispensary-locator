<!-- Dispensaries Q&A Component Display -->
<template>

    <section
        id="dispensaries"
        aria-labelledby="dispensaries-heading"
    >

        <!-- Display Dispensaries Q&A Introduction -->
        <h3 id="dispensaries-heading">
            Dispensaries Q&A
        </h3>

        <!-- Display Dispensaries Questions and Answers -->
        <ol class="question-list">

            <li>

                <h4>
                    What is a cannabis dispensary?
                </h4>

                <ul class="answer-list">
                    <li>
                        A cannabis dispensary is a licensed
                        retail store where consumers can
                        purchase cannabis products, including
                        flowers, edibles, concentrates, and
                        other related items.
                    </li>

                    <li>
                        Dispensaries operate under state
                        regulations and offer products for both
                        recreational and medicinal use.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Do I need a medical card to buy from a
                    cannabis dispensary?
                </h4>

                <ul class="answer-list">
                    <li>
                        In places where cannabis is legalized
                        for both recreational and medicinal
                        use, a medical card is only required
                        for purchasing medicinal cannabis.
                    </li>

                    <li>
                        For recreational use, a valid ID
                        proving age (usually 21 or older) is
                        sufficient.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    How can I find a cannabis dispensary near
                    me?
                </h4>

                <ul class="answer-list">
                    <li>
                        You can find nearby dispensaries using
                        our
                        <router-link
                            :to="{ name: 'search' }"
                        >
                            dispensary search
                        </router-link>.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What do I need to bring to a cannabis
                    dispensary?
                </h4>

                <ul class="answer-list">
                    <li>
                        <strong>ID:</strong>
                        A government-issued photo ID proving
                        you are of legal age (21 or older) is
                        required.
                    </li>

                    <li>
                        <strong>Medical Card:</strong>
                        If purchasing medicinal cannabis, bring
                        your medical marijuana card and a valid
                        ID.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What types of products are sold at cannabis
                    dispensaries?
                </h4>

                <ul class="answer-list">
                    <li>
                        <strong>Cannabis Flower:</strong>
                        Dried buds for smoking or vaporizing.
                    </li>

                    <li>
                        <strong>Edibles:</strong>
                        Cannabis-infused foods and beverages.
                    </li>

                    <li>
                        <strong>Concentrates:</strong>
                        Products like oils, waxes, and shatter.
                    </li>

                    <li>
                        <strong>Topicals:</strong>
                        Creams and balms for topical
                        application.
                    </li>

                    <li>
                        <strong>Tinctures:</strong>
                        Liquid cannabis extracts.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    How do I know what product to buy?
                </h4>

                <ul class="answer-list">
                    <li>
                        Dispensary staff, often referred to as
                        budtenders, can help guide you based on
                        your preferences, needs, and experience
                        level.
                    </li>

                    <li>
                        They can recommend strains or products
                        that align with your desired effects or
                        medical conditions.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Are cannabis dispensaries regulated?
                </h4>

                <ul class="answer-list">
                    <li>
                        Yes, cannabis dispensaries are heavily
                        regulated by state and local
                        governments.
                    </li>

                    <li>
                        They must comply with laws regarding
                        product safety, labeling, and sales.
                    </li>

                    <li>
                        Regulations vary by location.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Can I consume cannabis on-site at a
                    dispensary?
                </h4>

                <ul class="answer-list">
                    <li>
                        Most dispensaries do not allow on-site
                        consumption.
                    </li>

                    <li>
                        Consumption is typically restricted to
                        private residences or designated
                        consumption areas if permitted by local
                        laws.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Can I return or exchange cannabis products?
                </h4>

                <ul class="answer-list">
                    <li>
                        Policies on returns or exchanges vary
                        by dispensary and state law.
                    </li>

                    <li>
                        Many dispensaries do not accept returns
                        due to the nature of the products, but
                        they may offer exchanges or store
                        credits under certain conditions.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What are dispensary hours?
                </h4>

                <ul class="answer-list">
                    <li>
                        Dispensary hours vary depending on
                        location and local regulations.
                    </li>

                    <li>
                        Many dispensaries are open during
                        regular business hours, but some may
                        have extended hours or be closed on
                        certain days.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Do cannabis dispensaries offer delivery?
                </h4>

                <ul class="answer-list">
                    <li>
                        Many dispensaries offer delivery
                        services, though availability depends
                        on local laws and the specific
                        dispensary.
                    </li>

                    <li>
                        Check with your local dispensaries for
                        their delivery options.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Are there discounts or loyalty programs at
                    dispensaries?
                </h4>

                <ul class="answer-list">
                    <li>
                        Yes, some dispensaries offer discounts,
                        promotions, or loyalty programs.
                    </li>

                    <li>
                        These may include first-time customer
                        discounts, veterans’ discounts, or
                        rewards for frequent purchases.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    How should I store cannabis products from a
                    dispensary?
                </h4>

                <ul class="answer-list">
                    <li>
                        Store cannabis products in a cool, dark
                        place in airtight containers to
                        maintain freshness and potency.
                    </li>

                    <li>
                        Avoid exposure to light, heat, and
                        moisture.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    Can I bring cannabis products from one
                    state to another?
                </h4>

                <ul class="answer-list">
                    <li>
                        Transporting cannabis across state
                        lines is illegal, even if traveling
                        between states where cannabis is legal.
                    </li>

                    <li>
                        Always follow local laws and regulations
                        regarding cannabis transport.
                    </li>
                </ul>

            </li>

            <li>

                <h4>
                    What should I do if I have issues with a
                    product purchased from a dispensary?
                </h4>

                <ul class="answer-list">
                    <li>
                        Contact the dispensary directly to
                        address any issues.
                    </li>

                    <li>
                        They may offer assistance, such as
                        exchanges or refunds, depending on
                        their policies and the nature of the
                        problem.
                    </li>
                </ul>

            </li>

        </ol>

    </section>

</template>

<script>
export default {
    name: "DispensaryQuestions"
};
</script>

<style scoped>

</style>