import javax.swing.*;
import java.awt.*;

public class HangmanGUI extends JFrame {

    private HangmanGame game;
    private WordBank bank = new WordBank();

    private JLabel wordLabel;
    private JLabel messageLabel;
    private JLabel missLabel;
    private JTextField guessField;
    private JButton guessButton;

    public HangmanGUI() {

        setTitle("Hangman Game");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        startNewGame();

        wordLabel = new JLabel("Word: " + game.getHiddenWord(), SwingConstants.CENTER);
        messageLabel = new JLabel("Enter a letter below:", SwingConstants.CENTER);
        missLabel = new JLabel("Misses: 0", SwingConstants.CENTER);

        JPanel inputPanel = new JPanel();
        guessField = new JTextField(5);
        guessButton = new JButton("Guess");

        guessButton.addActionListener(e -> handleGuess());

        inputPanel.add(guessField);
        inputPanel.add(guessButton);

        add(wordLabel);
        add(messageLabel);
        add(missLabel);
        add(inputPanel);

        setVisible(true);
    }

    private void startNewGame() {
        game = new HangmanGame(bank.getRandomWord());
    }

    private void handleGuess() {
        String text = guessField.getText().toLowerCase();

        if (text.length() != 1) {
            messageLabel.setText("Please enter ONE letter.");
            guessField.setText("");
            return;
        }

        char letter = text.charAt(0);

        int result = game.guessLetter(letter);

        if (result == -1) {
            messageLabel.setText(letter + " is already in the word");
        }
        else if (result == 0) {
            messageLabel.setText(letter + " is not in the word");
        }
        else {
            messageLabel.setText("Good guess!");
        }

        wordLabel.setText("Word: " + game.getHiddenWord());
        missLabel.setText("Misses: " + game.getMisses());

        guessField.setText("");

        // Check if game is complete
        if (game.isWordComplete()) {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "The word is " + game.getWord() +
                            "\nYou missed " + game.getMisses() + " time(s).\nPlay again?",
                    "Game Over",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                startNewGame();
                wordLabel.setText("Word: " + game.getHiddenWord());
                missLabel.setText("Misses: 0");
                messageLabel.setText("Enter a letter:");
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new HangmanGUI();
    }
}
