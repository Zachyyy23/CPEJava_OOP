package GradeApp.model;

import java.util.Scanner;

public class GradeInput {
    private Scanner sc;

    public GradeInput() {
        sc = new Scanner(System.in);
    }

    public GradeDistribution getUserInput() {
        System.out.print("Enter number of A grades: ");
        int a = sc.nextInt();

        System.out.print("Enter number of B grades: ");
        int b = sc.nextInt();

        System.out.print("Enter number of C grades: ");
        int c = sc.nextInt();

        System.out.print("Enter number of D grades: ");
        int d = sc.nextInt();

        System.out.print("Enter number of F grades: ");
        int f = sc.nextInt();

        return new GradeDistribution(a, b, c, d, f);
    }

    public void close() {
        sc.close();
    }
}
