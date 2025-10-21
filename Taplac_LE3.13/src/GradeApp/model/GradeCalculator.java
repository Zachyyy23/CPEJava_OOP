package GradeApp.model;

public class GradeCalculator {
    private GradeDistribution distribution;

    public GradeCalculator(GradeDistribution distribution) {
        this.distribution = distribution;
    }

    public int getPercentage(char grade) {
        int total = distribution.getTotal();
        if (total == 0) return 0;

        switch (grade) {
            case 'A': return Math.round((distribution.getA() * 100f) / total);
            case 'B': return Math.round((distribution.getB() * 100f) / total);
            case 'C': return Math.round((distribution.getC() * 100f) / total);
            case 'D': return Math.round((distribution.getD() * 100f) / total);
            case 'F': return Math.round((distribution.getF() * 100f) / total);
        }
        return 0;
    }
}
