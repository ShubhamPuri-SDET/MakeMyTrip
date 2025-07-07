# ✈️ MakeMyTrip Automation Framework

A **Selenium-based automation framework** built with **Java** to test critical workflows of the MakeMyTrip web application — including **flight booking**, **hotel reservations**, and **account management**.

This framework follows industry-standard best practices with **Page Object Model (POM)**, **data-driven testing**, **cross-browser compatibility**, and **visual reporting** using **Extent Reports**. Ideal for scalable, maintainable, and robust UI test automation.


## 🔍 Features

- 🚀 **Automates key workflows**: Flight booking, hotel reservations, and login/logout
- 📊 **Data-driven testing** using Excel or CSV files
- 🌐 **Cross-browser support**: Chrome, Firefox, and Edge
- 🔁 **Reusable utilities** to simplify Selenium operations
- 📸 **Screenshot capture on failure** for easy debugging
- 📄 **Rich HTML reports** generated with Extent Reports
- 🧪 **TestNG** for test orchestration


## 🧰 Tech Stack

| Tool                 | Purpose                      |
|----------------------|------------------------------|
| Java                 | Programming language         |
| Selenium WebDriver   | Browser automation           |
| TestNG               | Test management              |
| Maven                | Build tool & dependency mgmt |
| Extent Reports       | Test reporting               |
| Apache POI / OpenCSV | Read test data               |
| Log4j                | Logging                      |


## 📁 Project Structure

MakeMyTrip-Automation/
├── src/
│ ├── main/
│ │ └── java/com/flight/
│ │ ├── model/ # Data models (Booking, Flight)
│ │ ├── pages/ # Page Object classes
│ │ ├── service/ # Business logic
│ └── test/
│ └── java/com/flight/
│ ├── service/ # Service-level tests
│ └── tests/ # UI tests
├── resources/
│ └── testng.xml # TestNG configuration
├── Jenkinsfile # CI setup
├── pom.xml # Maven configuration
├── .gitignore
└── README.md


### 🔧 Prerequisites

* Java JDK 8+
* Maven installed
* Chrome, Firefox, or Edge browser installed
* IDE (e.g., IntelliJ or Eclipse)

### ▶️ Run the Tests

```bash
mvn clean test
```

Or use the `testng.xml` suite file to run specific tests.

---

## 📊 Reporting

* After execution, a rich **Extent Report** is generated in `/reports`.
* Open the HTML file in your browser to view the test summary, logs, and screenshots.

---

## 🤖 CI/CD Integration

This framework supports integration with CI tools like **Jenkins**, using the provided `Jenkinsfile`. Customize it to run tests on commits, PRs, or a schedule.

---

## 🔄 Future Enhancements

* ✅ Parallel execution with TestNG
* ✅ Dockerized Selenium Grid support
* ✅ Integration with BrowserStack or Sauce Labs
* ✅ API testing using REST Assured
* ✅ Retry mechanism for flaky tests


**Happy Testing! 🧪**
