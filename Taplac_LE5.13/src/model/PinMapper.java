package model;

import java.util.Random;

public class PinMapper {

    private int[] mapping; // index = PIN digit, value = random number 1–3
    private Random rand = new Random();

    public PinMapper() {
        mapping = new int[10];
        generateMapping();
    }

    public void generateMapping() {
        for (int i = 0; i < 10; i++) {
            mapping[i] = rand.nextInt(3) + 1;
        }
    }

    public int[] getMapping() {
        return mapping;
    }

    public void displayMapping() {
        System.out.print("PIN:  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("NUM:  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(mapping[i] + " ");
        }
        System.out.println("\n");
    }
}
