Dispensary Locator Web Application
(Currently under development)

Welcome to the Dispensary Locator Web Application! This app allows users to easily find nearby dispensaries based on their location. It integrates the Yelp Fusion API for dispensary data and provides a user-friendly, dynamic interface built with Vue.js. The backend is powered by Spring Boot, with PostgreSQL as the database for storing and retrieving user and dispensary data.

Introduction
The Dispensary Locator Web Application is designed to help users search for dispensaries by location and view detailed information about them. With real-time data from the Yelp Fusion API, users can find the nearest dispensaries, see operating hours, contact information, and more. The app also integrates a map for an interactive, visual representation of the search results.

This project is currently under development, and I am continuously improving it with new features and enhancements.

Features
Location-based Search: Allows users to search for dispensaries based on a manually entered address or geolocation.
Map Integration: Displays dispensary results on an interactive map for better location visualization.
User-friendly Interface: Easy-to-navigate layout with clear search options and visuals.
Responsive Design: Fully optimized for mobile and desktop devices, ensuring a seamless experience across platforms.
API Integration: Fetches real-time dispensary data and geolocation information from Yelp Fusion API.
News Integration: Provides dispensary-related news updates via the News API.
Project Structure
The application is built with Vue.js for the frontend and Spring Boot for the backend. The project is structured as follows:

bash
Copy
/dispensary-locator
    /backend
        /src
            /main
                /java/com/dispensary/locator
                    /controller
                    /dao
                    /service
                    /model
                    /repository
                    /security
                    DispensaryLocatorApplication.java
                /resources
                    /application.yml
    /frontend
        /src
            /components
                /MapView
                /SearchForm
                /ResultsView
            /services
                /dispensaryService.js
            /views
                /HomeView
                /ResultsView
            App.vue
            main.js
        /public
            index.html
Technologies Used
Frontend:
Vue.js: A progressive JavaScript framework used for building the user interface.
Vue Router: Used for handling the routing of different views in the application.
Axios: A promise-based HTTP client for making requests to the backend server and Yelp API.
SVG: Used for rendering interactive maps.
Vuex: For state management across the app.
Backend:
Spring Boot: Java-based framework for developing the backend logic, including user authentication, dispensary data management, and RESTful API handling.
JPA: Java Persistence API for interacting with the PostgreSQL database.
PostgreSQL: Open-source relational database used to store dispensary data and user information.
API Integration:
Yelp Fusion API: Used to retrieve dispensary data, including name, location, contact information, and more.
The News API: Provides relevant news updates related to dispensaries.
How to Use
Search for a dispensary: Enter your location or use the geolocation feature to find dispensaries near you.
View results: See a list of dispensaries, including important details like distance, hours of operation, and contact information.
Interactive Map: Click on dispensaries on the map to view more detailed information about each location.
Prerequisites
Before you start, make sure you have the following installed:

A code editor (e.g., VS Code, IntelliJ IDEA)
Java 11 or newer
PostgreSQL (or any compatible relational database)
Node.js (for frontend development)
Maven (for backend)
Retrieve an API key from Yelp Fusion API and News API
Setup Instructions
Backend Setup:
Clone the repository:

bash
Copy
git clone https://github.com/your-username/dispensary-locator.git
cd dispensary-locator/backend
Configure the application:

Set up a PostgreSQL database for the project.
Update the application.yml file with your database credentials and API keys.
Run the backend:

bash
Copy
mvn spring-boot:run
Frontend Setup:
Navigate to the frontend directory:

bash
Copy
cd dispensary-locator/frontend
Install dependencies:

bash
Copy
npm install
Run the frontend:

bash
Copy
npm run serve
Open your browser to view the application.

Acknowledgements
Yelp Fusion API: For providing the dispensary data.
The News API: For delivering relevant news information related to dispensaries.
Vue.js: For building the dynamic and interactive frontend.
Spring Boot: For creating the backend logic and handling API requests.
PostgreSQL: For being a reliable database system for storing dispensary data and user information.
Future Enhancements
User Reviews: Allow users to leave reviews and ratings for dispensaries.
Search History: Keep track of recent searches for users.
Map Integration Enhancements: Improve map visuals and add additional filtering options.

