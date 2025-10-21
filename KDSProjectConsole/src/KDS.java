import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class KDS {
    // In a real project, this might be shared through a file or database.
    // For this simple demo, we simulate it with a static list.
    private static List<String> kitchenQueue = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // For testing purposes: simulate orders received
        kitchenQueue.add("Appetizer 1");
        kitchenQueue.add("Drink 1");

        while (running) {
            System.out.println("\n====== KITCHEN DISPLAY SYSTEM ======");
            System.out.println("1. View Incoming Orders");
            System.out.println("2. Mark Item as Done");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    viewOrders();
                    break;
                case 2:
                    markAsDone(sc);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }

    private static void viewOrders() {
        System.out.println("\n--- KITCHEN QUEUE ---");
        if (kitchenQueue.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            for (int i = 0; i < kitchenQueue.size(); i++) {
                System.out.println((i + 1) + ". " + kitchenQueue.get(i));
            }
        }
    }

    private static void markAsDone(Scanner sc) {
        if (kitchenQueue.isEmpty()) {
            System.out.println("No items to mark.");
            return;
        }
        viewOrders();
        System.out.print("Enter item number to mark as done: ");
        int itemNum = sc.nextInt();
        sc.nextLine();
        if (itemNum >= 1 && itemNum <= kitchenQueue.size()) {
            System.out.println(kitchenQueue.get(itemNum - 1) + " completed!");
            kitchenQueue.remove(itemNum - 1);
        } else {
            System.out.println("Invalid selection.");
        }
    }
}
