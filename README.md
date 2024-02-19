## Summary


- The automation testing framework is developed using Java with Selenium WebDriver.
- Maven is utilized as the build automation tool.
- TestNG is used as the test runner for executing test cases.
- Cucumber is employed for writing feature files and corresponding step definitions.
- The framework follows the Page Object Model (POM) design pattern to enhance test maintenance and readability.
- Data input for test scenarios is taken from Cucumber scenarios.
- Environment-specific data is retrieved from a configuration file.
- Additional input data can be provided as needed from excel file 
- The framework automatically captures screenshots upon test case failure and saves them in a designated "screenshots" folder.
- HTML reporting is integrated into the framework to provide detailed test execution reports, enhancing visibility into test results and facilitating analysis.

## Framework architecture

- Page: The page folder holds all page objects, making it simple to access and update them as needed.
- Runner: It contains runner files for cucumber which has cucumber option, runner class.
- Steps: This folder contains the step definitions for Cucumber features, making it easy to understand what each test is doing.
- Utility: This folder has various utility classes that assist with tasks like browser management and config file access, screenshot file managemeent.
- Feature: This folder contains Cucumber feature files, outlining the scenarios we want to test
- Target: This folder contains cucumber report saved after test execution
- TestNG xml: This file is a configuration file used to define the test suite and test cases for execution with TestNG
- POM.xml: This file has the project's configuration, dependencies and plugin for testNG

### Steps to run automated tests:
A.	Run full test 
1.	Navigate to project directory path
2.	Open command line where POM.xml file is saved
3.	Use command : mvn test

B.	Run specific scenario with tags
1. Navigate to project directory path
2. Open command line where POM.xml file is saved
3. Use command mvn clean test -Dcucumber.filter.tags="@searchAndAddtoCart"
4. Tags can be changed as per scenario
