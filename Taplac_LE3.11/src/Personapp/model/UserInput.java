package Personapp.model;

import java.util.Scanner;

public class UserInput {
    private Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    public int getInt(String prompt) {
        System.out.println(prompt);
        while(!input.hasNextInt()) {
            System.out.println("Invalid Input. Please enter a Number: ");
            input.next();
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

}
