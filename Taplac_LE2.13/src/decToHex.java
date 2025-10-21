import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class decToHex extends JFrame {
    private JTextField decimalField;
    private JLabel resultLabel;

    public decToHex() {
        setTitle("Decimal to Hexadecimal Converter");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Enter a decimal number:"));
        decimalField = new JTextField();
        add(decimalField);

        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("", SwingConstants.CENTER);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int decimal = Integer.parseInt(decimalField.getText());

                    if (decimal == 0) {
                        resultLabel.setText("Hexadecimal number: 0");
                        return;
                    }

                    String hex = "";
                    while (decimal > 0) {
                        int remainder = decimal % 16;
                        char hexDigit;

                        if (remainder < 10) {
                            hexDigit = (char) ('0' + remainder);
                        } else {
                            hexDigit = (char) ('A' + (remainder - 10));
                        }

                        hex = hexDigit + hex;
                        decimal = decimal / 16;
                    }

                    resultLabel.setText("Hexadecimal number: " + hex);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new decToHex().setVisible(true);
        });
    }
}