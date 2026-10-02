<!-- Page Jump Links Component -->
<template>

    <nav
        id="jump-links"
        aria-label="Page navigation shortcuts"
    >

        <!-- Back to Top -->
        <a
            href="#top"
            class="jump-link"
            aria-label="Back to top of page"
        >

            <span
                class="jump-link-icon"
                aria-hidden="true"
            >
                ↑
            </span>

            <span class="jump-link-text">
                Top
            </span>

        </a>


        <!-- Jump to Bottom -->
        <a
            href="#bottom"
            class="jump-link"
            aria-label="Jump to bottom of page"
        >

            <span
                class="jump-link-icon"
                aria-hidden="true"
            >
                ↓
            </span>

            <span class="jump-link-text">
                Bottom
            </span>

        </a>

    </nav>

</template>


<script>

export default {

    name: "JumpLinks"

};

</script>


<style scoped>

/* =========================================================
   Page Jump Links
   ========================================================= */

#jump-links {
    position: fixed;

    right: 1.25rem;
    bottom: 1.25rem;

    display: flex;
    flex-direction: column;

    gap: 0.5rem;

    z-index: 900;
}


/* =========================================================
   Jump Link
   ========================================================= */

.jump-link {
    display: flex;
    align-items: center;

    gap: 0.5rem;

    min-height: 2.75rem;

    padding:
        0.55rem
        0.8rem;

    background:
        var(--color-header-background);

    border:
        1px solid
        var(--color-border);

    border-radius:
        var(--border-radius-pill);

    box-shadow:
        0 8px 22px
        var(--color-shadow);

    color:
        var(--color-text);

    font-size: 0.74rem;
    font-weight: 600;

    text-decoration: none;

    backdrop-filter:
        blur(12px);

    -webkit-backdrop-filter:
        blur(12px);

    transition:
        transform 160ms ease,
        background 160ms ease,
        border-color 160ms ease,
        color 160ms ease;
}


/* Jump Link Hover */
.jump-link:hover {
    background:
        var(--color-primary);

    border-color:
        var(--color-primary);

    color:
        var(--color-background);

    transform:
        translateY(-2px);
}


/* =========================================================
   Jump Link Icon
   ========================================================= */

.jump-link-icon {
    display: grid;
    place-items: center;

    width: 1.5rem;
    height: 1.5rem;

    flex-shrink: 0;

    background:
        var(--color-primary-soft);

    border-radius: 50%;

    color:
        var(--color-primary);

    font-size: 0.8rem;

    transition:
        background 160ms ease,
        color 160ms ease;
}


/* Jump Link Icon Hover */
.jump-link:hover
.jump-link-icon {
    background:
        var(--color-gold);

    color:
        var(--color-background);
}


/* =========================================================
   Mobile
   ========================================================= */

@media (max-width: 575.98px) {

    #jump-links {
        right: 0.75rem;
        bottom: 0.75rem;

        gap: 0.4rem;
    }


    .jump-link {
        width: 2.75rem;
        height: 2.75rem;

        justify-content: center;

        padding: 0;

        border-radius: 50%;
    }


    .jump-link-text {
        position: absolute;

        width: 1px;
        height: 1px;

        margin: -1px;

        overflow: hidden;

        clip: rect(
            0,
            0,
            0,
            0
        );

        white-space: nowrap;
    }


    .jump-link-icon {
        width: 1.65rem;
        height: 1.65rem;
    }

}


/* =========================================================
   Reduced Motion
   ========================================================= */

@media (prefers-reduced-motion: reduce) {

    .jump-link,
    .jump-link-icon {
        transition: none;
    }


    .jump-link:hover {
        transform: none;
    }

}

</style>