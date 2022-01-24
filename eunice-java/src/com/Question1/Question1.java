// Author: Hash
package com.Question1;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in); // we use scanner to accept user input

        System.out.print("Enter number: "); // tell the user to enter number
        int number = UserInput.nextInt(); // accept what ever the user provides and save it in "number"

        // we loop numbers from 1 to 12 and multiply each of them to the given number
        for (int i = 1; i < 13; ++i) {
            System.out.println(number + " x " + i + "\t= " + (number * i));
        }

    }
}
