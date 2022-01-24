package com.Question6;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);

        System.out.print("\nEnter Rate(%): ");
        double rate = (UserInput.nextDouble()) / 100;

        System.out.print("Enter Principal: ");
        double principal = UserInput.nextDouble();

        System.out.print("Enter Period(yrs): ");
        int years = UserInput.nextInt();

        double interest = rate * principal * years;
        System.out.println("\nSimple Interest = " + interest);
    }
}
