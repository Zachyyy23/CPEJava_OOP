package GradeApp.model;

public class GradeDistribution {
    private int aCount, bCount, cCount, dCount, fCount;

    public GradeDistribution(int a, int b, int c, int d, int f) {
        this.aCount = a;
        this.bCount = b;
        this.cCount = c;
        this.dCount = d;
        this.fCount = f;
    }

    public int getA() { return aCount; }
    public int getB() { return bCount; }
    public int getC() { return cCount; }
    public int getD() { return dCount; }
    public int getF() { return fCount; }

    public int getTotal() {
        return aCount + bCount + cCount + dCount + fCount;
    }
}
