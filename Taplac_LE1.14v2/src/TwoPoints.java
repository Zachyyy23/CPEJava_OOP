import java.util.Scanner;

public class TwoPoints {
    private static double x1, y1, x2, y2, distance;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] point1 = getPoint(input, "Enter x1 and y1: ");
        x1 = point1[0];
        y1 = point1[1];

        double[] point2 = getPoint(input, "Enter x2 and y2: ");
        x2 = point2[0];
        y2 = point2[1];

        distance = calculateDistance();
        showResult();

        input.close();
    }

    private static double[] getPoint(Scanner input, String message) {
        System.out.print(message);
        double x = input.nextDouble();
        double y = input.nextDouble();
        return new double[]{x, y};
    }

    private static double calculateDistance() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static void showResult() {
        System.out.println("The distance between the two points is " + distance);
    }
}
