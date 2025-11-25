package program;


import model.Game;
import model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame implements ActionListener {

    private JButton[][] buttons;
    private Game game;

    public TicTacToeGUI() {
        game = new Game();
        buttons = new JButton[3][3];

        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clicked = (JButton) e.getSource();

        int row = -1, col = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == clicked) {
                    row = i;
                    col = j;
                }
            }
        }

        if (game.getBoard().placeMove(row, col, game.getCurrentPlayer())) {
            clicked.setText(String.valueOf(game.getCurrentPlayer()));

            if (game.checkWinner()) {
                JOptionPane.showMessageDialog(this,
                        "Player " + game.getCurrentPlayer() + " WINS!");
                resetGUI();
                return;
            }

            if (game.getBoard().isFull()) {
                JOptionPane.showMessageDialog(this, "It's a DRAW!");
                resetGUI();
                return;
            }

            game.switchPlayer();

        } else {
            JOptionPane.showMessageDialog(this, "Spot already taken!");
        }
    }

    private void resetGUI() {
        game.resetGame();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
