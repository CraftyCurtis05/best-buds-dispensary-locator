import { createRouter, createWebHistory } from 'vue-router';
import { useStore } from 'vuex';

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import SearchView from '../views/SearchView.vue';
import ShopView from '../views/ShopView.vue';
import TipsTricksView from '../views/TipsTricksView.vue';
import ArticlesView from '../views/ArticlesView.vue';
import AboutUsView from '../views/AboutUsView.vue';
import ProfileView from '../views/ProfileView.vue';
import SafetyTipsView from '../views/SafetyTipsView.vue';
import CannabisProductsView from '../views/CannabisProductsView.vue';
import StrainGuideView from '../views/StrainGuideView.vue';
import SmokingCannabisView from '../views/SmokingCannabisView.vue';
import TooMuchCannabisView from '../views/TooMuchCannabisView.vue';
import TopicalsView from '../views/TopicalsView.vue';
import LegalityView from '../views/LegalityView.vue';

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
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/search",
    name: "search",
    component: SearchView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/shop",
    name: "shop",
    component: ShopView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/tipstricks",
    name: "tipstricks",
    component: TipsTricksView,
    meta: {
      requiresAuth: true 
    }
  },
  {
    path: "/articles",
    name: "articles",
    component: ArticlesView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/aboutus",
    name: "aboutus",
    component: AboutUsView,
    meta: {
      requiresAuth: true

    }
  },
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
    meta: {
      requiresAuth: true
  }
},
  {
    path: "/safetytips",
    name: "safetytips",
    component: SafetyTipsView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/cannabisproducts",
    name: "cannabisproducts",
    component: CannabisProductsView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/strainguide",
    name: "strainguide",
    component: StrainGuideView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/smokingcannabis",
    name: "smokingcannabis",
    component: SmokingCannabisView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/toomuchcannabis",
    name: "toomuchcannabis",
    component: TooMuchCannabisView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/topicals",
    name: "topicals",
    component: TopicalsView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/legaity",
    name: "legality",
    component: LegalityView,
    meta: {
      requiresAuth: true
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
