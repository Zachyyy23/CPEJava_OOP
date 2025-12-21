import javax.swing.*;


public class ShapeTestGUI {
    public static void main(String[] args) {
        Square square = new Square(0, 0, "Red", 4);


        JTextArea output = new JTextArea(10, 20);
        output.append("Color: " + square.getColor() + "\n");
        output.append("Area: " + square.getArea() + "\n");
        output.append("Perimeter: " + square.getPerimeter() + "\n");


        JFrame frame = new JFrame("Drawable Shape Test");
        frame.add(new JScrollPane(output));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}