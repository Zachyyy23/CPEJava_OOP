package GradeApp.program;

import GradeApp.model.*;

public class GradeDistributionTester {
    public static void main(String[] args) {

        GradeInput input = new GradeInput();
        GradeDistribution gd = input.getUserInput();

        GradeCalculator calc = new GradeCalculator(gd);
        GradeGraph graph = new GradeGraph(calc);

        System.out.println("\n=== Grade Distribution Summary ===");
        System.out.println("Total grades: " + gd.getTotal());
        System.out.println("A: " + calc.getPercentage('A') + "%");
        System.out.println("B: " + calc.getPercentage('B') + "%");
        System.out.println("C: " + calc.getPercentage('C') + "%");
        System.out.println("D: " + calc.getPercentage('D') + "%");
        System.out.println("F: " + calc.getPercentage('F') + "%");

        System.out.println("\n=== Bar Graph ===");
        graph.printGraph();

        input.close();
    }
}
