package Question9;

import java.util.Random;
import java.util.Scanner;

// we create the student class
public class Student {
    // we create the properties required in the question
    private int indexNumber;
    private String fullName;
    private String studentDepartment;
    private int gpa;

    // next, we create setters and getters that help us to set the properties of the Student class
    // at the moment, the properties are not set. they were just declared. if you want to set a variable, we use the = sign
    // for example we want to set the fullName; it will be fullName = "Sampson James". so setters help us to set the values for the variables
    // and getters help us to get the values that we set to the variables


    public int getIndexNumber() { // this is a getter method
        return indexNumber; // it returns the indexNumber
    }

    public void setIndexNumber(int indexNumber) { // this is a setter method. it takes an int parameter and sets it as the index number
        this.indexNumber = indexNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) { // this is a setter method. it takes an integer parameter and sets it as the gpa
        this.gpa = gpa;
    }

    public void register() { // method to help us register the student
        // accepting strings with scanner misbehaves sometimes. so we declare a different scanner for strings and another for integers
        Scanner scString = new Scanner(System.in); // string scanner for accepting string inputs
        Scanner scInt = new Scanner(System.in); // int scanner for accepting int inputs. you should know that this scanner can also be used to accept string.
        // we are the ones deciding to use it only for ints. doesn't mean it can't be used for strings

        System.out.print("===REGISTER STUDENT===\nEnter Index Number: ");
        setIndexNumber(scInt.nextInt()); // here we call the setIndexNumber method and pass the user input to it so that the method sets the user input as the index number

        System.out.print("Enter Full Name: ");
        setFullName(scString.nextLine());

        System.out.print("Enter Department: ");
        setStudentDepartment(scString.nextLine());

        setGpa(new Random().nextInt(1, 4));
        // with the above line of code, it contains an object of the "Random" class with the "nextInt" method
        // it could have been:
        // Random random = new Random();
        // int randomNumber = random.nextInt(1, 4);
        // setGpa(randomNumber); But for simplicity’s sake, I created the object without putting it in a variable before passing it as a parameter to the setGpa method
    }

    public void graduate() { // method to help us print out the details of the students
        System.out.println("\n\n===GRADUATE STUDENT===\nIndex Number: " + getIndexNumber());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Department: " + getStudentDepartment());

        System.out.println("GPA: " + getGpa());
    }
}
