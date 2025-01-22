# Healthcare Automation Testing Project

This project is an automation testing solution for a healthcare management system (OpenMRS) that focuses on automating key functionalities like patient registration, appointment scheduling, and patient record management. The project uses Selenium WebDriver for browser automation, TestNG for test execution, Allure for reporting, and Maven for dependency management.

## **Key Features**

- **Patient Registration:** Automates the process of registering new patients into the healthcare system.
- **Date Scheduling:** Automates testing for scheduling appointments for patients.
- **Appointment Booking:** Verifies the process of booking and managing appointments.
- **Patient Record Management:** Automates searching and retrieving patient records.
- **Login/Logout:** Verifies user login and logout functionality.
- **Screenshot Capture:** Captures screenshots at each step for better reporting and debugging.

## **Technologies Used**

- **Selenium WebDriver:** Automates web browser interactions and simulates user actions for functional testing.
- **TestNG:** A testing framework used to organize, execute, and report test cases.
- **Allure Report:** Generates detailed and visually appealing test reports to track test execution and results.
- **Apache Maven:** Manages project dependencies and automates builds.
- **GitHub Actions (CI/CD):** Automates the testing process and ensures that tests run on every commit to the repository.
- **Screenshot Capture:** Screenshots are captured using a custom utility class for each test step, which helps in debugging and improving report quality.

## **Test Scenarios Covered**

1. **Login to OpenMRS:**
   - Validates user authentication for the system.

2. **Register a Patient:**
   - Automates the registration of new patients into the system.

3. **Schedule an Appointment:**
   - Verifies that appointments can be scheduled correctly for patients.

4. **Book Appointment:**
   - Verifies the functionality of booking and managing appointments.

5. **Find Patient Record:**
   - Tests the ability to search and retrieve patient records.

6. **Logout from System:**
   - Verifies that users can log out of the application successfully.

## **Allure Reporting**

- Allure reporting is integrated into the project to provide a detailed and interactive visual report for the executed tests.
- The report includes:
  - **Test status:** Pass/Fail/Skipped/Failed.
  - **Test steps:** Each test step is tracked and displayed in the report.
  - **Attachments:** Screenshots taken during the test are displayed in the report for better visualization and debugging.
  - **Severity:** Each test is tagged with severity levels (Critical, Normal, Minor) for better prioritization of issues.

## **Getting Started**

### **Prerequisites**

1. **Java 21** or later
2. **Maven**
3. **Selenium WebDriver**
4. **TestNG**
5. **Allure Commandline** (for generating Allure reports)

