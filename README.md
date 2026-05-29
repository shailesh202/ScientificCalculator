# Scientific Calculator Automation Framework

## Overview

This project is a scalable Selenium-TestNG automation framework developed for validating a Scientific Calculator web application.

The framework follows enterprise-level automation practices including:

* Page Object Model (POM)
* TestNG Framework
* Maven Build Management
* Extent Reporting
* Screenshot Capture
* Wait Utilities
* Configurable Execution
* Sanity & Regression Suite Execution
* CI/CD Integration Ready
* Headless Browser Execution
* Parallel Execution Support

---

# Tech Stack

| Technology       | Version |
| ---------------- | ------- |
| Java             | 17      |
| Selenium         | 4.22.0  |
| TestNG           | 7.10.2  |
| Maven            | Latest  |
| Extent Reports   | 5.1.1   |
| WebDriverManager | 5.8.0   |
| Log4j            | 2.23.1  |

---

# Project Structure

```text
ScientificCalculator/
│
├── .github/
│   └── workflows/
│       └── selenium-ci.yml
│
├── reports/
├── screenshots/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── constants/
│   │   │   ├── baseFactory/
│   │   │   ├── listeners/
│   │   │   ├── pages/
│   │   │   └── utils/
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       └── java/
│           └── testcases/
│
├── pom.xml
├── testng.xml
├── testng-sanity.xml
├── testng-regression.xml
└── README.md
```

---

# Features Implemented

## Functional Test Coverage

* Addition
* Subtraction
* Multiplication
* Division
* Decimal Calculations
* Multiple Chained Operations

---

## Scientific Operations

* Square Root
* Percentage
* Power
* Trigonometric Operations
* Memory Functions

---

## Negative Scenarios

* Divide By Zero
* Invalid Input
* Repeated Operators
* Empty Calculation

---

## Boundary Value Testing

* Large Numbers
* Floating Point Precision
* Consecutive Decimal Points
* Rapid Button Clicking

---

## Bug scenarios seperated Testing

* verify Digit Three
* verify Division
* verify Subtraction
* verify Division Precedence
* verify Mixed Operations

---

# Framework Components

## BaseTest

Responsible for:

* Browser setup
* Driver initialization
* Driver cleanup

---

## DriverFactory

Handles:

* ThreadLocal WebDriver
* Headless execution
* Browser initialization

---

## WaitUtils

Reusable explicit waits:

* waitForClickable()
* waitForVisibility()
* waitForText()

---

## Extent Reports

Features:

* Pass/Fail status
* Screenshots on failure
* Categorized reporting
* Sanity/Regression tagging

---

# Execution

## Run Complete Suite

```bash
mvn clean test
```

---

## Run Sanity Suite

```bash
mvn clean test -DsuiteXmlFile=testng-sanity.xml
```

---

## Run Regression Suite

```bash
mvn clean test -DsuiteXmlFile=testng-regression.xml
```

---

# Test Grouping

## Sanity

Critical business flow validations.

## Regression

Complete end-to-end validation including:

* edge cases
* negative testing
* boundary validations

---

# Reporting

Extent Reports are generated automatically under:

```text
/reports/
```

Failure screenshots are generated under:

```text
/screenshots/
```

---

# CI/CD Integration

The framework supports:

* GitHub Actions
* Jenkins
* Headless Execution
* Maven-based execution
* Automated report generation

---

# GitHub Actions

Workflow file:

```text
.github/workflows/selenium-ci.yml
```

Pipeline automatically:

* installs Java
* installs Chrome
* executes tests
* uploads reports

---

# Headless Execution

The framework supports CI-compatible headless execution using ChromeOptions.

Example:

```java
options.addArguments("--headless=new");
```

---

# Parallel Execution Support

The framework uses:

```java
ThreadLocal<WebDriver>
```

for thread-safe parallel execution.

---

# Configuration

## config.properties

```properties
url=https://rbihubcodechallenge.github.io/calculator/index.html
browser=chrome
```

---

# Maven Surefire Plugin

Configured for TestNG XML execution.

---

# Future Enhancements

* Cross Browser Execution
* Docker Integration
* Allure Reporting
* Retry Analyzer
* API Automation
* Database Validation
* Cloud Execution (BrowserStack/SauceLabs)

---

# Author

Shailesh

---

# Key Highlights

* Enterprise-ready automation framework
* CI/CD compatible
* Scalable architecture
* Config-driven execution
* Maintainable design
* Reporting & screenshot support
* Parallel execution ready
