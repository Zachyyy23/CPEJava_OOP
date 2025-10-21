import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JTextField yearField, monthField, dayField;
    private JLabel resultLabel;

    public Main() {
        setTitle("Zeller's Congruence Theorem");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Labels and input fields
        add(new JLabel("Enter Year:"));
        yearField = new JTextField();
        add(yearField);

        add(new JLabel("Enter Month (1-12):"));
        monthField = new JTextField();
        add(monthField);

        add(new JLabel("Enter Day (1-31):"));
        dayField = new JTextField();
        add(dayField);

        JButton calcButton = new JButton("Find Day");
        resultLabel = new JLabel("");
        add(calcButton);
        add(resultLabel);

        // Button action
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(yearField.getText());
                    int letterM = Integer.parseInt(monthField.getText());
                    int letterQ = Integer.parseInt(dayField.getText());

                    // adjust months Jan & Feb
                    if (letterM == 1) {
                        letterM = 13;
                        year -= 1;
                    } else if (letterM == 2) {
                        letterM = 14;
                        year -= 1;
                    }

                    int letterJ = year / 100;
                    int letterK = year % 100;

                    int letterH = letterQ + ((26 * (letterM + 1) / 10) + letterK + (letterK / 4) + (letterJ / 4) + 5 * letterJ);
                    letterH %= 7;

                    String day = "";
                    switch (letterH) {
                        case 0: day = "Saturday"; break;
                        case 1: day = "Sunday"; break;
                        case 2: day = "Monday"; break;
                        case 3: day = "Tuesday"; break;
                        case 4: day = "Wednesday"; break;
                        case 5: day = "Thursday"; break;
                        case 6: day = "Friday"; break;
                    }

                    resultLabel.setText("It is a " + day + "!");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
