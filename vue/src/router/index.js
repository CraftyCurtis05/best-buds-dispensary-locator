import {
    createRouter as _createRouter,
    createWebHistory
} from "vue-router";

import AuthService from "../services/AuthService.js";
import profileService from "../services/ProfileService.js";

// Application routes
const routes = [
    {
        path: "/",
        name: "age-confirmation",
        component: () => import("../views/AgeConfirmationView.vue"),
        meta: {
            requiresAuth: false,
            requiresAgeConfirmation: false,
            hideAppLayout: true,
            title: "Age Confirmation | Best Buds"
        }
    },
    {
        path: "/login",
        name: "login",
        component: () => import("../views/LoginView.vue"),
        meta: {
            requiresAuth: false,
            requiresAgeConfirmation: true,
            hideAppLayout: true,
            title: "Login | Best Buds"
        }
    },
    {
        path: "/register",
        name: "register",
        component: () => import("../views/RegisterView.vue"),
        meta: {
            requiresAuth: false,
            requiresAgeConfirmation: true,
            hideAppLayout: true,
            title: "Register | Best Buds"
        }
    },
    {
        path: "/profile-setup",
        name: "profile-setup",
        component: () => import("../views/ProfileSetupView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Profile Setup | Best Buds"
        }
    },
    {
        path: "/home",
        name: "home",
        component: () => import("../views/HomeView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Home | Best Buds"
        }
    },
    {
        path: "/search",
        name: "search",
        component: () => import("../views/SearchView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Search | Best Buds"
        }
    },
    {
        path: "/saved-dispensaries",
        name: "saved-dispensaries",
        component: () => import("../views/SavedDispensariesView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Saved Dispensaries | Best Buds"
        }
    },
    {
        path: "/learn",
        name: "learn",
        component: () => import("../views/LearnView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Learn | Best Buds"
        }
    },
    {
        path: "/tips-tricks",
        name: "tips-tricks",
        component: () => import("../views/TipsTricksView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Tips & Tricks | Best Buds"
        }
    },
    {
        path: "/articles",
        name: "articles",
        component: () => import("../views/ArticlesView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Articles | Best Buds"
        }
    },
    {
        path: "/news",
        name: "news",
        component: () => import("../views/NewsView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "News | Best Buds"
        }
    },
    {
        path: "/about",
        name: "about",
        component: () => import("../views/AboutView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "About Us | Best Buds"
        }
    },
    {
        path: "/profile",
        name: "profile",
        component: () => import("../views/ProfileView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Profile | Best Buds"
        }
    },
    {
        path: "/my-stash",
        name: "my-stash",
        component: () => import("../views/MyStashView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "My Stash | Best Buds"
        }
    },
    {
        path: "/account-settings",
        name: "account-settings",
        component: () => import("../views/AccountSettingsView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Account Settings | Best Buds"
        }
    },
    {
        path: "/safety",
        name: "safety",
        component: () => import("../views/SafetyView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Safety Tips | Best Buds"
        }
    },
    {
        path: "/products",
        name: "products",
        component: () => import("../views/ProductsView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Cannabis Products | Best Buds"
        }
    },
    {
        path: "/strain-guide",
        name: "strain-guide",
        component: () => import("../views/StrainGuideView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Strain Guide | Best Buds"
        }
    },
    {
        path: "/questions",
        name: "questions",
        component: () => import("../views/QuestionsView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Common Questions | Best Buds"
        }
    },
    {
        path: "/too-much",
        name: "too-much",
        component: () => import("../views/TooMuchView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Too Much Cannabis | Best Buds"
        }
    },
    {
        path: "/legality",
        name: "legality",
        component: () => import("../views/LegalityView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Legality | Best Buds"
        }
    },
    {
        path: "/privacy-policy",
        name: "privacy-policy",
        component: () => import("../views/PrivacyPolicyView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Privacy Policy | Best Buds"
        }
    },
    {
        path: "/contact-us",
        name: "contact-us",
        component: () => import("../views/ContactUsView.vue"),
        meta: {
            requiresAuth: true,
            requiresAgeConfirmation: true,
            title: "Contact Us | Best Buds"
        }
    }
];

// Create the application router
export function createRouter(store) {
    const router = _createRouter({
        history: createWebHistory(),
        routes
    });

    // Protect the age gate, authenticated routes,
    // and required onboarding steps
    router.beforeEach(async (to) => {

        const visitorAgeConfirmed =
            sessionStorage.getItem(
                "best-buds-age-confirmed"
            ) === "true";

        const requiresAgeConfirmation =
            to.matched.some(
                (route) =>
                    route.meta.requiresAgeConfirmation
            );

        const requiresAuth =
            to.matched.some(
                (route) =>
                    route.meta.requiresAuth
            );

        // Visitors must pass the age gate before
        // entering any other part of Best Buds
        if (
            requiresAgeConfirmation
            && !visitorAgeConfirmed
        ) {
            return {
                name: "age-confirmation"
            };
        }

        // Age-confirmed visitors no longer need
        // the visitor age gate
        if (
            to.name === "age-confirmation"
            && visitorAgeConfirmed
        ) {

            if (store.state.token !== "") {
                return {
                    name: "home"
                };
            }

            return {
                name: "login"
            };

        }

        // Protected routes require an authenticated session
        if (
            requiresAuth
            && store.state.token === ""
        ) {
            return {
                name: "login"
            };
        }

        // Public routes do not require account onboarding
        if (!requiresAuth) {
            return true;
        }

        // Users must confirm their age on their account
        if (!store.state.user.ageConfirmed) {

            try {

                const confirmationResponse =
                    await AuthService.confirmAge();

                if (confirmationResponse.status === 204) {

                    const updatedUser = {
                        ...store.state.user,
                        ageConfirmed: true
                    };

                    store.commit(
                        "SET_USER",
                        updatedUser
                    );

                }

            } catch {
                return {
                    name: "login"
                };
            }

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

    return router;
}