package emailApp;
/*
Main class serves as the entry point of the Email Management Application.
It initializes the EmailService with a password policy and starts
the EmailAccountManager, which handles all user commands (Add, List, Change Password, Exit).
 */


public class Main {
    public static void main(String[] args) {
        // Initialize the email service with a password policy
        EmailService service =new EmailService(new PasswordPolicy_Implemented());
        // Create the EmailAccountManager to handle user commands
        EmailAccountManager app =  new EmailAccountManager(service);

        app.start(); // Start the application
    }
}
