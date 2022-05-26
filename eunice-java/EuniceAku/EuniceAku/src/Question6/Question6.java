package Question6;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        // this question is normal maths
        // we have 525600 mins in the year so if we want to get the year out of the minutes, we just have to divide the minutes by 525600
        // same applies everywhere

        Scanner userInput = new Scanner(System.in); // preparing scanner for user input
        System.out.print("\nEnter minutes: ");
        int minutes = userInput.nextInt();

        int years = minutes / 525600;
        int months = minutes / 43800;
        int days = minutes / 1440;
        int hours = minutes / 60;

        System.out.println(minutes + " minutes is approximately " + years + " years, " + months + " months, " + days + " days, " + hours + " hours");
    }
}
