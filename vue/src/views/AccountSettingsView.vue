<!-- Account Settings View Display -->
<template>

    <div
        id="account-settings-view"
        aria-labelledby="account-settings-heading"
    >

        <!-- =================================================
             Account Settings Introduction
             ================================================= -->

        <header id="account-settings-header">

            <!-- Header Content -->
            <div class="account-settings-header-content">

                <p class="account-settings-eyebrow">
                    Your Best Buds
                </p>

                <h1 id="account-settings-heading">
                    Account Settings

                    <span>
                        Keep Your Account Current
                    </span>
                </h1>

                <p class="account-settings-introduction">
                    Manage the credentials you use to sign
                    in to Best Buds.
                </p>

                <p class="account-settings-description">
                    Update your username, email address, or
                    password while keeping the rest of your
                    profile information separate.
                </p>


                <!-- Account Areas -->
                <div
                    class="account-settings-pills"
                    aria-label="Account settings"
                >

                    <span>
                        Username
                    </span>

                    <span>
                        Email
                    </span>

                    <span>
                        Password
                    </span>

                </div>

            </div>


            <!-- Decorative Account Graphic -->
            <div
                class="account-settings-visual"
                aria-hidden="true"
            >

                <span class="account-ring ring-large"></span>
                <span class="account-ring ring-medium"></span>
                <span class="account-ring ring-small"></span>


                <div class="account-settings-center">

                    <span>
                        Account
                    </span>

                    <small>
                        Settings
                    </small>

                </div>

            </div>

        </header>


        <!-- =================================================
             Account Security Note
             ================================================= -->

        <aside
            id="account-security-note"
            aria-labelledby="
                account-security-note-heading
            "
        >

            <span
                class="account-security-icon"
                aria-hidden="true"
            >
                i
            </span>


            <div>

                <h2 id="account-security-note-heading">
                    Your Current Password Is Required
                </h2>

                <p>
                    Best Buds asks for your current password
                    before changing important account
                    credentials.
                </p>

            </div>

        </aside>


        <!-- =================================================
             Settings Navigation
             ================================================= -->

        <OnThisPage
            :topics="settingsSections"
            heading="Account Settings"
        />


        <!-- =================================================
             Account Settings Form
             ================================================= -->

        <section
            id="account-settings"
            aria-labelledby="account-settings-form-heading"
        >

            <header class="account-settings-section-header">

                <p class="account-settings-section-label">
                    Sign-In Information
                </p>

                <h2 id="account-settings-form-heading">
                    Manage Your Account
                </h2>

                <p>
                    Choose the account information you want
                    to update below.
                </p>

            </header>


            <AccountSettingsForm />

        </section>

    </div>

</template>


<script>

import OnThisPage
    from "../components/layout/OnThisPage.vue";

import AccountSettingsForm
    from "../components/account/AccountSettingsForm.vue";


export default {

    name: "AccountSettingsView",

    components: {
        OnThisPage,
        AccountSettingsForm
    },

    data() {

        return {

            // Account settings sections used
            // for quick page navigation
            settingsSections: [

                {
                    id: "username-settings",
                    label: "Username"
                },

                {
                    id: "email-settings",
                    label: "Email"
                },

                {
                    id: "password-settings",
                    label: "Password"
                }

            ]

        };

    }

};

</script>


<style scoped>

/* =========================================================
   Account Settings View
   ========================================================= */

#account-settings-view {
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

#account-settings-header {
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
.account-settings-header-content {
    max-width: 47rem;
}


/* Eyebrow */
.account-settings-eyebrow,
.account-settings-section-label {
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
#account-settings-heading {
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
#account-settings-heading span {
    display: block;

    margin-top: 0.1em;

    color:
        var(--color-primary);
}


/* Introduction */
.account-settings-introduction {
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
.account-settings-description {
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
   Setting Pills
   ========================================================= */

.account-settings-pills {
    display: flex;
    flex-wrap: wrap;

    gap: 0.45rem;
}


.account-settings-pills span {
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
   Decorative Graphic
   ========================================================= */

.account-settings-visual {
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


.account-ring {
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


.account-settings-center {
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


.account-settings-center span {
    font-size: 0.7rem;
    font-weight: 600;

    letter-spacing: 0.1em;

    text-transform: uppercase;
}


.account-settings-center small {
    margin-top: 0.2rem;

    color:
        var(--color-gold);

    font-size: 0.54rem;

    letter-spacing: 0.09em;

    text-transform: uppercase;
}


/* =========================================================
   Security Note
   ========================================================= */

#account-security-note {
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


.account-security-icon {
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
    font-weight: 700;
}


#account-security-note h2 {
    margin:
        0
        0
        0.35rem;

    color:
        var(--color-text);

    font-size: 0.86rem;
    font-weight: 600;
}


#account-security-note p {
    margin: 0;

    color:
        var(--color-text-soft);

    font-size: 0.78rem;

    line-height: 1.6;
}


/* =========================================================
   Settings Section
   ========================================================= */

#account-settings {
    padding-top:
        clamp(
            2rem,
            5vw,
            3.5rem
        );
}


.account-settings-section-header {
    max-width: 44rem;

    margin-bottom: 1.5rem;
}


.account-settings-section-header h2 {
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

    line-height: 1.1;

    letter-spacing: -0.03em;
}


.account-settings-section-header
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

    #account-settings-header {
        grid-template-columns: 1fr;
    }


    .account-settings-visual {
        width: 13rem;
    }

}


@media (max-width: 575.98px) {

    #account-settings-view {
        width:
            min(
                calc(100% - 1.5rem),
                76rem
            );

        padding-top: 1.5rem;
    }


    #account-settings-header {
        padding:
            2rem
            1.4rem;
    }


    .account-settings-visual {
        display: none;
    }

}

</style>