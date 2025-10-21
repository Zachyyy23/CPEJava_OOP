import java.util.Random;

public class HeadsOrTails {
    private static int headsCount;
    private static int tailsCount;
    private static final int iterations = 2_000_000;

    public static void main(String[] args) {
        simulateFlips();
        showResults();
    }

    private static void simulateFlips() {
        Random random = new Random();
        headsCount = 0;
        tailsCount = 0;

        for (int i = 0; i < iterations; i++) {
            boolean result = random.nextBoolean();
            if (result) {
                headsCount++;
            } else {
                tailsCount++;
            }
        }
    }

    private static void showResults() {
        System.out.println("Heads or Tails Program");
        System.out.println("After " + iterations + " flips:");
        System.out.println("Heads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
    }
}
