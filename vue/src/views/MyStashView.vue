<!-- My Stash View Display -->
<template>

    <div
        id="my-stash-view"
        aria-labelledby="my-stash-heading"
    >

        <!-- =================================================
             Page Introduction
             ================================================= -->

        <header id="my-stash-header">

            <!-- Header Content -->
            <div>

                <p class="stash-eyebrow">
                    Best Buds Drops
                </p>

                <h1 id="my-stash-heading">
                    My Stash

                    <span>
                        Your Collection
                    </span>
                </h1>

                <p>
                    View the Best Buds Drops you've unlocked
                    while exploring the app.
                </p>

            </div>


            <!-- Decorative Graphic -->
            <div
                class="stash-header-visual"
                aria-hidden="true"
            >

                <span class="stash-ring ring-large"></span>
                <span class="stash-ring ring-medium"></span>
                <span class="stash-ring ring-small"></span>


                <div class="stash-center">

                    <span>
                        Drops
                    </span>

                    <small>
                        Collected
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Collection Information
             ================================================= -->

        <aside class="stash-information">

            <span
                class="stash-information-icon"
                aria-hidden="true"
            >
                ✦
            </span>

            <div>

                <h2>
                    Explore. Discover. Collect.
                </h2>

                <p>
                    Drops are collectible Best Buds artwork
                    unlocked as you explore different parts
                    of the app.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Best Buds Drops
             ================================================= -->

        <section
            id="stash-collection"
            aria-labelledby="stash-collection-heading"
        >

            <header class="stash-section-header">

                <p class="stash-eyebrow">
                    Collection
                </p>

                <h2 id="stash-collection-heading">
                    Your Drops
                </h2>

            </header>


            <MyStash />

        </section>

    </div>

</template>


<script>

import MyStash
    from "../components/collectibles/MyStash.vue";


export default {

    name: "MyStashView",

    components: {
        MyStash
    }

};

</script>


<style scoped>

#my-stash-view {
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

#my-stash-header {
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
.stash-eyebrow {
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
#my-stash-heading {
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
#my-stash-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Header Description */
#my-stash-header p:last-child {
    max-width: 40rem;

    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Decorative Graphic
   ========================================================= */

.stash-header-visual {
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


.stash-ring {
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


.ring-medium {
    width: 72%;
    height: 72%;
}


.ring-small {
    width: 44%;
    height: 44%;

    border-color:
        var(--color-gold);
}


.stash-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    width: 6.5rem;
    height: 6.5rem;

    background:
        var(--color-primary);

    border-radius: 50%;

    color:
        var(--color-background);

    box-shadow:
        0 15px 34px
        var(--color-shadow-strong);
}


.stash-center span {
    font-size: 0.68rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


.stash-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.52rem;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


/* =========================================================
   Collection Information
   ========================================================= */

.stash-information {
    display: flex;
    align-items: flex-start;

    gap: 0.85rem;

    margin-top: 1rem;

    padding:
        1rem
        1.2rem;

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);
}


.stash-information-icon {
    display: grid;
    place-items: center;

    width: 1.9rem;
    height: 1.9rem;

    flex-shrink: 0;

    background:
        var(--color-gold-soft);

    border-radius: 50%;

    color:
        var(--color-gold-dark);

    font-size: 0.75rem;
}


.stash-information h2 {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text);

    font-size: 0.86rem;
    font-weight: 600;
}


.stash-information p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.6;
}


/* =========================================================
   Collection
   ========================================================= */

#stash-collection {
    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


.stash-section-header {
    margin-bottom: 1.5rem;
}


.stash-section-header h2 {
    margin: 0;

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


/* =========================================================
   Responsive
   ========================================================= */

@media (max-width: 849.98px) {

    #my-stash-header {
        grid-template-columns: 1fr;
    }


    .stash-header-visual {
        width: 12rem;
    }

}


@media (max-width: 575.98px) {

    #my-stash-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #my-stash-header {
        padding:
            2rem
            1.4rem;
    }


    .stash-header-visual {
        display: none;
    }

}

</style>