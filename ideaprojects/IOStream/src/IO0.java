import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IO0 {
    public static void main(String[] args) {
        try {
            // create a file write
            FileWriter ourReceipt = new FileWriter("C:\\Users\\Hash\\Desktop\\FirstFile.txt");

            // create a print write
            PrintWriter  printWriter = new PrintWriter(ourReceipt);

            // print something to the file
            printWriter.println("This is our first print out to a file!");
            printWriter.println("Another thing to be written");
            printWriter.print("Assuming I have another thing!\t");
            printWriter.print("I have seen the error!");

            // close the file writer
            //printWriter.close();

        } catch (IOException e) { // catch any IOException
            e.printStackTrace(); // handle the exception
        }

        // reading from a file
        try {
            FileReader
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
