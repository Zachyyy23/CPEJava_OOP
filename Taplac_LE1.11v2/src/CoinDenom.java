import java.util.Scanner;


public class CoinDenom {
    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);

        System.out.print("Choose a number between 1 - 99: ");

        int cents = input.nextInt();

        if (cents >= 1 && cents <= 99) {
            int[] coins = DenomProg(cents);
            showPrinter(coins);
        }else {
            System.out.println("Invalid Number! Enter a number from 1 - 99");
        }

        input.close();
    }

    public static int[] DenomProg(int cents) {

        int quarter = cents / 25;
        cents %= 25;

        int dime = cents / 10;
        cents %= 10;

        int nickel = cents / 5;
        cents %= 5;

        int penny = cents;

        return new int[] {quarter, dime, nickel, penny};

    }
    public static void showPrinter(int[] coins) {

        System.out.println("Quarters: " + coins[0]);
        System.out.println("Dimes: " + coins[1]);
        System.out.println("Nickel: " + coins[2]);
        System.out.println("Pennies: " + coins[3]);

    }
}