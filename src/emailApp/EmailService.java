package emailApp;

import java.util.ArrayList;

/* The EmailService class is responsible for managing email accounts.
It provides methods to create accounts, change passwords, and  retrieve all account.
It uses a PasswordPolicy to generate and validate passwords for accounts.
 */

public class EmailService {
    // Stores all accounts created in the system
    private ArrayList<Account> accounts = new ArrayList<>();
    private PasswordPolicy passwordPolicy; //PasswordPolicy used for generating and validating passwords


    public EmailService(PasswordPolicy policy){
        this.passwordPolicy = policy;
    }
    //Creates a new email account with the given first name, last name, and department.

    public Account createAccount(String first, String last, String dept){
        Account account = new UserAccount(first,last,dept);
        account.setPassword(passwordPolicy.generatePassword());// generate password
        accounts.add(account);// add account to list
        return account;

    }
    //Changes the password of the given account. Validates the new password using the PasswordPolicy.
    //If the password is too weak, it prints a warning and does not change it.
    public void changePassword(Account account, String newPass){
        if (passwordPolicy.isString(newPass))
        {
            account.setPassword(newPass);
        }else{
            System.out.println("Password is too weak!");
        }


    }
     //Returns the list of all accounts currently managed by this service.
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
