# 🚗 Car Maintenance & Service Management System

<div align="center">

# 🚘 Car Maintenance & Service Management System

### Java & MySQL Based Vehicle Service Management Platform

A console-based application developed using Java and MySQL that helps automobile service centers efficiently manage customers, vehicles, maintenance records, service appointments, and service operations through a menu-driven interface.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge\&logo=mysql\&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Database_Connectivity-blue?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Java-success?style=for-the-badge)

### 🔧 Manage • Track • Maintain

</div>

---

# 📖 Overview

The Car Maintenance & Service Management System is a Java-based console application designed to automate vehicle service center operations.

The system enables service centers to:

* Manage customer information
* Register and track vehicles
* Schedule service appointments
* Maintain service records
* Manage available services
* Track maintenance history

The project follows Object-Oriented Programming (OOP) principles and uses JDBC for seamless integration with MySQL databases.

---

# ✨ Features

## 👤 Customer Management

Manage customer information including:

* Customer Name
* Contact Number
* Email Address
* Residential Address

### Validation Features

* Email Validation
* Contact Number Validation
* Empty Field Validation

---

## 🚗 Vehicle Management

Store and manage vehicle information:

* Customer ID
* License Plate Number
* Vehicle Make
* Vehicle Model
* Manufacturing Year
* VIN Number

---

## 🔧 Service Management

Manage available service offerings:

* Oil Change
* Brake Replacement
* Wheel Alignment
* Engine Service
* General Maintenance

Each service contains:

* Service Name
* Service Cost
* Duration
* Description

---

## 📋 Maintenance Records

Track complete service history:

* Vehicle Serviced
* Service Performed
* Scheduled Date
* Completion Status
* Maintenance Logs

---

## 📅 Appointment Scheduling

Schedule and manage:

* Service Appointments
* Upcoming Services
* Appointment Status
* Service Tracking

---

# 💻 Console Output Preview

## 🏠 Main Menu

```text
=========================================
 CAR MAINTENANCE & SERVICE MANAGEMENT
=========================================

1. Add Customer
2. Add Car
3. Add Service
4. Schedule Appointment
5. View Maintenance Records
6. Exit

Enter your choice:
```

---

## 👤 Add Customer

```text
===== ADD CUSTOMER =====

Enter Name: Gowtham K
Enter Contact Number: 9876543210
Enter Email: gowtham@example.com
Enter Address: Erode, Tamil Nadu

Customer added successfully!
```

---

## 🚗 Add Car

```text
===== ADD CAR =====

Enter Customer ID: 101
Enter License Plate: TN39AB1234
Enter Make: Hyundai
Enter Model: Creta
Enter Year: 2023
Enter VIN: VIN123456789

Car added successfully!
```

---

## 🔧 Add Service

```text
===== ADD SERVICE =====

Service Name: Oil Change
Cost: 1500
Duration: 2 Hours
Description: Engine oil replacement

Service added successfully!
```

---

## 📅 Schedule Appointment

```text
===== SERVICE APPOINTMENT =====

Customer ID : 101
Car ID      : 201
Service ID  : 301
Date        : 2026-06-15

Appointment scheduled successfully!
```

---

## 📋 View Maintenance Records

```text
===== MAINTENANCE RECORDS =====

Record ID : 1
Vehicle   : Hyundai Creta
Service   : Oil Change
Date      : 2026-06-15
Status    : Completed

------------------------------------
```

---

# 🏗 Object-Oriented Design

The project demonstrates the following OOP concepts:

### Encapsulation

* Private class members
* Getters and Setters

### Classes & Objects

* Customer
* Car
* Service
* ServiceAppointment

### Constructors

* Parameterized Constructors
* Object Initialization

### JDBC Integration

* Database Connectivity
* CRUD Operations
* Prepared Statements

---

# 🛠 Technology Stack

| Category             | Technology                         |
| -------------------- | ---------------------------------- |
| Programming Language | Java                               |
| Database             | MySQL                              |
| Connectivity         | JDBC                               |
| Architecture         | Object-Oriented Programming        |
| Validation           | Java Regex                         |
| IDE                  | IntelliJ IDEA / Eclipse / NetBeans |

---

# 🏗 System Architecture

```text
User
 │
 ▼
Java Console Application
 │
 ├── Customer Module
 ├── Vehicle Module
 ├── Service Module
 ├── Appointment Module
 └── Maintenance Module
 │
 ▼
JDBC
 │
 ▼
MySQL Database
```

---

# 📂 Project Structure

```bash
CarMaintenanceSystem/
│
├── Main.java
├── Customer.java
├── Car.java
├── Service.java
├── ServiceAppointment.java
├── DatabaseHelper.java
│
├── database/
│   └── schema.sql
│
└── README.md
```

---

# 🗄 Database Design

## Customers Table

```sql
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    ContactNumber VARCHAR(15),
    Email VARCHAR(100),
    Address TEXT
);
```

## Cars Table

```sql
CREATE TABLE Cars (
    CarID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    LicensePlate VARCHAR(20),
    Make VARCHAR(50),
    Model VARCHAR(50),
    Year INT,
    VIN VARCHAR(50)
);
```

## Services Table

```sql
CREATE TABLE Services (
    ServiceID INT PRIMARY KEY AUTO_INCREMENT,
    ServiceName VARCHAR(100),
    ServiceCost DECIMAL(10,2),
    Duration VARCHAR(50),
    Description TEXT
);
```

## Maintenance Records Table

```sql
CREATE TABLE MaintenanceRecords (
    RecordID INT PRIMARY KEY AUTO_INCREMENT,
    CarID INT,
    ServiceID INT,
    ScheduledDate DATE,
    Status VARCHAR(50)
);
```

---

# 🚀 Installation

## Clone Repository

```bash
git clone https://github.com/gowthamk2503/CarMaintenanceSystem.git
```

## Create Database

```sql
CREATE DATABASE car_maintenance_system;
```

## Configure Database Connection

Update credentials in:

```java
DatabaseHelper.java
```

```java
String url = "jdbc:mysql://localhost:3306/car_maintenance_system";
String user = "root";
String password = "your_password";
```

## Compile Project

```bash
javac *.java
```

## Run Project

```bash
java Main
```

---

# 🔒 Security Improvements

Recommended improvements:

* Environment Variables
* Configuration Files
* Password Encryption
* Role-Based Access Control

---

# 🚀 Future Enhancements

### 🔍 Search Vehicle by VIN

View complete vehicle details using VIN number.

### 📋 Customer Service History

View all services performed for a customer.

### 💰 Maintenance Bill Generation

Generate bills automatically.

### 🔔 Service Reminder System

Notify customers about upcoming services.

### 📊 Revenue Analytics

Generate monthly and yearly reports.

### 🖥 GUI Version

Upgrade to Java Swing or JavaFX.

---

# 🎓 Learning Outcomes

This project demonstrates:

✅ Java Programming

✅ JDBC Connectivity

✅ MySQL Database Design

✅ Object-Oriented Programming

✅ CRUD Operations

✅ Data Validation

✅ Service Scheduling

✅ Database Integration

---



# 👨‍💻 Author

## Gowtham K

🎓 B.Tech Information Technology
🏫 Sri Eshwar College of Engineering

📧 [gowtham.k2023it@sece.ac.in](mailto:gowtham.k2023it@sece.ac.in)

### 🌐 Connect

* GitHub
* LinkedIn
* Portfolio

---

# 📜 License

Licensed under the MIT License.

---

<div align="center">

## ⭐ If you found this project useful, give it a Star ⭐

### 🚗 Keeping Vehicles Reliable Through Smart Service Management

</div>
