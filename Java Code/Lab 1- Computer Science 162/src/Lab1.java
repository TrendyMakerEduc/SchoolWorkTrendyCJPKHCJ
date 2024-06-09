// Outside class definition
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;


public class Lab1 {
    public static void main(String[] args){
        //print Line
        //System.out.println("Hello World!");


        // This is how to read input from the stream
// Create a Stream Reader with the standard input
        //InputStreamReader stream = new InputStreamReader(System.in);

// Give the Stream Reader to a Buffered Reader
        //BufferedReader reader = new BufferedReader(stream);

// We use the Buffered Reader to read the actual stream
// We use a try & catch because readLine may throw an
// exception that we must deal with
        //try {
          //  String theLine = reader.readLine();
          //  System.out.println(theLine);
        //} catch (IOException e){
          //  System.out.println("Something bad happened.");
        //}

        // End of reading input directly from code.

        //User input using the scanner class

        //Scanner myInput = new Scanner(System.in); // Create the Scanner
        //System.out.println("What is your username"); // Print out what is the username

        //String username = myInput.nextLine(); // Reads the input given
        //System.out.println("My username is : " + username);





        //Custom input that will take in two integers and sum them together
        //InputStreamReader stream = new InputStreamReader(System.in);
        //BufferedReader reader = new BufferedReader(stream);


        //Scanner myTwoIntegers = new Scanner(System.in); // Create the Scanner
        //System.out.println("What are your two integers? (Please put a space between the numbers)");
        //try{
        //    String theLine = reader.readLine();
        //    String[] TwoIntsSplit = theLine.split(" ");
        //    int data1 = Integer.parseInt(TwoIntsSplit[0]);
        //    int data2 = Integer.parseInt(TwoIntsSplit[1]);
        //    System.out.println("The sum is: " + (data1 + data2));
        //} catch(IOException e){
        //    System.out.println("That is not a number. Please try again.");
        //}



    }
}
