package Question19;

public class Question19 {
    // method to print the details of the students
    static void printStudentDetails(Student... students) {
        for (Student student : students) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Age: " + student.getAge());
            System.out.println("Student Address: " + student.getAddress());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Student student0 = new Student();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();

        student0.setInfo("Eunice Aku", 3);
        student1.setInfo("Martin Dukes", 554, "Northern South Sahara");
        student2.setInfo("Third Student", 50);
        student3.setInfo("Fourth Student", 32, "Pluto");

        printStudentDetails(student0, student1, student2, student3, student4);
    }
}
