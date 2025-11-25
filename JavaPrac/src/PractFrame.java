import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class PractFrame {

    public static void main (String[] args) {
        //JFrame Tutorial

        JPanel Category = new JPanel();
        Category.setBackground(Color.BLUE);
        Category.setBounds(0,0,200,750);

        JPanel Choices = new JPanel();
        Choices.setBackground(Color.red);
        Choices.setBounds(200,0,400,750);

        JPanel Summary = new JPanel();
        Summary.setBackground(Color.GREEN);
        Summary.setBounds(600,0,400,750);

        JFrame FirstFrame = new JFrame();
        FirstFrame.setTitle("Simple POS");
        FirstFrame.setVisible(true);
        FirstFrame.setLayout(null);
        FirstFrame.setSize(900,750);
        FirstFrame.setDefaultCloseOperation(FirstFrame.EXIT_ON_CLOSE);
        FirstFrame.add(Category);
        FirstFrame.add(Choices);
        FirstFrame.add(Summary);


    }
}
