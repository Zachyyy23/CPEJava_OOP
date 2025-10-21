package RectangleApp.program;

import RectangleApp.model.Rectangle;

public class RectangleTester {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        System.out.println("Rectangle 1:");
        System.out.println("Width: " + r1.getWidth());
        System.out.println("Height: " + r1.getHeight());
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        System.out.println();

        System.out.println("Rectangle 2:");
        System.out.println("Width: " + r2.getWidth());
        System.out.println("Height: " + r2.getHeight());
        System.out.println("Area: " + r2.getArea());
        System.out.println("Perimeter: " + r2.getPerimeter());
    }
}
