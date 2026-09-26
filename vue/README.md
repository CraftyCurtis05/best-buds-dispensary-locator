# Best Buds Frontend

The frontend for **Best Buds**, a Vue 3 web application designed to help users discover dispensaries, explore cannabis information, manage saved content, and interact with their personal Best Buds profile.

This directory contains the complete client-side application. It handles the user interface, navigation, application state, frontend validation, API communication, and interactive features while communicating with the separate Best Buds Spring Boot backend.

---

## Frontend Features

The Best Buds frontend includes:

- User registration and login
- Age confirmation and onboarding
- User profile setup and management
- Profile image management
- Account settings
- Dispensary search
- Interactive dispensary map
- Featured dispensaries
- Saved dispensaries
- Cannabis articles
- Cannabis news and news search
- Cannabis product information
- Strain and terpene guides
- Cannabis safety information
- Common cannabis questions
- Cannabis overuse information
- Cannabis legality information
- Tips and tricks
- Contact form
- Best Buds Drops collectible system
- Personal My Stash collection
- Responsive navigation
- Protected application routes
- Persistent authenticated sessions

---

## Technologies

### Core

- Vue 3
- JavaScript
- Vite
- HTML5
- CSS3

### Application

- Vue Router
- Vuex
- Axios
- vue3-google-map

### Development

- ESLint
- Vite development server
- Vite API proxy

---

## Project Structure

```text
vue/
├── public/
├── src/
│   ├── api/
│   ├── assets/
│   ├── components/
│   ├── data/
│   ├── router/
│   ├── services/
│   ├── store/
│   ├── views/
│   ├── BestBudsApp.vue
│   └── main.js
├── .gitignore
├── eslint.config.mjs
├── index.html
├── package.json
├── package-lock.json
├── README.md
└── vite.config.mjs
```

### `components`

Contains reusable and feature-specific Vue components.

Components handle focused pieces of the user interface and feature behavior while allowing views to remain responsible for page composition.

### `data`

Contains frontend data used by application features and informational content.

### `router`

Contains the Vue Router configuration.

The router controls application navigation, protected routes, page titles, and required onboarding steps.

### `services`

Contains the frontend API service layer.

Services use Axios to communicate with the Best Buds backend and keep API requests separate from Vue components and views.

### `store`

Contains the Vuex store used for application-wide state.

The store manages information such as:

- Authentication token
- Authenticated user
- User profile
- Profile loading state
- Selected location
- Dispensary search results

### `views`

Contains the application's routed pages.

Views are responsible for page-level structure and composition while feature-specific behavior is kept inside components when appropriate.

### `BestBudsApp.vue`

The root Vue component.

It manages the global application structure, including:

- Application header
- Main content
- Page navigation helpers
- Suggested destinations
- Application footer
- Best Buds Drop reveals

### `main.js`

The frontend application entry point.

It restores saved authentication information, creates the Vuex store, creates the Vue Router instance, and mounts the Vue application.

---

## Frontend Architecture

Best Buds follows a straightforward Vue structure:

```text
Views
  ↓
Components
  ↓
Services
  ↓
Best Buds Backend API
```

Application-wide state is handled separately through Vuex:

```text
Vue Components
      ↕
   Vuex Store
```

The general responsibilities are:

- **App** — global application structure and state
- **Views** — page composition
- **Components** — feature behavior and user interface
- **Services** — backend API communication
- **Store** — application-wide state
- **Router** — navigation and route protection
- **Data** — frontend content and configuration

The project intentionally keeps these responsibilities separated without introducing unnecessary abstractions.

---

## API Services

Frontend API requests are organized into focused service files.

Current services include:

```text
AccountService.js
AuthService.js
CollectibleService.js
NewsService.js
ProfileImageService.js
ProfileService.js
SavedDispensaryService.js
UserActivityService.js
YelpService.js
```

Each service is responsible for communicating with a related group of backend endpoints.

For example:

```js
import axios from "axios";

export default {

    // Get the authenticated user's profile
    getProfile() {
        return axios.get(
            "/api/profile"
        );
    }

};
```

Services return the Axios request so the component or view using the service can decide how to handle the response, loading state, and errors.

---

## Authentication

Best Buds uses token-based authentication.

After a successful login, the frontend stores the authentication token and authenticated user in Vuex and local storage.

The token is also added to the default Axios authorization header:

```text
Authorization: Bearer <token>
```

When the application starts, `main.js` checks local storage for an existing authenticated session.

If a valid saved session exists, the frontend restores the user and authentication token before creating the application.

Logging out clears the authenticated state and removes the saved session information.

---

## Protected Routes

Vue Router navigation guards protect authenticated pages.

Before allowing access to a protected route, the application checks:

1. The user is authenticated.
2. The user has confirmed the age requirement.
3. The user's profile has been loaded.
4. The user has completed profile setup.

This creates the following onboarding flow:

```text
Login / Register
       ↓
Age Confirmation
       ↓
Profile Setup
       ↓
Best Buds Application
```

Users who have already completed a required onboarding step are redirected past that step.

---

## Application State

Vuex manages state that needs to be available across multiple areas of the frontend.

The main application state includes:

```text
token
user
profile
profileLoaded
locationID
dispensaries
```

Authentication information is also stored in local storage so the user's session can survive a browser refresh.

Feature-specific state remains inside the component that owns the feature whenever application-wide storage is unnecessary.

---

## Dispensary Search

The dispensary search interface allows users to search for dispensaries based on location.

The frontend communicates with the Best Buds backend rather than communicating directly with the external business API.

```text
Vue Frontend
     ↓
YelpService
     ↓
Best Buds Backend
     ↓
External Business API
```

Search results can be displayed as both dispensary information and map locations.

Authenticated users can also save dispensaries to their account.

---

## Cannabis News

The frontend retrieves cannabis news through the Best Buds backend.

```text
Vue Frontend
     ↓
NewsService
     ↓
Best Buds Backend
     ↓
External News API
```

Users can view recent cannabis news and perform their own news searches without exposing external API credentials in the browser.

---

## Best Buds Drops

Best Buds Drops are collectible rewards that can be unlocked through application activity.

The frontend periodically checks the backend for newly earned Drops.

When one or more Drops are returned, they are placed into a reveal queue and displayed to the user individually.

```text
User Activity
     ↓
Backend Activity Record
     ↓
Drop Check
     ↓
Drop Reveal
     ↓
My Stash
```

Unlocked collectibles can be viewed later in the user's **My Stash** collection.

The backend determines when a collectible has been earned, while the frontend handles the reveal and collection experience.

---

## Local Development

### Requirements

Before running the frontend, install:

- Node.js
- npm

The Best Buds backend should also be available when testing features that require API requests.

### Install Dependencies

From the Vue project directory:

```bash
npm install
```

### Start the Development Server

```bash
npm run dev
```

Vite starts the frontend development server and provides the local development URL in the terminal.

---

## Backend API Proxy

During local development, Vite proxies frontend requests beginning with:

```text
/api
```

to the local Best Buds Spring Boot backend:

```text
http://localhost:9000
```

This allows frontend services to use requests such as:

```js
axios.get(
    "/api/profile"
);
```

instead of placing the backend host directly inside every service.

The development proxy is configured in:

```text
vite.config.mjs
```

Production API routing is handled separately by the deployment environment.

---

## Available Commands

### Start Development Server

```bash
npm run dev
```

### Build for Production

```bash
npm run build
```

### Preview Production Build

```bash
npm run preview
```

Running the preview command automatically creates a production build first.

### Run ESLint

```bash
npm run lint
```

---

## Production Build

Create the production frontend with:

```bash
npm run build
```

Vite creates the compiled application in:

```text
dist/
```

The `dist` directory contains the frontend files intended for production deployment and is excluded from Git.

---

## Code Organization

The frontend is intentionally written with readability and maintainability in mind.

The project generally follows these conventions:

- Vue Options API
- Four-space indentation
- Descriptive variable and method names
- Straightforward conditional logic
- Early returns where they improve readability
- Purpose-based comments
- Semantic HTML
- Accessible page and component structure
- Feature-specific components
- Thin API services
- Application-wide state only when necessary
- Minimal abstraction

The goal is to keep the code understandable while maintaining clear separation between the major parts of the application.

---

## Accessibility

Accessibility is considered throughout the frontend structure.

The application uses features such as:

- Semantic HTML elements
- Logical heading hierarchy
- Descriptive image alternative text
- Keyboard-accessible controls
- Accessible navigation landmarks
- Form labels
- Status messages
- Meaningful link and button text
- Page jump links
- Focusable main content

ARIA attributes are used when they provide additional meaning rather than as a replacement for semantic HTML.

---

## Frontend Dependencies

The primary frontend dependencies are:

```text
axios
vue
vue-router
vue3-google-map
vuex
```

Development dependencies include:

```text
@eslint/js
@vitejs/plugin-vue
eslint
eslint-plugin-vue
globals
vite
```

See `package.json` for the currently installed versions.

---

## Related Best Buds Projects

This README documents only the **Best Buds Vue 3 frontend**.

The Best Buds project also contains separate documentation for:

- The Spring Boot backend
- The complete Best Buds application

Refer to those README files for backend architecture, database configuration, backend API implementation, and full-project documentation.