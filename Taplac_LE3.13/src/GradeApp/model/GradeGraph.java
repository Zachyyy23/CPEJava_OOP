package GradeApp.model;

public class GradeGraph {
    private GradeCalculator calculator;

    public GradeGraph(GradeCalculator calculator) {
        this.calculator = calculator;
    }

    public void printGraph() {
        System.out.println(" 0   10   20   30   40   50   60   70   80   90  100%");
        System.out.println("|----|----|----|----|----|----|----|----|----|----|");

        printRow('A', calculator.getPercentage('A'));
        printRow('B', calculator.getPercentage('B'));
        printRow('C', calculator.getPercentage('C'));
        printRow('D', calculator.getPercentage('D'));
        printRow('F', calculator.getPercentage('F'));
    }

    private void printRow(char grade, int percentage) {
        int stars = (int) Math.round(percentage / 2.0); // 1 star = 2%
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < stars; i++) {
            row.append("*");
        }
        System.out.println(row + "  " + grade);
    }
}
