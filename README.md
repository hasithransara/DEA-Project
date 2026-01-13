# EventHub - Event Ticketing System

##  Overview
EventHub is a production-grade web application for discovering events and booking tickets. It features a secure user authentication system, dynamic event management (with categories, venues, and tiered pricing), and an automated email notification system for e-tickets.

## 🛠 Tech Stack
* *Backend:* Java 17+, Spring Boot (Web, Security, Data JPA, Mail)
* *Frontend:* Thymeleaf, Bootstrap 5, JavaScript
* *Database:* MySQL
* *Tools:* Maven, IntelliJ IDEA

##  How to Run the Application

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* MySQL Server installed and running

### Step 1: Database Setup
1.  Open MySQL Workbench.
2.  Create a new schema (database) named event_db.
    sql
    CREATE DATABASE event_db;

3.  Open src/main/resources/application.properties and update your MySQL username and password:
    properties
    spring.datasource.username=root
    spring.datasource.password=your_password


### Step 2: Run the App
1.  Open the project in IntelliJ IDEA.
2.  Run the EventSystemApplication class.
3.  The application will start on http://localhost:8080.

### Step 3: First Time Login
1.  Go to http://localhost:8080/register.
2.  Create a new account.
3.  The first user is automatically assigned the *ADMIN* role (based on current logic) or you can manually update the database role if needed.

##  Key Features
* *Public:* View events, search by keyword, filter by category (Concerts, Sports, etc.).
* *Guest:* Purchase tickets (General, Gold, VIP) without logging in.
* *User/Admin:* Secure login/logout.
* *Admin Dashboard:* Create, Edit, and Delete events.
* *System:* Automatic E-Ticket emails sent upon booking.
*
