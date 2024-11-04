# annotation-based-component-flow
**Annotation Project**
This project is a web application built with Java, Spring Boot, JavaScript, and Gradle. It allows users to provide input, make an API call to the backend, and display the response on the page. Additionally, it displays the flow of methods, classes, and component calls on the UI through WebSocket communication and Spring AOP.
**Project Structure**
Annotation
├── gradlew.bat
├── settings.gradle
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── honeywell
│   │   │           └── intelligrated
│   │   │               └── wes
│   │   │                   └── annotation
│   │   │                       └── DemoApplication.java
│   │   └── resources
│   │       └── application.properties
├── my-web-app
│   ├── src
│   │   ├── index.html
│   │   ├── styles.css
│   │   ├── app.js
│   │   └── api
│   │       └── api.js
│   ├── package.json
│   └── README.md
└── README.md

**Getting Started**
Prerequisites
Java 11 or higher
Node.js and npm
Gradle
http-server (for frontend-backend communication)
Installation
**Clone the repository:**  
git clone https://github.com/your-username/Annotation.git
cd Annotation
Install the dependencies for the web app:  
cd my-web-app
npm install
Install http-server:  
npm install -g http-server
**Running the Application**
Start the Spring Boot application:  
./gradlew.bat bootRun
**Start the web application**:  
cd my-web-app
npm start
Open your web browser and navigate to:  
http://localhost:8081
**Enter your input in the provided input field and click the "Submit" button**.  
The response from the API will be displayed below the input field.  
**Project Files**
src/main/java/com/honeywell/intelligrated/wes/annotation/DemoApplication.java
This is the main entry point for the Spring Boot application.  
src/main/resources/application.properties
Configuration file for the Spring Boot application.  
my-web-app/src/index.html
HTML file for the web application's user interface.  
my-web-app/src/styles.css
CSS file for styling the web application.  
my-web-app/src/app.js
JavaScript file for handling user interactions and making API calls.  
my-web-app/src/api/api.js
JavaScript file for defining API functions.  
my-web-app/package.json
Configuration file for the Node.js project, including dependencies and scripts.  
