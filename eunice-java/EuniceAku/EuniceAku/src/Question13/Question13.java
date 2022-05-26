package Question13;

import java.util.Scanner;

public class Question13 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter Side A: ");
        double sideA = userInput.nextDouble();

        System.out.print("Enter Side B: ");
        double sideB = userInput.nextDouble();

        System.out.print("Enter Side C: ");
        double sideC = userInput.nextDouble();

        TriangleClass triangleClass = new TriangleClass(sideA, sideB, sideC);

        double perimeter = triangleClass.sideA + triangleClass.sideB + triangleClass.sideC;
        System.out.println("\nPerimeter: " + perimeter);

        double s = perimeter / 2;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

        System.out.println("Area: " + area);
    }
}
