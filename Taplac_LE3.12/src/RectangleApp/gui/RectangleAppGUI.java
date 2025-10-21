package RectangleApp.gui;

import RectangleApp.model.Rectangle;
import javax.swing.*;
import java.awt.*;

public class RectangleAppGUI extends JFrame {
    private JTextArea resultArea;

    public RectangleAppGUI() {
        setTitle("Rectangle App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Rectangle Details"));
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        add(new RectanglePanel(), BorderLayout.CENTER);

        displayRectangles();
    }

    private void displayRectangles() {
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        StringBuilder sb = new StringBuilder();

        sb.append("Rectangle 1:\n");
        sb.append("Width: " + r1.getWidth() + "\n");
        sb.append("Height: " + r1.getHeight() + "\n");
        sb.append("Area: " + r1.getArea() + "\n");
        sb.append("Perimeter: " + r1.getPerimeter() + "\n\n");

        sb.append("Rectangle 2:\n");
        sb.append("Width: " + r2.getWidth() + "\n");
        sb.append("Height: " + r2.getHeight() + "\n");
        sb.append("Area: " + r2.getArea() + "\n");
        sb.append("Perimeter: " + r2.getPerimeter() + "\n");

        resultArea.setText(sb.toString());
    }

    class RectanglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int scale = 5;

            int r1Width = (int) (4 * scale);
            int r1Height = (int) (40 * scale);
            g.setColor(Color.BLUE);
            g.drawRect(50, 50, r1Width, r1Height);

            int r2Width = (int) (3.5 * scale);
            int r2Height = (int) (35.9 * scale);
            g.setColor(Color.RED);
            g.drawRect(200, 50, r2Width, r2Height);

            // Labels
            g.setColor(Color.BLACK);
            g.drawString("Rectangle 1", 50, 45);
            g.drawString("Rectangle 2", 200, 45);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RectangleAppGUI().setVisible(true);
        });
    }
}
