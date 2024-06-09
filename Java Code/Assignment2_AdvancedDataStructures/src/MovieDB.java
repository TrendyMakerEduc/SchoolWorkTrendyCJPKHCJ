//Student Name: Daniel Trenholm
//Student Number: 201202966

import java.io.*;
import java.util.Scanner;

public class MovieDB {
    private static final String RELATIVE_RESOURCES = "./resources/";
    private AVLTreeE<Title> titleDB = new AVLTreeE<>();
    private AVLTreeE<Rating> ratingDB = new AVLTreeE<>();

   public double find_rating_movie(String movieName){
       File file = new File(RELATIVE_RESOURCES + "titles.csv"); //Create an instance of the file
       try{
       Scanner scanner = new Scanner(file); // Scan the file
       while(scanner.hasNextLine()){
           Title title = parseLineMovie(scanner.nextLine()); // Parse the movie line
           String s = title.getID(); //Get the title
           if(s.equals(movieName+ " ")){ // If the title equals the movie name
               System.out.println(s);
               File file1 = new File(RELATIVE_RESOURCES + "ratings.csv"); //2nd check, for the rating
               String t = title.getTitle(); //Get the ID
               try{
               Scanner scanner1 = new Scanner(file1); //Create new scanner
               scanner1.nextLine();
                   while(scanner1.hasNextLine()){
                       Rating rating = parseLineRating(scanner1.nextLine()); //Parse the rating line
                       Double r =  Double.parseDouble(rating.getID()); // Switch to double
                       String z = rating.getRating(); // Get the ID from rating
                       if(t.equals(z)){ // If previous ID matched rating ID
                           return r; // return the double

                       }
           }}catch (FileNotFoundException e){
                   e.printStackTrace();}
       }}}catch (FileNotFoundException e){
           e.printStackTrace();}
       return -1; // A check to see if the movie file does not have a rating
   }

   public MovieDB(String movieName, String ratingName){
       loadMovieFile(movieName); //Load the movie file
       loadRatingFile(ratingName); //Load the rating file
   }

    public void loadMovieFile(String movie_file_name){
        try {
            File file = new File(movie_file_name);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                titleDB.insertElement(parseLineMovie(scanner.nextLine())); // Insert elements into the AVL Tree
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void loadRatingFile(String rating_file_name) {
        try {
            File file = new File(rating_file_name);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                ratingDB.insertElement(parseLineRating(scanner.nextLine())); // Insert Ratings into the rating file
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

private Title parseLineMovie(String line){
    String copy = line;
    String[] deepcopy = copy.split("[\\s\u00A0]+"); //Split data by tab and whitespaces
    String Movie = "";
    for(int i = 0; i < deepcopy.length; i++){
        if(i == 0){
            i++; // Skip the ID
        }
        Movie += deepcopy[i] + " "; //Create the movie title
    }
    Title title = new Title(deepcopy[0], Movie); //Make the Title Object
    return title;






}

 private Rating parseLineRating(String line){
     String copy = line;
     String[] deepcopy = copy.split("[\\s\u00A0]+"); //Split by tabs and whitespaces
     Rating rating = new Rating(deepcopy[0], deepcopy[1]); //Make the rating object
     return rating;
 }


    }
