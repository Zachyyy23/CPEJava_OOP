package CashRegister.services;

import java.util.Scanner;
import CashRegister.model.CashReg;

public class AdminService {
    private static final String ADMIN_PASSWORD = "iloveCPE"; //<---password is this one

    public static void enterAdminMode(CashReg register, Scanner scanner) {
        System.out.print("Enter admin password: ");
        String password = scanner.next();

        if (password.equals(ADMIN_PASSWORD)) {
            System.out.println("Access granted.");
            System.out.println("Current cash balance: " + register.getCurrentBalance() + " cents.");
        } else {
            System.out.println("Access denied.");
        }
    }
}
