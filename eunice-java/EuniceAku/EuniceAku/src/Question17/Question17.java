package Question17;

// we extend this class with Shapes so that we can access the methods in the Shapes class here
public class Question17 extends Shapes {
    // creating the main method
    public static void main(String[] args) {
        // since the two "findArea" methods in the Shapes class has a return value, they are treated as variables
        // so we can actually work with them like we work with normal variables. say a = 5. we can do print(a)
        // same thing happening here
        System.out.println("The area of a circle with radius 5 = " + findArea(5)); // for the circle
        System.out.println("The area of a rectangle with length 22.3 and width 13 = " + findArea(22.3, 13)); // for the rectangle
    }
}
