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

        <p>
            Visiting a cannabis dispensary for the first time
            can feel a little intimidating. There are IDs,
            menus, THC percentages, product types, purchase
            limits, and plenty of words you may have never
            heard before.
        </p>

        <p>
            You don't need to walk in already knowing
            everything. A licensed dispensary should provide
            information about the products it sells, and
            knowing a few basics ahead of time can make the
            whole experience a lot easier.
        </p>

        <p>
            The exact rules depend on where you are, so think
            of this as your general U.S. dispensary guide —
            not one state's rulebook.
        </p>

        <!-- Display Before You Go Questions -->
        <h4>
            Before You Go
        </h4>

        <ol class="question-list">

            <li>

                <h5>
                    What is a cannabis dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        A cannabis dispensary is a business
                        authorized under the laws of its
                        jurisdiction to sell cannabis products
                        to eligible customers or patients.
                    </li>

                    <li>
                        Depending on the state and license, a
                        dispensary may serve medical patients,
                        adult-use customers, or both.
                    </li>

                    <li>
                        Dispensaries may sell products such as
                        flower, pre-rolls, edibles, concentrates,
                        vape products, oils, tinctures, topicals,
                        and accessories.
                    </li>

                    <li>
                        What a dispensary is allowed to sell
                        depends on state and sometimes local
                        law.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What's the difference between a medical
                    and adult-use dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        A medical dispensary serves people who
                        qualify under a state's medical cannabis
                        program.
                    </li>

                    <li>
                        An adult-use dispensary serves adults
                        who meet the age and other requirements
                        established by that state's law.
                    </li>

                    <li>
                        Some dispensaries are licensed for both
                        medical and adult-use sales, while
                        others serve only one group.
                    </li>

                    <li>
                        Medical and adult-use customers can
                        have different purchase limits, taxes,
                        product rules, or other requirements
                        depending on the state.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Do I need a medical cannabis card?
                </h5>

                <ul class="answer-list">

                    <li>
                        It depends on the state and the type
                        of dispensary you're visiting.
                    </li>

                    <li>
                        In states with legal adult-use sales,
                        eligible adults generally don't need
                        to participate in the state's medical
                        cannabis program to shop through the
                        adult-use system.
                    </li>

                    <li>
                        Shopping as a medical patient may
                        require a medical cannabis card,
                        registration, certification, or other
                        documentation depending on the state.
                    </li>

                    <li>
                        Don't assume a medical cannabis card
                        from one state will automatically be
                        accepted in another. Reciprocity rules
                        vary.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    How old do I have to be to visit a
                    dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        Age requirements depend on the state
                        and whether you're using an adult-use
                        or medical cannabis program.
                    </li>

                    <li>
                        Adult-use cannabis programs generally
                        use age 21 as the minimum purchasing
                        age.
                    </li>

                    <li>
                        Medical programs can have different
                        rules for adult patients, younger
                        patients, caregivers, and guardians.
                    </li>

                    <li>
                        Check the rules where you're shopping
                        instead of assuming every dispensary
                        follows exactly the same requirements.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What should I bring to a dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        Bring a valid form of identification
                        accepted under the rules where you're
                        shopping.
                    </li>

                    <li>
                        Medical patients should also bring any
                        patient or caregiver documentation
                        required by their state's program.
                    </li>

                    <li>
                        Check the dispensary's payment options
                        before visiting. Cannabis businesses
                        may not offer the same payment options
                        as an ordinary retail store.
                    </li>

                    <li>
                        If you're visiting from another state,
                        check whether your ID is accepted and
                        whether any medical reciprocity rules
                        apply before making the trip.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Why does a dispensary check or scan my ID?
                </h5>

                <ul class="answer-list">

                    <li>
                        Dispensaries need to verify that a
                        customer meets the requirements for
                        the type of cannabis sale being made.
                    </li>

                    <li>
                        That commonly includes checking age
                        and identity and, for medical sales,
                        confirming required patient or
                        caregiver information.
                    </li>

                    <li>
                        How identification information may be
                        scanned, collected, stored, or used
                        can depend on state law, dispensary
                        practices, and the technology being
                        used.
                    </li>

                    <li>
                        If you're concerned about your
                        information, ask the dispensary what
                        it records and why.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    How can I find a dispensary near me?
                </h5>

                <ul class="answer-list">

                    <li>
                        You can use our
                        <router-link
                            :to="{ name: 'search' }"
                        >
                            dispensary search
                        </router-link>
                        to explore nearby cannabis
                        businesses.
                    </li>

                    <li>
                        Before purchasing cannabis, confirm
                        that the business is properly licensed
                        for cannabis sales where it operates.
                    </li>

                    <li>
                        State cannabis regulators often
                        provide license searches or lists of
                        authorized businesses.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    How do I know if a dispensary is licensed?
                </h5>

                <ul class="answer-list">

                    <li>
                        Check with the government agency that
                        regulates cannabis businesses in the
                        state where the dispensary operates.
                    </li>

                    <li>
                        Many state regulators provide an
                        online license lookup, business list,
                        or verification tool.
                    </li>

                    <li>
                        Don't assume that a professional
                        website, delivery service, social
                        media page, or storefront means a
                        business is licensed.
                    </li>

                    <li>
                        The regulated market may include
                        testing, labeling, packaging, and
                        tracking requirements that don't
                        necessarily exist with an unregulated
                        seller.
                    </li>

                </ul>

            </li>

        </ol>

        <!-- Display Shopping Questions -->
        <h4>
            While You're Shopping
        </h4>

        <ol class="question-list">

            <li>

                <h5>
                    What is a budtender?
                </h5>

                <ul class="answer-list">

                    <li>
                        "Budtender" is a common name for a
                        dispensary employee who helps customers
                        understand available cannabis products.
                    </li>

                    <li>
                        They may be able to explain product
                        types, THC and CBD information,
                        cannabinoid labels, terpene information,
                        prices, and how products are intended
                        to be used.
                    </li>

                    <li>
                        Their training and legal role can vary
                        considerably by state and employer.
                    </li>

                    <li>
                        A budtender isn't automatically a
                        doctor, pharmacist, or other licensed
                        healthcare professional.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What are good questions to ask a
                    budtender?
                </h5>

                <ul class="answer-list">

                    <li>
                        Ask what kind of product you're
                        looking at and how it's intended to
                        be used.
                    </li>

                    <li>
                        Ask how much THC and CBD are in one
                        serving and in the entire package.
                    </li>

                    <li>
                        Ask whether the product has other
                        cannabinoids or ingredients you
                        should know about.
                    </li>

                    <li>
                        Ask where the testing or batch
                        information can be found.
                    </li>

                    <li>
                        For unfamiliar products, ask how
                        quickly effects generally begin and
                        how the route of use differs from
                        products you've used before.
                    </li>

                    <li>
                        You don't need to pretend you know
                        cannabis vocabulary. Asking what
                        something means is completely normal.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can a budtender tell me what cannabis to
                    use for a medical condition?
                </h5>

                <ul class="answer-list">

                    <li>
                        A budtender can explain products the
                        dispensary carries, but ordinary
                        retail advice isn't the same thing as
                        a medical diagnosis or prescription.
                    </li>

                    <li>
                        Be cautious if someone promises that a
                        particular strain, edible, oil, or
                        other cannabis product will cure or
                        treat a disease.
                    </li>

                    <li>
                        Questions about medical conditions,
                        medications, interactions, pregnancy,
                        or personalized treatment are better
                        discussed with an appropriate
                        healthcare professional.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What types of cannabis products are sold
                    at dispensaries?
                </h5>

                <ul class="answer-list">

                    <li>
                        <strong>Flower:</strong>
                        Dried cannabis commonly smoked or
                        vaporized.
                    </li>

                    <li>
                        <strong>Pre-Rolls:</strong>
                        Cannabis flower already rolled for
                        smoking. Some may also contain
                        concentrates or other cannabis
                        ingredients.
                    </li>

                    <li>
                        <strong>Edibles and Drinks:</strong>
                        Gummies, foods, beverages, and other
                        swallowed cannabis products.
                    </li>

                    <li>
                        <strong>Concentrates:</strong>
                        Products such as wax, shatter, resin,
                        rosin, and other cannabis extracts.
                    </li>

                    <li>
                        <strong>Vape Products:</strong>
                        Cannabis oils or concentrates
                        manufactured for compatible
                        vaporizing devices.
                    </li>

                    <li>
                        <strong>Oils and Tinctures:</strong>
                        Liquid cannabis products used in
                        different ways depending on the
                        product.
                    </li>

                    <li>
                        <strong>Topicals and Transdermals:</strong>
                        Products applied to the skin, although
                        ordinary topicals and transdermal
                        products aren't necessarily the same
                        thing.
                    </li>

                    <li>
                        Available products and potency limits
                        can differ by state.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    How do I read a dispensary menu?
                </h5>

                <ul class="answer-list">

                    <li>
                        Start with the product type instead of
                        immediately choosing the highest THC
                        number or most interesting strain name.
                    </li>

                    <li>
                        Look for THC and CBD content, package
                        size, serving information, ingredients,
                        and how the product is intended to be
                        used.
                    </li>

                    <li>
                        Some menus also show other
                        cannabinoids, terpenes, testing
                        information, harvest or packaging
                        dates, and product ingredients.
                    </li>

                    <li>
                        Ask what a number means if you're not
                        sure. THC may be shown as a percentage,
                        milligrams per serving, milligrams per
                        package, or another measurement
                        depending on the product.
                    </li>

                    <li>
                        A strain name or an
                        Indica/Sativa/Hybrid label shouldn't
                        be treated as a guarantee of how the
                        product will make you feel.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Does the online menu guarantee a product
                    will still be in stock?
                </h5>

                <ul class="answer-list">

                    <li>
                        Not necessarily. Cannabis inventory
                        can change throughout the day.
                    </li>

                    <li>
                        Online menus may update quickly, but
                        the timing and accuracy depend on the
                        dispensary's inventory system.
                    </li>

                    <li>
                        If you're making a special trip for
                        one product, check whether the store
                        offers online ordering or call ahead
                        if needed.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    How do I choose a cannabis product?
                </h5>

                <ul class="answer-list">

                    <li>
                        Start with the product type, how it is
                        used, its THC and CBD content, and how
                        quickly that route can begin affecting
                        you.
                    </li>

                    <li>
                        Think about your previous cannabis
                        experience and whether the product and
                        route are familiar to you.
                    </li>

                    <li>
                        Don't assume higher THC means higher
                        quality or a better experience.
                    </li>

                    <li>
                        Don't rely entirely on Indica,
                        Sativa, Hybrid, or a strain name to
                        predict exactly how you'll feel.
                    </li>

                    <li>
                        Our
                        <router-link
                            :to="{ name: 'products' }"
                        >
                            cannabis product guide
                        </router-link>
                        explains the major product types in
                        plain language.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What should I look for on a cannabis
                    label?
                </h5>

                <ul class="answer-list">

                    <li>
                        Look for THC and CBD information,
                        serving size when applicable, total
                        package amount, ingredients, and
                        directions or warnings.
                    </li>

                    <li>
                        Depending on the state and product,
                        labels may also contain testing
                        information, other cannabinoids,
                        terpenes, batch or lot numbers, and
                        dates.
                    </li>

                    <li>
                        Pay particular attention to the
                        difference between the THC in one
                        serving and the THC in the entire
                        package.
                    </li>

                    <li>
                        Packaging and labeling requirements
                        vary between states, so not every
                        regulated cannabis label will look
                        the same.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What is a Certificate of Analysis?
                </h5>

                <ul class="answer-list">

                    <li>
                        A Certificate of Analysis, or COA, is
                        a laboratory report containing test
                        results for a product or batch.
                    </li>

                    <li>
                        Depending on the testing requirements,
                        it may include cannabinoid
                        concentrations and results for certain
                        contaminants.
                    </li>

                    <li>
                        If you're looking at a COA, make sure
                        it actually matches the product or
                        batch you're buying.
                    </li>

                    <li>
                        Testing requirements vary by state, so
                        don't assume every legal market tests
                        every product in exactly the same way.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Is dispensary cannabis tested and
                    automatically safe?
                </h5>

                <ul class="answer-list">

                    <li>
                        Regulated cannabis programs commonly
                        have product testing requirements, but
                        the exact requirements and standards
                        differ by state.
                    </li>

                    <li>
                        Testing may cover cannabinoid potency
                        and certain contaminants depending on
                        the jurisdiction and product.
                    </li>

                    <li>
                        A product passing required testing
                        doesn't mean it is completely
                        risk-free or appropriate for every
                        person.
                    </li>

                    <li>
                        THC can still impair someone, cannabis
                        can interact with medications or other
                        substances, and different product
                        types have their own risks.
                    </li>

                    <li>
                        Think of testing as one layer of
                        information and regulation — not a
                        guarantee that nothing can go wrong.
                    </li>

                </ul>

            </li>

        </ol>

        <!-- Display Purchasing Questions -->
        <h4>
            Buying Cannabis
        </h4>

        <ol class="question-list">

            <li>

                <h5>
                    Why are there purchase limits?
                </h5>

                <ul class="answer-list">

                    <li>
                        States can limit how much cannabis a
                        customer or patient may purchase or
                        possess.
                    </li>

                    <li>
                        Limits can depend on whether the sale
                        is medical or adult use and may treat
                        flower, concentrates, edibles, and
                        other products differently.
                    </li>

                    <li>
                        A dispensary may track purchases as
                        required by its state's regulatory
                        system.
                    </li>

                    <li>
                        A store's ability to sell you a
                        product doesn't change the possession
                        limits that apply after you leave.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Are purchase limits and possession limits
                    the same thing?
                </h5>

                <ul class="answer-list">

                    <li>
                        Not necessarily.
                    </li>

                    <li>
                        A purchase limit controls how much a
                        dispensary may sell under the
                        applicable rules.
                    </li>

                    <li>
                        A possession limit controls how much
                        cannabis someone may legally possess.
                    </li>

                    <li>
                        Depending on the state, those limits
                        can be structured differently.
                    </li>

                    <li>
                        Check both instead of assuming that
                        whatever a store can sell is
                        automatically the maximum amount you
                        may possess in every situation.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Why are cannabis prices different from
                    one dispensary to another?
                </h5>

                <ul class="answer-list">

                    <li>
                        Prices can vary because of brand,
                        product type, potency, cultivation or
                        manufacturing costs, supply, taxes,
                        local market conditions, and
                        dispensary pricing.
                    </li>

                    <li>
                        Medical and adult-use cannabis may
                        also be taxed differently depending
                        on the state.
                    </li>

                    <li>
                        A more expensive product isn't
                        automatically safer or better, and
                        higher THC isn't automatically a sign
                        of higher quality.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Are cannabis taxes the same everywhere?
                </h5>

                <ul class="answer-list">

                    <li>
                        No. Cannabis taxes can vary
                        substantially between states and
                        sometimes between local jurisdictions.
                    </li>

                    <li>
                        Medical and adult-use purchases may
                        also be treated differently.
                    </li>

                    <li>
                        The menu price may not always tell you
                        the final amount you'll pay after
                        applicable taxes.
                    </li>

                    <li>
                        Check the dispensary's pricing or ask
                        whether displayed prices include tax
                        if you're unsure.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can I pay with a credit or debit card?
                </h5>

                <ul class="answer-list">

                    <li>
                        Payment options vary by dispensary.
                    </li>

                    <li>
                        Cannabis businesses operate within an
                        unusual mix of state and federal law,
                        so payment and banking arrangements
                        can be different from an ordinary
                        retail store.
                    </li>

                    <li>
                        Some locations may accept cash,
                        certain debit transactions, or other
                        payment methods.
                    </li>

                    <li>
                        Check the dispensary's current payment
                        options before visiting instead of
                        assuming a particular card will work.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Do dispensaries offer discounts or
                    loyalty programs?
                </h5>

                <ul class="answer-list">

                    <li>
                        Some do. Promotions, patient
                        discounts, loyalty programs, and other
                        offers depend on the dispensary and
                        applicable rules.
                    </li>

                    <li>
                        Don't let a sale or loyalty reward
                        pressure you into buying more cannabis
                        than you intended or can legally
                        possess.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can I order cannabis online for pickup?
                </h5>

                <ul class="answer-list">

                    <li>
                        Some dispensaries allow customers to
                        reserve or order products online and
                        pick them up at the store.
                    </li>

                    <li>
                        Ordering online doesn't necessarily
                        replace age, identity, patient, or
                        other verification required when the
                        sale is completed.
                    </li>

                    <li>
                        Availability and ordering rules depend
                        on the dispensary and jurisdiction.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can dispensaries deliver cannabis?
                </h5>

                <ul class="answer-list">

                    <li>
                        Delivery is permitted in some
                        jurisdictions and restricted or
                        unavailable in others.
                    </li>

                    <li>
                        Where delivery is legal, rules can
                        cover who may deliver, where
                        deliveries can go, customer
                        verification, payment, and other
                        requirements.
                    </li>

                    <li>
                        Verify that you're ordering through a
                        properly licensed business rather than
                        assuming every cannabis delivery
                        website or social media account is
                        legal.
                    </li>

                </ul>

            </li>

        </ol>

        <!-- Display After Purchase Questions -->
        <h4>
            After You Buy
        </h4>

        <ol class="question-list">

            <li>

                <h5>
                    Can I consume cannabis at a dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        Don't assume purchasing cannabis gives
                        you permission to use it at the store
                        or outside in the parking lot.
                    </li>

                    <li>
                        Some jurisdictions allow separately
                        licensed or authorized cannabis
                        consumption spaces, while many retail
                        dispensaries don't permit on-site
                        consumption.
                    </li>

                    <li>
                        Public-use and indoor-smoking rules
                        can also apply.
                    </li>

                    <li>
                        Ask the dispensary and check local law
                        before consuming on or near the
                        property.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can I open my cannabis purchase in the
                    car?
                </h5>

                <ul class="answer-list">

                    <li>
                        Cannabis-in-vehicle and open-container
                        rules vary by state.
                    </li>

                    <li>
                        Keeping the product closed and stored
                        according to the rules where you're
                        traveling can avoid unnecessary
                        problems.
                    </li>

                    <li>
                        Don't use cannabis while driving, and
                        don't drive while impaired.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can I drive home after visiting a
                    dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        Buying cannabis doesn't make you
                        impaired. Using it can.
                    </li>

                    <li>
                        Don't use cannabis and then drive
                        while you're impaired.
                    </li>

                    <li>
                        If you've consumed cannabis, arrange a
                        sober driver, rideshare, taxi, public
                        transportation, or another safe way
                        home instead of trying to guess
                        whether you're okay to drive.
                    </li>

                    <li>
                        State driving and
                        cannabis-in-vehicle laws can differ,
                        so check the rules where you are.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can I return or exchange cannabis?
                </h5>

                <ul class="answer-list">

                    <li>
                        Return and exchange rules can depend
                        on state regulations and the
                        dispensary's policy.
                    </li>

                    <li>
                        A store may handle defective,
                        damaged, recalled, or incorrect
                        products differently from a product
                        you simply decided you don't want.
                    </li>

                    <li>
                        Keep your receipt and original
                        packaging until you know the product
                        is correct.
                    </li>

                    <li>
                        If there's a problem, contact the
                        dispensary before bringing an opened
                        cannabis product back into the store.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What should I do if a cannabis product
                    seems wrong?
                </h5>

                <ul class="answer-list">

                    <li>
                        Stop using the product if you think
                        something may be wrong with it.
                    </li>

                    <li>
                        Keep the package, label, batch or lot
                        information, and receipt if you still
                        have them.
                    </li>

                    <li>
                        Contact the dispensary and explain the
                        problem.
                    </li>

                    <li>
                        For a possible safety, contamination,
                        labeling, or regulatory problem, your
                        state's cannabis regulator or public
                        health agency may also have a way to
                        report it.
                    </li>

                    <li>
                        A serious medical reaction should be
                        handled as a health issue first, not
                        simply as a customer-service problem.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What happens if a cannabis product is
                    recalled?
                </h5>

                <ul class="answer-list">

                    <li>
                        Don't continue using a product that
                        has been recalled.
                    </li>

                    <li>
                        Check the recall notice for the brand,
                        product, batch or lot information, and
                        instructions for returning or
                        disposing of it.
                    </li>

                    <li>
                        State cannabis regulators may publish
                        recall and safety notices for products
                        sold through their regulated market.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    How should I store cannabis after I leave
                    the dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        Follow the storage directions for the
                        specific product.
                    </li>

                    <li>
                        Keep cannabis securely stored and out
                        of the reach and sight of children
                        and pets.
                    </li>

                    <li>
                        Edibles deserve extra attention
                        because gummies, chocolates, baked
                        goods, and drinks can look like
                        ordinary food.
                    </li>

                    <li>
                        Keeping cannabis in its original,
                        clearly labeled packaging can help
                        prevent accidental mix-ups.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What if a child accidentally eats a
                    cannabis product?
                </h5>

                <ul class="answer-list">

                    <li>
                        Treat accidental cannabis exposure in
                        a child seriously. Children can become
                        very sick after consuming THC,
                        especially from edibles.
                    </li>

                    <li>
                        In the United States, contact Poison
                        Control at
                        <strong>1-800-222-1222</strong>
                        for guidance. Don't wait for symptoms
                        to appear before getting advice.
                    </li>

                    <li>
                        Call 911 for an emergency, including
                        trouble breathing, seizure, collapse,
                        inability to wake the child, or
                        another severe medical problem.
                    </li>

                    <li>
                        Keep the product packaging available
                        so you can explain what may have been
                        consumed.
                    </li>

                </ul>

            </li>

        </ol>

        <!-- Display Travel and Law Questions -->
        <h4>
            Travel & U.S. Law
        </h4>

        <ol class="question-list">

            <li>

                <h5>
                    Can I take cannabis from one state to
                    another?
                </h5>

                <ul class="answer-list">

                    <li>
                        Don't assume cannabis purchased
                        legally in one state can legally be
                        carried into another.
                    </li>

                    <li>
                        Marijuana remains subject to federal
                        controlled-substance law, and crossing
                        state lines can create federal and
                        state-law issues.
                    </li>

                    <li>
                        This matters even when the states on
                        both sides of the border have their
                        own legal cannabis programs.
                    </li>

                    <li>
                        Check the laws that apply before
                        traveling rather than treating a
                        dispensary receipt as permission to
                        carry cannabis anywhere.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Can I take dispensary cannabis onto
                    federal property?
                </h5>

                <ul class="answer-list">

                    <li>
                        State cannabis legalization doesn't
                        automatically apply on federal
                        property or override federal law.
                    </li>

                    <li>
                        Federal buildings, federally
                        controlled lands, and other federal
                        property can have rules that differ
                        from the surrounding state's cannabis
                        laws.
                    </li>

                    <li>
                        Check the rules for the specific place
                        before bringing cannabis with you.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Are dispensary rules the same in every
                    state?
                </h5>

                <ul class="answer-list">

                    <li>
                        No. There isn't one nationwide
                        dispensary rulebook.
                    </li>

                    <li>
                        States can set different rules for
                        medical and adult-use cannabis,
                        licenses, age requirements, purchase
                        and possession limits, product types,
                        testing, labeling, packaging,
                        delivery, taxes, public use, and home
                        growing.
                    </li>

                    <li>
                        Cities and other local governments may
                        also have authority over where
                        cannabis businesses operate and other
                        local cannabis rules.
                    </li>

                    <li>
                        Check our
                        <router-link
                            :to="{ name: 'legality' }"
                        >
                            U.S. cannabis law guide
                        </router-link>
                        for current federal and state
                        information.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    Is marijuana Schedule III now?
                </h5>

                <ul class="answer-list">

                    <li>
                        No. A proposed federal change
                        shouldn't be confused with a completed
                        rescheduling.
                    </li>

                    <li>
                        Federal proceedings in 2026 concern a
                        proposal to transfer marijuana from
                        Schedule I to Schedule III under the
                        Controlled Substances Act.
                    </li>

                    <li>
                        DEA scheduled formal hearings on the
                        proposed change from June 29 through
                        July 15, 2026.
                    </li>

                    <li>
                        Check the
                        <router-link
                            :to="{ name: 'legality' }"
                        >
                            U.S. cannabis law guide
                        </router-link>
                        for the latest federal status.
                    </li>

                </ul>

            </li>

            <li>

                <h5>
                    What's the biggest thing to remember
                    before visiting a dispensary?
                </h5>

                <ul class="answer-list">

                    <li>
                        You don't need to be a cannabis
                        expert before walking through the
                        door.
                    </li>

                    <li>
                        Verify that the dispensary is licensed,
                        bring the required ID or medical
                        documentation, and understand how
                        you'll pay before you go.
                    </li>

                    <li>
                        Once you're there, focus on the
                        product type, THC and CBD information,
                        serving or package amount, and how the
                        product is intended to be used instead
                        of choosing only by strain name or
                        highest THC.
                    </li>

                    <li>
                        Ask questions when something doesn't
                        make sense. That's what this guide —
                        and a good dispensary experience —
                        should help with.
                    </li>

                </ul>

            </li>

        </ol>

        <!-- Display Dispensary Law Information -->
        <aside
            id="dispensary-law"
            aria-labelledby="dispensary-law-heading"
        >

            <h4 id="dispensary-law-heading">
                Dispensaries & U.S. Law in 2026
            </h4>

            <p>
                Cannabis dispensaries operate mainly through
                state and local cannabis systems, and those
                systems aren't the same across the country.
                States can have medical cannabis programs,
                adult-use programs, both, or more limited
                cannabis laws.
            </p>

            <p>
                Where regulated sales exist, rules can differ
                for licensing, customer age, medical
                patients, purchase and possession limits,
                available products, testing, labeling,
                packaging, delivery, taxes, public use,
                transportation, and other parts of the
                cannabis market.
            </p>

            <p>
                A legal sale also doesn't mean cannabis can
                be used anywhere or taken anywhere. Public
                consumption, driving, cannabis in vehicles,
                federal property, and transporting marijuana
                across state lines can involve different
                rules from simply purchasing it at a
                dispensary.
            </p>

            <p>
                State legalization doesn't erase federal
                marijuana law. Federal proceedings in 2026
                concern a proposal to transfer marijuana
                from Schedule I to Schedule III under the
                Controlled Substances Act. DEA scheduled
                formal hearings on that proposal from
                June 29 through July 15, 2026. A proposed
                rescheduling shouldn't be treated as a
                completed change.
            </p>

            <p>
                Before visiting or purchasing from a
                dispensary, check our
                <router-link
                    :to="{ name: 'legality' }"
                >
                    U.S. cannabis law guide
                </router-link>
                and the current cannabis regulator for the
                state you're in.
            </p>

            <p>
                <small>
                    Legal information last reviewed:
                    September 2026.
                </small>
            </p>

        </aside>

    </section>

</template>

<script>
export default {
    name: "DispensaryQuestions"
};
</script>

<style scoped>

</style>