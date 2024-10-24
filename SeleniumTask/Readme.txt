# Selenium Automation Registration Testing

## Overview
This project is a Selenium automated testing script for a registration form. The automation framework uses Java and JUnit, and it uses features for dynamic data generation, custom assertions, and reporting through Allure.

## Components

1. **Registration Class**: Contains methods for interacting with the registration form, such as entering user details and selecting options from dropdown menus.
2. **RegistrationTest Class**: Implements the test scenarios, including setup and teardown methods for WebDriver, and performs assertions to verify successful registration.
3. **DataGenerator Class**: Generates random user data using the Faker library.
4. **ScreenshotUtil Class**: Provides functionality for taking screenshots on test failures, aiding in debugging.
5. **ReportUtil Class**: Handles Allure report generation, providing insights into test execution results.
6. **WebDriverManagerUtil Class**: Manages browser driver configurations for running tests on different browsers.

## Features

- **Dynamic Data Generation**: Utilizes the Faker library to create realistic user data for testing.
- **Custom Assertions**: Implements assertions to validate registration outcomes, including capturing screenshots for failures.
- **Allure Reporting**: Generates detailed reports of test results, including logs, screenshots, and execution history.
- **Object-Oriented Design**: Follows an object-oriented approach, enhancing code maintainability and readability.

## Limitations

- The tests currently focus only on the registration process and do not cover login functionality.
- The test framework is primarily designed for web applications;

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Browser (e.g., Google Chrome)
- WebDriver for the respective browser (managed by WebDriverManager)

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/MahHakim98/SeleniumTask.git
