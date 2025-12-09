# Email Account Management System


## Project Overview
The **Email Account Management System** is a command-line interface (CLI) application designed to help startups efficiently manage employee email accounts. It automates account creation, password generation, department assignment, and mailbox management, reducing manual effort and errors.  

**Key features include:**  
- Create new email accounts quickly  
- Assign employees to departments (Sales, Development, Accounting, or None)  
- Generate secure passwords automatically  
- Manage mailbox capacities  
- List all accounts and update passwords  
- Import multiple employee accounts from a CSV file with auto-generated emails and passwords  

---

## Technologies Used
- Java  
- Object-Oriented Programming (OOP) principles: Encapsulation, Abstraction, Inheritance, Polymorphism  
- Interfaces and Composition for flexible design  
- Command-Line Interface (CLI)  
- CSV file handling  

---

## Design
- **Abstract Class:** `Account` (common attributes and methods for all account types)  
- **Concrete Class:** `UserAccount` (extends `Account` with default mailbox capacity)  
- **Interface:** `PasswordPolicy` (defines password rules; implemented by `PasswordPolicy_Implemented`)  
- **Service Class:** `EmailService` (manages accounts and password policies)  
- **Utility Class:** `DataImporter` (imports accounts from CSV)  
- **Manager Class:** `EmailAccountManager` (handles CLI interaction)  
- **Main Class:** `Main` (entry point for the program)  

**Design Patterns Used:**  
- **Strategy Pattern** for flexible password generation  
- **Factory Method (light)** in `EmailService.createAccount()` for centralized account creation  
- Layered separation (similar to MVC): CLI, business logic, and data handling are separated  

---

## Features
1. **Account Management**  
   - Add new accounts with auto-generated email and password  
   - Assign department and manage mailbox capacity  

2. **Password Management**  
   - Change passwords for existing accounts  
   - Password generation follows secure rules  

3. **CSV Import**  
   - Import multiple employee accounts from a CSV file with auto-generated emails and passwords  

4. **Account Listing**  
   - List all accounts with their details  

5. **User-Friendly CLI**  
   - Input validation and clear error messages  
   - Continuous loop until exit command is given  

---

## Implementation Highlights
- **Encapsulation:** Account details are private with controlled access through getters/setters  
- **Abstraction:** `Account` and `PasswordPolicy` hide implementation details  
- **Inheritance & Polymorphism:** `UserAccount` extends `Account` with customized behavior  
- **Composition:** `EmailService` uses `PasswordPolicy` for flexible password strategy  
- **Constants & Final:** Department names and other constants are immutable  

---

## Testing
Manual testing was performed for:  
1. Adding new accounts  
2. Listing all accounts  
3. Changing passwords  
4. Importing accounts from CSV  
5. Exiting the application gracefully  

All typical and edge-case scenarios were tested, ensuring valid email/password generation and proper CLI behavior.  

---

## Reflection
- **Design Trade-off:** Used composition over inheritance for `EmailService` and `PasswordPolicy` for flexibility  
- **Future Improvements:**  
  - Separate CLI input/output from business logic for better maintainability  
  - Use Java `records` for account data  
  - Implement try-with-resources for safer file handling  
   

---
