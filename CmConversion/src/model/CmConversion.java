package model;

public class CmConversion {
    private double centimeters;

    public CmConversion() {
        this.centimeters = 0;
    }

    public CmConversion(double centimeters) {
        this.centimeters = centimeters;
    }

    public double getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(double centimeters) {
        this.centimeters = centimeters;
    }

    public double toInches() {
        return centimeters / 2.54;
    }

    public double toYards() {
        double inches = toInches();
        double feet = inches / 12;
        return feet / 3;
    }
}
