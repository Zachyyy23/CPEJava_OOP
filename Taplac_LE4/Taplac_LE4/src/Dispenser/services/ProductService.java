package Dispenser.services;

import java.util.Scanner;
import CashRegister.model.CashReg;
import Dispenser.model.DispenserObj;

public class ProductService {

    public static void sellProduct(DispenserObj dispenser, CashReg register, Scanner scanner) {
        if (dispenser.getNoOfItems() <= 0) {
            System.out.println("Sorry, this product is sold out.");
            return;
        }

        int cost = dispenser.getCost();
        System.out.println("The cost is " + cost + " cents.");
        System.out.print("Please deposit money: ");
        int deposit = scanner.nextInt();

        if (deposit < cost) {
            System.out.println("You need to deposit at least " + (cost - deposit) + " more cents.");
            System.out.print("Please deposit additional money: ");
            deposit += scanner.nextInt();
        }

        if (deposit < cost) {
            System.out.println("Not enough money deposited. Returning " + deposit + " cents.");
            return;
        }

        register.acceptAmount(cost);
        dispenser.makeSale();

        int change = deposit - cost;
        if (change > 0) {
            System.out.println("Here is your change: " + change + " cents.");
        }
        System.out.println("Enjoy your drink!");
    }
}
