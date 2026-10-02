<!-- Saved Dispensaries View Display -->
<template>

    <div
        id="saved-dispensaries-view"
        aria-labelledby="saved-dispensaries-heading"
    >

        <!-- =================================================
             Page Introduction
             ================================================= -->

        <header id="saved-dispensaries-header">

            <!-- Header Content -->
            <div>

                <p class="saved-view-eyebrow">
                    Your Best Buds
                </p>

                <h1 id="saved-dispensaries-heading">
                    Saved Dispensaries

                    <span>
                        Keep Your Favorites Close
                    </span>
                </h1>

                <p>
                    View and manage the dispensaries you've
                    saved while exploring Best Buds.
                </p>

            </div>


            <!-- Decorative Graphic -->
            <div
                class="saved-view-visual"
                aria-hidden="true"
            >

                <span class="saved-ring ring-large"></span>
                <span class="saved-ring ring-small"></span>

                <div class="saved-center">
                    Saved
                </div>

            </div>

        </header>


        <!-- =================================================
             Saved Dispensaries
             ================================================= -->

        <section
            id="saved-dispensaries-content"
            aria-labelledby="
                saved-dispensaries-content-heading
            "
        >

            <header class="saved-view-section-header">

                <p class="saved-view-eyebrow">
                    Your Places
                </p>

                <h2 id="saved-dispensaries-content-heading">
                    Your Saved Locations
                </h2>

                <p>
                    Remove locations you no longer want to
                    keep or return to the locator to find
                    more.
                </p>

            </header>


            <SavedDispensaries />

        </section>

    </div>

</template>


<script>

import SavedDispensaries
    from "../components/dispensaries/SavedDispensaries.vue";


export default {

    name: "SavedDispensariesView",

    components: {
        SavedDispensaries
    }

};

</script>


<style scoped>

#saved-dispensaries-view {
    width:
        min(
            calc(100% - 2rem),
            76rem
        );

    margin:
        0
        auto;

    padding:
        2.5rem
        0
        5rem;
}


/* =========================================================
   Header
   ========================================================= */

#saved-dispensaries-header {
    display: grid;

    grid-template-columns:
        minmax(0, 1.35fr)
        minmax(14rem, 0.65fr);

    align-items: center;

    gap: 3rem;

    padding:
        clamp(
            2rem,
            6vw,
            4rem
        );

    background:
        linear-gradient(
            135deg,
            var(--color-surface),
            var(--color-surface-soft)
        );

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 18px 45px
        var(--color-shadow);
}


/* Eyebrow */
.saved-view-eyebrow {
    margin:
        0
        0
        0.7rem;

    color:
        var(--color-gold-dark);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.17em;

    text-transform: uppercase;
}


/* Main Heading */
#saved-dispensaries-heading {
    margin:
        0
        0
        1rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            2.4rem,
            6vw,
            4.5rem
        );

    font-weight: 500;

    line-height: 1;

    letter-spacing: -0.045em;
}


/* Heading Accent */
#saved-dispensaries-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Header Description */
#saved-dispensaries-header p:last-child {
    max-width: 42rem;

    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Decorative Graphic
   ========================================================= */

.saved-view-visual {
    position: relative;

    display: grid;
    place-items: center;

    width: 15rem;

    max-width: 100%;

    aspect-ratio: 1;

    margin:
        0
        auto;
}


.saved-ring {
    position: absolute;

    border:
        1px solid
        var(--color-gold-soft);

    border-radius: 50%;
}


.ring-large {
    width: 100%;
    height: 100%;
}


.ring-small {
    width: 62%;
    height: 62%;

    border-color:
        var(--color-gold);
}


.saved-center {
    display: grid;
    place-items: center;

    width: 6.5rem;
    height: 6.5rem;

    background:
        var(--color-primary);

    border-radius: 50%;

    color:
        var(--color-background);

    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.12em;

    text-transform: uppercase;

    box-shadow:
        0 15px 34px
        var(--color-shadow-strong);
}


/* =========================================================
   Content
   ========================================================= */

#saved-dispensaries-content {
    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


.saved-view-section-header {
    max-width: 44rem;

    margin-bottom: 1.5rem;
}


.saved-view-section-header h2 {
    margin:
        0
        0
        0.6rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.7rem,
            4vw,
            2.5rem
        );

    font-weight: 500;
}


.saved-view-section-header
> p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Responsive
   ========================================================= */

@media (max-width: 849.98px) {

    #saved-dispensaries-header {
        grid-template-columns: 1fr;
    }


    .saved-view-visual {
        width: 12rem;
    }

}


@media (max-width: 575.98px) {

    #saved-dispensaries-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #saved-dispensaries-header {
        padding:
            2rem
            1.4rem;
    }


    .saved-view-visual {
        display: none;
    }

}

</style>