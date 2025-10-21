import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class headsOrTails extends JFrame {
    private JLabel resultLabel;
    private JButton flipButton;

    public headsOrTails() {
        setTitle("Heads or Tails Simulation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 5, 5));

        JLabel titleLabel = new JLabel("Heads or Tails Program", SwingConstants.CENTER);
        add(titleLabel);

        flipButton = new JButton("Simulate 2,000,000 Flips");
        add(flipButton);

        resultLabel = new JLabel("Press the button to start.", SwingConstants.CENTER);
        add(resultLabel);

        flipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int headsCount = 0;
                int tailsCount = 0;
                int iterations = 2_000_000;

                for (int i = 0; i < iterations; i++) {
                    boolean result = random.nextBoolean();
                    if (result) {
                        headsCount++;
                    } else {
                        tailsCount++;
                    }
                }

                resultLabel.setText("After 2,000,000 flips: Heads = " + headsCount + ", Tails = " + tailsCount);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new headsOrTails().setVisible(true);
        });
    }
}