# Forecast-java
# Overview

I'm working on improving my skills in backend development, focusing on Java and Maven. I aim to deepen my understanding of integration testing, deployment, and server management for scalable applications.

I developed a weather application using Java and Maven, following the MVC architecture.Maven is a great manager tool to handle dependencies and asses the developer with tools that could be hard to handle manually. 
It integrates with the OpenWeather API to fetch real-time weather data, displaying it in a structured and user-friendly interface (Console for now).
This softwareprovides a menu with three features:
a- Forecast by city: The user can see the current weather, including some aditional features
b- Forecast by Lat and Lon: The user can see 4 days forecast, separated by 3 hours each of the current location
c- Provide History of searching: The user can see all the searches by date.

My purpose is to learn as much as I can from all the JAVA ecosystem. 

{Provide a link to your YouTube demonstration. It should be a 4-5 minute demo of the software running and a walkthrough of the code. Focus should be on sharing what you learned about the language syntax.}

[Software Demo Video](https://www.youtube.com/watch?v=jsSklLRz_jU)

# Development Environment
1. Technology Stack
Programming Language: Java
Build Tool: Maven 
        Maven is a build automation tool primarily used for Java projects. It simplifies the build process by managing dependencies, compiling code, running tests, and packaging the application. Maven uses an XML configuration file (pom.xml) where you define project settings, dependencies, plugins, and build tasks.
IDE: Visual Studio Code (VS Code)
Frameworks & Libraries:
    JSON Handling: org.json
2. Project Structure (MVC Pattern)
src/main/java/com/example/
│── api/      # Handles calls to the api
│── controller/      # Handles requests & business logic
│   ├── WeatherController.java
│── model/           # Represents data & business logic
│   ├── CityForecast.java
│   ├── HistoryModel.java
│   ├── HourForecast.java
│   ├── WeatherModel.java
│── view/            # Frontend (Just in console)
│   ├── index.jsp    # Frontend (Next feature for the project)
3. General Resources
Github

# Useful Websites

{Make a list of websites that you found helpful in this project}

- [Maven Central Repository](https://mvnrepository.com/)
- [Open Weather Api](https://openweathermap.org/api)
- [Stack Overflow Questions](https://stackoverflow.com/questions)

# Future Work

{List of things to do.}

- Frontend -  Definitely, The frontend is incomplete. I would have love to use some web frameworks. Include the server side so the user can interact from the browser.
- Helper functions. I should have grouped the helper functions in one folder in order to make the controller and the main cleaner.
- Backend - The app is storing localy on the computer through a txt file. Include databases and frameworks is definitely a future add.
- Warning message on VScode. Just a variable created that is never used.