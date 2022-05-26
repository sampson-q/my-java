package Question7;

import java.util.Scanner;

public class Question7 {
    static int add(int number1, int number2) { // declaring a static method which takes two numbers as parameter
        return (number1 + number2); // returns the additions of the two numbers
    }

    static int subtract(int number1, int number2) { return (number1 - number2); }

    static double divide(double number1, double number2) { return (number1 / number2); }

    static int multiply(int number1, int number2) { return (number1 * number2); }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // since we will have to ask the user if they'll still want to continue, we can keep the
        // whole operation in a loop. so that if the user disagrees with re-running the program, the loop is broken
        // otherwise, the loop still runs and so is our program

        // so we define our loop. here we use do-while

        do { // do all the codes in the block ...

            // for the addition part
            System.out.print("\n\nADDITION\n\tEnter number1: "); // tell the user to enter number 1
            int addition1 = userInput.nextInt(); // accept input from user. save it as addition1

            System.out.print("\tEnter number2: "); // tell the user to enter number 2
            int addition2 = userInput.nextInt(); // accept input from user. save it as addition2

            System.out.println("\tSum = " + add(addition1, addition2)); // pass both user inputs as parameters to add() method. add method returns the sum of the parameters. tell the user about the sum

            // for the subtraction part
            System.out.print("\nSUBTRACTION:\n\tEnter number1: "); // tell the user to enter number1
            int subtraction1 = userInput.nextInt(); // accept input from user. save it as subtraction1

            System.out.print("\tEnter number2: ");
            int subtraction2 = userInput.nextInt();

            System.out.println("\tSubtraction: " + subtract(subtraction1, subtraction2)); // pass both user inputs as parameters to subtract() method. this method returns the difference of both parameters. tell the user about the result


            // for the division part
            System.out.print("\nDIVISION:\n\tEnter number1: ");
            double division1 = userInput.nextDouble(); // here the data type is double because the result might be a fraction and we will want to know

            System.out.print("\tEnter number2: ");
            double division2 = userInput.nextDouble();

            System.out.println("\tDivision: " + divide(division1, division2));


            // for the multiplication part
            System.out.print("\nMULTIPLICATION:\n\tEnter number1: ");
            int multiply1 = userInput.nextInt();
            System.out.print("\tEnter number2: ");
            int multiply2 = userInput.nextInt();

            System.out.println("\tMultiplication: " + multiply(multiply1, multiply2));

            System.out.print("\nDo you want to continue?\n-> Enter [1] to quit\n-> Enter any key to continue\nEnter Choice: "); // ask the user for their choice

        } while (userInput.nextInt() != 1); // ... while the user input is not equal to one

    }
}
