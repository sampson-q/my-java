package Question3;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question3 {
    // we create a method to help us calculate the sum of digits of the inputs
    static int digitsSum(int digit) { // method return an integer input
        if (digit == 0) // if the "digit" parameter or argument is 0,
            return 0; // return 0

        return (digit % 10) + digitsSum(digit / 10);// by default, return the (digit mod 10) + (the return value of digitSum of digit divided by 10)
    }

    // main function throws Exception because of the creation and writing to file
    public static void main(String[] args) throws Exception {
        // preparing scanner for user input
        Scanner userInput = new Scanner(System.in);

        // create a FileWriter object to handle the creation of our file
        FileWriter file = new FileWriter("Question3.txt");
        // create a PrintWriter object to handle writing to our file
        PrintWriter printWriter = new PrintWriter(file);

        // introducing a counter by which our program will run
        int counter = 0;

        // since the user is allowed to repeat this operation 5 time, we loop the whole operation to run 5 times
        while (counter != 5) { // while counter is not equal to 5
            System.out.print("Enter number: "); // ask the user for their input

            if (userInput.hasNextInt()) { // if the input is an integer,
                int digit = userInput.nextInt(); // store the input into "digit" variable
                printWriter.println(digit + "\t\t" + digitsSum(digit)); // printWriter to write the digit and the sum of its digits to our file
                ++ counter; // increment counter so that counter will get a chance of reaching 5. so that our program can terminate after
            }

            else // else if user's input is not an integer
                System.out.println(userInput.next() + " is invalid input\n"); // tell the user the input is invalid

            if (counter == 5) // if counter is 5 (which means our program has finish executing)
                printWriter.close(); // printWriter to close the file... this is important otherwise you won't have anything in your file
        }
    }
}
