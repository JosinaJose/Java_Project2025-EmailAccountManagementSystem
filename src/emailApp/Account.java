package emailApp;

/*
Abstract class representing a generic Email Account.

This class encapsulates the basic information and behaviors of an email account, including first name, last name, department,
email address, password, mailbox capacity, and an optional alternative email.

 Key Features:
 - Generates an email automatically based on the first name, last name, and department.
 - Stores and allows updating the account password and mailbox capacity.
 - Abstract method `getDefaultCapacity()` enforces subclasses to define default mailbox capacity, demonstrating polymorphism.
 - Provides a `displaInfo()` method to display the account details.

  Usage:
 - Extend this class to create concrete account types (e.g., UserAccount, AdminAccount)and provide an implementation for `getDefaultCapacity()`.
 - The `department` field is stored as a String; if no department is provided, it defaults to "NONE".
 - Passwords can be updated using `setPassword()`.
 */

public abstract class Account {
    private String firstName;
    private String lastName;
    //private Department department;
    private String department;
    private String email;
    private String password;
    private int mailboxCapacity;
    private String alternativeEmail;


    public Account(String first, String last, String dept) {
        this.firstName = first;
        this.lastName = last;
        this.department = dept;
        this.email = generateEmail();
        this.password = "default123";
        this.mailboxCapacity = getDefaultCapacity();


    }

     //Abstract method to define default mailbox capacity.
    //Each subclass must implement this method to specify default capacity.
    public abstract int getDefaultCapacity();
    //------ Generate email using first.last@department.company.com-----//

    private String generateEmail() {

        String dept = (department.equalsIgnoreCase(Department.NONE)) ? "" : department.toLowerCase() + ".";
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + dept + "company.com";
    }
     //Get the first first name of the account holder
    public String getFirstName() {
        return firstName;
    }
   //gets the last name of the account holder
    public String getLastName() {
        return lastName;
    }
      //get the email of the account
    public String getEmail() {
        return email;
    }
    //get the password
    public String getPassword() {
        return password;
    }
   // change password
    public void setPassword(String password) {
        this.password = password;
    }
   // get the mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
   //sets a new mailbox capcity MB
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }
     //gets alternative email  address(if any)
    public String getAlternativeEmail() {
        return alternativeEmail;
    }
     // sets an alternative email address for the account
    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }
     //get the department of th account holder
    public String getDepartment() {
        return department;
    }
     //display the account information as a formated string
    public String displaInfo() {
        return "Name: " + firstName + " " + lastName
                + "\n Email: " + email
                + "\nMailbox: " + mailboxCapacity + "MB"
                + "\nDepartment: " + (department.isEmpty() ? "NONE" : department)
                + "\nAlternative Email: " + (alternativeEmail != null ? alternativeEmail : "None");

    }


}
