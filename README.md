# Dispensary Locator Web Application
<em>(Currently under development)</em>

Welcome to the Dispensary Locator Web Application! This app allows users to easily find nearby dispensaries based on their location. It integrates the **Yelp Fusion API** for dispensary data and provides a user-friendly, dynamic interface built with **Vue.js**. The backend is powered by **Spring Boot**, with **PostgreSQL** as the database for storing and retrieving user and dispensary data. The app includes user authentication, enabling users to create profiles, manage favorite dispensaries, and upload profile pictures.

---

## Introduction

The Dispensary Locator Web Application is designed to help users search for dispensaries by location and view detailed information about them. With real-time data from the **Yelp Fusion API**, users can find the nearest dispensaries, see operating hours, contact information, and more. The app also integrates **Google Maps API** for an interactive, visual representation of the search results. Provides all neccessary information on cannabis and legality using **The News API** for the latest cannabis news and an article search from preselected articles within a **JavaScript** file. It helps users discover nearby dispensaries, manage their profiles, and save their favorite spots using data saved within a **PostgreSQL** database.

<em>This project is currently under development, and I am continuously improving it with new features and enhancements.</em>

---

## Features

- **Location-based Search**: Allows users to search for dispensaries based on user input, geolocation or the user's saved address details.
- **Map Integration**: Displays dispensary results on an interactive map using **Google Maps API** for better location visualization.
- **User-friendly Interface**: Easy-to-navigate layout with clear search options and visuals.
- **Responsive Design**: Fully optimized for mobile and desktop devices, ensuring a seamless experience across platforms.
- **API Integration**: Fetches real-time dispensary data and geolocation information from **Yelp Fusion API**.
- **News Integration**: Provides dispensary-related news updates via the **News API**.
- **Interactive Legality Map**: Displays an interactive SVG map for legality for each state within the US. 

---

## Project Structure

The application is built with **Vue.js** for the frontend and **Spring Boot** for the backend. The project is structured as follows:

/dispensary-locator <br>
&nbsp;&nbsp;&nbsp;&nbsp;/backend <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/src <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/main <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/java/com/dispensary/locator <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/dao <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/service <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/model <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/repository <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/security <br>
                    DispensaryLocatorApplication.java <br>
                /resources <br>
                    /application.yml <br>
    /frontend <br>
        /src <br>
            /components <br>
                /MapView <br>
                /SearchForm <br>
                /ResultsView <br>
            /services <br>
                /dispensaryService.js <br>
            /views <br>
                /HomeView <br>
                /ResultsView <br>
            App.vue <br>
            main.js <br>
        /public <br>
            index.html <br>

---

## Technologies Used
**Frontend**:
- **Vue.js**: A progressive **JavaScript** framework used for building the user interface.
- **Vue Router**: Used for handling the routing of different views in the application.
- **Axios**: A promise-based HTTP client for making requests to the backend server and **Yelp API**.
- **SVG**: Used for rendering interactive maps.
- **Vuex**: For state management across the app.

**Backend**:
- **Spring Boot**: **Java**-based framework for developing the backend logic, including user authentication, dispensary data management, and RESTful API handling.
- **JPA**: **Java** Persistence API for interacting with the **PostgreSQL** database.
- **PostgreSQL**: Open-source relational database used to store dispensary data and user information.

**API Integration**:
- **Yelp Fusion API**: Used to retrieve dispensary data, including name, location, contact information, and more.
- **The News API**: Provides relevant news updates related to dispensaries.
- **Google Maps API**: Provides user with a location-based, interactive map for dispensary locations.

---

## How to Use

- **Register as user**: Create a new account by providing your personal details and setting up a secure password.
- **Login as user**: Sign in using your registered credentials to access your profile, saved favorites, and any other personalized features.
- **Complete uer profile**: Complete your profile to personalize your experience and update preferences.
- **Search for a dispensary**: Enter your location or use the geolocation feature to find dispensaries near you.
- **View results**: See a list of dispensaries, including important details like distance, hours of operation, and contact information.
- **Interactive Map**: Click on dispensaries on the map to view more detailed information about each location, including directions and services offered.
- **Save favorites**: Mark dispensaries you like or want to visit later by saving them to your favorites list. This makes it easier to access them again in the future.

---

## Prerequisites
Before you start, make sure you have the following installed:

A code editor (e.g., **VS Code**, **IntelliJ IDEA**)
Ensure you have **Node.js** installed, including **npm**
**Java 11** or newer
**PostgreSQL** (or any compatible relational database)
**Maven** (for backend)
Retrieve an API key from **Yelp Fusion API** and **The News API**

---

## Acknowledgements

- **Yelp Fusion API**: For providing the dispensary data.
- **The News API**: For delivering relevant news information related to dispensaries.
- **Vue.js**: For building the dynamic and interactive frontend.
- **Spring Boot**: For creating the backend logic and handling API requests.
- **PostgreSQL**: For being a reliable database system for storing dispensary data and user information.

---

## Future Enhancements

- **User Reviews**: Allow users to leave reviews and ratings for dispensaries.
- **Search History**: Keep track of recent searches for users.
- **Map Integration Enhancements**: Improve map visuals and add additional filtering options.
