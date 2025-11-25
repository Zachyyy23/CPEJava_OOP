package program;

import model.ChallengeResponse;
import model.PinMapper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // For demo, we fix a PIN. Could be replaced by user input.
        String pin = "12345";

        System.out.println("=== Randomized Challenge-Response Login System ===");
        System.out.println("Your actual PIN is hidden (e.g., 12345).");
        System.out.println("You will enter scrambled numbers instead.\n");

        while (true) {

            PinMapper mapper = new PinMapper();
            ChallengeResponse cr = new ChallengeResponse(pin, mapper);

            // Show mapping table
            mapper.displayMapping();

            System.out.print("Enter the NUM values that correspond to your PIN: ");
            String userEntry = sc.nextLine();

            if (cr.authenticate(userEntry)) {
                System.out.println("Access Granted!\n");
            } else {
                System.out.println("Access Denied!\n");
            }

            System.out.print("Do you want to try a new randomized mapping? (y/n): ");
            if (!sc.nextLine().equalsIgnoreCase("y")) {
                break;
            }

            System.out.println();
        }

        System.out.println("Goodbye!");
        sc.close();
    }
}
