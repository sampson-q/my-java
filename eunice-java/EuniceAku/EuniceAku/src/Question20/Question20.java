package Question20;

import java.util.Scanner;

public class Question20 {
    public static void main(String[] args) {
        int[] arr = new int[10]; // preparing an empty array of size 10
        Scanner userInput = new Scanner(System.in);

        // preparing variables which will hold count of number of positive numbers, etc
        int numberOfPositiveNumbers = 0, numberOfNegativeNumbers = 0, numberOfOddNumbers = 0, numberOfEvenNumbers = 0, sumOfOddNumbers = 0, sumOfEvenNumbers = 0;

        // loop for collecting the 10 numbers
        for (int i = 0; i < 10; ++ i) {
            System.out.print("Enter number " + (i + 1) + " of 10: ");
            int number = userInput.nextInt();

            if (number >= 0)
                ++ numberOfPositiveNumbers;
            else
                ++ numberOfNegativeNumbers;

            if (number % 2 == 0)
                ++ numberOfEvenNumbers;
            else
                ++ numberOfOddNumbers;

            arr[i] = number;
        }

        System.out.println("\nPositive Numbers: " + numberOfPositiveNumbers);
        System.out.println("Negative Numbers: " + numberOfNegativeNumbers);

        System.out.println("Odd Numbers: " + numberOfOddNumbers);
        System.out.println("Even Numbers: " + numberOfEvenNumbers);

        for (int i : arr) {
            if (i % 2 == 0)
                sumOfEvenNumbers += i;
            else
                sumOfOddNumbers += i;
        }

        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbers);
        System.out.println("Sum of Odd  Numbers: " + sumOfOddNumbers);
    }
}
