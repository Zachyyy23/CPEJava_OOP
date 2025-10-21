import java.util.Scanner;

public class MultiplyDigit {
    private static int numberChoice;
    private static int product;

    public static void main(String[] args) {
        Scanner choiceRead = new Scanner(System.in);

        numberChoice = getInput(choiceRead);
        product = computeProduct(numberChoice);

        showResult();

        choiceRead.close();
    }

    private static int getInput(Scanner input) {
        System.out.print("Enter a number between 0 - 1000: ");
        return input.nextInt();
    }

    private static int computeProduct(int number) {
        int result = 1;
        String numStr = Integer.toString(number);

        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            result *= digit;
        }
        return result;
    }

    private static void showResult() {
        System.out.println("The product of all digits in " + numberChoice + " is " + product);
    }
}
