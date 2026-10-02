<!-- Contact Us Form Component Display -->
<template>

    <form
        id="contact-us-form"
        @submit.prevent="submitForm"
    >

        <!-- Display Name Field -->
        <div class="form-group">

            <label for="contact-name">
                Name
            </label>

            <input
                id="contact-name"
                v-model.trim="form.name"
                class="form-input"
                type="text"
                name="name"
                autocomplete="name"
                maxlength="100"
                required
            />

        </div>

        <!-- Display Email Field -->
        <div class="form-group">

            <label for="contact-email">
                Email
            </label>

            <input
                id="contact-email"
                v-model.trim="form.email"
                class="form-input"
                type="email"
                name="email"
                autocomplete="email"
                maxlength="254"
                required
            />

        </div>

        <!-- Display Favorite Strain Field -->
        <div class="form-group">

            <label for="favorite-strain">
                Favorite Strain
            </label>

            <input
                id="favorite-strain"
                v-model.trim="form.favoriteStrain"
                class="form-input"
                type="text"
                name="favoriteStrain"
                maxlength="100"
            />

        </div>

        <!-- Display Message Field -->
        <div class="form-group">

            <label for="contact-message">
                Message
            </label>

            <textarea
                id="contact-message"
                v-model.trim="form.message"
                class="form-input"
                name="message"
                rows="6"
                maxlength="2000"
                required
            ></textarea>

        </div>

        <!-- Display Spam Protection -->
        <div
            class="honeypot"
            aria-hidden="true"
        >

            <label for="contact-website">
                Website
            </label>

            <input
                id="contact-website"
                v-model="form.website"
                type="text"
                name="website"
                tabindex="-1"
                autocomplete="off"
            />

        </div>

        <!-- Display Form Status -->
        <p
            v-if="statusMessage"
            role="status"
            aria-live="polite"
        >
            {{ statusMessage }}
        </p>

        <!-- Display Submit Button -->
        <button
            type="submit"
            :disabled="isSubmitting"
        >
            {{ isSubmitting ? "Sending..." : "Submit" }}
        </button>

    </form>

</template>

<script>
import axios from "axios";

export default {
    name: "ContactUsForm",

    data() {
        return {
            form: {
                name: "",
                email: "",
                favoriteStrain: "",
                message: "",
                website: ""
            },

            isSubmitting: false,
            statusMessage: ""
        };
    },

    methods: {

        // Submit the contact form
        async submitForm() {

            this.isSubmitting = true;
            this.statusMessage = "";

            try {

                await axios.post(
                    "/api/contact.php",
                    this.form
                );

                this.statusMessage =
                    "Your message was sent successfully.";

                this.resetForm();

            } catch (error) {

                console.error(
                    "Contact form submission failed:",
                    error
                );

                this.statusMessage =
                    "Your message could not be sent. Please try again.";

            } finally {

                this.isSubmitting = false;

            }

        },

        // Clear the contact form
        resetForm() {

            this.form = {
                name: "",
                email: "",
                favoriteStrain: "",
                message: "",
                website: ""
            };

        }

    }
};
</script>

<style scoped>

/* =========================================================
   Contact Form
   ========================================================= */

#contact-us-form {
    display: grid;

    grid-template-columns:
        repeat(
            2,
            minmax(
                0,
                1fr
            )
        );

    gap: 1rem;

    width:
        min(
            100%,
            48rem
        );

    padding:
        clamp(
            1.2rem,
            4vw,
            1.75rem
        );

    background:
        var(--color-surface);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-large);

    box-shadow:
        0 12px 32px
        var(--color-shadow);
}


/* =========================================================
   Form Group
   ========================================================= */

.form-group {
    display: flex;
    flex-direction: column;

    gap: 0.35rem;

    min-width: 0;
}


/* Message Field */
.form-group:has(
    #contact-message
) {
    grid-column:
        1 / -1;
}


/* Label */
.form-group label {
    color:
        var(--color-text);

    font-size: 0.72rem;
    font-weight: 600;
}


/* =========================================================
   Form Fields
   ========================================================= */

.form-input {
    width: 100%;

    min-height: 2.9rem;

    padding:
        0.65rem
        0.8rem;

    background:
        var(--color-background);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);

    color:
        var(--color-text);

    font-size: 0.82rem;

    resize: vertical;
}


/* Textarea */
textarea.form-input {
    min-height: 10rem;

    line-height: 1.6;
}


/* Field Hover */
.form-input:hover {
    border-color:
        var(--color-border-strong);
}


/* Field Focus */
.form-input:focus {
    border-color:
        var(--color-border-strong);

    outline: none;

    box-shadow:
        0 0 0 3px
        var(--color-primary-soft);
}


/* =========================================================
   Form Status
   ========================================================= */

#contact-us-form
> p[role="status"] {
    grid-column:
        1 / -1;

    margin: 0;

    padding:
        0.8rem
        1rem;

    background:
        var(--color-primary-soft);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-medium);

    color:
        var(--color-primary);

    font-size: 0.76rem;

    line-height: 1.5;
}


/* =========================================================
   Submit Button
   ========================================================= */

#contact-us-form
> button {
    grid-column:
        1 / -1;

    justify-self: start;

    min-width: 8rem;
    min-height: 2.8rem;

    padding:
        0.55rem
        1rem;

    background:
        var(--color-primary);

    border:
        1px solid
        var(--color-primary);

    border-radius:
        var(--border-radius-pill);

    color:
        var(--color-background);

    font-size: 0.76rem;
    font-weight: 600;

    cursor: pointer;

    transition:
        background 160ms ease,
        transform 160ms ease;
}


/* Button Hover */
#contact-us-form
> button:hover:not(:disabled) {
    background:
        var(--color-primary-hover);

    transform:
        translateY(-1px);
}


/* Disabled Button */
#contact-us-form
> button:disabled {
    cursor: not-allowed;

    opacity: 0.5;
}


/* =========================================================
   Honeypot
   ========================================================= */

.honeypot {
    position: absolute;

    width: 1px;
    height: 1px;

    overflow: hidden;

    clip-path:
        inset(50%);

    white-space: nowrap;
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 649.98px) {

    #contact-us-form {
        grid-template-columns: 1fr;
    }


    .form-group:has(
        #contact-message
    ),
    #contact-us-form
    > p[role="status"],
    #contact-us-form
    > button {
        grid-column: auto;
    }


    #contact-us-form
    > button {
        width: 100%;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    #contact-us-form
    > button {
        transition: none;
    }


    #contact-us-form
    > button:hover:not(:disabled) {
        transform: none;
    }

}

</style>