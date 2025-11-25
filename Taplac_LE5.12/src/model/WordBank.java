import java.util.Random;

public class WordBank {

    private String[] words = {
            "write",
            "that",
            "java",
            "hangman",
            "computer",
            "keyboard",
            "mouse",
            "program",
            "school",
            "phone"
    };

    private Random rand = new Random();

    public String getRandomWord() {
        return words[rand.nextInt(words.length)];
    }
}
