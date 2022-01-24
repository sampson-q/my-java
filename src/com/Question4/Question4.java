package com.Question4;

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int UserNumber = UserInput.nextInt();

        System.out.print(UserNumber > 1 && UserNumber < 100);
    }
}
