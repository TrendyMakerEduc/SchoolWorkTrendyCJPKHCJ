// Student name:  Daniel Trenholm
// Student number:201202966

//************PLEASE NOTE***************
//Make sure you add the files to read to a Resources directory in your project.

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Analysis {
    public String fileName; //Filename of sentiments
    private Sentiment sentiment = new Sentiment(); //Hash table creation
    private static final String RELATIVE_RESOURCES = "./Resources/"; //Relative resources load


    private File file; //A file created off of filename
    public Analysis(String fileName){
        this.fileName = fileName; //Set the filename path
        file = new File(fileName); //The file gets updated
    }

    public void SentimentIntoHashTable() throws FileNotFoundException {
        Scanner readCSVFileLocation = new Scanner(file); // Be sure to give the full path to the console.


        while(readCSVFileLocation.hasNextLine()){
           String[] s =  getLineInfo(readCSVFileLocation.nextLine()); //Get the line, split in two, and go to the next line
           String word = s[0]; //The key
           String score = s[1]; //The value
           sentiment.put(word, score); //Key value generation
    }
    }

    public int SumSentimentCount() throws IOException {
        SentimentIntoHashTable(); //This function creates the hash table of words and their sentiments
        int a = getTextInput(); // The actual input to grab the index of the text.
        String[] text = getText(RELATIVE_RESOURCES + "Reviews.csv", a ).split("[\\s\u00A0]+"); //Array created to seperate words
        System.out.println(Arrays.toString(text) + "\n"); //prints the sentence used.
        int count = 0; //a count used to total the sentiment value
        String realText = ""; // This is the text generated that shows the words with their sentiment values used
        for(int i = 0; i < text.length; i++){
            if(sentiment.get(text[i]) != null) {
                String s = sentiment.get(text[i]).toString(); //gets value
                int score = parseInt(s); //parse value to int
                count += score; // the new sentiment value is set
                realText += text[i] + " "; // The next word is gathered
            }

        }

        System.out.println(realText + "\n"); //prints the words that were used
        double d = ((double) count) / text.length; //gather a percentage
        System.out.println(String.format("The total sentiment score is: %d .... The Total average of sentiment with words is: %.5f percent", count, d * 100));
        return count;

    }

    public int getTextInput(){
        Scanner scan = new Scanner(System.in); //Get input
        System.out.println("Please input a text you would like to view, using a number between 0 - 4999. (Chooses a text to analyze based on line)"); //Could not figure out why it only went through half the list
        int a = scan.nextInt(); //gather an int to use for indexing
        return a; //return the index
    }
    public String getText(String line, int index) throws IOException {
        InputStream ips = new FileInputStream(line); //Create FileInputStream
        InputStreamReader ipsr = new InputStreamReader(ips); //Create InputStreamReader
        BufferedReader br = new BufferedReader(ipsr); //Create buffered reader
        int i = 0; // i starts at 0
        String s = br.readLine(); //Set the variable, so It does not double read the line
        while (s != null) {
            s = br.readLine(); //Read the next line
            if(i == index){ //If the index is reached
                return s; //Return the string
            }
            i++; //else, i increments, and loop continues

        }
        return null; //If nothing , return null

    }









  public String[] getLineInfo(String line){
      String copy = line; //Get line
      String[] newCopy = copy.split(","); //Split the line into two pieces
      return newCopy; //Return for use in hash table
  }



}
