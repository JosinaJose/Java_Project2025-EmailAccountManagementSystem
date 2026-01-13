package emailApp;
/*
PasswordPolicy interface defines the contract for password handling.Any class implementing this interface must provide:
 1. generatePassword() - to generate a new secure password.
 2. isString(String password) - to validate if a given password meets the policy requirements.
 */

public interface PasswordPolicy {
    String generatePassword(); //Generates a random password according to the policy.
    boolean isString(String Password); //Checks if the given password is valid according to the policy.
}
