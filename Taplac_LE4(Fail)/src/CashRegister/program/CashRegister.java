package CashRegister.program;

import java.util.Scanner;
import CashRegister.model.CashReg;
import CashRegister.services.GetBalance;

import static CashRegister.services.GetBalance.displayBalance;

public class CashRegister {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        CashReg cashier = new CashReg(500, "Zachare", "iloveCPE");

        System.out.println("Hello Dear Guest...");
        System.out.println("(1)Order a Drink\n(2)Access Admin");
        System.out.print("What would you like to do?: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Proceed to Juicer");
                break;
            case 2:
                int attempts = 0;
                String passAttempt = "";
                boolean authenticator = false;

                while (attempts < 3 && !authenticator) {
                    System.out.print("Enter Admin Password: ");
                    passAttempt = scanner.nextLine();

                    if (passAttempt.equals(cashier.getPassword())) {
                        authenticator = true;
                        System.out.println("Welcome " + cashier.getOwner());
                        System.out.print("Enter (1) to Check Balance: ");
                        choice = scanner.nextInt();
                        if(choice == 1) {
                            GetBalance.displayBalance(cashier);
                        }

                    } else {
                        attempts++;
                        if (attempts < 3) {
                            System.out.println("Invalid Password, Try Again (" + (3 - attempts) + (" attemps left)"));
                        } else {
                            System.out.println("You have reached the maximum attempts...");
                        }
                    }
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
