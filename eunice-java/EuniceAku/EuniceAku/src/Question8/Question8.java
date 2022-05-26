package Question8;

import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        // since we are asking if the user would like to continue with our program, we run the program in a loop
        // then ask the user if they want to continue. if they disagree, we break the loop. otherwise, we keep running the program

        // we will use do-while loop because this loop runs the codes at least once before it checks for the conditions to either rerun
        // the codes or to stop

        Scanner userInput = new Scanner(System.in); // prepare scanner to accept user input

        // so we start our loop
        do {
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

            System.out.print("\nDo you want to continue?\n-> Enter [1] to quit\n-> Enter any key to continue\nEnter Choice: "); // ask the user for their choice
        } while (userInput.nextInt() != 1); // here, the program takes up a user input and checks if it's equal to one. if it's not, the loop continues. else, it breaks
    }
}
