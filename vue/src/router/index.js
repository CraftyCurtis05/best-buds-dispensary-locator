import { createRouter, createWebHistory } from "vue-router";
import { useStore } from "vuex";

import profileService from "../services/ProfileService.js";

// Application routes
const routes = [
    {
        path: "/",
        name: "login",
        component: () => import("../views/LoginView.vue"),
        meta: {
            requiresAuth: false,
            title: "Login | Best Buds"
        }
    },
    {
        path: "/register",
        name: "register",
        component: () => import("../views/RegisterView.vue"),
        meta: {
            requiresAuth: false,
            title: "Register | Best Buds"
        }
    },
    {
        path: "/age-confirmation",
        name: "age-confirmation",
        component: () => import("../views/AgeConfirmationView.vue"),
        meta: {
            requiresAuth: true,
            title: "Age Confirmation | Best Buds"
        }
    },
    {
        path: "/profile-setup",
        name: "profile-setup",
        component: () => import("../views/ProfileSetupView.vue"),
        meta: {
            requiresAuth: true,
            title: "Profile Setup | Best Buds"
        }
    },
    {
        path: "/home",
        name: "home",
        component: () => import("../views/HomeView.vue"),
        meta: {
            requiresAuth: true,
            title: "Home | Best Buds"
        }
    },
    {
        path: "/search",
        name: "search",
        component: () => import("../views/SearchView.vue"),
        meta: {
            requiresAuth: true,
            title: "Search | Best Buds"
        }
    },
    {
        path: "/tips-tricks",
        name: "tips-tricks",
        component: () => import("../views/TipsTricksView.vue"),
        meta: {
            requiresAuth: true,
            title: "Tips & Tricks | Best Buds"
        }
    },
    {
        path: "/articles",
        name: "articles",
        component: () => import("../views/ArticlesView.vue"),
        meta: {
            requiresAuth: true,
            title: "Articles | Best Buds"
        }
    },
    {
        path: "/news",
        name: "news",
        component: () => import("../views/NewsView.vue"),
        meta: {
            requiresAuth: true,
            title: "News | Best Buds"
        }
    },
    {
        path: "/about",
        name: "about",
        component: () => import("../views/AboutView.vue"),
        meta: {
            requiresAuth: true,
            title: "About Us | Best Buds"
        }
    },
    {
        path: "/profile",
        name: "profile",
        component: () => import("../views/ProfileView.vue"),
        meta: {
            requiresAuth: true,
            title: "Profile | Best Buds"
        }
    },
    {
        path: "/safety",
        name: "safety",
        component: () => import("../views/SafetyView.vue"),
        meta: {
            requiresAuth: true,
            title: "Safety Tips | Best Buds"
        }
    },
    {
        path: "/products",
        name: "products",
        component: () => import("../views/ProductsView.vue"),
        meta: {
            requiresAuth: true,
            title: "Cannabis Products | Best Buds"
        }
    },
    {
        path: "/strain-guide",
        name: "strain-guide",
        component: () => import("../views/StrainGuideView.vue"),
        meta: {
            requiresAuth: true,
            title: "Strain Guide | Best Buds"
        }
    },
    {
        path: "/questions",
        name: "questions",
        component: () => import("../views/QuestionsView.vue"),
        meta: {
            requiresAuth: true,
            title: "Common Questions | Best Buds"
        }
    },
    {
        path: "/too-much",
        name: "too-much",
        component: () => import("../views/TooMuchView.vue"),
        meta: {
            requiresAuth: true,
            title: "Too Much Cannabis | Best Buds"
        }
    },
    {
        path: "/legality",
        name: "legality",
        component: () => import("../views/LegalityView.vue"),
        meta: {
            requiresAuth: true,
            title: "Legality | Best Buds"
        }
    },
    {
        path: "/privacy-policy",
        name: "privacy-policy",
        component: () => import("../views/PrivacyPolicyView.vue"),
        meta: {
            requiresAuth: true,
            title: "Privacy Policy | Best Buds"
        }
    },
    {
        path: "/contact-us",
        name: "contact-us",
        component: () => import("../views/ContactUsView.vue"),
        meta: {
            requiresAuth: true,
            title: "Contact Us | Best Buds"
        }
    }
];

// Create the application router
const router = createRouter({
    history: createWebHistory(),
    routes
});

// Protect authenticated routes and required onboarding steps
router.beforeEach(async (to) => {
    const store = useStore();

    const requiresAuth =
        to.matched.some(
            (route) => route.meta.requiresAuth
        );

    // Protected routes require an authenticated session
    if (
        requiresAuth
        && store.state.token === ""
    ) {
        return {
            name: "login"
        };
    }

    // Public routes do not require onboarding checks
    if (!requiresAuth) {
        return true;
    }

    // Users must confirm they are 21 or older
    if (!store.state.user.ageConfirmed) {
        if (to.name !== "age-confirmation") {
            return {
                name: "age-confirmation"
            };
        }

        return true;
    }

    // Age-confirmed users no longer need the age gate
    if (to.name === "age-confirmation") {
        return {
            name: "home"
        };
    }

    // Load the user's profile once when needed
    if (!store.state.profileLoaded) {
        try {
            const response =
                await profileService.getProfile();

            if (response.status === 204) {
                store.commit(
                    "SET_PROFILE_MISSING"
                );
            } else {
                store.commit(
                    "SET_PROFILE",
                    response.data
                );
            }
        } catch {
            return {
                name: "login"
            };
        }
    }

    // Users without a profile must complete profile setup
    if (!store.state.profile) {
        if (to.name !== "profile-setup") {
            return {
                name: "profile-setup"
            };
        }

        return true;
    }

    // Users with a profile no longer need profile setup
    if (to.name === "profile-setup") {
        return {
            name: "home"
        };
    }

    return true;
});

// Update the browser title after navigation
router.afterEach((to) => {
    document.title =
        to.meta.title || "Best Buds";
});

export default router;