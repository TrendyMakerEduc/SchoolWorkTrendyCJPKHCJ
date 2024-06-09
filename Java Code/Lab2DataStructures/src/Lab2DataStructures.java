//Importing required classes
import java.io.FileWriter;
import java.io.IOException;

public class Lab2DataStructures {

    int i = 0; // 1 total big Oh
    int j = 0; // 1 total big Oh

    int k = 0; // 1 total big Oh
    public static long access1DList(int n) {
        int i = 0; // 1 total big Oh
        int j = 0; // 1 total big Oh

        int k = 0; // 1 total big Oh
        long begin = System.currentTimeMillis();
        int sum = 0; //1 total big Oh
        for (i = 0; i < n; i++) { // 2n + 1
            sum++; //1 total big Oh
        }
        //The big Oh of this problem would be RunningTime = 2n + 3 }
        long end = System.currentTimeMillis();
        return end - begin;
    }
    public static long access2DList(int n) {
        int i = 0; // 1 total big Oh
        int j = 0; // 1 total big Oh

        int k = 0; // 1 total big Oh
        long begin = System.currentTimeMillis();
        int sum = 0; //1 total big Oh
        for (i = 0; i < n; i++) { //2n + 1
            for (j = 0; i < n; i++) {//2n + 1
                sum++; //1 total big Oh
                //This is where the code would be implemented for j being n,
                //which you would need to implement the variables used for a 2D
                //list, for example, n plus another parameter.
            }
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }
    // The big Oh of this problem would be RunningTime = (n**2) + 4n + 4
    //This function is useful for remaking lists and breaking up data.
    public static long MakeBig2DList(int n) {
        int i = 0; // 1 total big Oh
        int j = 0; // 1 total big Oh

        int k = 0; // 1 total big Oh
        long begin = System.currentTimeMillis();
        int sum = 0; // 1 Total big Oh
        for (i = 0; i < n; i++) { // 2n + 1
            for (j = 0; j < n * n; j++) { // (2n * n) + 1
                sum++; // 1 total big Oh
            }
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    // This problem would be RunningTime = (n**3) + 4n + 4?


    // This function would be useful going diagonally through a list, to achieve
    // maybe binary tree initization
    public static long Diagonal2DListSearch(int n) {
        int i = 0; // 1 total big Oh
        int j = 0; // 1 total big Oh

        int k = 0; // 1 total big Oh
        long begin = System.currentTimeMillis();
        int sum = 0; // 1 total big Oh
        for (i = 0; i < n; i++){ // 2n + 1
            for (j = 0; j < i; j++){ // 2n + 1
                sum++; // 1 total big Oh
            }
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    // The running time for this would be RunningTime = (n**2) + 4n + 4


    public static long Access3DElementList(int n) {
        int i = 0; // 1 total big Oh
        int j = 0; // 1 total big Oh

        int k = 0; // 1 total big Oh
        long begin = System.currentTimeMillis();
        int sum = 0; // 1 Total big Oh
        for (i = 0; i < n; i++){ // 2n + 1
            for (j = 0; j < i*i; j++){ //(n**2)  * 3n + 1
                for (k = 0; k < j; k++){ //2n + 1
                    sum++; //1 Total big Oh
                }
            }
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }
// The total Running time for this algorithm would be RunningTime = (n**5) + 7n + 5


    // This function would be useful for machines to execute a certain component in
    // a 3D list half of the time.
    public static long AIStateHalfOfTheTimeMovement(int n){
        int i = 0; // 1 total big Oh
        int j = 0; // 1 total big Oh

        int k = 0; // 1 total big Oh
        long begin = System.currentTimeMillis();
        int sum = 0; // 1 Total big Oh
        for (i = 0; i < n; i++){ // 2n + 1
            for (j = 0; j < i*i; j++){ //(n**2) * 2n + 1
                if (j % i == 0){ // Executes when j has a remainder of 0 when divided by i
                    for (k = 0; k < j; k++){ // 2n + 1
                        sum++; // 1 total Big Oh
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        return end - begin;

    }//Checking time is long end = System.currentTimeMillis(); return end - begin;
    // worst case n**5

    public static void Test(){
        String algo1 = Long.toString(access1DList(2100));
        String algo2 = Long.toString(access2DList(2100));
        String algo3 = Long.toString(MakeBig2DList(2100));
        String algo4 = Long.toString(Diagonal2DListSearch(2100));
        String algo5 = Long.toString(Access3DElementList(2100));
        String algo6 = Long.toString(AIStateHalfOfTheTimeMovement(2100));

        // Try block to check if exception occurs
        try {

            // Create a FileWriter object
            // to write in the file
            FileWriter fWriter = new FileWriter(
                    "C:\\Users\\danny\\AndroidStudioProjects\\demo.txt");

            // Writing into file
            // Note: The content taken above inside the
            // string
            fWriter.write(algo1);
            fWriter.write("\n");
            fWriter.write(algo2);
            fWriter.write("\n");
            fWriter.write(algo3);
            fWriter.write("\n");
            fWriter.write(algo4);
            fWriter.write("\n");
            fWriter.write(algo5);
            fWriter.write("\n");
            fWriter.write(algo6);
            fWriter.write("\n");

            // Closing the file writing connection
            fWriter.close();

            // Display message for successful execution of
            // program on the console
            System.out.println(
                    "File is created successfully with the content.");
        }

        // Catch block to handle if exception occurs
        catch (IOException e) {

            // Print the exception
            System.out.print(e.getMessage());
        }
    }


}

