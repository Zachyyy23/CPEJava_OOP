import java.util.Scanner;

public class ZellerForm {
    private static int year;
    private static int month;
    private static int day;
    private static int dayOfWeek;

    public static void main(String[] args) {
        System.out.println("Zeller's Congruence Theorem");
        Scanner inputs = new Scanner(System.in);

        year = getYear(inputs);
        month = getMonth(inputs);
        day = getDay(inputs);

        inputs.close();

        dayOfWeek = calculateDayOfWeek();
        printDay();
    }

    private static int getYear(Scanner input) {
        System.out.print("Enter year: ");
        return input.nextInt();
    }

    private static int getMonth(Scanner input) {
        System.out.print("Enter Month: 1 - 12: ");
        int m = input.nextInt();
        while (m < 1 || m > 12) {
            System.out.print("Invalid Number!\nEnter Month: 1 - 12: ");
            m = input.nextInt();
        }
        return m;
    }

    private static int getDay(Scanner input) {
        System.out.print("Enter Day of Month: 1 - 31: ");
        int d = input.nextInt();
        while (d < 1 || d > 31) {
            System.out.print("Invalid Number!\nEnter Day of Month: 1 - 31: ");
            d = input.nextInt();
        }
        return d;
    }

    private static int calculateDayOfWeek() {
        int tempMonth = month;
        int tempYear = year;

        if (tempMonth == 1) {
            tempMonth = 13;
            tempYear -= 1;
        } else if (tempMonth == 2) {
            tempMonth = 14;
            tempYear -= 1;
        }

        int j = tempYear / 100;
        int k = tempYear % 100;

        int h = day + ((26 * (tempMonth + 1)) / 10) + k + (k / 4) + (j / 4) + (5 * j);
        return h % 7;
    }

    private static void printDay() {
        switch (dayOfWeek) {
            case 0 -> System.out.println("\nIt is a Saturday!");
            case 1 -> System.out.println("\nIt is a Sunday!");
            case 2 -> System.out.println("\nIt is a Monday!");
            case 3 -> System.out.println("\nIt is a Tuesday!");
            case 4 -> System.out.println("\nIt is a Wednesday!");
            case 5 -> System.out.println("\nIt is a Thursday!");
            case 6 -> System.out.println("\nIt is a Friday!");
        }
    }
}
