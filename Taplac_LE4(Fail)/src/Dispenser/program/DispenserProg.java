package Dispenser.program;

import Dispenser.model.DispenserObj;

import java.util.Scanner;

public class DispenserProg {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        DispenserObj appleJuice = new DispenserObj("Apple Juice", 50, 20);
        DispenserObj orangeJuice = new DispenserObj("Orange Juice",50, 20);
        DispenserObj mangoLassi = new DispenserObj("Mango Lassi", 50, 20);
        DispenserObj fruitPunch = new DispenserObj("Fruit Punch", 50, 20);

        System.out.println("How's Your Day? Care for a drink? These are our available selections!");
        System.out.println("(1) Apple Juice\n(2) Orange Juice\n(3) Mango Lassi\n(4) Fruit Punch");
        System.out.print("Enter your Choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case(1):
                String choice2;
                System.out.println("Perfect! Our Apple Juice costs " + appleJuice.getItemCost() + " Pesos");
                System.out.println("We currently have " + appleJuice.getNoOfItems() + " servings left.");
                System.out.print("Confirm Order? Y/N: ");
                choice2 = scanner.nextLine();

                if (choice2.equalsIgnoreCase("Y")) {
                    appleJuice.setNoOfItems(appleJuice.getNoOfItems() - 1);
                    System.out.println(appleJuice.getNoOfItems());
                }
        }

    }
}
