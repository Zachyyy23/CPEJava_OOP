import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class POS {
    private static List<String> menu = List.of(
            "Beef", "Appetizer 2", "Entrée 1", "Entrée 2",
            "Drink 1", "Drink 2", "Dessert 1", "Dessert 2"
    );
    private static List<String> orderList = new ArrayList<>();
    private static List<String> kitchenQueue = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n====== MINI POS SYSTEM ======");
            System.out.println("1. View Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. View Current Order");
            System.out.println("4. Send Order to Kitchen");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    addItem(sc);
                    break;
                case 3:
                    viewOrder();
                    break;
                case 4:
                    sendToKitchen();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }

    private static void viewMenu() {
        System.out.println("\n--- MENU ---");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    private static void addItem(Scanner sc) {
        viewMenu();
        System.out.print("Enter item number to add: ");
        int itemNum = sc.nextInt();
        sc.nextLine();
        if (itemNum >= 1 && itemNum <= menu.size()) {
            orderList.add(menu.get(itemNum - 1));
            System.out.println(menu.get(itemNum - 1) + " added to order.");
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private static void viewOrder() {
        System.out.println("\n--- CURRENT ORDER ---");
        if (orderList.isEmpty()) {
            System.out.println("No items in order.");
        } else {
            for (String item : orderList) {
                System.out.println("- " + item);
            }
        }
    }

    private static void sendToKitchen() {
        if (orderList.isEmpty()) {
            System.out.println("No items to send.");
        } else {
            kitchenQueue.addAll(orderList);
            orderList.clear();
            System.out.println("Order sent to kitchen.");
        }
    }
}
