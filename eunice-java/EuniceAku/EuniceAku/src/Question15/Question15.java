package Question15;

import java.util.Scanner;

public class Question15 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter Height (meters): ");
        double height = userInput.nextDouble();

        System.out.println("Enter Weight (kilograms): ");
        double weight = userInput.nextDouble();

        double BMI = weight / (height * height);

        String bmiValue;
        if (BMI < 18.5)
            bmiValue = "Underweight";
        else if (BMI < 25)
            bmiValue = "Healthy Weight";
        else if (BMI < 30)
            bmiValue = "Overweight Range";
        else
            bmiValue = "Obesity Range";

        System.out.println("BMI: " + bmiValue);
    }
}
