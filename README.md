# BudgetTrackerBack

BudgetTrackerBack is the backend for the mobile application "BudgetTracker". This project is being developed as part of a faculty assignment. It serves as the backbone of the mobile app, managing data storage, retrieval, and processing to provide a seamless user experience for tracking expenses and budgets.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Project Overview

The BudgetTrackerBack project is designed to handle all backend operations for the BudgetTracker mobile application. It connects to a database, processes user requests, and sends appropriate responses to the frontend application. The project aims to provide a reliable and efficient service for users to manage their financial data.

## Features

- User authentication and authorization
- CRUD operations for budget and expense records
- Real-time data synchronization with the mobile application
- Secure data storage
- RESTful API endpoints for various functionalities

## Technologies Used

- **Java**: Core programming language
- **Spring Boot**: Framework for building the backend application
- **Maven**: Build and dependency management tool
- **PostgreSQL**: Database for storing user and financial data

## Setup and Installation

To set up and run this project locally, follow these steps:

1. **Clone the repository**
   ```sh
   git clone https://github.com/your-username/BudgetTrackerBack.git
   cd BudgetTrackerBack
   ```
2. **Configure the database**

    Ensure you have PostgreSQL installed and running.
    Create a database named budget_tracker.
    Update the application.properties file in src/main/resources with your database credentials.

3. **Build the project**
   ```sh
    mvn clean install
   ```
4. **Run the application**
   ```sh
    mvn spring-boot:run
   ```
5. **Access the application**
   The backend server will be running at http://localhost:8081.

## Usage

The backend provides various API endpoints to interact with the BudgetTracker mobile application. Here are some example endpoints:

    POST /api/auth/signup: Register a new user
    POST /api/auth/login: Authenticate a user
    GET /plan/all: Retrieve all budgets for the authenticated user
    POST /plan/add: Create a new budget plan
    PUT /plan/update/{id}: Update an existing budget plan
    DELETE /plan/delete/{id}: Delete a budget plan

For detailed API documentation, refer to the Swagger documentation provided in the project.
## Contributing
   Contributions are welcome! If you have any suggestions or improvements, please create an issue or submit a pull request.

    Fork the project
    Create your feature branch (git checkout -b feature/YourFeature)
    Commit your changes (git commit -m 'Add some feature')
    Push to the branch (git push origin feature/YourFeature)
    Open a pull request

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements

    Special thanks to the faculty for providing the opportunity to work on this project.
    Thanks to the contributors and the open-source community for their valuable resources and support.

