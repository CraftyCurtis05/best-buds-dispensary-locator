<!-- Strain Guide View Display -->
<template>

    <div
        id="strain-guide-view"
        aria-labelledby="strain-guide-heading"
    >

        <!-- Display Page Introduction -->
        <header
            id="strain-guide-header"
            aria-labelledby="strain-guide-heading"
        >

            <h1 id="strain-guide-heading">
                Strain and Terpene Guide
            </h1>

            <h2>
                Understanding Cannabis Labels Beyond the Name
            </h2>

            <p>
                Cannabis products are often described using strain
                names, Indica, Sativa, Hybrid, cannabinoid content,
                and terpene profiles.
            </p>

            <p>
                These labels can help describe a product, but they
                do not guarantee a specific effect. Products with
                the same strain name can differ in their chemical
                makeup, and people can respond differently to the
                same product.
            </p>

            <p>
                Use this guide to understand common strain terms,
                cannabinoids, terpenes, aromas, and other information
                you may see on cannabis labels.
            </p>

        </header>

        <!-- Display Guide Navigation -->
        <OnThisPage
            :topics="guideSections"
            heading="Guide Topics"
        />

        <!-- Display Strain Guide -->
        <section
            id="strain-guide"
            aria-labelledby="strain-guide-section-heading"
        >

            <h2 id="strain-guide-section-heading">
                Strain Guide
            </h2>

            <!-- Display Strain Guide Navigation -->
            <OnThisPage
                :topics="strainGuideSections"
                heading="Strain Guide Topics"
            />

            <StrainGuide />

        </section>

        <!-- Display Terpene Guide -->
        <section
            id="terpene-guide"
            aria-labelledby="terpene-guide-section-heading"
        >

            <h2 id="terpene-guide-section-heading">
                Terpene Guide
            </h2>

            <!-- Display Terpene Guide Navigation -->
            <OnThisPage
                :topics="terpeneGuideSections"
                heading="Terpene Guide Topics"
            />

            <TerpeneGuide />

        </section>

    </div>

</template>

<script>
import OnThisPage from "../components/layout/OnThisPage.vue";
import StrainGuide from "../components/strain-guide/StrainGuide.vue";
import TerpeneGuide from "../components/strain-guide/TerpeneGuide.vue";

import UserActivityService from "../services/UserActivityService.js";

import {USER_ACTIVITY_TYPES} from "../constants/userActivityTypes.js";

export default {
    name: "StrainGuideView",

    components: {
        OnThisPage,
        StrainGuide,
        TerpeneGuide
    },

    emits: [
        "activity-recorded"
    ],

    data() {
        return {

            // Track strain guide topics viewed during this page visit
            strainGuideObserver: null,
            viewedStrainGuideTopics: new Set(),

            // Main guide sections used for navigation
            guideSections: [
                {
                    id: "strain-guide",
                    label: "Strain 101"
                },
                {
                    id: "terpene-guide",
                    label: "Terpene 101"
                }
            ],

            // Strain guide sections used for navigation
            strainGuideSections: [
                {
                    id: "indica",
                    label: "Indica"
                },
                {
                    id: "sativa",
                    label: "Sativa"
                },
                {
                    id: "hybrid",
                    label: "Hybrid"
                }
            ],

            // Terpene guide sections used for navigation
            terpeneGuideSections: [
                {
                    id: "humulene",
                    label: "Humulene"
                },
                {
                    id: "limonene",
                    label: "Limonene"
                },
                {
                    id: "myrcene",
                    label: "Myrcene"
                },
                {
                    id: "caryophyllene",
                    label: "Caryophyllene"
                },
                {
                    id: "linalool",
                    label: "Linalool"
                },
                {
                    id: "alpha-pinene",
                    label: "Alpha-Pinene"
                },
                {
                    id: "beta-pinene",
                    label: "Beta-Pinene"
                },
                {
                    id: "terpinolene",
                    label: "Terpinolene"
                },
                {
                    id: "ocimene",
                    label: "Ocimene"
                },
                {
                    id: "eucalyptol",
                    label: "Eucalyptol"
                },
                {
                    id: "nerolidol",
                    label: "Nerolidol"
                },
                {
                    id: "borneol",
                    label: "Borneol"
                },
                {
                    id: "camphene",
                    label: "Camphene"
                }
            ]
        };
    },

    mounted() {
        this.observeStrainGuideSections();
    },

    beforeUnmount() {

        if (this.strainGuideObserver) {
            this.strainGuideObserver.disconnect();
        }

    },

    methods: {

        // Watch strain guide sections as the user explores the page
        observeStrainGuideSections() {

            const strainGuideSections = [
                {
                    id: "strain-101",
                    value: "strain-guide"
                },
                {
                    id: "terpene-101",
                    value: "terpenes"
                }
            ];

            this.strainGuideObserver =
                new IntersectionObserver(
                    (entries) => {

                        entries.forEach(
                            (entry) => {

                                if (!entry.isIntersecting) {
                                    return;
                                }

                                const strainGuideTopic =
                                    strainGuideSections.find(
                                        (item) =>
                                            item.id
                                            === entry.target.id
                                    );

                                if (!strainGuideTopic) {
                                    return;
                                }

                                this.recordEducationView(
                                    strainGuideTopic.value
                                );

                            }
                        );

                    },
                    {
                        threshold: 0.1
                    }
                );

            strainGuideSections.forEach(
                (strainGuideTopic) => {

                    const section =
                        document.getElementById(
                            strainGuideTopic.id
                        );

                    if (section) {
                        this.strainGuideObserver.observe(
                            section
                        );
                    }

                }
            );

        },

        // Record an education topic once during this page visit
        recordEducationView(
            educationTopic
        ) {

            if (
                this.viewedStrainGuideTopics.has(
                    educationTopic
                )
            ) {
                return;
            }

            this.viewedStrainGuideTopics.add(
                educationTopic
            );

            UserActivityService
                .createUserActivity(
                    USER_ACTIVITY_TYPES.EDUCATION_VIEW,
                    educationTopic
                )
                .then(() => {

                    this.$emit(
                        "activity-recorded"
                    );

                })
                .catch(() => {

                    this.viewedStrainGuideTopics.delete(
                        educationTopic
                    );

                });

        }

    }
};
</script>

<style scoped>

</style>