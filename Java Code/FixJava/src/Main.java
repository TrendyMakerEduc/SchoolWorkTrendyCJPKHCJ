public class Main {

    //Here, we instantiate two of FixJava class, to check for indentation and brace errors. I have BadJavaClass
    //which contains misaligned Braces and Block Indentation issues, while Good Java Class has no errors, based
    //on the convention that each block of code has 4 spaces, and braces align at the same space in the code
    public static void main(String[] args) {
        FixJava badJavaFix = new FixJava("src/BadJavaClass.java"); //Grabs the filePath
        System.out.println("Bad Java Class"); //Label for Bad Java Class
        badJavaFix.checkForErrors(); //Checks errors in BadJavaCLass.java
        FixJava goodJavaFix = new FixJava("src/GoodJavaClass.java"); //Grabs the filePath of the Good Class
        System.out.println("Good Java Class"); //Label for Good Java Class
        goodJavaFix.checkForErrors(); //Checks errors in GoodJavaClass.java
    }
}