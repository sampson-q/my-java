package Question2;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in); // preparing scanner for user input

        System.out.print("Enter loan amount: $"); // telling the user to enter the amount

        double loanAmount = userInput.nextDouble(); // accepting user input into "loanAmount" variable

        System.out.println("Loan amount in 6 months = " + ((0.1 * loanAmount) * 6)); // calculating and printing the results to the user


    }
}
