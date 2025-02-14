# FoodKing Selenium Automation with TestNG

## 🚀 Overview  

This repository contains UI test automation scripts using **Selenium WebDriver**, written in **Java**, and managed with the **TestNG** framework.

## 📍 About Foodking Restaurant

**Foodking Restaurant Management & Food Delivery System** offers a wide range of features, including online ordering, inventory management, point of sale, order time scheduling, customer relationship management, and delivery tracking. FoodKing is single page application (SPA) and full API based model. The website offers a comprehensive resource for customers looking to learn more about the restaurant chain, its menu offerings, and promotions. The website is easy to navigate and provides a wealth of information, making it a valuable resource for your customers. Overall, you can choose to use FoodKing because of its comprehensive features, user-friendly interface, customization options, and accessibility.

## 📌 Automated Test Coverage for Foodking

✅ User Authentication (Login & Logout)

✅ Multiple Branch Selection

✅ Role & Permission Management

✅ Restaurant POS System

✅ Scheduled Order System

✅ Delivery Charge Calculation (Distance-Based)

✅ Location-Based Search Options

✅ Home Delivery & Takeaway Workflow

✅ Easy Payment System (Multiple Payment Gateways)

✅ Coupons & Vouchers

✅ Order Tracking & Confirmation

✅ Customer & Branch Manager Chat Functionality

✅ Product Variations & Add-ons

✅ Multi-Language Support

✅ Push Notifications & Social Analytics

✅ Admin Panel & Reports

## 🛠️ Tech Stack  

- **Programming Language**: Java  
- **Testing Framework**: TestNG  
- **Automation Tool**: Selenium WebDriver  
- **Build Tool**: Maven 
- **Reporting**: TestNG Reports / Extent Reports 

## 📂 Project Structure 

```bash
selenium-testng-framework  
│── 📂 src  
│   ├── 📂 test  
│   │   ├── 📂 java  
│   │   │   ├── 📂 tests      # Test cases  
│   │   │   ├── 📂 pages      # Page Object Model (POM) classes  
│   │   │   ├── 📂 utils      # Utility classes (Helper methods, Config files)  
│── 📄 pom.xml                # Maven configuration file (if using Maven)  
│── 📄 testng.xml             # TestNG test suite configuration  
│── 📄 README.md              # Project documentation  
```

## ⚙️ Setup Instructions  

### Prerequisites  
- Install **Java JDK (11 or later)**  
- Install **Maven** (if using Maven for dependency management)  
- Install **TestNG** plugin (if using IntelliJ or Eclipse)  

## 🔧 Installation  
1. Clone the repository
   ```sh
   git clone https://github.com/your-username/your-repo.git
   cd your-repo
2. Install dependencies (for Maven projects)
   ```sh
   mvn clean install
3. Run Tests
   
    Using TestNG XML:
   ```sh
   mvn test -DsuiteXmlFile=testng.xml
 - Running a specific test class (from IDE):
 - Open src/test/java/tests/YourTestClass.java
 - Click on the Run button or use the shortcut (Shift + F10 in IntelliJ)
   ```

## 📊 Test Reports 
- After running the tests, TestNG generates an HTML report under the test-output folder.
- Open test-output/index.html to view the results.

## 📜 License
Copyright © 2025, iNiLabs Ltd.

[iNiLabs](https://inilabs.net/)

![Logo](https://kiosk.reworqx.com/images/theme/theme-logo.png)

## Demo

🎟️ https://demo.foodking.dev/home


