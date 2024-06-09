// Student name:  Daniel Trenholm
// Student number:201202966

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//************PLEASE NOTE***************
//Make sure you add the files to read to a Resources directory in your project.

public class Main {
    private static final String RELATIVE_RESOURCES = "./Resources/";

    public static void main(String[] args) throws IOException {


        boolean check = false;
        while(check == false) {
            Analysis an = new Analysis(RELATIVE_RESOURCES + "sentiments.txt"); //Loads sentiment off of analysis
            an.SumSentimentCount(); //Generate the sentiment value, the words used, and the total average sentiment


            Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Would you like to know the sentiment of another text??" + "\n" + "Y or y for yes" + "\n" + "quit to end");
            String Answer = myObj2.nextLine();  // Read user input
            if (Answer.equals("y") || Answer.equals("Y")) {
                check = false; //continues program
            }
            if (Answer.equals("quit")) { //exits the program
                check = true; //exits program
            }
        }
    }
}