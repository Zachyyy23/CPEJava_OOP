package program;

import java.util.Scanner;
import model.CmConversion;

public class CMConversionTest {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("CM Conversion Tester");

        System.out.print("Input amount of conversion you want to make: ");
        int count = scanner.nextInt();

        for(int i = 1; i<= count; i++) {
            System.out.print("\nEnter length in cm for conversion " + i + ": ");
            double cmValue = scanner.nextDouble();

            CmConversion conversion = new CmConversion(cmValue);

            System.out.printf("Centimeters: %.2f cm%n", conversion.getCentimeters());
            System.out.printf("Inches: %.2f in%n", conversion.toInches());
            System.out.printf("Yards: %.4f yd%n", conversion.toYards());
        }
        scanner.close();
    }
}
