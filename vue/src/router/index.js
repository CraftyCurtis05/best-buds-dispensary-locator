import { createRouter, createWebHistory } from 'vue-router';
import { useStore } from 'vuex';

// Import components
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import LogoutView from '../views/LogoutView.vue';
import HomeView from '../views/HomeView.vue';
import SearchView from '../views/SearchView.vue';
import ShopView from '../views/ShopView.vue';
import TipsTricksView from '../views/TipsTricksView.vue';
import ArticlesView from '../views/ArticlesView.vue';
import NewsView from '../views/NewsView.vue';
import AboutUsView from '../views/AboutUsView.vue';
import ProfileView from '../views/ProfileView.vue';
import SafetyTipsView from '../views/SafetyTipsView.vue';
import CannabisProductsView from '../views/CannabisProductsView.vue';
import StrainGuideView from '../views/StrainGuideView.vue';
import CommonQuestionsView from '../views/CommonQuestionsView.vue';
import TooMuchCannabisView from '../views/TooMuchCannabisView.vue';
import LegalityView from '../views/LegalityView.vue';
import PrivacyPolicyView from '../views/PrivacyPolicyView.vue';
import ContactUsView from '../views/ContactUsView.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false,
      title: 'Login | Best Buds'
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false,
      title: 'Register | Best Buds'
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false,
      title: 'Logout | Best Buds'
    }
  },
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true,
      title: 'Home | Best Buds'
    }
  },
  {
    path: "/search",
    name: "search",
    component: SearchView,
    meta: {
      requiresAuth: true,
      title: 'Search | Best Buds'
    }
  },
  {
    path: "/shop",
    name: "shop",
    component: ShopView,
    meta: {
      requiresAuth: true,
      title: 'Shop | Best Buds'
    }
  },
  {
    path: "/tips-tricks",
    name: "tipstricks",
    component: TipsTricksView,
    meta: {
      requiresAuth: true ,
      title: 'Tips & Tricks | Best Buds'
    }
  },
  {
    path: "/articles",
    name: "articles",
    component: ArticlesView,
    meta: {
      requiresAuth: true,
      title: 'Articles | Best Buds'
    }
  },
  {
    path: "/news",
    name: "news",
    component: NewsView,
    meta: {
      requiresAuth: true,
      title: 'News | Best Buds'
    }
  },
  {
    path: "/about-us",
    name: "aboutus",
    component: AboutUsView,
    meta: {
      requiresAuth: true,
      title: 'About Us | Best Buds'

    }
  },
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
    meta: {
      requiresAuth: true,
      title: 'Profile | Best Buds'
  }
},
  {
    path: "/safety-tips",
    name: "safetytips",
    component: SafetyTipsView,
    meta: {
      requiresAuth: true,
      title: 'Safety Tips | Best Buds'
    }
  },
  {
    path: "/cannabis-products",
    name: "cannabisproducts",
    component: CannabisProductsView,
    meta: {
      requiresAuth: true,
      title: 'Cannabis Products | Best Buds'
    }
  },
  {
    path: "/strain-guide",
    name: "strainguide",
    component: StrainGuideView,
    meta: {
      requiresAuth: true,
      title: 'Strain Guide | Best Buds'
    }
  },
  {
    path: "/common-questions",
    name: "commonquestions",
    component: CommonQuestionsView,
    meta: {
      requiresAuth: true,
      title: 'Common Questions | Best Buds'
    }
  },
  {
    path: "/too-much-cannabis",
    name: "toomuchcannabis",
    component: TooMuchCannabisView,
    meta: {
      requiresAuth: true,
      title: 'Too Much Cannabis | Best Buds'
    }
  },
  {
    path: "/legaity",
    name: "legality",
    component: LegalityView,
    meta: {
      requiresAuth: true,
      title: 'Legality | Best Buds'
    }
  },
  {
    path: "/privacy-policy",
    name: "privacypolicy",
    component: PrivacyPolicyView,
    meta: {
      requiresAuth: true,
      title: 'Privacy Policy | Best Buds'
    }
  },
  {
    path: "/contact-us",
    name: "contactus",
    component: ContactUsView,
    meta: {
      requiresAuth: true,
      title: 'Contact Us | Best Buds'
    }
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
