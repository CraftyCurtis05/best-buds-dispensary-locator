<!-- Profile View Display -->
<template>

    <div
        id="profile-view"
        aria-labelledby="profile-heading"
    >

        <!-- =================================================
             Profile Page Introduction
             ================================================= -->

        <header id="profile-header">

            <!-- Header Content -->
            <div class="profile-header-content">

                <p class="profile-eyebrow">
                    Your Best Buds
                </p>

                <h1 id="profile-heading">
                    Your Profile

                    <span>
                        Make It Yours
                    </span>
                </h1>

                <p class="profile-introduction">
                    Manage the information that helps
                    personalize your Best Buds experience.
                </p>

                <p class="profile-description">
                    Update your profile picture and home
                    location, manage dispensaries you've
                    saved, and view the Drops you've
                    collected while exploring Best Buds.
                </p>


                <!-- Profile Areas -->
                <div
                    class="profile-topic-pills"
                    aria-label="Profile areas"
                >

                    <span>
                        Profile Details
                    </span>

                    <span>
                        Saved Dispensaries
                    </span>

                    <span>
                        My Stash
                    </span>

                </div>

            </div>


            <!-- Decorative Profile Graphic -->
            <div
                class="profile-header-visual"
                aria-hidden="true"
            >

                <span class="profile-ring ring-large"></span>
                <span class="profile-ring ring-medium"></span>
                <span class="profile-ring ring-small"></span>


                <div class="profile-center">

                    <span>
                        You
                    </span>

                    <small>
                        Best Buds
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Profile Navigation
             ================================================= -->

        <OnThisPage
            :topics="profileSections"
            heading="Your Profile"
        />


        <!-- =================================================
             Profile Details
             ================================================= -->

        <section
            id="profile-details"
            class="profile-page-section"
            aria-labelledby="profile-details-heading"
        >

            <!-- Section Header -->
            <header class="profile-page-section-header">

                <p class="profile-section-label">
                    Profile
                </p>

                <h2 id="profile-details-heading">
                    Profile Details
                </h2>

                <p>
                    Manage your profile picture, personal
                    information, and saved home location.
                </p>

            </header>


            <!-- Profile Content -->
            <div class="profile-content">

                <!-- Profile Picture -->
                <div class="profile-sidebar">
                    <ProfileImage />
                </div>


                <!-- Profile Information -->
                <div class="profile-main">
                    <ProfileInfo />
                </div>

            </div>

        </section>


        <!-- =================================================
             Saved Dispensaries
             ================================================= -->

        <section
            id="saved-dispensaries"
            class="profile-page-section"
            aria-labelledby="saved-dispensaries-heading"
        >

            <!-- Section Header -->
            <header class="profile-page-section-header">

                <p class="profile-section-label">
                    Places
                </p>

                <h2 id="saved-dispensaries-heading">
                    Saved Dispensaries
                </h2>

                <p>
                    Keep the dispensaries you want to
                    remember in one place.
                </p>

            </header>


            <SavedDispensaries />

        </section>


        <!-- =================================================
             My Stash
             ================================================= -->

        <section
            id="my-stash"
            class="profile-page-section"
            aria-labelledby="my-stash-heading"
        >

            <!-- Section Header -->
            <header class="profile-page-section-header">

                <p class="profile-section-label">
                    Collection
                </p>

                <h2 id="my-stash-heading">
                    My Stash
                </h2>

                <p>
                    View the Best Buds Drops you've
                    discovered while exploring the app.
                </p>

            </header>


            <MyStash />

        </section>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import ProfileImage
    from "../components/profile/ProfileImage.vue";

import ProfileInfo
    from "../components/profile/ProfileInfo.vue";

import SavedDispensaries
    from "../components/dispensaries/SavedDispensaries.vue";

import MyStash
    from "../components/collectibles/MyStash.vue";


export default {

    name: "ProfileView",

    components: {
        OnThisPage,
        ProfileImage,
        ProfileInfo,
        SavedDispensaries,
        MyStash
    },

    data() {

        return {

            // Profile sections used for
            // quick page navigation
            profileSections: [

                {
                    id: "profile-details",
                    label: "Profile Details"
                },

                {
                    id: "saved-dispensaries",
                    label: "Saved Dispensaries"
                },

                {
                    id: "my-stash",
                    label: "My Stash"
                }

            ]

        };

    }

};

</script>


<style scoped>

/* =========================================================
   Profile View
   ========================================================= */

#profile-view {
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
   Profile Header
   ========================================================= */

#profile-header {
    display: grid;

    grid-template-columns:
        minmax(
            0,
            1.35fr
        )
        minmax(
            15rem,
            0.65fr
        );

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


/* Header Content */
.profile-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.profile-eyebrow,
.profile-section-label {
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
#profile-heading {
    margin:
        0
        0
        1.25rem;

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
#profile-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.profile-introduction {
    margin:
        0
        0
        0.8rem;

    color:
        var(--color-text);

    font-size: 1.03rem;

    line-height: 1.7;
}


/* Description */
.profile-description {
    margin:
        0
        0
        1.4rem;

    color:
        var(--color-text-soft);

    font-size: 0.9rem;

    line-height: 1.7;
}


/* =========================================================
   Topic Pills
   ========================================================= */

.profile-topic-pills {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


/* Topic Pill */
.profile-topic-pills span {
    padding:
        0.36rem
        0.65rem;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-primary);

    font-size: 0.62rem;
    font-weight: 600;

    letter-spacing: 0.07em;

    text-transform: uppercase;
}


/* =========================================================
   Decorative Profile Graphic
   ========================================================= */

.profile-header-visual {
    position: relative;

    display: grid;
    place-items: center;

    width:
        min(
            100%,
            18rem
        );

    aspect-ratio: 1;

    margin:
        0
        auto;
}


/* Profile Rings */
.profile-ring {
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


/* Profile Center */
.profile-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    width: 7.5rem;
    height: 7.5rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-border-strong);

    border-radius: 50%;

    color:
        var(--color-background);

    box-shadow:
        0 16px 36px
        var(--color-shadow-strong);
}


/* Center Text */
.profile-center span {
    font-size: 1rem;
    font-weight: 600;

    letter-spacing: 0.08em;

    text-transform: uppercase;
}


.profile-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.54rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


/* =========================================================
   Profile Page Sections
   ========================================================= */

.profile-page-section {
    padding-top:
        clamp(
            3rem,
            7vw,
            5rem
        );
}


/* Section Header */
.profile-page-section-header {
    max-width: 44rem;

    margin-bottom: 1.4rem;
}


/* Section Heading */
.profile-page-section-header h2 {
    margin:
        0
        0
        0.55rem;

    color:
        var(--color-text);

    font-size:
        clamp(
            1.7rem,
            4vw,
            2.5rem
        );

    font-weight: 500;

    line-height: 1.1;

    letter-spacing: -0.03em;
}


/* Section Description */
.profile-page-section-header
> p:last-child {
    margin: 0;

    color:
        var(--color-text-soft);

    line-height: 1.7;
}


/* =========================================================
   Profile Details Layout
   ========================================================= */

.profile-content {
    display: grid;

    grid-template-columns:
        minmax(
            15rem,
            0.6fr
        )
        minmax(
            0,
            1.4fr
        );

    align-items: start;

    gap: 1rem;
}


/* Profile Sidebar */
.profile-sidebar {
    position: sticky;

    top: 7rem;
}


/* =========================================================
   Tablet
   ========================================================= */

@media (max-width: 899.98px) {

    #profile-header {
        grid-template-columns: 1fr;
    }


    .profile-header-visual {
        width: 13rem;
    }


    .profile-content {
        grid-template-columns: 1fr;
    }


    .profile-sidebar {
        position: static;
    }

}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #profile-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #profile-header {
        padding:
            2rem
            1.4rem;
    }


    .profile-header-visual {
        display: none;
    }

}

</style>