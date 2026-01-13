package emailApp;
/*
 UserAccount class represents a standard user email account in the system.

 This class extends the abstract Account class and provides a concrete implementationfor the abstract method getDefaultCapacity().

 1. Store user-specific information such as first name, last name, department, email, and mailbox capacity.
 2. Provide default mailbox capacity for standard user accounts (1000MB in this case).

 Instances of UserAccount are created via EmailService when a new user account is added.
 */
public class UserAccount extends Account {
    public UserAccount(String first, String last, String dept){
        super(first,last,dept);
    }
    @Override
    public int getDefaultCapacity(){
        return 1000;
    }
}
