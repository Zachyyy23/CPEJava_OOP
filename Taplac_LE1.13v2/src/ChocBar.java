import java.util.Scanner;

public class ChocBar {
    private static double weight;
    private static double height;
    private static int age;
    private static double bmrWoman;
    private static double bmrMan;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        weight = getInput(input, "Enter weight (in pounds): ");
        height = getInput(input, "Enter height (in inches): ");
        age = (int) getInput(input, "Enter age (in years): ");

        bmrWoman = calculateBmrWoman();
        bmrMan = calculateBmrMan();

        showResults();

        input.close();
    }

    private static double getInput(Scanner input, String message) {
        System.out.print(message);
        return input.nextDouble();
    }

    private static double calculateBmrWoman() {
        return 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
    }

    private static double calculateBmrMan() {
        return 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
    }

    private static void showResults() {
        final double caloriesPerBar = 230.0;
        double barsWoman = bmrWoman / caloriesPerBar;
        double barsMan = bmrMan / caloriesPerBar;

        System.out.printf("%nA woman of this weight (%.1f), height (%.1f), and age (%d) needs about %.2f chocolate bars per day.%n",
                weight, height, age, barsWoman);
        System.out.printf("A man of this weight, height, and age needs about %.2f chocolate bars per day.%n",
                barsMan);
    }
}
