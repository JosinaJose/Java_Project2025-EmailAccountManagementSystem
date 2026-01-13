package emailApp;
/*
PasswordPolicy_Implemented class provides the concrete implementation of the PasswordPolicy interface.

  1. Generate secure random passwords using a combination of uppercase letters, lowercase letters,
     numbers, and special characters.
  2. Validate passwords based on defined rules (in this case, ensuring a minimum length of 6 characters).

 Used by EmailService or other classes to assign and validate passwords for user accounts.

 generatePassword(): Creates an 8-character random password.nisString(String password): Checks if the provided
 password meets the minimum policy requirements.
 */
import java.util.Random;

public class PasswordPolicy_Implemented implements PasswordPolicy{
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@!#$%^&*";

    // What it does: Generates a random 8-character password using letters (uppercase & lowercase), numbers, and special characters.
    @Override
    public String generatePassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {   // password length = 8
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return sb.toString();
    }


    public boolean isString(String password) {

        return password.length()>=6;
    }
}
