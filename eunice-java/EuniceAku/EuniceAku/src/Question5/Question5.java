package Question5;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // prepare scanner to accept user input

        System.out.print("Enter number 1: "); // tell user to enter first number
        int number1 = userInput.nextInt(); // accept first input from user and store it in number1 variable

        System.out.print("Enter number 2: "); // tell user to enter second number
        int number2 = userInput.nextInt(); // accept second input from user and store it in number2 variable

        System.out.println("sum(" + number1 + ", " + number2 + "): " + (number1 + number2)); // printing the sum
        System.out.println("difference(" + number1 + ", " + number2 + "): " + (number1 - number2)); // printing the difference
        System.out.println("product(" + number1 + ", " + number2 + "): " + (number1 * number2)); // printing the product
        System.out.println("average(" + number1 + ", " + number2 + "): " + (((number1 + number2)) / 2)); // printing the average

        if (number1 > number2) {
            System.out.println("max(" + number1 + ", " + number2 + "): " + number1);
            System.out.println("min(" + number1 + ", " + number2 + "): " + number2);
        }
        else if (number1 == number2) {
            System.out.println("max(" + number1 + ", " + number2 + "): " + number1);
            System.out.println("min(" + number1 + ", " + number2 + "): " + number2);
        }
        else {
            System.out.println("max(" + number1 + ", " + number2 + "): " + number2);
            System.out.println("min(" + number1 + ", " + number2 + "): " + number1);
        }

        // time to write to a file
        try { // put this in a try and catch block
            FileWriter file = new FileWriter("Question5.txt"); // a fileWriter to create a file called "Question5.txt"
            PrintWriter printWriter = new PrintWriter(file); // printWriter to write contents to "Question5.txt"

            printWriter.println("sum(" + number1 + ", " + number2 + "): " + (number1 + number2)); // printing the sum to file
            printWriter.println("difference(" + number1 + ", " + number2 + "): " + (number1 - number2)); // printing the difference to file
            printWriter.println("product(" + number1 + ", " + number2 + "): " + (number1 * number2)); // printing the product to file
            printWriter.println("average(" + number1 + ", " + number2 + "): " + (((number1 + number2)) / 2)); // printing the average to file

            if (number1 > number2) {
                printWriter.println("max(" + number1 + ", " + number2 + "): " + number1);
                printWriter.println("min(" + number1 + ", " + number2 + "): " + number2);
            }
            else if (number1 == number2) {
                printWriter.println("max(" + number1 + ", " + number2 + "): " + number1);
                printWriter.println("min(" + number1 + ", " + number2 + "): " + number2);
            }
            else {
                printWriter.println("max(" + number1 + ", " + number2 + "): " + number2);
                printWriter.println("min(" + number1 + ", " + number2 + "): " + number1);
            }

            printWriter.close(); // closing the file

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
