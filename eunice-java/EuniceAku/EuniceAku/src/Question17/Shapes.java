package Question17;

// creating the shape's class
public class Shapes {
    // creating the first findArea method with length and width as parameters/arguments
    // it is created to return a double value
    public static double findArea(double length, double width) {
        return length * width; // multiplying the length by the width and returning it
    }

    // declaring the second findArea method/function
    public static double findArea(double radius) { // picks the radius as an argument/parameter
        return ((3.142) * (radius * radius));
    }
}
