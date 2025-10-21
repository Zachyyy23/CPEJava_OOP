package Dispenser.program;

import java.util.Scanner;
import CashRegister.model.CashReg;
import CashRegister.services.AdminService;
import Dispenser.model.DispenserObj;
import Dispenser.services.ProductService;

public class DispenserProg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CashReg register = new CashReg();

        DispenserObj apple = new DispenserObj(10, 50);
        DispenserObj orange = new DispenserObj(10, 60);
        DispenserObj mango = new DispenserObj(10, 70);
        DispenserObj punch = new DispenserObj(10, 80);

        boolean running = true;
        while (running) {
            showSelection();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: ProductService.sellProduct(apple, register, scanner); break;
                case 2: ProductService.sellProduct(orange, register, scanner); break;
                case 3: ProductService.sellProduct(mango, register, scanner); break;
                case 4: ProductService.sellProduct(punch, register, scanner); break;
                case 9: AdminService.enterAdminMode(register, scanner); break;
                case 5:
                    System.out.println("Thank you! Come again.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
        scanner.close();
    }

    public static void showSelection() {
        System.out.println("\n -Juice Menu-");
        System.out.println("1. Apple Juice");
        System.out.println("2. Orange Juice");
        System.out.println("3. Mango Lassi");
        System.out.println("4. Fruit Punch");
        System.out.println("5. Exit");
        System.out.println("9. Admin Mode");
        System.out.print("Select an option: ");
    }
}
