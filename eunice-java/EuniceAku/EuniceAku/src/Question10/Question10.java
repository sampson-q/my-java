package Question10;

import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = userInput.nextInt();

        // a loop to run "number" times; with decreasing "number" by 1 at each step
        for (int i = number; i != 0; -- i) { // for i = number, i != 0, decrement i
            // another loop to print 1 to "number"
            for (int j = 1; j < (i + 1); ++ j) { // for j = 1, j is less that (number + 1), increment j
                System.out.print(j); // print j
            }
            System.out.println(); // print an empty line
        }

        // a loop to run "number" times starting from 1; with increasing "number" by 1 at each step
        for (int i = 1; i < (number + 1); ++ i) { // for i = 1, i is less than (number + 1), increment i
            for (int j = 1; j < (i + 1); ++ j) { // for j = 1, j is less than (i + 1), increment j
                System.out.print(j); // print j
            }
            System.out.println(); // print an empty line
        }
    }
}
