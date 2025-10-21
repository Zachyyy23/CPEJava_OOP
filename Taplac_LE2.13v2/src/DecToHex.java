import java.util.Scanner;

public class DecToHex {
    private static int decimal;
    private static String hex = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        decimal = getInput(input);
        input.close();

        if (decimal == 0) {
            System.out.println("Hexadecimal number: 0");
            return;
        }

        convertToHex();
        showResult();
    }

    private static int getInput(Scanner input) {
        System.out.print("Enter a decimal number: ");
        return input.nextInt();
    }

    private static void convertToHex() {
        while (decimal > 0) {
            int remainder = decimal % 16;
            char hexDigit;
            if (remainder < 10) {
                hexDigit = (char) ('0' + remainder);
            } else {
                hexDigit = (char) ('A' + (remainder - 10));
            }
            hex = hexDigit + hex;
            decimal = decimal / 16;
        }
    }

    private static void showResult() {
        System.out.println("Hexadecimal number: " + hex);
    }
}
