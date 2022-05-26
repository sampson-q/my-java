package Question4;

import java.util.Scanner;

public class Question4 {
    public static boolean searchNumber(int number, int[] array) { // picks a number and an array as argument
        for (int i : array) { // for all elements in the array (represented as "i")
            if (number == i) // if the number equals i
                return true; // set the value of this method to true

            // you should know that once the number is equal to i, the method returns true. that's how conditions work
            // they are just waiting to be satisfied. once they get satisfied, no other line of code will be taken into consideration
            // means that once number is equal to i, there will be a return value then the last line "return false;" won't be run
        }

        return false; // by default, set the value of this function to false
    }

    public static void main(String[] args) {
        int[] arr = new int[5]; // declare an empty array with length of 5
        Scanner userInput = new Scanner(System.in); // scanner to help accept user's input

        // create a loop so that user can provide integers 5 times
        // we will also use the same loop to save the inputs into the array
        for (int i = 0; i < 5; ++ i) {
            System.out.print("Enter number " + (i + 1) + " of 5: "); // tell the user to enter numbers
            arr[i] = userInput.nextInt(); // array index of the current value of i should be equal to the user's input
        }

        System.out.print("\nEnter number to search: "); // tell the user to enter number to search

        if (searchNumber(userInput.nextInt(), arr)) // if true in terms of searchNumber with userInput.nextInt() and arr as parameters,
            // 404 is an error code which means "can't be found". in programming, exclamation denotes opposite. means that !true means false or !false means not false
            System.out.println("Number !404 in array");
        else
            System.out.println("Number 404 in array");
    }
}
