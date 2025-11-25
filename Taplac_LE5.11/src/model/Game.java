package model;

public class Game {

    private Board board;
    private char currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public Board getBoard() {
        return board;
    }

    public void resetGame() {
        board.reset();
        currentPlayer = 'X';
    }

    public boolean checkWinner() {
        char[][] b = board.getBoard();
        char p = currentPlayer;

        for (int i = 0; i < 3; i++) {
            if (b[i][0] == p && b[i][1] == p && b[i][2] == p)
                return true;
        }

        for (int j = 0; j < 3; j++) {
            if (b[0][j] == p && b[1][j] == p && b[2][j] == p)
                return true;
        }

        if (b[0][0] == p && b[1][1] == p && b[2][2] == p)
            return true;

        if (b[0][2] == p && b[1][1] == p && b[2][0] == p)
            return true;

        return false;
    }
}
