import java.util.Random;
import java.util.UUID;

public class EmailGenerator {

    // Method to generate a random email address
    public static String generateRandomEmail() {
        String[] domains = {"example.com", "fakemail.net", "tempmail.org", "dummyemail.com"};
        String emailPrefix = UUID.randomUUID().toString().substring(0, 8); // Unique prefix
        Random random = new Random();
        String domain = domains[random.nextInt(domains.length)];
        return emailPrefix + "@" + domain;
    }

    public static void main(String[] args) {
        // Example usage
        String randomEmail = generateRandomEmail();
        System.out.println("Generated Email: " + randomEmail);
    }
}
