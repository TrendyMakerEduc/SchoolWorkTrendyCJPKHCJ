//Student Name: Daniel Trenholm
//Student Number: 201202966

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner readCSVFileLocation = new Scanner(System.in); // Be sure to give the full path to the console.
        System.out.println("Please select your two movie database files with an exact path location. Be sure to use the" + "\n" + "movie file name location first, and the ratings file second" + "\n" + "Copy and paste the addresses from your explorer");
        String[] files = readCSVFileLocation.nextLine().split("[\\s\u00A0]+");
        MovieDB load = new MovieDB(files[0], files[1]); //Create the Movie DataBase
        boolean check = false; // Useful for the loop
        while(check != true) { // While false
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter a movie name...");
            String Movie = myObj.nextLine();  // Read user input
            Double d = (load.find_rating_movie(Movie));
            if(d == -1){
                System.out.println("Sorry, there is no currently updated rating for this movie!");
            } else{
                System.out.println(d);
            }
            Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Would you like to know another movie rating?" + "\n" + "Y or y for yes" + "\n" + "quit to end");
            String Answer = myObj2.nextLine();  // Read user input
            if(Answer.equals("y") || Answer.equals("Y")){
                check = false;
            }
            if(Answer.equals("quit")){ //exits the program
                check = true;
            }
        }


    }}