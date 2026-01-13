package emailApp;
/*
The DataImporter class is responsible for importing employee account data from a CSV file located in the resources folder.

 It reads employee details (First Name, Last Name, Department) line by line,creates corresponding email accounts via the EmailService,
 and displays the generated account information (including email and password).
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataImporter {
    private EmailService service;

    public DataImporter(EmailService service) {
        this.service = service;
    }

    // Import CSV from classpath
    public void importFromCSV(String fileName) {
        try {
            // loaded the file
            InputStream is = getClass().getResourceAsStream("/emailApp/" + fileName);
            if (is == null) {
                System.out.println("File not found in resources: " + fileName);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            boolean firstLine = true;
            //read each line of the csv file
            while ((line = reader.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; } // skip header

                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                String first = parts[0].trim();
                String last = parts[1].trim();
                String dept = parts[2].trim();
                service.createAccount(first, last, dept);
                // Create account using EmailService
                Account acc = service.createAccount(first, last, dept);
                // Display the imported account details
                System.out.println("\n----- Account Imported ----");
                System.out.println(acc.displaInfo());
                System.out.println("Password: " + acc.getPassword());
                System.out.println("--------------------------\n");
            }

            reader.close();
            System.out.println("Data imported successfully from " + fileName);

        } catch (Exception e) {
            e.printStackTrace();// Display the newly imported account details
        }
    }
}
