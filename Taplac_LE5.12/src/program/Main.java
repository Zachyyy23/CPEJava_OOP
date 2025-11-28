//for console version

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WordBank bank = new WordBank();
        boolean playAgain = true;

        System.out.println("=== HANGMAN GAME ===");

        while (playAgain) {

            String randomWord = bank.getRandomWord();
            HangmanGame game = new HangmanGame(randomWord);

            while (true) {
                System.out.print("(Guess) Enter a letter in word " + game.getHiddenWord() + " > ");
                char letter = sc.next().toLowerCase().charAt(0);

                int result = game.guessLetter(letter);

                if (result == -1) {
                    System.out.println("   " + letter + " is already in the word");
                }
                else if (result == 0) {
                    System.out.println("   " + letter + " is not in the word");
                }

                if (game.isWordComplete()) {
                    System.out.println("The word is " + game.getWord() + ".");
                    System.out.println("You missed " + game.getMisses() + " time(s).");
                    break;
                }
            }

            System.out.print("Do you want to guess another word? (y or n): ");
            playAgain = sc.next().toLowerCase().equals("y");
        }

        System.out.println("Goodbye!");
        sc.close();
    }
}
