# automationMagentoTask

This repository contains a Java-based automation framework for testing Magento applications. It leverages Selenium WebDriver for browser automation and TestNG for test management.

## Features

- **Browser Automation**: Utilizes Selenium WebDriver to automate interactions with web browsers.
- **Test Management**: Employs TestNG for organizing and executing test cases.
- **Modular Design**: Structured to allow easy addition and maintenance of test cases.

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Apache Maven**: For managing project dependencies and build lifecycle.
- **Selenium WebDriver**: Ensure the appropriate WebDriver executable is available in your system's PATH.
- **TestNG**: Integrated as a dependency in the `pom.xml` file.

## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Ahmedsheeriif/automationMagentoTask.git
   cd automationMagentoTask
   ```

2. **Set Up Dependencies**:

   Use Maven to download and set up the necessary dependencies:

   ```bash
   mvn clean install
   ```

## Running Tests

Execute the following Maven command to run the test suite:

```bash
mvn test
```

Test results will be displayed in the console output.

## Project Structure

- **`src/main/java`**: Contains the main Java source files.
- **`src/test/java`**: Contains the test cases.
- **`pom.xml`**: Maven configuration file managing project dependencies and build settings.
