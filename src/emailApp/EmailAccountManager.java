package emailApp;
/*
The EmailAccountManager class provides a command-line interface (CLI) for manageing email accounts in th esystem.

User can perform operation such as :
1. Add a new accounts
2. List All accounts
3.Change the password of an existing account
4. exit the application

This class has relationship with the EmailService class to perform actual account operations.
 */

import java.util.Scanner;

public class EmailAccountManager {
    private EmailService service;
    private Scanner scanner;

    public EmailAccountManager(EmailService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    /*------ Account Management  */
    public void start() {
        System.out.println("\n=== Email Account Management ===");
        while (true) {
            // Display menu
            System.out.println("1. Add new Account");
            System.out.println("2. List All Accounts");
            System.out.println("3. Change Password");
            System.out.println("4. Import Accounts from File");
            System.out.println("5. Exit");

            System.out.println("Enter your choice (1-5): ");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            // Handling the choice
            if (input.equals("1") || input.equalsIgnoreCase("Add")) {
                addAccount();
            } else if (input.equals("2") || input.equalsIgnoreCase("List")) {
                listAccounts();
            } else if (input.equals("3") || input.equalsIgnoreCase("Change")) {
                changePassword();
            } else if (input.equals("4") || input.equalsIgnoreCase("Import")) {
                importFromFile();
            } else if (input.equals("5") || input.equalsIgnoreCase("Exit")) {
                exit();
                break;

            } else {
                System.out.println("Invalid choice, Please try again. ");
            }
        }
    }

    // Adds a new email account by prompting the user for first name, last name,and department. The account is then created using EmailService.
    private void addAccount() {
        System.out.println("First Name: ");
        String first = scanner.nextLine();
        System.out.println("Last Name: ");
        String last = scanner.nextLine();
        System.out.println("Department (Sales/Development/Accounting/None): ");
        String deptInput = scanner.nextLine().trim().toLowerCase();

        // Determine department based on input
        String dept;
        if (deptInput.equals("sales")) {
            dept = Department.Sales;
        } else if (deptInput.equals("development")) {
            dept = Department.Development;
        } else if (deptInput.equals("accounting")) {
            dept = Department.Accounting;

        } else {
            dept = Department.NONE;
        }

        // Create account and display details
        Account acc = service.createAccount(first, last, dept);
        System.out.println("\n----- Account Created ----");
        System.out.println(acc.displaInfo());
        System.out.println("Password: " + acc.getPassword());
        System.out.println("-----------------------\n");
    }

    /*
      Lists all email accounts stored in the EmailService.If no account exits , displays a message indicating that.
      Validates the account exists before updating the password using EmailService. for changing password.
     */
    private void listAccounts() {
        if (service.getAccounts().isEmpty()) {
            System.out.println("No Account Created Yet.");
        } else {

            for (Account acc : service.getAccounts()) {
                System.out.println(acc.displaInfo());
                System.out.println("--------------------");
            }
        }

    }

    private void changePassword() {
        System.out.println("Enter Email of Account: ");
        String email = scanner.nextLine().trim();
        Account account = null;
        for (Account a : service.getAccounts()) {   // Find account by email
            if (a.getEmail().equalsIgnoreCase(email)) {
                account = a;
                break;
            }
        }
        if (account == null) {
            System.out.println("No Account Found with this Email.");
            return;
        }
        System.out.println("Enter new password: ");
        String newPassword = scanner.nextLine();
        service.changePassword(account, newPassword);
        System.out.println("Password updated for " + account.getEmail());
        System.out.println("\n---------------------------");
    }

    private void importFromFile() {
        System.out.println("Enter CSV file name to import: ");
        String filePath = scanner.nextLine().trim();
        DataImporter importer = new DataImporter(service);
        importer.importFromCSV(filePath);
    }

    // Closes the scanner and exits the CLI interface.
    private void exit() {
        scanner.close();
        System.out.println("Goodbye!");
    }

}

