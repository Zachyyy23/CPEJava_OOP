public class HangmanGame {

    private String word;
    private char[] hiddenWord;
    private int misses;

    public HangmanGame(String word) {
        this.word = word;
        hiddenWord = new char[word.length()];
        misses = 0;

        // Fill hiddenWord with asterisks
        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '*';
        }
    }

    public String getHiddenWord() {
        return new String(hiddenWord);
    }

    public int getMisses() {
        return misses;
    }

    // Returns:
    //  1 → correct guess
    //  0 → wrong guess
    // -1 → already guessed
    public int guessLetter(char letter) {

        boolean already = false;
        boolean correct = false;

        // Check if letter already revealed
        for (int i = 0; i < word.length(); i++) {
            if (hiddenWord[i] == letter) {
                already = true;
            }
        }

        if (already) {
            return -1; // letter already guessed
        }

        // Reveal all occurrences of this letter
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                hiddenWord[i] = letter;
                correct = true;
            }
        }

        if (!correct) {
            misses++;
            return 0;
        }

        return 1;
    }

    public boolean isWordComplete() {
        return word.equals(new String(hiddenWord));
    }

    public String getWord() {
        return word;
    }
}
